package com.hitha.SpringBootApp1.rest;

import com.hitha.SpringBootApp1.entity.HithaUser;
import com.hitha.SpringBootApp1.objects.UserConflict;
import com.hitha.SpringBootApp1.service.HithaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class HithaUserController {
    @Autowired
    private HithaUserService userService;

    //Get user by aadhar number
    @GetMapping("/aadhar")
    public ResponseEntity getUserForAadharNumber(@RequestParam String aadharNumber) {
        try {
            HithaUser user = userService.getUserByAadharNumber(aadharNumber);
            return new ResponseEntity<>(user,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/checkConflict")
    public ResponseEntity checkIfExists(@RequestBody HithaUser newUser) {
        try {
            UserConflict currentUserConflict= userService.isConflictNewUser(newUser);
            if(currentUserConflict.isOverallConflict()){
                return new ResponseEntity<>(currentUserConflict,HttpStatus.CONFLICT);
            }
            else {
                return new ResponseEntity<>(currentUserConflict,HttpStatus.OK);
            }
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/phone")
    public ResponseEntity getUserForPhoneNumber(@RequestParam String phoneNumber) {
        try {
            HithaUser currentUser = userService.getUserByPhoneNumber(phoneNumber);
            return new ResponseEntity<>(currentUser,HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody HithaUser newUser) {
        try {
            HithaUser newAddedUser= userService.addUser(newUser);
            return new ResponseEntity<>(newUser,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }
    @PutMapping("/update")
    public ResponseEntity updateUser(@RequestBody HithaUser user) {
        try {
            HithaUser updatedUser= userService.updateUser(user);
            return new ResponseEntity<>(updatedUser,HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteUser(@RequestParam String phoneNumber) {
        try {
            userService.deleteUser(phoneNumber);
            return new ResponseEntity<>("Deleted User with phoneNumber"+phoneNumber,HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
