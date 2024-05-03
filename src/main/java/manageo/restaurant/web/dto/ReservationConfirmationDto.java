package manageo.restaurant.web.dto;

public class ReservationConfirmationDto extends ReservationDto {
    
    boolean confirmed;

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

}
