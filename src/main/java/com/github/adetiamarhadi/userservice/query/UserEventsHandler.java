package com.github.adetiamarhadi.userservice.query;

import com.github.adetiamarhadi.sagacore.model.PaymentDetails;
import com.github.adetiamarhadi.sagacore.model.User;
import com.github.adetiamarhadi.sagacore.query.FetchUserPaymentDetailsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserEventsHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserEventsHandler.class);

    @QueryHandler
    public User findUser(FetchUserPaymentDetailsQuery query) {

        LOGGER.info("get payment details for user: " + query.getUserId());

        PaymentDetails paymentDetails = PaymentDetails.builder()
                .cardNumber("1234-5678-9012-3456")
                .cvv("123")
                .name("ADETIA MARHADI")
                .validUntilMonth(12)
                .validUntilYear(2030)
                .build();

        return User.builder()
                .firstName("Adetia")
                .lastName("Marhadi")
                .userId(query.getUserId())
                .paymentDetails(paymentDetails)
                .build();
    }
}
