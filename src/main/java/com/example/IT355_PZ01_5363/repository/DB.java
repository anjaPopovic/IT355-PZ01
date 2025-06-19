package com.example.IT355_PZ01_5363.repository;

import com.example.IT355_PZ01_5363.model.*;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
public class DB {

    private List<Client> allClients = new ArrayList<>();
    private List<Employee> allEmployees = new ArrayList<>();
    private List<Treatment> allTreatments = new ArrayList<>();
    private List<Feedback> allFeedbacks = new ArrayList<>();
    private List<Appointment> allAppointments = new ArrayList<>();

    public void addEmployee(Employee employee){
        allEmployees.add(employee);
    }

    public void addTreatment(Treatment treatment){
        allTreatments.add(treatment);
    }
}
