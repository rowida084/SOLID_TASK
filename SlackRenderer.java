package SOLID_TASK;

public class SlackRenderer implements NotificationRenderer{
    @Override
    public String sendRender(Notification notification) {
        return "[SLACK] Notification "+notification.getId();
    }
}
