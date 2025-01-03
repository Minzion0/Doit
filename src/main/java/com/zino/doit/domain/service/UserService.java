package com.zino.doit.domain.service;

import com.zino.doit.domain.model.dto.UserDTO;

public interface UserService {

    public void userSignUp(UserDTO.SignUpDTO request);
}
