package com.zino.doit.domain.service.user.impl;

import com.zino.doit.domain.model.dto.UserDTO.SignUpDTO;
import com.zino.doit.domain.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  @Override
  public void userSignUp(SignUpDTO request) {

  }
}
