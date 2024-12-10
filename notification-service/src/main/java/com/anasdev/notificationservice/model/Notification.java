package com.anasdev.notificationservice.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "notifications")
public class Notification {

    @Id
    private String id; // Unique identifier for the notification

    private Long userId;
    private String message;
    private boolean isRead;
    private String type;  // For example: "delivery", "status-update", etc.
    private String timestamp;

}
