package lk.ijse.cinemax.bo.custom.impl;

import lk.ijse.cinemax.bo.custom.SignUpBO;
import lk.ijse.cinemax.dao.DAOFactory;
import lk.ijse.cinemax.dao.SQLUtil;
import lk.ijse.cinemax.dao.custom.SignUpDAO;
import lk.ijse.cinemax.db.DbConnection;
import lk.ijse.cinemax.dto.SignUpDto;
import lk.ijse.cinemax.entity.SignUp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SignUpBOImpl implements SignUpBO {

    SignUpDAO signUpDAO = (SignUpDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.SIGNUP);
    public ArrayList<SignUpDto> loadAll() throws SQLException, ClassNotFoundException {
        ArrayList<SignUp> signUp = signUpDAO.loadAll();
        ArrayList<SignUpDto> signUpDTOS = new ArrayList<>();
        for (SignUp s : signUp) {
            signUpDTOS.add(new SignUpDto(
                    s.getUserId(),
                    s.getFristName(),
                    s.getLastName(),
                    s.getUserName(),
                    s.getPassword()
            ));
        }
        return signUpDTOS;
//        ResultSet rst = SQLUtil.execute("SELECT * FROM user");
//        ArrayList<SignUpDto> list = new ArrayList<>();
//
//        while (rst.next()){
//            list.add(new SignUpDto(
//                            rst.getString(1),
//                            rst.getString(2),
//                            rst.getString(3),
//                            rst.getString(4),
//                            rst.getString(5)
//                    )
//            );
//        }
//        return list;
    }

    public boolean save(SignUpDto dto) throws SQLException, ClassNotFoundException {
        return signUpDAO.save(new SignUp(
                dto.getUserId(),
                dto.getFristName(),
                dto.getLastName(),
                dto.getUserName(),
                dto.getPassword()
        ));
//        return SQLUtil.execute("INSERT INTO user VALUES(?,?,?,?,?)",
//                dto.getUserId(),dto.getFristName(),dto.getLastName(),dto.getUserName(),dto.getPassword());
    }

    @Override
    public boolean update(SignUpDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public SignUpDto search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    public String getLastUserId() throws SQLException{
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT userId FROM user ORDER BY userId DESC LIMIT 1";

        try(PreparedStatement pstm = connection.prepareStatement(sql)){
            ResultSet resultSet = pstm.executeQuery();

            if(resultSet.next()){
                return resultSet.getString(1);
            }else{
                return "";
            }
        }
    }
}
