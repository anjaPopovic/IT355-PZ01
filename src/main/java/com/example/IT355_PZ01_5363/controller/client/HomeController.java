package com.example.IT355_PZ01_5363.controller.client;


import com.example.IT355_PZ01_5363.service.EmployeeService;
import com.example.IT355_PZ01_5363.service.TreatmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final EmployeeService employeeService;

    private final TreatmentService treatmentService;

    public HomeController(EmployeeService employeeService, TreatmentService treatmentService) {
        this.employeeService = employeeService;
        this.treatmentService = treatmentService;
    }

    @GetMapping("/home")
    public String showHome(Model model){
        model.addAttribute("treatments", treatmentService.getAllTreatments());
        return "client/home";
    }

}
