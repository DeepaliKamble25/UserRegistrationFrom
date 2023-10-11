package com.registration.entities;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company {

    private User username;
    private String companyId;

    private Date dateOfJoining;

    private Date dateOfExits;

    private String achievement;

    private Integer ctc;

    private List<MultipartFile> file;
    private User userNameUser;






}
