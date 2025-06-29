package com.example.IT355_PZ01_5363.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Treatment {
    private String name;
    private String description;
    private int durationInMin;
    private double price;

    @Override
    public String toString() {
        return name + ',' + ' ' + description;
    }
}
