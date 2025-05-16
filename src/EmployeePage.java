import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.table.TableRowSorter;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Ringo M. Baldivino
 */
public class EmployeePage extends javax.swing.JFrame {

    /**
     * Creates new form EmployeePage
     */
    public EmployeePage() {
        initComponents();
        loadProduct();
        time();
        dt();
        updateProducts();
        updateSupplier();
        updateUser();
        loadFood1();
        loadToy1();
        loadDesign1();
        loadAccessories1();
        loadClothing1();
        updateSupplier1();
        updateUser1();
        foodcount();
        decorationcount();
        toycount();
        clothingcount();
        accessoriescount();
    }
       Connection con;
       PreparedStatement pst;
       ResultSet rs;
       
            
       
                 public void clothingcount() { //Total Event Count Method
    try {
        Connection con = CONN.getConnection();
        String sql = "SELECT COUNT(*) FROM clothing"; 
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            int count = rs.getInt(1); // Get the count from query
            clocount1.setText("CLOTHINGS:   " + count); // Update JLabel
        }

        rs.close();
        pst.close();
        con.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error retrieving member count: " + ex.getMessage());
    }
}
       
                 public void accessoriescount() { //Total Event Count Method
    try {
        Connection con = CONN.getConnection();
        String sql = "SELECT COUNT(*) FROM accessories"; 
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            int count = rs.getInt(1); // Get the count from query
            accecount1.setText("ACCESSORIES:   " + count); // Update JLabel
        }

        rs.close();
        pst.close();
        con.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error retrieving member count: " + ex.getMessage());
    }
}
       
             public void foodcount() { //Total Event Count Method
    try {
        Connection con = CONN.getConnection();
        String sql = "SELECT COUNT(*) FROM food"; 
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            int count = rs.getInt(1); // Get the count from query
            foodcount1.setText("FOOD:   " + count); // Update JLabel
        }

        rs.close();
        pst.close();
        con.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error retrieving member count: " + ex.getMessage());
    }
}
       
             public void toycount() { //Total Event Count Method
    try {
        Connection con = CONN.getConnection();
        String sql = "SELECT COUNT(*) FROM toy"; 
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            int count = rs.getInt(1); // Get the count from query
            toycount1.setText("TOYS:   " + count); // Update JLabel
        }

        rs.close();
        pst.close();
        con.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error retrieving member count: " + ex.getMessage());
    }
}
             
                   public void decorationcount() { //Total Event Count Method
    try {
        Connection con = CONN.getConnection();
        String sql = "SELECT COUNT(*) FROM design"; 
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            int count = rs.getInt(1); // Get the count from query
            decocount1.setText("DECORATIONS:   " + count); // Update JLabel
        }

        rs.close();
        pst.close();
        con.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error retrieving member count: " + ex.getMessage());
    }
}
    
                  
         public void updateSupplier1() { //Total Event Count Method
    try {
        Connection con = CONN.getConnection();
        String sql = "SELECT COUNT(*) FROM suppliers"; 
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            int count = rs.getInt(1); // Get the count from query
            suppliercount1.setText("SUPPLIER:   " + count); // Update JLabel
        }

        rs.close();
        pst.close();
        con.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error retrieving member count: " + ex.getMessage());
    }
}
       
         public void updateUser1() { //Total Event Count Method
    try {
        Connection con = CONN.getConnection();
        String sql = "SELECT COUNT(*) FROM accdetails"; 
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            int count = rs.getInt(1); // Get the count from query
            usercount1.setText("ACCOUNTS:   " + count); // Update JLabel
        }

        rs.close();
        pst.close();
        con.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error retrieving member count: " + ex.getMessage());
    }
}
       
       
                    public void loadClothing1() {
     
        DefaultTableModel model = (DefaultTableModel) Tproducts7.getModel();
        model.setRowCount(0);
        
        String query = "SELECT * FROM clothing ORDER BY id DESC";
        
        try {
            Connection con = CONN.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                Object[] row = {
                  rs.getInt("id"),
                  rs.getString("name"),
                  rs.getString("type"),
                  rs.getString("size"),
                  rs.getString("gender"),
                  rs.getString("price"),
                  rs.getString("description"),
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
             
                 public void loadAccessories1() {
     
        DefaultTableModel model = (DefaultTableModel) TACCESSORIES.getModel();
        model.setRowCount(0);
        
        String query = "SELECT * FROM accessories ORDER BY id DESC";
        
        try {
            Connection con = CONN.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                Object[] row = {
                  rs.getInt("id"),
                  rs.getString("name"),
                  rs.getString("type"),
                  rs.getString("design_style"),
                  rs.getString("material"),
                  rs.getString("color"),
                  rs.getString("price"),
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
       
       
             
                    public void loadDesign1() {
     
        DefaultTableModel model = (DefaultTableModel) TDECORATION.getModel();
        model.setRowCount(0);
        
        String query = "SELECT * FROM design ORDER BY id DESC";
        
        try {
            Connection con = CONN.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                Object[] row = {
                  rs.getInt("id"),
                  rs.getString("name"),
                  rs.getString("notes"),
                  rs.getString("type"),
                  rs.getString("material"),
                  rs.getString("price"),
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
       
       
       
                 public void loadToy1() {
     
        DefaultTableModel model = (DefaultTableModel) TTOYY.getModel();
        model.setRowCount(0);
        
        String query = "SELECT * FROM toy ORDER BY id DESC";
        
        try {
            Connection con = CONN.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                Object[] row = {
                  rs.getInt("id"),
                  rs.getString("character_name"),
                  rs.getString("franchise"),
                  rs.getInt("height_cm"),
                  rs.getInt("articulation_points"),
                  rs.getString("material"),
                  rs.getString("release_date"),
                  rs.getInt("price"),
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        
        }
    }
       
       
            public void loadFood1() {
     
        DefaultTableModel model = (DefaultTableModel) TFOOD.getModel();
        model.setRowCount(0);
        
        String query = "SELECT * FROM food ORDER BY id DESC";
        
        try {
            Connection con = CONN.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                Object[] row = {
                  rs.getInt("id"),
                  rs.getString("name"),
                  rs.getString("food_type"),
                  rs.getInt("price"),
                  rs.getString("date_added"),
                  rs.getString("expiration_date"),
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
       
       
             public void updateProducts() { //Total Event Count Method
    try {
        Connection con = CONN.getConnection();
        String sql = "SELECT COUNT(*) FROM products_info"; 
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            int count = rs.getInt(1); // Get the count from query
            productscount.setText("PRODUCTS:   " + count); // Update JLabel
        }

        rs.close();
        pst.close();
        con.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error retrieving member count: " + ex.getMessage());
    }
}
       
       
              
       public void updateSupplier() { //Total Event Count Method
    try {
        Connection con = CONN.getConnection();
        String sql = "SELECT COUNT(*) FROM suppliers"; 
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            int count = rs.getInt(1); // Get the count from query
            suppliercount.setText("SUPPLIER:   " + count); // Update JLabel
        }

        rs.close();
        pst.close();
        con.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error retrieving member count: " + ex.getMessage());
    }
}
       
         public void updateUser() { //Total Event Count Method
    try {
        Connection con = CONN.getConnection();
        String sql = "SELECT COUNT(*) FROM accdetails"; 
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            int count = rs.getInt(1); // Get the count from query
            usercount3.setText("USER:   " + count); // Update JLabel
        }

        rs.close();
        pst.close();
        con.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error retrieving member count: " + ex.getMessage());
    }
}
  
       
       
       public void dt() {
        
        Date d =new Date();
        
        SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd");
        String dd = sfd.format(d);
        petsa.setText(dd);
    }
    
    //time
    
    public void time() {
        
        new Timer (0,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Date d = new Date ();
                SimpleDateFormat s = new SimpleDateFormat("hh-mm-ss");
                String tim = s.format(d);
                oras.setText(tim);
                
                
            }
        }).start();
    }
       
       
        public void loadProduct() {
     
        DefaultTableModel model = (DefaultTableModel) Tproducts.getModel();
        model.setRowCount(0);
        
        String query = "SELECT * FROM products_info ORDER BY product_id DESC";
        
        try {
            Connection con = CONN.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                Object[] row = {
                  rs.getInt("product_id"),
                  rs.getString("product_name"),
                  rs.getString("description"),
                  rs.getInt("price"),
                  rs.getInt("stock_quantity"),
                  rs.getString("date_added"),
                  rs.getString("category_name")
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }  
   
        
        
        private void fetchProductData(int userId) {
    String query = "SELECT * FROM products_info WHERE product_id = ?";

    try {
        con = CONN.getConnection();
        PreparedStatement pst = con.prepareStatement(query);

        pst.setInt(1, userId);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            txtproductname.setText(rs.getString("product_name"));
            descriptiontxt.setText(rs.getString("description"));
            txtprice.setText(rs.getString("price"));
            txtstock.setText(rs.getString("stock_quantity"));
            datetxt.setDateFormatString(rs.getString("date_added"));
            ComboBox.setSelectedItem(rs.getString("category_name"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
        
       
     /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        asdasdasd = new javax.swing.JLabel();
        petsa = new javax.swing.JLabel();
        oras = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jLabel89 = new javax.swing.JLabel();
        foodcount1 = new javax.swing.JLabel();
        toycount1 = new javax.swing.JLabel();
        decocount1 = new javax.swing.JLabel();
        accecount1 = new javax.swing.JLabel();
        clocount1 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        TFOOD = new javax.swing.JTable();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        TxtFood = new javax.swing.JTextField();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        TTOYY = new javax.swing.JTable();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        TXtToy = new javax.swing.JTextField();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        TDECORATION = new javax.swing.JTable();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        TxtDecoration = new javax.swing.JTextField();
        jPanel24 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        TACCESSORIES = new javax.swing.JTable();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        TxtAccessories = new javax.swing.JTextField();
        jPanel25 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        Tproducts7 = new javax.swing.JTable();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        TxtCLOTHING = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        FOOD = new javax.swing.JLabel();
        TOYYY = new javax.swing.JLabel();
        DECORATION = new javax.swing.JLabel();
        ACCESSORIES = new javax.swing.JLabel();
        CLOTHING = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        usercount1 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        suppliercount1 = new javax.swing.JLabel();
        asd = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        productscount = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        usercount3 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        suppliercount = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtprice = new javax.swing.JTextField();
        txtstock = new javax.swing.JTextField();
        ComboBox = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tproducts = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        Insert = new javax.swing.JButton();
        txtproductname = new javax.swing.JTextField();
        clear = new javax.swing.JButton();
        descriptiontxt = new javax.swing.JTextField();
        datetxt = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 153, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel22.setText("DATE:");
        jPanel7.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 8, -1, -1));

        asdasdasd.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        asdasdasd.setText("TIME:");
        jPanel7.add(asdasdasd, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 46, -1, -1));

        petsa.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        petsa.setText("0");
        jPanel7.add(petsa, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 11, 115, -1));

        oras.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        oras.setText("0");
        jPanel7.add(oras, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 49, 115, -1));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1720, 53, -1, -1));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 0, 204));
        jLabel16.setText("PRODUCTS INFORMATION SYSTEM(PIS) for Diossa's Station ");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 53, 1342, 57));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1980, 180));

        jPanel2.setBackground(new java.awt.Color(255, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EMPLOYEE");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-home-page-50 (1).png"))); // NOI18N
        jLabel2.setText("HOME PAGE");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-fast-moving-consumer-goods-50.png"))); // NOI18N
        jLabel3.setText("Products");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-magnifying-glass-50.png"))); // NOI18N
        jLabel4.setText("Search Products");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("LOG OUT");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 153, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-user-100.png"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-records-50.png"))); // NOI18N
        jLabel36.setText("REPORTS");
        jLabel36.setAutoscrolls(true);
        jLabel36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel36MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel36)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 228, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 270, 900));

        jPanel4.setBackground(new java.awt.Color(255, 204, 255));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/diossa'sBackground (2).jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 1462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab2", jPanel4);

        jPanel3.setBackground(new java.awt.Color(255, 204, 255));

        jPanel28.setBackground(new java.awt.Color(255, 153, 255));
        jPanel28.setBorder(javax.swing.BorderFactory.createMatteBorder(30, 10, 10, 10, new java.awt.Color(255, 102, 255)));

        jLabel89.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel89.setText("PRODUCTS");

        foodcount1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        foodcount1.setText("FOOD");
        foodcount1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 102, 255)));

        toycount1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        toycount1.setText("TOY");
        toycount1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 102, 255)));

        decocount1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        decocount1.setText("DECORATION");
        decocount1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 102, 255)));

        accecount1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        accecount1.setText("ACCESSORIES");
        accecount1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 102, 255)));

        clocount1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        clocount1.setText("CLOTHING");
        clocount1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(foodcount1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(toycount1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(decocount1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(accecount1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(clocount1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(foodcount1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(toycount1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(decocount1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(accecount1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(clocount1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1650, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(412, 412, 412)
                    .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(413, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 905, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(141, 141, 141)
                    .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(142, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("tab4", jPanel3);

        jPanel9.setBackground(new java.awt.Color(255, 153, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel21.setBackground(new java.awt.Color(255, 204, 255));

        TFOOD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "FOOD ID", "FOOD NAME", "FOOD TYPE", "PRICE", "DATE ADDED	", "EXPIRATION DATE "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TFOOD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TFOODMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(TFOOD);

        jLabel78.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel78.setText("SEARCH FOOD");

        jLabel79.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel79.setText("SEARCH:");

        TxtFood.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TxtFood.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TxtFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtFoodActionPerformed(evt);
            }
        });
        TxtFood.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtFoodKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtFood, javax.swing.GroupLayout.PREFERRED_SIZE, 869, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(529, 529, 529)
                        .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 1277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtFood, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel79, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab1", jPanel21);

        jPanel22.setBackground(new java.awt.Color(255, 204, 255));

        TTOYY.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "PRODUCT ID", "CHARACTER NAME", "FRANCHISE", "HEIGHT", "ARTICULATION", "MATERIAL", "RELEASE DATE", "PRICE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TTOYY.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TTOYYMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(TTOYY);

        jLabel80.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel80.setText("SEARCH TOY");

        jLabel81.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel81.setText("SEARCH:");

        TXtToy.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TXtToy.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TXtToy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXtToyActionPerformed(evt);
            }
        });
        TXtToy.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXtToyKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXtToy, javax.swing.GroupLayout.PREFERRED_SIZE, 869, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(529, 529, 529)
                        .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 1277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TXtToy, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel81, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab2", jPanel22);

        jPanel23.setBackground(new java.awt.Color(255, 204, 255));

        TDECORATION.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "product_id", "product_name", "description", "type", "material", "price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TDECORATION.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TDECORATIONMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(TDECORATION);

        jLabel82.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel82.setText("SEARCH DECORATION");

        jLabel83.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel83.setText("SEARCH:");

        TxtDecoration.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TxtDecoration.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TxtDecoration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtDecorationActionPerformed(evt);
            }
        });
        TxtDecoration.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtDecorationKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtDecoration, javax.swing.GroupLayout.PREFERRED_SIZE, 869, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(529, 529, 529)
                        .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 1277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtDecoration, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel83, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab3", jPanel23);

        jPanel24.setBackground(new java.awt.Color(255, 204, 255));

        TACCESSORIES.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "PRODUCT ID", "PRODUCT NAME", "TYPE", "DESIGN STYLE", "MATERIAL", "COLOR", "PRICE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TACCESSORIES.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TACCESSORIESMouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(TACCESSORIES);

        jLabel84.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel84.setText("SEARCH ACCESSORIES");

        jLabel85.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel85.setText("SEARCH:");

        TxtAccessories.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TxtAccessories.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TxtAccessories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtAccessoriesActionPerformed(evt);
            }
        });
        TxtAccessories.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtAccessoriesKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtAccessories, javax.swing.GroupLayout.PREFERRED_SIZE, 869, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(529, 529, 529)
                        .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 1277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtAccessories, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel85, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(272, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab4", jPanel24);

        jPanel25.setBackground(new java.awt.Color(255, 204, 255));

        Tproducts7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "product_id", "product_name", "TYPE", "SIZE", "GENDER", "PRICE", "DESCRIPTION"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Tproducts7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tproducts7MouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(Tproducts7);

        jLabel86.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel86.setText("SEARCH CLOTHING");

        jLabel87.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel87.setText("SEARCH:");

        TxtCLOTHING.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TxtCLOTHING.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TxtCLOTHING.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtCLOTHINGActionPerformed(evt);
            }
        });
        TxtCLOTHING.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtCLOTHINGKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtCLOTHINGKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtCLOTHING, javax.swing.GroupLayout.PREFERRED_SIZE, 869, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(529, 529, 529)
                        .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 1277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtCLOTHING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel87, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab5", jPanel25);

        jPanel9.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 17, 1387, 1090));

        jPanel20.setBackground(new java.awt.Color(255, 153, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        jPanel20.setForeground(new java.awt.Color(255, 255, 255));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FOOD.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        FOOD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FOOD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-magnifying-glass-50.png"))); // NOI18N
        FOOD.setText("SEARCH FOOD ");
        FOOD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FOODMouseClicked(evt);
            }
        });
        jPanel20.add(FOOD, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 233, -1, -1));

        TOYYY.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TOYYY.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TOYYY.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-magnifying-glass-50.png"))); // NOI18N
        TOYYY.setText("SEARCH TOY");
        TOYYY.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TOYYYMouseClicked(evt);
            }
        });
        jPanel20.add(TOYYY, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 313, 254, -1));

        DECORATION.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        DECORATION.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DECORATION.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-magnifying-glass-50.png"))); // NOI18N
        DECORATION.setText("SEARCH DECORATION");
        DECORATION.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DECORATIONMouseClicked(evt);
            }
        });
        jPanel20.add(DECORATION, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 393, -1, -1));

        ACCESSORIES.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ACCESSORIES.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ACCESSORIES.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-magnifying-glass-50.png"))); // NOI18N
        ACCESSORIES.setText("SEARCH ACCESSORIES");
        ACCESSORIES.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ACCESSORIESMouseClicked(evt);
            }
        });
        jPanel20.add(ACCESSORIES, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 473, 254, -1));

        CLOTHING.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        CLOTHING.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CLOTHING.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-magnifying-glass-50.png"))); // NOI18N
        CLOTHING.setText("SEARCH CLOTHING");
        CLOTHING.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CLOTHINGMouseClicked(evt);
            }
        });
        jPanel20.add(CLOTHING, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 553, 238, -1));

        jPanel9.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -5, 260, 930));

        jTabbedPane1.addTab("tab6", jPanel9);

        jPanel10.setBackground(new java.awt.Color(255, 204, 255));

        jPanel12.setBackground(new java.awt.Color(255, 153, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createMatteBorder(30, 5, 5, 5, new java.awt.Color(255, 102, 255)));

        usercount1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        usercount1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usercount1.setText("USER: 0");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(usercount1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(usercount1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(255, 153, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createMatteBorder(30, 5, 5, 5, new java.awt.Color(255, 102, 255)));

        suppliercount1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        suppliercount1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        suppliercount1.setText("SUPPLIER:   0");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(suppliercount1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(suppliercount1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
        );

        asd.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        asd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        asd.setText("SUPPLIER & USER ");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(244, 244, 244)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(614, 614, 614)
                        .addComponent(asd, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(334, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(asd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(262, 262, 262))
        );

        jTabbedPane1.addTab("tab6", jPanel10);

        jPanel8.setBackground(new java.awt.Color(255, 204, 255));

        jPanel11.setBackground(new java.awt.Color(255, 153, 255));
        jPanel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        productscount.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        productscount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        productscount.setText("PRODUCTS: 0");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(productscount, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(productscount, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );

        jPanel15.setBackground(new java.awt.Color(255, 153, 255));
        jPanel15.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        usercount3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        usercount3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usercount3.setText("USER: 0");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(usercount3, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addComponent(usercount3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );

        jPanel16.setBackground(new java.awt.Color(255, 153, 255));
        jPanel16.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        suppliercount.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        suppliercount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        suppliercount.setText("SUPPLIER:   0");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(suppliercount, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addComponent(suppliercount, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(219, 219, 219)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 347, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(275, 275, 275))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(599, 599, 599)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(94, 94, 94)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(164, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab4", jPanel8);

        jPanel5.setBackground(new java.awt.Color(255, 204, 255));

        txtprice.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpriceActionPerformed(evt);
            }
        });

        txtstock.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtstock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstockActionPerformed(evt);
            }
        });

        ComboBox.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ComboBox.setForeground(new java.awt.Color(204, 0, 204));
        ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FOOD", "TOY", "ACCESSORIES", "DESIGN", "CLOTHING", " " }));
        ComboBox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 0, 153));
        jLabel7.setText("Product Name:");

        Tproducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "product_id", "product_name", "description", "price", "stock_quantity	", "category_id", "date_added"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Tproducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TproductsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tproducts);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 0, 153));
        jLabel8.setText("Description:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 0, 153));
        jLabel9.setText("category:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 0, 153));
        jLabel10.setText("Stock:");

        jButton1.setBackground(new java.awt.Color(255, 102, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("UPDATE");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 0, 153));
        jLabel11.setText("Price:");

        jButton2.setBackground(new java.awt.Color(255, 102, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setText("DELETE");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 0, 153));
        jLabel12.setText("Date added:");

        Insert.setBackground(new java.awt.Color(255, 102, 255));
        Insert.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Insert.setText("INSERT");
        Insert.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertActionPerformed(evt);
            }
        });

        txtproductname.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtproductname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtproductnameActionPerformed(evt);
            }
        });

        clear.setBackground(new java.awt.Color(255, 51, 255));
        clear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        clear.setText("CLEAR");
        clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearMouseClicked(evt);
            }
        });

        descriptiontxt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        descriptiontxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descriptiontxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1650, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(181, 181, 181)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(101, 101, 101)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel11)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtproductname, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                        .addComponent(descriptiontxt))
                                    .addGap(54, 54, 54)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel9))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtstock, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(37, 37, 37)
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(datetxt, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(Insert, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGap(182, 182, 182)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 905, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(77, 77, 77)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtstock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtproductname, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(15, 15, 15)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(descriptiontxt, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGap(8, 8, 8)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(datetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(7, 7, 7))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(Insert, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(29, 29, 29)
                    .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(45, 45, 45)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(148, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("tab3", jPanel5);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 1650, 940));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:

        jTabbedPane1.setSelectedIndex(0);

        
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:

        jTabbedPane1.setSelectedIndex(1);

        
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:

        jTabbedPane1.setSelectedIndex(2);
        
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:

        Login Log = new Login();
        Log.show();
        dispose();
        
    }//GEN-LAST:event_jLabel5MouseClicked

    private void txtpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpriceActionPerformed

    private void txtstockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstockActionPerformed

    private void TproductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TproductsMouseClicked
        // TODO add your handling code here:

        int selectedRow = Tproducts.getSelectedRow();

        if (selectedRow >= 0) {
            int Id = Integer.parseInt(Tproducts.getValueAt(selectedRow, 0).toString());
            fetchProductData(Id);
        }

    }//GEN-LAST:event_TproductsMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        SimpleDateFormat sdf = new SimpleDateFormat ("yyyy/MM/dd");

        int selectedRow = Tproducts.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a product to update.");
            return;
        }

        int productId = Integer.parseInt(Tproducts.getValueAt(selectedRow, 0).toString());

        // Get text values

        String productN = txtproductname.getText().trim();
        String description = descriptiontxt.getText().trim();
        String price = txtprice.getText().trim();
        String stock = txtstock.getText().trim();
        String category = ComboBox.getSelectedItem().toString().trim();
        Date dateAdded = datetxt.getDate();

        // Check if any field is empty
        if (productN.isEmpty() || description.isEmpty() || price.isEmpty() || stock.isEmpty() || category.isEmpty() || dateAdded == null) {
            JOptionPane.showMessageDialog(null, "All fields must be filled out!");
            return;
        }

        try {
            int totalCopies = Integer.parseInt(stock);
            int availableCopies = Integer.parseInt(price);
            java.sql.Date sqlDate = new java.sql.Date(dateAdded.getTime());

            String query = "UPDATE products_info SET product_name=?, description=?, price=?, stock_quantity=?, date_added=?, category_name=? WHERE product_id";

            con = CONN.getConnection();
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, productN);
            pst.setString(2, description);
            pst.setString(3, price);
            pst.setString(4, stock);
            pst.setDate(5, sqlDate);
            pst.setString(6, category);

            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "product updated successfully.");

                txtproductname.setText("");
                descriptiontxt.setText("");
                txtprice.setText("");
                txtstock.setText("");
                datetxt.setDate(null);
                ComboBox.setSelectedIndex(0);

                loadProduct(); // Refresh table
            } else {
                JOptionPane.showMessageDialog(null, "No product was updated. Please check the ID.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid number format for copies! Please enter valid numbers.");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error updating product.");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        int selectedRow = Tproducts.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a user to delete.");
            return;
        }

        int userId = Integer.parseInt(Tproducts.getValueAt(selectedRow, 0).toString());

        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this user?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            String query = "DELETE FROM products_info WHERE product_id=?";

            try {
                con = CONN.getConnection();
                PreparedStatement pst = con.prepareStatement(query);
                pst.setInt(1, userId);

                int rowsDeleted = pst.executeUpdate();
                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(null, "User deleted successfully."); // Refresh Table

                    loadProduct();

                }

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error deleting user.");
            }
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertActionPerformed
        // TODO add your handling code here:

        SimpleDateFormat sdf = new SimpleDateFormat ("yyyy/MM/dd");

        try {
            String productN = txtproductname.getText().trim();
            String description = descriptiontxt.getText().trim();
            String price = txtprice.getText().trim();
            String stock = txtstock.getText().trim();
            String category = ComboBox.getSelectedItem().toString().trim();
            Date dateAdded = datetxt.getDate();

            // String dt = sdf.format(datetxt.getDate());

            // Check if any field is empty
            if (productN.isEmpty() || description.isEmpty() || price.isEmpty() || stock.isEmpty() || category.isEmpty() || dateAdded == null) {
                JOptionPane.showMessageDialog(rootPane, "No input! Please fill in all fields.");
                return;
            }

            // Convert copies anintd available to integers
            int totalCopies = Integer.parseInt(stock);
            int availableCopies = Integer.parseInt(price);

            java.sql.Date sqlDate = new java.sql.Date(dateAdded.getTime());

            // Database connection
            con = CONN.getConnection();

            // Insert new book record
            String insertQuery = "INSERT INTO products_info (product_name, description, price, stock_quantity, date_added, category_name) VALUES (?, ?, ?, ?, ?, ?)";
            pst = con.prepareStatement(insertQuery);
            pst.setString(1, productN);
            pst.setString(2, description);
            pst.setString(3, price);
            pst.setString(4, stock);
            pst.setDate(5, sqlDate);
            pst.setString(6, category);

            int k = pst.executeUpdate();

            if (k == 1) {
                JOptionPane.showMessageDialog(rootPane, "Product added successfully!");
                // Clear fields after successful insert
                txtproductname.setText("");
                descriptiontxt.setText("");
                txtprice.setText("");
                txtstock.setText("");
                datetxt.setDate(null);
                ComboBox.setSelectedIndex(0);

            } else {
                JOptionPane.showMessageDialog(rootPane, "Failed to add products");
            }
            loadProduct();

        } catch (Exception ex) {
            Logger.getLogger(AdminPage.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Error occurred while adding the product.");
            JOptionPane.showMessageDialog(rootPane, "Invalid number format for copies!");
        }

    }//GEN-LAST:event_InsertActionPerformed

    private void txtproductnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtproductnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtproductnameActionPerformed

    private void clearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearMouseClicked
        // TODO add your handling code here:

        txtproductname.setText("");
        descriptiontxt.setText("");
        txtprice.setText("");
        txtstock.setText("");
        datetxt.setDate(null);

    }//GEN-LAST:event_clearMouseClicked

    private void descriptiontxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descriptiontxtActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_descriptiontxtActionPerformed

    private void jLabel36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel36MouseClicked
        // TODO add your handling code here:

        jTabbedPane1.setSelectedIndex(3);

    }//GEN-LAST:event_jLabel36MouseClicked

    private void TFOODMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TFOODMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TFOODMouseClicked

    private void TxtFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtFoodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtFoodActionPerformed

    private void TxtFoodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtFoodKeyReleased
        // TODO add your handling code here:

        DefaultTableModel ob =  (DefaultTableModel) TFOOD.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<> (ob);
        TFOOD.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(TxtFood.getText()));

    }//GEN-LAST:event_TxtFoodKeyReleased

    private void TTOYYMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TTOYYMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TTOYYMouseClicked

    private void TXtToyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXtToyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXtToyActionPerformed

    private void TXtToyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXtToyKeyReleased
        // TODO add your handling code here:

        DefaultTableModel ob =  (DefaultTableModel) TTOYY.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<> (ob);
        TTOYY.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(TXtToy.getText()));

    }//GEN-LAST:event_TXtToyKeyReleased

    private void TDECORATIONMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TDECORATIONMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TDECORATIONMouseClicked

    private void TxtDecorationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtDecorationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtDecorationActionPerformed

    private void TxtDecorationKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtDecorationKeyReleased
        // TODO add your handling code here:

        DefaultTableModel ob =  (DefaultTableModel) TDECORATION.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<> (ob);
        TDECORATION.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(TxtDecoration.getText()));

    }//GEN-LAST:event_TxtDecorationKeyReleased

    private void TACCESSORIESMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TACCESSORIESMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TACCESSORIESMouseClicked

    private void TxtAccessoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtAccessoriesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtAccessoriesActionPerformed

    private void TxtAccessoriesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtAccessoriesKeyReleased
        // TODO add your handling code here:

        DefaultTableModel ob =  (DefaultTableModel) TACCESSORIES.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<> (ob);
        TACCESSORIES.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(TxtAccessories.getText()));

    }//GEN-LAST:event_TxtAccessoriesKeyReleased

    private void Tproducts7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tproducts7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Tproducts7MouseClicked

    private void TxtCLOTHINGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCLOTHINGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtCLOTHINGActionPerformed

    private void TxtCLOTHINGKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtCLOTHINGKeyReleased
        // TODO add your handling code here:

        DefaultTableModel ob =  (DefaultTableModel) Tproducts7.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<> (ob);
        Tproducts7.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(TxtCLOTHING.getText()));

    }//GEN-LAST:event_TxtCLOTHINGKeyReleased

    private void TxtCLOTHINGKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtCLOTHINGKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtCLOTHINGKeyTyped

    private void FOODMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FOODMouseClicked
        // TODO add your handling code here:

        jTabbedPane2.setSelectedIndex(4);

    }//GEN-LAST:event_FOODMouseClicked

    private void TOYYYMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TOYYYMouseClicked
        // TODO add your handling code here:

        jTabbedPane2.setSelectedIndex(0);

    }//GEN-LAST:event_TOYYYMouseClicked

    private void DECORATIONMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DECORATIONMouseClicked
        // TODO add your handling code here:

        jTabbedPane2.setSelectedIndex(1);

    }//GEN-LAST:event_DECORATIONMouseClicked

    private void ACCESSORIESMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ACCESSORIESMouseClicked
        // TODO add your handling code here:

        jTabbedPane2.setSelectedIndex(2);

    }//GEN-LAST:event_ACCESSORIESMouseClicked

    private void CLOTHINGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CLOTHINGMouseClicked
        // TODO add your handling code here:

        jTabbedPane2.setSelectedIndex(3);

    }//GEN-LAST:event_CLOTHINGMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(EmployeePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ACCESSORIES;
    private javax.swing.JLabel CLOTHING;
    private javax.swing.JComboBox<String> ComboBox;
    private javax.swing.JLabel DECORATION;
    private javax.swing.JLabel FOOD;
    private javax.swing.JButton Insert;
    private javax.swing.JTable TACCESSORIES;
    private javax.swing.JTable TDECORATION;
    private javax.swing.JTable TFOOD;
    private javax.swing.JLabel TOYYY;
    private javax.swing.JTable TTOYY;
    private javax.swing.JTextField TXtToy;
    private javax.swing.JTable Tproducts;
    private javax.swing.JTable Tproducts7;
    private javax.swing.JTextField TxtAccessories;
    private javax.swing.JTextField TxtCLOTHING;
    private javax.swing.JTextField TxtDecoration;
    private javax.swing.JTextField TxtFood;
    private javax.swing.JLabel accecount1;
    private javax.swing.JLabel asd;
    private javax.swing.JLabel asdasdasd;
    private javax.swing.JButton clear;
    private javax.swing.JLabel clocount1;
    private com.toedter.calendar.JDateChooser datetxt;
    private javax.swing.JLabel decocount1;
    private javax.swing.JTextField descriptiontxt;
    private javax.swing.JLabel foodcount1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel oras;
    private javax.swing.JLabel petsa;
    private javax.swing.JLabel productscount;
    private javax.swing.JLabel suppliercount;
    private javax.swing.JLabel suppliercount1;
    private javax.swing.JLabel toycount1;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txtproductname;
    private javax.swing.JTextField txtstock;
    private javax.swing.JLabel usercount1;
    private javax.swing.JLabel usercount3;
    // End of variables declaration//GEN-END:variables
}
