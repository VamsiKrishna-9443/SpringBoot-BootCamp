package in.coderarmy;


import in.coderarmy.payment.CardPayment;
import in.coderarmy.payment.PaymentService;
import in.coderarmy.payment.UpiPayment;
import in.strikes.CartService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig
{
    @Bean
    public User createUser()
    {
        return new User("Aashitha",22);
    }

    @Bean
    public CartService createCartService() {
        return new CartService();
    }

    @Bean
    @Qualifier("cp")
    public PaymentService createCardPayment() {
        return  new CardPayment();
    }

    @Bean
    @Qualifier("up")
    public PaymentService createUpiPayment()
    {
        return new UpiPayment();
    }
    @Bean
    public OrderService createOrderService(@Qualifier("cp") PaymentService paymentService) {
        return new OrderService(paymentService);
    }
}
