package com.users.login.services.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.users.login.model.Login;
import com.users.login.repo.LoginRepository;
import com.users.login.services.LoginServices;
@Service
@Transactional
public class LoginServiceImpl implements LoginServices {

@Autowired EntityManager em;
@Autowired LoginRepository repo;
public LoginServiceImpl(LoginRepository repo) {
    this.repo = repo;
}

    @Override
    public Login getByEmailId(String email_id) {
        // Query query = (Query) em.createQuery(  "select * from user_account where email_id ='garunanath@gmail.com'").getSingleResult();  
        // query.setParameter("email_id",1);  
       // Login val =   query.getSingleResult(); 
        String sql="select * from user_account  where email_id=:email_id";
        Query query = em.createNativeQuery(sql);
        query.setParameter("email_id", email_id);
       
        return  (Login) query.getSingleResult();
        // Login login=(Login) em.createNativeQuery(sql).getResultList();
        // List<Login> list= em.createNativeQuery(sql,Login.class).getResultList();
        // return (Login) query;
        // return login;
    }

    @Override
    public Login getByEmailAndPassword(String email_id, String login_password) {
        String sql=String.format("select p.* from user_account p where email_id=:email_id and login_password=:login_password");
        Query query = em.createNativeQuery(sql);
        query.setParameter("email_id", email_id);
        query.setParameter("login_password", login_password);
        Login login=(Login) query.getResultList();
        return login;
    }

    @Override
    public boolean saveVerificationCode(String verify_code, String email_id) {
        return false;
    }

    @Override
    public boolean setPassword(String password, String email_id) {
        return false;
    }

    @Override
    public Login getById(int user_id) {
        return this.repo.findById(user_id);
    }
    
}
