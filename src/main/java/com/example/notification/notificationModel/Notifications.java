package com.example.notification.notificationModel;

import com.example.notification.enums.EntityType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data

@Entity
public class Notifications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date sendingDate;
    private Date sendingTime;
    private String description;
    private Long userEntityId;
    private EntityType entityType ;
    private boolean isRead;


}
