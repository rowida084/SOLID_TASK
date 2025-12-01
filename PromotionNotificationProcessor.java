package SOLID_TASK;

public class PromotionNotificationProcessor implements  NotificationProcessor{

    private  NotificationDeliverService _notificationDeliverService;
    private GDPRPromotionFilter _GDPRPromotionFilter;

    public PromotionNotificationProcessor(NotificationDeliverService notificationDeliverService,
                                          GDPRPromotionFilter gdprPromotionFilter){
        _notificationDeliverService=notificationDeliverService;
        _GDPRPromotionFilter=gdprPromotionFilter;
    }

    public void process(Notification notification) {
        if (notification.getType().equals("PROMOTION")) {

            if (notification.getExpiryDate() == null) {
                throw new IllegalArgumentException("Promotions require expiry date");
            }

            if(!_GDPRPromotionFilter.isAllowed(notification)){
                System.out.println("Filtered PROMOTION for EU user");
                return;
            }

        }
        _notificationDeliverService.deliver(notification);
    }
}
