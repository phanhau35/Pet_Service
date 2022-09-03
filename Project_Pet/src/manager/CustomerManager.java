/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import dao.CustomerDAO;
import entity.Customer;
import java.util.ArrayList;

/**
 *
 * @author hau
 */
public class CustomerManager {

    private ArrayList<Customer> customerList = null;
    private dao.CustomerDAO myDAO;
    private boolean lock = true;

    //false for testing
    public CustomerManager() {
        this.customerList = new ArrayList<>();
        this.myDAO = new CustomerDAO();
        this.myDAO.createFolder();
    }

    public Customer getBillUsingID(int id) {
        Customer tempCustomer = null;
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getBillNumber() == id) {
                tempCustomer = customerList.get(i);
            }
        }
        return tempCustomer;
    }

    public ArrayList getList() {
        return this.customerList;
    }

    public ArrayList<Customer> getListContainName(String name) {
        Customer tempCustomer = null;
        ArrayList<Customer> customerListName = new ArrayList<>();
        for (int i = 0; i < customerList.size(); i++) {
            String tempCustomerName = customerList.get(i).getCustomerName();
            if (tempCustomerName.equalsIgnoreCase(name)) {
                tempCustomer = customerList.get(i);
                customerListName.add(tempCustomer);
            }
        }
        return customerListName;
    }

    public ArrayList<Customer> getListContainPhone(String phoneNumber) {
        Customer tempCustomer = null;
        ArrayList<Customer> customerListPhone = new ArrayList<>();

        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getPhoneNum().contains(phoneNumber)) {
                tempCustomer = customerList.get(i);
                customerListPhone.add(tempCustomer);
            }
        }
        return customerListPhone;
    }

    public ArrayList<Customer> getListContainPet(String type) {
        Customer tempCustomer = null;
        ArrayList<Customer> customerListPet = new ArrayList<>();
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getPet().equalsIgnoreCase(type)) {
                tempCustomer = customerList.get(i);
                customerListPet.add(tempCustomer);
            }
        }
        return customerListPet;
    }

    public ArrayList<Customer> getListContainType(String type) {
        if (type.equals("keeping")) {
            type = "pet keeping";
        }
        Customer tempCustomer = null;
        ArrayList<Customer> customerListType = new ArrayList<>();
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getServiceUsed().equalsIgnoreCase(type)) {
                tempCustomer = customerList.get(i);
                customerListType.add(tempCustomer);
            }
        }
        return customerListType;
    }

    public ArrayList<Customer> getListPayment() {
        Customer tempCustomer = null;
        ArrayList<Customer> customerListPayment = new ArrayList<>();
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).isPaymentStatus() == false) {
                tempCustomer = customerList.get(i);
                customerListPayment.add(tempCustomer);
            }
        }
        return customerListPayment;
    }

    public boolean addCustomer(Customer newCustomer) {
        boolean result = false;
        if (this.lock == true) {
            return false;
        }
        Customer tempCustomer = this.getBillUsingID(newCustomer.getBillNumber());
        if (tempCustomer == null) {
            this.customerList.add(newCustomer);
            return true;
        }

        return result;
    }

    public boolean updateCustomer(Customer editCustomer) {
        boolean result = false;
        if (this.lock == true) {
            return false;
        }
        Customer oldCustomer = this.getBillUsingID(editCustomer.getBillNumber());
        if (oldCustomer != null) {
            int i = customerList.indexOf(oldCustomer);
            this.customerList.remove(oldCustomer);
            this.customerList.add(i, editCustomer);
            result = true;
        }
        return result;
    }

    public boolean removeCustomer(Customer editCustomer) {
        boolean result = false;
        if (this.lock == true) {
            return false;
        }
        Customer oldCustomer = this.getBillUsingID(editCustomer.getBillNumber());
        if (oldCustomer != null) {
            this.customerList.remove(oldCustomer);
            result = true;
        }
        return result;
    }

    public boolean adminLock(String pass) {
        boolean changed = false;
        if (pass.equals("admin")) {
            this.lock = false;
            changed = true;
        }
        return changed;
    }

    public boolean adminOut() {
        this.lock = true;
        return true;
    }

    public boolean getAdminStatus() {
        return this.lock;
    }

    public int saveByteData() {
        this.myDAO.saveListAsByte(customerList);
        return customerList.size();
    }
    public int saveByteDataManual() {
        this.myDAO.saveListAsByteManual(customerList);
        return customerList.size();
    }

//    public int saveCharData() {
//        this.myDAO.saveListAsChar(customerList);
//        return customerList.size();
//    }
    public int getByteData() {
        this.customerList = this.myDAO.readListAsByte();
        return this.customerList.size();
    }
}
