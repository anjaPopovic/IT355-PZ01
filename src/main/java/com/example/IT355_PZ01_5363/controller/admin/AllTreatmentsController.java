package com.example.IT355_PZ01_5363.controller.admin;

import com.example.IT355_PZ01_5363.model.Treatment;
import com.example.IT355_PZ01_5363.service.TreatmentService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class AllTreatmentsController {
    private final TreatmentService treatmentService;

    @GetMapping("/admin/treatments")
    public String showTreatmentsAdmin(Model model, HttpSession session){
        if(!"ADMIN".equals(session.getAttribute("role"))){
            return "redirect:/";
        }
        model.addAttribute("treatments", treatmentService.getAllTreatments());
        return "admin/treatments";
    }

    @PostMapping("/admin/treatments/deleteTreatment")
    public String handleDeleteTreatment(@RequestParam String name, @RequestParam String description){
        treatmentService.deleteTreatment(name, description);
        return "redirect:/admin/treatments";
    }

    @GetMapping("/admin/treatments/editTreatment")
    public String showEditTreatmentForm(@RequestParam String name, Model model){
        Optional<Treatment> treatment = treatmentService.getTreatmentByName(name);
        if(treatment.isPresent()){
            model.addAttribute("treatment", treatment.get());
            return "admin/editTreatments";
        }
        return "redirect:/admin/treatments";
    }

    @PostMapping("/admin/treatments/editTreatment")
public String handleEditTreatment(@RequestParam String originalName, @RequestParam String name, @RequestParam String description, @RequestParam int durationInMin, @RequestParam double price){
        treatmentService.editTreatment(originalName, new Treatment(name, description, durationInMin, price));
        return "redirect:/admin/treatments";
    }

    @PostMapping("/admin/treatments/addTreatment")
    public String handleAddTreatment(@RequestParam String name, @RequestParam String description, @RequestParam int durationInMin, @RequestParam double price){
        Treatment treatment = new Treatment(name, description, durationInMin, price);
        treatmentService.addTreatment(treatment);
        return "redirect:/admin/treatments";
    }
}
