package com.example.exam.repository;

import com.example.exam.model.Doctor;
import com.example.exam.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>{

}
