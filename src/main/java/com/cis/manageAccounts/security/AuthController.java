package com.cis.manageAccounts.security;


import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/auth")
public class AuthController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private TokenUtil tokenUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(value = {"","/"})
    public JwtResponse signIn(@RequestBody SignInRequest signInRequest){

        try {
            final Authentication authentication = authenticationManager.
                    authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails userDetails= adminService.loadUserByUsername(signInRequest.getUsername());
            String token=tokenUtil.generateToken(userDetails);
            JwtResponse jwtResponse =new JwtResponse(token);
            return jwtResponse;
        }catch (Exception ex){
            System.out.println(String.format("********* %s",ex));
            return null;
        }

    }

}
