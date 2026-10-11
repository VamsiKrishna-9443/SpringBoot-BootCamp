package in.coderarmy;

import in.coderarmy.notification.EmailService;
import in.coderarmy.notification.NotificationService;

public class OrderService
{
    NotificationService notification = new EmailService();
    public void placeOrder()
    {
        System.out.println("Order Placed");
        notification.sendNotification();
    }
}
