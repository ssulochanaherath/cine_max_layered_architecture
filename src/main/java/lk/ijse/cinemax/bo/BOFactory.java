package lk.ijse.cinemax.bo;

import lk.ijse.cinemax.bo.custom.impl.CustomerBOImpl;
import lk.ijse.cinemax.bo.custom.impl.ItemBOImpl;
import lk.ijse.cinemax.bo.custom.impl.LoginBOImpl;
import lk.ijse.cinemax.bo.custom.impl.MovieBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){

    }

    public static BOFactory getBoFactory(){
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes{
        CUSTOMER,ITEM,LOGIN,MOVIE,PLACEORDER,SEAT,SIGNUP,SUPPLIER,TICKET
    }

    public SuperBO getBo(BOTypes boTypes){
        switch (boTypes){
            case CUSTOMER:
                return new CustomerBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case LOGIN:
                return new LoginBOImpl();
            case MOVIE:
                return new MovieBOImpl();
            case PLACEORDER:
                return new PlaceOrderBOImpl();
            case SEAT:
                return new SeatBOImpl();
            case SIGNUP:
                return new SignUpBOImpl();
            case SUPPLIER:
                return new SupplierBOImpl();
            case TICKET:
                return new TicketBOImpl();
            default:
    }
}
