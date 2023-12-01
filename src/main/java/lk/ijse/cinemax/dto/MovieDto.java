package lk.ijse.cinemax.dto;

public class MovieDto {
    private String movieId;
    private String movieName;
    private String movieGenre;
    private String year;
    private String imagePath;
    private String description;

    public MovieDto() {
    }

    public MovieDto(String movieId, String movieName, String movieGenre, String year, String imagePath, String description) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieGenre = movieGenre;
        this.year = year;
        this.imagePath = imagePath;
        this.description = description;
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "MovieDto{" +
                "movieId='" + movieId + '\'' +
                ", movieName='" + movieName + '\'' +
                ", movieGenre='" + movieGenre + '\'' +
                ", year='" + year + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
