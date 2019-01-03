package ar.com.intivefdv.rentalBike.domain.request;

import ar.com.intivefdv.rentalBike.domain.Holder;
import ar.com.intivefdv.rentalBike.domain.Rental;

import java.io.Serializable;

/**
 * @author hdelmastro <hector.delmastro@xcaleconsulting.com>
 * Created 26/12/2018 12:21
 */
public class BookingConfirm implements Serializable {

    private Holder holder;
    private Rental rental;

    public Holder getHolder() {
        return holder;
    }

    public void setHolder(Holder holder) {
        this.holder = holder;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }
}
