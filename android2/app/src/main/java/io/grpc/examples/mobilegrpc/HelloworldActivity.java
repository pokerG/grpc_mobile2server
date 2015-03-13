package io.grpc.examples.mobilegrpc;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.RadioGroup;
import android.widget.RadioButton;

import java.util.concurrent.TimeUnit;
import java.util.Iterator;

import io.grpc.ChannelImpl;
import io.grpc.stub.StreamObserver;
// import io.grpc.examples.mobilegrpc.Mobile2Server.Reply;
import io.grpc.examples.mobilegrpc.Mobile2Server.*;
import io.grpc.transport.okhttp.OkHttpChannelBuilder;
import com.google.common.util.concurrent.SettableFuture;

public class HelloworldActivity extends ActionBarActivity {
    private Button mSendButton;
    private EditText mHostEdit;
    private EditText mPortEdit;
    private EditText mMessageEdit;
    private TextView mResultText;
    private  RadioGroup  mRadioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helloworld);
        mSendButton = (Button) findViewById(R.id.send_button);
        mHostEdit = (EditText) findViewById(R.id.host_edit_text);
        mPortEdit = (EditText) findViewById(R.id.port_edit_text);
        mMessageEdit = (EditText) findViewById(R.id.message_edit_text);
        mResultText = (TextView) findViewById(R.id.grpc_response_text);
        mRadioGroup = (RadioGroup)findViewById(R.id.rg);
    }

    public void sendMessage(View view) {
        ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(mHostEdit.getWindowToken(), 0);
        mSendButton.setEnabled(false);
        new GrpcTask().execute();
    }

    private class GrpcTask extends AsyncTask<Void, Void, String> {
        private String mHost;
        private String mMessage;
        private int mPort;
        private ChannelImpl mChannel;
        private int style;
        private String re;
        @Override
        protected void onPreExecute() {
            mHost = mHostEdit.getText().toString();
            mMessage = mMessageEdit.getText().toString();
            String portStr = mPortEdit.getText().toString();
            mPort = TextUtils.isEmpty(portStr) ? 0 : Integer.valueOf(portStr);
            for(int i = 0;i < mRadioGroup.getChildCount();i++){
                RadioButton rd = (RadioButton)mRadioGroup.getChildAt(i);
                if(rd.isChecked()){
                    style = i + 1;
                    break;
                }
            }  
            mResultText.setText("");
        }

        private String sayHello(ChannelImpl channel) {
            greeterGrpc.greeterBlockingStub stub = greeterGrpc.newBlockingStub(channel);
            Request message = new Request();
            message.value = mMessage;
            Reply reply = stub.sayHello(message);
            return reply.value;
        }

        private String Spliti(ChannelImpl channel){
            greeterGrpc.greeterBlockingStub stub = greeterGrpc.newBlockingStub(channel);
            Request message = new Request();
            message.value = mMessage;
            re = "";
            Iterator<sReply> replys = stub.forwarding(message);
            while(replys.hasNext()){
                sReply reply = replys.next();
                re += reply.id + ":" + reply.value + "\n";
            }
            return re;
        }
        private String Cat(ChannelImpl channel)throws Exception{
            greeterGrpc.greeterStub stub = greeterGrpc.newStub(channel);
            final SettableFuture<Void> finsishFuture = SettableFuture.create();
            re = "";
            StreamObserver<Reply> replyObserver = new StreamObserver<Reply>(){
                @Override
                public void onValue(Reply reply){
                    re += reply.value;
                }
                @Override
                public void onError(Throwable t){
                    finsishFuture.setException(t);
                }
                @Override
                public void onCompleted(){
                    finsishFuture.set(null);
                }
            };
            StreamObserver<sRequest> requestObserver = stub.cat(replyObserver);
            try{
                
                String[] msgs = mMessage.split(";");
                int i = 0;
                for(String x: msgs){
                    sRequest request = new sRequest();
                    request.id = i++;
                    request.value = x;
                    requestObserver.onValue(request);
                    if(finsishFuture.isDone()){
                        break;
                    } 
                }
                requestObserver.onCompleted();
                finsishFuture.get();
                return re;    
            }catch(Exception e){
                requestObserver.onError(e);
                throw e;
            }
            
        }
        private String Transmit(ChannelImpl channel) throws Exception{
            greeterGrpc.greeterStub stub = greeterGrpc.newStub(channel);
            re = "";
            final SettableFuture<Void> finsishFuture = SettableFuture.create();
            StreamObserver<sRequest> requestObserver = stub.transmit(new StreamObserver<sReply>(){
                @Override
                public void onValue(sReply reply){
                    re += reply.id + ":" + reply.value + "\n";
                }
                @Override
                public void onError(Throwable t){
                    finsishFuture.setException(t);
                }
                @Override
                public void onCompleted(){
                    finsishFuture.set(null);
                }
            });
            try{
                int i = 0;
                String[] msgs = mMessage.split(";");
                for(String x: msgs){
                    sRequest request = new sRequest();
                    request.id = i++;
                    request.value = x;
                    requestObserver.onValue(request);
                    if(finsishFuture.isDone()){
                        break;
                    } 
                }
                requestObserver.onCompleted();
                finsishFuture.get();
                return re;
            }catch(Exception t){
                requestObserver.onError(t);
                throw t;
            }
            
            
        }

        @Override
        protected String doInBackground(Void... nothing) {
            try {
                mChannel = OkHttpChannelBuilder.forAddress(mHost, mPort).build();
                return Spliti(mChannel);
            } catch (Exception e) {
                return "Failed... : " + e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            try {
                mChannel.shutdown().awaitTerminated(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            mResultText.setText(result);
            mSendButton.setEnabled(true);
        }
    }
}
