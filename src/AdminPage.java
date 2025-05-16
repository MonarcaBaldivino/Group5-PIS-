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
public class AdminPage extends javax.swing.JFrame {

    /**
     * Creates new form AdminPage
     */
    public AdminPage() {
        initComponents();
        loadProduct();
        loadUser();
        loadProduct1();
        time();
        dt();
        loadSupplier();
        updateSupplier();
        updateUser();
        loadFood();
        loadToy();
        loadDesign();
        loadAccessories();
        loadClothing();
        loadFood1();
        loadToy1();
        loadDesign1();
        loadAccessories1();
        loadClothing1();
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
            clocount.setText("CLOTHINGS:   " + count); // Update JLabel
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
            accecount.setText("ACCESSORIES:   " + count); // Update JLabel
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
            foodcount.setText("FOOD:   " + count); // Update JLabel
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
            toycount.setText("TOYS:   " + count); // Update JLabel
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
            decocount.setText("DECORATIONS:   " + count); // Update JLabel
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
       
                    public void loadClothing() {
     
        DefaultTableModel model = (DefaultTableModel) Tproducts6.getModel();
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
       
       
       private void fetchClothingData(int toyId) {
    String query = "SELECT * FROM clothing WHERE id = ?";

    try {
        con = CONN.getConnection();
        PreparedStatement pst = con.prepareStatement(query);

        pst.setInt(1, toyId);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            ClothingName.setText(rs.getString("name"));
            ClothingType.setText(rs.getString("type"));
            ClothingSize.setText(rs.getString("size"));
            ClothingGender.setSelectedItem(rs.getString("gender"));
            txtstock6.setText(rs.getString("price"));
            txtstock5.setText(rs.getString("description"));


        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
                }
       
    private void fetchAccessoriesData(int toyId) {
    String query = "SELECT * FROM accessories WHERE id = ?";

    try {
        con = CONN.getConnection();
        PreparedStatement pst = con.prepareStatement(query);

        pst.setInt(1, toyId);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            PNacc.setText(rs.getString("name"));
            TypeAcc.setText(rs.getString("type"));
            DStyleacc.setText(rs.getString("design_style"));
            c.setText(rs.getString("material"));
            colorAcc.setText(rs.getString("color"));
            AccPrice.setText(rs.getString("price"));


        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
                }
       
                 public void loadAccessories() {
     
        DefaultTableModel model = (DefaultTableModel) TAccessories.getModel();
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
       
       
                    public void loadDesign() {
     
        DefaultTableModel model = (DefaultTableModel) TDecoration.getModel();
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
       

    private void fetchDesignData(int toyId) {
    String query = "SELECT * FROM design WHERE id = ?";

    try {
        con = CONN.getConnection();
        PreparedStatement pst = con.prepareStatement(query);

        pst.setInt(1, toyId);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            TXTPRODUCTNAME.setText(rs.getString("name"));
            DESDEC.setText(rs.getString("notes"));
            DECTYPE.setText(rs.getString("type"));
            MATERIALDEC.setText(rs.getString("material"));
            DECPRICE.setText(rs.getString("price"));

        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
                }
       
        
        
    private void fetchToyData(int toyId) {
    String query = "SELECT * FROM toy WHERE id = ?";

    try {
        con = CONN.getConnection();
        PreparedStatement pst = con.prepareStatement(query);

        pst.setInt(1, toyId);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            CharNamee.setText(rs.getString("character_name"));
            Franchise.setText(rs.getString("franchise"));
            height.setText(rs.getString("height_cm"));
            points.setText(rs.getString("articulation_points"));
            material.setText(rs.getString("material"));
            dateAdded.setDateFormatString(rs.getString("release_date"));
            pricetxt.setText(rs.getString("price"));

        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
                }
       
              public void loadToy() {
     
        DefaultTableModel model = (DefaultTableModel) TToy.getModel();
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
       
         public void loadFood() {
     
        DefaultTableModel model = (DefaultTableModel) TproductsFood.getModel();
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
       
       
         private void fetchFoodData(int foodId) {
    String query = "SELECT * FROM food WHERE id = ?";

    try {
        con = CONN.getConnection();
        PreparedStatement pst = con.prepareStatement(query);

        pst.setInt(1, foodId);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            FoodNtxt.setText(rs.getString("name"));
            FoodTtxt.setText(rs.getString("food_type"));
            FoodPtxt.setText(rs.getString("price"));
            DateFoodAdd.setDateFormatString(rs.getString("date_added"));
            DateFoodEx.setDateFormatString(rs.getString("expiration_date"));

        }
    } catch (SQLException e) {
        e.printStackTrace();
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
            usercount.setText("ACCOUNTS:   " + count); // Update JLabel
        }

        rs.close();
        pst.close();
        con.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error retrieving member count: " + ex.getMessage());
    }
}
         
         private void fetchSupplyData(int Supplyid) {
    String query = "SELECT * FROM suppliers WHERE Supplier_ID = ?";

    try {
        con = CONN.getConnection();
        PreparedStatement pst = con.prepareStatement(query);

        
        pst.setInt(1, Supplyid);
        ResultSet rs = pst.executeQuery();
        
        if (rs.next()) {
            txtSname.setText(rs.getString("Supplier_Name"));
            txtsocial.setText(rs.getString("Contact_Person"));
            txtNumber.setText(rs.getString("Phone_Number"));
            txtEmail.setText(rs.getString("Email_Address"));
            txtddress.setText(rs.getString("Address"));
            txtdes.setText(rs.getString("supplydes"));

        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
       
         public void loadSupplier() {
     
        DefaultTableModel model = (DefaultTableModel) Tsup.getModel();
        model.setRowCount(0);
        
        String query = "SELECT * FROM suppliers ORDER BY Supplier_ID DESC";
        
        try {
            Connection con = CONN.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                Object[] row = {
                  rs.getInt("Supplier_ID"),
                  rs.getString("Supplier_Name"),
                  rs.getString("Contact_Person"),
                  rs.getString("Phone_Number"),
                  rs.getString("Email_Address"),
                  rs.getString("Address"),
                  rs.getString("supplydes"),
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
    
         public void loadProduct1() {
     
        DefaultTableModel model = (DefaultTableModel) Tproducts1.getModel();
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
    
         public void loadUser() {
     
        DefaultTableModel model = (DefaultTableModel) Tuser.getModel();
        model.setRowCount(0);
        
        String query = "SELECT * FROM accdetails ORDER BY id_user DESC";
        
        try {
            Connection con = CONN.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                Object[] row = {
                  rs.getInt("id_user"),
                  rs.getString("NAME"),
                  rs.getString("username"),
                  rs.getString("password"),
                  rs.getString("role"),
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
       
         private void fetchUserData(int USERID) {
    String query = "SELECT * FROM accdetails WHERE id_user=?";

    try {
        con = CONN.getConnection();
        PreparedStatement pst = con.prepareStatement(query);

        pst.setInt(1, USERID);
        ResultSet rs = pst.executeQuery();
        
        if (rs.next()) {
            nametxt.setText(rs.getString("NAME"));
            usertxt.setText(rs.getString("username"));
            passtxt.setText(rs.getString("password"));
            roletxt.setSelectedItem(rs.getString("role"));
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
        jPanel6 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        asdasdasd = new javax.swing.JLabel();
        petsa = new javax.swing.JLabel();
        oras = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        TabPaneManagement = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        TabPaneCategory = new javax.swing.JTabbedPane();
        ProductCategoryTab = new javax.swing.JPanel();
        FoodNtxt = new javax.swing.JTextField();
        clear1 = new javax.swing.JButton();
        FoodTtxt = new javax.swing.JTextField();
        DateFoodAdd = new com.toedter.calendar.JDateChooser();
        FoodPtxt = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        TproductsFood = new javax.swing.JTable();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        UpdateFood = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        InsertFood = new javax.swing.JButton();
        DateFoodEx = new com.toedter.calendar.JDateChooser();
        jPanel16 = new javax.swing.JPanel();
        CharNamee = new javax.swing.JTextField();
        clear2 = new javax.swing.JButton();
        Franchise = new javax.swing.JTextField();
        dateAdded = new com.toedter.calendar.JDateChooser();
        height = new javax.swing.JTextField();
        pricetxt = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        TToy = new javax.swing.JTable();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        INSERTToy = new javax.swing.JButton();
        jLabel74 = new javax.swing.JLabel();
        material = new javax.swing.JTextField();
        points = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        TXTPRODUCTNAME = new javax.swing.JTextField();
        clear3 = new javax.swing.JButton();
        DESDEC = new javax.swing.JTextField();
        DECTYPE = new javax.swing.JTextField();
        MATERIALDEC = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        TDecoration = new javax.swing.JTable();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        DecorUpdate = new javax.swing.JButton();
        jLabel58 = new javax.swing.JLabel();
        DecorINSERT = new javax.swing.JButton();
        DECPRICE = new javax.swing.JTextField();
        ProductsCategory = new javax.swing.JPanel();
        PNacc = new javax.swing.JTextField();
        clear4 = new javax.swing.JButton();
        TypeAcc = new javax.swing.JTextField();
        DStyleacc = new javax.swing.JTextField();
        AccPrice = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        TAccessories = new javax.swing.JTable();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        UPDATEACCESSORIES = new javax.swing.JButton();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        INSERTACC = new javax.swing.JButton();
        c = new javax.swing.JTextField();
        colorAcc = new javax.swing.JTextField();
        jPanel19 = new javax.swing.JPanel();
        ClothingName = new javax.swing.JTextField();
        clear5 = new javax.swing.JButton();
        ClothingType = new javax.swing.JTextField();
        ClothingSize = new javax.swing.JTextField();
        txtstock5 = new javax.swing.JTextField();
        ClothingGender = new javax.swing.JComboBox<>();
        jLabel67 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        Tproducts6 = new javax.swing.JTable();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        Insert5 = new javax.swing.JButton();
        txtstock6 = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
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
        jPanel10 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        usertxt = new javax.swing.JTextField();
        USERinsertBtn = new javax.swing.JButton();
        passtxt = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        USERdeleteBtn = new javax.swing.JButton();
        USERupdateBtn = new javax.swing.JButton();
        USERclearBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tuser = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        nametxt = new javax.swing.JTextField();
        roletxt = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        txtSname = new javax.swing.JTextField();
        clearS = new javax.swing.JButton();
        txtsocial = new javax.swing.JTextField();
        txtNumber = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Tsup = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        UpdateSupplier = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        DeleteSupplier = new javax.swing.JButton();
        InsertSupplier = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtddress = new javax.swing.JTextArea();
        jLabel25 = new javax.swing.JLabel();
        txtdes = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        suppliercount = new javax.swing.JLabel();
        usercount1 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        usercount = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel88 = new javax.swing.JLabel();
        foodcount = new javax.swing.JLabel();
        toycount = new javax.swing.JLabel();
        decocount = new javax.swing.JLabel();
        accecount = new javax.swing.JLabel();
        clocount = new javax.swing.JLabel();
        totals = new javax.swing.JLabel();
        clocount1 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tproducts1 = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        searchtxt = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtproductname = new javax.swing.JTextField();
        descriptiontxt = new javax.swing.JTextField();
        txtprice = new javax.swing.JTextField();
        txtstock = new javax.swing.JTextField();
        ComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tproducts = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Insert = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        datetxt = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));

        jPanel6.setBackground(new java.awt.Color(255, 153, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel22.setText("DATE:");

        asdasdasd.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        asdasdasd.setText("TIME:");

        petsa.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        petsa.setText("0");

        oras.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        oras.setText("0");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(asdasdasd))
                .addGap(5, 5, 5)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(oras, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(petsa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(petsa))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(asdasdasd)
                    .addComponent(oras))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(204, 0, 204));
        jLabel24.setText("PRODUCTS INFORMATION SYSTEM(PIS) for Diossa's Station ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 1674, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1920, 230));

        jPanel2.setBackground(new java.awt.Color(255, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ADMIN");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-home-page-50 (1).png"))); // NOI18N
        jLabel2.setText("HOME PAGE");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-fast-moving-consumer-goods-50.png"))); // NOI18N
        jLabel3.setText("INSERT PRODUCTS");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-magnifying-glass-50.png"))); // NOI18N
        jLabel4.setText("SEARCH PRODUCTS");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-user-48.png"))); // NOI18N
        jLabel5.setText("USER MANAGEMENT");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("LOG OUT");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(255, 153, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel7.setForeground(new java.awt.Color(153, 0, 153));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-administrator-100.png"))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addGap(14, 14, 14))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addContainerGap())
        );

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-supplier-50.png"))); // NOI18N
        jLabel28.setText("SUPPLIERS");
        jLabel28.setAutoscrolls(true);
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-records-50.png"))); // NOI18N
        jLabel36.setText("INFORMATION ");
        jLabel36.setAutoscrolls(true);
        jLabel36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel36MouseClicked(evt);
            }
        });

        jLabel89.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-fast-moving-consumer-goods-50.png"))); // NOI18N
        jLabel89.setText("PRODUCTS");
        jLabel89.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel89MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel89, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(72, 72, 72)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(64, 64, 64)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1)))))
                        .addGap(0, 53, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(31, 31, 31)
                .addComponent(jLabel3)
                .addGap(29, 29, 29)
                .addComponent(jLabel4)
                .addGap(30, 30, 30)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel89)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 270, 910));

        jPanel3.setBackground(new java.awt.Color(255, 204, 255));

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/diossa'sBackground (2).jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 1593, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TabPaneManagement.addTab("tab1", jPanel3);

        jPanel14.setBackground(new java.awt.Color(255, 204, 255));

        TabPaneCategory.setBackground(new java.awt.Color(255, 204, 255));
        TabPaneCategory.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TabPaneCategory.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        ProductCategoryTab.setBackground(new java.awt.Color(255, 204, 255));
        ProductCategoryTab.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        FoodNtxt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        FoodNtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FoodNtxtActionPerformed(evt);
            }
        });

        clear1.setBackground(new java.awt.Color(255, 51, 255));
        clear1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        clear1.setText("CLEAR");
        clear1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clear1MouseClicked(evt);
            }
        });
        clear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear1ActionPerformed(evt);
            }
        });

