package lk.ijse.cinemax.model;

import lk.ijse.cinemax.db.DbConnection;
import lk.ijse.cinemax.dto.MovieDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieModel {
    public boolean saveMovie(MovieDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO movie VALUES(?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getMovieId());
        pstm.setString(2, dto.getMovieName());
        pstm.setString(3, dto.getMovieGenre());
        pstm.setString(4, dto.getYear());

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
                    resultSet.getString(4)
            ));
        }
        return dtoList;
    }

    public boolean updateMovie(MovieDto dto) throws SQLException{
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE movie SET movieName = ? , movieGenre = ? , movieYear = ? WHERE movieId = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getMovieName());
        pstm.setString(2, dto.getMovieGenre());
        pstm.setString(3, dto.getYear());
        pstm.setString(4, dto.getMovieId());

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

            dto = new MovieDto(id, name, genre, year);
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
}
