package com.dk.demo;

import com.dk.grpc.Request;
import com.dk.grpc.Response;
import com.dk.grpc.ServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class Service extends ServiceGrpc.ServiceImplBase {
	
	@Override
    public void sendMessage(Request request, StreamObserver<Response> responseObserver) {
        String message = request.getMessage() + " -> GRPC Response added";        

        Response response = Response.newBuilder()
                .setMessage("Received: " + message)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}