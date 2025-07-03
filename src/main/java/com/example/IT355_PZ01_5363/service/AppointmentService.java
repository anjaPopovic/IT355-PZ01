package com.example.IT355_PZ01_5363.service;

import com.example.IT355_PZ01_5363.model.Appointment;
import com.example.IT355_PZ01_5363.model.Client;
import com.example.IT355_PZ01_5363.model.Employee;
import com.example.IT355_PZ01_5363.model.Treatment;
import com.example.IT355_PZ01_5363.repository.DB;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final DB db;

    /**
     * returns a list of employees qualified for given treatment
     * @param treatment name of treatment
     * @return list of employees offering the treatment
     */
    public List<Employee> getEmployeesForTreatment(String treatment){
       return db.getAllEmployees().stream().filter(e -> e.getTreatments().contains(treatment)).collect(Collectors.toList());
    }

    /**
     * retrieves a client by their username
     * @param username client's username
     * @return Optional containing the matching client
     */
    public Optional<Client> getClient(String username){
        return db.getAllClients().stream().filter(c -> c.getUsername().equalsIgnoreCase(username)).findFirst();
    }

    /**
     * retrieves an employee by their name
     * @param name employee's name
     * @return Optional containing the matching employee
     */
    public Optional<Employee> getEmployee(String name){
        return db.getAllEmployees().stream().filter(e -> e.getName().equalsIgnoreCase(name)).findFirst();
    }

    /**
     * adds a new appointment to the DB
     * @param client client booking the appointment
     * @param employee employee chosen to do the treatment
     * @param treatment treatment to be performed
     * @param date date of appointment
     * @param time time of appointment
     */
    public void createAppointment(Client client, Employee employee, Treatment treatment, LocalDate date, LocalTime time){
        Appointment appointment = new Appointment(client, employee, treatment, date, time);
        db.getAllAppointments().add(appointment);
    }

    /**
     *
     * @return list of all appointments
     */
    public List<Appointment> getAllAppointments(){
        return db.getAllAppointments();
    }

    /**
     * returns all appointments scheduled by specific client
     * @param client client whose appointments are requested
     * @return list of appointments belonging to chosen client
     */
    public List<Appointment> getAppointmentsByClient(Client client) {
        return db.getAllAppointments().stream()
                .filter(a -> a.getClient().equals(client))
                .toList();
    }
}