        FoodTtxt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        FoodTtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FoodTtxtActionPerformed(evt);
            }
        });

        DateFoodAdd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        FoodPtxt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        FoodPtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FoodPtxtActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(153, 0, 153));
        jLabel39.setText("Food Name:");

        TproductsFood.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        TproductsFood.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "FOOD ID", "FOOD NAME", "FOOD TYPE", "PRICE", "DATE ADDED", "EXPIRATION DATE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TproductsFood.setGridColor(new java.awt.Color(255, 204, 255));
        TproductsFood.setSelectionBackground(new java.awt.Color(255, 102, 255));
        TproductsFood.setSelectionForeground(new java.awt.Color(255, 204, 255));
        TproductsFood.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TproductsFoodMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(TproductsFood);

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(153, 0, 153));
        jLabel40.setText("Food type:");

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(153, 0, 153));
        jLabel41.setText("Expiration:");

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("FOOD");

        UpdateFood.setBackground(new java.awt.Color(255, 102, 255));
        UpdateFood.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        UpdateFood.setText("UPDATE");
        UpdateFood.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        UpdateFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateFoodActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(153, 0, 153));
        jLabel44.setText("Price:");

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(153, 0, 153));
        jLabel45.setText("Date added:");

        InsertFood.setBackground(new java.awt.Color(255, 102, 255));
        InsertFood.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        InsertFood.setText("INSERT");
        InsertFood.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        InsertFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertFoodActionPerformed(evt);
            }
        });

        DateFoodEx.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout ProductCategoryTabLayout = new javax.swing.GroupLayout(ProductCategoryTab);
        ProductCategoryTab.setLayout(ProductCategoryTabLayout);
        ProductCategoryTabLayout.setHorizontalGroup(
            ProductCategoryTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductCategoryTabLayout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addGroup(ProductCategoryTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel44)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40))
                .addGap(18, 18, 18)
                .addGroup(ProductCategoryTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(FoodNtxt, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                    .addComponent(FoodTtxt)
                    .addComponent(FoodPtxt))
                .addGap(39, 39, 39)
                .addGroup(ProductCategoryTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel45)
                    .addComponent(jLabel41))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProductCategoryTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DateFoodAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DateFoodEx, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(ProductCategoryTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(InsertFood, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateFood, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clear1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(343, 343, 343))
            .addGroup(ProductCategoryTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(ProductCategoryTabLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 1277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ProductCategoryTabLayout.setVerticalGroup(
            ProductCategoryTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductCategoryTabLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProductCategoryTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProductCategoryTabLayout.createSequentialGroup()
                        .addGroup(ProductCategoryTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(ProductCategoryTabLayout.createSequentialGroup()
                                .addGroup(ProductCategoryTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(DateFoodAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(ProductCategoryTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(FoodNtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(ProductCategoryTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ProductCategoryTabLayout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addGroup(ProductCategoryTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(FoodTtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(ProductCategoryTabLayout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(7, 7, 7))
                            .addGroup(ProductCategoryTabLayout.createSequentialGroup()
                                .addComponent(DateFoodEx, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(ProductCategoryTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FoodPtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ProductCategoryTabLayout.createSequentialGroup()
                        .addComponent(InsertFood, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(UpdateFood, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(clear1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TabPaneCategory.addTab("food", null, ProductCategoryTab, "");

        jPanel16.setBackground(new java.awt.Color(255, 204, 255));

        CharNamee.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CharNamee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CharNameeActionPerformed(evt);
            }
        });

        clear2.setBackground(new java.awt.Color(255, 51, 255));
        clear2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        clear2.setText("CLEAR");
        clear2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clear2MouseClicked(evt);
            }
        });
        clear2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear2ActionPerformed(evt);
            }
        });

        Franchise.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Franchise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FranchiseActionPerformed(evt);
            }
        });

        height.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        height.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                heightActionPerformed(evt);
            }
        });

        pricetxt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pricetxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pricetxtActionPerformed(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(153, 0, 153));
        jLabel46.setText("Character Name:");

        TToy.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "PRODUCT ID", "CHARACTER NAME", "FRANCHISE", "HEIGHT", "ARTICULATION	", "MATERIAL", "RELEASE DATE", "PRICE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TToy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TToyMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TToyMouseEntered(evt);
            }
        });
        jScrollPane7.setViewportView(TToy);

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(153, 0, 153));
        jLabel47.setText("Franchise:");

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(153, 0, 153));
        jLabel48.setText("Articulation_points:");

        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("TOY");

        jLabel50.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(153, 0, 153));
        jLabel50.setText("Price:");

        jButton5.setBackground(new java.awt.Color(255, 102, 255));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton5.setText("UPDATE");
        jButton5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel51.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(153, 0, 153));
        jLabel51.setText("Height cm:");

        jLabel52.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(153, 0, 153));
        jLabel52.setText("Material:");

        INSERTToy.setBackground(new java.awt.Color(255, 102, 255));
        INSERTToy.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        INSERTToy.setText("INSERT");
        INSERTToy.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        INSERTToy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INSERTToyActionPerformed(evt);
            }
        });

        jLabel74.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(153, 0, 153));
        jLabel74.setText("Release Date:");

        material.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        material.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialActionPerformed(evt);
            }
        });

        points.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        points.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pointsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel46)
                                    .addComponent(jLabel47)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addComponent(jLabel51)
                                        .addGap(11, 11, 11)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addComponent(Franchise, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel52))
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(CharNamee, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(height, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel16Layout.createSequentialGroup()
                                                .addGap(59, 59, 59)
                                                .addComponent(jLabel48))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel74))))
                                    .addComponent(jLabel50, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(points, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                                        .addComponent(material))
                                    .addComponent(dateAdded, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pricetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(clear2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(INSERTToy, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 1172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)))
                        .addGap(0, 138, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(CharNamee, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(points, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Franchise, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(material, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateAdded, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(height, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pricetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addComponent(INSERTToy, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(clear2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)))
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(205, 205, 205))
        );

        TabPaneCategory.addTab("toy", jPanel16);

        jPanel17.setBackground(new java.awt.Color(255, 204, 255));

        TXTPRODUCTNAME.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TXTPRODUCTNAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTPRODUCTNAMEActionPerformed(evt);
            }
        });

        clear3.setBackground(new java.awt.Color(255, 51, 255));
        clear3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        clear3.setText("CLEAR");
        clear3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clear3MouseClicked(evt);
            }
        });
        clear3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear3ActionPerformed(evt);
            }
        });

        DESDEC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DESDEC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DESDECActionPerformed(evt);
            }
        });

        DECTYPE.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DECTYPE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DECTYPEActionPerformed(evt);
            }
        });

        MATERIALDEC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MATERIALDEC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MATERIALDECActionPerformed(evt);
            }
        });

        jLabel53.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(153, 0, 153));
        jLabel53.setText("Product Name:");

        TDecoration.setModel(new javax.swing.table.DefaultTableModel(
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
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TDecoration.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TDecorationMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(TDecoration);

        jLabel54.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(153, 0, 153));
        jLabel54.setText("Description:");

        jLabel55.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(153, 0, 153));
        jLabel55.setText("Price:");

        jLabel56.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setText("DECORATION");

        jLabel57.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(153, 0, 153));
        jLabel57.setText("Material:");

        DecorUpdate.setBackground(new java.awt.Color(255, 102, 255));
        DecorUpdate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        DecorUpdate.setText("UPDATE");
        DecorUpdate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DecorUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecorUpdateActionPerformed(evt);
            }
        });

        jLabel58.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(153, 0, 153));
        jLabel58.setText("Type:");

        DecorINSERT.setBackground(new java.awt.Color(255, 102, 255));
        DecorINSERT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        DecorINSERT.setText("INSERT");
        DecorINSERT.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DecorINSERT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecorINSERTActionPerformed(evt);
            }
        });

        DECPRICE.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DECPRICE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DECPRICEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 1295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 1177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jLabel53)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TXTPRODUCTNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jLabel54)
                                .addGap(18, 18, 18)
                                .addComponent(DESDEC, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jLabel58)
                                .addGap(18, 18, 18)
                                .addComponent(DECTYPE, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel57)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel55)
                                .addGap(28, 28, 28)))
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MATERIALDEC, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DECPRICE, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(80, 80, 80)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DecorUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DecorINSERT, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clear3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TXTPRODUCTNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(MATERIALDEC, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(DecorINSERT, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DESDEC, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(DECPRICE, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DECTYPE, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(DecorUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(clear3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(304, 304, 304))
        );

        TabPaneCategory.addTab("decoration", jPanel17);

        ProductsCategory.setBackground(new java.awt.Color(255, 204, 255));

        PNacc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PNacc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PNaccActionPerformed(evt);
            }
        });

        clear4.setBackground(new java.awt.Color(255, 51, 255));
        clear4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        clear4.setText("CLEAR");
        clear4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clear4MouseClicked(evt);
            }
        });
        clear4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear4ActionPerformed(evt);
            }
        });

        TypeAcc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TypeAcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TypeAccActionPerformed(evt);
            }
        });

        DStyleacc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DStyleacc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DStyleaccActionPerformed(evt);
            }
        });

        AccPrice.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AccPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccPriceActionPerformed(evt);
            }
        });

        jLabel60.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(153, 0, 153));
        jLabel60.setText("Product Name:");

        TAccessories.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "product_id", "product_name", "Type", "Design Style", "Material", "Color", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TAccessories.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TAccessoriesMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(TAccessories);

        jLabel61.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(153, 0, 153));
        jLabel61.setText("Type:");

        jLabel62.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(153, 0, 153));
        jLabel62.setText("Color:");

        jLabel63.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel63.setText("ACCESSORIES");

        jLabel64.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(153, 0, 153));
        jLabel64.setText("Material:");

        UPDATEACCESSORIES.setBackground(new java.awt.Color(255, 102, 255));
        UPDATEACCESSORIES.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        UPDATEACCESSORIES.setText("UPDATE");
        UPDATEACCESSORIES.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        UPDATEACCESSORIES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATEACCESSORIESActionPerformed(evt);
            }
        });

        jLabel65.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(153, 0, 153));
        jLabel65.setText("Design Style:");

        jLabel66.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(153, 0, 153));
        jLabel66.setText("Price:");

        INSERTACC.setBackground(new java.awt.Color(255, 102, 255));
        INSERTACC.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        INSERTACC.setText("INSERT");
        INSERTACC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        INSERTACC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INSERTACCActionPerformed(evt);
            }
        });

        c.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cActionPerformed(evt);
            }
        });

        colorAcc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        colorAcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorAccActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ProductsCategoryLayout = new javax.swing.GroupLayout(ProductsCategory);
        ProductsCategory.setLayout(ProductsCategoryLayout);
        ProductsCategoryLayout.setHorizontalGroup(
            ProductsCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductsCategoryLayout.createSequentialGroup()
                .addGroup(ProductsCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProductsCategoryLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(ProductsCategoryLayout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addGroup(ProductsCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ProductsCategoryLayout.createSequentialGroup()
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 1165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(ProductsCategoryLayout.createSequentialGroup()
                                .addGroup(ProductsCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel65)
                                    .addComponent(jLabel60)
                                    .addComponent(jLabel61))
                                .addGap(18, 18, 18)
                                .addGroup(ProductsCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(DStyleacc)
                                    .addComponent(PNacc, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                    .addComponent(TypeAcc))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                                .addGroup(ProductsCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel62, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel64, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel66, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(ProductsCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(colorAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(c, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AccPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                                .addGroup(ProductsCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(clear4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(ProductsCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(INSERTACC, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(UPDATEACCESSORIES, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 211, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        ProductsCategoryLayout.setVerticalGroup(
            ProductsCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductsCategoryLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ProductsCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProductsCategoryLayout.createSequentialGroup()
                        .addGroup(ProductsCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(ProductsCategoryLayout.createSequentialGroup()
                                .addGroup(ProductsCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PNacc, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8))
                            .addGroup(ProductsCategoryLayout.createSequentialGroup()
                                .addComponent(c, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(ProductsCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TypeAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(colorAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ProductsCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ProductsCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(DStyleacc, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(AccPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProductsCategoryLayout.createSequentialGroup()
                        .addComponent(INSERTACC, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(UPDATEACCESSORIES, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(clear4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)))
                .addGap(89, 89, 89)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(246, 246, 246))
        );

        TabPaneCategory.addTab("accessories", ProductsCategory);

        jPanel19.setBackground(new java.awt.Color(255, 204, 255));

        ClothingName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ClothingName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClothingNameActionPerformed(evt);
            }
        });

        clear5.setBackground(new java.awt.Color(255, 51, 255));
        clear5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        clear5.setText("CLEAR");
        clear5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clear5MouseClicked(evt);
            }
        });
        clear5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear5ActionPerformed(evt);
            }
        });

        ClothingType.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ClothingType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClothingTypeActionPerformed(evt);
            }
        });

        ClothingSize.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ClothingSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClothingSizeActionPerformed(evt);
            }
        });

        txtstock5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtstock5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstock5ActionPerformed(evt);
            }
        });

        ClothingGender.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ClothingGender.setForeground(new java.awt.Color(204, 0, 204));
        ClothingGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CHOOSE", "MALE", "FEMALE", "UNISEX" }));
        ClothingGender.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ClothingGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClothingGenderActionPerformed(evt);
            }
        });

        jLabel67.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(153, 0, 153));
        jLabel67.setText("Product Name:");

        Tproducts6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "product_id", "product_name", "Type", "Size", "Gender	", "Price", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Tproducts6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tproducts6MouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(Tproducts6);

        jLabel68.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(153, 0, 153));
        jLabel68.setText("Type:");

        jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(153, 0, 153));
        jLabel69.setText("Price:");

        jLabel70.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel70.setText("CLOTHING");

        jLabel71.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(153, 0, 153));
        jLabel71.setText("Gender:");

        jButton11.setBackground(new java.awt.Color(255, 102, 255));
        jButton11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton11.setText("UPDATE");
        jButton11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel72.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(153, 0, 153));
        jLabel72.setText("Size:");

        jLabel73.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(153, 0, 153));
        jLabel73.setText("Description:");

        Insert5.setBackground(new java.awt.Color(255, 102, 255));
        Insert5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Insert5.setText("INSERT");
        Insert5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Insert5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Insert5ActionPerformed(evt);
            }
        });

        txtstock6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtstock6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstock6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel72)
                            .addComponent(jLabel67)
                            .addComponent(jLabel68))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ClothingSize)
                            .addComponent(ClothingName, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(ClothingType))
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel71)
                                    .addComponent(jLabel69)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel73)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtstock6, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ClothingGender, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtstock5, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Insert5, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(clear5, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 1277, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 1205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ClothingName, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ClothingGender, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Insert5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClothingType, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtstock6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ClothingSize, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtstock5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(clear5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127))
        );

        TabPaneCategory.addTab("clothing", jPanel19);

        jPanel15.setBackground(new java.awt.Color(255, 153, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-fast-moving-consumer-goods-50.png"))); // NOI18N
        jLabel33.setText("FOOD");
        jLabel33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel33MouseClicked(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-fast-moving-consumer-goods-50.png"))); // NOI18N
        jLabel34.setText("TOY");
        jLabel34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel34MouseClicked(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-fast-moving-consumer-goods-50.png"))); // NOI18N
        jLabel35.setText("DECORATION");
        jLabel35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel35MouseClicked(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-fast-moving-consumer-goods-50.png"))); // NOI18N
        jLabel37.setText("ACCESSORIES");
        jLabel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel37MouseClicked(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-fast-moving-consumer-goods-50.png"))); // NOI18N
        jLabel38.setText("CLOTHING");
        jLabel38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel38MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(jLabel33)
                .addGap(30, 30, 30)
                .addComponent(jLabel34)
                .addGap(30, 30, 30)
                .addComponent(jLabel35)
                .addGap(30, 30, 30)
                .addComponent(jLabel37)
                .addGap(30, 30, 30)
                .addComponent(jLabel38)
                .addContainerGap(294, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TabPaneCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 1437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TabPaneCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 846, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TabPaneManagement.addTab("tab7", jPanel14);

        jPanel18.setBackground(new java.awt.Color(255, 204, 255));

        jPanel20.setBackground(new java.awt.Color(255, 153, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        jPanel20.setForeground(new java.awt.Color(255, 255, 255));

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-magnifying-glass-50.png"))); // NOI18N
        jLabel43.setText("SEARCH FOOD ");
        jLabel43.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel43MouseClicked(evt);
            }
        });

        jLabel59.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-magnifying-glass-50.png"))); // NOI18N
        jLabel59.setText("SEARCH TOY");
        jLabel59.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel59MouseClicked(evt);
            }
        });

        jLabel75.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel75.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-magnifying-glass-50.png"))); // NOI18N
        jLabel75.setText("SEARCH DECORATION");
        jLabel75.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel75MouseClicked(evt);
            }
        });

        jLabel76.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel76.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel76.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-magnifying-glass-50.png"))); // NOI18N
        jLabel76.setText("SEARCH ACCESSORIES");
        jLabel76.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel76MouseClicked(evt);
            }
        });

        jLabel77.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-magnifying-glass-50.png"))); // NOI18N
        jLabel77.setText("SEARCH CLOTHING");
        jLabel77.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel77MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel76, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
            .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel75)
                    .addComponent(jLabel43))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jLabel43)
                .addGap(30, 30, 30)
                .addComponent(jLabel59)
                .addGap(30, 30, 30)
                .addComponent(jLabel75)
                .addGap(30, 30, 30)
                .addComponent(jLabel76)
                .addGap(30, 30, 30)
                .addComponent(jLabel77)
                .addContainerGap(248, Short.MAX_VALUE))
        );

        jTabbedPane1.setBackground(new java.awt.Color(255, 204, 255));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane1.setForeground(new java.awt.Color(204, 0, 204));

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
                        .addGap(56, 56, 56)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 1277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtFood, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel79, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(454, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("food", jPanel21);

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
                .addContainerGap(444, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("toy", jPanel22);

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

        jTabbedPane1.addTab("decoration", jPanel23);

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
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 1277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(18, 18, 18)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("accessories", jPanel24);

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

        jTabbedPane1.addTab("clothing", jPanel25);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1384, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1255, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("food");

        TabPaneManagement.addTab("tab8", jPanel18);

        jPanel10.setBackground(new java.awt.Color(255, 204, 255));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel14.setText("USER MANAGEMENT");

        usertxt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        USERinsertBtn.setBackground(new java.awt.Color(255, 102, 255));
        USERinsertBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        USERinsertBtn.setText("INSERT");
        USERinsertBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        USERinsertBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                USERinsertBtnActionPerformed(evt);
            }
        });

        passtxt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel15.setText("USERNAME:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel16.setText("PASSWORD:");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel17.setText("ROLE:");

        USERdeleteBtn.setBackground(new java.awt.Color(255, 102, 255));
        USERdeleteBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        USERdeleteBtn.setText("DELETE");
        USERdeleteBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        USERdeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                USERdeleteBtnActionPerformed(evt);
            }
        });

        USERupdateBtn.setBackground(new java.awt.Color(255, 102, 255));
        USERupdateBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        USERupdateBtn.setText("UPDATE");
        USERupdateBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        USERupdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                USERupdateBtnActionPerformed(evt);
            }
        });

        USERclearBtn.setBackground(new java.awt.Color(255, 102, 255));
        USERclearBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        USERclearBtn.setText("CLEAR");
        USERclearBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        USERclearBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                USERclearBtnMouseClicked(evt);
            }
        });
        USERclearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                USERclearBtnActionPerformed(evt);
            }
        });

        Tuser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID USERNAME", "FULLNAME", "USERNAME", "PASSWORD", "ROLE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Tuser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TuserMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Tuser);

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel19.setText("FULLNAME:");

        nametxt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nametxtActionPerformed(evt);
            }
        });

        roletxt.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        roletxt.setForeground(new java.awt.Color(204, 0, 204));
        roletxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CHOOSE", "admin", "employee" }));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(617, 617, 617)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usertxt)
                            .addComponent(nametxt, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roletxt, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(107, 107, 107)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(USERdeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(USERinsertBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(USERupdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(USERclearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 452, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(600, 600, 600)
                        .addComponent(jLabel14)))
                .addContainerGap(183, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jLabel14)
                .addGap(40, 40, 40)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(USERinsertBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(USERdeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(USERupdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(USERclearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel17)
                                .addComponent(roletxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usertxt, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );

        TabPaneManagement.addTab("tab4", jPanel10);

        jPanel5.setBackground(new java.awt.Color(255, 204, 255));

        txtSname.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtSname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSnameActionPerformed(evt);
            }
        });

        clearS.setBackground(new java.awt.Color(255, 51, 255));
        clearS.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        clearS.setText("CLEAR");
        clearS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearSMouseClicked(evt);
            }
        });
        clearS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearSActionPerformed(evt);
            }
        });

        txtsocial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtsocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsocialActionPerformed(evt);
            }
        });

        txtNumber.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumberActionPerformed(evt);
            }
        });

        txtEmail.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(153, 0, 153));
        jLabel26.setText("Supplier Name:");

        Tsup.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Supplier_id", "Supplier_Name", "Social Media", "Phone Number", "Email Address", "Address", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Tsup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TsupMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(Tsup);

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(153, 0, 153));
        jLabel27.setText("Social Media:");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("SUPPLIER");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(153, 0, 153));
        jLabel30.setText("Email Address:");

        UpdateSupplier.setBackground(new java.awt.Color(255, 102, 255));
        UpdateSupplier.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        UpdateSupplier.setText("UPDATE");
        UpdateSupplier.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        UpdateSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateSupplierActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(153, 0, 153));
        jLabel31.setText("Phone number:");

        DeleteSupplier.setBackground(new java.awt.Color(255, 102, 255));
        DeleteSupplier.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        DeleteSupplier.setText("DELETE");
        DeleteSupplier.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DeleteSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteSupplierActionPerformed(evt);
            }
        });

        InsertSupplier.setBackground(new java.awt.Color(255, 102, 255));
        InsertSupplier.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        InsertSupplier.setText("INSERT");
        InsertSupplier.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        InsertSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertSupplierActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(153, 0, 153));
        jLabel32.setText("Address:");

        txtddress.setColumns(20);
        txtddress.setRows(5);
        txtddress.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane5.setViewportView(txtddress);

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(153, 0, 153));
        jLabel25.setText("DESCRIPTION:");

        txtdes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtdes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(214, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel31)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSname, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                    .addComponent(txtsocial)
                    .addComponent(txtNumber))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel30)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel32))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtdes)
                    .addComponent(txtEmail)
                    .addComponent(jScrollPane5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(clearS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(InsertSupplier, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteSupplier, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateSupplier, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(343, 343, 343))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSname, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtsocial, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(7, 7, 7))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(InsertSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(DeleteSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(UpdateSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(txtdes, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(clearS, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(72, 72, 72)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        TabPaneManagement.addTab("tab5", jPanel5);

        jPanel11.setBackground(new java.awt.Color(255, 204, 255));

        jPanel13.setBackground(new java.awt.Color(255, 153, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createMatteBorder(30, 5, 5, 5, new java.awt.Color(255, 102, 255)));

        suppliercount.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        suppliercount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        suppliercount.setText("SUPPLIER:   0");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(suppliercount, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(suppliercount, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
        );

        usercount1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        usercount1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usercount1.setText("SUPPLIER & USER ");

        jPanel12.setBackground(new java.awt.Color(255, 153, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createMatteBorder(30, 5, 5, 5, new java.awt.Color(255, 102, 255)));

        usercount.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        usercount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usercount.setText("USER: 0");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(usercount, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(usercount, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(648, 648, 648)
                .addComponent(usercount1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 473, Short.MAX_VALUE)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(164, 164, 164))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(usercount1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 239, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(235, 235, 235))
        );

        TabPaneManagement.addTab("tab9", jPanel11);

        jPanel8.setBackground(new java.awt.Color(255, 204, 255));

        jPanel26.setBackground(new java.awt.Color(255, 204, 255));

        jPanel27.setBackground(new java.awt.Color(255, 153, 255));
        jPanel27.setBorder(javax.swing.BorderFactory.createMatteBorder(30, 10, 10, 10, new java.awt.Color(255, 102, 255)));

        jLabel88.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel88.setText("PRODUCTS");

        foodcount.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        foodcount.setText("FOOD");
        foodcount.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 102, 255)));

        toycount.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        toycount.setText("TOY");
        toycount.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 102, 255)));

        decocount.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        decocount.setText("DECORATION");
        decocount.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 102, 255)));

        accecount.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        accecount.setText("ACCESSORIES");
        accecount.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 102, 255)));

        clocount.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        clocount.setText("CLOTHING");
        clocount.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 102, 255)));

        totals.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        totals.setText("TOTAL");
        totals.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(foodcount, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(toycount, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(decocount, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(accecount, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(clocount, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
                            .addComponent(totals, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(foodcount, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(toycount, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(decocount, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(accecount, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(clocount, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(totals, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        clocount1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        clocount1.setText("CLOTHING");
        clocount1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 102, 255)));

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addContainerGap(440, Short.MAX_VALUE)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(385, 385, 385))
            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel26Layout.createSequentialGroup()
                    .addGap(517, 517, 517)
                    .addComponent(clocount1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(517, Short.MAX_VALUE)))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(225, Short.MAX_VALUE))
            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel26Layout.createSequentialGroup()
                    .addGap(442, 442, 442)
                    .addComponent(clocount1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(442, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TabPaneManagement.addTab("tab6", jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 204, 255));

        Tproducts1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "product_id", "product_name", "description", "price", "stock_quantity	", "date added", "category"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Tproducts1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tproducts1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Tproducts1);

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("SEARCH PRODUCTS");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel20.setText("SEARCH:");

        searchtxt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        searchtxt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        searchtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchtxtActionPerformed(evt);
            }
        });
        searchtxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchtxtKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 869, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(529, 529, 529)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(197, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TabPaneManagement.addTab("tab3", jPanel9);

        jPanel4.setBackground(new java.awt.Color(255, 204, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 0, 153));
        jLabel7.setText("Product Name:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 0, 153));
        jLabel8.setText("Description:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 0, 153));
        jLabel9.setText("category:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 0, 153));
        jLabel10.setText("Stock:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 0, 153));
        jLabel11.setText("Price:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 0, 153));
        jLabel12.setText("Date added:");

        txtproductname.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtproductname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtproductnameActionPerformed(evt);
            }
        });

        descriptiontxt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        descriptiontxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descriptiontxtActionPerformed(evt);
            }
        });

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
        ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CHOOSE", "FOOD", "TOY", "ACCESSORIES", "DESIGN", "CLOTHING", " " }));
        ComboBox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Tproducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "product_id", "product_name", "description", "price", "stock_quantity	", "Date_added", "Category"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
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

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("PRODUCTS");

        jButton1.setBackground(new java.awt.Color(255, 102, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("UPDATE");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 102, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setText("DELETE");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        Insert.setBackground(new java.awt.Color(255, 102, 255));
        Insert.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Insert.setText("INSERT");
        Insert.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertActionPerformed(evt);
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
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(214, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtproductname, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(descriptiontxt))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtstock, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(datetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(Insert, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(343, 343, 343))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtstock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtproductname, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(descriptiontxt, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(datetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(7, 7, 7))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(Insert, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        TabPaneManagement.addTab("tab2", jPanel4);

        getContentPane().add(TabPaneManagement, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 1650, 900));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        
        TabPaneManagement.setSelectedIndex(0);
        
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:

        TabPaneManagement.setSelectedIndex(1);

        
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here

        TabPaneManagement.setSelectedIndex(2);

        
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:

        TabPaneManagement.setSelectedIndex(3);

        
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        
        Login Log = new Login();
        Log.show();
        dispose();
        
    }//GEN-LAST:event_jLabel6MouseClicked

    private void txtproductnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtproductnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtproductnameActionPerformed

    private void descriptiontxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descriptiontxtActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_descriptiontxtActionPerformed

    private void txtpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpriceActionPerformed

    private void txtstockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstockActionPerformed

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
            java.sql.Date sqlDate = new java.sql.Date(dateAdded.getDate());


            String query = "UPDATE products_info SET product_name=?, description=?, price=?, stock_quantity=?, date_added=?, category_name=? WHERE product_id=?";

            con = CONN.getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            
            pst.setString(1, productN);
            pst.setString(2, description);
            pst.setString(3, price);
            pst.setString(4, stock);
            pst.setDate(5, sqlDate);
            pst.setString(6, category);
            pst.setInt(7, productId);
            

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

    private void TproductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TproductsMouseClicked
        // TODO add your handling code here:
        
        int selectedRow = Tproducts.getSelectedRow();

        if (selectedRow >= 0) {
         int Id = Integer.parseInt(Tproducts.getValueAt(selectedRow, 0).toString());
        fetchProductData(Id);
}

        
    }//GEN-LAST:event_TproductsMouseClicked

    private void clearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearMouseClicked
        // TODO add your handling code here:
        
               txtproductname.setText("");
                descriptiontxt.setText("");
                txtprice.setText("");
                txtstock.setText("");
                datetxt.setDate(null);
                ComboBox.setSelectedIndex(0); 
                
    }//GEN-LAST:event_clearMouseClicked

    private void USERinsertBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_USERinsertBtnActionPerformed
        // TODO add your handling code here:
        
        try {
            String name = nametxt.getText().trim();
            String username = usertxt.getText().trim();
            String password = passtxt.getText().trim();
            String role = roletxt.getSelectedItem().toString().trim();
            
            // Check if any field is empty
            if (name.isEmpty() || username.isEmpty() || password.isEmpty() || role.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "No input! Please fill in all fields.");
                return;
            }

            // Convert copies anintd available to integers


            
            // Database connection
            con = CONN.getConnection();

            // Insert new book record
            String insertQuery = "INSERT INTO accdetails (NAME, username, password, role) VALUES (?, ?, ?, ?)";
            pst = con.prepareStatement(insertQuery);
            pst.setString(1, name);
            pst.setString(2, username);
            pst.setString(3, password);
            pst.setString(4, role);


            int k = pst.executeUpdate();

            if (k == 1) {
                JOptionPane.showMessageDialog(rootPane, "user added successfully!");
                // Clear fields after successful insert
                nametxt.setText("");
                usertxt.setText("");
                passtxt.setText("");
                roletxt.setSelectedIndex(0);

                
            } else {
                JOptionPane.showMessageDialog(rootPane, "Failed to add user");
            }
                    loadUser();

            } catch (Exception ex) {
                Logger.getLogger(AdminPage.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, "Error occurred while adding the product.");
                JOptionPane.showMessageDialog(rootPane, "Invalid number format for copies!");
         } 

    }//GEN-LAST:event_USERinsertBtnActionPerformed

    private void USERdeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_USERdeleteBtnActionPerformed
        // TODO add your handling code here:
        
            
        int selectedRow = Tuser.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a user to delete.");
            return;
        }

        int USER = Integer.parseInt(Tuser.getValueAt(selectedRow, 0).toString());

        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this user?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            String query = "DELETE FROM accdetails WHERE id_user=?";

            try {
                con = CONN.getConnection();
                PreparedStatement pst = con.prepareStatement(query);
                pst.setInt(1, USER);

                int rowsDeleted = pst.executeUpdate();
                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(null, "User deleted successfully."); // Refresh Table
            
                    loadUser();

                }

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error deleting user.");
            }
        }
        
    }//GEN-LAST:event_USERdeleteBtnActionPerformed

    private void USERupdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_USERupdateBtnActionPerformed
        // TODO add your handling code here:
        
        
          
        int selectedRow = Tuser.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Please select a user to update.");
        return;
}

    int userId = Integer.parseInt(Tuser.getValueAt(selectedRow, 0).toString());

