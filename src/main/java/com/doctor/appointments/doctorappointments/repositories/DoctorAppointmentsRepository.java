package com.doctor.updater.registration.updaterdoctorregistration.repositories;

import com.doctor.updater.registration.updaterdoctorregistration.models.DoctorDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface DoctorDetailsRepository extends JpaRepository<DoctorDetails, BigInteger> {
}
