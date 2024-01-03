package lk.ijse.cinemax.entity;

public class ShowTime {
    private String showTimeId;
    private String title;
    private String date;

    public ShowTime() {
    }

    public ShowTime(String showTimeId, String title, String date) {
        this.showTimeId = showTimeId;
        this.title = title;
        this.date = date;
    }

    public String getShowTimeId() {
        return showTimeId;
    }

    public void setShowTimeId(String showTimeId) {
        this.showTimeId = showTimeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ShowTimeDto{" +
                "showTimeId='" + showTimeId + '\'' +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
