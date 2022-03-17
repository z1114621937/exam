package com.auths.domain;


import com.mbg.exam.entity.Student;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author zuo
 */
public class MemberDetails implements UserDetails {
    private Student student;
    
    public MemberDetails(Student student) {
        this.student = student;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return Arrays.asList(new SimpleGrantedAuthority("TEST"));
    }
    
    @Override
    public String getPassword() {
        return student.getPassword();
    }
    
    @Override
    public String getUsername() {
        return student.getUsername();
    }
    
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    
    @Override
    public boolean isEnabled() {
        return true;
    }
    
    public Student getStudent() {
        return student;
    }
}