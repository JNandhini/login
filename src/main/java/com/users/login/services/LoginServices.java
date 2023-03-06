package com.users.login.services;


import com.users.login.model.Login;

public interface LoginServices {
    public Login getByEmailId(String email_id);//verifycode
     Login getByEmailAndPassword(String email_id,String password);//verufy email and password
     boolean saveVerificationCode(String verify_code,String email_id); // get verification code and save 
     boolean setPassword(String password,String email_id);//update password
     Login getById(int user_id); //
}
