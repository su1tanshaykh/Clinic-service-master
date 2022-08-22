package com.example.exam.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.swing.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
public class DoctorDto {
    private Integer id;
    @NotBlank(message = ("Name Error and it must not be empty or null"))
    private String name;
    @NotBlank(message = ("Surname Error and it must not be empty or null"))
    private String surname;
    @NotBlank(message = ("Direction error and it must not be empty or null"))
    private String direction;
    @Size(min =9 , message = "only uzbekistan's phone numbers")
    private String contact;
    private Integer experience;
    private Boolean status;


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
