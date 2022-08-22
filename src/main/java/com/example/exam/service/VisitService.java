package com.example.exam.service;

import com.example.exam.DTO.VisitDto;
import com.example.exam.exception.BadRequest;
import com.example.exam.model.Visit;
import com.example.exam.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class VisitService {
    @Autowired
    private VisitRepository visitRepository;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PatientService patientService;

    public VisitDto create(VisitDto dto) {
        Visit visit = new Visit();
        visit.setDoctorId(dto.getDoctorId());
        visit.setPatientId(dto.getPatientId());
        visit.setCreatedAt(LocalDateTime.now());
        visit.setStatus(true);
        visitRepository.save(visit);
        return dto;

    }

    public VisitDto get(Integer id) {
        Visit visit = getEntity(id);
        VisitDto visitDto = new VisitDto();
        visitDto.setPatient(patientService.get(visitDto.getPatientId()));
        visitDto.setDoctor(doctorService.get(visitDto.getDoctorId()));
        visitDto.setDiagnosis(visit.getDiagnosis());
        return visitDto;

    }

    public Visit getEntity(Integer id) {
        Optional<Visit> optional = visitRepository.findById(id);
        if (optional.isEmpty()) {
            throw new BadRequest("Visit not found");
        }
        return optional.get();
    }

    public boolean update(Integer id, VisitDto dto) {
        Visit visit = getEntity(id);
        visit.setDoctorId(dto.getDoctorId());
        visit.setPatientId(dto.getPatientId());
        visit.setDiagnosis(dto.getDiagnosis());
        visitRepository.save(visit);
        return true;

    }


    public boolean delete(Integer id) {
        Visit visit = getEntity(id);
        visitRepository.delete(visit);
        return true;

    }


}
