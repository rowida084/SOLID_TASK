package SOLID_TASK;

public class NotificationManager {

    private AlertNotificationProcessor _alertNotificationProcessor;
    private  PromotionNotificationProcessor _promotionNotificationProcessor;

    public  NotificationManager(AlertNotificationProcessor alertNotificationProcessor,
                                PromotionNotificationProcessor promotionNotificationProcessor){
        _alertNotificationProcessor=alertNotificationProcessor;
        _promotionNotificationProcessor=promotionNotificationProcessor;
    }


    public  void process(Notification notification){
        switch (notification.getType()){
            case "Alert":{
                _alertNotificationProcessor.process(notification);
                break;
            }
            case "Promotion":{
                _promotionNotificationProcessor.process(notification);
                break;
            }
        }
    }
}
