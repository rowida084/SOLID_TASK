package SOLID_TASK;

public class NotificationDeliverService {

    private SlackService _slackService;
    private  EmailService _emailService;
    private EmailRenderer _emailRenderer;
    private SlackRenderer _slackRenderer;

    public NotificationDeliverService(SlackService slackService, SlackRenderer slackRenderer
    , EmailService emailService, EmailRenderer emailRenderer){
        _slackService=slackService;
        _slackRenderer=slackRenderer;
        _emailService=emailService;
        _emailRenderer=emailRenderer;
    }

   public void deliver (Notification notification){

       if (notification.getPreferredChannel().equals("EMAIL")) {
           _emailService.send(notification.getTarget(), _emailRenderer.sendRender(notification));
       }
       else if(notification.getPreferredChannel().equals("Slack")){
           _emailService.send(notification.getTarget(), _slackRenderer.sendRender(notification));
       }
    }
}
