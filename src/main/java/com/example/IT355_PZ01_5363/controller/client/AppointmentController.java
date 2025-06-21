package com.example.IT355_PZ01_5363.controller.client;

import com.example.IT355_PZ01_5363.model.Client;
import com.example.IT355_PZ01_5363.model.Employee;
import com.example.IT355_PZ01_5363.model.Treatment;
import com.example.IT355_PZ01_5363.service.AppointmentService;
import com.example.IT355_PZ01_5363.service.TreatmentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Controller
public class AppointmentController {
    private final AppointmentService appointmentService;
    private final TreatmentService treatmentService;

    public AppointmentController(AppointmentService appointmentService, TreatmentService treatmentService) {
        this.appointmentService = appointmentService;
        this.treatmentService = treatmentService;
    }

    @GetMapping("/reserve/{treatmentName}")
    public String showReservationForm(@PathVariable String treatmentName, Model model){
        Optional<Treatment> treatment = treatmentService.getTreatmentByName(treatmentName);
        if(treatment.isEmpty()){
            return "redirect:/home";
        }

        List<Employee> availableEmployees = appointmentService.getEmployeesForTreatment(treatmentName);

        model.addAttribute("treatment", treatment.get());
        model.addAttribute("employees", availableEmployees);

        return "client/reservation";
    }

    @PostMapping("/reserve")
    public String handleReservation(@RequestParam String treatmentName, @RequestParam String employeeName, @RequestParam LocalDate date, @RequestParam LocalTime time, HttpSession session){
        String username = (String) session.getAttribute("username");
        if(username == null) return "redirect:/";

        System.out.println(username);
        Optional<Client> chosenClient = appointmentService.getClient(username);
        Optional<Employee> chosenEmployee = appointmentService.getEmployee(employeeName);
        Optional<Treatment> chosenTreatment = treatmentService.getTreatmentByName(treatmentName);

        if(chosenClient.isPresent() && chosenEmployee.isPresent() && chosenTreatment.isPresent()){
            appointmentService.createAppointment(chosenClient.get(), chosenEmployee.get(), chosenTreatment.get(), date, time);
        }

        return "redirect:/confirmation";
    }

    @GetMapping("/confirmation") 
    public String showConfirmation(){
        return "client/confirmation";
    }

}
