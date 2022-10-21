package com.cis.manageAccounts.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value ="/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = {"","/"})
    public ResponseEntity<List<User>> getAllUsers(){
      return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
     }

     @PostMapping(value ={"","/"} )
     public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        return new ResponseEntity<>(userService.saveUser(user),HttpStatus.CREATED);
     }

    @GetMapping(value ={"/{email}"})
    public ResponseEntity<User> getUserByEmail(@PathVariable String email){
        return new ResponseEntity<>(userService.getUserByEmail(email),HttpStatus.OK);
    }

    @GetMapping(value ={"/city/{city}"})
    public ResponseEntity<List<User>> getUserByCity(@PathVariable String city){
        return new ResponseEntity<>(userService.getUsersByCity(city),HttpStatus.OK);
    }
}
