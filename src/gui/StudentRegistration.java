/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

/**
 *
 * @author acer
 */
public class StudentRegistration extends javax.swing.JFrame {

    public static HashMap<String, Integer> destrictMap = new HashMap();
    public static HashMap<String, Integer> gendertMap = new HashMap();
    public static HashMap<String, Integer> batchMap = new HashMap();
    String regexMobile = "\\d{10}";
    String regexEmail = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    String regexDate = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/([0-9]{4})$";

    /**
     * Creates new form StudentRegistration
     */
    public StudentRegistration() {

        initComponents();

//        this.setAlwaysOnTop(true);
//        Toolkit kit = Toolkit.getDefaultToolkit();
//        int x = (int) kit.getScreenSize().getWidth();
//        int y = (int) kit.getScreenSize().getHeight();
//        Insets scnMax = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
//        int taskBarSize = scnMax.bottom;
//        this.setSize(x, y - taskBarSize);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        loadComboBox();
        genderLoad();
        loadUsers();
        reset();

    }

    public void reset() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setEditable(false);
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        jTextField10.setText("");
        jTextField11.setText("");
        jTextField12.setText("");
        jTextField13.setText("");
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        jPasswordField1.setText("");
        jButton2.setEnabled(true);
        loadBatch();

        Runnable runnable = new Runnable() {
            public void run() {
                while (true) {
                    Date date = new Date();
                    SimpleDateFormat form1 = new SimpleDateFormat("yyyy-MM-dd");
                    String stringDate = form1.format(date);
                    jTextField6.setText(stringDate);

                    Date time = new Date();
                    SimpleDateFormat form1Time = new SimpleDateFormat("hh:mm:ss a");
                    String stringTime = form1Time.format(time);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        };
        Thread thred = new Thread(runnable);
        thred.start();
    }

    public void loadUsers() {
        try {
            ResultSet resultSet = MySQL.execute("SELECT * FROM `Student`\n"
                    + "INNER JOIN `district` ON `student`.`district_id` = `district`.`id`\n"
                    + "INNER JOIN `gender`ON `student`.`gender_id` = `gender`.`id`"
                    + "INNER JOIN `batch` ON `student`.`batch_id` = `batch`.`id` ORDER BY student.id ASC");

            DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
            tableModel.setRowCount(0);

            while (resultSet.next()) {

                Vector<String> v = new Vector();

                v.add(resultSet.getString("student.id"));
                v.add(resultSet.getString("frist_name"));
                v.add(resultSet.getString("last_name"));
                v.add(resultSet.getString("date_of_birth"));
                v.add(resultSet.getString("father_name"));
                v.add(resultSet.getString("father_mobile"));
                v.add(resultSet.getString("date_of_reg"));
                v.add(resultSet.getString("email"));
                v.add(resultSet.getString("mobile"));
                v.add(resultSet.getString("gender.gender"));
                v.add(resultSet.getString("user_name"));
                v.add(resultSet.getString("password"));
                v.add(resultSet.getString("district.name"));
                v.add(resultSet.getString("address_no"));
                v.add(resultSet.getString("street"));
                v.add(resultSet.getString("city"));
                v.add(resultSet.getString("batch.name"));

                tableModel.addRow(v);
                jTable1.setModel(tableModel);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadComboBox() {
        try {
//            System.out.println("pp");
            ResultSet resultSet = MySQL.execute("SELECT * FROM `district`");
//            System.out.println("qq");

            Vector vectorD = new Vector();
            vectorD.add("Select");

            while (resultSet.next()) {
                vectorD.add(resultSet.getString("name"));
                destrictMap.put(resultSet.getString("name"), resultSet.getInt("id"));
            }

            DefaultComboBoxModel districtModel = new DefaultComboBoxModel(vectorD);
            jComboBox1.setModel(districtModel);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void genderLoad() {
        try {
            ResultSet resultSet = MySQL.execute("SELECT * FROM `gender`");

            Vector vectorG = new Vector();
            vectorG.add("Selcet");

            while (resultSet.next()) {
                vectorG.add(resultSet.getString("gender"));
                gendertMap.put(resultSet.getString("gender"), resultSet.getInt("id"));

            }

            DefaultComboBoxModel genderModel = new DefaultComboBoxModel(vectorG);
            jComboBox2.setModel(genderModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadBatch() {
        try {
            ResultSet resultSet = MySQL.execute("SELECT * FROM `batch`");
            Vector vectorB = new Vector();
            vectorB.add("Select Batch");

            while (resultSet.next()) {
                vectorB.add(resultSet.getString("name"));
                batchMap.put(resultSet.getString("name"), resultSet.getInt("id"));
            }

            DefaultComboBoxModel batchModel = new DefaultComboBoxModel(vectorB);
            jComboBox3.setModel(batchModel);

        } catch (Exception e) {
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

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField11 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTextField10 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Details");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Student Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel1.setText("Gender");

        jTextField1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel2.setText("Last Name");

        jTextField2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel3.setText("Father Name");

        jTextField3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel4.setText("Father Mbile");

        jTextField4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel5.setText("DOB");

        jTextField5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel6.setText("Register Date");

        jTextField6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel7.setText("Email");

        jTextField7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel8.setText("Mobile");

        jTextField8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel9.setText("Username");

        jTextField9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel10.setText("Password");

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel11.setText("Disteic");

        jComboBox1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextField11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel12.setText("Address No");

        jTextField12.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel13.setText("Street");

        jTextField13.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel14.setText("City");

        jLabel15.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel15.setText("Frist Name");

        jComboBox2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/visible.png"))); // NOI18N
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Action", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("Add Student");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setText("Update Details");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setText("Delete Student");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setText("Search Student");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTextField10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField10KeyReleased(evt);
            }
        });

        jLabel16.setText("Enter ID");

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Back.png"))); // NOI18N
        jButton6.setText("Back");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton7.setText("Reset");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(jTextField10)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addGap(14, 14, 14)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addContainerGap())
        );

        jTable1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Frist Name", "Last Name", "DOB", "Father Name", "Father Mobile", "Register Date", "Email", "Mobile", "Gender", "Username", "Password", "Distric", "Address No", "Street", "City", "Batch"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jComboBox3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel17.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel17.setText("batch");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jTextField7))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jTextField8))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField1)
                                            .addComponent(jLabel15))
                                        .addGap(21, 21, 21)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jTextField2)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
                                        .addGap(21, 21, 21)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField6)
                                    .addComponent(jTextField5)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jTextField9)
                                    .addComponent(jLabel12)
                                    .addComponent(jTextField11))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jPasswordField1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11))
                                        .addGap(1, 1, 1))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addComponent(jTextField12))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14)
                                            .addComponent(jTextField13))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(jLabel2)
                                                                    .addComponent(jLabel15))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addComponent(jLabel5)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addComponent(jLabel4)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addComponent(jLabel6)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                            .addComponent(jLabel1)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                            .addComponent(jLabel8)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addComponent(jLabel7)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel17)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Add Student code here:
        String fristName = jTextField1.getText();
        String lastName = jTextField2.getText();
        String dob = jTextField5.getText();
        String fatherName = jTextField3.getText();
        String fatherMobile = jTextField4.getText();
        String registreDate = jTextField6.getText();
        String email = jTextField7.getText();
        String mobile = jTextField8.getText();
        String gender = String.valueOf(jComboBox2.getSelectedItem());
        String userName = jTextField9.getText();
        String password = String.valueOf(jPasswordField1.getPassword());
        String distric = String.valueOf(jComboBox1.getSelectedItem());
        String addressNo = jTextField11.getText();
        String street = jTextField12.getText();
        String city = jTextField13.getText();
        String batch = String.valueOf(jComboBox3.getSelectedItem());

        if (fristName.isEmpty()) {
            JOptionPane.showConfirmDialog(this, "Enter First Name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (lastName.isEmpty()) {
            JOptionPane.showConfirmDialog(this, "Enter Last Name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (dob.isEmpty()) {
            JOptionPane.showConfirmDialog(this, "Enter DOB", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (fatherName.isEmpty()) {
            JOptionPane.showConfirmDialog(this, "Enter Father Name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (fatherMobile.isEmpty()) {
            JOptionPane.showConfirmDialog(this, "Enter Father Mobile", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (registreDate.isEmpty()) {
            JOptionPane.showConfirmDialog(this, "Enter Register Date", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (email.isEmpty()) {
            JOptionPane.showConfirmDialog(this, "Enter Email", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (mobile.isEmpty()) {
            JOptionPane.showConfirmDialog(this, "Enter Mobile", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (gender.equals("Selcet")) {
            JOptionPane.showConfirmDialog(this, "Choos Gender", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (batch.equals("Selcet Batch")) {
            JOptionPane.showConfirmDialog(this, "Choos Gender", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (userName.isEmpty()) {
            JOptionPane.showConfirmDialog(this, "Enter userName", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (password.isEmpty()) {
            JOptionPane.showConfirmDialog(this, "Enter password", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (distric.equals("Select")) {
            JOptionPane.showConfirmDialog(this, "Choos Distric", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (addressNo.isEmpty()) {
            JOptionPane.showConfirmDialog(this, "Enter Address No", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (street.isEmpty()) {
            JOptionPane.showConfirmDialog(this, "Enter Street", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (city.isEmpty()) {
            JOptionPane.showConfirmDialog(this, "Enter City", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (city.isEmpty()) {
            JOptionPane.showConfirmDialog(this, "Enter City", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!fatherMobile.matches(regexMobile)) {
            JOptionPane.showConfirmDialog(this, "Enter Valid Mobile", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!email.matches(regexEmail)) {
            JOptionPane.showConfirmDialog(this, "Enter Valid Email", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!mobile.matches(regexMobile)) {
            JOptionPane.showConfirmDialog(this, "Enter Valid Father Mobile", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            try {
                int genderId = gendertMap.get(gender);
                int districtId = destrictMap.get(distric);
                int batchId = batchMap.get(batch);
                MySQL.execute("INSERT INTO"
                        + "`student`(`frist_name`,`last_name`,`father_name`,`father_mobile`,`date_of_birth`,`date_of_reg`,`email`"
                        + ",`mobile`,`user_name`,`password`,`district_id`,`address_no`,`street`,`city`,`gender_id`,`batch_id`)"
                        + "VALUES ('" + fristName + "','" + lastName + "','" + fatherName + "','" + fatherMobile + "','" + dob + "','" + registreDate + "','" + email + "',"
                        + "'" + mobile + "','" + userName + "','" + password + "','" + districtId + "','" + addressNo + "','" + street + "','" + city + "','" + genderId + "','" + batchId + "')");
                JOptionPane.showConfirmDialog(this, "Student Adding Success", "Success", JOptionPane.PLAIN_MESSAGE);
                reset();
                jTable1.setEnabled(true);
                jButton1.setEnabled(true);
                jTextField1.grabFocus();
                loadUsers();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

        if (evt.getClickCount() == 2) {
            jButton2.setEnabled(false);
            jTable1.setEnabled(false);

            int selectedRow = jTable1.getSelectedRow();
            String fristName = String.valueOf(jTable1.getValueAt(selectedRow, 1));
            jTextField1.setText(fristName);

            String lasttName = String.valueOf(jTable1.getValueAt(selectedRow, 2));
            jTextField2.setText(lasttName);

            String dob = String.valueOf(jTable1.getValueAt(selectedRow, 3));
            jTextField5.setText(dob);

            String fatherName = String.valueOf(jTable1.getValueAt(selectedRow, 4));
            jTextField3.setText(fatherName);

            String fatherMobile = String.valueOf(jTable1.getValueAt(selectedRow, 5));
            jTextField4.setText(fatherMobile);

            String redDate = String.valueOf(jTable1.getValueAt(selectedRow, 6));
            jTextField6.setText(redDate);

            String email = String.valueOf(jTable1.getValueAt(selectedRow, 7));
            jTextField7.setText(email);

            String mobile = String.valueOf(jTable1.getValueAt(selectedRow, 8));
            jTextField8.setText(mobile);

            String gender = String.valueOf(jTable1.getValueAt(selectedRow, 9));
            jComboBox2.setSelectedItem(gender);
//            System.out.println(gender);

            String userName = String.valueOf(jTable1.getValueAt(selectedRow, 10));
            jTextField9.setText(userName);

            String password = String.valueOf(jTable1.getValueAt(selectedRow, 11));
            jPasswordField1.setText(password);

            String district = String.valueOf(jTable1.getValueAt(selectedRow, 12));
            jComboBox1.setSelectedItem(district);
//            System.out.println(district);

            String addressNo = String.valueOf(jTable1.getValueAt(selectedRow, 13));
            jTextField11.setText(addressNo);

            String street = String.valueOf(jTable1.getValueAt(selectedRow, 14));
            jTextField12.setText(street);

            String city = String.valueOf(jTable1.getValueAt(selectedRow, 15));
            jTextField13.setText(city);

            String batch = String.valueOf(jTable1.getValueAt(selectedRow, 16));
            jComboBox3.setSelectedItem(batch);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showConfirmDialog(this, "Pleace Select Student", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            String id = String.valueOf(jTable1.getValueAt(selectedRow, 0));
            String fristName = jTextField1.getText();
            String lastName = jTextField2.getText();
            String dob = jTextField5.getText();
            String fatherName = jTextField3.getText();
            String fatherMobile = jTextField4.getText();
            String registreDate = jTextField6.getText();
            String email = jTextField7.getText();
            String mobile = jTextField8.getText();
            String gender = String.valueOf(jComboBox2.getSelectedItem());
            String userName = jTextField9.getText();
            String password = String.valueOf(jPasswordField1.getPassword());
            String distric = String.valueOf(jComboBox1.getSelectedItem());
            String addressNo = jTextField11.getText();
            String street = jTextField12.getText();
            String city = jTextField13.getText();
            String batch = String.valueOf(jComboBox3.getSelectedItem());

            if (fristName.isEmpty()) {
                JOptionPane.showConfirmDialog(this, "Enter First Name", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (lastName.isEmpty()) {
                JOptionPane.showConfirmDialog(this, "Enter Last Name", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (dob.isEmpty()) {
                JOptionPane.showConfirmDialog(this, "Enter DOB", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (fatherName.isEmpty()) {
                JOptionPane.showConfirmDialog(this, "Enter Father Name", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (fatherMobile.isEmpty()) {
                JOptionPane.showConfirmDialog(this, "Enter Father Mobile", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (registreDate.isEmpty()) {
                JOptionPane.showConfirmDialog(this, "Enter Register Date", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (email.isEmpty()) {
                JOptionPane.showConfirmDialog(this, "Enter Email", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (mobile.isEmpty()) {
                JOptionPane.showConfirmDialog(this, "Enter Mobile", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (gender.equals("Selcet")) {
                JOptionPane.showConfirmDialog(this, "Choos Gender", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (batch.equals("Selcet")) {
                JOptionPane.showConfirmDialog(this, "Choos Batch", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (userName.isEmpty()) {
                JOptionPane.showConfirmDialog(this, "Enter userName", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (password.isEmpty()) {
                JOptionPane.showConfirmDialog(this, "Enter password", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (distric.equals("Select")) {
                JOptionPane.showConfirmDialog(this, "Choos Distric", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (addressNo.isEmpty()) {
                JOptionPane.showConfirmDialog(this, "Enter Address No", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (street.isEmpty()) {
                JOptionPane.showConfirmDialog(this, "Enter Street", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (city.isEmpty()) {
                JOptionPane.showConfirmDialog(this, "Enter City", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {

                try {
                    int genderId = gendertMap.get(gender);
                    int districtId = destrictMap.get(distric);
                    int batchId = batchMap.get(batch);
                    MySQL.execute("UPDATE `student` SET"
                            + "`frist_name`='" + fristName + "',"
                            + "`last_name`='" + lastName + "',"
                            + "`father_name`='" + fatherName + "',"
                            + "`father_mobile`='" + fatherMobile + "',"
                            + "`date_of_birth`='" + dob + "',"
                            + "`date_of_reg`='" + registreDate + "',"
                            + "`email`='" + email + "',"
                            + "`mobile`='" + mobile + "',"
                            + "`user_name`='" + userName + "',"
                            + "`password`='" + password + "',"
                            + "`district_id`='" + districtId + "',"
                            + "`address_no`='" + addressNo + "',"
                            + "`street`='" + street + "',"
                            + "`city`='" + city + "',"
                            + "`gender_id`='" + genderId + "',"
                            + "`batch_id`='" + batchId + "'"
                            + "WHERE `id`='" + id + "'");
                    JOptionPane.showConfirmDialog(this, "Updatin Is Success", "Success", JOptionPane.PLAIN_MESSAGE);
                    reset();
                    loadUsers();
                    jButton2.setEnabled(true);
                    jTable1.setEnabled(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Delete Student code here:
        int selectedRow = jTable1.getSelectedRow();
        jButton2.setEnabled(true);
        jTable1.setEnabled(true);
        jButton2.grabFocus();
        if (selectedRow == -1) {
            JOptionPane.showConfirmDialog(this, "Pleace Select Student", "Warning", JOptionPane.ERROR_MESSAGE);
        } else {
            String id = String.valueOf(jTable1.getValueAt(selectedRow, 0));
            try {
                MySQL.execute("DELETE FROM `student` WHERE `id`='" + id + "'");
                JOptionPane.showConfirmDialog(this, "Student Account Deleted Success ", "Success", JOptionPane.PLAIN_MESSAGE);
                jButton2.setEnabled(true);
                jTable1.setEnabled(true);
                jButton2.grabFocus();
                reset();
                loadUsers();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyReleased
        // Search Studet code here:

//        String id = jTextField10.getText();
//        System.out.println(id);
//
//        try {
//            ResultSet resultSet = MySQL.execute("SELECT * FROM `Student`\n"
//                    + "INNER JOIN `district` ON `student`.`district_id` = `district`.`id`\n"
//                    + "INNER JOIN `gender`ON `student`.`gender_id` = `gender`.`id` WHERE student.id='" + id + "'");
//
//            if (id.isEmpty()) {
//                loadUsers();
//            }
//            if (resultSet.next()) {
//                DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
//                tableModel.setRowCount(0);
//
//                Vector<String> v = new Vector();
//
//                v.add(resultSet.getString("student.id"));
//                v.add(resultSet.getString("frist_name"));
//                v.add(resultSet.getString("last_name"));
//                v.add(resultSet.getString("date_of_birth"));
//                v.add(resultSet.getString("father_name"));
//                v.add(resultSet.getString("father_mobile"));
//                v.add(resultSet.getString("date_of_reg"));
//                v.add(resultSet.getString("email"));
//                v.add(resultSet.getString("mobile"));
//                v.add(resultSet.getString("gender.gender"));
//                v.add(resultSet.getString("user_name"));
//                v.add(resultSet.getString("password"));
//                v.add(resultSet.getString("district.name"));
//                v.add(resultSet.getString("address_no"));
//                v.add(resultSet.getString("street"));
//                v.add(resultSet.getString("city"));
//
//                tableModel.addRow(v);
//                jTable1.setModel(tableModel);
//
//            }
//        } catch (Exception e) {
//        }
    }//GEN-LAST:event_jTextField10KeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // Search button code here:
        String id = jTextField10.getText();

        try {
            ResultSet resultSet = MySQL.execute("SELECT * FROM `Student`\n"
                    + "INNER JOIN `district` ON `student`.`district_id` = `district`.`id`\n"
                    + "INNER JOIN `gender`ON `student`.`gender_id` = `gender`.`id`"
                    + "INNER JOIN `batch` ON `student`.`batch_id` = `batch`.`id` WHERE student.id='" + id + "'");

            if (resultSet.next()) {
                DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
                tableModel.setRowCount(0);

                Vector<String> v = new Vector();

                v.add(resultSet.getString("student.id"));
                v.add(resultSet.getString("frist_name"));
                v.add(resultSet.getString("last_name"));
                v.add(resultSet.getString("date_of_birth"));
                v.add(resultSet.getString("father_name"));
                v.add(resultSet.getString("father_mobile"));
                v.add(resultSet.getString("date_of_reg"));
                v.add(resultSet.getString("email"));
                v.add(resultSet.getString("mobile"));
                v.add(resultSet.getString("gender.gender"));
                v.add(resultSet.getString("user_name"));
                v.add(resultSet.getString("password"));
                v.add(resultSet.getString("district.name"));
                v.add(resultSet.getString("address_no"));
                v.add(resultSet.getString("street"));
                v.add(resultSet.getString("city"));
                v.add(resultSet.getString("batch.name"));

                tableModel.addRow(v);
                jTable1.setModel(tableModel);

            } else {
                JOptionPane.showConfirmDialog(this, "Invalid ID Number", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        // TODO add your handling code here:
        jPasswordField1.setEchoChar('\u0000');
    }//GEN-LAST:event_jButton1MousePressed

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
        // TODO add your handling code here:        
        jPasswordField1.setEchoChar('\u25cf');
    }//GEN-LAST:event_jButton1MouseReleased

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Home home = new Home();
        home.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        reset();
        loadUsers();
    }//GEN-LAST:event_jButton7ActionPerformed

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
            java.util.logging.Logger.getLogger(StudentRegistration.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentRegistration.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentRegistration.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentRegistration.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
