package com.hitha.SpringBootApp1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="hitha_user")
public class HithaUser {
//    public User(String phoneNumber, String aadharNumber, String firstName, String middleName, String lastName) {
//        this.phoneNumber = phoneNumber;
//        this.aadharNumber = aadharNumber;
//        this.firstName = firstName;
//        this.middleName = middleName;
//        this.lastName = lastName;
//    }

   //@GeneratedValue(strategy= GenerationType.AUTO)
//    @Column(name="user_id")
//    private UUID userId;

    @Id
    @Column(name="phone_number")
    private String phoneNumber;


    @Column(name="aadhar_number")
    private String aadharNumber;

    @Column(name="first_name")
    private String firstName;

    @Column(name="middle_name")
    private String middleName;

    @Column(name="last_name")
    private String lastName;

    @Column(name = "language")
    private String language;

}
