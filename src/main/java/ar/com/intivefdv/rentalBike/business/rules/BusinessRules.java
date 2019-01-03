package ar.com.intivefdv.rentalBike.business.rules;

import ar.com.intivefdv.rentalBike.domain.Rental;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author hdelmastro <hector.delmastro@xcaleconsulting.com>
 * Created 26/12/2018 11:44
 */
@Component
public class BusinessRules {

    private static BigDecimal PERCENTAGE_DISCOUNT = BigDecimal.valueOf(30);

    private static Integer FROM = 3;
    private static Integer TO = 5;

    private static BigDecimal PRICE_BY_HOUR = BigDecimal.valueOf(5);

    private static BigDecimal PRICE_BY_DAY = BigDecimal.valueOf(20);

    private static BigDecimal PRICE_BY_WEEK = BigDecimal.valueOf(60);


    public BigDecimal getPrice(Rental rental) {

        switch (rental.getType()) {
            case BY_HOUR:
                return PRICE_BY_HOUR;
            case BY_DAY:
                return PRICE_BY_DAY;
            case BY_WEEK:
                return PRICE_BY_WEEK;
        }

        return null;
    }

    public BigDecimal getDiscountPercentage(Rental rental) {
        if (FROM<=rental.getNumberOfBikes() && rental.getNumberOfBikes()<=TO){
            return PERCENTAGE_DISCOUNT;
        }
        return BigDecimal.valueOf(0);
    }
}
