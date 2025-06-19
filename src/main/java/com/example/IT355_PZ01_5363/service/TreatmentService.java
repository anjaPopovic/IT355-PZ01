package com.example.IT355_PZ01_5363.service;

import com.example.IT355_PZ01_5363.model.Treatment;
import com.example.IT355_PZ01_5363.repository.DB;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreatmentService {
    private final DB db;

    public TreatmentService(DB db) {
        this.db = db;
    }

    @PostConstruct
    public void initTreatments() {
       if(db.getAllTreatments().isEmpty()){
           db.addTreatment(new Treatment("Blowdrying", "Short Hair", 30, 1200.0));
           db.addTreatment(new Treatment("Hair Coloring", "Medium Long Hair", 90, 3000.0));
           db.addTreatment(new Treatment("Haircut", "Men's Haircut", 20, 1000.0));
           db.addTreatment(new Treatment("Haircut", "Women's Long Hair", 45, 1800.0));
           db.addTreatment(new Treatment("Highlights", "Partial Foils", 75, 3500.0));
           db.addTreatment(new Treatment("Keratin Treatment", "Full Hair", 120, 6000.0));
           db.addTreatment(new Treatment("Facial", "Deep Cleansing", 60, 2500.0));
           db.addTreatment(new Treatment("Facial", "Anti-Aging", 75, 3200.0));
           db.addTreatment(new Treatment("Manicure", "Classic", 30, 1200.0));
           db.addTreatment(new Treatment("Manicure", "Gel", 45, 1800.0));
           db.addTreatment(new Treatment("Pedicure", "Spa", 60, 2500.0));
           db.addTreatment(new Treatment("Eyebrow Shaping", "Threading", 15, 700.0));
           db.addTreatment(new Treatment("Makeup", "Evening Glam", 60, 4000.0));
           db.addTreatment(new Treatment("Massage", "Relaxing Full Body", 60, 3000.0));
           db.addTreatment(new Treatment("Waxing", "Full Legs", 45, 2200.0));
       }
    }

    public List<Treatment> getAllTreatments(){
        return db.getAllTreatments();
    }
}
