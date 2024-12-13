package com.anasdev.servicedesuividelivraisonsservice.controller;

import com.anasdev.servicedesuividelivraisonsservice.model.Position;
import com.anasdev.servicedesuividelivraisonsservice.dto.PositionDTO;
import com.anasdev.servicedesuividelivraisonsservice.repository.PositionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/positions")
public class PositionController {

    @Autowired
    private PositionRepository positionRepository;

    @PostMapping("/update")
    public ResponseEntity<String> updatePosition(@RequestBody PositionDTO positionDTO) {
        try {
            Position position = new Position();
            position.setVehicleId(positionDTO.getVehicleId());
            position.setLatitude(positionDTO.getLatitude());
            position.setLongitude(positionDTO.getLongitude());
            position.setTimestamp(System.currentTimeMillis());

            positionRepository.save(position);

            return ResponseEntity.ok("Position mise à jour !");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erreur : " + e.getMessage());
        }
    }
}
