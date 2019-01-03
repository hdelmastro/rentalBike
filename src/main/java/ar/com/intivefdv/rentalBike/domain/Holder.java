package ar.com.intivefdv.rentalBike.domain;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * @author hdelmastro <hector.delmastro@xcaleconsulting.com>
 * Created 26/12/2018 11:35
 */
public class Holder implements Serializable {

    private String name;

    private BigInteger clientId;

    private String identification;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }
}
