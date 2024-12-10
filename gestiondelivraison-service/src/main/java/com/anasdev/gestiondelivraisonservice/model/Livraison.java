package com.anasdev.gestiondelivraisonservice.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Data // Lombok will automatically generate getters and setters
@NoArgsConstructor
@AllArgsConstructor
public class Livraison {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String destination;
    private String status;
    private Date createdAt; // Ensure this field is of type Date
    private Date updatedAt; // Ensure this field is of type Date
    private String deliveryPerson;

}
