package com.furkanarslan.jwt.services.impl;

import com.furkanarslan.jwt.entity.RefreshToken;
import com.furkanarslan.jwt.entity.User;
import com.furkanarslan.jwt.jwt.AuthResponse;
import com.furkanarslan.jwt.jwt.JwtServices;
import com.furkanarslan.jwt.repository.RefreshTokenRepository;
import com.furkanarslan.jwt.services.IRefreshTokenServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenServices implements IRefreshTokenServices {
@Autowired
private RefreshTokenRepository refreshTokenRepository;
@Autowired
JwtServices jwtServices;
public boolean isRefreshTokenExpired(Date expiredDate) {
return new Date().before(expiredDate);
}
private RefreshToken createRefreshToken (User user) {
        RefreshToken refreshToken = new RefreshToken();

        refreshToken.setRefreshToken(UUID.randomUUID().toString());
        refreshToken.setExpireDate(new Date(System.currentTimeMillis()+ 1000*60*60*4));
        refreshToken.setUser(user);
        return refreshToken;
    }

    @Override
    public AuthResponse refreshToken(String refreshToken) {
      Optional<RefreshToken> optional = refreshTokenRepository.findByRefreshToken(refreshToken);

      if (optional.isEmpty()) {
          System.out.println("Refresh token not found"+refreshToken);
      }
      RefreshToken refreshToken1 = optional.get();
      if (!isRefreshTokenExpired(refreshToken1.getExpireDate())){
          System.out.println("Refresh token expired"+refreshToken);
      }

     String accessToken= jwtServices.generateToken(refreshToken1.getUser());
     RefreshToken newRefreshToken=createRefreshToken(refreshToken1.getUser());

     refreshTokenRepository.save(newRefreshToken);
     return new AuthResponse(accessToken,newRefreshToken.getRefreshToken());
    }
}
