package com.springsoap.api.endpoint;


import com.springsoap.api.service.UserService;
import com.springsoap.api.users.GetUserRequest;
import com.springsoap.api.users.GetUserResponse;
import com.springsoap.api.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class UserEndPoint {


    @Autowired
    UserService userService;


    @PayloadRoot(namespace ="http://springsoap.com/api/users", localPart ="getUserRequest")
    @ResponsePayload
    public GetUserResponse getUserRequest(@RequestPayload GetUserRequest request) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        System.out.println(authentication.getPrincipal().toString());


        GetUserResponse userResponse =new GetUserResponse();

        User user = userService.getUser(request.getName());


        if(user!=null)
        userResponse.setUser(user);

        return userResponse;
    }


}
