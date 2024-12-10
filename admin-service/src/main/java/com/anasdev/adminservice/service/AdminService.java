package com.anasdev.adminservice.service;
import com.anasdev.gestiondelivraisonservice.model.Livraison;
import com.anasdev.gestiondelivraisonservice.repository.LivraisonRepository;
import com.anasdev.gestiondesutilisateursservice.model.User;
import com.anasdev.gestiondesutilisateursservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final UserRepository userRepository;
    private final LivraisonRepository livraisonRepository;

    @Autowired
    public AdminService(UserRepository userRepository, LivraisonRepository livraisonRepository) {
        this.userRepository = userRepository;
        this.livraisonRepository = livraisonRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<Livraison> getAllDeliveries() {
        return livraisonRepository.findAll();
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public Optional<Livraison> getDeliveryById(Long deliveryId) {
        return livraisonRepository.findById(deliveryId);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public void deleteDelivery(Long deliveryId) {
        livraisonRepository.deleteById(deliveryId);
    }

    public User updateUser(Long userId, User userDetails) {
        if (userRepository.existsById(userId)) {
            userDetails.setId(userId);
            return userRepository.save(userDetails);
        }
        return null;
    }

    public Livraison updateDelivery(Long deliveryId, Livraison deliveryDetails) {
        if (livraisonRepository.existsById(deliveryId)) {
            deliveryDetails.setId(deliveryId);
            return livraisonRepository.save(deliveryDetails);
        }
        return null;
    }
}

