package com.registration.dao;

import com.registration.entities.User;
import lombok.*;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.Date;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyDto {

    private Long companyId;

    private Date dateOfJoining;

    private Date dateOfExits;

    private String achievement;

    private Integer ctc;

    private UserDto userId;
}
