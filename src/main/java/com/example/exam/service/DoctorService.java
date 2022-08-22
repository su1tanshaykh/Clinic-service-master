package com.example.exam.service;

import com.example.exam.DTO.DoctorDto;
import com.example.exam.DTO.PatientDto;
import com.example.exam.exception.BadRequest;
import com.example.exam.model.Doctor;
import com.example.exam.model.Patient;
import com.example.exam.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public DoctorDto create(DoctorDto dto) {
        Doctor doctor = new Doctor();
        doctor.setName(dto.getName());
        doctor.setSurname(dto.getSurname());
        doctor.setDirection(dto.getDirection());
        doctor.setContact(dto.getContact());
        doctor.setExperience(dto.getExperience());
        doctor.setStatus(true);
        doctorRepository.save(doctor);
        return dto;
    }

    public Doctor get(Integer id) {
        Optional<Doctor> optional=doctorRepository.findById(id);
        if (optional.isEmpty()){
            throw new BadRequest("Doctor is not found");
        }

        return optional.get();
    }


    public boolean  update(Integer id, Doctor doctor) {
        Doctor update = getEntity(id);
        update.setName(doctor.getName());
        update.setSurname(doctor.getSurname());
        update.setContact(doctor.getContact());
        update.setDirection(doctor.getDirection());
        update.setExperience(doctor.getExperience());
        update.setUpdatedAt(LocalDateTime.now());
        doctorRepository.save(update);
        return true;
    }

    public boolean delete(Integer id) {
        Doctor doctor = getEntity(id);
        doctorRepository.delete(doctor);
        return true;
    }

    public Doctor getEntity(Integer id) {
        Optional<Doctor> optional = doctorRepository.findById(id);
        if (optional.isEmpty()){
            throw new BadRequest("Doctor not found");
        }
        return optional.get();

    }

}
