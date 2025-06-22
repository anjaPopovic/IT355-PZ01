package com.example.IT355_PZ01_5363.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    private Client client;
    private String content;
    private int rating;
}
