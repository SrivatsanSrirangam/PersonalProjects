package com.hitha.SpringBootApp1.repo;

import com.hitha.SpringBootApp1.entity.HithaUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HithaUserRepository extends CrudRepository<HithaUser, UUID> {
    List<HithaUser> findByAadharNumber(String aadharNumber);

    List<HithaUser> findByPhoneNumber(String phoneNumber);

    void deleteByPhoneNumber(String phoneNumber);

//    @Query("SELECT u FROM User u WHERE u.status = 1")
//    List<User> findConflictingUsers();
}
