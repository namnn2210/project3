package ginp14.project3.service;

import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import ginp14.project3.config.PaypalPaymentIntent;
import ginp14.project3.config.PaypalPaymentMethod;

public interface PaypalService {
    Payment createPayment(Double totalPrice, String currency, PaypalPaymentMethod method, PaypalPaymentIntent intent, String cancelUrl, String successUrl) throws PayPalRESTException;
    Payment executePayment(String paymentId, String payerId) throws PayPalRESTException;
}
