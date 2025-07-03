package com.example.IT355_PZ01_5363.controller.client;

import com.example.IT355_PZ01_5363.model.Client;
import com.example.IT355_PZ01_5363.model.Review;
import com.example.IT355_PZ01_5363.service.ClientService;
import com.example.IT355_PZ01_5363.service.ReviewService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;
    private final ClientService clientService;

    @GetMapping("/reviews")
    public String showReviewForm(Model model){
        model.addAttribute("review", new Review());
        return "client/reviewForm";
    }

    @PostMapping("/reviews")
    public String handleReviews(@RequestParam("content") String content, @RequestParam("rating") int rating, HttpSession session) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/";
        }

        Client client = clientService.findClientByUsername(username);
        if (client == null) {
            return "redirect:/";
        }

        Review review = new Review(client, content, rating);
        reviewService.addReview(review);
        return "redirect:/home?success";
    }
}
