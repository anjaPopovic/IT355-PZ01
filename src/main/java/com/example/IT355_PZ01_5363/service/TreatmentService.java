package com.example.IT355_PZ01_5363.service;

import com.example.IT355_PZ01_5363.model.Treatment;
import com.example.IT355_PZ01_5363.repository.DB;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TreatmentService {
    private final DB db;

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

    /**
     * returns the list of all treatments
     * @return list of treatments
     */
    public List<Treatment> getAllTreatments(){
        return db.getAllTreatments();
    }

    /**
     * finds a treatment by its name
     * @param name name of treatment
     * @return Optional containing treatment if found, or empty if not
     */
    public Optional<Treatment> getTreatmentByName(String name){
        return db.getAllTreatments().stream().filter(t -> t.getName().equalsIgnoreCase(name)).findFirst();
    }

    /**
     * deletes a treatment based on its name and description (description also because of the same name of treatments)
     * @param name treatment name
     * @param description treatment description
     */
    public void deleteTreatment(String name, String description){
        db.getAllTreatments().removeIf(t -> t.getName().equalsIgnoreCase(name) && t.getDescription().equalsIgnoreCase(description));
    }

    /**
     * edits an existing treatment by replacing it with a new one
     * @param originalName name of treatment to be replaced
     * @param treatment new name of treatment
     */
    public void editTreatment(String originalName, Treatment treatment){
        for(int i = 0; i < db.getAllTreatments().size(); i++){
            if(db.getAllTreatments().get(i).getName().equalsIgnoreCase(originalName)){
                db.getAllTreatments().set(i, treatment);
                return;
            }
        }
    }

    /**
     * add a new treatment to the DB
     * @param treatment new treatment to be added
     */
    public void addTreatment(Treatment treatment){
        db.addTreatment(treatment);
    }
}
