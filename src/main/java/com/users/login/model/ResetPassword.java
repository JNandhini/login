package com.users.login.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_account")
public class ResetPassword {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String email_id;
   
    public String newpassword;
    // public String login_password;
    public void setnewpassword(String newpassword) {
        this.newpassword = newpassword;
    }
    public String getnewpassword() {
        return newpassword;
    }
    
    public void setemail_id(String email_id) {
        this.email_id = email_id;
    }
    public String getemail_id() {
        return email_id;
    }
}

