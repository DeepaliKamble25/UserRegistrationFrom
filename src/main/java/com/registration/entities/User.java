package com.registration.entities;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {


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








}
