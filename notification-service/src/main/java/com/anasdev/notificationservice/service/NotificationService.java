package com.anasdev.notificationservice.service;
import com.anasdev.notificationservice.model.Notification;
import com.anasdev.notificationservice.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public Notification sendNotification(Long userId, String message, String type) {
        Notification notification = new Notification();
        notification.setUserId(userId);
        notification.setMessage(message);
        notification.setRead(false);
        notification.setType(type);
        notification.setTimestamp(LocalDateTime.now().toString());

        return notificationRepository.save(notification);
    }
}
