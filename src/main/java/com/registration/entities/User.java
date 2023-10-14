package com.registration.entities;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name="users")
public class User {

      @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
      private String userId;
      private String name;
      private String password;
      private String country;
      private Integer pincode;

      private String emailId;
      private String state;
      private String district;
      private Long mobileNo;
    private String city;
    private String adharNo;
    private Boolean status;

    private Date dateOfJoining;

    private Date dateOfExits;

    private String achievement;

    private Integer ctc;

    private List<MultipartFile> file;
    private User userNameUser;








}
