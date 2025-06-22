package com.example.IT355_PZ01_5363.service;

import com.example.IT355_PZ01_5363.model.Review;
import com.example.IT355_PZ01_5363.repository.DB;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
        private final DB db;

        public ReviewService(DB db) {
            this.db = db;
        }

        public void addReview(Review review) {
            db.getAllReviews().add(review);
        }

}
