package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.dao.custom.impl.CustomerDAOImpl;
import com.example.layeredarchitecture.dao.custom.impl.ItemDAOImpl;
import com.example.layeredarchitecture.dao.custom.impl.OrderDAOImpl;
import com.example.layeredarchitecture.dao.custom.impl.OrderDetailsDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){
    }
    public static DAOFactory getInstance(){
        if (daoFactory == null) {
            daoFactory=new DAOFactory();
        }
        return daoFactory;
    }


    public SuperDAO getDAO(DAOType type){
        switch (type){
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case ORDER:
                return new OrderDAOImpl();
            case ORDERDETAIL:
                return new OrderDetailsDAOImpl();
            default:
                return null;
        }
    }

    public enum DAOType {
        CUSTOMER, ITEM, ORDER, ORDERDETAIL, QUERY;
    }
}
