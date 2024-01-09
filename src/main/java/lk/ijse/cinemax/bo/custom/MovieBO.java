package lk.ijse.cinemax.bo.custom;

import lk.ijse.cinemax.bo.SuperBO;
import lk.ijse.cinemax.dao.CrudDAO;
import lk.ijse.cinemax.dto.MovieDto;
import lk.ijse.cinemax.entity.Movie;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MovieBO extends SuperBO {
    boolean saveMovies(MovieDto dto) throws SQLException, ClassNotFoundException;

    boolean updateMovies(MovieDto dto) throws SQLException, ClassNotFoundException;

    boolean deleteMovies(String id) throws SQLException, ClassNotFoundException;

    MovieDto searchMovies(String id) throws SQLException, ClassNotFoundException;

    ArrayList<MovieDto> loadAllMovies() throws SQLException, ClassNotFoundException;

    byte[] getImageData(String movieName) throws SQLException;

    public String generateMovieId() throws SQLException, ClassNotFoundException;

    public MovieDto getMovieName(String movieName) throws SQLException, ClassNotFoundException;

    public int getAvailableMoviesCount() throws SQLException, ClassNotFoundException;
}
