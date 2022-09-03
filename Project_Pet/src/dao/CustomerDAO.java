/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.*;
import java.util.ArrayList;
import entity.Customer;

/**
 *
 * @author hau
 */
public class CustomerDAO {

    private String pathStr = "Data\\Private";
    private String fileNameByte = "Data_Byte.dat";
    private String fileNameByteM = "Data_ByteM";
    private String fileNameChar = "Data_Char.txt";

    public CustomerDAO() {

        this.createFolder();
    }

    public void createFolder() {
        File folder = new File(pathStr);

        if (folder.exists()) {
            System.out.println("Folder exists");
        } else {
            System.out.println("Folder not exists");
            folder.mkdirs();
            System.out.println("Folder created");
        }
    }

    public void saveListAsByte(ArrayList<Customer> listCustomer) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(this.pathStr + "\\" + this.fileNameByte);
            oos = new ObjectOutputStream(fos);

            oos.writeObject(listCustomer);
            oos.flush();
        } catch (IOException ex) {
            System.out.println("Exception:  " + ex.getMessage());
        }
    }
    public void saveListAsByteManual(ArrayList<Customer> listCustomer) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(this.pathStr + "\\" + this.fileNameByteM);
            oos = new ObjectOutputStream(fos);

            oos.writeObject(listCustomer);
            oos.flush();
        } catch (IOException ex) {
            System.out.println("Exception:  " + ex.getMessage());
        }
    }

    public ArrayList<Customer> readListAsByte() {

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(this.pathStr + "\\" + this.fileNameByte);
            ois = new ObjectInputStream(fis);

            ArrayList<Customer> listCustomer = (ArrayList<Customer>) ois.readObject();

            return listCustomer;

        } catch (IOException ex) {
            System.out.println("Exception:  " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Exception:  " + ex.getMessage());
        }

        return null;
    }
}
