package lk.ijse.cinemax.dao.custom.impl;

import lk.ijse.cinemax.dao.SQLUtil;
import lk.ijse.cinemax.dao.custom.MovieDAO;
import lk.ijse.cinemax.db.DbConnection;
import lk.ijse.cinemax.dto.MovieDto;
import lk.ijse.cinemax.entity.Item;
import lk.ijse.cinemax.entity.Movie;

import java.sql.*;
import java.util.ArrayList;

public class MovieDAOImpl implements MovieDAO {

    public static byte[] getImageData(String movieName) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT image FROM movie WHERE movieName = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, movieName);

        ResultSet resultSet = pstm.executeQuery();

        if (resultSet.next()) {
            return resultSet.getBytes(1);
        }

        return null;
    }

    public boolean save(Movie dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO movie VALUES(?,?,?,?,?,?)",
                dto.getMovieId(),dto.getMovieName(),dto.getMovieGenre(),dto.getYear(),dto.getImagePath(),dto.getDescription());
    }

    public ArrayList<Movie> loadAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM movie");
        ArrayList<Movie> allMovie = new ArrayList<>();

        while (rst.next()){
            allMovie.add(new Movie(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6)
            ));
        }
        return allMovie;
    }

    public boolean update(Movie dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE movie SET movieName = ? , movieGenre = ? , movieYear = ?, imagePath = ?, description = ? WHERE movieId = ?",
                dto.getMovieName(),dto.getMovieGenre(),dto.getYear(),dto.getImagePath(),dto.getDescription(),dto.getMovieId());
    }

    public Item search(String searchMovie) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM movie WHERE movieId = ?", searchMovie);
        rst.next();
        return new Movie(searchMovie, rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6));
    }

    public boolean delete(String movieId) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM movie WHERE movieId = ?", movieId);
    }

    public String generateMovieId() throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("SELECT movieId FROM movie ORDER BY movieId DESC LIMIT 1");
    }

    public MovieDto getMovieName(String movieName) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM movie WHERE movieName = ?", movieName);
        rst.next();

        if (rst.next()){
            return new MovieDto(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6)
            );
        } else {
            return null;
        }
    }

    public int getAvailableMoviesCount() throws SQLException, ClassNotFoundException {
        int count = 0;
        ResultSet rst = SQLUtil.execute("SELECT COUNT(*) FROM movie WHERE imagePath IS NOT NULL");
        try {
            if (rst.next()) {
                count =  rst.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
        }

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
