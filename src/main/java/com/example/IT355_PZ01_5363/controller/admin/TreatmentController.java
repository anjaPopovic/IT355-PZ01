package com.example.IT355_PZ01_5363.controller.admin;

import com.example.IT355_PZ01_5363.service.TreatmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TreatmentController {
    private final TreatmentService treatmentService;

    public TreatmentController(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }

    @GetMapping("/admin/treatments")
    public String showTreatmentsAdmin(Model model){
        model.addAttribute("treatments", treatmentService.getAllTreatments());
        return "treatments";
    }

}
