package lk.ijse.cinemax.dto.tm;


import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.awt.*;

public class MovieTm {
    private String movieId;
    private String movieName;
    private String movieGenre;
    private String year;

    private final ObjectProperty<Image> image = new SimpleObjectProperty<>();

    public ObjectProperty<Image> imageProperty() {
        return image;
    }

    public MovieTm() {
    }

    public MovieTm(String movieId, String movieName, String movieGenre, String year, String image) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieGenre = movieGenre;
        this.year = year;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }



    @Override
    public String toString() {
        return "MovieDto{" +
                "movieId='" + movieId + '\'' +
                ", movieName='" + movieName + '\'' +
                ", movieGenre='" + movieGenre + '\'' +
                ", year='" + year + '\'' +
                ", imagePath='" + image + '\'' +
                '}';
    }
}
