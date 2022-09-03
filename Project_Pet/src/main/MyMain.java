/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import UI.MainFrame;
import dao.CustomerDAO;
import entity.Customer;
import java.util.ArrayList;
import java.util.Scanner;
import manager.CustomerManager;

/**
 *
 * @author hau
 */
public class MyMain {

    public static void main(String[] args) {
        MainFrame myFrame = new MainFrame();
        myFrame.setVisible(true);

//        Scanner scan = new Scanner(System.in);
//        CustomerManager manager = new CustomerManager();
//        CustomerDAO dao = new CustomerDAO();
//        System.out.println("Test Menu");
//        int billNumber = scan.nextInt();
//        String customerName = scan.next();
//        String phoneNum = scan.next();
//        String serviceUsed = scan.next();
//        float price = scan.nextFloat();
//        int quantity = scan.nextInt();
//        boolean paymentStatus = false;
        // 12 Hau 01234444 seg 200000 12 
//        manager.addCustomer(new Customer(billNumber, customerName, phoneNum, serviceUsed, price, quantity, paymentStatus));
//        ArrayList<Customer> cuslist = dao.readListAsByte();
//        for (int i = 0; i < cuslist.size(); i++) {
//            System.out.println(cuslist.get(i));
//        }
    }
}
