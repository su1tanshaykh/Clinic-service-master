package com.example.exam.service;

import com.example.exam.DTO.PatientDto;
import com.example.exam.exception.BadRequest;
import com.example.exam.model.Patient;
import com.example.exam.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;


    public PatientDto create(PatientDto patientDto) {
        Patient patient = new Patient();
        patientDto.setId(patient.getId());
        convertDtoToEntity(patientDto,patient);
        patient.setStatus(true);
        patient.setCreatedAt(LocalDateTime.now());
        patientRepository.save(patient);
        return patientDto;
    }

    public PatientDto get(Integer id) {
        Patient patient = getEntity(id);
        PatientDto patientDto = new PatientDto();
        convertDtoToEntity(patientDto, patient);
        return patientDto;
    }



    public boolean update(Integer id, Patient patient) {
        Patient update = getEntity(id);
        update.setUpdatedAt(LocalDateTime.now());
        patientRepository.save(update);
        return true;

    }
    public void convertDtoToEntity(PatientDto dto, Patient entity) {
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setBirthday(dto.getBirthday());
        entity.setAge(LocalDate.now().getYear() - dto.getBirthday().getYear());
        entity.setContact(dto.getContact());
    }

    public boolean delete(Integer id) {
        Patient patient = getEntity(id);
        patient.setDeletedAt(LocalDateTime.now());
        patientRepository.delete(patient);
        return true;
    }

    public Patient getEntity(Integer id) {
        Optional<Patient> optional = patientRepository.findById(id);
        if (optional.isEmpty()) {
            throw new BadRequest("Doctor not found");
        }
        return optional.get();
    }

    public List<Patient> findAll(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Patient> resultPage = patientRepository.findAll(pageable);
        List<Patient> response = new LinkedList<>();
        for (Patient patient : resultPage) {
            if (patient.getDeletedAt() == null) {
                Patient dto = new Patient();
                response.add(dto);
            }
        }
        return response;
}


}




