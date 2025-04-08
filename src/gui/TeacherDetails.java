/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import java.awt.Insets;
import java.awt.Toolkit;
import java.sql.ResultSet;
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
public class TeacherDetails extends javax.swing.JFrame {

    /**
     * Creates new form StudentRegistration
     */
    public static HashMap<String, Integer> genHashMap = new HashMap<>();
    public static HashMap<String, Integer> destrictMap = new HashMap<>();
    public static HashMap<String, Integer> subjectMap = new HashMap<>();
    String regex = "\\d{10}";

    public TeacherDetails() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        reSize();
        loadComboBox();
        reset();
        loadTeacher();
    }

    public void reSize() {
        this.setAlwaysOnTop(true);
        Toolkit kit = Toolkit.getDefaultToolkit();
        int x = (int) kit.getScreenSize().getWidth();
        int y = (int) kit.getScreenSize().getHeight();
        Insets scnMax = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
        int taskBarSize = scnMax.bottom;
        this.setSize(x, y - taskBarSize);
    }

    public void loadComboBox() {
        try {
            ResultSet resultSet = MySQL.execute("SELECT * FROM `gender`");

            Vector vectorG = new Vector();
            vectorG.add("Selcet Gender");

            while (resultSet.next()) {
                vectorG.add(resultSet.getString("gender"));
                genHashMap.put(resultSet.getString("gender"), resultSet.getInt("id"));
            }

            DefaultComboBoxModel genderModel = new DefaultComboBoxModel(vectorG);
            jComboBox1.setModel(genderModel);
            resultSet.close();

            ResultSet resultSet1 = MySQL.execute("SELECT * FROM `district`");

            Vector vectorD = new Vector();
            vectorD.add("Select District");

            while (resultSet1.next()) {
                vectorD.add(resultSet1.getString("name"));
                destrictMap.put(resultSet1.getString("name"), resultSet1.getInt("id"));
            }

            DefaultComboBoxModel districtModel = new DefaultComboBoxModel(vectorD);
            jComboBox2.setModel(districtModel);

            ResultSet resultSet2 = MySQL.execute("SELECT * FROM `subject`");

            Vector vectorS = new Vector();
            vectorS.add("Select Subject");

            while (resultSet2.next()) {
                vectorS.add(resultSet2.getString("subject_name"));
                subjectMap.put(resultSet2.getString("subject_name"), resultSet2.getInt("id"));
            }
            DefaultComboBoxModel subjectModel = new DefaultComboBoxModel(vectorS);
            jComboBox3.setModel(subjectModel);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reset() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        jPasswordField1.setText("");
        jComboBox1.setSelectedItem(0);
        jComboBox2.setSelectedItem(0);
        jComboBox3.setSelectedItem(0);
        jTextField1.grabFocus();

    }

    public void loadTeacher() {
        try {
            ResultSet resultSet = MySQL.execute("SELECT * FROM `teacher`\n"
                    + "INNER JOIN `district` ON `teacher`.district_id = `district`.id\n"
                    + "INNER JOIN `subject` ON `teacher`.subject_id = `subject`.id\n"
                    + "INNER JOIN `gender` ON `teacher`.gender_id = `gender`.id ORDER BY teacher.id ASC");

            DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
            tableModel.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> v = new Vector();
                v.add(resultSet.getString("teacher.id"));
                v.add(resultSet.getString("frist_name"));
                v.add(resultSet.getString("last_name"));
                v.add(resultSet.getString("nic_number"));
                v.add(resultSet.getString("mobile"));
                v.add(resultSet.getString("user_name"));
                v.add(resultSet.getString("password"));
                v.add(resultSet.getString("gender.gender"));
                v.add(resultSet.getString("district.name"));
                v.add(resultSet.getString("address_no"));
                v.add(resultSet.getString("street"));
                v.add(resultSet.getString("city"));
                v.add(resultSet.getString("subject.subject_name"));

                tableModel.addRow(v);
                jTable1.setModel(tableModel);
            }

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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField7 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Teacher Details");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Teacher Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel1.setText("Frist Name");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel2.setText("Last Name");

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel3.setText("NIC");

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel4.setText("Mobile");

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel5.setText("Password");

        jPasswordField1.setText("jPasswordField1");
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/visible.png"))); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel6.setText("Gender");

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel7.setText("Address No");

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel8.setText("District");

        jComboBox2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel9.setText("Street");

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel10.setText("City");

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel11.setText("Subject");

        jComboBox3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Action", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("Add Teacher");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setText("Update Teacher");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setText("Delete Teacher");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Enter ID");

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setText("Search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Frist Name", "Last Name", "NIC", "Mobile", "Username", "Password", "Gender", "District", "Address No", "Street", "City", "Subject"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
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

        jLabel13.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel13.setText("Username");

        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                            .addComponent(jComboBox2, 0, 187, Short.MAX_VALUE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                            .addComponent(jTextField1)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel7)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField9)
                                    .addComponent(jTextField2)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox3, 0, 147, Short.MAX_VALUE)
                                    .addComponent(jLabel11))
                                .addGap(46, 46, 46)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(55, 55, 55))
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(95, 95, 95))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel3)
                                    .addComponent(jTextField7))
                                .addGap(48, 48, 48))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPasswordField1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jPasswordField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 53, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Add Teacher code here:
        String frisName = jTextField1.getText();
        String lastName = jTextField2.getText();
        String nic = jTextField3.getText();
        String mobile = jTextField4.getText();
        String password = String.valueOf(jPasswordField1.getPassword());
        String gender = String.valueOf(jComboBox1.getSelectedItem());
        String district = String.valueOf(jComboBox2.getSelectedItem());
        String addressNo = jTextField6.getText();
        String street = jTextField7.getText();
        String city = jTextField8.getText();
        String username = jTextField9.getText();
        String subject = String.valueOf(jComboBox3.getSelectedItem());


        if (frisName.isEmpty()) {
            JOptionPane.showConfirmDialog(this, "Enter First Name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (lastName.isEmpty()) {
            JOptionPane.showConfirmDialog(this, "Enter Last Name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (nic.isEmpty()) {
            JOptionPane.showConfirmDialog(this, "Enter NIC", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (mobile.isEmpty()) {
            JOptionPane.showConfirmDialog(this, "Enter Mobile", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (username.isEmpty()) {
            JOptionPane.showConfirmDialog(this, "Enter userName", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (password.isEmpty()) {
            JOptionPane.showConfirmDialog(this, "Enter password", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (district.equals("Select")) {
            JOptionPane.showConfirmDialog(this, "Choos Distric", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (addressNo.isEmpty()) {
            JOptionPane.showConfirmDialog(this, "Enter Address No", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (street.isEmpty()) {
            JOptionPane.showConfirmDialog(this, "Enter Street", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (city.isEmpty()) {
            JOptionPane.showConfirmDialog(this, "Enter City", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (subject.isEmpty()) {
            JOptionPane.showConfirmDialog(this, "Choos subject", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (gender.equals("Selcet")) {
            JOptionPane.showConfirmDialog(this, "Choos Gender", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!mobile.matches(regex)) {
            JOptionPane.showConfirmDialog(this, "Entre Valide Mobile", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            try {
                int genderId = genHashMap.get(gender);
                int districtId = destrictMap.get(district);
                int subjectId = subjectMap.get(subject);
//            System.out.println(genderId);
//            System.out.println(subjectId);
//            System.out.println(districtId);
                MySQL.execute("INSERT INTO `teacher` (`frist_name`,`last_name`,`nic_number`,`mobile`,`user_name`,`password`,"
                        + "`district_id`,`address_no`,`street`,`city`,`gender_id`,`subject_id`)VALUES"
                        + "('" + frisName + "','" + lastName + "','" + nic + "','" + mobile + "','" + username + "','" + password + "','" + districtId + "',"
                        + "'" + addressNo + "','" + street + "','" + city + "','" + genderId + "','" + subjectId + "')");
                JOptionPane.showConfirmDialog(this, "Success", "Success", JOptionPane.PLAIN_MESSAGE);
                reset();
                loadTeacher();
                loadComboBox();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

        if (evt.getClickCount() == 2) {
            jButton2.setEnabled(false);
            jTable1.setEnabled(false);
            jButton5.setEnabled(false);
            jTextField5.setEnabled(false);

            int selectedRow = jTable1.getSelectedRow();

            String id = String.valueOf(jTable1.getValueAt(selectedRow, 0));
            jTextField5.setText(id);

            String fristName = String.valueOf(jTable1.getValueAt(selectedRow, 1));
            jTextField1.setText(fristName);

            String lastName = String.valueOf(jTable1.getValueAt(selectedRow, 2));
            jTextField2.setText(lastName);

            String nic = String.valueOf(jTable1.getValueAt(selectedRow, 3));
            jTextField3.setText(nic);

            String mobile = String.valueOf(jTable1.getValueAt(selectedRow, 4));
            jTextField4.setText(mobile);

            String username = String.valueOf(jTable1.getValueAt(selectedRow, 5));
            jTextField9.setText(username);

            String password = String.valueOf(jTable1.getValueAt(selectedRow, 6));
            jPasswordField1.setText(password);

            String gender = String.valueOf(jTable1.getValueAt(selectedRow, 7));
            jComboBox1.setSelectedItem(gender);

            String district = String.valueOf(jTable1.getValueAt(selectedRow, 8));
            jComboBox2.setSelectedItem(district);

            String address = String.valueOf(jTable1.getValueAt(selectedRow, 9));
            jTextField6.setText(address);

            String street = String.valueOf(jTable1.getValueAt(selectedRow, 10));
            jTextField7.setText(street);

            String city = String.valueOf(jTable1.getValueAt(selectedRow, 11));
            jTextField8.setText(city);

            String subject = String.valueOf(jTable1.getValueAt(selectedRow, 12));
            jComboBox3.setSelectedItem(subject);

        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        // TODO add your handling code here:
        jPasswordField1.setEchoChar('\u0000');
    }//GEN-LAST:event_jButton1MousePressed

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
        // TODO add your handling code here:        
        jPasswordField1.setEchoChar('\u25cf');
    }//GEN-LAST:event_jButton1MouseReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Update Teacher code here:
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showConfirmDialog(this, "Pleace Select Teacher", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            String id = String.valueOf(jTable1.getValueAt(selectedRow, 0));
            String frisName = jTextField1.getText();
            String lastName = jTextField2.getText();
            String nic = jTextField3.getText();
            String mobile = jTextField4.getText();
            String password = String.valueOf(jPasswordField1.getPassword());
            String gender = String.valueOf(jComboBox1.getSelectedItem());
            String district = String.valueOf(jComboBox2.getSelectedItem());
            String addressNo = jTextField6.getText();
            String street = jTextField7.getText();
            String city = jTextField8.getText();
            String username = jTextField9.getText();
            String subject = String.valueOf(jComboBox3.getSelectedItem());

            if (frisName.isEmpty()) {
                JOptionPane.showConfirmDialog(this, "Enter First Name", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (lastName.isEmpty()) {
                JOptionPane.showConfirmDialog(this, "Enter Last Name", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (nic.isEmpty()) {
                JOptionPane.showConfirmDialog(this, "Enter NIC", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (mobile.isEmpty()) {
                JOptionPane.showConfirmDialog(this, "Enter Mobile", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (username.isEmpty()) {
                JOptionPane.showConfirmDialog(this, "Enter userName", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (password.isEmpty()) {
                JOptionPane.showConfirmDialog(this, "Enter password", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (district.equals("Select")) {
                JOptionPane.showConfirmDialog(this, "Choos Distric", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (addressNo.isEmpty()) {
                JOptionPane.showConfirmDialog(this, "Enter Address No", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (street.isEmpty()) {
                JOptionPane.showConfirmDialog(this, "Enter Street", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (city.isEmpty()) {
                JOptionPane.showConfirmDialog(this, "Enter City", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (subject.isEmpty()) {
                JOptionPane.showConfirmDialog(this, "Choos subject", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (gender.equals("Selcet")) {
                JOptionPane.showConfirmDialog(this, "Choos Gender", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (!mobile.matches(regex)) {
                JOptionPane.showConfirmDialog(this, "Entre Valide Mobile", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    int genderId = genHashMap.get(gender);
                    int districtId = destrictMap.get(district);
                    int subjectId = subjectMap.get(subject);
                    MySQL.execute("UPDATE `teacher` SET "
                            + "`frist_name`='" + frisName + "',"
                            + "`last_name`='" + lastName + "',"
                            + "`nic_number`='" + nic + "',"
                            + "`mobile`='" + mobile + "',"
                            + "`user_name`='" + username + "',"
                            + "`password`='" + password + "',"
                            + "`district_id`='" + districtId + "',"
                            + "`address_no`='" + addressNo + "',"
                            + "`street`='" + street + "',"
                            + "`city`='" + city + "',"
                            + "`gender_id`='" + genderId + "',"
                            + "`subject_id`='" + subjectId + "'"
                            + "WHERE `id`='" + id + "'");

                    JOptionPane.showConfirmDialog(this, "Success", "Success", JOptionPane.PLAIN_MESSAGE);
                    reset();
                    loadTeacher();
                    loadComboBox();
                    jButton2.setEnabled(true);
                    jTable1.setEnabled(true);
                    jButton5.setEnabled(true);
                    jTextField5.setEnabled(true);

                } catch (Exception e) {
                }
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Delete teacher code here:
        int selectedRow = jTable1.getSelectedRow();
        jButton2.setEnabled(true);
        jTable1.setEnabled(true);
        jButton5.setEnabled(true);
        jTable1.setEnabled(true);
        jTextField1.grabFocus();
        reset();
        if (selectedRow == -1) {
            JOptionPane.showConfirmDialog(this, "Pleace Select Teacher", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            String id = String.valueOf(jTable1.getValueAt(selectedRow, 0));
            try {
                MySQL.execute("DELETE FROM `teacher` WHERE `id`='" + id + "'");
                JOptionPane.showConfirmDialog(this, "Teacher Account Deleted Success ", "Infromations", JOptionPane.PLAIN_MESSAGE);
                jButton2.setEnabled(true);
                jTable1.setEnabled(true);
                jButton5.setEnabled(true);
                jTable1.setEnabled(true);
                jTextField1.grabFocus();
                reset();
                loadTeacher();
                loadComboBox();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here
        this.setVisible(false);
        Home home = new Home();
        home.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // Search teacher code here:
        String id = jTextField5.getText();

        try {
            ResultSet resultSet = MySQL.execute("SELECT * FROM `teacher`\n"
                    + "INNER JOIN `district` ON `teacher`.district_id = `district`.id\n"
                    + "INNER JOIN `subject` ON `teacher`.subject_id = `subject`.id\n"
                    + "INNER JOIN `gender` ON `teacher`.gender_id = `gender`.id WHERE teacher.id='" + id + "' ");
            if (resultSet.next()) {
                DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
                tableModel.setRowCount(0);

                Vector<String> v = new Vector();
                v.add(resultSet.getString("teacher.id"));
                v.add(resultSet.getString("frist_name"));
                v.add(resultSet.getString("last_name"));
                v.add(resultSet.getString("nic_number"));
                v.add(resultSet.getString("mobile"));
                v.add(resultSet.getString("user_name"));
                v.add(resultSet.getString("password"));
                v.add(resultSet.getString("gender.gender"));
                v.add(resultSet.getString("district.name"));
                v.add(resultSet.getString("address_no"));
                v.add(resultSet.getString("street"));
                v.add(resultSet.getString("city"));
                v.add(resultSet.getString("subject.subject_name"));

                tableModel.addRow(v);
                jTable1.setModel(tableModel);
            } else {
                JOptionPane.showConfirmDialog(this, "Invalid ID Number", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        reset();
        loadComboBox();
        loadTeacher();
        jButton2.setEnabled(true);
        jTable1.setEnabled(true);
        jButton5.setEnabled(true);
        jTable1.setEnabled(true);
        jTextField5.setEnabled(true);
        jTextField1.grabFocus();
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
            java.util.logging.Logger.getLogger(TeacherDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeacherDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeacherDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeacherDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeacherDetails().setVisible(true);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
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
