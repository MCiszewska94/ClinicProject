package com.gosia.clinic.daos;

import com.gosia.clinic.model.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorDAO extends CrudRepository<Doctor, Integer> {
}
