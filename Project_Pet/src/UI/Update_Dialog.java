/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import entity.Customer;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import manager.CustomerManager;

/**
 *
 * @author hau
 */
public class Update_Dialog extends javax.swing.JDialog {

    private CustomerManager myManager;
    private Customer editCustomer;

    /**
     * Creates new form Add_Dialog
     */
    public Update_Dialog(Customer editCustomer, CustomerManager myManager, java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.myManager = myManager;
        this.editCustomer = editCustomer;
        this.addListener();
        this.fillInData();
    }

    private void addListener() {

        this.btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (doValidate()) {
                    doUpdate();
                    doExit();
                }
            }
        });
        this.btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doClear();
            }
        });
        this.btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doExit();
            }
        });
        this.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doDelete();
            }
        });

    }

    private void doExit() {
        this.dispose();
    }

    private void doUpdate() {
        int billNumber;//
        String customerName, phoneNum, serviceUsed, pet;//
        float price;//
        int quantity;//
        boolean paymentStatus;
        StringBuilder detail = new StringBuilder();

        billNumber = Integer.parseInt(this.txtID.getText());

        customerName = this.txtName.getText();
        pet = this.txtPet.getText();

        phoneNum = this.txtPhone.getText();
        serviceUsed = (String) this.cbxAnimal.getSelectedItem();
        quantity = Integer.parseInt(this.txtQuantity.getText());
        price = Float.parseFloat(this.txtPrice.getText());
        if (this.btnYes.isSelected()) {
            paymentStatus = true;
        } else {
            paymentStatus = false;
        }
        Customer customer = new Customer(billNumber, customerName, pet, phoneNum, serviceUsed, price, quantity, paymentStatus);

        if (this.myManager.updateCustomer(customer)) {
            JOptionPane.showMessageDialog(this, "Successful ");
            this.refreshParent();
        } else {
            detail.append("Unsuccessful");
            if (myManager.getAdminStatus()) {
                detail.append(", please enter password first ");
            }
            JOptionPane.showMessageDialog(this, detail);
        }
        System.out.println(customer.toString());
    }

    private void doDelete() {
        int billNumber;//
        String customerName, phoneNum, serviceUsed, pet;//
        float price;//
        int quantity;//
        boolean paymentStatus;
        StringBuilder detail = new StringBuilder();
        billNumber = Integer.parseInt(this.txtID.getText());

        customerName = this.txtName.getText();
        pet = this.txtPet.getText();

        phoneNum = this.txtPhone.getText();
        serviceUsed = (String) this.cbxAnimal.getSelectedItem();
        quantity = Integer.parseInt(this.txtQuantity.getText());
        price = Float.parseFloat(this.txtPrice.getText());
        if (this.btnYes.isSelected()) {
            paymentStatus = true;
        } else {
            paymentStatus = false;
        }
        Customer editCustomer = new Customer(billNumber, customerName, pet, phoneNum, serviceUsed, price, quantity, paymentStatus);

        if (this.myManager.removeCustomer(editCustomer)) {
            JOptionPane.showMessageDialog(this, "Successful");
            this.refreshParent();
        } else {
            detail.append("Unsuccessful");
            if (myManager.getAdminStatus()) {
                detail.append(",please enter password first ");
            }
            JOptionPane.showMessageDialog(this, detail);
        }
    }

    private void fillInData() {
        this.txtID.setText(Integer.toString(this.editCustomer.getBillNumber()));
        this.txtName.setText(this.editCustomer.getCustomerName());
        this.txtPrice.setText(Float.toString(this.editCustomer.getPrice()));
        this.txtPet.setText(this.editCustomer.getPet());

        this.txtPhone.setText(this.editCustomer.getPhoneNum());
        if (this.editCustomer.isPaymentStatus()) {
            this.btnYes.setSelected(true);

        } else {
            this.btnNo.setSelected(true);
        }
        String fillInService = this.editCustomer.getServiceUsed();
        String cap = fillInService.substring(0, 1).toUpperCase() + fillInService.substring(1);
        this.cbxAnimal.setSelectedItem(cap);
        this.lblError.setText("...");
    }

    private void doClear() {
        this.txtName.setText("");
        this.txtPrice.setText("");
        this.txtPhone.setText("");
        this.btnYes.setSelected(true);
        this.cbxAnimal.setSelectedIndex(0);
        this.lblError.setText("...");
    }

    private boolean doValidate() {
        boolean isValid = true;

        if (this.txtID.getText().length() == 0) {
            isValid = false;
            this.lblError.setText("Bill ID can not be blank");
        }
        if (this.txtName.getText().length() == 0) {
            isValid = false;
            this.lblError.setText("ID can not be blank");
        }
        if (this.txtPhone.getText().length() < 8) {
            isValid = false;
            this.lblError.setText("Phone number not long enough or not filled");
        }

        try {
            Float.parseFloat(this.txtPrice.getText());
        } catch (Exception exx) {
            isValid = false;
            this.lblError.setText("Price not filled");

        }

        return isValid;
    }

    private void refreshParent() {
        MainFrame myBoss = (MainFrame) this.getParent();
        myBoss.refreshTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paymentStatus = new javax.swing.ButtonGroup();
        lbPaymentStatus = new javax.swing.JLabel();
        lbPhone = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        lbPrice = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        lbQuantity = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        cbxAnimal = new javax.swing.JComboBox<>();
        lbID = new javax.swing.JLabel();
        lbService = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        btnYes = new javax.swing.JRadioButton();
        lbName = new javax.swing.JLabel();
        btnNo = new javax.swing.JRadioButton();
        txtName = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblPet = new javax.swing.JLabel();
        txtPet = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Customer");

        lbPaymentStatus.setText("Đơn đã được thanh toán");

        lbPhone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbPhone.setText("Phone");

        txtPhone.setColumns(10);

        lbPrice.setText("Price");
        lbPrice.setToolTipText("");

        txtPrice.setColumns(6);
        txtPrice.setText(" ");

        lbQuantity.setText("Quantity");
        lbQuantity.setToolTipText("");

        txtQuantity.setColumns(3);
        txtQuantity.setText("1");

        cbxAnimal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Food", "Medicine", "Pet Keeping" }));
        cbxAnimal.setToolTipText("");

        lbID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbID.setText("ID");

        lbService.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbService.setText("Service");

        txtID.setEditable(false);
        txtID.setColumns(10);
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        paymentStatus.add(btnYes);
        btnYes.setSelected(true);
        btnYes.setText("Yes");

        lbName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbName.setText("Name");
        lbName.setToolTipText("");

        paymentStatus.add(btnNo);
        btnNo.setText("No");

        txtName.setColumns(10);

        btnSubmit.setBackground(new java.awt.Color(0, 0, 255));
        btnSubmit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setText("Edit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(0, 0, 255));
        btnClear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("Clear");
        btnClear.setToolTipText("Remove all things except ID");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Update customers' information");

        btnDelete.setBackground(new java.awt.Color(0, 0, 255));
        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.setToolTipText("");

        btnCancel.setBackground(new java.awt.Color(0, 0, 255));
        btnCancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancel");
        btnCancel.setToolTipText("");

        lblPet.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPet.setText("Pet");
        lblPet.setToolTipText("");

        txtPet.setColumns(10);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbPaymentStatus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnYes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnNo))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbID)
                                    .addComponent(lbService)
                                    .addComponent(lbPhone)
                                    .addComponent(lbName)
                                    .addComponent(lblPet)
                                    .addComponent(lbPrice))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbQuantity)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtID)
                                        .addComponent(cbxAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtName)
                                        .addComponent(txtPet)
                                        .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbID)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbName)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPet)
                            .addComponent(txtPet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbPhone)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbService)
                            .addComponent(cbxAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbQuantity)
                            .addComponent(lbPrice))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnYes)
                            .addComponent(btnNo)
                            .addComponent(lbPaymentStatus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JRadioButton btnNo;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JRadioButton btnYes;
    private javax.swing.JComboBox<String> cbxAnimal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbPaymentStatus;
    private javax.swing.JLabel lbPhone;
    private javax.swing.JLabel lbPrice;
    private javax.swing.JLabel lbQuantity;
    private javax.swing.JLabel lbService;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblPet;
    private javax.swing.ButtonGroup paymentStatus;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPet;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
