package io.grpc.examples.mobilegrpc;

import static io.grpc.stub.Calls.createMethodDescriptor;
import static io.grpc.stub.Calls.asyncUnaryCall;
import static io.grpc.stub.Calls.asyncServerStreamingCall;
import static io.grpc.stub.Calls.asyncClientStreamingCall;
import static io.grpc.stub.Calls.duplexStreamingCall;
import static io.grpc.stub.Calls.blockingUnaryCall;
import static io.grpc.stub.Calls.blockingServerStreamingCall;
import static io.grpc.stub.Calls.unaryFutureCall;
import static io.grpc.stub.ServerCalls.createMethodDefinition;
import static io.grpc.stub.ServerCalls.asyncUnaryRequestCall;
import static io.grpc.stub.ServerCalls.asyncStreamingRequestCall;

import java.io.IOException;


public class greeterGrpc {

  private static final io.grpc.stub.Method<io.grpc.examples.mobilegrpc.Mobile2Server.Request,
      io.grpc.examples.mobilegrpc.Mobile2Server.Reply> METHOD_SAY_HELLO =
      io.grpc.stub.Method.create(
          io.grpc.MethodType.UNARY, "SayHello",
          io.grpc.nano.NanoUtils.<io.grpc.examples.mobilegrpc.Mobile2Server.Request>marshaller(
              new io.grpc.nano.Parser<io.grpc.examples.mobilegrpc.Mobile2Server.Request>() {
                  @Override
                  public io.grpc.examples.mobilegrpc.Mobile2Server.Request parse(com.google.protobuf.nano.CodedInputByteBufferNano input) throws IOException {
                      return io.grpc.examples.mobilegrpc.Mobile2Server.Request.parseFrom(input);
                  }
          }),
          io.grpc.nano.NanoUtils.<io.grpc.examples.mobilegrpc.Mobile2Server.Reply>marshaller(
              new io.grpc.nano.Parser<io.grpc.examples.mobilegrpc.Mobile2Server.Reply>() {
                  @Override
                  public io.grpc.examples.mobilegrpc.Mobile2Server.Reply parse(com.google.protobuf.nano.CodedInputByteBufferNano input) throws IOException {
                      return io.grpc.examples.mobilegrpc.Mobile2Server.Reply.parseFrom(input);
                  }
          }));
  private static final io.grpc.stub.Method<io.grpc.examples.mobilegrpc.Mobile2Server.Request,
      io.grpc.examples.mobilegrpc.Mobile2Server.sReply> METHOD_SPLITI =
      io.grpc.stub.Method.create(
          io.grpc.MethodType.SERVER_STREAMING, "Spliti",
          io.grpc.nano.NanoUtils.<io.grpc.examples.mobilegrpc.Mobile2Server.Request>marshaller(
              new io.grpc.nano.Parser<io.grpc.examples.mobilegrpc.Mobile2Server.Request>() {
                  @Override
                  public io.grpc.examples.mobilegrpc.Mobile2Server.Request parse(com.google.protobuf.nano.CodedInputByteBufferNano input) throws IOException {
                      return io.grpc.examples.mobilegrpc.Mobile2Server.Request.parseFrom(input);
                  }
          }),
          io.grpc.nano.NanoUtils.<io.grpc.examples.mobilegrpc.Mobile2Server.sReply>marshaller(
              new io.grpc.nano.Parser<io.grpc.examples.mobilegrpc.Mobile2Server.sReply>() {
                  @Override
                  public io.grpc.examples.mobilegrpc.Mobile2Server.sReply parse(com.google.protobuf.nano.CodedInputByteBufferNano input) throws IOException {
                      return io.grpc.examples.mobilegrpc.Mobile2Server.sReply.parseFrom(input);
                  }
          }));
  private static final io.grpc.stub.Method<io.grpc.examples.mobilegrpc.Mobile2Server.sRequest,
      io.grpc.examples.mobilegrpc.Mobile2Server.Reply> METHOD_CAT =
      io.grpc.stub.Method.create(
          io.grpc.MethodType.CLIENT_STREAMING, "Cat",
          io.grpc.nano.NanoUtils.<io.grpc.examples.mobilegrpc.Mobile2Server.sRequest>marshaller(
              new io.grpc.nano.Parser<io.grpc.examples.mobilegrpc.Mobile2Server.sRequest>() {
                  @Override
                  public io.grpc.examples.mobilegrpc.Mobile2Server.sRequest parse(com.google.protobuf.nano.CodedInputByteBufferNano input) throws IOException {
                      return io.grpc.examples.mobilegrpc.Mobile2Server.sRequest.parseFrom(input);
                  }
          }),
          io.grpc.nano.NanoUtils.<io.grpc.examples.mobilegrpc.Mobile2Server.Reply>marshaller(
              new io.grpc.nano.Parser<io.grpc.examples.mobilegrpc.Mobile2Server.Reply>() {
                  @Override
                  public io.grpc.examples.mobilegrpc.Mobile2Server.Reply parse(com.google.protobuf.nano.CodedInputByteBufferNano input) throws IOException {
                      return io.grpc.examples.mobilegrpc.Mobile2Server.Reply.parseFrom(input);
                  }
          }));
  private static final io.grpc.stub.Method<io.grpc.examples.mobilegrpc.Mobile2Server.sRequest,
      io.grpc.examples.mobilegrpc.Mobile2Server.sReply> METHOD_TRANSMIT =
      io.grpc.stub.Method.create(
          io.grpc.MethodType.DUPLEX_STREAMING, "Transmit",
          io.grpc.nano.NanoUtils.<io.grpc.examples.mobilegrpc.Mobile2Server.sRequest>marshaller(
              new io.grpc.nano.Parser<io.grpc.examples.mobilegrpc.Mobile2Server.sRequest>() {
                  @Override
                  public io.grpc.examples.mobilegrpc.Mobile2Server.sRequest parse(com.google.protobuf.nano.CodedInputByteBufferNano input) throws IOException {
                      return io.grpc.examples.mobilegrpc.Mobile2Server.sRequest.parseFrom(input);
                  }
          }),
          io.grpc.nano.NanoUtils.<io.grpc.examples.mobilegrpc.Mobile2Server.sReply>marshaller(
              new io.grpc.nano.Parser<io.grpc.examples.mobilegrpc.Mobile2Server.sReply>() {
                  @Override
                  public io.grpc.examples.mobilegrpc.Mobile2Server.sReply parse(com.google.protobuf.nano.CodedInputByteBufferNano input) throws IOException {
                      return io.grpc.examples.mobilegrpc.Mobile2Server.sReply.parseFrom(input);
                  }
          }));
  private static final io.grpc.stub.Method<io.grpc.examples.mobilegrpc.Mobile2Server.Request,
      io.grpc.examples.mobilegrpc.Mobile2Server.sReply> METHOD_FORWARDING =
      io.grpc.stub.Method.create(
          io.grpc.MethodType.SERVER_STREAMING, "Forwarding",
          io.grpc.nano.NanoUtils.<io.grpc.examples.mobilegrpc.Mobile2Server.Request>marshaller(
              new io.grpc.nano.Parser<io.grpc.examples.mobilegrpc.Mobile2Server.Request>() {
                  @Override
                  public io.grpc.examples.mobilegrpc.Mobile2Server.Request parse(com.google.protobuf.nano.CodedInputByteBufferNano input) throws IOException {
                      return io.grpc.examples.mobilegrpc.Mobile2Server.Request.parseFrom(input);
                  }
          }),
          io.grpc.nano.NanoUtils.<io.grpc.examples.mobilegrpc.Mobile2Server.sReply>marshaller(
              new io.grpc.nano.Parser<io.grpc.examples.mobilegrpc.Mobile2Server.sReply>() {
                  @Override
                  public io.grpc.examples.mobilegrpc.Mobile2Server.sReply parse(com.google.protobuf.nano.CodedInputByteBufferNano input) throws IOException {
                      return io.grpc.examples.mobilegrpc.Mobile2Server.sReply.parseFrom(input);
                  }
          }));

