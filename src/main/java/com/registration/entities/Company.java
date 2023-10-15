package com.registration.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "companys")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    private String companyName;

    private Date dateOfJoining;

    private Date dateOfExits;

    private String achievement;

    private Integer ctc;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private User userId;
}
