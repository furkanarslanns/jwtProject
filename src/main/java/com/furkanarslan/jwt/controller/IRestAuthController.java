package com.furkanarslan.jwt.controller;

import com.furkanarslan.jwt.dto.DtoUser;
import com.furkanarslan.jwt.jwt.AuthRequest;
import com.furkanarslan.jwt.jwt.AuthResponse;

public interface IRestAuthController {

    public DtoUser register(AuthRequest request);

    public AuthResponse authenticate(AuthRequest request);


}
