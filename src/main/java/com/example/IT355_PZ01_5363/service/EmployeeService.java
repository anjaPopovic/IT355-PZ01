package com.example.IT355_PZ01_5363.service;

import com.example.IT355_PZ01_5363.model.Employee;
import com.example.IT355_PZ01_5363.repository.DB;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final DB db;

    @PostConstruct
    public void initEmployees() {
        if (db.getAllEmployees().isEmpty()) {
            db.addEmployee(new Employee("Annie Ryan", "Hairdresser", List.of("Blowdrying", "Hair Coloring")));
            db.addEmployee(new Employee("Henry Black", "Hairdresser", List.of("Balayage", "Hair Dyeing")));
            db.addEmployee(new Employee("Sophia Lee", "Hairdresser", List.of("Haircut", "Blowdrying", "Hair Coloring")));
            db.addEmployee(new Employee("Daniel Kim", "Color Specialist", List.of("Hair Coloring", "Highlights", "Balayage")));
            db.addEmployee(new Employee("Olivia White", "Facialist", List.of("Facial", "Anti-Aging", "Deep Cleansing")));
            db.addEmployee(new Employee("Isabella Brown", "Nail Technician", List.of("Manicure", "Pedicure", "Gel Manicure")));
            db.addEmployee(new Employee("Emily Johnson", "Massage Therapist", List.of("Massage", "Relaxing Full Body")));
            db.addEmployee(new Employee("Grace Evans", "Makeup Artist", List.of("Makeup", "Evening Glam")));
            db.addEmployee(new Employee("Mia Thompson", "Waxing Specialist", List.of("Waxing", "Full Legs")));
            db.addEmployee(new Employee("Chloe Adams", "Threading Specialist", List.of("Eyebrow Shaping", "Threading")));
            db.addEmployee(new Employee("Lily Carter", "Hairdresser", List.of("Haircut", "Highlights", "Keratin Treatment")));
            db.addEmployee(new Employee("Noah Scott", "Hairdresser", List.of("Haircut", "Beard Trim", "Blowdrying")));
            db.addEmployee(new Employee("Ethan Moore", "Massage Therapist", List.of("Massage", "Deep Tissue")));
            db.addEmployee(new Employee("Charlotte Taylor", "Manicurist", List.of("Classic Manicure", "Gel Manicure")));
            db.addEmployee(new Employee("Ava Walker", "Facialist", List.of("Facial", "Deep Cleansing", "Anti-Aging")));
        }
    }

    /**
     *
     * @return the list of all employees
     */
    public List<Employee> getAllEmployees(){
        return db.getAllEmployees();
    }

}
