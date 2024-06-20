package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.bo.custom.impl.CustomerBoImpl;
import com.example.layeredarchitecture.bo.custom.impl.ItemBoImpl;
import com.example.layeredarchitecture.bo.custom.impl.PlaceOrderBOImpl;

public class BoFactory {
    private static BoFactory boFactory;

    private BoFactory() {
    }

    public static BoFactory getInstance() {
        if (boFactory == null) {
            boFactory = new BoFactory();
        }
        return boFactory;
    }

    public SuperBo getBO(BOType type) {
        switch (type) {
            case CUSTOMER:
                return new CustomerBoImpl();
            case ITEM:
                return new ItemBoImpl();
            case PLACEORDER:
                return new PlaceOrderBOImpl();
            default:
                return null;
        }
    }

    public enum BOType {
        CUSTOMER, ITEM, PLACEORDER;
    }
}
