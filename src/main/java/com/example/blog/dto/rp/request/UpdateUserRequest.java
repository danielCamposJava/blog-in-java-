package com.example.blog.dto.rp.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UpdateUserRequest {

    @NotBlank String password;
    @Size(min = 3, max = 20)
    String confirmPassword;
    @Size(min = 3, max = 20)
    String confirmPassword2;
}
