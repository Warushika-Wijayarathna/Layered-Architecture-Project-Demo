package com.example.layeredarchitecture.bo.custom;

import com.example.layeredarchitecture.bo.SuperBo;
import com.example.layeredarchitecture.dto.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBo extends SuperBo {
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException;
    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException;
    public boolean addItem(ItemDTO dto) throws SQLException, ClassNotFoundException;
    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException;
    public boolean existItem(String code) throws SQLException, ClassNotFoundException;
    public String generateNewID() throws SQLException, ClassNotFoundException;
    public ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException;
}
