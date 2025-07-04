package com.example.IT355_PZ01_5363.controller.client;

import com.example.IT355_PZ01_5363.service.TreatmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class TreatmentController {
    private final TreatmentService treatmentService;

    @GetMapping("/treatments")
    public String showHome(Model model){
        model.addAttribute("treatments", treatmentService.getAllTreatments());
        return "client/treatmentForm";
    }
}
