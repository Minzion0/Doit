package com.zino.doit.domain.controller;

import com.zino.doit.domain.model.dto.UserDTO;
import com.zino.doit.domain.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {

   private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?>userSignUp(@RequestBody UserDTO.SignUpDTO signUpDTO) {



        return ResponseEntity.ok().build();
    }
}
