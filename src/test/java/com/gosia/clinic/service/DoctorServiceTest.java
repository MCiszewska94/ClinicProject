package com.gosia.clinic.service;

import com.gosia.clinic.daos.DoctorDAO;
import com.gosia.clinic.model.Doctor;
import org.aspectj.lang.annotation.AfterReturning;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DoctorServiceTest {

    private static EmbeddedDatabase db;

    @Autowired
    private DoctorService doctorService;

    @BeforeClass
    public static void setUp() {
        db = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("create-table.sql")
                .build();
    }

    @Test
    public void shouldReturnDoctors() {
        Assert.assertNotEquals(doctorService.getAllDoctors().size(), 0);
    }

    @Test
    public void shouldReturnOneDoctorOfIdOne() {
        Integer id = 1;
        Doctor d = new Doctor(id, "Alison", "Austin");
        Assert.assertEquals(doctorService.getDoctorById(id).get(), d);
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
    public void shouldNotDeleteDoctorOfNotExistingId() {
        Assert.assertFalse(doctorService.deleteDoctor(666));
    }

    @AfterClass
    public static void tearDown() {
        db.shutdown();
    }

}