package com.anasdev.servicedesuividelivraisonsservice.dto;

public class PositionDTO {
    private String vehicleId;
    private double latitude;
    private double longitude;

    // Getters et Setters
    public String getVehicleId() { return vehicleId; }
    public void setVehicleId(String vehicleId) { this.vehicleId = vehicleId; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }
}
