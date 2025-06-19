package com.example.IT355_PZ01_5363.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private String name;
    private String specialization;
    private List<String> treatments;
}
