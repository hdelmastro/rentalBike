package ar.com.intivefdv.rentalBike.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class RentalTest {

    public static final int NUMBER_OF_BIKES = 5;
    private Rental target = new Rental();

    @Test
    public void numberOfBikes() {
        target.setNumberOfBikes(NUMBER_OF_BIKES);
        Integer numberOfBikes = target.getNumberOfBikes();
        Assert.assertNotNull(numberOfBikes);
        Assert.assertEquals(Integer.valueOf(NUMBER_OF_BIKES), numberOfBikes);
    }


    @Test
    public void type() {
        target.setType(RentalType.BY_HOUR);
        RentalType type = target.getType();
        Assert.assertNotNull(type);
        Assert.assertEquals(RentalType.BY_HOUR, type);
    }

}