/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author hau
 */
public class Customer implements Serializable {

    private int billNumber;//
    private String customerName;//
    private String phoneNum;//
    private String pet;

    private String serviceUsed;//
    private float price;//
    private int quantity;//
    private float total;
    private boolean paymentStatus;

    public Customer(int billNumber, String customerName, String pet, String phoneNum, String serviceUsed, float price, int quantity, boolean paymentStatus) {
        this.billNumber = billNumber;
        this.customerName = customerName;
        this.pet = pet;
        this.phoneNum = phoneNum;
        this.serviceUsed = serviceUsed;
        this.price = price;//
        this.quantity = quantity;//
        this.total = price * quantity;//
        this.paymentStatus = paymentStatus;
    }

    public int getBillNumber() {
        return billNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getServiceUsed() {
        return serviceUsed;
    }

    public void setServiceUsed(String serviceUsed) {
        this.serviceUsed = serviceUsed;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPet() {
        return pet;
    }

    public void setPet(String pet) {
        this.pet = pet;
    }

    public String toString() {
        boolean status = paymentStatus;
        String statusDetail;
        if (status == true) {
            statusDetail = "Yes";
        } else {
            statusDetail = "No";
        }
        String str = "";
        str = billNumber + " " + customerName+" " + pet + " " + phoneNum + " " + serviceUsed + " " + price + " " + quantity + " " + statusDetail;
        return str;
    }
}
