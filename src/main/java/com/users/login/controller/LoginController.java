package com.users.login.controller;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.users.login.repo.LoginRepository;
import com.users.login.model.Login;
import com.users.login.services.LoginServices;

@RestController
@RequestMapping("/login")
public class LoginController {
 @Autowired  LoginServices loginService;

// public LoginController(LoginServices loginService) {
//     super();
//     this.loginService=loginService;
//     }
@GetMapping("/verifycode/{email_id}")
Login getByEmailId(@PathVariable String email_id)
{
    return this.loginService.getByEmailId(email_id);
}
@GetMapping("/verifypassword/{email_id}/{password}")
Login verifyUser(@PathVariable String email_id,@PathVariable String password)
{
    return this.loginService.getByEmailAndPassword(email_id, password);
}
@GetMapping("/user_id/{user_id}")
Login getById(@PathVariable int user_id)
{
    return this.loginService.getById(user_id);
}
}
