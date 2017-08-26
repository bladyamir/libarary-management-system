
package pages;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import librarymanagementsystem.Base64Converter;

import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import static pages.LoginWindow.logged_in_admin;


public class LibrarySystem extends javax.swing.JFrame {

 
    AboutUs aboutus = new AboutUs();

   
    static private Connection con;
    static private Statement stmt;
    static int available_cpy_bef = 0, all_cpy_bef = 0;

    JFileChooser fr = new JFileChooser();
    FileSystemView fw = fr.getFileSystemView();
//    Base64Converter base64 = new Base64Converter();
   
    public LibrarySystem() {
        initComponents();
        Establish_connection_to_db();
        refresh_all_tables();
    }

    public final void refresh_all_tables() {
        member_display_table();
        member_borrow_table();
        member_over_due_table();
        book_display_table();
        book_popular_table();
        admin_loggedin_label();
    }

   
    @SuppressWarnings("unchecked")
 
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        main_panel = new javax.swing.JPanel();
        main_tab = new javax.swing.JTabbedPane();
        book_panel = new javax.swing.JPanel();
        book_tab_panel = new javax.swing.JTabbedPane();
        display_tab = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        bk_display_table = new javax.swing.JTable();
        bk_display_refresh_btn = new javax.swing.JButton();
        bk_display_save_btn = new javax.swing.JButton();
        insert_book_tab = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        bk_title_txt = new javax.swing.JTextField();
        bk_author_txt = new javax.swing.JTextField();
        bk_publisher_txt = new javax.swing.JTextField();
        bk_category_txt = new javax.swing.JTextField();
        bk_ISBN_txt = new javax.swing.JTextField();
        bk_edition_txt = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        bk_allcopies_txt = new javax.swing.JTextField();
        bk_clear_btn = new javax.swing.JButton();
        bk_insert_btn = new javax.swing.JButton();
        update_tab = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        bk_update_id_txt = new javax.swing.JTextField();
        bk_editinfo_btn = new javax.swing.JButton();
        bk_update_btn = new javax.swing.JButton();
        up_cancel_btn = new javax.swing.JButton();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        bk_up_panel = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        bk_up_title_txt = new javax.swing.JTextField();
        bk_up_publisher_txt = new javax.swing.JTextField();
        bk_up_author_txt = new javax.swing.JTextField();
        bk_up_ISBN_txt = new javax.swing.JTextField();
        bk_up_category_txt = new javax.swing.JTextField();
        bk_up_edition_txt = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        bk_up_numofcopy_txt = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        search_tab = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel13 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        bk_srch_id_txt = new javax.swing.JTextField();
        bk_srch_id_btn = new javax.swing.JButton();
        bk_srch_id_chk = new javax.swing.JCheckBox();
        jPanel14 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        bk_srch_title_txt = new javax.swing.JTextField();
        bk_srch_title_btn = new javax.swing.JButton();
        bk_srch_title_chk = new javax.swing.JCheckBox();
        jPanel15 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        bk_srch_author_txt = new javax.swing.JTextField();
        bk_srch_author_btn = new javax.swing.JButton();
        bk_srch_author_chk = new javax.swing.JCheckBox();
        jPanel16 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        bk_srch_publisher_txt = new javax.swing.JTextField();
        bk_srch_publisher_btn = new javax.swing.JButton();
        bk_srch_publisher_chk = new javax.swing.JCheckBox();
        jPanel17 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        bk_srch_category_txt = new javax.swing.JTextField();
        bk_srch_category_btn = new javax.swing.JButton();
        bk_srch_category_chk = new javax.swing.JCheckBox();
        jPanel19 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        bk_srch_brw_btn = new javax.swing.JButton();
        bk_srch_brw_txt = new com.toedter.calendar.JDateChooser();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bk_srch_table = new javax.swing.JTable();
        jLabel44 = new javax.swing.JLabel();
        delete_tab = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        bk_del_id_txt = new javax.swing.JTextField();
        bk_del_load_btn = new javax.swing.JButton();
        bk_del_del_btn = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        bk_del_list = new javax.swing.JList<>();
        bk_del_lbl = new javax.swing.JLabel();
        bk_del_cancel_btn = new javax.swing.JButton();
        popular_books_tab = new javax.swing.JPanel();
        bk_pop_refresh_btn = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        bk_pop_display_table = new javax.swing.JTable();
        bk_pop_save_btn = new javax.swing.JButton();
        member_panel = new javax.swing.JPanel();
        member_tab_panel = new javax.swing.JTabbedPane();
        display_mem_panel = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        mem_display_table = new javax.swing.JTable();
        jLabel54 = new javax.swing.JLabel();
        mem_display_refresh_btn = new javax.swing.JButton();
        mem_display_save_btn = new javax.swing.JButton();
        register_mem_tab = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        mem_reg_str_txt = new javax.swing.JTextField();
        mem_reg_city_txt = new javax.swing.JTextField();
        mem_reg_add_txt = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        mem_reg_phn_txt = new javax.swing.JTextField();
        mem_reg_email_txt = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        mem_reg_id_txt = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        mem_reg_NIC_txt = new javax.swing.JTextField();
        mem_reg_age_txt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        mem_reg_fname_txt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        mem_reg_lname_txt = new javax.swing.JTextField();
        mem_reg_reg_btn = new javax.swing.JButton();
        mem_reg_clear_btn = new javax.swing.JButton();
        update_mem_tab = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        mem_up_id_txt = new javax.swing.JTextField();
        mem_up_edit_btn = new javax.swing.JButton();
        mem_up_update_btn = new javax.swing.JButton();
        mem_up_cancel_btn = new javax.swing.JButton();
        up_info_tab = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        mem_up_fname_txt = new javax.swing.JTextField();
        mem_up_lname_txt = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        mem_up_add_txt = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        mem_up_city_txt = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        mem_up_str_txt = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        mem_up_phone_txt = new javax.swing.JTextField();
        mem_up_email_txt = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        mem_up_NIC_txt = new javax.swing.JTextField();
        mem_up_age_txt = new javax.swing.JTextField();
        remove_mem_tab = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        mem_rmv_id_txt = new javax.swing.JTextField();
        mem_rmv_load_btn = new javax.swing.JButton();
        mem_rmv_rmv_btn = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        mem_rmv_list = new javax.swing.JList<>();
        mem_rmv_lbl = new javax.swing.JLabel();
        mem_rmv_cancel_btn = new javax.swing.JButton();
        borrow_tab = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        mem_brw_memid_txt = new javax.swing.JTextField();
        mem_brw_bkid_txt = new javax.swing.JTextField();
        mem_brw_brwdate = new com.toedter.calendar.JDateChooser();
        mem_brw_duedate = new com.toedter.calendar.JDateChooser();
        mem_brw_brw_btn = new javax.swing.JButton();
        mem_brw_cancel_btn = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        brw_display_table = new javax.swing.JTable();
        jLabel53 = new javax.swing.JLabel();
        brw_refresh_btn = new javax.swing.JButton();
        brw_save_btn = new javax.swing.JButton();
        return_tab = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        mem_ret_id_txt = new javax.swing.JTextField();
        mem_ret_rmv_btn = new javax.swing.JButton();
        mem_ret_load_btn = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        mem_ret_list = new javax.swing.JList<>();
        mem_ret_lbl = new javax.swing.JLabel();
        mem_ret_cancel_btn = new javax.swing.JButton();
        due_books = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        mem_due_display_table = new javax.swing.JTable();
        mem_due_refresh_btn = new javax.swing.JButton();
        mem_due_save_btn = new javax.swing.JButton();
        admin_panel = new javax.swing.JPanel();
        admin_tab_panel = new javax.swing.JTabbedPane();
        name_tab = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        admin_up_fname_txt = new javax.swing.JTextField();
        admin_up_lname_txt = new javax.swing.JTextField();
        admin_reg_log_lbl = new javax.swing.JLabel();
        admin_up_up_btn = new javax.swing.JButton();
        password_tab = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        admin_chng_npwd_txt = new javax.swing.JPasswordField();
        admin_chng_cpwd_txt = new javax.swing.JPasswordField();
        admin_chng_curpwd_txt = new javax.swing.JPasswordField();
        admin_chng_up_btn = new javax.swing.JButton();
        register_admin_tab = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        admin_reg_fname_txt = new javax.swing.JTextField();
        admin_reg_lname_txt = new javax.swing.JTextField();
        jPanel27 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        admin_reg_uname_txt = new javax.swing.JTextField();
        jPanel28 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        admin_reg_pwd_txt = new javax.swing.JPasswordField();
        admin_reg_cpwd_txt = new javax.swing.JPasswordField();
        admin_reg_clear_btn = new javax.swing.JButton();
        admin_reg_reg_btn = new javax.swing.JButton();
        main_menu_bar = new javax.swing.JMenuBar();
        file = new javax.swing.JMenu();
        logout_menu_item = new javax.swing.JMenuItem();
        exit_menu_item = new javax.swing.JMenuItem();
        about = new javax.swing.JMenu();
        help_menu_item = new javax.swing.JMenuItem();
        aboutus_menu_item = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName(""); 
        setResizable(false);

        book_tab_panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Book Management"));

        jLabel55.setText("All the Records of Books :");

        bk_display_table.setBackground(java.awt.SystemColor.inactiveCaption);
        bk_display_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Title", "Author", "Publisher", "Category", "ISBN", "Edition", "Available Copies", "Number of all Copies"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bk_display_table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        bk_display_table.setAutoscrolls(false);
        bk_display_table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane11.setViewportView(bk_display_table);

