package com.users.login.services.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.users.login.model.ForgotPassword;
import com.users.login.model.Login;
import com.users.login.model.ResetPassword;
import com.users.login.model.ValidLogin;
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
    public Object getByEmailId(String email_id) {
       
        String sql = "select email_id as 'email',is_verified as'isverified',verify_code as 'verifycode',is_active as 'isactive' from user_account  WHERE email_id = :email_id";
        NativeQueryImpl nativeQuery = (NativeQueryImpl)em.createNativeQuery(sql);
        nativeQuery.setParameter("email_id", email_id);
        nativeQuery.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        List<Map<String,Object>> list = nativeQuery.getResultList();
        return list;
    }
    

    @Override
    public Object getByEmailAndPassword(String email_id, String login_password) {
        String sql = "select count(*) as count from user_account where email_id=:email_id and login_password=:login_password";
        NativeQueryImpl nativeQuery = (NativeQueryImpl)em.createNativeQuery(sql);
        nativeQuery.setParameter("email_id", email_id);
        nativeQuery.setParameter("login_password", login_password);
        nativeQuery.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        List<Map<String,Object>> list = nativeQuery.getResultList();
        return list;
    }

    @Override
    public boolean forgotPassword(ForgotPassword forgotPassword,String email_id) { //saveVerificationCode
        String sql = "UPDATE user_account set is_verified='No',verify_code=:verify_code WHERE email_id=:email_id";
        Query query = em.createNativeQuery(sql, ForgotPassword.class);
        query.setParameter("verify_code",forgotPassword.getverify_code() );
        query.setParameter("email_id", email_id);
        System.out.println(forgotPassword.getemail_id());
        query.executeUpdate();
        // List<Login> result = query.getResultList();
        return true;
    }

    @Override
    public boolean setPassword(ResetPassword resetPassword,String email_id) {
        String sql = "UPDATE user_account set is_verified='Yes',login_password=:newpassword WHERE email_id=:email_id";
        Query query = em.createNativeQuery(sql, ResetPassword.class);
        query.setParameter("newpassword",resetPassword.getnewpassword() );
        query.setParameter("email_id", email_id);
        query.executeUpdate();
        // List<Login> result = query.getResultList();
        return true;
    }

    @Override
    public Object getByUserEmailId(String email_id) {
        String sql = "select first_name,last_name,email_id as 'email',count(*) as 'count',is_admin as 'admin',is_verified,is_active as 'active',user_id from user_account where  email_id = :email_id";
        // Query query = em.createNativeQuery(sql, ValidLogin.class);
        NativeQueryImpl nativeQuery = (NativeQueryImpl)em.createNativeQuery(sql);
        nativeQuery.setParameter("email_id", email_id);
        nativeQuery.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        List<Map<String,Object>> list = nativeQuery.getResultList();
        return list;
        // List<ValidLogin> result = query.getResultList();
        // if (result.isEmpty()) {
        //     return null;
        // }
        // return result.get(0);
    }
    
}
