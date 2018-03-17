package com.gosia.clinic.service;

import com.gosia.clinic.model.Doctor;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql( scripts = "classpath:create-table.sql")
public class DoctorServiceTest {


    @Autowired
    private DoctorService doctorService;



    @Test
    public void shouldReturnDoctors() {
        Assert.assertNotEquals(doctorService.getAllDoctors().size(), 0);
    }

    @Test
    public void shouldReturnOneDoctorOfIdOne() {
        Integer id = 1;
        Doctor d = new Doctor(id, "Alison", "Austin");
        if (doctorService.getDoctorById(id).isPresent()) {
            Assert.assertEquals(doctorService.getDoctorById(id).get(), d);
        }
    }

    @Test
    public void shouldNotReturnDoctor() {
        Integer id = 0;
        Assert.assertEquals(doctorService.getDoctorById(id), Optional.empty());
    }


    @Test
    public void shouldAddDoctor() {
        Doctor d = new Doctor("Garry", "McLauren");
        Assert.assertTrue(doctorService.addDoctor(d));
    }

    @Test
    public void shouldUpdateDoctorOfIdOne() {
        Doctor d = new Doctor("Alison", "Apple");
        Assert.assertTrue(doctorService.updateDoctor(1, d));
    }

    @Test
    public void shouldNotUpdateDoctor() {
        Doctor d = new Doctor("Alison", "Apple");
        Assert.assertFalse(doctorService.updateDoctor(666, d));
    }

    @Test
    public void shouldDeleteDoctorOfIdFive() {
        Integer id = 5;
        Assert.assertTrue(doctorService.deleteDoctor(id));
    }

    @Test
    public void shouldNotDeleteDoctorOfNotExistingId() {
        Assert.assertFalse(doctorService.deleteDoctor(666));
    }


}