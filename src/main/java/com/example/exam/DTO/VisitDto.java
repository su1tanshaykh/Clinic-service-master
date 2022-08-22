package com.example.exam.DTO;

import com.example.exam.model.Doctor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter

public class VisitDto {
    private Integer patientId;
    private Doctor doctor;
    private Integer doctorId;
    @NotBlank(message = ("there is no diagnosis"))
    private String diagnosis;
    private Boolean status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    private PatientDto patient;
}
