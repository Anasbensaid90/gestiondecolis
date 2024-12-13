package com.anasdev.servicedesuividelivraisonsservice.service;

import com.anasdev.servicedesuividelivraisonsservice.model.Position;
import com.anasdev.servicedesuividelivraisonsservice.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionService {

    @Autowired
    private PositionRepository positionRepository;

    public void updatePosition(String vehicleId, double latitude, double longitude) {
        Position position = new Position();
        position.setVehicleId(vehicleId);
        position.setLatitude(latitude);
        position.setLongitude(longitude);
        position.setTimestamp(System.currentTimeMillis());

        positionRepository.save(position);
    }
}
