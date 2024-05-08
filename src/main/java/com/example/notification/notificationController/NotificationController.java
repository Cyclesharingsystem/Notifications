package com.example.notification.notificationController;

import com.example.notification.notificationModel.Notifications;
import com.example.notification.notificationService.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
    @Autowired
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/")
    public Notifications sendNotification(@RequestBody Notifications notification) {
        return notificationService.saveNotification(notification);
    }

    @GetMapping("/{userId}")
    public List<Notifications> getNotificationsByUserId(@PathVariable Long userId) {
        return notificationService.getNotificationsByUserId(userId);
    }

    @GetMapping("/{notificationId}")
    public Optional<Notifications> getNotificationById(@PathVariable Long notificationId) {
        return notificationService.getNotificationById(notificationId);
    }

    @PutMapping("/{notificationId}/read")
    public void markNotificationAsRead(@PathVariable Long notificationId) {
        notificationService.markNotificationAsRead(notificationId);
    }
}
