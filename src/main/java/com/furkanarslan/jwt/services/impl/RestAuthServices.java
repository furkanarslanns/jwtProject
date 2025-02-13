package com.furkanarslan.jwt.services.impl;

import com.furkanarslan.jwt.dto.DtoUser;
import com.furkanarslan.jwt.entity.User;
import com.furkanarslan.jwt.jwt.AuthRequest;
import com.furkanarslan.jwt.repository.UserRepository;
import com.furkanarslan.jwt.services.IRestAuthServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RestAuthServices implements IRestAuthServices {
@Autowired
private UserRepository userRepository;
@Autowired
private BCryptPasswordEncoder passwordEncoder;

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
