package SOLID_TASK;

public class EmailRenderer implements NotificationRenderer{
    @Override
    public String sendRender(Notification notification) {
        return "[EMAIL] Notification " + notification.getId();
    }
}
