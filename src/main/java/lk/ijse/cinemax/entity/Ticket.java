package lk.ijse.cinemax.entity;

public class Ticket {
    private String ticketId;
    private String customerId;
    private String movieId;
    private String seatNo;
    private String showTimeID;
    private String price;

    public Ticket() {
    }

    public Ticket(String ticketId, String customerId, String movieId, String seatNo, String showTimeID, String price) {
        this.ticketId = ticketId;
        this.customerId = customerId;
        this.movieId = movieId;
        this.seatNo = seatNo;
        this.showTimeID = showTimeID;
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

    public String getShowTimeID() {
        return showTimeID;
    }

    public void setShowTimeID(String showTimeID) {
        this.showTimeID = showTimeID;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "TicketDto{" +
                "ticketId='" + ticketId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", movieId='" + movieId + '\'' +
                ", seatNo='" + seatNo + '\'' +
                ", showTimeID='" + showTimeID + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
