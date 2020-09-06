package com.doctor.appointments.doctorappointments.controllers;

import com.doctor.appointments.doctorappointments.model.DoctorAppointments;
import com.doctor.appointments.doctorappointments.repositories.DoctorAppointmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/doctor-appointments")
public class DoctorAppointmentsController {

    @Autowired
    private DoctorAppointmentsRepository doctorAppointmentsRepository;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> setAppointmentFlag(@RequestBody DoctorAppointments doctorAppointments) {
        if (doctorAppointmentsRepository.existsById(doctorAppointments.getId())) {
            //call doctor appointments microservice..
        } else {
            doctorAppointmentsRepository.save(doctorAppointments);
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }



}
