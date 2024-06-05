package com.apigateway.apigateway.services;

import com.apigateway.apigateway.models.StaffModel;
import com.apigateway.apigateway.repositorys.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailSever implements UserDetailsService {
    @Autowired
    private StaffRepository staffRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        StaffModel user =staffRepository.findByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("User not found", null);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }
}
