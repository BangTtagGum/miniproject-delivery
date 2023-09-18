package com.example.miniprojectdelivery.controller;


import com.example.miniprojectdelivery.dto.SignupRequestDto;
import com.example.miniprojectdelivery.model.Mail;
import com.example.miniprojectdelivery.model.Msg;
import com.example.miniprojectdelivery.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    // ResponseEntity<Map>
    @PostMapping("/user/signup")
    public ResponseEntity<Msg> signup(@Valid @RequestBody SignupRequestDto requestDto){
        return userService.signup(requestDto);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Msg> deleteById(@PathVariable Long id){
        return userService.deleteById(id);
    }

    @PostMapping("/user/mailing")
    public void mailing(@RequestBody Mail email){
        userService.Mailing(email);
    }
}
