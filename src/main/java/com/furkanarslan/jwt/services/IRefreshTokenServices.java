package com.furkanarslan.jwt.services;

import com.furkanarslan.jwt.jwt.AuthResponse;

public interface IRefreshTokenServices {

public AuthResponse refreshToken(String refreshToken);



}
