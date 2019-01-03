package ar.com.intivefdv.rentalBike.controller;

import ar.com.intivefdv.rentalBike.domain.request.BookingConfirm;
import ar.com.intivefdv.rentalBike.domain.response.BookingResponse;
import ar.com.intivefdv.rentalBike.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hdelmastro <hector.delmastro@xcaleconsulting.com>
 * Created 26/12/2018 11:45
 */
@RequestMapping("/api")
@RestController
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @RequestMapping(value = "/booking",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    public ResponseEntity<BookingResponse> rentBike(@RequestBody BookingConfirm booking) {

        BookingResponse bookingRS = rentalService.booking(booking);

        if (bookingRS != null) {
            return ResponseEntity.status(HttpStatus.OK).body(bookingRS);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }


}
