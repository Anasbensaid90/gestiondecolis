package com.anasdev.servicedesuividelivraisonsservice.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Suivi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long livraisonId;  // ID of the associated delivery
    private String status;     // Current status of the delivery
    private String location;   // Current location (can be formatted as "lat,lng" or a city name)
    private Date updatedAt;    // Last update timestamp
}
