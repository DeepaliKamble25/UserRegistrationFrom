package com.registration.repository;

import com.registration.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


    User findByEmail(String email);

    User findByName(String name);

    User findByCountry(String country);

    User findByState(String state);

    User findByPanAndAadhar(String pan, String aadhar);

    User findBymobile(Integer mobile);



}
