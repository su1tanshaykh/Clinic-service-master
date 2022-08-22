package com.example.exam.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter

public class PatientDto {

    private Integer id;
    @NotBlank(message = ("Error! It must not be null or empty"))
    private String name;
    @NotBlank(message = ("Error! It must not be null or empty"))
    private String surname;

    private LocalDate birthday;
    @NotBlank(message = ("Error! It must not be null or empty"))
    private String contact;
    @NotBlank(message = ("Error! It must not be null or empty"))
    private Integer age;

    private Boolean status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
