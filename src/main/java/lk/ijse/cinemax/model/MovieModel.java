package lk.ijse.cinemax.model;

import lk.ijse.cinemax.db.DbConnection;
import lk.ijse.cinemax.dto.MovieDto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieModel {

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

    public boolean saveMovie(MovieDto dto) throws SQLException, IOException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO movie VALUES(?,?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getMovieId());
        pstm.setString(2, dto.getMovieName());
        pstm.setString(3, dto.getMovieGenre());
        pstm.setString(4, dto.getYear());
        pstm.setString(5, dto.getImagePath());
        pstm.setString(6, dto.getDescription());

        if (dto.getImagePath() != null) {
            byte[] imageData = Files.readAllBytes(Paths.get(dto.getImagePath()));
            pstm.setBytes(5, imageData);
        } else {
            // If no image is provided, set the column to null
            pstm.setNull(5, Types.LONGVARBINARY);
        }

        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;
    }

    public List<MovieDto> loadAllMovies() throws SQLException{
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM movie";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        ArrayList<MovieDto> dtoList = new ArrayList<>();

        while(resultSet.next()){
            dtoList.add(new MovieDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6)
            ));
        }
        return dtoList;
    }

    public boolean updateMovie(MovieDto dto) throws SQLException{
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE movie SET movieName = ? , movieGenre = ? , movieYear = ?, imagePath = ?, description = ? WHERE movieId = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getMovieName());
        pstm.setString(2, dto.getMovieGenre());
        pstm.setString(3, dto.getYear());
        pstm.setString(4, dto.getImagePath());
        pstm.setString(5, dto.getMovieId());
        pstm.setString(6, dto.getDescription());

        return pstm.executeUpdate() > 0;
    }

    public MovieDto searchMovie(String searchMovie) throws SQLException{
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM movie WHERE movieId = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, searchMovie);

        ResultSet resultSet = pstm.executeQuery();

        MovieDto dto = null;

        if (resultSet.next()) {
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String genre = resultSet.getString(3);
            String year = resultSet.getString(4);
            String imagePath = resultSet.getString(5);
            String description = resultSet.getString(6);

            dto = new MovieDto(id, name, genre, year, imagePath, description);
        }
        return dto;
    }

    public boolean deleteMovie(String movieId) throws SQLException{
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM movie WHERE movieid = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, movieId);

        return pstm.executeUpdate() > 0;
    }

    public String generateMovieId() throws SQLException{
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT movieId FROM movie ORDER BY movieId DESC LIMIT 1";

        try(PreparedStatement pstm = connection.prepareStatement(sql)){
            ResultSet resultSet = pstm.executeQuery();

            if(resultSet.next()){
                return resultSet.getString(1);
            }else{
                return "";
            }
        }
    }

    public MovieDto getMovieName(String movieName) throws SQLException{
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM movie WHERE movieName = ?";
        try(PreparedStatement pstm = connection.prepareStatement(sql)){
            pstm.setString(1, movieName);
            ResultSet resultSet = pstm.executeQuery();

            if(resultSet.next()){
                return new MovieDto(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6)
                );
            } else {
                return null;
            }
        }
    }
}
