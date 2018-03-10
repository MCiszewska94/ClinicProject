package com.gosia.clinic.service;

import com.gosia.clinic.daos.DoctorDAO;
import com.gosia.clinic.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    private DoctorDAO doctorDAO;

    @Autowired
    public DoctorService(DoctorDAO doctorDAO) {
        this.doctorDAO = doctorDAO;
    }

    public List<Doctor> getAllDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        doctorDAO.findAll().forEach(doctors::add);
        return doctors;
    }

    public Optional<Doctor> getDoctorById(Integer id) {
        return doctorDAO.findById(id);
    }

    public boolean addDoctor(Doctor d) {
        try {
            doctorDAO.save(d);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateDoctor(Integer doctorId, Doctor d) {
        if (getDoctorById(doctorId).isPresent()) {
            doctorDAO.save(d);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteDoctor(Integer id) {
        try {
            doctorDAO.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
