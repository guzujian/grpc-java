package a.b.c;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class RpcClient {
    ManagedChannel channel;
    AddServiceGrpc.AddServiceBlockingStub stub;

    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        RpcClient client = new RpcClient();
        AddReply resp = client.stub.add(AddRequest.newBuilder().setA(a).setB(b).build());
        System.out.println(resp.getRes());
    }
    public RpcClient() {
        channel = ManagedChannelBuilder
                .forAddress("127.0.0.1", 9999).usePlaintext().build();
        stub = AddServiceGrpc.newBlockingStub(channel);
    }
}
