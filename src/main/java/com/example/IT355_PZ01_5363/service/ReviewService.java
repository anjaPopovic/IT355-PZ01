package com.example.IT355_PZ01_5363.service;

import com.example.IT355_PZ01_5363.model.Review;
import com.example.IT355_PZ01_5363.repository.DB;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {
        private final DB db;

    /**
     * adds a new review to the DB
     * @param review new review to be added
     */
    public void addReview(Review review) {
            db.getAllReviews().add(review);
        }

}
