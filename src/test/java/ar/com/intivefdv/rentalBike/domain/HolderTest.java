package ar.com.intivefdv.rentalBike.domain;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class HolderTest {


    public static final String USERNAME = "username";
    public static final BigInteger DEFAULT_CLIENT_ID = BigInteger.valueOf(35);
    public static final String IDENTIFICATION = "ident";
    private Holder target = new Holder();


    @Test
    public void name() {
        target.setName(USERNAME);
        String name = target.getName();
        Assert.assertNotNull(name);
        Assert.assertEquals(USERNAME, name);
    }


    @Test
    public void clientId() {
        target.setClientId(DEFAULT_CLIENT_ID);
        BigInteger clientId = target.getClientId();
        Assert.assertNotNull(clientId);
        Assert.assertEquals(DEFAULT_CLIENT_ID, clientId);
    }


    @Test
    public void identification() {
        target.setIdentification(IDENTIFICATION);
        String identification = target.getIdentification();
        Assert.assertNotNull(identification);
        Assert.assertEquals(IDENTIFICATION, identification);
    }


}