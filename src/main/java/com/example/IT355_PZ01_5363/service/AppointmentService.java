package com.example.IT355_PZ01_5363.service;

import com.example.IT355_PZ01_5363.model.Appointment;
import com.example.IT355_PZ01_5363.model.Client;
import com.example.IT355_PZ01_5363.model.Employee;
import com.example.IT355_PZ01_5363.model.Treatment;
import com.example.IT355_PZ01_5363.repository.DB;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppointmentService {
    private final DB db;

    public AppointmentService(DB db) {
        this.db = db;
    }

    //to select treatment
    public Optional<Treatment> getTreatmentByName(String name){
        return db.getAllTreatments().stream().filter(t -> t.getName().equalsIgnoreCase(name)).findFirst();
    }

    //to get all employees for chosen treatment
    public List<Employee> getEmployeesForTreatment(String treatment){
       return db.getAllEmployees().stream().filter(e -> e.getTreatments().contains(treatment)).collect(Collectors.toList());
    }

    //to get name of client
    public Optional<Client> getClient(String username){
        return db.getAllClients().stream().filter(c -> c.getUsername().equalsIgnoreCase(username)).findFirst();
    }

    //to get name of employee chosen
    public Optional<Employee> getEmployee(String name){
        return db.getAllEmployees().stream().filter(e -> e.getName().equalsIgnoreCase(name)).findFirst();
    }

    public void createAppointment(Client client, Employee employee, Treatment treatment, LocalDate date, LocalTime time){
        Appointment appointment = new Appointment(client, employee, treatment, date, time);
        db.getAllAppointments().add(appointment);
    }
}
