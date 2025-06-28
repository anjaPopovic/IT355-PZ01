package com.example.IT355_PZ01_5363.controller.admin;

import com.example.IT355_PZ01_5363.service.AppointmentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AllAppointmentsController {
    private final AppointmentService appointmentService;

    public AllAppointmentsController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/admin/appointments")
    public String showAppointments(Model model, HttpSession session){
        if (!"ADMIN".equals(session.getAttribute("role"))) {
            return "redirect:/";
        }
        model.addAttribute("appointments", appointmentService.getAllAppointments());
        return "admin/allAppointments";
    }
}
