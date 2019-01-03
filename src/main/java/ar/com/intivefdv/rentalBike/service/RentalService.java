package ar.com.intivefdv.rentalBike.service;

import ar.com.intivefdv.rentalBike.business.PriceCalculator;
import ar.com.intivefdv.rentalBike.domain.request.BookingConfirm;
import ar.com.intivefdv.rentalBike.domain.response.BookingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hdelmastro <hector.delmastro@xcaleconsulting.com>
 * Created 26/12/2018 11:20
 */
@Service
public class RentalService {


    @Autowired
    private PriceCalculator priceCalculator;


    public BookingResponse booking (BookingConfirm bookingConfirm){

        BookingResponse response = new BookingResponse();


        response.setHolder(bookingConfirm.getHolder());
        response.setRental(bookingConfirm.getRental());

        response.setTotalPrice(priceCalculator.calculatePrice(bookingConfirm.getRental()));

        return response;
    }




}
