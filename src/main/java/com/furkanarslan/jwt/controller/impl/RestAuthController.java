package com.furkanarslan.jwt.controller.impl;

import com.furkanarslan.jwt.controller.IRestAuthController;
import com.furkanarslan.jwt.dto.DtoUser;
import com.furkanarslan.jwt.jwt.AuthRequest;
import com.furkanarslan.jwt.jwt.AuthResponse;
import com.furkanarslan.jwt.services.impl.RestAuthServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAuthController implements IRestAuthController {

    @Autowired
    private RestAuthServices restAuthServices;


    @PostMapping("/register")
    @Override
    public DtoUser register(@Valid @RequestBody AuthRequest request) {
        return restAuthServices.register(request);
    }

    @PostMapping("/authenticate")
    @Override
    public AuthResponse authenticate(AuthRequest request) {
        return restAuthServices.authenticate(request);
    }
}
