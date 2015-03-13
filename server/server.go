package main

import (
	"flag"
	"fmt"
	"io"
	//"io/toutil"
	"log"
	// "math"
	"golang.org/x/net/context"
	"google.golang.org/grpc"
	"net"
	"strconv"
	"strings"

	// proto "github.com/golang/protobuf/proto"

	pb "proto"
)

var (
	tls  = flag.Bool("tls", false, "Connection uses TLS if true, else plain TCP")
	port = flag.Int("port", 8980, "The server port")
)

type Server struct {
	mem map[int]string
}

func (s *Server) SayHello(ctx context.Context, from *pb.Request) (*pb.Reply, error) {
	return &pb.Reply{Value: "Hello" + from.Value}, nil
}

func (s *Server) Spliti(from *pb.Request, stream pb.Greeter_SplitiServer) error {
	sub := strings.Split(from.Value, ";")
	for k, v := range sub {
		s.mem[k] = v
		if err := stream.Send(&pb.SReply{Id: int32(k), Value: v}); err != nil {
			return err
		}
	}
	return nil
}

func (s *Server) Cat(stream pb.Greeter_CatServer) error {
	var final string
	for {
		v, err := stream.Recv()
		if err == io.EOF {
			return stream.SendAndClose(&pb.Reply{Value: final})
		}
		if err != nil {
			return err
		}
		final += strconv.Itoa(int(v.Id)) + ":" + v.Value + ";"
	}
}

func (s *Server) Transmit(stream pb.Greeter_TransmitServer) error {
	for {
		in, err := stream.Recv()
		if err == io.EOF {
			return nil
		}
		if err != nil {
			return err
		}
		out := &pb.SReply{}
		out.Id = 100 - in.Id
		out.Value = in.Value
		if err := stream.Send(out); err != nil {
			return err
		}
	}
}
func (s *Server) Forwarding(from *pb.Request, stream pb.Greeter_ForwardingServer) error {
	if from.Value == "get" {
		for k, v := range s.mem {
			if err := stream.Send(&pb.SReply{Id: int32(k), Value: v}); err != nil {
				return err
			}
		}
	}
	return nil
}
func main() {
	flag.Parse()
	lis, err := net.Listen("tcp", fmt.Sprintf(":%d", *port))
	if err != nil {
		log.Fatalf("failed to listen: %v", err)
	}
	grpcServer := grpc.NewServer()
	pb.RegisterGreeterServer(grpcServer, &Server{mem: make(map[int]string)})
	grpcServer.Serve(lis)
}
