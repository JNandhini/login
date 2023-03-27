package com.users.login.controller;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.users.login.repo.LoginRepository;
import com.users.login.model.ForgotPassword;
import com.users.login.model.Login;
import com.users.login.model.ResetPassword;
import com.users.login.model.ValidLogin;
import com.users.login.services.LoginServices;

@RestController
@RequestMapping("/login")
public class LoginController {
 
      LoginServices loginService;

public LoginController(LoginServices loginService) {
    super();
    this.loginService=loginService;
    }
@GetMapping("/verifycode/{email_id}")
Object getByEmailId(@PathVariable String email_id)
{
    return this.loginService.getByEmailId(email_id);
}
@GetMapping("/validloginpassword/{email_id}/{password}")
Object verifyUser(@PathVariable String email_id,@PathVariable String password)
{
    return this.loginService.getByEmailAndPassword(email_id,password);
}
@GetMapping("/validlogin/{email_id}")
Object getByUserEmailId(@PathVariable String email_id)
{
    return this.loginService.getByUserEmailId(email_id);
}
@PutMapping("/forgotPassword/{email_id}")
boolean forgotPassword(@RequestBody ForgotPassword forgotPassword,@PathVariable String email_id)
{
    return this.loginService.forgotPassword(forgotPassword,email_id);
}
@PutMapping("/resetPassword/{email_id}")
boolean savePassword(@RequestBody ResetPassword resetPassword,@PathVariable String email_id)
{
    return this.loginService.setPassword(resetPassword,email_id);
}
}
