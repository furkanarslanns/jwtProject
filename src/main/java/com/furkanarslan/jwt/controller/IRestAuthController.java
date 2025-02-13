package com.furkanarslan.jwt.controller;

import com.furkanarslan.jwt.dto.DtoUser;
import com.furkanarslan.jwt.jwt.AuthRequest;

public interface IRestAuthController {

    public DtoUser register(AuthRequest request);


}
