package com.example.user;

import com.example.grpc.UserOuterClass.User;
import com.example.grpc.UserServiceGrpc.UserServiceImplBase;
/**
 * UserService class that extends UserServiceImplBase.
 * This class implements the gRPC service methods defined in the .proto file.
 */


public class UserService extends UserServiceImplBase{
    /**
     * Override the login method defined in the .proto file.
     * This method is generated in the com.example.grpc.UserServiceGrpc.UserServiceImplBase class.
     *
     * @param request The request containing the username and password.
     * @param responseObserver The response observer to send the response.
     */
    @Override
    public void login(com.example.grpc.UserOuterClass.GetUserRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.UserOuterClass.User> responseObserver) {

            System.out.println("login method called");
            String username = request.getUsername();
            String passy=request.getPassword();
            // Create a User.Builder object to build the respons
            User.Builder user= User.newBuilder();
            if(username.equals(passy))
            {
                // return success message
                // Set response code to 0 indicating success
                user.setResponseCode(0);
                user.setResponseMessage("Login Success");

            }
            else
            { // login failed
                user.setResponseCode(100).setResponseMessage("Login Failed. INVALID PASSWORD");
            }
            // Send the response to the client
            responseObserver.onNext(user.build());
            responseObserver.onCompleted();
        }
    /**
     * Override the logout method defined in the .proto file.
     * This method is generated in the com.example.grpc.UserServiceGrpc.UserServiceImplBase class.
     *
     * @param request The request containing the logout information.
     * @param responseObserver The response observer to send the response.
     */    
    @Override
    public void logout(com.example.grpc.UserOuterClass.Empty request,
        io.grpc.stub.StreamObserver<com.example.grpc.UserOuterClass.User> responseObserver) {
            responseObserver.onCompleted();
        }
    
}