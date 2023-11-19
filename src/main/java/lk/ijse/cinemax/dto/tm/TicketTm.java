package lk.ijse.cinemax.dto.tm;

public class TicketTm {
    private String ticketId;
    private String customerId;
    private String movieId;
    private String seatNo;
    private String showtimeID;
    private String price;

    public TicketTm() {
    }

    public TicketTm(String ticketId, String customerId, String movieId, String seatNo, String showtimeID, String price) {
        this.ticketId = ticketId;
        this.customerId = customerId;
        this.movieId = movieId;
        this.seatNo = seatNo;
        this.showtimeID = showtimeID;
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

    public String getShowtimeID() {
        return showtimeID;
    }

    public void setShowtimeID(String showtimeID) {
        this.showtimeID = showtimeID;
    }

    public String getTicketPrice() {
        return price;
    }

    public void setTicketPrice(String ticketPrice) {
        this.price = ticketPrice;
    }

    @Override
    public String toString() {
        return "TicketTm{" +
                "ticketId='" + ticketId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", movieId='" + movieId + '\'' +
                ", seatNo='" + seatNo + '\'' +
                ", showtimeID='" + showtimeID + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
