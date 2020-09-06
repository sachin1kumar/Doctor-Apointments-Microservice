package com.doctor.updater.registration.updaterdoctorregistration.controllers;

import com.doctor.updater.registration.updaterdoctorregistration.models.DoctorDetails;
import com.doctor.updater.registration.updaterdoctorregistration.repositories.DoctorDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.math.BigInteger;

@RestController
@RequestMapping("/update-registration")
public class DoctorDetailsController {

    @Autowired
    private DoctorDetailsRepository doctorDetailsRepository;

    @RequestMapping(value = "/doctor/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateRegisteredDoctor(@PathVariable BigInteger id, @RequestBody DoctorDetails doctorDetails) {
        DoctorDetails currentDoctorDetails = doctorDetailsRepository.findById(id).get();
        currentDoctorDetails.setName(doctorDetails.getName());
        currentDoctorDetails.setClinic_name(doctorDetails.getClinic_name());
        currentDoctorDetails.setAddress(doctorDetails.getAddress());
        currentDoctorDetails.setFees(doctorDetails.getFees());
        currentDoctorDetails.setTiming(doctorDetails.getTiming());
        currentDoctorDetails.setRegistration_date(doctorDetails.getRegistration_date());
        currentDoctorDetails.setEmail_id(doctorDetails.getEmail_id());
        currentDoctorDetails.setPassword(doctorDetails.getPassword());
        doctorDetailsRepository.save(currentDoctorDetails);
        return ResponseEntity.status(HttpStatus.OK).build();
    }



}
