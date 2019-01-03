package ar.com.intivefdv.rentalBike.business.rules;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringRunner.class)
public class BusinessRulesTest {

    @Autowired
    private BusinessRules target;

    @Before
    public void setUp() {}

    @Test
    public void getPrice() {
    }

    @Test
    public void getDiscountPercentage() {
    }
}