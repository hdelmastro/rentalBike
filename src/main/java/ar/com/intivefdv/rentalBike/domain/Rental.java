package ar.com.intivefdv.rentalBike.domain;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * @author hdelmastro <hector.delmastro@xcaleconsulting.com>
 * Created 26/12/2018 11:40
 */
public class Rental {

    private Integer numberOfBikes;
    private RentalType type;

    public Integer getNumberOfBikes() {
        return numberOfBikes;
    }

    public void setNumberOfBikes(Integer numberOfBikes) {
        this.numberOfBikes = numberOfBikes;
    }

    public RentalType getType() {
        return type;
    }

    public void setType(RentalType type) {
        this.type = type;
    }
}
