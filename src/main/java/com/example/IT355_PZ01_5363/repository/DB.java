package com.example.IT355_PZ01_5363.repository;

import com.example.IT355_PZ01_5363.model.*;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
public class DB {

    private final List<Client> allClients = new ArrayList<>();
    private final List<Employee> allEmployees = new ArrayList<>();
    private final List<Treatment> allTreatments = new ArrayList<>();
    private final List<Review> allReviews = new ArrayList<>();
    private final List<Appointment> allAppointments = new ArrayList<>();

    public void addEmployee(Employee employee){
        allEmployees.add(employee);
    }

    public void addTreatment(Treatment treatment){
        allTreatments.add(treatment);
    }
}
