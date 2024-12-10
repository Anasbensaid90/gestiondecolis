package com.anasdev.notificationservice.controller;
import com.anasdev.notificationservice.model.Notification;
import com.anasdev.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<Notification> createNotification(@RequestParam Long userId,
                                                           @RequestParam String message,
                                                           @RequestParam String type) {
        Notification notification = notificationService.sendNotification(userId, message, type);
        return ResponseEntity.ok(notification);
    }
}
