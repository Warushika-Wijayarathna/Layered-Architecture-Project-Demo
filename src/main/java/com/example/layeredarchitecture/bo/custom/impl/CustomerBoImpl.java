package com.example.layeredarchitecture.bo.custom.impl;

import com.example.layeredarchitecture.bo.custom.CustomerBo;
import com.example.layeredarchitecture.dao.DAOFactory;
import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.entity.Customer;
import com.example.layeredarchitecture.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBoImpl implements CustomerBo {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.CUSTOMER);

    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        ArrayList <Customer> allCustomers = customerDAO.getAll();
        ArrayList<CustomerDTO> allCustomersDTO = new ArrayList<>();
        for (Customer customer : allCustomers) {
            allCustomersDTO.add(new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress()));
        }
        return allCustomersDTO;
    }
    public boolean addCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.add(new Customer(dto.getId(), dto.getName(), dto.getAddress()));
    }
    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.update(new Customer(dto.getId(), dto.getName(), dto.getAddress()));
    }
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.exist(id);
    }
    public String generateNewID() throws SQLException, ClassNotFoundException {
       return customerDAO.generateNewID();
    }
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id);
    }
    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
        return new CustomerDTO(customerDAO.search(id).getId(), customerDAO.search(id).getName(), customerDAO.search(id).getAddress());
    }
}
