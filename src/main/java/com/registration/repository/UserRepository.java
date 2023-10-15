package com.registration.repository;

import com.registration.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


    Optional< User> findByEmail(String email);

    Optional< User> findByName(String name);

  List<User> findByCountry(String country);

    List<User> findByState(String state);

    Optional< User> findByPanAndAadhar(String pan, String aadhar);

    Optional< User> findByMobile(Long mobile);



}
