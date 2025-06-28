package com.example.IT355_PZ01_5363.controller.admin;

import com.example.IT355_PZ01_5363.service.EmployeeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/admin/employees")
    public String showEmployees(Model model, HttpSession session){
        if(!"ADMIN".equals(session.getAttribute("role"))){
            return "redirect:/";
        }
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "admin/employees";
    }


}
