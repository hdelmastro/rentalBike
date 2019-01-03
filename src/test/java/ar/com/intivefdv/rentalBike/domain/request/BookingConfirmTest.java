package ar.com.intivefdv.rentalBike.domain.request;

import ar.com.intivefdv.rentalBike.domain.Holder;
import ar.com.intivefdv.rentalBike.domain.Rental;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class BookingConfirmTest {

    private BookingConfirm target = new BookingConfirm();

    private  Holder holderDefault;
    private Rental rentalDefault;

    @Before
    public void setUp(){
        holderDefault = Mockito.mock(Holder.class);
        rentalDefault = Mockito.mock(Rental.class);
    }

    @Test
    public void holder() {
        target.setHolder(holderDefault);
        Holder holder = target.getHolder();
        Assert.assertNotNull(holder);
        Assert.assertEquals(holderDefault, holder);
    }

    @Test
    public void rental() {
        target.setRental(rentalDefault);
        Rental rental = target.getRental();
        Assert.assertNotNull(rental);
        Assert.assertEquals(rentalDefault, rental);
    }

}