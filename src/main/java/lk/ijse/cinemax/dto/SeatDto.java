package lk.ijse.cinemax.dto;

public class SeatDto {
    private String seatId;
    private String horizontal;
    private String vertical;
    private String seatNo;

    public SeatDto() {
    }

    public SeatDto(String seatId, String horizontal, String vertical, String seatNo) {
        this.seatId = seatId;
        this.horizontal = horizontal;
        this.vertical = vertical;
        this.seatNo = seatNo;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public String getHorizontal() {
        return horizontal;
    }

    public void setHorizontal(String horizontal) {
        this.horizontal = horizontal;
    }

    public String getVertical() {
        return vertical;
    }

    public void setVertical(String vertical) {
        this.vertical = vertical;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    @Override
    public String toString() {
        return "SeatDto{" +
                "seatId='" + seatId + '\'' +
                ", horizontal='" + horizontal + '\'' +
                ", vertical='" + vertical + '\'' +
                ", seatNo='" + seatNo + '\'' +
                '}';
    }
}
