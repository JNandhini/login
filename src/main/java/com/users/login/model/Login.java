package com.users.login.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_account")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int user_id;
    public String email_id;
    public String is_active;
    public String login_password;
    public String verify_code;
    // public String post_job;
    public String is_admin;
    public String is_verified;
    public String last_name;
    public String first_name;

}

