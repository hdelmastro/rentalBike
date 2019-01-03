package ar.com.intivefdv.rentalBike.business;

import ar.com.intivefdv.rentalBike.business.rules.BusinessRules;
import ar.com.intivefdv.rentalBike.domain.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author hdelmastro <hector.delmastro@xcaleconsulting.com>
 * Created 26/12/2018 11:59
 */
@Component
public class PriceCalculator {

    @Autowired
    private BusinessRules businessRules;


    public BigDecimal calculatePrice(Rental rental) {
        BigDecimal response = null;
        response  = (businessRules.getPrice(rental).multiply(BigDecimal.valueOf(rental.getNumberOfBikes())).multiply(getDiscount(rental)));
        return response;
    }

    private BigDecimal getDiscount(Rental rental) {
        BigDecimal discount = businessRules.getDiscountPercentage(rental).divide(BigDecimal.valueOf(100));
        BigDecimal response = BigDecimal.valueOf(1).subtract(discount);
        return response;
    }
}
