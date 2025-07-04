package com.example.IT355_PZ01_5363.controller.admin;

import com.example.IT355_PZ01_5363.repository.DB;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AllReviewsController {
    private final DB db;

    @GetMapping("/admin/reviews")
    public String showReviews(Model model, HttpSession session){
        if(!"ADMIN".equals(session.getAttribute("role"))){
            return "redirect:/";
        }
        model.addAttribute("reviews", db.getAllReviews());
        return "admin/reviews";
    }
}
