package com.example.exam.controller;

import com.example.exam.DTO.DoctorDto;
import com.example.exam.model.Doctor;
import com.example.exam.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid DoctorDto doctor){
        DoctorDto result = doctorService.create(doctor);
        return ResponseEntity.ok(result);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {
        Doctor result = doctorService.get(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody @Valid Doctor doctor){
        boolean result = doctorService.update(id,doctor);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        Boolean result = doctorService.delete(id);
        return ResponseEntity.ok(result);
    }

}
