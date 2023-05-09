package uz.pdp.crudwithspringboot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uz.pdp.crudwithspringboot.domain.dto.BaseResponse;
import uz.pdp.crudwithspringboot.domain.dto.LoginDto;
import uz.pdp.crudwithspringboot.domain.entity.UserEntity;
import uz.pdp.crudwithspringboot.service.UserService;


import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;



@Controller
@RequestMapping(value = "/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping("/login")
    @ResponseBody
    public BaseResponse login(
            @RequestParam String email,
            @RequestParam String password
    ){
        return userService.login(new LoginDto(email, password));
    }

    @PostMapping("/register")
    @ResponseBody
    public BaseResponse register(
            @RequestBody UserEntity user
    ){
        return userService.createUser(user);
    }

    @PostMapping("/update/{id}")
    @ResponseBody
    public BaseResponse confirmUpdate(
            @PathVariable UUID id,
            @RequestBody UserEntity user
    ){
        UserEntity user1 = userService.getById(id).getUserEntity();
        user1.setUpdated_date(LocalDateTime.now());
        user1.setEmail(user.getEmail());
        user1.setName(user.getName());
        user1.setPassword(user.getPassword());
        return userService.updateUserInfo(user1);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public BaseResponse deleteAccount(@PathVariable UUID id){
        return userService.deleteById(id);
    }

    @GetMapping("/get-all")
    @ResponseBody
    public List<UserEntity> getAll(){
        List<UserEntity> usersList = userService.getUsersList();
        return usersList;
    }

}
