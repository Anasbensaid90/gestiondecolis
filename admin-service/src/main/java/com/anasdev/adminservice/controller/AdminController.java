package com.anasdev.adminservice.controller;
import com.anasdev.adminservice.service.AdminService;
import com.anasdev.gestiondelivraisonservice.model.Livraison;
import com.anasdev.gestiondesutilisateursservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/utilisateurs")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(adminService.getAllUsers());
    }

    @GetMapping("/livraisons")
    public ResponseEntity<List<Livraison>> getAllDeliveries() {
        return ResponseEntity.ok(adminService.getAllDeliveries());
    }

    @GetMapping("/utilisateurs/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return adminService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/livraisons/{id}")
    public ResponseEntity<Livraison> getDeliveryById(@PathVariable Long id) {
        return adminService.getDeliveryById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/utilisateurs/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        adminService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/livraisons/{id}")
    public ResponseEntity<Void> deleteDelivery(@PathVariable Long id) {
        adminService.deleteDelivery(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/utilisateurs/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User updatedUser = adminService.updateUser(id, userDetails);
        return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
    }

    @PutMapping("/livraisons/{id}")
    public ResponseEntity<Livraison> updateDelivery(@PathVariable Long id, @RequestBody Livraison deliveryDetails) {
        Livraison updatedDelivery = adminService.updateDelivery(id, deliveryDetails);
        return updatedDelivery != null ? ResponseEntity.ok(updatedDelivery) : ResponseEntity.notFound().build();
    }
}

