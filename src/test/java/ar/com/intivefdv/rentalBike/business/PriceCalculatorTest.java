package ar.com.intivefdv.rentalBike.business;

import ar.com.intivefdv.rentalBike.domain.Rental;
import ar.com.intivefdv.rentalBike.domain.RentalType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PriceCalculatorTest {

    public static final int NO_FAMILY_NUMBER = 2;
    public static final int FAMILY_NUMBER = 4;
    private static BigDecimal PRICE_BY_HOUR = BigDecimal.valueOf(5);
    @Autowired
    private PriceCalculator target;

    Rental rental;

    @Before
    public void setUp() {
        rental = Mockito.mock(Rental.class);
        Mockito.when(rental.getType()).thenReturn(RentalType.BY_HOUR);
    }

    @Test
    public void calculatePrice() {
        Mockito.when(rental.getNumberOfBikes()).thenReturn(NO_FAMILY_NUMBER);
        BigDecimal response = target.calculatePrice(rental);
        Assert.assertNotNull(response);
        BigDecimal expected = BigDecimal.valueOf(NO_FAMILY_NUMBER).multiply(PRICE_BY_HOUR);
        Assert.assertEquals(expected, response);
    }

    @Test
    public void calculatePriceWithDiscount() {
        Mockito.when(rental.getNumberOfBikes()).thenReturn(FAMILY_NUMBER);
        BigDecimal response = target.calculatePrice(rental);
        BigDecimal expected =  BigDecimal.valueOf(FAMILY_NUMBER).multiply(PRICE_BY_HOUR).multiply(BigDecimal.valueOf(0.7));
        Assert.assertEquals(expected, response);
    }
}