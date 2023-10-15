package com.registration.controller;

import com.registration.dao.UserDto;
import com.registration.payload.ApiConstant;
import com.registration.payload.ApiResponse;
import com.registration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService userService;


    @PostMapping("/")
    public ResponseEntity<UserDto> saveUserDto(@Valid @RequestBody UserDto userDto) {
        UserDto savedUser = this.userService.createRecord(userDto);

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long userId, @RequestBody UserDto userDto) {

        UserDto userDto1 = this.userService.updateUserDto(userDto, userId);

        return new ResponseEntity<>(userDto1, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        ApiResponse apiResponse = ApiResponse.builder().message(ApiConstant.User_DEleted).success(true).status(HttpStatus.OK).build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/email/{emailId}")
    public ResponseEntity<UserDto> getByEmail(@PathVariable String emailId) {
        UserDto userDto = userService.getByemail(emailId);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<UserDto> getByName(@PathVariable String name) {
        UserDto userDto = userService.getByName(name);

        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @GetMapping("/country/{country}")
    public ResponseEntity<List<UserDto>> getByCountry(@PathVariable String country) {
        List<UserDto> userDtos = userService.getByCountry(country);

        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }

    @GetMapping("/state/{state}")
    public ResponseEntity<List<UserDto>> getByState(@PathVariable String state) {
        List<UserDto> userDtosList = userService.getByState(state);
        return new ResponseEntity<>(userDtosList, HttpStatus.OK);
    }

    @GetMapping("/panaadhar")
    public ResponseEntity<UserDto> getByPanAndAadhar(@RequestParam String pan, @RequestParam String aadhar) {
        UserDto userDto = userService.getByPanAndAadhar(pan, aadhar);

        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @GetMapping("/mobile/{mobile}")
    public ResponseEntity<UserDto> getByMobile(@PathVariable Long mobile) {
        UserDto byMobile = userService.getByMobile(mobile);

        return new ResponseEntity<>(byMobile, HttpStatus.OK);

    }
}