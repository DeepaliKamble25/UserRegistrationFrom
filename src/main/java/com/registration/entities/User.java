package com.registration.entities;

import com.registration.dao.CompanyDto;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    private String password;
    private String country;
    private Integer pincode;

    private String emailId;
    private String state;
    private String district;
    private Long mobile;
    private String city;
    private Long aadhar;
    private Boolean status;
    private String pan;


    private List<MultipartFile> file;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Company> companys;


}
