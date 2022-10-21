package com.cis.manageAccounts.security;
import com.cis.manageAccounts.errors.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;


    @Bean
    private PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepository.getByUsername(username);
        if(admin==null)
        {
            throw new NotFoundException("Admin not found !!");
        }
        else
            return admin;
    }

    public void saveAdmin(Admin admin){
        admin.setPassword(passwordEncoder().encode(admin.getPassword()));
        adminRepository.save(admin);
    }
    public List<Admin>findAll(){
        return adminRepository.findAll();
    }


}
