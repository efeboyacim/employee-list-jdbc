import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
public class EmployeeList extends javax.swing.JFrame {
    
    DefaultTableModel model;
    
    public EmployeeList() throws SQLException {
        this.setResizable(false);
        initComponents();
        this.setTitle("Employee Manager");
        
        populateTable();
    }
    
    public void populateTable() throws SQLException{
        model = (DefaultTableModel) tblEmployee.getModel();
        model.setRowCount(0);
        ArrayList<Employee> employeeList = selectEmployeeList();
        for(Employee employee : employeeList){
            Object[] Row = {employee.getId(),employee.getFirstName(),employee.getSurname(),employee.getPosition(),employee.getSalary()};
            model.addRow(Row);
        }
    }
    public ArrayList<Employee> selectEmployeeList() throws SQLException{
        Connection connection= null;
        DbHelper helper = new DbHelper();
        Statement statement = null;
        ResultSet resultSet;
        ArrayList<Employee> employeeList = null;
        try{
            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from employee");
            employeeList = new ArrayList<Employee>();
            while(resultSet.next()){
                employeeList.add(new Employee(
                        resultSet.getInt("ID"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("Surname"),
                        resultSet.getString("Position"),
                        resultSet.getInt("Salary")
                        ));   
            }                   
        }catch(SQLException e){
            helper.showMessage(e);
        }finally{
            statement.close();
            connection.close();
            return employeeList;
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmployee = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtFirstname = new javax.swing.JTextField();
        txtSurname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSalary = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPosition = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblNotif = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Firstname", "Surname", "Position", "Salary"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblEmployee);
        if (tblEmployee.getColumnModel().getColumnCount() > 0) {
            tblEmployee.getColumnModel().getColumn(0).setResizable(false);
            tblEmployee.getColumnModel().getColumn(1).setResizable(false);
            tblEmployee.getColumnModel().getColumn(2).setResizable(false);
            tblEmployee.getColumnModel().getColumn(3).setResizable(false);
            tblEmployee.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel1.setText("Firstname:");

        jLabel2.setText("Surname:");

        txtSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalaryActionPerformed(evt);
            }
        });

        jLabel3.setText("Salary:");

        jLabel4.setText("Position:");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel5.setText("Search:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(31, 31, 31)
                        .addComponent(txtPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(31, 31, 31)
                        .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31)
                        .addComponent(txtFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(btnAdd)
                        .addGap(44, 44, 44)
                        .addComponent(btnUpdate)
                        .addGap(41, 41, 41)
                        .addComponent(btnDelete))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(304, 304, 304)
                        .addComponent(lblNotif, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnDelete)
                            .addComponent(btnUpdate))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lblNotif))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null;
        try{
            connection = helper.getConnection();
            String sql = "insert into employee (FirstName,Surname,Position,Salary) values(?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,txtFirstname.getText());
            statement.setString(2,txtSurname.getText());
            statement.setString(3, txtPosition.getText());
            statement.setInt(4,Integer.valueOf(txtSalary.getText()));
            statement.executeUpdate();    
        }catch(SQLException e){
            helper.showMessage(e);
        }finally{
            try{
                clearTextfields();
                populateTable();
                statement.close();
                connection.close();
                lblNotif.setText("Operation completed.");
            }catch(SQLException e){
                helper.showMessage(e);
            }
        }        
    }//GEN-LAST:event_btnAddActionPerformed
    public void deleteEmployee() throws SQLException{
        if(txtFirstname.getText().equals("")){
            int index = tblEmployee.getSelectedRow();
            int a = (int)model.getValueAt(index, 0);
            if(index!=-1){
                model.removeRow(index);
                Connection connection= null;
                DbHelper helper = new DbHelper();
                PreparedStatement statement = null;
                try{
                    connection = helper.getConnection();
                    String sql = "delete from employee where id = ?";
                    statement = connection.prepareStatement(sql);
                    statement.setInt(1,a);
                    statement.executeUpdate();
                    lblNotif.setText("Employee removed from the list.");
                } catch (SQLException e) {
                    helper.showMessage(e);
                }finally{
                    statement.close();
                    connection.close();
                    System.out.println("Connection closed.");
                }            
            }else if(index==-1)
                lblNotif.setText("There is no user yet.");
        }else{
            lblNotif.setText("Firstly clear the text areas and please select user at the list.");
        }          
    }
            
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            deleteEmployee();
            clearTextfields();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeList.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        
    }//GEN-LAST:event_btnDeleteActionPerformed
    public void update() throws SQLException {
        int index = tblEmployee.getSelectedColumn();
        int row = tblEmployee.getSelectedRow();
        int id = (int)model.getValueAt(row, 0);
        Connection connection= null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null;
        try{
            connection = helper.getConnection();
            if(index==1){
                String sql = "update employee set FirstName = ? where ID=?";
                statement = connection.prepareStatement(sql);
                statement.setString(1,txtFirstname.getText());
                statement.setInt(2,id);   
            }else if(index==0){
                lblNotif.setText("ID is not editable.");
            }else if(index==2){
                String sql = "update employee set Surname = ? where ID=?";
                statement = connection.prepareStatement(sql);
                statement.setString(1,txtSurname.getText());
                statement.setInt(2,id);   
            }else if(index==3){
                String sql = "update employee set Position = ? where ID=?";
                statement = connection.prepareStatement(sql);
                statement.setString(1,txtPosition.getText());
                statement.setInt(2,id);   
            }else if(index==4){
                String sql = "update employee set Salary = ? where ID= ?";
                statement = connection.prepareStatement(sql);
                statement.setInt(1,Integer.valueOf(txtSalary.getText()));
                statement.setInt(2,id);   
            }

            statement.executeUpdate();
            System.out.println("Kayıt güncellendi.");
        } catch (SQLException e) {
            helper.showMessage(e);
        }finally{
            statement.close();
            connection.close();
            System.out.println("Connection closed.");
        }  
        }
    
    
    public void clearTextfields(){
        txtFirstname.setText("");
        txtSurname.setText("");
        txtPosition.setText("");
        txtSalary.setText("");
    }



 
    
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            // TODO add your handling code here:
            update();
            populateTable();
            clearTextfields();
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeList.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalaryActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        String searchKey = txtSearch.getText();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(model);
        tblEmployee.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(searchKey));
        
    }//GEN-LAST:event_txtSearchKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws SQLException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmployeeList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new EmployeeList().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeList.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNotif;
    private javax.swing.JTable tblEmployee;
    private javax.swing.JTextField txtFirstname;
    private javax.swing.JTextField txtPosition;
    private javax.swing.JTextField txtSalary;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSurname;
    // End of variables declaration//GEN-END:variables
}
