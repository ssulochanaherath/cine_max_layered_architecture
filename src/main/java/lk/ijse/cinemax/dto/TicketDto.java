package lk.ijse.cinemax.dto;

public class TicketDto {
    private String ticketId;
    private String customerId;
    private String movieId;
    private String seatNo;
    private String price;

    public TicketDto() {
    }

    public TicketDto(String ticketId, String customerId, String movieId, String seatNo, String price) {
        this.ticketId = ticketId;
        this.customerId = customerId;
        this.movieId = movieId;
        this.seatNo = seatNo;
        this.price = price;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
