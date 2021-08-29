package a.b.c;

import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

public class RpcServer extends AddServiceGrpc.AddServiceImplBase {
    public static void main(String[] args) throws IOException {
        ServerBuilder.forPort(9999).addService(new RpcServer()).build().start();
        while(true){
        }
    }

    @Override
    public void add(AddRequest request, StreamObserver<AddReply> responseObserver) {
        int res = myAdd(request.getA(),request.getB());
        responseObserver.onNext(AddReply.newBuilder().setRes(res).build());
        responseObserver.onCompleted();
    }

    private int myAdd(int a,int b){
        return a+b;
    }
}
