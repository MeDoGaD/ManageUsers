package com.cis.manageAccounts.users;

import com.cis.manageAccounts.errors.ConflictException;
import com.cis.manageAccounts.errors.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
       return userRepository.findAll();
    }

    public User saveUser(User user){
        User user1=userRepository.findByEmail(user.getEmail());
        if(user1==null)
             return userRepository.save(user);
        else
            throw new ConflictException("There is another user with the same email :(");

    }


    public User getUserByEmail(String email) {
            User user= userRepository.findByEmail(email);
            if(user==null)
                throw new NotFoundException(String.format("No users with the email [%s] in our database !!",email));
            else
                return user;
    }

    public List<User> getUsersByCity(String city) {
        List<User> users=userRepository.findByCity(city);
        return users;
    }
}
