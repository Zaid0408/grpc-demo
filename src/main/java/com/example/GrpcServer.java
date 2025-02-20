package com.example;
import java.io.IOException;

import com.example.user.UserService;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcServer{
    public static void main(String[] args) throws IOException {
        System.out.println("gRPC Server started");
        Server server = ServerBuilder.forPort(50051)
            .addService(new UserService())
            .build();
        try {
            server.start(); // some exception issues handle it using try catch
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Server started at " + server.getPort());
        
        try {
            server.awaitTermination();
        } catch (InterruptedException e) { // some interrupted exception issues handle it using try catch
            e.printStackTrace();
        }
        
        
    }
}