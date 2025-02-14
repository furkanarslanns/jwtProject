package com.furkanarslan.jwt.services.impl;

import com.furkanarslan.jwt.dto.DtoUser;
import com.furkanarslan.jwt.entity.User;
import com.furkanarslan.jwt.jwt.AuthRequest;
import com.furkanarslan.jwt.jwt.AuthResponse;
import com.furkanarslan.jwt.jwt.JwtServices;
import com.furkanarslan.jwt.repository.UserRepository;
import com.furkanarslan.jwt.services.IRestAuthServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestAuthServices implements IRestAuthServices {
@Autowired
private UserRepository userRepository;
@Autowired
private BCryptPasswordEncoder passwordEncoder;
@Autowired
private AuthenticationProvider authenticationProvider;


    @Override
    public AuthResponse authenticate(AuthRequest request) {

try {
  UsernamePasswordAuthenticationToken authRequest =
          new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
  authenticationProvider.authenticate(authRequest);

    Optional<User> optional = userRepository.findByUsername(request.getUsername());
    JwtServices jwtServices = new JwtServices();
     String token= jwtServices.generateToken(optional.get());

return new AuthResponse(token);

}
catch (Exception e) {
    System.out.println("kullanıcı adı ve şifre yanlış");
}






        return null;
    }
    @Override
    public DtoUser register(AuthRequest request) {
       DtoUser dtoUser = new DtoUser();
     User user = new User();
     user.setUsername(request.getUsername());
     user.setPassword( passwordEncoder.encode(request.getPassword()));

     User savedUser =userRepository.save(user);
BeanUtils.copyProperties(savedUser, dtoUser);


return dtoUser;
    }


}