// Get text values
            
            String name = nametxt.getText().trim();
            String user = usertxt.getText().trim();
            String pass = passtxt.getText().trim();
            String role = roletxt.getSelectedItem().toString().trim();

// Check if any field is empty
        if (name.isEmpty() || user.isEmpty() || pass.isEmpty() || role.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields must be filled out!");
        return;
}

        try {
            


            String query = "UPDATE accdetails SET NAME=?, username=?, password=?, role=? WHERE id_user=?";

            con = CONN.getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            
            pst.setString(1, name);
            pst.setString(2, user);
            pst.setString(3, pass);
            pst.setString(4, role);
            pst.setInt(5, userId);            

    int rowsUpdated = pst.executeUpdate();
    if (rowsUpdated > 0) {
        JOptionPane.showMessageDialog(null, "user updated successfully.");
              
                nametxt.setText("");
                usertxt.setText("");
                passtxt.setText("");
                roletxt.setSelectedIndex(0);
              
                loadUser(); // Refresh table
    } else {
        JOptionPane.showMessageDialog(null, "No user was updated. Please check the ID.");
    }

} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(null, "Invalid number format for copies! Please enter valid numbers.");
} catch (SQLException e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(null, "Error updating user.");
}
    }//GEN-LAST:event_USERupdateBtnActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_clearActionPerformed

    private void USERclearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_USERclearBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_USERclearBtnActionPerformed

    private void USERclearBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_USERclearBtnMouseClicked
        // TODO add your handling code here:
                
        
                nametxt.setText("");
                usertxt.setText("");
                passtxt.setText("");
                roletxt.setSelectedItem(0);
  
        
    }//GEN-LAST:event_USERclearBtnMouseClicked

    private void Tproducts1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tproducts1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Tproducts1MouseClicked

    private void nametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nametxtActionPerformed

    private void TuserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TuserMouseClicked
        // TODO add your handling code here:
            
        int selectedRow = Tuser.getSelectedRow();

        if (selectedRow >= 0) {
         int Id = Integer.parseInt(Tuser.getValueAt(selectedRow, 0).toString());
        fetchUserData(Id);
        
        }
    }//GEN-LAST:event_TuserMouseClicked

    private void searchtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchtxtActionPerformed

    private void searchtxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchtxtKeyReleased
        // TODO add your handling code here:
        
        DefaultTableModel ob =  (DefaultTableModel) Tproducts1.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<> (ob);
        Tproducts1.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(searchtxt.getText()));
        
        
    }//GEN-LAST:event_searchtxtKeyReleased

    private void txtSnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSnameActionPerformed

    private void clearSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearSMouseClicked
        // TODO add your handling code here:
        
             txtSname.setText("");
                txtsocial.setText("");
                txtNumber.setText("");
                txtEmail.setText("");
                txtddress.setText("");
                txtdes.setText("");
                
                
    }//GEN-LAST:event_clearSMouseClicked

    private void clearSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearSActionPerformed







        // TODO add your handling code here:
    }//GEN-LAST:event_clearSActionPerformed

    private void txtsocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsocialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsocialActionPerformed

    private void txtNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumberActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void TsupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TsupMouseClicked
        // TODO add your handling code here:
        
               int selectedRow = Tsup.getSelectedRow();

        if (selectedRow >= 0) {
         int Id = Integer.parseInt(Tsup.getValueAt(selectedRow, 0).toString());
        fetchSupplyData(Id);
}
        
    }//GEN-LAST:event_TsupMouseClicked

    private void UpdateSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateSupplierActionPerformed
        // TODO add your handling code here:

       
        try {
            String SuppName = txtSname.getText().trim();
            String socialM = txtsocial.getText().trim();
            String phoneNum = txtNumber.getText().trim();
            String EmAdd = txtEmail.getText().trim();
            String address = txtddress.toString().trim();
            String description = txtdes.toString().trim();
            
            
           // String dt = sdf.format(datetxt.getDate());
            
            
            
            // Check if any field is empty
            if (SuppName.isEmpty() || socialM.isEmpty() || phoneNum.isEmpty() || EmAdd.isEmpty() || address.isEmpty() || description.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "No input! Please fill in all fields.");
                return;
            }

            // Convert copies anintd available to integers
            int totalCopies = Integer.parseInt(phoneNum);


            
            // Database connection
            con = CONN.getConnection();

            // Insert new book record
            String insertQuery = "INSERT INTO suppliers (Supplier_Name, Contact_Person, Phone_Number, Email_Address, Address, supplydes) VALUES (?, ?, ?, ?, ?, ?)";
            pst = con.prepareStatement(insertQuery);
            pst.setString(1, SuppName);
            pst.setString(2, socialM);
            pst.setString(3, phoneNum);
            pst.setString(4, EmAdd);
            pst.setString(5, address);
            pst.setString(6, description);
            
            int k = pst.executeUpdate();

            if (k == 1) {
                JOptionPane.showMessageDialog(rootPane, "supplier added successfully!");
                // Clear fields after successful insert
                txtSname.setText("");
                txtsocial.setText("");
                txtNumber.setText("");
                txtEmail.setText("");
                txtddress.setText("");
                txtdes.setText("");

                
            } else {
                JOptionPane.showMessageDialog(rootPane, "Failed to add supplier");
            }
                    loadProduct();

            } catch (Exception ex) {
                Logger.getLogger(AdminPage.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, "Error occurred while adding the product.");
                JOptionPane.showMessageDialog(rootPane, "Invalid number format for copies!");
         } 






        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateSupplierActionPerformed

    private void DeleteSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteSupplierActionPerformed
        // TODO add your handling code here:
        
                
        int selectedRow = Tsup.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a supplier to delete.");
            return;
        }

        int userId = Integer.parseInt(Tsup.getValueAt(selectedRow, 0).toString());

        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this supplier?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            String query = "DELETE FROM suppliers WHERE Supplier_ID =?";

            try {
                con = CONN.getConnection();
                PreparedStatement pst = con.prepareStatement(query);
                pst.setInt(1, userId);

                int rowsDeleted = pst.executeUpdate();
                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(null, "supplier deleted successfully."); // Refresh Table
            
                    loadProduct();
                    
                }

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error deleting supplier.");
            }
        }
        
    }//GEN-LAST:event_DeleteSupplierActionPerformed

    private void InsertSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertSupplierActionPerformed
        // TODO add your handling code here:
        
       
        try {
            String supname = txtSname.getText().trim();
            String social = txtsocial.getText().trim();
            String num = txtNumber.getText().trim();
            String email = txtEmail.getText().trim();
            String addres = txtddress.getText().trim();
            String des = txtdes.getText().trim();            
                
            
            // Check if any field is empty
            if (supname.isEmpty() || social.isEmpty() || num.isEmpty() || email.isEmpty() || addres.isEmpty() || des.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "No input! Please fill in all fields.");
                return;
            }

            // Convert copies anintd available to integers

            
            // Database connection
            con = CONN.getConnection();

            // Insert new book record
                String insertQuery = "INSERT INTO suppliers (Supplier_Name, Contact_Person, Phone_Number, Email_Address, Address, supplydes) VALUES (?, ?, ?, ?, ?, ?)";
            pst = con.prepareStatement(insertQuery);
            pst.setString(1, supname);
            pst.setString(2, social);
            pst.setString(3, num);
            pst.setString(4, email);
            pst.setString(5, addres);
            pst.setString(6, des);
            
            int k = pst.executeUpdate();

            if (k == 1) {
                JOptionPane.showMessageDialog(rootPane, "supplier added successfully!");
                // Clear fields after successful insert
                txtSname.setText("");
                txtsocial.setText("");
                txtNumber.setText("");
                txtEmail.setText("");
                txtddress.setText("");
                txtdes.setText("");


                
            } else {
                JOptionPane.showMessageDialog(rootPane, "Failed to add supplier");
            }
                    loadSupplier();

            } catch (Exception ex) {
                Logger.getLogger(AdminPage.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, "Error occurred while adding the product.");
                JOptionPane.showMessageDialog(rootPane, "Invalid number format for copies!");
         } 
           
        
        
        
        
        
    }//GEN-LAST:event_InsertSupplierActionPerformed

    private void txtdesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdesActionPerformed

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        // TODO add your handling code here:
        
                TabPaneManagement.setSelectedIndex(4);

        
    }//GEN-LAST:event_jLabel28MouseClicked

    private void jLabel36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel36MouseClicked
        // TODO add your handling code here:
        
                        TabPaneManagement.setSelectedIndex(5);

        
    }//GEN-LAST:event_jLabel36MouseClicked

    private void jLabel33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel33MouseClicked
        // TODO add your handling code here:

        TabPaneCategory.setSelectedIndex(0);
        
    }//GEN-LAST:event_jLabel33MouseClicked

    private void jLabel34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel34MouseClicked
        // TODO add your handling code here:

        TabPaneCategory.setSelectedIndex(1);

    }//GEN-LAST:event_jLabel34MouseClicked

    private void jLabel35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseClicked
        // TODO add your handling code here:

        TabPaneCategory.setSelectedIndex(2);
        
    }//GEN-LAST:event_jLabel35MouseClicked

    private void jLabel37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseClicked
        // TODO add your handling code here:

        TabPaneCategory.setSelectedIndex(3);
        
    }//GEN-LAST:event_jLabel37MouseClicked

    private void jLabel38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel38MouseClicked
        // TODO add your handling code here:

        TabPaneCategory.setSelectedIndex(4);
        
    }//GEN-LAST:event_jLabel38MouseClicked

    private void FoodNtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FoodNtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FoodNtxtActionPerformed

    private void clear1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clear1MouseClicked
        // TODO add your handling code here:
        
        
               FoodNtxt.setText("");
                FoodTtxt.setText("");
                FoodPtxt.setText("");
                DateFoodAdd.setDate(null);
                DateFoodEx.setDate(null);
        
    }//GEN-LAST:event_clear1MouseClicked

    private void clear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clear1ActionPerformed

    private void FoodTtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FoodTtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FoodTtxtActionPerformed

    private void FoodPtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FoodPtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FoodPtxtActionPerformed

    private void TproductsFoodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TproductsFoodMouseClicked
        // TODO add your handling code here:
        
                
        int selectedRow = TproductsFood.getSelectedRow();

        if (selectedRow >= 0) {
         int Id = Integer.parseInt(TproductsFood.getValueAt(selectedRow, 0).toString());
        fetchFoodData(Id);
}
        
    }//GEN-LAST:event_TproductsFoodMouseClicked

    private void UpdateFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateFoodActionPerformed
        // TODO add your handling code here:
        
               SimpleDateFormat sdf = new SimpleDateFormat ("yyyy/MM/dd");

       
        int selectedRow = TproductsFood.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Please select a product to update.");
        return;
}

    int productId = Integer.parseInt(TproductsFood.getValueAt(selectedRow, 0).toString());

