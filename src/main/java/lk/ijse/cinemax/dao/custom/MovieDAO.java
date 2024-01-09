package lk.ijse.cinemax.dao.custom;

import lk.ijse.cinemax.dao.CrudDAO;
import lk.ijse.cinemax.dto.MovieDto;
import lk.ijse.cinemax.entity.Movie;

import java.sql.SQLException;

public interface MovieDAO extends CrudDAO<Movie> {
    String generateMovieId() throws SQLException, ClassNotFoundException;

    MovieDto getMovieName(String movieName) throws SQLException, ClassNotFoundException;

    int getAvailableMoviesCount() throws SQLException, ClassNotFoundException;

    byte[] getImageData(String movieName) throws SQLException, ClassNotFoundException;
}
