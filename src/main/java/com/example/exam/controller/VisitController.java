package com.example.exam.controller;

import com.example.exam.DTO.VisitDto;
import com.example.exam.model.Visit;
import com.example.exam.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/visit")
public class VisitController {
    @Autowired
    private VisitService visitService;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id){
        VisitDto result = visitService.get(id);
        return ResponseEntity.ok(result);

    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid VisitDto visit){
        VisitDto result = visitService.create(visit);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody @Valid VisitDto visit){
       Boolean result = visitService.update(id,visit);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        Boolean result = visitService.delete(id);
        return ResponseEntity.ok(result);
    }
}
