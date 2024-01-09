package lk.ijse.cinemax.bo.custom.impl;

import lk.ijse.cinemax.bo.custom.MovieBO;
import lk.ijse.cinemax.dao.DAOFactory;
import lk.ijse.cinemax.dao.SQLUtil;
import lk.ijse.cinemax.dao.custom.MovieDAO;
import lk.ijse.cinemax.db.DbConnection;
import lk.ijse.cinemax.dto.MovieDto;
import lk.ijse.cinemax.entity.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovieBOImpl implements MovieBO {

    MovieDAO movieDAO = (MovieDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.MOVIE);

    public byte[] getImageData(String movieName) throws SQLException, ClassNotFoundException {
        return movieDAO.getImageData(movieName);
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "SELECT image FROM movie WHERE movieName = ?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setString(1, movieName);
//
//        ResultSet resultSet = pstm.executeQuery();
//
//        if (resultSet.next()) {
//            return resultSet.getBytes(1);
//        }
//
//        return null;
    }

    public boolean saveMovies(MovieDto dto) throws SQLException, ClassNotFoundException {
        return movieDAO.save(new Movie(
                dto.getMovieId(),
                dto.getMovieName(),
                dto.getMovieGenre(),
                dto.getYear(),
                dto.getImagePath(),
                dto.getDescription()
        ));
    }

    public ArrayList<MovieDto> loadAllMovies() throws SQLException, ClassNotFoundException {
        ArrayList<Movie> movies = movieDAO.loadAll();
        ArrayList<MovieDto> movieDTOS = new ArrayList<>();
        for(Movie m : movies){
            movieDTOS.add(new MovieDto(
                    m.getMovieId(),
                    m.getMovieName(),
                    m.getMovieGenre(),
                    m.getYear(),
                    m.getImagePath(),
                    m.getDescription()
            ));
        }
        return movieDTOS;
    }

    public boolean updateMovies(MovieDto dto) throws SQLException, ClassNotFoundException {
        return movieDAO.update(new Movie(
                dto.getMovieId(),
                dto.getMovieName(),
                dto.getMovieGenre(),
                dto.getYear(),
                dto.getImagePath(),
                dto.getDescription()
        ));
    }

    public MovieDto searchMovies(String searchMovie) throws SQLException, ClassNotFoundException {
        Movie movie = movieDAO.search(searchMovie);
        MovieDto movieDto = new MovieDto(
                movie.getMovieId(),
                movie.getMovieName(),
                movie.getMovieGenre(),
                movie.getYear(),
                movie.getImagePath(),
                movie.getDescription()
        );
        return movieDto;
    }

    public boolean deleteMovies(String movieId) throws SQLException, ClassNotFoundException {
        return movieDAO.delete(movieId);
    }

    public String generateMovieId() throws SQLException, ClassNotFoundException {
        return movieDAO.generateMovieId();
//        return SQLUtil.execute("SELECT movieId FROM movie ORDER BY movieId DESC LIMIT 1");
    }

    public MovieDto getMovieName(String movieName) throws SQLException, ClassNotFoundException {
        return movieDAO.getMovieName(movieName);
//        ResultSet rst = SQLUtil.execute("SELECT * FROM movie WHERE movieName = ?", movieName);
//        rst.next();
//
//        if (rst.next()){
//            return new MovieDto(
//                    rst.getString(1),
//                    rst.getString(2),
//                    rst.getString(3),
//                    rst.getString(4),
//                    rst.getString(5),
//                    rst.getString(6)
//            );
//        } else {
//            return null;
//        }
    }

    public int getAvailableMoviesCount() throws SQLException, ClassNotFoundException {
        int count = 0;

        return movieDAO.getAvailableMoviesCount();
    }
//        ResultSet rst = SQLUtil.execute("SELECT COUNT(*) FROM movie WHERE imagePath IS NOT NULL");
//        try {
//            if (rst.next()) {
//                count =  rst.getInt(1);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return count;
//        }

//        int count = 0;
//        try {
//            Connection connection = DbConnection.getInstance().getConnection();
//            String sql = "SELECT COUNT(*) FROM movie";
//            try (PreparedStatement pstm = connection.prepareStatement(sql);
//                 ResultSet resultSet = pstm.executeQuery()) {
//
//                if (resultSet.next()) {
//                    count = resultSet.getInt(1);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace(); // Handle other SQLExceptions appropriately
//        }
//        return count;
}