        bk_display_refresh_btn.setText("Refresh Records");
        bk_display_refresh_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bk_display_refresh_btnActionPerformed(evt);
            }
        });

        bk_display_save_btn.setText("Save Data to File");
        bk_display_save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bk_display_save_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout display_tabLayout = new javax.swing.GroupLayout(display_tab);
        display_tab.setLayout(display_tabLayout);
        display_tabLayout.setHorizontalGroup(
            display_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(display_tabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(display_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(display_tabLayout.createSequentialGroup()
                        .addComponent(jLabel55)
                        .addGap(0, 504, Short.MAX_VALUE))
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, display_tabLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bk_display_save_btn)
                        .addGap(18, 18, 18)
                        .addComponent(bk_display_refresh_btn)))
                .addContainerGap())
        );
        display_tabLayout.setVerticalGroup(
            display_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(display_tabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel55)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(display_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bk_display_refresh_btn)
                    .addComponent(bk_display_save_btn))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        book_tab_panel.addTab("Display", display_tab);

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Book Information"));

        jLabel21.setText("Title");

        jLabel22.setText("Author");

        jLabel23.setText("Publisher");

        jLabel24.setText("Category");

        jLabel25.setText("ISBN");

        jLabel26.setText("Edition");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel21)
                    .addComponent(jLabel23))
                .addGap(25, 25, 25)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bk_title_txt)
                            .addComponent(bk_ISBN_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                        .addGap(90, 90, 90)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel22)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bk_edition_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                            .addComponent(bk_category_txt)
                            .addComponent(bk_author_txt)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(bk_publisher_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 355, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(bk_title_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bk_author_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(bk_publisher_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(bk_category_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(bk_ISBN_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(bk_edition_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Available Copies"));

        jLabel28.setText("Number of All Copies");

        bk_allcopies_txt.setToolTipText("Only numbers allowed");
        bk_allcopies_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bk_allcopies_txtKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addGap(55, 55, 55)
                .addComponent(bk_allcopies_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bk_allcopies_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bk_clear_btn.setText("Clear Fields");
        bk_clear_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bk_clear_btnActionPerformed(evt);
            }
        });

        bk_insert_btn.setText("Insert Book");
        bk_insert_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bk_insert_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout insert_book_tabLayout = new javax.swing.GroupLayout(insert_book_tab);
        insert_book_tab.setLayout(insert_book_tabLayout);
        insert_book_tabLayout.setHorizontalGroup(
            insert_book_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(insert_book_tabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(insert_book_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, insert_book_tabLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bk_insert_btn)
                        .addGap(18, 18, 18)
                        .addComponent(bk_clear_btn)))
                .addContainerGap())
        );
        insert_book_tabLayout.setVerticalGroup(
            insert_book_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(insert_book_tabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(insert_book_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bk_clear_btn)
                    .addComponent(bk_insert_btn))
                .addContainerGap(241, Short.MAX_VALUE))
        );

        book_tab_panel.addTab("Insert Book", insert_book_tab);

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder("Book ID"));

        jLabel35.setText("ID");

        bk_update_id_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bk_update_id_txtKeyTyped(evt);
            }
        });

        bk_editinfo_btn.setText("Edit Information");
        bk_editinfo_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bk_editinfo_btnActionPerformed(evt);
            }
        });

        bk_update_btn.setText("Update");
        bk_update_btn.setEnabled(false);
        bk_update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bk_update_btnActionPerformed(evt);
            }
        });

        up_cancel_btn.setText("Cancel");
        up_cancel_btn.setEnabled(false);
        up_cancel_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                up_cancel_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35)
                .addGap(66, 66, 66)
                .addComponent(bk_update_id_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bk_editinfo_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bk_update_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(up_cancel_btn)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(bk_update_id_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bk_editinfo_btn)
                    .addComponent(bk_update_btn)
                    .addComponent(up_cancel_btn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.setBorder(javax.swing.BorderFactory.createTitledBorder("Update Book Information"));
        jTabbedPane3.setEnabled(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTabbedPane3, org.jdesktop.beansbinding.ELProperty.create("${enabled}"), bk_up_panel, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jLabel36.setText("Title");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, bk_up_panel, org.jdesktop.beansbinding.ELProperty.create("${enabled}"), jLabel36, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jLabel37.setText("Author");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, bk_up_panel, org.jdesktop.beansbinding.ELProperty.create("${enabled}"), jLabel37, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jLabel38.setText("Publisher");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, bk_up_panel, org.jdesktop.beansbinding.ELProperty.create("${enabled}"), jLabel38, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jLabel39.setText("Category");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, bk_up_panel, org.jdesktop.beansbinding.ELProperty.create("${enabled}"), jLabel39, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jLabel40.setText("ISBN");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, bk_up_panel, org.jdesktop.beansbinding.ELProperty.create("${enabled}"), jLabel40, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jLabel41.setText("Edition");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, bk_up_panel, org.jdesktop.beansbinding.ELProperty.create("${enabled}"), jLabel41, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, bk_up_panel, org.jdesktop.beansbinding.ELProperty.create("${enabled}"), bk_up_title_txt, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, bk_up_panel, org.jdesktop.beansbinding.ELProperty.create("${enabled}"), bk_up_publisher_txt, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, bk_up_panel, org.jdesktop.beansbinding.ELProperty.create("${enabled}"), bk_up_author_txt, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, bk_up_panel, org.jdesktop.beansbinding.ELProperty.create("${enabled}"), bk_up_ISBN_txt, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, bk_up_panel, org.jdesktop.beansbinding.ELProperty.create("${enabled}"), bk_up_category_txt, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, bk_up_panel, org.jdesktop.beansbinding.ELProperty.create("${enabled}"), bk_up_edition_txt, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout bk_up_panelLayout = new javax.swing.GroupLayout(bk_up_panel);
        bk_up_panel.setLayout(bk_up_panelLayout);
        bk_up_panelLayout.setHorizontalGroup(
            bk_up_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bk_up_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bk_up_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(jLabel36)
                    .addComponent(jLabel40))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(bk_up_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bk_up_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(bk_up_title_txt)
                        .addComponent(bk_up_publisher_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bk_up_ISBN_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(bk_up_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addComponent(jLabel39)
                    .addComponent(jLabel41))
                .addGap(57, 57, 57)
                .addGroup(bk_up_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bk_up_author_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bk_up_edition_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bk_up_category_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        bk_up_panelLayout.setVerticalGroup(
            bk_up_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bk_up_panelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(bk_up_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bk_up_panelLayout.createSequentialGroup()
                        .addComponent(bk_up_title_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bk_up_publisher_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bk_up_ISBN_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bk_up_panelLayout.createSequentialGroup()
                        .addGroup(bk_up_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(bk_up_author_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37))
                        .addGap(18, 18, 18)
                        .addGroup(bk_up_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bk_up_category_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38)
                            .addComponent(jLabel39))
                        .addGap(18, 18, 18)
                        .addGroup(bk_up_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40)
                            .addGroup(bk_up_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(bk_up_edition_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel41)))))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Book Information", bk_up_panel);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTabbedPane3, org.jdesktop.beansbinding.ELProperty.create("${enabled}"), jPanel20, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        bk_up_numofcopy_txt.setToolTipText("Only numbers allowed");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jPanel20, org.jdesktop.beansbinding.ELProperty.create("${enabled}"), bk_up_numofcopy_txt, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        bk_up_numofcopy_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bk_up_numofcopy_txtKeyTyped(evt);
            }
        });

        jLabel43.setText("Number of All Copies");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jPanel20, org.jdesktop.beansbinding.ELProperty.create("${enabled}"), jLabel43, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel43)
                .addGap(62, 62, 62)
                .addComponent(bk_up_numofcopy_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(361, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bk_up_numofcopy_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43))
                .addContainerGap(117, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Available Copies", jPanel20);

        javax.swing.GroupLayout update_tabLayout = new javax.swing.GroupLayout(update_tab);
        update_tab.setLayout(update_tabLayout);
        update_tabLayout.setHorizontalGroup(
            update_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(update_tabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(update_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        update_tabLayout.setVerticalGroup(
            update_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(update_tabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(220, Short.MAX_VALUE))
        );

        book_tab_panel.addTab("Update", update_tab);

        jTabbedPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Search Category"));

        jLabel30.setText("Enter a book ID");

        bk_srch_id_txt.setToolTipText("Only numbers allowed");
        bk_srch_id_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bk_srch_id_txtKeyTyped(evt);
            }
        });

        bk_srch_id_btn.setText("Search");
        bk_srch_id_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bk_srch_id_btnActionPerformed(evt);
            }
        });

        bk_srch_id_chk.setText("Whole ID");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(bk_srch_id_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bk_srch_id_chk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 266, Short.MAX_VALUE)
                        .addComponent(bk_srch_id_btn)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bk_srch_id_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bk_srch_id_btn)
                    .addComponent(bk_srch_id_chk))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Book ID", jPanel13);

        jLabel31.setText("Enter a title");

        bk_srch_title_btn.setText("Search");
        bk_srch_title_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bk_srch_title_btnActionPerformed(evt);
            }
        });

        bk_srch_title_chk.setText("Whole Word");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(bk_srch_title_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bk_srch_title_chk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 250, Short.MAX_VALUE)
                        .addComponent(bk_srch_title_btn)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bk_srch_title_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bk_srch_title_btn)
                    .addComponent(bk_srch_title_chk))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Title", jPanel14);

        jLabel32.setText("Enter a author");

        bk_srch_author_btn.setText("Search");
        bk_srch_author_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bk_srch_author_btnActionPerformed(evt);
            }
        });

        bk_srch_author_chk.setText("Whole Word");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(bk_srch_author_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bk_srch_author_chk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 250, Short.MAX_VALUE)
                        .addComponent(bk_srch_author_btn)))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bk_srch_author_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bk_srch_author_btn)
                    .addComponent(bk_srch_author_chk))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Author", jPanel15);

        jLabel33.setText("Enter a publisher");

        bk_srch_publisher_btn.setText("Search");
        bk_srch_publisher_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bk_srch_publisher_btnActionPerformed(evt);
            }
        });

        bk_srch_publisher_chk.setText("Whole Word");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(bk_srch_publisher_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bk_srch_publisher_chk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 250, Short.MAX_VALUE)
                        .addComponent(bk_srch_publisher_btn)))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bk_srch_publisher_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bk_srch_publisher_btn)
                    .addComponent(bk_srch_publisher_chk))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Publisher", jPanel16);

        jLabel34.setText("Enter a category");

        bk_srch_category_btn.setText("Search");
        bk_srch_category_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bk_srch_category_btnActionPerformed(evt);
            }
        });

        bk_srch_category_chk.setText("Whole Word");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addGap(0, 509, Short.MAX_VALUE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(bk_srch_category_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bk_srch_category_chk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bk_srch_category_btn)))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bk_srch_category_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bk_srch_category_btn)
                    .addComponent(bk_srch_category_chk))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Category", jPanel17);

        jLabel66.setText("Enter borrow date");

        bk_srch_brw_btn.setText("Search");
        bk_srch_brw_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bk_srch_brw_btnActionPerformed(evt);
            }
        });

        bk_srch_brw_txt.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel66)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(bk_srch_brw_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 353, Short.MAX_VALUE)
                        .addComponent(bk_srch_brw_btn)))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel66)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bk_srch_brw_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bk_srch_brw_btn))
                .addGap(20, 20, 20))
        );

        jTabbedPane2.addTab("Borrow Date", jPanel19);

        jLabel29.setText("You can search books by category. Simply select a category and click on seach.");

        bk_srch_table.setBackground(java.awt.SystemColor.inactiveCaption);
        bk_srch_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Title", "Author", "Publisher", "Category", "ISBN", "Edition", "Available Copies", "Number of all Copies"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bk_srch_table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        bk_srch_table.setAutoscrolls(false);
        jScrollPane1.setViewportView(bk_srch_table);

        jLabel44.setText("Search Result :");

        javax.swing.GroupLayout search_tabLayout = new javax.swing.GroupLayout(search_tab);
        search_tab.setLayout(search_tabLayout);
        search_tabLayout.setHorizontalGroup(
            search_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(search_tabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(search_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane2)
                    .addGroup(search_tabLayout.createSequentialGroup()
                        .addGroup(search_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(jLabel44))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        search_tabLayout.setVerticalGroup(
            search_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(search_tabLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel29)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(110, Short.MAX_VALUE))
        );

        book_tab_panel.addTab("Search", search_tab);

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder("Book ID"));

        jLabel45.setText("ID");

        bk_del_id_txt.setToolTipText("Only numbers allowed");
        bk_del_id_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bk_del_id_txtKeyTyped(evt);
            }
        });

        bk_del_load_btn.setText("Load");
        bk_del_load_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bk_del_load_btnActionPerformed(evt);
            }
        });

        bk_del_del_btn.setText("Delete Book");
        bk_del_del_btn.setEnabled(false);
        bk_del_del_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bk_del_del_btnActionPerformed(evt);
            }
        });

        bk_del_list.setEnabled(false);
        jScrollPane4.setViewportView(bk_del_list);

        bk_del_lbl.setText("This will permanantly delete the entire record of the book.");
        bk_del_lbl.setEnabled(false);

        bk_del_cancel_btn.setText("Cancel");
        bk_del_cancel_btn.setEnabled(false);
        bk_del_cancel_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bk_del_cancel_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addGap(66, 66, 66)
                        .addComponent(bk_del_id_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bk_del_load_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bk_del_del_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bk_del_cancel_btn))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bk_del_lbl)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 255, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(bk_del_id_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bk_del_load_btn)
                    .addComponent(bk_del_del_btn)
                    .addComponent(bk_del_cancel_btn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(bk_del_lbl)
                .addContainerGap())
        );

        javax.swing.GroupLayout delete_tabLayout = new javax.swing.GroupLayout(delete_tab);
        delete_tab.setLayout(delete_tabLayout);
        delete_tabLayout.setHorizontalGroup(
            delete_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(delete_tabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        delete_tabLayout.setVerticalGroup(
            delete_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(delete_tabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(188, Short.MAX_VALUE))
        );

        book_tab_panel.addTab("Delete", delete_tab);

        bk_pop_refresh_btn.setText("Refresh Records");
        bk_pop_refresh_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bk_pop_refresh_btnActionPerformed(evt);
            }
        });

        jLabel47.setText("All the Popular Books in Order of Lowering the Popularity :");

        bk_pop_display_table.setBackground(java.awt.SystemColor.inactiveCaption);
        bk_pop_display_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Title", "Author", "Publisher", "Number of all Copies"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(bk_pop_display_table);

        bk_pop_save_btn.setText("Save Data to File");
        bk_pop_save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bk_pop_save_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout popular_books_tabLayout = new javax.swing.GroupLayout(popular_books_tab);
        popular_books_tab.setLayout(popular_books_tabLayout);
        popular_books_tabLayout.setHorizontalGroup(
            popular_books_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(popular_books_tabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(popular_books_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                    .addGroup(popular_books_tabLayout.createSequentialGroup()
                        .addComponent(jLabel47)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, popular_books_tabLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bk_pop_save_btn)
                        .addGap(18, 18, 18)
                        .addComponent(bk_pop_refresh_btn)))
                .addContainerGap())
        );
        popular_books_tabLayout.setVerticalGroup(
            popular_books_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(popular_books_tabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(popular_books_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bk_pop_refresh_btn)
                    .addComponent(bk_pop_save_btn))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        book_tab_panel.addTab("Popular Books", popular_books_tab);

        javax.swing.GroupLayout book_panelLayout = new javax.swing.GroupLayout(book_panel);
        book_panel.setLayout(book_panelLayout);
        book_panelLayout.setHorizontalGroup(
            book_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(book_tab_panel)
        );
        book_panelLayout.setVerticalGroup(
            book_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(book_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(book_tab_panel))
        );

        main_tab.addTab("Book Management", book_panel);

        member_tab_panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Member Management"));

        mem_display_table.setBackground(java.awt.SystemColor.inactiveCaption);
        mem_display_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Member ID", "First Name", "Last Name", "Address", "City", "Street", "Phone", "E-Mail", "NIC", "Age", "Registered Date"
            }
        ));
        mem_display_table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane7.setViewportView(mem_display_table);

        jLabel54.setText("All the Records of Books :");

        mem_display_refresh_btn.setText("Refresh Records");
        mem_display_refresh_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mem_display_refresh_btnActionPerformed(evt);
            }
        });

        mem_display_save_btn.setText("Save Data to File");
        mem_display_save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mem_display_save_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout display_mem_panelLayout = new javax.swing.GroupLayout(display_mem_panel);
        display_mem_panel.setLayout(display_mem_panelLayout);
        display_mem_panelLayout.setHorizontalGroup(
            display_mem_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(display_mem_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(display_mem_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                    .addGroup(display_mem_panelLayout.createSequentialGroup()
                        .addComponent(jLabel54)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, display_mem_panelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(mem_display_save_btn)
                        .addGap(18, 18, 18)
                        .addComponent(mem_display_refresh_btn)))
                .addContainerGap())
        );
        display_mem_panelLayout.setVerticalGroup(
            display_mem_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(display_mem_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel54)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(display_mem_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mem_display_refresh_btn)
                    .addComponent(mem_display_save_btn))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        member_tab_panel.addTab("Display", display_mem_panel);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Address"));

        jLabel3.setText("Address");

        jLabel4.setText("City");

        jLabel5.setText("Street");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mem_reg_add_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(mem_reg_str_txt))
                .addGap(90, 90, 90)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mem_reg_city_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(mem_reg_add_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mem_reg_city_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(mem_reg_str_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Contact Information"));

        jLabel6.setText("Phone");

        jLabel8.setText("E-Mail");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(39, 39, 39)
                .addComponent(mem_reg_phn_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mem_reg_email_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(mem_reg_phn_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mem_reg_email_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Member ID"));

        jLabel9.setText("ID");

        mem_reg_id_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mem_reg_id_txtKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(66, 66, 66)
                .addComponent(mem_reg_id_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mem_reg_id_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Basic Information"));

        jLabel10.setText("Age");

        jLabel7.setText("NIC");

        mem_reg_age_txt.setToolTipText("Only numbers allowed");
        mem_reg_age_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mem_reg_age_txtKeyTyped(evt);
            }
        });

        jLabel1.setText("First Name");

        jLabel2.setText("Last Name");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mem_reg_fname_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mem_reg_NIC_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(mem_reg_lname_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mem_reg_age_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(mem_reg_fname_txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(mem_reg_lname_txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(mem_reg_NIC_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mem_reg_age_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addComponent(jLabel10))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        mem_reg_reg_btn.setText("Register Member");
        mem_reg_reg_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mem_reg_reg_btnActionPerformed(evt);
            }
        });

        mem_reg_clear_btn.setText("Clear Fields");
        mem_reg_clear_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mem_reg_clear_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout register_mem_tabLayout = new javax.swing.GroupLayout(register_mem_tab);
        register_mem_tab.setLayout(register_mem_tabLayout);
        register_mem_tabLayout.setHorizontalGroup(
            register_mem_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(register_mem_tabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(register_mem_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, register_mem_tabLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(mem_reg_reg_btn)
                        .addGap(18, 18, 18)
                        .addComponent(mem_reg_clear_btn)))
                .addContainerGap())
        );
        register_mem_tabLayout.setVerticalGroup(
            register_mem_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, register_mem_tabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(register_mem_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mem_reg_reg_btn)
                    .addComponent(mem_reg_clear_btn))
                .addContainerGap(146, Short.MAX_VALUE))
        );

        member_tab_panel.addTab("Register", register_mem_tab);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Member ID"));

        jLabel11.setText("ID");

        mem_up_id_txt.setToolTipText("Only numbers allowed");
        mem_up_id_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mem_up_id_txtKeyTyped(evt);
            }
        });

        mem_up_edit_btn.setText("Edit Information");
        mem_up_edit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mem_up_edit_btnActionPerformed(evt);
            }
        });

        mem_up_update_btn.setText("Update");
        mem_up_update_btn.setEnabled(false);
        mem_up_update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mem_up_update_btnActionPerformed(evt);
            }
        });

        mem_up_cancel_btn.setText("Cancel");
        mem_up_cancel_btn.setEnabled(false);
        mem_up_cancel_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mem_up_cancel_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(66, 66, 66)
                .addComponent(mem_up_id_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mem_up_edit_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mem_up_update_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mem_up_cancel_btn)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(mem_up_id_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mem_up_edit_btn)
                    .addComponent(mem_up_update_btn)
                    .addComponent(mem_up_cancel_btn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        up_info_tab.setBorder(javax.swing.BorderFactory.createTitledBorder("Update Registered Member Information"));
        up_info_tab.setEnabled(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, up_info_tab, org.jdesktop.beansbinding.ELProperty.create("${enabled}"), jPanel7, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jLabel12.setText("First Name");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jPanel7, org.jdesktop.beansbinding.ELProperty.create("${enabled}"), jLabel12, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jLabel13.setText("Last Name");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jPanel7, org.jdesktop.beansbinding.ELProperty.create("${enabled}"), jLabel13, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jPanel7, org.jdesktop.beansbinding.ELProperty.create("${enabled}"), mem_up_fname_txt, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jPanel7, org.jdesktop.beansbinding.ELProperty.create("${enabled}"), mem_up_lname_txt, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(46, 46, 46)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mem_up_fname_txt)
                    .addComponent(mem_up_lname_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(331, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(mem_up_fname_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(mem_up_lname_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        up_info_tab.addTab("Update Name", jPanel7);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, up_info_tab, org.jdesktop.beansbinding.ELProperty.create("${enabled}"), jPanel8, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jLabel14.setText("Address");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jPanel8, org.jdesktop.beansbinding.ELProperty.create("${enabled}"), jLabel14, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jPanel8, org.jdesktop.beansbinding.ELProperty.create("${enabled}"), mem_up_add_txt, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jLabel15.setText("City");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jPanel8, org.jdesktop.beansbinding.ELProperty.create("${enabled}"), jLabel15, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jPanel8, org.jdesktop.beansbinding.ELProperty.create("${enabled}"), mem_up_city_txt, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jLabel16.setText("Street");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jPanel8, org.jdesktop.beansbinding.ELProperty.create("${enabled}"), jLabel16, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jPanel8, org.jdesktop.beansbinding.ELProperty.create("${enabled}"), mem_up_str_txt, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGap(61, 61, 61)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mem_up_city_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mem_up_add_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mem_up_str_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(328, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(mem_up_add_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(mem_up_city_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(mem_up_str_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        up_info_tab.addTab("Update Address", jPanel8);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, up_info_tab, org.jdesktop.beansbinding.ELProperty.create("${enabled}"), jPanel9, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jLabel17.setText("Phone");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jPanel9, org.jdesktop.beansbinding.ELProperty.create("${enabled}"), jLabel17, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jLabel18.setText("E-Mail");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jPanel9, org.jdesktop.beansbinding.ELProperty.create("${enabled}"), jLabel18, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jPanel9, org.jdesktop.beansbinding.ELProperty.create("${enabled}"), mem_up_phone_txt, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jPanel9, org.jdesktop.beansbinding.ELProperty.create("${enabled}"), mem_up_email_txt, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addGap(71, 71, 71)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mem_up_phone_txt)
                    .addComponent(mem_up_email_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(327, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(mem_up_phone_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mem_up_email_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        up_info_tab.addTab("Update Contatct Information", jPanel9);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, up_info_tab, org.jdesktop.beansbinding.ELProperty.create("${enabled}"), jPanel10, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jLabel19.setText("NIC");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jPanel10, org.jdesktop.beansbinding.ELProperty.create("${enabled}"), jLabel19, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jLabel20.setText("Age");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jPanel10, org.jdesktop.beansbinding.ELProperty.create("${enabled}"), jLabel20, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jPanel10, org.jdesktop.beansbinding.ELProperty.create("${enabled}"), mem_up_NIC_txt, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        mem_up_age_txt.setToolTipText("Only numbers allowed");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jPanel10, org.jdesktop.beansbinding.ELProperty.create("${enabled}"), mem_up_age_txt, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        mem_up_age_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mem_up_age_txtKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20))
                .addGap(86, 86, 86)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mem_up_age_txt)
                    .addComponent(mem_up_NIC_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(323, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(mem_up_NIC_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(mem_up_age_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        up_info_tab.addTab("Update Basic Information", jPanel10);

        javax.swing.GroupLayout update_mem_tabLayout = new javax.swing.GroupLayout(update_mem_tab);
        update_mem_tab.setLayout(update_mem_tabLayout);
        update_mem_tabLayout.setHorizontalGroup(
            update_mem_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(update_mem_tabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(update_mem_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(up_info_tab))
                .addContainerGap())
        );
        update_mem_tabLayout.setVerticalGroup(
            update_mem_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(update_mem_tabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(up_info_tab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(218, Short.MAX_VALUE))
        );

        member_tab_panel.addTab("Update", update_mem_tab);

        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder("Member ID"));
        jPanel22.setPreferredSize(new java.awt.Dimension(559, 300));

        jLabel46.setText("ID");

        mem_rmv_id_txt.setToolTipText("Only numbers allowed");
        mem_rmv_id_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mem_rmv_id_txtKeyTyped(evt);
            }
        });

        mem_rmv_load_btn.setText("Load");
        mem_rmv_load_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mem_rmv_load_btnActionPerformed(evt);
            }
        });

        mem_rmv_rmv_btn.setText("Remove Member");
        mem_rmv_rmv_btn.setEnabled(false);
        mem_rmv_rmv_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mem_rmv_rmv_btnActionPerformed(evt);
            }
        });

        mem_rmv_list.setEnabled(false);
        jScrollPane6.setViewportView(mem_rmv_list);

        mem_rmv_lbl.setText("This will permantly remove the record of the member.");
        mem_rmv_lbl.setEnabled(false);

        mem_rmv_cancel_btn.setText("Cancel");
        mem_rmv_cancel_btn.setEnabled(false);
        mem_rmv_cancel_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mem_rmv_cancel_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addGap(66, 66, 66)
                        .addComponent(mem_rmv_id_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                        .addComponent(mem_rmv_load_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mem_rmv_rmv_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mem_rmv_cancel_btn))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mem_rmv_lbl)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(mem_rmv_id_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mem_rmv_load_btn)
                    .addComponent(mem_rmv_rmv_btn)
                    .addComponent(mem_rmv_cancel_btn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(mem_rmv_lbl)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout remove_mem_tabLayout = new javax.swing.GroupLayout(remove_mem_tab);
        remove_mem_tab.setLayout(remove_mem_tabLayout);
        remove_mem_tabLayout.setHorizontalGroup(
            remove_mem_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(remove_mem_tabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                .addContainerGap())
        );
        remove_mem_tabLayout.setVerticalGroup(
            remove_mem_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(remove_mem_tabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        member_tab_panel.addTab("Remove", remove_mem_tab);

        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder("Books Borrowing Information"));

        jLabel49.setText("Member ID");

        jLabel50.setText("Book ID");

        jLabel51.setText("Borrow Date");

        jLabel52.setText("Due Date");

        mem_brw_memid_txt.setToolTipText("Only numbers allowed");
        mem_brw_memid_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mem_brw_memid_txtKeyTyped(evt);
            }
        });

        mem_brw_bkid_txt.setToolTipText("Only numbers allowed");
        mem_brw_bkid_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mem_brw_bkid_txtKeyTyped(evt);
            }
        });

        mem_brw_brwdate.setDateFormatString("yyyy-MM-dd");
        mem_brw_brwdate.setMinSelectableDate(new Date());

        mem_brw_duedate.setDateFormatString("yyyy-MM-dd");
        mem_brw_duedate.setMaxSelectableDate(new java.util.Date(253370748690000L));
        mem_brw_duedate.setMinSelectableDate(new Date());

        mem_brw_brw_btn.setText("Borrow");
        mem_brw_brw_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mem_brw_brw_btnActionPerformed(evt);
            }
        });

        mem_brw_cancel_btn.setText("Cancel");
        mem_brw_cancel_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mem_brw_cancel_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel51)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mem_brw_brwdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel49)
                        .addGap(18, 18, 18)
                        .addComponent(mem_brw_memid_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel50)
                    .addComponent(jLabel52))
                .addGap(38, 38, 38)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                        .addComponent(mem_brw_brw_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mem_brw_cancel_btn))
                    .addComponent(mem_brw_bkid_txt)
                    .addComponent(mem_brw_duedate, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(jLabel50)
                    .addComponent(mem_brw_memid_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mem_brw_bkid_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mem_brw_brwdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51)
                    .addComponent(jLabel52)
                    .addComponent(mem_brw_duedate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mem_brw_brw_btn)
                    .addComponent(mem_brw_cancel_btn))
                .addContainerGap())
        );

        brw_display_table.setBackground(java.awt.SystemColor.inactiveCaption);
        brw_display_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Transaction ID", "Member ID", "Book ID", "Borrow Date", "Due Date"
            }
        ));
        jScrollPane8.setViewportView(brw_display_table);

        jLabel53.setText("Books Borrow Records :");

        brw_refresh_btn.setText("Refresh Records");
        brw_refresh_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brw_refresh_btnActionPerformed(evt);
            }
        });

        brw_save_btn.setText("Save Data to File");
        brw_save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brw_save_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout borrow_tabLayout = new javax.swing.GroupLayout(borrow_tab);
        borrow_tab.setLayout(borrow_tabLayout);
        borrow_tabLayout.setHorizontalGroup(
            borrow_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(borrow_tabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(borrow_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(borrow_tabLayout.createSequentialGroup()
                        .addComponent(jLabel53)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, borrow_tabLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(brw_save_btn)
                        .addGap(18, 18, 18)
                        .addComponent(brw_refresh_btn)))
                .addContainerGap())
        );
        borrow_tabLayout.setVerticalGroup(
            borrow_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(borrow_tabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel53)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(borrow_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(brw_refresh_btn)
                    .addComponent(brw_save_btn))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        member_tab_panel.addTab("Borrow a Book", borrow_tab);

        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder("Return a Book"));

        jLabel27.setText("Transacton ID");

        mem_ret_id_txt.setToolTipText("Only numbers allowed");
        mem_ret_id_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mem_ret_id_txtKeyTyped(evt);
            }
        });

        mem_ret_rmv_btn.setText("Remove Borrow Information");
        mem_ret_rmv_btn.setEnabled(false);
        mem_ret_rmv_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mem_ret_rmv_btnActionPerformed(evt);
            }
        });

        mem_ret_load_btn.setText("Load");
        mem_ret_load_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mem_ret_load_btnActionPerformed(evt);
            }
        });

        mem_ret_list.setEnabled(false);
        jScrollPane10.setViewportView(mem_ret_list);

        mem_ret_lbl.setText("This will remove the all the details of borrowing-book-record of the transaction ID above.");
        mem_ret_lbl.setEnabled(false);

        mem_ret_cancel_btn.setText("Cancel");
        mem_ret_cancel_btn.setEnabled(false);
        mem_ret_cancel_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mem_ret_cancel_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(95, 95, 95)
                        .addComponent(mem_ret_id_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(mem_ret_load_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mem_ret_rmv_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mem_ret_cancel_btn))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mem_ret_lbl)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mem_ret_id_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(mem_ret_rmv_btn)
                    .addComponent(mem_ret_load_btn)
                    .addComponent(mem_ret_cancel_btn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(mem_ret_lbl)
                .addContainerGap())
        );

        javax.swing.GroupLayout return_tabLayout = new javax.swing.GroupLayout(return_tab);
        return_tab.setLayout(return_tabLayout);
        return_tabLayout.setHorizontalGroup(
            return_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(return_tabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        return_tabLayout.setVerticalGroup(
            return_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(return_tabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(188, Short.MAX_VALUE))
        );

        member_tab_panel.addTab("Return a Book", return_tab);

        jLabel42.setText("All the Over Due Books Records :");

        mem_due_display_table.setBackground(java.awt.SystemColor.inactiveCaption);
        mem_due_display_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Transaction ID", "Member ID", "Book ID", "Borrow Date", "Due Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(mem_due_display_table);

        mem_due_refresh_btn.setText("Refresh Records");
        mem_due_refresh_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mem_due_refresh_btnActionPerformed(evt);
            }
        });

        mem_due_save_btn.setText("Save Data to File");
        mem_due_save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mem_due_save_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout due_booksLayout = new javax.swing.GroupLayout(due_books);
        due_books.setLayout(due_booksLayout);
        due_booksLayout.setHorizontalGroup(
            due_booksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(due_booksLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(due_booksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(due_booksLayout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, due_booksLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(mem_due_save_btn)
                        .addGap(18, 18, 18)
                        .addComponent(mem_due_refresh_btn)))
                .addContainerGap())
        );
        due_booksLayout.setVerticalGroup(
            due_booksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(due_booksLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(due_booksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mem_due_refresh_btn)
                    .addComponent(mem_due_save_btn))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        member_tab_panel.addTab("Over Due Books", due_books);

        javax.swing.GroupLayout member_panelLayout = new javax.swing.GroupLayout(member_panel);
        member_panel.setLayout(member_panelLayout);
        member_panelLayout.setHorizontalGroup(
            member_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(member_tab_panel)
        );
        member_panelLayout.setVerticalGroup(
            member_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(member_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(member_tab_panel))
        );

        main_tab.addTab("Member Management", member_panel);

        admin_tab_panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Administrator Management"));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Update Name"));

        jLabel48.setText("First Name");

        jLabel64.setText("Last Name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel48)
                .addGap(18, 18, 18)
                .addComponent(admin_up_fname_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(jLabel64)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(admin_up_lname_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(jLabel64)
                    .addComponent(admin_up_fname_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(admin_up_lname_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        admin_reg_log_lbl.setText("You are logged in as ");

        admin_up_up_btn.setText("Update Name");
        admin_up_up_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_up_up_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout name_tabLayout = new javax.swing.GroupLayout(name_tab);
        name_tab.setLayout(name_tabLayout);
        name_tabLayout.setHorizontalGroup(
            name_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(name_tabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(name_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, name_tabLayout.createSequentialGroup()
                        .addComponent(admin_reg_log_lbl)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, name_tabLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(admin_up_up_btn)))
                .addContainerGap())
        );
        name_tabLayout.setVerticalGroup(
            name_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(name_tabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(admin_reg_log_lbl)
                .addGap(17, 17, 17)
                .addComponent(admin_up_up_btn)
                .addContainerGap(368, Short.MAX_VALUE))
        );

        admin_tab_panel.addTab("Update Name", name_tab);

        jPanel29.setBorder(javax.swing.BorderFactory.createTitledBorder("Change Password"));

        jLabel61.setText("Current Password");

        jLabel62.setText("New Password");

        jLabel63.setText("Confirm Password");

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel62)
                    .addComponent(jLabel61))
                .addGap(18, 18, 18)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(admin_chng_curpwd_txt)
                    .addComponent(admin_chng_npwd_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(jLabel63)
                .addGap(18, 18, 18)
                .addComponent(admin_chng_cpwd_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(admin_chng_curpwd_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(admin_chng_npwd_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63)
                    .addComponent(admin_chng_cpwd_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        admin_chng_up_btn.setText("Update Password");
        admin_chng_up_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_chng_up_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout password_tabLayout = new javax.swing.GroupLayout(password_tab);
        password_tab.setLayout(password_tabLayout);
        password_tabLayout.setHorizontalGroup(
            password_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(password_tabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(password_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, password_tabLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(admin_chng_up_btn)))
                .addContainerGap())
        );
        password_tabLayout.setVerticalGroup(
            password_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(password_tabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(admin_chng_up_btn)
                .addContainerGap(356, Short.MAX_VALUE))
        );

        admin_tab_panel.addTab("Change Password", password_tab);

        jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder("Name"));

        jLabel56.setText("First Name");

        jLabel57.setText("Last Name");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel56)
                .addGap(18, 18, 18)
                .addComponent(admin_reg_fname_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(jLabel57)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(admin_reg_lname_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(jLabel57)
                    .addComponent(admin_reg_fname_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(admin_reg_lname_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder("Username"));

        jLabel58.setText("Username");

        admin_reg_uname_txt.setToolTipText("White spaces are not allowed");
        admin_reg_uname_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                admin_reg_uname_txtKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel58)
                .addGap(21, 21, 21)
                .addComponent(admin_reg_uname_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(admin_reg_uname_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder("Password"));

        jLabel59.setText("New Password");

        jLabel60.setText("Confirm Password");

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel59)
                .addGap(18, 18, 18)
                .addComponent(admin_reg_pwd_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(jLabel60)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(admin_reg_cpwd_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(jLabel60)
                    .addComponent(admin_reg_pwd_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(admin_reg_cpwd_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        admin_reg_clear_btn.setText("Clear Fields");
        admin_reg_clear_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_reg_clear_btnActionPerformed(evt);
            }
        });

        admin_reg_reg_btn.setText("Register Admin");
        admin_reg_reg_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_reg_reg_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout register_admin_tabLayout = new javax.swing.GroupLayout(register_admin_tab);
        register_admin_tab.setLayout(register_admin_tabLayout);
        register_admin_tabLayout.setHorizontalGroup(
            register_admin_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(register_admin_tabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(register_admin_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, register_admin_tabLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(admin_reg_reg_btn)
                        .addGap(18, 18, 18)
                        .addComponent(admin_reg_clear_btn)))
                .addContainerGap())
        );
        register_admin_tabLayout.setVerticalGroup(
            register_admin_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(register_admin_tabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(register_admin_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(admin_reg_clear_btn)
                    .addComponent(admin_reg_reg_btn))
                .addContainerGap(213, Short.MAX_VALUE))
        );

        admin_tab_panel.addTab("Register Admin", register_admin_tab);

        javax.swing.GroupLayout admin_panelLayout = new javax.swing.GroupLayout(admin_panel);
        admin_panel.setLayout(admin_panelLayout);
        admin_panelLayout.setHorizontalGroup(
            admin_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(admin_tab_panel)
        );
        admin_panelLayout.setVerticalGroup(
            admin_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(admin_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(admin_tab_panel))
        );

        main_tab.addTab("Administrator Management", admin_panel);

        javax.swing.GroupLayout main_panelLayout = new javax.swing.GroupLayout(main_panel);
        main_panel.setLayout(main_panelLayout);
        main_panelLayout.setHorizontalGroup(
            main_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main_tab)
        );
        main_panelLayout.setVerticalGroup(
            main_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main_tab, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        main_tab.getAccessibleContext().setAccessibleName("Book Management");

        file.setText("File");

        logout_menu_item.setText("Logout");
        logout_menu_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_menu_itemActionPerformed(evt);
            }
        });
        file.add(logout_menu_item);

        exit_menu_item.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        exit_menu_item.setText("Exit");
        exit_menu_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_menu_itemActionPerformed(evt);
            }
        });
        file.add(exit_menu_item);

        main_menu_bar.add(file);

        about.setText("Help");

 

        aboutus_menu_item.setText("About Us");
        aboutus_menu_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutus_menu_itemActionPerformed(evt);
            }
        });
        about.add(aboutus_menu_item);

        main_menu_bar.add(about);

        setJMenuBar(main_menu_bar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }
    public static void main(String args[]) {


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LibrarySystem().setVisible(true);
            }
        });
    }

    public final void Establish_connection_to_db() {
       
        

        try {
           
            con = DriverManager.getConnection("jdbc:mysql://localhost/liberary_management","root","");
            stmt = con.createStatement();

        } catch (Exception e) {
        	e.getMessage();
        }
    }



    public void member_display_table() {
       
        try {
            ResultSet mem_display_rs = stmt.executeQuery("SELECT member_id,fname,lname,address,city,street,phone,email,NIC,age,registered_date FROM members");
            DefaultTableModel mem_display_model = (DefaultTableModel) mem_display_table.getModel();
            mem_display_model.setRowCount(0); 
            while (mem_display_rs.next()) {
                mem_display_model.addRow(new Object[]{mem_display_rs.getString(1), mem_display_rs.getString(2), mem_display_rs.getString(3), mem_display_rs.getString(4), mem_display_rs.getString(5), mem_display_rs.getString(6), mem_display_rs.getString(7), mem_display_rs.getString(8), mem_display_rs.getString(9), mem_display_rs.getInt(10), mem_display_rs.getDate(11)});
            }
            mem_display_rs.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Database error!");
        }
    }

    public void member_borrow_table() {
       
        try {
            ResultSet brw_display_rs = stmt.executeQuery("SELECT transaction_id,member_id,book_id,borrow_date,due_date FROM transactions");
            DefaultTableModel brw_display_model = (DefaultTableModel) brw_display_table.getModel();
            brw_display_model.setRowCount(0);
            while (brw_display_rs.next()) {
                brw_display_model.addRow(new Object[]{brw_display_rs.getInt(1), brw_display_rs.getInt(2), brw_display_rs.getInt(3), brw_display_rs.getDate(4), brw_display_rs.getDate(5)});
            }
            brw_display_rs.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Database error!");
        }
    }

    public void book_display_table() {
        
        try {
            ResultSet bk_display_rs = stmt.executeQuery("SELECT book_id,title,author,publisher,category,ISBN,edition,available_copies,number_of_copies FROM books");
            DefaultTableModel bk_display_model = (DefaultTableModel) bk_display_table.getModel();
            bk_display_model.setRowCount(0);
            while (bk_display_rs.next()) {
                bk_display_model.addRow(new Object[]{bk_display_rs.getString(1), bk_display_rs.getString(2), bk_display_rs.getString(3), bk_display_rs.getString(4), bk_display_rs.getString(5), bk_display_rs.getString(6), bk_display_rs.getString(7), bk_display_rs.getString(8), bk_display_rs.getString(9)});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Database error!");
        }
    }

    public void member_over_due_table() {
        
        Date todays_date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            ResultSet due_display_rs = stmt.executeQuery("SELECT transaction_id,member_id,book_id,borrow_date,due_date FROM transactions WHERE due_date<='" + sdf.format(todays_date) + "'");
            DefaultTableModel due_display_model = (DefaultTableModel) mem_due_display_table.getModel();
            due_display_model.setRowCount(0);
            while (due_display_rs.next()) {
                due_display_model.addRow(new Object[]{due_display_rs.getInt(1), due_display_rs.getInt(2), due_display_rs.getInt(3), due_display_rs.getDate(4), due_display_rs.getDate(5)});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Database error!");
        }
    }

    public void book_popular_table() {
        try {
            ResultSet bk_popular_rs = stmt.executeQuery("SELECT book_id,title,author,publisher,number_of_copies FROM books WHERE popularity IS NOT NULL ORDER BY popularity DESC");
            DefaultTableModel bk_popular_model = (DefaultTableModel) bk_pop_display_table.getModel();
            bk_popular_model.setRowCount(0);
            while (bk_popular_rs.next()) {
                bk_popular_model.addRow(new Object[]{bk_popular_rs.getString(1), bk_popular_rs.getString(2), bk_popular_rs.getString(3), bk_popular_rs.getString(4), bk_popular_rs.getInt(5)});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Database error!");
        }
    }

    public void admin_loggedin_label() {
        String str = "SELECT username,fname,lname FROM admins WHERE username='" + logged_in_admin + "'";
        try {
            ResultSet rs = stmt.executeQuery(str);

            while (rs.next()) {
                admin_reg_log_lbl.setText("You are Logged in as " + rs.getString(1) + " (" + rs.getString(2) + " " + rs.getString(3) + ")");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    private void exit_menu_itemActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void bk_srch_id_btnActionPerformed(java.awt.event.ActionEvent evt) {
        String srch_str;
        if (bk_srch_id_chk.isSelected()) {
            srch_str = "SELECT book_id,title,author,publisher,category,ISBN,edition,available_copies,number_of_copies FROM books WHERE book_id='" + bk_srch_id_txt.getText().trim() + "'";
        } else {
            srch_str = "SELECT book_id,title,author,publisher,category,ISBN,edition,available_copies,number_of_copies FROM books WHERE book_id LIKE '%" + bk_srch_id_txt.getText().trim() + "%'";
        }
        try {
            ResultSet bk_search_rs = stmt.executeQuery(srch_str);
            DefaultTableModel bk_search_model = (DefaultTableModel) bk_srch_table.getModel();
            bk_search_model.setRowCount(0); 
            while (bk_search_rs.next()) {
                bk_search_model.addRow(new Object[]{bk_search_rs.getString(1), bk_search_rs.getString(2), bk_search_rs.getString(3), bk_search_rs.getString(4), bk_search_rs.getString(5), bk_search_rs.getString(6), bk_search_rs.getString(7), bk_search_rs.getString(8), bk_search_rs.getString(9)});
            }
            bk_search_rs.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Database error!");
        }
    }

    private void bk_del_del_btnActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int response = JOptionPane.showConfirmDialog(null, "Are you sure want to delete the book?", "Confirm Delete",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                stmt.executeUpdate("DELETE FROM books WHERE book_id='" + bk_del_id_txt.getText().trim() + "'");

                bk_del_list.setEnabled(false);
                bk_del_del_btn.setEnabled(false);
                bk_del_lbl.setEnabled(false);
                bk_del_id_txt.setEnabled(true);
                bk_del_load_btn.setEnabled(true);
                bk_del_cancel_btn.setEnabled(false);

                bk_del_id_txt.setText("");

                String[] delete_list = new String[0];
                bk_del_list.setListData(delete_list);

                JOptionPane.showMessageDialog(null, "Successfully deleted!");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Database error!");
        }
        refresh_all_tables();
    }

    private void mem_rmv_load_btnActionPerformed(java.awt.event.ActionEvent evt) {
        if (!mem_rmv_id_txt.getText().trim().equals("")) {
            String check_id = "SELECT * FROM members WHERE member_id='" + mem_rmv_id_txt.getText().trim() + "'";
            boolean check_id_status = false;
            try {
                ResultSet rs_check = stmt.executeQuery(check_id);
                if (rs_check.next()) {
                    check_id_status = true;
                    rs_check.close();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Database error!");
            } 

            if (check_id_status == true) {
                String str = "SELECT fname,lname,address,city,street,phone,email,NIC,age,registered_date FROM members WHERE member_id='" + mem_rmv_id_txt.getText().trim() + "'";
                try {
                    ResultSet fill_del_list = stmt.executeQuery(str);

                    String[] delete_list = new String[0];

                    while (fill_del_list.next()) {
                        delete_list = new String[]{"First Name : " + fill_del_list.getString(1), "Last Name : " + fill_del_list.getString(2), "Address : " + fill_del_list.getString(3), "City : " + fill_del_list.getString(4), "Street : " + fill_del_list.getString(5), "Phone : " + fill_del_list.getString(6), "E-Mail : " + fill_del_list.getString(7), "NIC : " + fill_del_list.getString(8), "Age : " + fill_del_list.getInt(9), "Registered Date : " + fill_del_list.getDate(10)};
                    }

                    mem_rmv_list.setListData(delete_list);

                    mem_rmv_id_txt.setEnabled(false);
                    mem_rmv_load_btn.setEnabled(false);
                    mem_rmv_rmv_btn.setEnabled(true);
                    mem_rmv_cancel_btn.setEnabled(true);
                    mem_rmv_list.setEnabled(true);
                    mem_rmv_lbl.setEnabled(true);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Database error!");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Entered ID is not valid!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Enter a valid Member ID");
        }
    }

    private void mem_brw_brw_btnActionPerformed(java.awt.event.ActionEvent evt) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String borrow_date = "", due_date = "";
        try {
            borrow_date = sdf.format(mem_brw_brwdate.getDate());
            due_date = sdf.format(mem_brw_duedate.getDate());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Enter a valid dates in required fields!");
        } 

        if (!mem_brw_memid_txt.getText().trim().equals("") && !mem_brw_bkid_txt.getText().trim().equals("") && !borrow_date.equals("") && !due_date.equals("")) {

            String check_mem_id = "SELECT * FROM members WHERE member_id='" + mem_brw_memid_txt.getText().trim() + "'";
            boolean check_mem_id_status = false;
            try {
                ResultSet rs_check = stmt.executeQuery(check_mem_id);
                if (rs_check.next()) {
                    check_mem_id_status = true;
                    rs_check.close();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Database error!");
            }

            if (check_mem_id_status == true) {
                

                String check_bk_id = "SELECT * FROM books WHERE book_id='" + mem_brw_bkid_txt.getText().trim() + "'";
                boolean check_bk_id_status = false;
                try {
                    ResultSet rs_check = stmt.executeQuery(check_bk_id);
                    if (rs_check.next()) {
                        check_bk_id_status = true;
                        rs_check.close();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Database error!");
                }

                if (check_bk_id_status == true) {
                   

                    if (mem_brw_brwdate.getDate().before(mem_brw_duedate.getDate())) {

                        SimpleDateFormat stf_cmp = new SimpleDateFormat("yyyy-MM-dd");
                        String bdate_str = stf_cmp.format(mem_brw_brwdate.getDate());
                        String ddate_str = stf_cmp.format(mem_brw_duedate.getDate());
                        long diff = 0;
                        try {
                            Date bdate = stf_cmp.parse(bdate_str);
                            Date ddate = stf_cmp.parse(ddate_str);

                            diff = ddate.getTime() - bdate.getTime();
                        } catch (ParseException ex) {
                            JOptionPane.showMessageDialog(null, "Error!");
                        }
                        if (diff >= 432000000) {
                            int available_books = 0;
                            String check_bk_availability = "SELECT available_copies FROM books WHERE book_id='" + mem_brw_bkid_txt.getText().trim() + "'";

                            try {
                                ResultSet rs_check = stmt.executeQuery(check_bk_availability);
                                if (rs_check.next()) {
                                    available_books = rs_check.getInt(1);
                                    rs_check.close();
                                }
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, "Database error!");
                            }
                            if (available_books > 0) {

                             
                                String check_transactions = "SELECT COUNT(*) FROM transactions WHERE member_id='" + mem_brw_memid_txt.getText().trim() + "' AND book_id='" + mem_brw_bkid_txt.getText().trim() + "'";
                                int check_transactions_count = 0;
                                try {
                                    ResultSet rs_check_transactions = stmt.executeQuery(check_transactions);
                                    while (rs_check_transactions.next()) {
                                        check_transactions_count = rs_check_transactions.getInt(1);
                                    }
                                } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(null, "Database error!");
                                }

                                if (check_transactions_count < 1) {
                                    
                                    try {
                                        ResultSet pop_rs = stmt.executeQuery("SELECT popularity FROM books WHERE book_id='" + mem_brw_bkid_txt.getText().trim() + "'");
                                        int pop = 0;
                                        while (pop_rs.next()) {
                                            pop = pop_rs.getInt(1);
                                        }
                                        pop++;

                                        stmt.executeUpdate("UPDATE books SET popularity='" + pop + "' WHERE book_id='" + mem_brw_bkid_txt.getText().trim() + "'");

                                    } catch (SQLException ex) {
                                        JOptionPane.showMessageDialog(null, "Database error!");
                                    }
                                   
                                    String str_avaiability_refresh = "UPDATE books SET available_copies='" + (available_books - 1) + "' WHERE book_id='" + mem_brw_bkid_txt.getText().trim() + "'";
                                    try {
                                        stmt.executeUpdate(str_avaiability_refresh);
                                    } catch (Exception ex) {
                                        JOptionPane.showMessageDialog(null, "Database error!");
                                    }

                                    String str = "INSERT INTO transactions(member_id,book_id,borrow_date,due_date) VALUES('" + mem_brw_memid_txt.getText().trim() + "','" + mem_brw_bkid_txt.getText().trim() + "','" + bdate_str + "','" + ddate_str + "')";
                                    try {
                                        stmt.executeUpdate(str);

                                        JOptionPane.showMessageDialog(null, "Transaction information saved!");

                                        mem_brw_memid_txt.setText("");
                                        mem_brw_bkid_txt.setText("");
                                        mem_brw_brwdate.setCalendar(null);
                                        mem_brw_duedate.setCalendar(null);
                                    } catch (Exception ex) {
                                        JOptionPane.showMessageDialog(null, "Database error!");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Same member cannot borrow same book twice !");
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "The requested book is not available right now. All the copies are borrowed!");
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "The difference between Borrow Date and Due Date should be at least 5 days!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Due Date should be after the Borrow Date");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Entered Book ID is not valid!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Entered Member ID is not valid!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Make sure all the fields are not empty!");
        }

        refresh_all_tables(); 
    }
    private void admin_reg_clear_btnActionPerformed(java.awt.event.ActionEvent evt) {
        admin_reg_fname_txt.setText("");
        admin_reg_lname_txt.setText("");
        admin_reg_uname_txt.setText("");
        admin_reg_pwd_txt.setText("");
        admin_reg_cpwd_txt.setText("");
    }

    private void admin_reg_reg_btnActionPerformed(java.awt.event.ActionEvent evt) {
        if (!admin_reg_fname_txt.getText().trim().equals("") && !admin_reg_lname_txt.getText().trim().equals("") && !admin_reg_uname_txt.getText().trim().equals("") && admin_reg_pwd_txt.getPassword().length != 0 && admin_reg_cpwd_txt.getPassword().length != 0) {
            
            String uname_check = "SELECT count(*) FROM admins WHERE username='" + admin_reg_uname_txt.getText().trim() + "'";
            int uname_availability = 0;
            try {
                ResultSet uname_check_rs = stmt.executeQuery(uname_check);
                while (uname_check_rs.next()) {
                    uname_availability = uname_check_rs.getInt(1);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Database error!");
            }
            if (uname_availability == 0) {
               
                String admin_reg_pwd_str = admin_reg_pwd_txt.getText();
                String admin_reg_cpwd_str = admin_reg_cpwd_txt.getText();

                if (admin_reg_pwd_str.equals(admin_reg_cpwd_str)) {

                    String str = "INSERT INTO admins(fname,lname,username,password) VALUES('" + admin_reg_fname_txt.getText().trim() + "','" + admin_reg_lname_txt.getText().trim() + "','" + admin_reg_uname_txt.getText().trim() + "','" + admin_reg_pwd_str + "')";
                    try {
                        stmt.executeUpdate(str);

                        JOptionPane.showMessageDialog(null, "Admin details saved!");

                        admin_reg_fname_txt.setText("");
                        admin_reg_lname_txt.setText("");
                        admin_reg_uname_txt.setText("");
                        admin_reg_pwd_txt.setText("");
                        admin_reg_cpwd_txt.setText("");

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Database error!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Passwords don't match!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Username already exists!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Make sure all the fields are not empty!");
        }
    }

    private void bk_clear_btnActionPerformed(java.awt.event.ActionEvent evt) {
        bk_title_txt.setText("");
        bk_author_txt.setText("");
        bk_ISBN_txt.setText("");
        bk_allcopies_txt.setText("");
        bk_category_txt.setText("");
        bk_publisher_txt.setText("");
        bk_edition_txt.setText("");
    }

    private void bk_insert_btnActionPerformed(java.awt.event.ActionEvent evt) {
        if (!bk_title_txt.getText().trim().equals("") && !bk_author_txt.getText().trim().equals("") && !bk_ISBN_txt.getText().trim().equals("") && !bk_allcopies_txt.getText().trim().equals("") && !bk_category_txt.getText().trim().equals("") && !bk_publisher_txt.getText().trim().equals("") && !bk_edition_txt.getText().trim().equals("")) {
            String str = "INSERT INTO books(title,author,publisher,category,ISBN,edition,available_copies,number_of_copies) VALUES('" + bk_title_txt.getText().trim() + "','" + bk_author_txt.getText().trim() + "','" + bk_publisher_txt.getText().trim() + "','" + bk_category_txt.getText().trim() + "','" + bk_ISBN_txt.getText().trim() + "','" + bk_edition_txt.getText().trim() + "','" + bk_allcopies_txt.getText().trim() + "','" + bk_allcopies_txt.getText().trim() + "')";
            try {
                stmt.executeUpdate(str);

                JOptionPane.showMessageDialog(null, "Book information saved!");

                bk_title_txt.setText("");
                bk_author_txt.setText("");
                bk_ISBN_txt.setText("");
                bk_allcopies_txt.setText("");
                bk_category_txt.setText("");
                bk_publisher_txt.setText("");
                bk_edition_txt.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Database error!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Make sure all the fields are not empty!");
        }
        refresh_all_tables();
    }

    private void bk_editinfo_btnActionPerformed(java.awt.event.ActionEvent evt) {
        if (!bk_update_id_txt.getText().trim().equals("")) {

            String check_id = "SELECT * FROM books WHERE book_id='" + bk_update_id_txt.getText().trim() + "'";
            boolean check_id_status = false;
            try {
                ResultSet rs_check = stmt.executeQuery(check_id);
                if (rs_check.next()) {
                    check_id_status = true;
                    rs_check.close();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Database error!");
            }

            if (check_id_status == true) {
                try {
                    ResultSet fill_update_txts = stmt.executeQuery("SELECT title,author,publisher,category,ISBN,edition,available_copies,number_of_copies FROM books WHERE book_id='" + bk_update_id_txt.getText().trim() + "'");

                    while (fill_update_txts.next()) {
                        bk_up_title_txt.setText(fill_update_txts.getString(1));
                        bk_up_author_txt.setText(fill_update_txts.getString(2));
                        bk_up_publisher_txt.setText(fill_update_txts.getString(3));
                        bk_up_category_txt.setText(fill_update_txts.getString(4));
                        bk_up_ISBN_txt.setText(fill_update_txts.getString(5));
                        bk_up_edition_txt.setText(fill_update_txts.getString(6));
                        available_cpy_bef = fill_update_txts.getInt(7);
                        all_cpy_bef = fill_update_txts.getInt(8);
                    }

                    bk_up_numofcopy_txt.setText("" + all_cpy_bef);

                    bk_up_panel.setEnabled(true);
                    bk_update_btn.setEnabled(true);
                    bk_editinfo_btn.setEnabled(false);
                    bk_update_id_txt.setEnabled(false);
                    up_cancel_btn.setEnabled(true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Make sure you entered correct Book ID");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Enter a valid Book ID");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Enter a valid Book ID");
        }
    }

    private void bk_update_btnActionPerformed(java.awt.event.ActionEvent evt) {

        int update_cpy = 0, b_new_cpy, available_cpy_aft, all_cpy_aft;
        String str = "";

        if (!bk_up_numofcopy_txt.getText().trim().equals("")) {
            String update_cpy_str = bk_up_numofcopy_txt.getText().trim();
            update_cpy = Integer.parseInt(update_cpy_str); 
        }

        if (update_cpy > all_cpy_bef && update_cpy != 0) {

            b_new_cpy = update_cpy - all_cpy_bef;
            available_cpy_aft = available_cpy_bef + b_new_cpy;
            all_cpy_aft = all_cpy_bef + b_new_cpy;

            str = "UPDATE books SET title='" + bk_up_title_txt.getText().trim() + "',author='" + bk_up_author_txt.getText().trim() + "',publisher='" + bk_up_publisher_txt.getText().trim() + "',category='" + bk_up_category_txt.getText().trim() + "',ISBN='" + bk_up_ISBN_txt.getText().trim() + "',edition='" + bk_up_edition_txt.getText().trim() + "',available_copies='" + available_cpy_aft + "',number_of_copies='" + all_cpy_aft + "' WHERE book_id='" + bk_update_id_txt.getText().trim() + "'";

        } else if (update_cpy < all_cpy_bef && update_cpy != 0) {

            if (update_cpy >= (all_cpy_bef - available_cpy_bef)) {
                b_new_cpy = all_cpy_bef - update_cpy;
                available_cpy_aft = available_cpy_bef - b_new_cpy;
                all_cpy_aft = all_cpy_bef - b_new_cpy;

                str = "UPDATE books SET title='" + bk_up_title_txt.getText().trim() + "',author='" + bk_up_author_txt.getText().trim() + "',publisher='" + bk_up_publisher_txt.getText().trim() + "',category='" + bk_up_category_txt.getText().trim() + "',ISBN='" + bk_up_ISBN_txt.getText().trim() + "',edition='" + bk_up_edition_txt.getText().trim() + "',available_copies='" + available_cpy_aft + "',number_of_copies='" + all_cpy_aft + "' WHERE book_id='" + bk_update_id_txt.getText().trim() + "'";

            } else {
                JOptionPane.showMessageDialog(null, "Number of All Copies should equal or exceed the number of books have been borrowed.");
            }

        } else if (update_cpy == all_cpy_bef && update_cpy != 0) {
            str = "UPDATE books SET title='" + bk_up_title_txt.getText().trim() + "',author='" + bk_up_author_txt.getText().trim() + "',publisher='" + bk_up_publisher_txt.getText().trim() + "',category='" + bk_up_category_txt.getText().trim() + "',ISBN='" + bk_up_ISBN_txt.getText().trim() + "',edition='" + bk_up_edition_txt.getText().trim() + "',number_of_copies='" + bk_up_numofcopy_txt.getText().trim() + "' WHERE book_id='" + bk_update_id_txt.getText().trim() + "'";
        }

        if (!bk_up_title_txt.getText().trim().equals("") && !bk_up_author_txt.getText().trim().equals("") && !bk_up_ISBN_txt.getText().trim().equals("") && !bk_up_numofcopy_txt.getText().trim().equals("") && !bk_up_category_txt.getText().trim().equals("") && !bk_up_publisher_txt.getText().trim().equals("") && !bk_up_edition_txt.getText().trim().equals("")) {

            if (!str.equals("")) {
                try {
                    stmt.executeUpdate(str);

                    JOptionPane.showMessageDialog(null, "Book information saved!");

                    bk_up_title_txt.setText("");
                    bk_up_author_txt.setText("");
                    bk_up_ISBN_txt.setText("");
                    bk_up_numofcopy_txt.setText("");
                    bk_up_category_txt.setText("");
                    bk_up_publisher_txt.setText("");
                    bk_up_edition_txt.setText("");

                    bk_up_panel.setEnabled(false);
                    bk_update_btn.setEnabled(false);
                    bk_editinfo_btn.setEnabled(true);
                    bk_update_id_txt.setEnabled(true);
                    up_cancel_btn.setEnabled(false);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Database error!");
                    ex.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Make sure all the fields are not empty!");
        }
        refresh_all_tables();
    }

    private void bk_display_refresh_btnActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            ResultSet bk_display_rs = stmt.executeQuery("SELECT book_id,title,author,publisher,category,ISBN,edition,available_copies,number_of_copies FROM books");
            DefaultTableModel bk_display_model = (DefaultTableModel) bk_display_table.getModel();
            bk_display_model.setRowCount(0); 
            while (bk_display_rs.next()) {
                bk_display_model.addRow(new Object[]{bk_display_rs.getString(1), bk_display_rs.getString(2), bk_display_rs.getString(3), bk_display_rs.getString(4), bk_display_rs.getString(5), bk_display_rs.getString(6), bk_display_rs.getString(7), bk_display_rs.getString(8), bk_display_rs.getString(9)});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Database error!");
        }
    }

    private void bk_del_load_btnActionPerformed(java.awt.event.ActionEvent evt) {
        if (!bk_del_id_txt.getText().trim().equals("")) {

            try {
                ResultSet fill_del_list = stmt.executeQuery("SELECT title,author,publisher,category,ISBN,edition,number_of_copies FROM books WHERE book_id='" + bk_del_id_txt.getText().trim() + "'");

                String[] delete_list = new String[0];

                while (fill_del_list.next()) {
                    delete_list = new String[]{"Title : " + fill_del_list.getString(1), "Author : " + fill_del_list.getString(2), "Publisher : " + fill_del_list.getString(3), "Category : " + fill_del_list.getString(4), "ISBN : " + fill_del_list.getString(5), "Edition : " + fill_del_list.getString(6), "Number of copies : " + fill_del_list.getString(7)};
                }

                bk_del_list.setListData(delete_list);

                bk_del_id_txt.setEnabled(false);
                bk_del_list.setEnabled(true);
                bk_del_del_btn.setEnabled(true);
                bk_del_lbl.setEnabled(true);
                bk_del_id_txt.setEnabled(false);
                bk_del_load_btn.setEnabled(false);
                bk_del_cancel_btn.setEnabled(true);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Make sure you entered correct book ID");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Enter a valid book ID");
        }
    }


    private void mem_up_cancel_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mem_up_cancel_btnActionPerformed

        mem_up_fname_txt.setText("");
        mem_up_lname_txt.setText("");
        mem_up_add_txt.setText("");
        mem_up_city_txt.setText("");
        mem_up_str_txt.setText("");
        mem_up_phone_txt.setText("");
        mem_up_email_txt.setText("");
        mem_up_NIC_txt.setText("");
        mem_up_age_txt.setText("");

        mem_up_id_txt.setEnabled(true);
        mem_up_edit_btn.setEnabled(true);
        mem_up_update_btn.setEnabled(false);
        mem_up_cancel_btn.setEnabled(false);
        up_info_tab.setEnabled(false);
    }//GEN-LAST:event_mem_up_cancel_btnActionPerformed

    private void bk_del_cancel_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bk_del_cancel_btnActionPerformed
        bk_del_id_txt.setEnabled(true);
        bk_del_load_btn.setEnabled(true);
        bk_del_del_btn.setEnabled(false);
        bk_del_cancel_btn.setEnabled(false);
        bk_del_lbl.setEnabled(false);

        String[] delete_list = new String[0];
        bk_del_list.setListData(delete_list);
    }

    private void up_cancel_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_up_cancel_btnActionPerformed
        bk_up_title_txt.setText("");
        bk_up_author_txt.setText("");
        bk_up_ISBN_txt.setText("");
        bk_up_numofcopy_txt.setText("");
        bk_up_category_txt.setText("");
        bk_up_publisher_txt.setText("");
        bk_up_edition_txt.setText("");

        bk_up_panel.setEnabled(false);
        bk_update_btn.setEnabled(false);
        bk_editinfo_btn.setEnabled(true);
        bk_update_id_txt.setEnabled(true);
        up_cancel_btn.setEnabled(false);

    }//GEN-LAST:event_up_cancel_btnActionPerformed

    private void bk_srch_title_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bk_srch_title_btnActionPerformed
        String srch_str;
        if (bk_srch_title_chk.isSelected()) {
            srch_str = "SELECT book_id,title,author,publisher,category,ISBN,edition,available_copies,number_of_copies FROM books WHERE title='" + bk_srch_title_txt.getText().trim() + "'";
        } else {
            srch_str = "SELECT book_id,title,author,publisher,category,ISBN,edition,available_copies,number_of_copies FROM books WHERE title LIKE '%" + bk_srch_title_txt.getText().trim() + "%'";
        }
        try {
            ResultSet bk_search_rs = stmt.executeQuery(srch_str);
            DefaultTableModel bk_search_model = (DefaultTableModel) bk_srch_table.getModel();
            bk_search_model.setRowCount(0); //for refreshing purpose
            while (bk_search_rs.next()) {
                bk_search_model.addRow(new Object[]{bk_search_rs.getString(1), bk_search_rs.getString(2), bk_search_rs.getString(3), bk_search_rs.getString(4), bk_search_rs.getString(5), bk_search_rs.getString(6), bk_search_rs.getString(7), bk_search_rs.getString(8), bk_search_rs.getString(9)});
            }
            bk_search_rs.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Database error!");
        }
    }

    private void bk_srch_author_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bk_srch_author_btnActionPerformed
        String srch_str;
        if (bk_srch_author_chk.isSelected()) {
            srch_str = "SELECT book_id,title,author,publisher,category,ISBN,edition,available_copies,number_of_copies FROM books WHERE author='" + bk_srch_author_txt.getText().trim() + "'";
        } else {
            srch_str = "SELECT book_id,title,author,publisher,category,ISBN,edition,available_copies,number_of_copies FROM books WHERE author LIKE '%" + bk_srch_author_txt.getText().trim() + "%'";
        }
        try {
            ResultSet bk_search_rs = stmt.executeQuery(srch_str);
            DefaultTableModel bk_search_model = (DefaultTableModel) bk_srch_table.getModel();
            bk_search_model.setRowCount(0); //for refreshing purpose
            while (bk_search_rs.next()) {
                bk_search_model.addRow(new Object[]{bk_search_rs.getString(1), bk_search_rs.getString(2), bk_search_rs.getString(3), bk_search_rs.getString(4), bk_search_rs.getString(5), bk_search_rs.getString(6), bk_search_rs.getString(7), bk_search_rs.getString(8), bk_search_rs.getString(9)});
            }
            bk_search_rs.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Database error!");
        }
    }//GEN-LAST:event_bk_srch_author_btnActionPerformed

    private void bk_srch_publisher_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bk_srch_publisher_btnActionPerformed
        String srch_str;
        if (bk_srch_publisher_chk.isSelected()) {
            srch_str = "SELECT book_id,title,author,publisher,category,ISBN,edition,available_copies,number_of_copies FROM books WHERE publisher='" + bk_srch_publisher_txt.getText().trim() + "'";
        } else {
            srch_str = "SELECT book_id,title,author,publisher,category,ISBN,edition,available_copies,number_of_copies FROM books WHERE publisher LIKE '%" + bk_srch_publisher_txt.getText().trim() + "%'";
        }
        try {
            ResultSet bk_search_rs = stmt.executeQuery(srch_str);
            DefaultTableModel bk_search_model = (DefaultTableModel) bk_srch_table.getModel();
            bk_search_model.setRowCount(0); //for refreshing purpose
            while (bk_search_rs.next()) {
                bk_search_model.addRow(new Object[]{bk_search_rs.getString(1), bk_search_rs.getString(2), bk_search_rs.getString(3), bk_search_rs.getString(4), bk_search_rs.getString(5), bk_search_rs.getString(6), bk_search_rs.getString(7), bk_search_rs.getString(8), bk_search_rs.getString(9)});
            }
            bk_search_rs.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Database error!");
        }
    }//GEN-LAST:event_bk_srch_publisher_btnActionPerformed

    private void bk_srch_category_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bk_srch_category_btnActionPerformed
        String srch_str;
        if (bk_srch_category_chk.isSelected()) {
            srch_str = "SELECT book_id,title,author,publisher,category,ISBN,edition,available_copies,number_of_copies FROM books WHERE category='" + bk_srch_category_txt.getText().trim() + "'";
        } else {
            srch_str = "SELECT book_id,title,author,publisher,category,ISBN,edition,available_copies,number_of_copies FROM books WHERE category LIKE '%" + bk_srch_category_txt.getText().trim() + "%'";
        }
        try {
            ResultSet bk_search_rs = stmt.executeQuery(srch_str);
            DefaultTableModel bk_search_model = (DefaultTableModel) bk_srch_table.getModel();
            bk_search_model.setRowCount(0); //for refreshing purpose
            while (bk_search_rs.next()) {
                bk_search_model.addRow(new Object[]{bk_search_rs.getString(1), bk_search_rs.getString(2), bk_search_rs.getString(3), bk_search_rs.getString(4), bk_search_rs.getString(5), bk_search_rs.getString(6), bk_search_rs.getString(7), bk_search_rs.getString(8), bk_search_rs.getString(9)});
            }
            bk_search_rs.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Database error!");
        }
    }

    private void bk_srch_brw_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bk_srch_brw_btnActionPerformed
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String borrow_date = sdf.format(bk_srch_brw_txt.getDate());

            ResultSet bk_search_rs = stmt.executeQuery("SELECT books.book_id,books.title,books.author,books.publisher,books.category,books.ISBN,books.edition,books.available_copies,books.number_of_copies FROM books INNER JOIN transactions ON books.book_id = transactions.book_id WHERE borrow_date='" + borrow_date + "'");
            DefaultTableModel bk_search_model = (DefaultTableModel) bk_srch_table.getModel();
            bk_search_model.setRowCount(0); //for refreshing purpose
            while (bk_search_rs.next()) {
                bk_search_model.addRow(new Object[]{bk_search_rs.getString(1), bk_search_rs.getString(2), bk_search_rs.getString(3), bk_search_rs.getString(4), bk_search_rs.getString(5), bk_search_rs.getString(6), bk_search_rs.getString(7), bk_search_rs.getString(8), bk_search_rs.getString(9)});
            }
            bk_search_rs.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Database error! \nMake sure you entered a correct date!");
        }
    }

    private void mem_reg_reg_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mem_reg_reg_btnActionPerformed
        String check_id = "SELECT * FROM members WHERE member_id='" + mem_reg_id_txt.getText().trim() + "'";
        boolean check_id_status = true;
        try {
            ResultSet rs_check = stmt.executeQuery(check_id);
            if (!rs_check.next()) {
                check_id_status = false;
                rs_check.close();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Database error!");
        }

        if (check_id_status == false) {
            if (!mem_reg_id_txt.getText().trim().equals("") && !mem_reg_fname_txt.getText().trim().equals("") && !mem_reg_lname_txt.getText().trim().equals("") && !mem_reg_add_txt.getText().trim().equals("") && !mem_reg_city_txt.getText().trim().equals("") && !mem_reg_str_txt.getText().trim().equals("") && !mem_reg_phn_txt.getText().trim().equals("") && !mem_reg_email_txt.getText().trim().equals("") && !mem_reg_NIC_txt.getText().trim().equals("") && !mem_reg_age_txt.getText().trim().equals("")) {

                //formatting today's date to enter to the registered_date field in the database
                DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date todays_date = new Date();
                String todays_date_str = sdf.format(todays_date);

                String str = "INSERT INTO members(member_id,fname,lname,address,city,street,phone,NIC,email,age,registered_date) VALUES('" + mem_reg_id_txt.getText().trim() + "','" + mem_reg_fname_txt.getText().trim() + "','" + mem_reg_lname_txt.getText().trim() + "','" + mem_reg_add_txt.getText().trim() + "','" + mem_reg_city_txt.getText().trim() + "','" + mem_reg_str_txt.getText().trim() + "','" + mem_reg_phn_txt.getText().trim() + "','" + mem_reg_NIC_txt.getText().trim() + "','" + mem_reg_email_txt.getText().trim() + "','" + mem_reg_age_txt.getText().trim() + "','" + todays_date_str + "')";
                try {
                    stmt.executeUpdate(str);

                    JOptionPane.showMessageDialog(null, "Member details saved!");

                    mem_reg_id_txt.setText("");
                    mem_reg_fname_txt.setText("");
                    mem_reg_lname_txt.setText("");
                    mem_reg_add_txt.setText("");
                    mem_reg_city_txt.setText("");
                    mem_reg_str_txt.setText("");
                    mem_reg_phn_txt.setText("");
                    mem_reg_email_txt.setText("");
                    mem_reg_NIC_txt.setText("");
                    mem_reg_age_txt.setText("");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Database error!");
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Make sure all the fields are not empty!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Entered ID is already taken. Try different!");
        }
        refresh_all_tables();
    }

    private void mem_reg_clear_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mem_reg_clear_btnActionPerformed
        mem_reg_id_txt.setText("");
        mem_reg_fname_txt.setText("");
        mem_reg_lname_txt.setText("");
        mem_reg_add_txt.setText("");
        mem_reg_city_txt.setText("");
        mem_reg_str_txt.setText("");
        mem_reg_phn_txt.setText("");
        mem_reg_email_txt.setText("");
        mem_reg_NIC_txt.setText("");
        mem_reg_age_txt.setText("");

        mem_up_id_txt.setEnabled(true);
        mem_up_edit_btn.setEnabled(true);
        mem_up_update_btn.setEnabled(false);
        mem_up_cancel_btn.setEnabled(false);
        up_info_tab.setEnabled(false);
    }//GEN-LAST:event_mem_reg_clear_btnActionPerformed

    private void mem_up_edit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mem_up_edit_btnActionPerformed
        if (!mem_up_id_txt.getText().trim().equals("")) {
            String check_id = "SELECT * FROM members WHERE member_id='" + mem_up_id_txt.getText().trim() + "'";
            boolean check_id_status = false;
            try {
                ResultSet rs_check = stmt.executeQuery(check_id);
                if (rs_check.next()) {
                    check_id_status = true;
                    rs_check.close();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Database error!");
            }

            if (check_id_status == true) {

                String str = "SELECT fname,lname,address,city,street,phone,email,NIC,age FROM members WHERE member_id='" + mem_up_id_txt.getText().trim() + "'";
                try {
                    ResultSet up_rs = stmt.executeQuery(str);

                    while (up_rs.next()) {
                        mem_up_fname_txt.setText(up_rs.getString(1));
                        mem_up_lname_txt.setText(up_rs.getString(2));
                        mem_up_add_txt.setText(up_rs.getString(3));
                        mem_up_city_txt.setText(up_rs.getString(4));
                        mem_up_str_txt.setText(up_rs.getString(5));
                        mem_up_phone_txt.setText(up_rs.getString(6));
                        mem_up_email_txt.setText(up_rs.getString(7));
                        mem_up_NIC_txt.setText(up_rs.getString(8));
                        mem_up_age_txt.setText("" + up_rs.getInt(9));
                    }

                    mem_up_id_txt.setEnabled(false);
                    mem_up_edit_btn.setEnabled(false);
                    mem_up_update_btn.setEnabled(true);
                    mem_up_cancel_btn.setEnabled(true);
                    up_info_tab.setEnabled(true);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Database error!");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Entered ID is not valid!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Enter a valid Member ID");
        }
    }//GEN-LAST:event_mem_up_edit_btnActionPerformed

    private void mem_up_update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mem_up_update_btnActionPerformed
        if (!mem_up_id_txt.getText().trim().equals("") && !mem_up_fname_txt.getText().trim().equals("") && !mem_up_lname_txt.getText().trim().equals("") && !mem_up_add_txt.getText().trim().equals("") && !mem_up_city_txt.getText().trim().equals("") && !mem_up_str_txt.getText().trim().equals("") && !mem_up_phone_txt.getText().trim().equals("") && !mem_up_email_txt.getText().trim().equals("") && !mem_up_NIC_txt.getText().trim().equals("") && !mem_up_age_txt.getText().trim().equals("")) {
            String str = "UPDATE members SET fname='" + mem_up_fname_txt.getText().trim() + "',lname='" + mem_up_lname_txt.getText().trim() + "',address='" + mem_up_add_txt.getText().trim() + "',city='" + mem_up_city_txt.getText().trim() + "',street='" + mem_up_str_txt.getText().trim() + "',phone='" + mem_up_phone_txt.getText().trim() + "',NIC='" + mem_up_NIC_txt.getText().trim() + "',email='" + mem_up_email_txt.getText().trim() + "',age='" + mem_up_age_txt.getText().trim() + "' WHERE member_id='" + mem_up_id_txt.getText().trim() + "'";

            try {
                stmt.executeUpdate(str);

                JOptionPane.showMessageDialog(null, "Member details saved!");

                mem_up_fname_txt.setText("");
                mem_up_lname_txt.setText("");
                mem_up_add_txt.setText("");
                mem_up_city_txt.setText("");
                mem_up_str_txt.setText("");
                mem_up_phone_txt.setText("");
                mem_up_email_txt.setText("");
                mem_up_NIC_txt.setText("");
                mem_up_age_txt.setText("");

                mem_up_id_txt.setEnabled(true);
                mem_up_edit_btn.setEnabled(true);
                mem_up_update_btn.setEnabled(false);
                mem_up_cancel_btn.setEnabled(false);
                up_info_tab.setEnabled(false);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Database error!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Make sure all the fields are not empty!");
        }

        refresh_all_tables();
    }//GEN-LAST:event_mem_up_update_btnActionPerformed

    private void mem_rmv_cancel_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mem_rmv_cancel_btnActionPerformed
        String[] delete_list = new String[0];

        mem_rmv_list.setListData(delete_list);

        mem_rmv_id_txt.setEnabled(true);
        mem_rmv_load_btn.setEnabled(true);
        mem_rmv_rmv_btn.setEnabled(false);
        mem_rmv_cancel_btn.setEnabled(false);
        mem_rmv_list.setEnabled(false);
        mem_rmv_lbl.setEnabled(false);
    }//GEN-LAST:event_mem_rmv_cancel_btnActionPerformed

    private void mem_rmv_rmv_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mem_rmv_rmv_btnActionPerformed
        try {
            int response = JOptionPane.showConfirmDialog(null, "Are you sure want to remove this member?", "Confirm Delete",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                stmt.executeUpdate("DELETE FROM members WHERE member_id='" + mem_rmv_id_txt.getText().trim() + "'");

                String[] delete_list = new String[0];

                mem_rmv_list.setListData(delete_list);
                mem_rmv_id_txt.setText("");
                mem_rmv_id_txt.setEnabled(true);
                mem_rmv_load_btn.setEnabled(true);
                mem_rmv_rmv_btn.setEnabled(false);
                mem_rmv_cancel_btn.setEnabled(false);
                mem_rmv_list.setEnabled(false);
                mem_rmv_lbl.setEnabled(false);

                JOptionPane.showMessageDialog(null, "Successfully deleted!");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Cannot remove! This member has books to return.");
        }
        refresh_all_tables();
    }//GEN-LAST:event_mem_rmv_rmv_btnActionPerformed

    private void mem_display_refresh_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mem_display_refresh_btnActionPerformed
        try {
            ResultSet mem_display_rs = stmt.executeQuery("SELECT member_id,fname,lname,address,city,street,phone,email,NIC,age,registered_date FROM members");
            DefaultTableModel mem_display_model = (DefaultTableModel) mem_display_table.getModel();
            mem_display_model.setRowCount(0); //for refreshing purpose
            while (mem_display_rs.next()) {
                mem_display_model.addRow(new Object[]{mem_display_rs.getString(1), mem_display_rs.getString(2), mem_display_rs.getString(3), mem_display_rs.getString(4), mem_display_rs.getString(5), mem_display_rs.getString(6), mem_display_rs.getString(7), mem_display_rs.getString(8), mem_display_rs.getString(9), mem_display_rs.getInt(10), mem_display_rs.getDate(11)});
            }
            mem_display_rs.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Database error!");
        }
    }//GEN-LAST:event_mem_display_refresh_btnActionPerformed

    private void brw_refresh_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brw_refresh_btnActionPerformed
        try {
            ResultSet brw_display_rs = stmt.executeQuery("SELECT transaction_id,member_id,book_id,borrow_date,due_date FROM transactions");
            DefaultTableModel brw_display_model = (DefaultTableModel) brw_display_table.getModel();
            brw_display_model.setRowCount(0); //for refreshing purpose
            while (brw_display_rs.next()) {
                brw_display_model.addRow(new Object[]{brw_display_rs.getInt(1), brw_display_rs.getInt(2), brw_display_rs.getInt(3), brw_display_rs.getDate(4), brw_display_rs.getDate(5)});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Database error!");
        }
    }//GEN-LAST:event_brw_refresh_btnActionPerformed

    private void mem_ret_cancel_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mem_ret_cancel_btnActionPerformed
        String[] delete_list = new String[0];

        mem_ret_list.setListData(delete_list);

        mem_ret_id_txt.setEnabled(true);
        mem_ret_load_btn.setEnabled(true);
        mem_ret_rmv_btn.setEnabled(false);
        mem_ret_cancel_btn.setEnabled(false);
        mem_ret_list.setEnabled(false);
        mem_ret_lbl.setEnabled(false);
    }//GEN-LAST:event_mem_ret_cancel_btnActionPerformed

    private void mem_ret_load_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mem_ret_load_btnActionPerformed
        if (!mem_ret_id_txt.getText().trim().equals("")) {
            String check_id = "SELECT * FROM transactions WHERE transaction_id='" + mem_ret_id_txt.getText().trim() + "'";
            boolean check_id_status = false;
            try {
                ResultSet rs_check = stmt.executeQuery(check_id);
                if (rs_check.next()) {
                    check_id_status = true;
                    rs_check.close();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Database error!");
            } //above try-catch block will recognize if the entered ID is correct or not.

            if (check_id_status == true) {
                String str = "SELECT transaction_id,member_id,book_id,borrow_date,due_date FROM transactions WHERE transaction_id='" + mem_ret_id_txt.getText().trim() + "'";
                try {
                    ResultSet fill_del_list = stmt.executeQuery(str);

                    String[] delete_list = new String[0];

                    while (fill_del_list.next()) {
                        delete_list = new String[]{"Transaction ID : " + fill_del_list.getInt(1), "Member ID : " + fill_del_list.getInt(2), "Book ID : " + fill_del_list.getInt(3), "Borrow Date : " + fill_del_list.getDate(4), "Due Date : " + fill_del_list.getDate(5)};
                    }

                    mem_ret_list.setListData(delete_list);

                    mem_ret_id_txt.setEnabled(false);
                    mem_ret_load_btn.setEnabled(false);
                    mem_ret_rmv_btn.setEnabled(true);
                    mem_ret_cancel_btn.setEnabled(true);
                    mem_ret_list.setEnabled(true);
                    mem_ret_lbl.setEnabled(true);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Database error!");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Entered ID is not valid!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Enter a valid Member ID");
        }
    }//GEN-LAST:event_mem_ret_load_btnActionPerformed

    private void mem_ret_rmv_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mem_ret_rmv_btnActionPerformed
        try {
            int response = JOptionPane.showConfirmDialog(null, "Are you sure want to remove this borrow information?", "Confirm Delete",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {

                ResultSet get_bk_id = stmt.executeQuery("SELECT book_id FROM transactions WHERE transaction_id='" + mem_ret_id_txt.getText().trim() + "'");
                String bk_id = "";
                while (get_bk_id.next()) {
                    bk_id = get_bk_id.getString(1);
                }

                stmt.executeUpdate("DELETE FROM transactions WHERE transaction_id='" + mem_ret_id_txt.getText().trim() + "'");

                String[] delete_list = new String[0];

                int available_books = 0;
                String available_str = "SELECT available_copies FROM books WHERE book_id='" + bk_id + "'";

                ResultSet rs_check_ret = stmt.executeQuery(available_str);
                while (rs_check_ret.next()) {
                    available_books = Integer.parseInt(rs_check_ret.getString(1));
                }

                String str_avaiability_refresh = "UPDATE books SET available_copies='" + (available_books + 1) + "' WHERE book_id='" + bk_id + "'";

                stmt.executeUpdate(str_avaiability_refresh);

                mem_ret_list.setListData(delete_list);
                mem_ret_id_txt.setText("");
                mem_ret_id_txt.setEnabled(true);
                mem_ret_load_btn.setEnabled(true);
                mem_ret_rmv_btn.setEnabled(false);
                mem_ret_cancel_btn.setEnabled(false);
                mem_ret_list.setEnabled(false);
                mem_ret_lbl.setEnabled(false);

                JOptionPane.showMessageDialog(null, "Successfully deleted!");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Database error!");
        }
        refresh_all_tables();
    }

    private void mem_due_refresh_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mem_due_refresh_btnActionPerformed
        Date todays_date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            ResultSet due_display_rs = stmt.executeQuery("SELECT transaction_id,member_id,book_id,borrow_date,due_date FROM transactions WHERE due_date<='" + sdf.format(todays_date) + "'");
            DefaultTableModel due_display_model = (DefaultTableModel) mem_due_display_table.getModel();
            due_display_model.setRowCount(0); //for refreshing purpose
            while (due_display_rs.next()) {
                due_display_model.addRow(new Object[]{due_display_rs.getInt(1), due_display_rs.getInt(2), due_display_rs.getInt(3), due_display_rs.getDate(4), due_display_rs.getDate(5)});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Database error!");
        }
    }

    private void bk_pop_refresh_btnActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            ResultSet bk_popular_rs = stmt.executeQuery("SELECT book_id,title,author,publisher,number_of_copies FROM books WHERE popularity IS NOT NULL ORDER BY popularity DESC");
            DefaultTableModel bk_popular_model = (DefaultTableModel) bk_pop_display_table.getModel();
            bk_popular_model.setRowCount(0); //for refreshing purpose
            while (bk_popular_rs.next()) {
                bk_popular_model.addRow(new Object[]{bk_popular_rs.getString(1), bk_popular_rs.getString(2), bk_popular_rs.getString(3), bk_popular_rs.getString(4), bk_popular_rs.getInt(5)});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Database error!");
        }
    }

    private void admin_chng_up_btnActionPerformed(java.awt.event.ActionEvent evt) {
        if (admin_chng_curpwd_txt.getPassword().length != 0 && admin_chng_npwd_txt.getPassword().length != 0 && admin_chng_cpwd_txt.getPassword().length != 0) {

            String curr_pass = "SELECT password FROM admins WHERE username='" + logged_in_admin + "'";

            try {
                ResultSet curr_pass_rs = stmt.executeQuery(curr_pass);
                while (curr_pass_rs.next()) {
                    curr_pass = curr_pass_rs.getString(1);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Database Error!");
            }
            if (curr_pass.equals(admin_chng_curpwd_txt.getText().trim())) {
                String new_pass = admin_chng_npwd_txt.getText().trim();
                String con_pass = admin_chng_cpwd_txt.getText().trim();
                if (new_pass.equals(con_pass)) {
                    String pwd_change = "UPDATE admins SET password='" + new_pass + "' WHERE username='" + logged_in_admin + "'";

                    try {
                        stmt.executeUpdate(pwd_change);
                        JOptionPane.showMessageDialog(null, "Password changed successfully!");
                        admin_chng_curpwd_txt.setText("");
                        admin_chng_npwd_txt.setText("");
                        admin_chng_cpwd_txt.setText("");
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Database Error!");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "New Password and Confirm Password doesn't match!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Current password you have entered is incorrect!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Make sure all the fields are not empty!");
        }
    }

    private void bk_allcopies_txtKeyTyped(java.awt.event.KeyEvent evt) {
        char vchar = evt.getKeyChar();
        if (!Character.isDigit(vchar) || (vchar == KeyEvent.VK_BACK_SPACE) || (vchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }

    private void bk_up_numofcopy_txtKeyTyped(java.awt.event.KeyEvent evt) {
        char vchar = evt.getKeyChar();
        if (!Character.isDigit(vchar) || (vchar == KeyEvent.VK_BACK_SPACE) || (vchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }
    private void bk_update_id_txtKeyTyped(java.awt.event.KeyEvent evt) {
        char vchar = evt.getKeyChar();
        if (!Character.isDigit(vchar) || (vchar == KeyEvent.VK_BACK_SPACE) || (vchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }

    private void bk_srch_id_txtKeyTyped(java.awt.event.KeyEvent evt) {
        char vchar = evt.getKeyChar();
        if (!Character.isDigit(vchar) || (vchar == KeyEvent.VK_BACK_SPACE) || (vchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }

    private void bk_del_id_txtKeyTyped(java.awt.event.KeyEvent evt) {
        char vchar = evt.getKeyChar();
        if (!Character.isDigit(vchar) || (vchar == KeyEvent.VK_BACK_SPACE) || (vchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }

    private void mem_reg_id_txtKeyTyped(java.awt.event.KeyEvent evt) {
        char vchar = evt.getKeyChar();
        if (!Character.isDigit(vchar) || (vchar == KeyEvent.VK_BACK_SPACE) || (vchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }

    private void mem_reg_age_txtKeyTyped(java.awt.event.KeyEvent evt) {
        char vchar = evt.getKeyChar();
        if (!Character.isDigit(vchar) || (vchar == KeyEvent.VK_BACK_SPACE) || (vchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }

    private void mem_up_id_txtKeyTyped(java.awt.event.KeyEvent evt) {
        char vchar = evt.getKeyChar();
        if (!Character.isDigit(vchar) || (vchar == KeyEvent.VK_BACK_SPACE) || (vchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }

    private void mem_up_age_txtKeyTyped(java.awt.event.KeyEvent evt) {
        char vchar = evt.getKeyChar();
        if (!Character.isDigit(vchar) || (vchar == KeyEvent.VK_BACK_SPACE) || (vchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }

    private void mem_rmv_id_txtKeyTyped(java.awt.event.KeyEvent evt) {
        char vchar = evt.getKeyChar();
        if (!Character.isDigit(vchar) || (vchar == KeyEvent.VK_BACK_SPACE) || (vchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }
    private void mem_brw_memid_txtKeyTyped(java.awt.event.KeyEvent evt) {
        char vchar = evt.getKeyChar();
        if (!Character.isDigit(vchar) || (vchar == KeyEvent.VK_BACK_SPACE) || (vchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }

    private void mem_brw_bkid_txtKeyTyped(java.awt.event.KeyEvent evt) {
        char vchar = evt.getKeyChar();
        if (!Character.isDigit(vchar) || (vchar == KeyEvent.VK_BACK_SPACE) || (vchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }

    private void mem_ret_id_txtKeyTyped(java.awt.event.KeyEvent evt) {
        char vchar = evt.getKeyChar();
        if (!Character.isDigit(vchar) || (vchar == KeyEvent.VK_BACK_SPACE) || (vchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }

    private void mem_brw_cancel_btnActionPerformed(java.awt.event.ActionEvent evt) {
        mem_brw_memid_txt.setText("");
        mem_brw_bkid_txt.setText("");
        mem_brw_brwdate.setCalendar(null);
        mem_brw_duedate.setCalendar(null);
    }

    private void logout_menu_itemActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        LoginWindow log = new LoginWindow();
        log.setVisible(true);
    }

  

    private void aboutus_menu_itemActionPerformed(java.awt.event.ActionEvent evt) {
        aboutus.setVisible(true);
    }

    private void admin_reg_uname_txtKeyTyped(java.awt.event.KeyEvent evt) {
        char vchar = evt.getKeyChar();
        if (vchar == KeyEvent.VK_SPACE) {
            evt.consume();
        }
    }

    private void bk_pop_save_btnActionPerformed(java.awt.event.ActionEvent evt) {
        if (bk_pop_display_table.getModel().getRowCount() != 0) {
            JFileChooser fileChooser = new JFileChooser();

            int returnVal = fileChooser.showSaveDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                try {
                    File file = fileChooser.getSelectedFile();

                    String suffix = ".txt";
                    if (!fileChooser.getSelectedFile().getAbsolutePath().endsWith(suffix)) {
                        file = new File(fileChooser.getSelectedFile() + suffix);
                    }

                    PrintWriter pw = new PrintWriter(file);

                    for (int row = 0; row < bk_pop_display_table.getRowCount(); row++) {
                        for (int col = 0; col < bk_pop_display_table.getColumnCount(); col++) {
                            pw.print(bk_pop_display_table.getColumnName(col));
                            pw.print(": ");
                            pw.println(bk_pop_display_table.getValueAt(row, col));
                        }
                        pw.println("");
                        pw.println("");
                    }
                    pw.close();
                    JOptionPane.showMessageDialog(null, "File Saved Successfully!");
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "IO Stream Error!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cannot Save. Table is Empty!");
        }
    }

    private void bk_display_save_btnActionPerformed(java.awt.event.ActionEvent evt) {
        if (bk_display_table.getModel().getRowCount() != 0) {
            JFileChooser fileChooser = new JFileChooser();

            int returnVal = fileChooser.showSaveDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                try {
                    File file = fileChooser.getSelectedFile();

                    String suffix = ".txt";
                    if (!fileChooser.getSelectedFile().getAbsolutePath().endsWith(suffix)) {
                        file = new File(fileChooser.getSelectedFile() + suffix);
                    }

                    PrintWriter pw = new PrintWriter(file);

                    for (int row = 0; row < bk_display_table.getRowCount(); row++) {
                        for (int col = 0; col < bk_display_table.getColumnCount(); col++) {
                            pw.print(bk_display_table.getColumnName(col));
                            pw.print(": ");
                            pw.println(bk_display_table.getValueAt(row, col));
                        }
                        pw.println("");
                        pw.println("");
                    }
                    pw.close();
                    JOptionPane.showMessageDialog(null, "File Saved Successfully!");
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "IO Stream Error!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cannot Save. Table is Empty!");
        }
    }

    private void mem_display_save_btnActionPerformed(java.awt.event.ActionEvent evt) {
        if (mem_display_table.getModel().getRowCount() != 0) {
            JFileChooser fileChooser = new JFileChooser();

            int returnVal = fileChooser.showSaveDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                try {
                    File file = fileChooser.getSelectedFile();

                    String suffix = ".txt";
                    if (!fileChooser.getSelectedFile().getAbsolutePath().endsWith(suffix)) {
                        file = new File(fileChooser.getSelectedFile() + suffix);
                    }

                    PrintWriter pw = new PrintWriter(file);

                    for (int row = 0; row < mem_display_table.getRowCount(); row++) {
                        for (int col = 0; col < mem_display_table.getColumnCount(); col++) {
                            pw.print(mem_display_table.getColumnName(col));
                            pw.print(": ");
                            pw.println(mem_display_table.getValueAt(row, col));
                        }
                        pw.println("");
                        pw.println("");
                    }
                    pw.close();
                    JOptionPane.showMessageDialog(null, "File Saved Successfully!");
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "IO Stream Error!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cannot Save. Table is Empty!");
        }
    }

    private void brw_save_btnActionPerformed(java.awt.event.ActionEvent evt) {
        if (brw_display_table.getModel().getRowCount() != 0) {
            JFileChooser fileChooser = new JFileChooser();

            int returnVal = fileChooser.showSaveDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                try {
                    File file = fileChooser.getSelectedFile();

                    String suffix = ".txt";
                    if (!fileChooser.getSelectedFile().getAbsolutePath().endsWith(suffix)) {
                        file = new File(fileChooser.getSelectedFile() + suffix);
                    }

                    PrintWriter pw = new PrintWriter(file);

                    for (int row = 0; row < brw_display_table.getRowCount(); row++) {
                        for (int col = 0; col < brw_display_table.getColumnCount(); col++) {
                            pw.print(brw_display_table.getColumnName(col));
                            pw.print(": ");
                            pw.println(brw_display_table.getValueAt(row, col));
                        }
                        pw.println("");
                        pw.println("");
                    }
                    pw.close();
                    JOptionPane.showMessageDialog(null, "File Saved Successfully!");
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "IO Stream Error!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cannot Save. Table is Empty!");
        }
    }

    private void mem_due_save_btnActionPerformed(java.awt.event.ActionEvent evt) {
        if (mem_due_display_table.getModel().getRowCount() != 0) {
            JFileChooser fileChooser = new JFileChooser();

            int returnVal = fileChooser.showSaveDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                try {
                    File file = fileChooser.getSelectedFile();

                    String suffix = ".txt";
                    if (!fileChooser.getSelectedFile().getAbsolutePath().endsWith(suffix)) {
                        file = new File(fileChooser.getSelectedFile() + suffix);
                    }

                    PrintWriter pw = new PrintWriter(file);

                    for (int row = 0; row < mem_due_display_table.getRowCount(); row++) {
                        for (int col = 0; col < mem_due_display_table.getColumnCount(); col++) {
                            pw.print(mem_due_display_table.getColumnName(col));
                            pw.print(": ");
                            pw.println(mem_due_display_table.getValueAt(row, col));
                        }
                        pw.println("");
                        pw.println("");
                    }
                    pw.close();
                    JOptionPane.showMessageDialog(null, "File Saved Successfully!");
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "IO Stream Error!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cannot Save. Table is Empty!");
        }
    }

    private void admin_up_up_btnActionPerformed(java.awt.event.ActionEvent evt) {
        if (!admin_up_fname_txt.getText().trim().equals("") && !admin_up_lname_txt.getText().trim().equals("")) {
            String str = "UPDATE admins SET fname='" + admin_up_fname_txt.getText().trim() + "', lname='" + admin_up_lname_txt.getText().trim() + "' WHERE username='" + logged_in_admin + "'";
            
            try {
                stmt.executeUpdate(str);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Database Error!");
            }
            JOptionPane.showMessageDialog(null, "Name updated successfully!");
            
            admin_up_fname_txt.setText("");
            admin_up_lname_txt.setText("");
            admin_loggedin_label();
        } else {
            JOptionPane.showMessageDialog(null, "Make sure all the fields are not empty!!");
        }

    }


        private javax.swing.JMenu about;
    private javax.swing.JMenuItem aboutus_menu_item;
    private javax.swing.JPasswordField admin_chng_cpwd_txt;
    private javax.swing.JPasswordField admin_chng_curpwd_txt;
    private javax.swing.JPasswordField admin_chng_npwd_txt;
    private javax.swing.JButton admin_chng_up_btn;
    private javax.swing.JPanel admin_panel;
    private javax.swing.JButton admin_reg_clear_btn;
    private javax.swing.JPasswordField admin_reg_cpwd_txt;
    private javax.swing.JTextField admin_reg_fname_txt;
    private javax.swing.JTextField admin_reg_lname_txt;
    private javax.swing.JLabel admin_reg_log_lbl;
    private javax.swing.JPasswordField admin_reg_pwd_txt;
    private javax.swing.JButton admin_reg_reg_btn;
    private javax.swing.JTextField admin_reg_uname_txt;
    private javax.swing.JTabbedPane admin_tab_panel;
    private javax.swing.JTextField admin_up_fname_txt;
    private javax.swing.JTextField admin_up_lname_txt;
    private javax.swing.JButton admin_up_up_btn;
    private javax.swing.JTextField bk_ISBN_txt;
    private javax.swing.JTextField bk_allcopies_txt;
    private javax.swing.JTextField bk_author_txt;
    private javax.swing.JTextField bk_category_txt;
    private javax.swing.JButton bk_clear_btn;
    private javax.swing.JButton bk_del_cancel_btn;
    private javax.swing.JButton bk_del_del_btn;
    private javax.swing.JTextField bk_del_id_txt;
    private javax.swing.JLabel bk_del_lbl;
    private javax.swing.JList<String> bk_del_list;
    private javax.swing.JButton bk_del_load_btn;
    private javax.swing.JButton bk_display_refresh_btn;
    private javax.swing.JButton bk_display_save_btn;
    private javax.swing.JTable bk_display_table;
    private javax.swing.JButton bk_editinfo_btn;
    private javax.swing.JTextField bk_edition_txt;
    private javax.swing.JButton bk_insert_btn;
    private javax.swing.JTable bk_pop_display_table;
    private javax.swing.JButton bk_pop_refresh_btn;
    private javax.swing.JButton bk_pop_save_btn;
    private javax.swing.JTextField bk_publisher_txt;
    private javax.swing.JButton bk_srch_author_btn;
    private javax.swing.JCheckBox bk_srch_author_chk;
    private javax.swing.JTextField bk_srch_author_txt;
    private javax.swing.JButton bk_srch_brw_btn;
    private com.toedter.calendar.JDateChooser bk_srch_brw_txt;
    private javax.swing.JButton bk_srch_category_btn;
    private javax.swing.JCheckBox bk_srch_category_chk;
    private javax.swing.JTextField bk_srch_category_txt;
    private javax.swing.JButton bk_srch_id_btn;
    private javax.swing.JCheckBox bk_srch_id_chk;
    private javax.swing.JTextField bk_srch_id_txt;
    private javax.swing.JButton bk_srch_publisher_btn;
    private javax.swing.JCheckBox bk_srch_publisher_chk;
    private javax.swing.JTextField bk_srch_publisher_txt;
    private javax.swing.JTable bk_srch_table;
    private javax.swing.JButton bk_srch_title_btn;
    private javax.swing.JCheckBox bk_srch_title_chk;
    private javax.swing.JTextField bk_srch_title_txt;
    private javax.swing.JTextField bk_title_txt;
    private javax.swing.JTextField bk_up_ISBN_txt;
    private javax.swing.JTextField bk_up_author_txt;
    private javax.swing.JTextField bk_up_category_txt;
    private javax.swing.JTextField bk_up_edition_txt;
    private javax.swing.JTextField bk_up_numofcopy_txt;
    private javax.swing.JPanel bk_up_panel;
    private javax.swing.JTextField bk_up_publisher_txt;
    private javax.swing.JTextField bk_up_title_txt;
    private javax.swing.JButton bk_update_btn;
    private javax.swing.JTextField bk_update_id_txt;
    private javax.swing.JPanel book_panel;
    private javax.swing.JTabbedPane book_tab_panel;
    private javax.swing.JPanel borrow_tab;
    private javax.swing.JTable brw_display_table;
    private javax.swing.JButton brw_refresh_btn;
    private javax.swing.JButton brw_save_btn;
    private javax.swing.JPanel delete_tab;
    private javax.swing.JPanel display_mem_panel;
    private javax.swing.JPanel display_tab;
    private javax.swing.JPanel due_books;
    private javax.swing.JMenuItem exit_menu_item;
    private javax.swing.JMenu file;
    private javax.swing.JMenuItem help_menu_item;
    private javax.swing.JPanel insert_book_tab;
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
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
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
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JMenuItem logout_menu_item;
    private static javax.swing.JMenuBar main_menu_bar;
    private static javax.swing.JPanel main_panel;
    private javax.swing.JTabbedPane main_tab;
    private javax.swing.JTextField mem_brw_bkid_txt;
    private javax.swing.JButton mem_brw_brw_btn;
    private com.toedter.calendar.JDateChooser mem_brw_brwdate;
    private javax.swing.JButton mem_brw_cancel_btn;
    private com.toedter.calendar.JDateChooser mem_brw_duedate;
    private javax.swing.JTextField mem_brw_memid_txt;
    private javax.swing.JButton mem_display_refresh_btn;
    private javax.swing.JButton mem_display_save_btn;
    private javax.swing.JTable mem_display_table;
    private javax.swing.JTable mem_due_display_table;
    private javax.swing.JButton mem_due_refresh_btn;
    private javax.swing.JButton mem_due_save_btn;
    private javax.swing.JTextField mem_reg_NIC_txt;
    private javax.swing.JTextField mem_reg_add_txt;
    private javax.swing.JTextField mem_reg_age_txt;
    private javax.swing.JTextField mem_reg_city_txt;
    private javax.swing.JButton mem_reg_clear_btn;
    private javax.swing.JTextField mem_reg_email_txt;
    private javax.swing.JTextField mem_reg_fname_txt;
    private javax.swing.JTextField mem_reg_id_txt;
    private javax.swing.JTextField mem_reg_lname_txt;
    private javax.swing.JTextField mem_reg_phn_txt;
    private javax.swing.JButton mem_reg_reg_btn;
    private javax.swing.JTextField mem_reg_str_txt;
    private javax.swing.JButton mem_ret_cancel_btn;
    private javax.swing.JTextField mem_ret_id_txt;
    private javax.swing.JLabel mem_ret_lbl;
    private javax.swing.JList<String> mem_ret_list;
    private javax.swing.JButton mem_ret_load_btn;
    private javax.swing.JButton mem_ret_rmv_btn;
    private javax.swing.JButton mem_rmv_cancel_btn;
    private javax.swing.JTextField mem_rmv_id_txt;
    private javax.swing.JLabel mem_rmv_lbl;
    private javax.swing.JList<String> mem_rmv_list;
    private javax.swing.JButton mem_rmv_load_btn;
    private javax.swing.JButton mem_rmv_rmv_btn;
    private javax.swing.JTextField mem_up_NIC_txt;
    private javax.swing.JTextField mem_up_add_txt;
    private javax.swing.JTextField mem_up_age_txt;
    private javax.swing.JButton mem_up_cancel_btn;
    private javax.swing.JTextField mem_up_city_txt;
    private javax.swing.JButton mem_up_edit_btn;
    private javax.swing.JTextField mem_up_email_txt;
    private javax.swing.JTextField mem_up_fname_txt;
    private javax.swing.JTextField mem_up_id_txt;
    private javax.swing.JTextField mem_up_lname_txt;
    private javax.swing.JTextField mem_up_phone_txt;
    private javax.swing.JTextField mem_up_str_txt;
    private javax.swing.JButton mem_up_update_btn;
    private javax.swing.JPanel member_panel;
    private javax.swing.JTabbedPane member_tab_panel;
    private javax.swing.JPanel name_tab;
    private javax.swing.JPanel password_tab;
    private javax.swing.JPanel popular_books_tab;
    private javax.swing.JPanel register_admin_tab;
    private javax.swing.JPanel register_mem_tab;
    private javax.swing.JPanel remove_mem_tab;
    private javax.swing.JPanel return_tab;
    private javax.swing.JPanel search_tab;
    private javax.swing.JButton up_cancel_btn;
    private javax.swing.JTabbedPane up_info_tab;
    private javax.swing.JPanel update_mem_tab;
    private javax.swing.JPanel update_tab;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    
}