// Get text values
            
            String foodName = FoodNtxt.getText().trim();
            String foodtype = FoodTtxt.getText().trim();
            String price = FoodPtxt.getText().trim();
            Date dateAdded = DateFoodAdd.getDate();
            Date DateEx = DateFoodEx.getDate();


// Check if any field is empty
        if (foodName.isEmpty() || foodtype.isEmpty() || price.isEmpty() || dateAdded == null || DateEx == null) {
            JOptionPane.showMessageDialog(null, "All fields must be filled out!");
        return;
}

        try {
            java.sql.Date sqlDate = new java.sql.Date(dateAdded.getDate());
            java.sql.Date sqlexdate = new java.sql.Date(dateAdded.getDate());



            String query = "UPDATE food SET name=?, food_type=?, price=?, date_added=?, expiration_date=? WHERE id=?";

            con = CONN.getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            
            pst.setString(1, foodName);
            pst.setString(2, foodtype);
            pst.setString(3, price);
            pst.setDate(4, sqlDate);
            pst.setDate(5, sqlexdate);
            pst.setInt(6, productId);

            
            

    int rowsUpdated = pst.executeUpdate();
    if (rowsUpdated > 0) {
        JOptionPane.showMessageDialog(null, "product updated successfully.");
              
                FoodNtxt.setText("");
                FoodTtxt.setText("");
                FoodPtxt.setText("");
                DateFoodAdd.setDate(null);
                DateFoodEx.setDate(null);
              
                loadFood(); // Refresh table
    } else {
        JOptionPane.showMessageDialog(null, "No product was updated. Please check the ID.");
    }

} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(null, "Invalid number format for copies! Please enter valid numbers.");
} catch (SQLException e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(null, "Error updating product.");
}
        
    }//GEN-LAST:event_UpdateFoodActionPerformed

    private void InsertFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertFoodActionPerformed
        // TODO add your handling code here:
        
                    SimpleDateFormat sdf = new SimpleDateFormat ("yyyy/MM/dd");
        
        try {
            String FoodName = FoodNtxt.getText().trim();
            String FoodType = FoodTtxt.getText().trim();
            String FoodPrice = FoodPtxt.getText().trim();
            Date dateAdded = DateFoodAdd.getDate();
            Date dateEx = DateFoodEx.getDate();
            
                        
            // Check if any field is empty
            if (FoodName.isEmpty() || FoodType.isEmpty() || FoodPrice.isEmpty() || dateAdded == null || dateEx == null) {
                JOptionPane.showMessageDialog(rootPane, "No input! Please fill in all fields.");
                return;
            }

            // Convert copies anintd available to integers
  
            java.sql.Date sqlDateAdded = new java.sql.Date(dateAdded.getTime());
            java.sql.Date sqlDateEx = new java.sql.Date(dateEx.getTime());


            
            // Database connection
            con = CONN.getConnection();

            // Insert new book record
            String insertQuery = "INSERT INTO food (name, food_type, price, date_added, expiration_date) VALUES (?, ?, ?, ?, ?)";
            pst = con.prepareStatement(insertQuery);
            pst.setString(1, FoodName);
            pst.setString(2, FoodType);
            pst.setString(3, FoodPrice);
            pst.setDate(4, sqlDateAdded);
            pst.setDate(5, sqlDateEx);
            
            int k = pst.executeUpdate();

            if (k == 1) {
                JOptionPane.showMessageDialog(rootPane, "Product added successfully!");
                // Clear fields after successful insert
                FoodNtxt.setText("");
                FoodTtxt.setText("");
                FoodPtxt.setText("");
                DateFoodAdd.setDate(null);
                DateFoodEx.setDate(null);
                
            } else {
                JOptionPane.showMessageDialog(rootPane, "Failed to add products");
            }
                    loadFood();

            } catch (Exception ex) {
                Logger.getLogger(AdminPage.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, "Error occurred while adding the product.");
                JOptionPane.showMessageDialog(rootPane, "Invalid number format for copies!");
         } 
      
        
    }//GEN-LAST:event_InsertFoodActionPerformed

    private void CharNameeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CharNameeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CharNameeActionPerformed

    private void clear2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clear2MouseClicked
        // TODO add your handling code here:

                CharNamee.setText("");
                Franchise.setText("");
                height.setText("");
                points.setText("");
                material.setText("");
                dateAdded.setDate(null);
                pricetxt.setText("");
                
    }//GEN-LAST:event_clear2MouseClicked

    private void clear2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clear2ActionPerformed

    private void FranchiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FranchiseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FranchiseActionPerformed

    private void heightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_heightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_heightActionPerformed

    private void pricetxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pricetxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pricetxtActionPerformed

    private void TToyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TToyMouseClicked
        // TODO add your handling code here:
        
         int selectedRow = TToy.getSelectedRow();

        if (selectedRow >= 0) {
         int Id = Integer.parseInt(TToy.getValueAt(selectedRow, 0).toString());
        fetchToyData(Id);
        }
        
    }//GEN-LAST:event_TToyMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
                      SimpleDateFormat sdf = new SimpleDateFormat ("yyyy/MM/dd");

       
        int selectedRow = TToy.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Please select a product to update.");
        return;
}

    int productId = Integer.parseInt(TToy.getValueAt(selectedRow, 0).toString());

