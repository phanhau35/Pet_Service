/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import entity.Customer;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hau
 */
public class TableModel extends AbstractTableModel {

    private String[] columnNames = {"Bill ID", "Name", "Pet Name", "Phone Number", "Service", "Price", "Quantity", "Total Price", "Payment Status"};
    private ArrayList<Customer> listData;
    private ArrayList<Object[]> listRow = new ArrayList<>();

    public TableModel(ArrayList<Customer> listData) {
        this.listData = listData;
        Customer customer;
        String status = "";
        for (int i = 0; i < this.listData.size(); i++) {
            customer = this.listData.get(i);

            if (customer.isPaymentStatus()) {
                status = "Yes";
            } else {
                status = "No";
            }
            Object[] row = {customer.getBillNumber(), customer.getCustomerName(), customer.getPet(), customer.getPhoneNum(), customer.getServiceUsed(), customer.getPrice(), customer.getQuantity(), customer.getTotal(), status};
            this.listRow.add(row);
        }
    }

    @Override
    public int getRowCount() {
        return this.listRow.size();
    }

    @Override
    public int getColumnCount() {
        return this.columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.listRow.get(rowIndex)[columnIndex];
    }

    public String getColumnName(int column) {
        return this.columnNames[column];
    }

    public java.lang.Class getColumnClass(int column) {
        return this.listRow.get(0)[column].getClass();
    }

    public Object getObjectAtRow(int row) {
        return this.listData.get(row);
    }

}
