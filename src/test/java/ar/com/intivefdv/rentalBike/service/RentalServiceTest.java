package ar.com.intivefdv.rentalBike.service;

import ar.com.intivefdv.rentalBike.domain.Holder;
import ar.com.intivefdv.rentalBike.domain.Rental;
import ar.com.intivefdv.rentalBike.domain.RentalType;
import ar.com.intivefdv.rentalBike.domain.request.BookingConfirm;
import ar.com.intivefdv.rentalBike.domain.response.BookingResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.math.BigInteger;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RentalServiceTest {

    private static BigDecimal PRICE_BY_HOUR = BigDecimal.valueOf(5);

    private static BigDecimal PRICE_BY_DAY = BigDecimal.valueOf(20);

    private static BigDecimal PRICE_BY_WEEK = BigDecimal.valueOf(60);

    public static final int NO_FAMILY_NUMBER = 2;
    public static final int FAMILY_NUMBER = 4;
    @Autowired
    private RentalService target;

    BookingConfirm bookingConfirm;

    @Before
    public void setUp() {
        bookingConfirm = Mockito.mock(BookingConfirm.class);
        Holder holder = Mockito.mock(Holder.class);
        Mockito.when(holder.getClientId()).thenReturn(BigInteger.valueOf(1));
        Mockito.when(holder.getIdentification()).thenReturn("1234");
        Mockito.when(holder.getName()).thenReturn("username");
        Mockito.when(bookingConfirm.getHolder()).thenReturn(holder);
    }

    @Test
    public void bookingByHour() {
        Rental rental = Mockito.mock(Rental.class);
        Mockito.when(rental.getNumberOfBikes()).thenReturn(NO_FAMILY_NUMBER);
        Mockito.when(rental.getType()).thenReturn(RentalType.BY_HOUR);
        Mockito.when(bookingConfirm.getRental()).thenReturn(rental);
        BookingResponse response = target.booking(bookingConfirm);
        Assert.assertNotNull(response);
        BigDecimal expected = BigDecimal.valueOf(NO_FAMILY_NUMBER).multiply(PRICE_BY_HOUR);
        Assert.assertEquals(expected, response.getTotalPrice());
    }

    @Test
    public void bookingByDay() {
        Rental rental = Mockito.mock(Rental.class);
        Mockito.when(rental.getNumberOfBikes()).thenReturn(NO_FAMILY_NUMBER);
        Mockito.when(rental.getType()).thenReturn(RentalType.BY_DAY);
        Mockito.when(bookingConfirm.getRental()).thenReturn(rental);
        BookingResponse response = target.booking(bookingConfirm);
        Assert.assertNotNull(response);
        BigDecimal expected = BigDecimal.valueOf(NO_FAMILY_NUMBER).multiply(PRICE_BY_DAY);
        Assert.assertEquals(expected, response.getTotalPrice());
    }

    @Test
    public void bookingByWeek() {
        Rental rental = Mockito.mock(Rental.class);
        Mockito.when(rental.getNumberOfBikes()).thenReturn(NO_FAMILY_NUMBER);
        Mockito.when(rental.getType()).thenReturn(RentalType.BY_WEEK);
        Mockito.when(bookingConfirm.getRental()).thenReturn(rental);
        BookingResponse response = target.booking(bookingConfirm);
        Assert.assertNotNull(response);
        BigDecimal expected = BigDecimal.valueOf(NO_FAMILY_NUMBER).multiply(PRICE_BY_WEEK);
        Assert.assertEquals(expected, response.getTotalPrice());
    }

    @Test
    public void familyBooking() {
        Rental rental = Mockito.mock(Rental.class);
        Mockito.when(rental.getNumberOfBikes()).thenReturn(FAMILY_NUMBER);
        Mockito.when(rental.getType()).thenReturn(RentalType.BY_HOUR);
        Mockito.when(bookingConfirm.getRental()).thenReturn(rental);
        BookingResponse response = target.booking(bookingConfirm);
        Assert.assertNotNull(response);
        BigDecimal expected =  BigDecimal.valueOf(FAMILY_NUMBER).multiply(PRICE_BY_HOUR).multiply(BigDecimal.valueOf(0.7));
        Assert.assertEquals(expected, response.getTotalPrice());

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void wrongBooking() {
        Rental rental = Mockito.mock(Rental.class);
        Mockito.when(rental.getNumberOfBikes()).thenReturn(0);
        Mockito.when(rental.getType()).thenReturn(RentalType.BY_HOUR);
        Mockito.when(bookingConfirm.getRental()).thenReturn(rental);
        BookingResponse response = target.booking(bookingConfirm);
        Assert.assertNotNull(response);
        BigDecimal expected =  BigDecimal.valueOf(FAMILY_NUMBER).multiply(PRICE_BY_HOUR).multiply(BigDecimal.valueOf(0.7));
        Assert.assertEquals(expected, response.getTotalPrice());
    }
}