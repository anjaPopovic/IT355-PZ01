package com.example.IT355_PZ01_5363.controller.admin;

import com.example.IT355_PZ01_5363.service.EmployeeService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AllEmployeesController {
    private final EmployeeService employeeService;

    @GetMapping("/admin/employees")
    public String showEmployees(Model model, HttpSession session){
        if(!"ADMIN".equals(session.getAttribute("role"))){
            return "redirect:/";
        }
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "admin/employees";
    }
}
