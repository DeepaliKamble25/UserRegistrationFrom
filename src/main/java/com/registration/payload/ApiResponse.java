package com.registration.payload;

import lombok.*;
import org.springframework.http.HttpStatus;
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {


    private boolean success;
    private String message;
    private HttpStatus status;



}