// Get text values
            
            String CharName = CharNamee.getText().trim();
            String fran = Franchise.getText().trim();
            String cm = height.getText().trim();
            String point = points.getText().trim();
            String mat = material.getText().trim();
            Date releasedate = dateAdded.getDate();
            String price = pricetxt.getText().trim();


// Check if any field is empty
        if (CharName.isEmpty() || fran.isEmpty() || cm.isEmpty() || point.isEmpty() || mat.isEmpty() || releasedate == null || price.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields must be filled out!");
        return;
}

        try {
            java.sql.Date sqlDate = new java.sql.Date(releasedate.getDate());



            String query = "UPDATE toy SET character_name=?, franchise=?, height_cm=?, articulation_points=?, material=?, release_date=?, price=? WHERE id=?";

            con = CONN.getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            
            pst.setString(1, CharName);
            pst.setString(2, fran);
            pst.setString(4, cm);
            pst.setString(5, point);
            pst.setString(6, mat);
            pst.setDate(7, sqlDate);
            pst.setString(8, price);
            pst.setInt(9, productId);

            
            

    int rowsUpdated = pst.executeUpdate();
    if (rowsUpdated > 0) {
        JOptionPane.showMessageDialog(null, "product updated successfully.");
              
                CharNamee.setText("");
                Franchise.setText("");
                height.setText("");
                points.setText("");
                material.setText("");
                dateAdded.setDate(null);
                pricetxt.setText("");
              
                loadToy(); // Refresh table
    } else {
        JOptionPane.showMessageDialog(null, "No product was updated. Please check the ID.");
    }

} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(null, "Invalid number format for copies! Please enter valid numbers.");
} catch (SQLException e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(null, "Error updating product.");
}
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void INSERTToyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INSERTToyActionPerformed
        // TODO add your handling code here:
        
               
                    SimpleDateFormat sdf = new SimpleDateFormat ("yyyy/MM/dd");
        
        try {
            String CharName = CharNamee.getText().trim();
            String fran = Franchise.getText().trim();
            String cm = height.getText().trim();
            String point = points.getText().trim();
            String materials = material.getText().trim();
            Date dateAddedd = dateAdded.getDate();
            String price = pricetxt.getText().trim();

            
                        
            // Check if any field is empty
            if (CharName.isEmpty() || fran.isEmpty() || cm.isEmpty() || point.isEmpty() || materials.isEmpty() || dateAddedd == null || price.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "No input! Please fill in all fields.");
                return;
            }

            // Convert copies anintd available to integers
  
            java.sql.Date sqlDateAdded = new java.sql.Date(dateAddedd.getTime());

            
            // Database connection
            con = CONN.getConnection();

            // Insert new book record
            String insertQuery = "INSERT INTO toy (character_name, franchise, height_cm, articulation_points, material, release_date, price) VALUES (?, ?, ?, ?, ?, ?, ?)";
            pst = con.prepareStatement(insertQuery);
            pst.setString(1, CharName);
            pst.setString(2, fran);
            pst.setString(3, cm);
            pst.setString(4, point);
            pst.setString(5, materials);
            pst.setDate(6, sqlDateAdded);
            pst.setString(7, price);
            
            
            int k = pst.executeUpdate();

            if (k == 1) {
                JOptionPane.showMessageDialog(rootPane, "Product added successfully!");
                // Clear fields after successful insert
                CharNamee.setText("");
                Franchise.setText("");
                height.setText("");
                points.setText("");
        
                material.setText("");
                dateAdded.setDate(null);
                pricetxt.setText("");
                
            } else {
                JOptionPane.showMessageDialog(rootPane, "Failed to add products");
            }
                   loadToy();

            } catch (Exception ex) {
                Logger.getLogger(AdminPage.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, "Error occurred while adding the product.");
                JOptionPane.showMessageDialog(rootPane, "Invalid number format for copies!");
         } 
      
        
    }//GEN-LAST:event_INSERTToyActionPerformed

    private void TXTPRODUCTNAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTPRODUCTNAMEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTPRODUCTNAMEActionPerformed

    private void clear3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clear3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_clear3MouseClicked

    private void clear3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear3ActionPerformed
        // TODO add your handling code here
        
           TXTPRODUCTNAME.setText("");
                DESDEC.setText("");
                DECTYPE.setText("");
                MATERIALDEC.setText("");
                DECPRICE.setText("");
        
    }//GEN-LAST:event_clear3ActionPerformed

    private void DESDECActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DESDECActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DESDECActionPerformed

    private void DECTYPEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DECTYPEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DECTYPEActionPerformed

    private void MATERIALDECActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MATERIALDECActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MATERIALDECActionPerformed

    private void TDecorationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TDecorationMouseClicked
        // TODO add your handling code here:
        
                 int selectedRow = TDecoration.getSelectedRow();

        if (selectedRow >= 0) {
         int Id = Integer.parseInt(TDecoration.getValueAt(selectedRow, 0).toString());
        fetchDesignData(Id);
        }

        
    }//GEN-LAST:event_TDecorationMouseClicked

    private void DecorUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecorUpdateActionPerformed
        // TODO add your handling code here:
        
       
        int selectedRow = TDecoration.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Please select a product to update.");
        return;
}

    int productId = Integer.parseInt(TDecoration.getValueAt(selectedRow, 0).toString());

