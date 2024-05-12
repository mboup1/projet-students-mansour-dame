package com.mansourdame.student.dto;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class StudentDTO {

    @NotBlank(message = "firstName required")
    private String firstName;

    @NotBlank(message = "lastName required")
    private String lastName;

    @Email(message = "Invalid email format")
    private String email;
}
