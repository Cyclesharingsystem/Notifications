package com.example.notification.notificationService;

import com.example.notification.notificationModel.Notifications;
import com.example.notification.notificationRepository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.Optional;

@Service
public class NotificationService {
    @Autowired
    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public Notifications saveNotification(Notifications notification) {
        return notificationRepository.save(notification);
    }

    public List<Notifications> getNotificationsByUserId(Long userId) {
        return notificationRepository.findByUserEntityId(userId);
    }

    public Optional<Notifications> getNotificationById(Long notificationId) {
        return notificationRepository.findById(notificationId);
    }

    public void markNotificationAsRead(Long notificationId) {
        Optional<Notifications> optionalNotification = notificationRepository.findById(notificationId);
        optionalNotification.ifPresent(notification -> {
            notification.setRead(true);
            notificationRepository.save(notification);
        });
    }
}