package com.hitha.SpringBootApp1.service;

import com.hitha.SpringBootApp1.entity.HithaUser;
import com.hitha.SpringBootApp1.objects.UserConflict;
import com.hitha.SpringBootApp1.repo.HithaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HithaUserService {

    @Autowired
    private HithaUserRepository hithaUserRepository;

    public UserConflict isConflictNewUser(HithaUser newUser)  {
        UserConflict userConflict=new UserConflict(false,false,false);
        if(!(newUser.getPhoneNumber().isEmpty() || hithaUserRepository.findByPhoneNumber(newUser.getPhoneNumber()).isEmpty())){
            userConflict.setPhoneNumber(true);
            userConflict.setOverallConflict(true);
        }
        if(!(newUser.getAadharNumber().isEmpty() || hithaUserRepository.findByAadharNumber(newUser.getAadharNumber()).isEmpty())){
            userConflict.setAadharNumber(true);
            userConflict.setOverallConflict(true);
        }
        return userConflict;




    }
    //By aadhar number
    public HithaUser getUserByAadharNumber(String aadharNumber) {

        try {
            List<HithaUser> userList= hithaUserRepository.findByAadharNumber(aadharNumber);
            if(userList.isEmpty()) {
                throw new RuntimeException("USER_NOT_FOUND");
            }
            if(userList.size()>1){
                throw new RuntimeException("TOO_MANY_VALUES");
            }
            return userList.get(0);
        }
        catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    //By phone number
    public HithaUser getUserByPhoneNumber(String phoneNumber) {

        try {
            List<HithaUser> userList= hithaUserRepository.findByPhoneNumber(phoneNumber);
            if(userList.isEmpty()) {
                throw new RuntimeException("USER_NOT_FOUND");
            }
            if(userList.size()>1){
                throw new RuntimeException("TOO_MANY_VALUES");
            }
            return userList.get(0);
        }
        catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public HithaUser addUser(HithaUser newUser) {
        //boolean conflict=false;
        //List<String> conflictMessages= new ArrayList<String>();
        if(!hithaUserRepository.findByPhoneNumber(newUser.getPhoneNumber()).isEmpty()){
//            conflictMessages.add("PHONE_NUMBER_ALREADY_EXISTS");
//            conflict=true;
            throw new RuntimeException("PHONE_NUMBER_ALREADY_EXISTS");
        }


//        if(!HithaUserRepository.findByAadharNumber(newUser.getAadharNumber()).isEmpty()){
//            conflictMessages.add("AADHAR_NUMBER_ALREADY_EXISTS");
//            conflict=true;
//        }
//        if(!HithaUserRepository.findByPhoneNumber(newUser.getPhoneNumber()).isEmpty()){
//            conflictMessages.add("PHONE_NUMBER_ALREADY_EXISTS");
//            conflict=true;
//        }
//        if(conflict) {
//            throw new RuntimeException(conflictMessages.toString());
//        }
        return hithaUserRepository.save(newUser);
    }

    public HithaUser updateUser(HithaUser user) {
        if(!hithaUserRepository.findByPhoneNumber(user.getPhoneNumber()).isEmpty()){
//            conflictMessages.add("PHONE_NUMBER_ALREADY_EXISTS");
//            conflict=true;
            throw new RuntimeException("USER_WITH_PHONE_NUMBER_DOES_NOT_EXIST");
        }
        return hithaUserRepository.save(user);
    }

    public void deleteUser(String phoneNumber) {
        hithaUserRepository.deleteByPhoneNumber(phoneNumber);
    }
}
