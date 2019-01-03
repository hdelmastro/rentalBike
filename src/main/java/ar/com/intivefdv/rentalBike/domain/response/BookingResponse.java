package ar.com.intivefdv.rentalBike.domain.response;

import ar.com.intivefdv.rentalBike.domain.Holder;
import ar.com.intivefdv.rentalBike.domain.Rental;

import java.math.BigDecimal;

/**
 * @author hdelmastro <hector.delmastro@xcaleconsulting.com>
 * Created 26/12/2018 12:21
 */
public class BookingResponse {

    private Holder holder;
    private Rental rental;
    private BigDecimal totalPrice;

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

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

}
