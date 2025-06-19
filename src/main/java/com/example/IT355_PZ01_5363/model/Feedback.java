package com.example.IT355_PZ01_5363.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {
    private Client client;
    private Appointment appointment;
    private int rating;
    private String comment;
}
