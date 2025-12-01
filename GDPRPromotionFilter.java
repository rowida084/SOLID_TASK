package SOLID_TASK;

public class GDPRPromotionFilter {

    private  UserRepository _userRepository;

    public GDPRPromotionFilter(UserRepository userRepository){
        _userRepository=userRepository;
    }

   public  boolean isAllowed(Notification notification){
        if (_userRepository.getLocation(notification.getUserId()).equals("EU")) {
            return false;
        }
        return true;
    }
}
