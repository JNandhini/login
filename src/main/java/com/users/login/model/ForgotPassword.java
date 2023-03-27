package com.users.login.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_account")
public class ForgotPassword {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String email_id;
    public String verify_code;
    public void setverify_code(String verify_code) {
        this.verify_code = verify_code;
    }
    public String getverify_code() {
        return verify_code;
    }
    public void setemail_id(String email_id) {
        this.email_id = email_id;
    }
    public String getemail_id() {
        return email_id;
    }
}

