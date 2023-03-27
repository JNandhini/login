package com.users.login.services;


import com.users.login.model.ForgotPassword;
import com.users.login.model.Login;
import com.users.login.model.ResetPassword;
import com.users.login.model.ValidLogin;

public interface LoginServices {
    public Object getByEmailId(String email_id);//verifycode
     Object getByEmailAndPassword(String email_id,String password);//verufy email and password
    //  boolean forgotPassword(String email_id,ForgotPassword forgotPassword); // get verification code and save 
     boolean setPassword(ResetPassword resetPassword,String email_id);//update password
     Object getByUserEmailId(String email_id); //
    public boolean forgotPassword(ForgotPassword forgotPassword, String email_id);
}
