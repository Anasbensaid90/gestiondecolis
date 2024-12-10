package com.anasdev.servicedesuividelivraisonsservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

@Service
public class InfluxDBService {

    private final InfluxDBClient influxDBClient;

    // Constructor injection for the InfluxDB client
    public InfluxDBService(@Value("${influxdb.url}") String url,
                           @Value("${influxdb.token}") String token,
                           @Value("${influxdb.org}") String org,
                           @Value("${influxdb.bucket}") String bucket) {
        this.influxDBClient = InfluxDBClient.create(url, token.toCharArray(), org, bucket);
    }

    public void saveTrackingData(Long livraisonId, String status, String location) {
        // Create a point to write
        Point point = Point.measurement("livraison_tracking")
                .addTag("livraison_id", String.valueOf(livraisonId))  // Add a tag for livraison ID
                .addField("status", status)  // Add field for status
                .addField("location", location)  // Add field for location
                .time(Instant.now(), TimeUnit.MILLISECONDS);  // Add current timestamp

        // Write data to InfluxDB
        try (WriteApi writeApi = influxDBClient.getWriteApi()) {
            writeApi.writePoint(point);
        }
    }
}
