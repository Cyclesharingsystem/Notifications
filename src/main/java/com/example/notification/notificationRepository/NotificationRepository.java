package com.example.notification.notificationRepository;

import com.example.notification.notificationModel.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notifications, Long> {

    List<Notifications> findByUserEntityId(Long userId);
}
