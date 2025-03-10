package com.furkanarslan.jwt.services;

import com.furkanarslan.jwt.dto.DtoUser;
import com.furkanarslan.jwt.jwt.AuthRequest;
import com.furkanarslan.jwt.jwt.AuthResponse;
import org.apache.coyote.Request;

public interface IRestAuthServices {

    public DtoUser register(AuthRequest request);

    public AuthResponse authenticate(AuthRequest request);



}