// Get text values
            
            String PN = TXTPRODUCTNAME.getText().trim();
            String DES = DESDEC.getText().trim();
            String type = DECTYPE.getText().trim();
            String mat = MATERIALDEC.getText().trim();
            String pri = DECPRICE.getText().trim();


// Check if any field is empty
        if (PN.isEmpty() || DES.isEmpty() || type.isEmpty() || mat.isEmpty() || pri.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields must be filled out!");
        return;
}

        try {



            String query = "UPDATE design SET name=?, notes=?, type=?, material=?, price=? WHERE id=?";

            con = CONN.getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            
            pst.setString(1, PN);
            pst.setString(2, DES);
            pst.setString(3, type);
            pst.setString(4, mat);
            pst.setString(5, pri);
            pst.setInt(6, productId);

            
            

    int rowsUpdated = pst.executeUpdate();
    if (rowsUpdated > 0) {
        JOptionPane.showMessageDialog(null, "product updated successfully.");
              
                TXTPRODUCTNAME.setText("");
                DESDEC.setText("");
                DECTYPE.setText("");
                MATERIALDEC.setText("");
                DECPRICE.setText("");
              
                loadDesign(); // Refresh table
    } else {
        JOptionPane.showMessageDialog(null, "No product was updated. Please check the ID.");
    }

} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(null, "Invalid number format for copies! Please enter valid numbers.");
} catch (SQLException e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(null, "Error updating product.");
}
        
        
    }//GEN-LAST:event_DecorUpdateActionPerformed

    private void DecorINSERTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecorINSERTActionPerformed
        // TODO add your handling code here
        
            
        try {
            String deisignName = TXTPRODUCTNAME.getText().trim();
            String designDEC = DESDEC.getText().trim();
            String designType = DECTYPE.getText().trim();
            String designMat = MATERIALDEC.getText().trim();
            String desginprice = DECPRICE.getText().trim();

            
                        
            // Check if any field is empty
            if (deisignName.isEmpty() || designDEC.isEmpty() || designType.isEmpty() || designMat.isEmpty() || desginprice.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "No input! Please fill in all fields.");
                return;
            }

            // Convert copies anintd available to integers
  
            
            // Database connection
            con = CONN.getConnection();

            // Insert new book record
            String insertQuery = "INSERT INTO design (name, notes, type, material, price) VALUES (?, ?, ?, ?, ?)";
            pst = con.prepareStatement(insertQuery);
            pst.setString(1, deisignName);
            pst.setString(2, designDEC);
            pst.setString(3, designType);
            pst.setString(4, designMat);
            pst.setString(5, desginprice);
            
            
            int k = pst.executeUpdate();

            if (k == 1) {
                JOptionPane.showMessageDialog(rootPane, "Product added successfully!");
                // Clear fields after successful insert
                TXTPRODUCTNAME.setText("");
                DESDEC.setText("");
                DECTYPE.setText("");
                MATERIALDEC.setText("");
                DECPRICE.setText("");
                
            } else {
                JOptionPane.showMessageDialog(rootPane, "Failed to add products");
            }
                   loadDesign();

            } catch (Exception ex) {
                Logger.getLogger(AdminPage.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, "Error occurred while adding the product.");
                JOptionPane.showMessageDialog(rootPane, "Invalid number format for copies!");
         } 
      
        
    }//GEN-LAST:event_DecorINSERTActionPerformed

    private void PNaccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PNaccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PNaccActionPerformed

    private void clear4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clear4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_clear4MouseClicked

    private void clear4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear4ActionPerformed
        // TODO add your handling code here:
        
             PNacc.setText("");
                TypeAcc.setText("");
                c.setText("");
                colorAcc.setText("");
                AccPrice.setText("");
                DStyleacc.setText("");
        
    }//GEN-LAST:event_clear4ActionPerformed

    private void TypeAccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TypeAccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TypeAccActionPerformed

    private void DStyleaccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DStyleaccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DStyleaccActionPerformed

    private void TAccessoriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TAccessoriesMouseClicked
        // TODO add your handling code here:
        
            int selectedRow = TAccessories.getSelectedRow();

        if (selectedRow >= 0) {
         int Id = Integer.parseInt(TAccessories.getValueAt(selectedRow, 0).toString());
        fetchAccessoriesData(Id);
        }

        
    }//GEN-LAST:event_TAccessoriesMouseClicked

    private void UPDATEACCESSORIESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATEACCESSORIESActionPerformed
        // TODO add your handling code here:
        
         int selectedRow = TAccessories.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Please select a product to update.");
        return;
}

    int productId = Integer.parseInt(TAccessories.getValueAt(selectedRow, 0).toString());

