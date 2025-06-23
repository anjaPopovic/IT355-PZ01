package com.example.IT355_PZ01_5363.controller.admin;

import com.example.IT355_PZ01_5363.model.Treatment;
import com.example.IT355_PZ01_5363.service.TreatmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;

@Controller
public class AllTreatmentsController {
    private final TreatmentService treatmentService;

    public AllTreatmentsController(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }

    @GetMapping("/admin/treatments")
    public String showTreatmentsAdmin(Model model){
        model.addAttribute("treatments", treatmentService.getAllTreatments());
        return "admin/treatments";
    }

    //to delete treatment
    @PostMapping("/admin/treatments/deleteTreatment")
    public String handleDeleteTreatment(@RequestParam String name, @RequestParam String description){
        treatmentService.deleteTreatment(name, description);
        return "redirect:/admin/treatments";
    }

    //to edit treatment
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

    //to add treatment
    @PostMapping("/admin/treatments/addTreatment")
    public String handleAddTreatment(@RequestParam String name, @RequestParam String description, @RequestParam int durationInMin, @RequestParam double price){
        Treatment treatment = new Treatment(name, description, durationInMin, price);
        treatmentService.addTreatment(treatment);
        return "redirect:/admin/treatments";
    }

}
