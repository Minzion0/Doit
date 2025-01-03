package com.zino.doit.domain.model.dto;

import lombok.Data;

public class UserDTO {

    @Data
    public static class SignUpDTO{
        private String username;
        private String password;
        private String email;
        private String nickname;
    }
}