// Get text values
            
            String PN = PNacc.getText().trim();
            String type = TypeAcc.getText().trim();
            String DS = DStyleacc.getText().trim();
            String mat = c.getText().trim();
            String color = colorAcc.getText().trim();
            String pri = AccPrice.getText().trim();


// Check if any field is empty
        if (PN.isEmpty() || type.isEmpty() || DS.isEmpty() || mat.isEmpty() || color.isEmpty() || pri.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields must be filled out!");
        return;
}

        try {



            String query = "UPDATE design SET name=?, type=?, design_style=?, material=?, color=?,  price=? WHERE id=?";

            con = CONN.getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            
            pst.setString(1, PN);
            pst.setString(2, type);
            pst.setString(3, DS);
            pst.setString(4, mat);
            pst.setString(5, color);
            pst.setString(6, pri);
            pst.setInt(7, productId);

            
            

    int rowsUpdated = pst.executeUpdate();
    if (rowsUpdated > 0) {
        JOptionPane.showMessageDialog(null, "product updated successfully.");
              
                PNacc.setText("");
                TypeAcc.setText("");
                DStyleacc.setText("");
                c.setText("");
                colorAcc.setText("");
                AccPrice.setText("");
              
                loadAccessories(); // Refresh table
    } else {
        JOptionPane.showMessageDialog(null, "No product was updated. Please check the ID.");
    }

} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(null, "Invalid number format for copies! Please enter valid numbers.");
} catch (SQLException e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(null, "Error updating product.");
}
        
        
    }//GEN-LAST:event_UPDATEACCESSORIESActionPerformed

    private void INSERTACCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INSERTACCActionPerformed
        // TODO add your handling code here:
             try {
            String accPN = PNacc.getText().trim();
            String accType = TypeAcc.getText().trim();
            String accDS = DStyleacc.getText().trim();
            String accmat = c.getText().trim();
            String accPrice = AccPrice.getText().trim();
            String accColor = colorAcc.getText().trim();

            
                        
            // Check if any field is empty
            if (accPN.isEmpty() || accType.isEmpty() || accDS.isEmpty() || accmat.isEmpty() || accPrice.isEmpty() || accColor.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "No input! Please fill in all fields.");
                return;
            }

            // Convert copies anintd available to integers
  
            // Database connection
            con = CONN.getConnection();

            // Insert new book record
            String insertQuery = "INSERT INTO accessories (name, type, design_style, material, color, price) VALUES (?, ?, ?, ?, ?, ?)";
            pst = con.prepareStatement(insertQuery);
            pst.setString(1, accPN);
            pst.setString(2, accType);
            pst.setString(3, accDS);
            pst.setString(4, accmat);
            pst.setString(5, accColor);
            pst.setString(6, accPrice);
            
            
            int k = pst.executeUpdate();

            if (k == 1) {
                JOptionPane.showMessageDialog(rootPane, "Product added successfully!");
                PNacc.setText("");
                TypeAcc.setText("");
                // Clear fields after successful insert
                PNacc.setText("");
                TypeAcc.setText("");
                DStyleacc.setText("");
                c.setText("");
                AccPrice.setText("");
                colorAcc.setText("");
                
            } else {
                JOptionPane.showMessageDialog(rootPane, "Failed to add products");
            }
                   loadAccessories();

           
 } catch (Exception ex) {
                Logger.getLogger(AdminPage.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, "Error occurred while adding the product.");
                JOptionPane.showMessageDialog(rootPane, "Invalid number format for copies!");
         } 
              
        
    }//GEN-LAST:event_INSERTACCActionPerformed

    private void ClothingNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClothingNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClothingNameActionPerformed

    private void clear5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clear5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_clear5MouseClicked

    private void clear5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear5ActionPerformed
        // TODO add your handling code here:
        
        
        ClothingName.setText("");
                ClothingType.setText("");
                ClothingSize.setText("");
                ClothingGender.setSelectedIndex(0);
                txtstock6.setText("");
                txtstock5.setText("");
    }//GEN-LAST:event_clear5ActionPerformed

    private void ClothingTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClothingTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClothingTypeActionPerformed

    private void ClothingSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClothingSizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClothingSizeActionPerformed

    private void txtstock5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstock5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstock5ActionPerformed

    private void Tproducts6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tproducts6MouseClicked
        // TODO add your handling code here:
        
        
            int selectedRow = Tproducts6.getSelectedRow();

        if (selectedRow >= 0) {
         int Id = Integer.parseInt(Tproducts6.getValueAt(selectedRow, 0).toString());
        fetchClothingData(Id);
        }

        
    }//GEN-LAST:event_Tproducts6MouseClicked

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        
              int selectedRow = Tproducts6.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Please select a product to update.");
        return;
}

    int productId = Integer.parseInt(Tproducts6.getValueAt(selectedRow, 0).toString());

