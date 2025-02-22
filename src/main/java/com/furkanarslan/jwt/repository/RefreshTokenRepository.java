package com.furkanarslan.jwt.repository;

import com.furkanarslan.jwt.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {



    Optional<RefreshToken> findByRefreshToken(String refreshToken);
}
