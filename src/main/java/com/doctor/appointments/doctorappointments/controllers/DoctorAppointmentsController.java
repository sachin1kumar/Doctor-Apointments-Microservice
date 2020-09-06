package com.doctor.appointments.doctorappointments.controllers;

import com.doctor.appointments.doctorappointments.model.DoctorAppointments;
import com.doctor.appointments.doctorappointments.repositories.DoctorAppointmentsRepository;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;

@RestController
@RequestMapping("/doctor-appointments")
public class DoctorAppointmentsController {

    @Autowired
    private DoctorAppointmentsRepository doctorAppointmentsRepository;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> setAppointmentFlag(@RequestBody DoctorAppointments doctorAppointments) {
        if (doctorAppointmentsRepository.existsById(doctorAppointments.getId())) {
            //call doctor appointments update microservice..
            final HttpEntity<ObjectNode> requestEntity = new HttpEntity(doctorAppointments);
            restTemplate.exchange("http://doctor-update-appointments-service/doctor-update-appointments/", HttpMethod.PATCH, requestEntity, DoctorAppointments.class);
        } else {
            doctorAppointmentsRepository.save(doctorAppointments);
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }



}
