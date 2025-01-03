package com.zino.doit.domain.service.user;

import com.zino.doit.domain.model.dto.UserDTO;

public interface UserService {

    public void userSignUp(UserDTO.SignUpDTO request);
}
