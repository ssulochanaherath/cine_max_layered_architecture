package lk.ijse.cinemax.dao;

import lk.ijse.cinemax.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){

    }

    public static DAOFactory getDaoFactory(){
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes{
        CUSTOMER,ITEM,LOGIN,MOVIE,PLACEORDER,SEAT,SIGNUP,SUPPLIER,TICKET
    }

    public SuperDAO getDao(DAOTypes daoTypes){
        switch (daoTypes){
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case LOGIN:
                return new LoginDAOImpl();
            case MOVIE:
                return new MovieDAOImpl();
            case PLACEORDER:
                return new PlaceOrderDAOImpl();
            case SEAT:
                return new SeatDAOImpl();
            case SIGNUP:
                return new SignUpDAOImpl();
            case SUPPLIER:
                return new SupplierDAOImpl();
            case TICKET:
                return new TicketDAOImpl();
            default:
                return null;
    }
    }
}
