package SOLID_TASK;

public class AlertNotificationProcessor implements  NotificationProcessor {
    private  NotificationDeliverService _notificationDeliverService;

    @Override
    public void process(Notification notification) {
        if (notification.getType().equals("ALERT")) {
            if (notification.getPriority() == null) {
                throw new IllegalArgumentException("Alerts require priority");
            }
        }
        _notificationDeliverService.deliver(notification);
    }
}
