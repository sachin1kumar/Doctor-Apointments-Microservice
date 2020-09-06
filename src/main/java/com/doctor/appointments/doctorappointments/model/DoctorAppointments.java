package com.doctor.appointments.doctorappointments.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;

@Entity(name = "doctor_appointments")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class DoctorAppointments {

    @Id
    private BigInteger id;
    private boolean enable_disable;
    private BigInteger appointment_limit;
    private BigInteger next_appointment_limit;
    private String today_date;

    public DoctorAppointments() {

    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public boolean isEnable_disable() {
        return enable_disable;
    }

    public void setEnable_disable(boolean enable_disable) {
        this.enable_disable = enable_disable;
    }

    public BigInteger getAppointment_limit() {
        return appointment_limit;
    }

    public void setAppointment_limit(BigInteger appointment_limit) {
        this.appointment_limit = appointment_limit;
    }

    public BigInteger getNext_appointment_limit() {
        return next_appointment_limit;
    }

    public void setNext_appointment_limit(BigInteger next_appointment_limit) {
        this.next_appointment_limit = next_appointment_limit;
    }

    public String getToday_date() {
        return today_date;
    }

    public void setToday_date(String today_date) {
        this.today_date = today_date;
    }
}