// Get text values
            
            String PN = ClothingName.getText().trim();
            String type = ClothingType.getText().trim();
            String DS = ClothingSize.getText().trim();
            String mat = ClothingGender.getSelectedItem().toString().trim();
            String color = txtstock6.getText().trim();
            String pri = txtstock5.getText().trim();


// Check if any field is empty
        if (PN.isEmpty() || type.isEmpty() || DS.isEmpty() || mat.isEmpty() || color.isEmpty() || pri.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields must be filled out!");
        return;
}

        try {



            String query = "UPDATE clothing SET name=?, type=?, size=?, gender=?, price=?,  description=? WHERE id=?";

            con = CONN.getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            
            pst.setString(1, PN);
            pst.setString(2, type);
            pst.setString(3, DS);
            pst.setString(4, mat);
            pst.setString(5, color);
            pst.setString(6, pri);
            pst.setInt(7, productId);

            
            

    int rowsUpdated = pst.executeUpdate();
    if (rowsUpdated > 0) {
        JOptionPane.showMessageDialog(null, "product updated successfully.");
              
                ClothingName.setText("");
                ClothingType.setText("");
                ClothingSize.setText("");
                ClothingGender.setSelectedIndex(0);
                txtstock6.setText("");
                txtstock5.setText("");
              
                loadAccessories(); // Refresh table
    } else {
        JOptionPane.showMessageDialog(null, "No product was updated. Please check the ID.");
    }

} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(null, "Invalid number format for copies! Please enter valid numbers.");
} catch (SQLException e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(null, "Error updating product.");
}
        
        
    }//GEN-LAST:event_jButton11ActionPerformed

    private void Insert5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Insert5ActionPerformed
        // TODO add your handling code here:
        
             try {
            String clothName = ClothingName.getText().trim();
            String clothType = ClothingType.getText().trim();
            String clothsize = ClothingSize.getText().trim();
            String clothGender = ClothingGender.getSelectedItem().toString().trim();
            String clothPrice = txtstock6.getText().trim();
            String clothDes = txtstock5.getText().trim();

            
                        
            // Check if any field is empty
            if (clothName.isEmpty() || clothType.isEmpty() || clothsize.isEmpty() || clothGender.isEmpty() || clothPrice.isEmpty() || clothDes.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "No input! Please fill in all fields.");
                return;
            }

            // Convert copies anintd available to integers
  
            // Database connection
            con = CONN.getConnection();

            // Insert new book record
            String insertQuery = "INSERT INTO clothing (name, type, size, gender, price, description) VALUES (?, ?, ?, ?, ?, ?)";
            pst = con.prepareStatement(insertQuery);
            pst.setString(1, clothName);
            pst.setString(2, clothType);
            pst.setString(3, clothsize);
            pst.setString(4, clothGender);
            pst.setString(5, clothPrice);
            pst.setString(6, clothDes);
            
            
            int k = pst.executeUpdate();

            if (k == 1) {
                JOptionPane.showMessageDialog(rootPane, "Product added successfully!");
                ClothingName.setText("");
                ClothingType.setText("");
                ClothingSize.setText("");
                ClothingGender.setSelectedIndex(0);
                txtstock6.setText("");
                txtstock5.setText("");
                
            } else {
                JOptionPane.showMessageDialog(rootPane, "Failed to add products");
            }
                   loadClothing();

           
 } catch (Exception ex) {
                Logger.getLogger(AdminPage.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, "Error occurred while adding the product.");
                JOptionPane.showMessageDialog(rootPane, "Invalid number format for copies!");
         } 
              
        
    }//GEN-LAST:event_Insert5ActionPerformed

    private void materialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_materialActionPerformed

    private void pointsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pointsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pointsActionPerformed

    private void TToyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TToyMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_TToyMouseEntered

    private void cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cActionPerformed

    private void AccPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AccPriceActionPerformed

    private void colorAccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorAccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_colorAccActionPerformed

    private void DECPRICEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DECPRICEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DECPRICEActionPerformed

    private void ClothingGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClothingGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClothingGenderActionPerformed

    private void txtstock6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstock6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstock6ActionPerformed

    private void jLabel43MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel43MouseClicked
        // TODO add your handling code here:
        
                jTabbedPane1.setSelectedIndex(0);

        
    }//GEN-LAST:event_jLabel43MouseClicked

    private void jLabel59MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel59MouseClicked
        // TODO add your handling code here:
        
                jTabbedPane1.setSelectedIndex(1);

        
    }//GEN-LAST:event_jLabel59MouseClicked

    private void jLabel75MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel75MouseClicked
        // TODO add your handling code here:
        
                jTabbedPane1.setSelectedIndex(2);

        
    }//GEN-LAST:event_jLabel75MouseClicked

    private void jLabel76MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel76MouseClicked
        // TODO add your handling code here:
        
                jTabbedPane1.setSelectedIndex(3);

        
    }//GEN-LAST:event_jLabel76MouseClicked

    private void jLabel77MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel77MouseClicked
        // TODO add your handling code here:
        
                        jTabbedPane1.setSelectedIndex(4);

        
    }//GEN-LAST:event_jLabel77MouseClicked

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

    private void jLabel89MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel89MouseClicked
        // TODO add your handling code here:
                                TabPaneManagement.setSelectedIndex(6);

        
    }//GEN-LAST:event_jLabel89MouseClicked

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
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AccPrice;
    private javax.swing.JTextField CharNamee;
    private javax.swing.JComboBox<String> ClothingGender;
    private javax.swing.JTextField ClothingName;
    private javax.swing.JTextField ClothingSize;
    private javax.swing.JTextField ClothingType;
    private javax.swing.JComboBox<String> ComboBox;
    private javax.swing.JTextField DECPRICE;
    private javax.swing.JTextField DECTYPE;
    private javax.swing.JTextField DESDEC;
    private javax.swing.JTextField DStyleacc;
    private com.toedter.calendar.JDateChooser DateFoodAdd;
    private com.toedter.calendar.JDateChooser DateFoodEx;
    private javax.swing.JButton DecorINSERT;
    private javax.swing.JButton DecorUpdate;
    private javax.swing.JButton DeleteSupplier;
    private javax.swing.JTextField FoodNtxt;
    private javax.swing.JTextField FoodPtxt;
    private javax.swing.JTextField FoodTtxt;
    private javax.swing.JTextField Franchise;
    private javax.swing.JButton INSERTACC;
    private javax.swing.JButton INSERTToy;
    private javax.swing.JButton Insert;
    private javax.swing.JButton Insert5;
    private javax.swing.JButton InsertFood;
    private javax.swing.JButton InsertSupplier;
    private javax.swing.JTextField MATERIALDEC;
    private javax.swing.JTextField PNacc;
    private javax.swing.JPanel ProductCategoryTab;
    private javax.swing.JPanel ProductsCategory;
    private javax.swing.JTable TACCESSORIES;
    private javax.swing.JTable TAccessories;
    private javax.swing.JTable TDECORATION;
    private javax.swing.JTable TDecoration;
    private javax.swing.JTable TFOOD;
    private javax.swing.JTable TTOYY;
    private javax.swing.JTable TToy;
    private javax.swing.JTextField TXTPRODUCTNAME;
    private javax.swing.JTextField TXtToy;
    private javax.swing.JTabbedPane TabPaneCategory;
    private javax.swing.JTabbedPane TabPaneManagement;
    private javax.swing.JTable Tproducts;
    private javax.swing.JTable Tproducts1;
    private javax.swing.JTable Tproducts6;
    private javax.swing.JTable Tproducts7;
    private javax.swing.JTable TproductsFood;
    private javax.swing.JTable Tsup;
    private javax.swing.JTable Tuser;
    private javax.swing.JTextField TxtAccessories;
    private javax.swing.JTextField TxtCLOTHING;
    private javax.swing.JTextField TxtDecoration;
    private javax.swing.JTextField TxtFood;
    private javax.swing.JTextField TypeAcc;
    private javax.swing.JButton UPDATEACCESSORIES;
    private javax.swing.JButton USERclearBtn;
    private javax.swing.JButton USERdeleteBtn;
    private javax.swing.JButton USERinsertBtn;
    private javax.swing.JButton USERupdateBtn;
    private javax.swing.JButton UpdateFood;
    private javax.swing.JButton UpdateSupplier;
    private javax.swing.JLabel accecount;
    private javax.swing.JLabel asdasdasd;
    private javax.swing.JTextField c;
    private javax.swing.JButton clear;
    private javax.swing.JButton clear1;
    private javax.swing.JButton clear2;
    private javax.swing.JButton clear3;
    private javax.swing.JButton clear4;
    private javax.swing.JButton clear5;
    private javax.swing.JButton clearS;
    private javax.swing.JLabel clocount;
    private javax.swing.JLabel clocount1;
    private javax.swing.JTextField colorAcc;
    private com.toedter.calendar.JDateChooser dateAdded;
    private com.toedter.calendar.JDateChooser datetxt;
    private javax.swing.JLabel decocount;
    private javax.swing.JTextField descriptiontxt;
    private javax.swing.JLabel foodcount;
    private javax.swing.JTextField height;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
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
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField material;
    private javax.swing.JTextField nametxt;
    private javax.swing.JLabel oras;
    private javax.swing.JTextField passtxt;
    private javax.swing.JLabel petsa;
    private javax.swing.JTextField points;
    private javax.swing.JTextField pricetxt;
    private javax.swing.JComboBox<String> roletxt;
    private javax.swing.JTextField searchtxt;
    private javax.swing.JLabel suppliercount;
    private javax.swing.JLabel totals;
    private javax.swing.JLabel toycount;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNumber;
    private javax.swing.JTextField txtSname;
    private javax.swing.JTextArea txtddress;
    private javax.swing.JTextField txtdes;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txtproductname;
    private javax.swing.JTextField txtsocial;
    private javax.swing.JTextField txtstock;
    private javax.swing.JTextField txtstock5;
    private javax.swing.JTextField txtstock6;
    private javax.swing.JLabel usercount;
    private javax.swing.JLabel usercount1;
    private javax.swing.JTextField usertxt;
    // End of variables declaration//GEN-END:variables
}