  public static greeterStub newStub(io.grpc.Channel channel) {
    return new greeterStub(channel, CONFIG);
  }

  public static greeterBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new greeterBlockingStub(channel, CONFIG);
  }

  public static greeterFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new greeterFutureStub(channel, CONFIG);
  }

  public static final greeterServiceDescriptor CONFIG =
      new greeterServiceDescriptor();

  @javax.annotation.concurrent.Immutable
  public static class greeterServiceDescriptor extends
      io.grpc.stub.AbstractServiceDescriptor<greeterServiceDescriptor> {
    public final io.grpc.MethodDescriptor<io.grpc.examples.mobilegrpc.Mobile2Server.Request,
        io.grpc.examples.mobilegrpc.Mobile2Server.Reply> sayHello;
    public final io.grpc.MethodDescriptor<io.grpc.examples.mobilegrpc.Mobile2Server.Request,
        io.grpc.examples.mobilegrpc.Mobile2Server.sReply> spliti;
    public final io.grpc.MethodDescriptor<io.grpc.examples.mobilegrpc.Mobile2Server.sRequest,
        io.grpc.examples.mobilegrpc.Mobile2Server.Reply> cat;
    public final io.grpc.MethodDescriptor<io.grpc.examples.mobilegrpc.Mobile2Server.sRequest,
        io.grpc.examples.mobilegrpc.Mobile2Server.sReply> transmit;
    public final io.grpc.MethodDescriptor<io.grpc.examples.mobilegrpc.Mobile2Server.Request,
        io.grpc.examples.mobilegrpc.Mobile2Server.sReply> forwarding;

    private greeterServiceDescriptor() {
      sayHello = createMethodDescriptor(
          "mobile2server.greeter", METHOD_SAY_HELLO);
      spliti = createMethodDescriptor(
          "mobile2server.greeter", METHOD_SPLITI);
      cat = createMethodDescriptor(
          "mobile2server.greeter", METHOD_CAT);
      transmit = createMethodDescriptor(
          "mobile2server.greeter", METHOD_TRANSMIT);
      forwarding = createMethodDescriptor(
          "mobile2server.greeter", METHOD_FORWARDING);
    }

    @SuppressWarnings("unchecked")
    private greeterServiceDescriptor(
        java.util.Map<java.lang.String, io.grpc.MethodDescriptor<?, ?>> methodMap) {
      sayHello = (io.grpc.MethodDescriptor<io.grpc.examples.mobilegrpc.Mobile2Server.Request,
          io.grpc.examples.mobilegrpc.Mobile2Server.Reply>) methodMap.get(
          CONFIG.sayHello.getName());
      spliti = (io.grpc.MethodDescriptor<io.grpc.examples.mobilegrpc.Mobile2Server.Request,
          io.grpc.examples.mobilegrpc.Mobile2Server.sReply>) methodMap.get(
          CONFIG.spliti.getName());
      cat = (io.grpc.MethodDescriptor<io.grpc.examples.mobilegrpc.Mobile2Server.sRequest,
          io.grpc.examples.mobilegrpc.Mobile2Server.Reply>) methodMap.get(
          CONFIG.cat.getName());
      transmit = (io.grpc.MethodDescriptor<io.grpc.examples.mobilegrpc.Mobile2Server.sRequest,
          io.grpc.examples.mobilegrpc.Mobile2Server.sReply>) methodMap.get(
          CONFIG.transmit.getName());
      forwarding = (io.grpc.MethodDescriptor<io.grpc.examples.mobilegrpc.Mobile2Server.Request,
          io.grpc.examples.mobilegrpc.Mobile2Server.sReply>) methodMap.get(
          CONFIG.forwarding.getName());
    }

    @java.lang.Override
    protected greeterServiceDescriptor build(
        java.util.Map<java.lang.String, io.grpc.MethodDescriptor<?, ?>> methodMap) {
      return new greeterServiceDescriptor(methodMap);
    }

    @java.lang.Override
    public com.google.common.collect.ImmutableList<io.grpc.MethodDescriptor<?, ?>> methods() {
      return com.google.common.collect.ImmutableList.<io.grpc.MethodDescriptor<?, ?>>of(
          sayHello,
          spliti,
          cat,
          transmit,
          forwarding);
    }
  }

  public static interface greeter {

    public void sayHello(io.grpc.examples.mobilegrpc.Mobile2Server.Request request,
        io.grpc.stub.StreamObserver<io.grpc.examples.mobilegrpc.Mobile2Server.Reply> responseObserver);

    public void spliti(io.grpc.examples.mobilegrpc.Mobile2Server.Request request,
        io.grpc.stub.StreamObserver<io.grpc.examples.mobilegrpc.Mobile2Server.sReply> responseObserver);

    public io.grpc.stub.StreamObserver<io.grpc.examples.mobilegrpc.Mobile2Server.sRequest> cat(
        io.grpc.stub.StreamObserver<io.grpc.examples.mobilegrpc.Mobile2Server.Reply> responseObserver);

    public io.grpc.stub.StreamObserver<io.grpc.examples.mobilegrpc.Mobile2Server.sRequest> transmit(
        io.grpc.stub.StreamObserver<io.grpc.examples.mobilegrpc.Mobile2Server.sReply> responseObserver);

    public void forwarding(io.grpc.examples.mobilegrpc.Mobile2Server.Request request,
        io.grpc.stub.StreamObserver<io.grpc.examples.mobilegrpc.Mobile2Server.sReply> responseObserver);
  }

  public static interface greeterBlockingClient {

    public io.grpc.examples.mobilegrpc.Mobile2Server.Reply sayHello(io.grpc.examples.mobilegrpc.Mobile2Server.Request request);

    public java.util.Iterator<io.grpc.examples.mobilegrpc.Mobile2Server.sReply> spliti(
        io.grpc.examples.mobilegrpc.Mobile2Server.Request request);

    public java.util.Iterator<io.grpc.examples.mobilegrpc.Mobile2Server.sReply> forwarding(
        io.grpc.examples.mobilegrpc.Mobile2Server.Request request);
  }

  public static interface greeterFutureClient {

    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.mobilegrpc.Mobile2Server.Reply> sayHello(
        io.grpc.examples.mobilegrpc.Mobile2Server.Request request);
  }

  public static class greeterStub extends
      io.grpc.stub.AbstractStub<greeterStub, greeterServiceDescriptor>
      implements greeter {
    private greeterStub(io.grpc.Channel channel,
        greeterServiceDescriptor config) {
      super(channel, config);
    }

    @java.lang.Override
    protected greeterStub build(io.grpc.Channel channel,
        greeterServiceDescriptor config) {
      return new greeterStub(channel, config);
    }

    @java.lang.Override
    public void sayHello(io.grpc.examples.mobilegrpc.Mobile2Server.Request request,
        io.grpc.stub.StreamObserver<io.grpc.examples.mobilegrpc.Mobile2Server.Reply> responseObserver) {
      asyncUnaryCall(
          channel.newCall(config.sayHello), request, responseObserver);
    }

    @java.lang.Override
    public void spliti(io.grpc.examples.mobilegrpc.Mobile2Server.Request request,
        io.grpc.stub.StreamObserver<io.grpc.examples.mobilegrpc.Mobile2Server.sReply> responseObserver) {
      asyncServerStreamingCall(
          channel.newCall(config.spliti), request, responseObserver);
    }

    @java.lang.Override
    public io.grpc.stub.StreamObserver<io.grpc.examples.mobilegrpc.Mobile2Server.sRequest> cat(
        io.grpc.stub.StreamObserver<io.grpc.examples.mobilegrpc.Mobile2Server.Reply> responseObserver) {
      return asyncClientStreamingCall(
          channel.newCall(config.cat), responseObserver);
    }

    @java.lang.Override
    public io.grpc.stub.StreamObserver<io.grpc.examples.mobilegrpc.Mobile2Server.sRequest> transmit(
        io.grpc.stub.StreamObserver<io.grpc.examples.mobilegrpc.Mobile2Server.sReply> responseObserver) {
      return duplexStreamingCall(
          channel.newCall(config.transmit), responseObserver);
    }

    @java.lang.Override
    public void forwarding(io.grpc.examples.mobilegrpc.Mobile2Server.Request request,
        io.grpc.stub.StreamObserver<io.grpc.examples.mobilegrpc.Mobile2Server.sReply> responseObserver) {
      asyncServerStreamingCall(
          channel.newCall(config.forwarding), request, responseObserver);
    }
  }

  public static class greeterBlockingStub extends
      io.grpc.stub.AbstractStub<greeterBlockingStub, greeterServiceDescriptor>
      implements greeterBlockingClient {
    private greeterBlockingStub(io.grpc.Channel channel,
        greeterServiceDescriptor config) {
      super(channel, config);
    }

    @java.lang.Override
    protected greeterBlockingStub build(io.grpc.Channel channel,
        greeterServiceDescriptor config) {
      return new greeterBlockingStub(channel, config);
    }

    @java.lang.Override
    public io.grpc.examples.mobilegrpc.Mobile2Server.Reply sayHello(io.grpc.examples.mobilegrpc.Mobile2Server.Request request) {
      return blockingUnaryCall(
          channel.newCall(config.sayHello), request);
    }

    @java.lang.Override
    public java.util.Iterator<io.grpc.examples.mobilegrpc.Mobile2Server.sReply> spliti(
        io.grpc.examples.mobilegrpc.Mobile2Server.Request request) {
      return blockingServerStreamingCall(
          channel.newCall(config.spliti), request);
    }

    @java.lang.Override
    public java.util.Iterator<io.grpc.examples.mobilegrpc.Mobile2Server.sReply> forwarding(
        io.grpc.examples.mobilegrpc.Mobile2Server.Request request) {
      return blockingServerStreamingCall(
          channel.newCall(config.forwarding), request);
    }
  }

  public static class greeterFutureStub extends
      io.grpc.stub.AbstractStub<greeterFutureStub, greeterServiceDescriptor>
      implements greeterFutureClient {
    private greeterFutureStub(io.grpc.Channel channel,
        greeterServiceDescriptor config) {
      super(channel, config);
    }

    @java.lang.Override
    protected greeterFutureStub build(io.grpc.Channel channel,
        greeterServiceDescriptor config) {
      return new greeterFutureStub(channel, config);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.mobilegrpc.Mobile2Server.Reply> sayHello(
        io.grpc.examples.mobilegrpc.Mobile2Server.Request request) {
      return unaryFutureCall(
          channel.newCall(config.sayHello), request);
    }
  }

  public static io.grpc.ServerServiceDefinition bindService(
      final greeter serviceImpl) {
    return io.grpc.ServerServiceDefinition.builder("mobile2server.greeter")
      .addMethod(createMethodDefinition(
          METHOD_SAY_HELLO,
          asyncUnaryRequestCall(
            new io.grpc.stub.ServerCalls.UnaryRequestMethod<
                io.grpc.examples.mobilegrpc.Mobile2Server.Request,
                io.grpc.examples.mobilegrpc.Mobile2Server.Reply>() {
              @java.lang.Override
              public void invoke(
                  io.grpc.examples.mobilegrpc.Mobile2Server.Request request,
                  io.grpc.stub.StreamObserver<io.grpc.examples.mobilegrpc.Mobile2Server.Reply> responseObserver) {
                serviceImpl.sayHello(request, responseObserver);
              }
            })))
      .addMethod(createMethodDefinition(
          METHOD_SPLITI,
          asyncUnaryRequestCall(
            new io.grpc.stub.ServerCalls.UnaryRequestMethod<
                io.grpc.examples.mobilegrpc.Mobile2Server.Request,
                io.grpc.examples.mobilegrpc.Mobile2Server.sReply>() {
              @java.lang.Override
              public void invoke(
                  io.grpc.examples.mobilegrpc.Mobile2Server.Request request,
                  io.grpc.stub.StreamObserver<io.grpc.examples.mobilegrpc.Mobile2Server.sReply> responseObserver) {
                serviceImpl.spliti(request, responseObserver);
              }
            })))
      .addMethod(createMethodDefinition(
          METHOD_CAT,
          asyncStreamingRequestCall(
            new io.grpc.stub.ServerCalls.StreamingRequestMethod<
                io.grpc.examples.mobilegrpc.Mobile2Server.sRequest,
                io.grpc.examples.mobilegrpc.Mobile2Server.Reply>() {
              @java.lang.Override
              public io.grpc.stub.StreamObserver<io.grpc.examples.mobilegrpc.Mobile2Server.sRequest> invoke(
                  io.grpc.stub.StreamObserver<io.grpc.examples.mobilegrpc.Mobile2Server.Reply> responseObserver) {
                return serviceImpl.cat(responseObserver);
              }
            })))
      .addMethod(createMethodDefinition(
          METHOD_TRANSMIT,
          asyncStreamingRequestCall(
            new io.grpc.stub.ServerCalls.StreamingRequestMethod<
                io.grpc.examples.mobilegrpc.Mobile2Server.sRequest,
                io.grpc.examples.mobilegrpc.Mobile2Server.sReply>() {
              @java.lang.Override
              public io.grpc.stub.StreamObserver<io.grpc.examples.mobilegrpc.Mobile2Server.sRequest> invoke(
                  io.grpc.stub.StreamObserver<io.grpc.examples.mobilegrpc.Mobile2Server.sReply> responseObserver) {
                return serviceImpl.transmit(responseObserver);
              }
            })))
      .addMethod(createMethodDefinition(
          METHOD_FORWARDING,
          asyncUnaryRequestCall(
            new io.grpc.stub.ServerCalls.UnaryRequestMethod<
                io.grpc.examples.mobilegrpc.Mobile2Server.Request,
                io.grpc.examples.mobilegrpc.Mobile2Server.sReply>() {
              @java.lang.Override
              public void invoke(
                  io.grpc.examples.mobilegrpc.Mobile2Server.Request request,
                  io.grpc.stub.StreamObserver<io.grpc.examples.mobilegrpc.Mobile2Server.sReply> responseObserver) {
                serviceImpl.forwarding(request, responseObserver);
              }
            }))).build();
  }
}
