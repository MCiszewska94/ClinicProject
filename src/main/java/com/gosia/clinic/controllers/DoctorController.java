package com.gosia.clinic.controllers;

import com.gosia.clinic.model.Doctor;
import com.gosia.clinic.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DoctorController {
    private DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @RequestMapping(name = "/doctors", method = RequestMethod.GET)
    public List<Doctor> getAll() {
        return doctorService.getAllDoctors();
    }

    @RequestMapping("/doctors/{doctorId}")
    public ResponseEntity<Doctor> getById(@PathVariable Integer doctorId) {
        Optional<Doctor> doctorById = doctorService.getDoctorById(doctorId);
        return doctorById
                .map(doctor -> new ResponseEntity<>(doctor, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(name = "/doctors", method = RequestMethod.POST)
    public ResponseEntity addDoctor(@RequestBody Doctor d) {
        if (doctorService.addDoctor(d)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(name = "/doctors/{doctorId}", method = RequestMethod.PUT)
    public ResponseEntity updateDoctor(@PathVariable Integer doctorId, @RequestBody Doctor d) {
        if (doctorService.updateDoctor(doctorId, d)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(name = "/doctors/{doctorId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteDoctor(@PathVariable Integer doctorId) {
        if (doctorService.deleteDoctor(doctorId)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
