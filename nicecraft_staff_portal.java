package nicecraft_staff_portal;

/*
Patrick Looi 0121712 Java Individual Assignment
 */
//Import everything that is required to run the software.
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class nicecraft_staff_portal extends JFrame implements WindowListener, ActionListener {

    //Declaration for  Large Panel that will hold all the small panel.
    private JPanel pnlRegistration,
            pnlLogin,
            pnlViewMembers,
            pnlEditMembers,
            pnlDeleteMembers,
            pnlThreaded;

    //Declaration for JMenu, JMenuBar, and JMenuItem of all 6 page.
    private JMenuBar mnubMain1, mnubMain2, mnubMain3, mnubMain4, mnubMain5, mnubMain6;
    private JMenu mnuiRegistration1,
            mnuiRegistration2,
            mnuiRegistration3,
            mnuiRegistration4,
            mnuiRegistration5,
            mnuiRegistration6,
            mnuiLogin1,
            mnuiLogin2,
            mnuiLogin3,
            mnuiLogin4,
            mnuiLogin5,
            mnuiLogin6,
            mnuiViewMembers1,
            mnuiViewMembers2,
            mnuiViewMembers3,
            mnuiViewMembers4,
            mnuiViewMembers5,
            mnuiViewMembers6,
            mnuiEditMembers1,
            mnuiEditMembers2,
            mnuiEditMembers3,
            mnuiEditMembers4,
            mnuiEditMembers5,
            mnuiEditMembers6,
            mnuiDeleteMembers1,
            mnuiDeleteMembers2,
            mnuiDeleteMembers3,
            mnuiDeleteMembers4,
            mnuiDeleteMembers5,
            mnuiDeleteMembers6;

    //Declaration for menu JPanel that hold all JMenuBar for all 6 page.
    private JPanel pnlMenu1, pnlMenu2, pnlMenu3, pnlMenu4, pnlMenu5, pnlMenu6;

    //Declaration for Registration, also known as Regis.
    private JPanel pnlRegis1, pnlRegis2, pnlRegis3, pnlRegis4, pnlRegis5;
    private JLabel lblRegisMC, lblRegisDisc, lblRegisPass, lblRegisNote;
    private JTextField txtRegisMC, txtRegisDisc, txtRegisNotes;
    private JPasswordField pfRegisPass;
    private JButton btnRegisRegister;

    //Declaration for Login, also known as Login.
    private JPanel pnlLogin1, pnlLogin2, pnlLogin3;
    private JLabel lblLoginMc, lblLoginPassword;
    private JTextField txtLoginMc,pfLoginPassword;
    //private JPasswordField pfLoginPassword;
    private JButton btnLoginLogin;

    //Declaration for View Members, also known as VM.
    private JLabel lblVM_Search, lblVM_MC, lblVM_Disc, lblVM_Note;
    private JTextField txtVM_Search, txtVM_MC, txtVM_Disc, txtVM_Notes;
    private JPanel pnlVM_1, pnlVM_1A, pnlVM_2, pnlVM_3, pnlVM_4, pnlVM_5;
    private JButton btnVM_Search;

    //Declaration for Edit or Update Members, also known as EU.
    private JLabel lblEU_Search, lblEU_MC, lblEU_Disc, lblEU_Note, lblEU_Pass;
    private JTextField txtEU_Search, txtEU_MC, txtEU_Disc, txtEU_Notes;
    private JPasswordField pfEU_Pass;
    private JPanel pnlEU_1, pnlEU_1A, pnlEU_2, pnlEU_3, pnlEU_4, pnlEU_5, pnlEU_6;
    private JButton btnEU_Search, btnEU_Update;

    //Declaration for Delete Members, also known as DM.
    private JLabel lblDM_Search;
    private JComboBox cbDM_Search;
    private JPanel pnlDM_1, pnlDM_1A, pnlDM_2;
    private JButton btnDM_Delete;

    //Declaration for Multi Threaded MT.
    private int intInput1, intInput2, intResult;
    private static Boolean beginThread;
    private runnables runnable1 = new runnables();
    private runnables runnable2 = new runnables();
    private JLabel lblMT_Input1, lblMT_Input2;
    private JTextField txtMT_Input1, txtMT_Input2;
    private JPanel pnlMT_1, pnlMT_2, pnlMT_3;
    private JButton btnMT_Begin;

    //Declaration for CardLayout and Container.
    private CardLayout cLayout = new CardLayout(40, 40);
    private Container c;

    public nicecraft_staff_portal(String title) {

        super(title);
        addWindowListener(this);

        c = getContentPane();
        c.setLayout(cLayout);

        //Declaration for JMenuBar, JMenu and JItem for all 6 page
        mnubMain1 = new JMenuBar();
        mnubMain2 = new JMenuBar();
        mnubMain3 = new JMenuBar();
        mnubMain4 = new JMenuBar();
        mnubMain5 = new JMenuBar();
        mnubMain6 = new JMenuBar();

        mnuiRegistration1 = new JMenu("Register");
        mnuiRegistration1.addMenuListener(new topMenuListener());
        mnuiLogin1 = new JMenu("Login");
        mnuiLogin1.addActionListener(this);
        mnuiViewMembers1 = new JMenu("View Members");
        mnuiViewMembers1.addActionListener(this);
        mnuiEditMembers1 = new JMenu("Edit Members");
        mnuiEditMembers1.addActionListener(this);
        mnuiDeleteMembers1 = new JMenu("Delete Member");
        mnuiDeleteMembers1.addActionListener(this);

        mnuiRegistration2 = new JMenu("Register");
        mnuiRegistration2.addMenuListener(new topMenuListener());
        mnuiLogin2 = new JMenu("Login");
        mnuiLogin2.addActionListener(this);
        mnuiViewMembers2 = new JMenu("View Members");
        mnuiViewMembers2.addActionListener(this);
        mnuiEditMembers2 = new JMenu("Edit Members");
        mnuiEditMembers2.addActionListener(this);
        mnuiDeleteMembers2 = new JMenu("Delete Member");
        mnuiDeleteMembers2.addActionListener(this);

        mnuiRegistration3 = new JMenu("Register");
        mnuiRegistration3.addMenuListener(new topMenuListener());
        mnuiLogin3 = new JMenu("Login");
        mnuiLogin3.addActionListener(this);
        mnuiViewMembers3 = new JMenu("View Members");
        mnuiViewMembers3.addActionListener(this);
        mnuiEditMembers3 = new JMenu("Edit Members");
        mnuiEditMembers3.addActionListener(this);
        mnuiDeleteMembers3 = new JMenu("Delete Member");
        mnuiDeleteMembers3.addActionListener(this);

        mnuiRegistration4 = new JMenu("Register");
        mnuiRegistration4.addMenuListener(new topMenuListener());
        mnuiLogin4 = new JMenu("Login");
        mnuiLogin4.addActionListener(this);
        mnuiViewMembers4 = new JMenu("View Members");
        mnuiViewMembers4.addActionListener(this);
        mnuiEditMembers4 = new JMenu("Edit Members");
        mnuiEditMembers4.addActionListener(this);
        mnuiDeleteMembers4 = new JMenu("Delete Member");
        mnuiDeleteMembers4.addActionListener(this);

        mnuiRegistration4 = new JMenu("Register");
        mnuiRegistration4.addMenuListener(new topMenuListener());
        mnuiLogin4 = new JMenu("Login");
        mnuiLogin4.addActionListener(this);
        mnuiViewMembers4 = new JMenu("View Members");
        mnuiViewMembers4.addActionListener(this);
        mnuiEditMembers4 = new JMenu("Edit Members");
        mnuiEditMembers4.addActionListener(this);
        mnuiDeleteMembers4 = new JMenu("Delete Member");
        mnuiDeleteMembers4.addActionListener(this);

        mnuiRegistration5 = new JMenu("Register");
        mnuiRegistration5.addMenuListener(new topMenuListener());
        mnuiLogin5 = new JMenu("Login");
        mnuiLogin5.addActionListener(this);
        mnuiViewMembers5 = new JMenu("View Members");
        mnuiViewMembers5.addActionListener(this);
        mnuiEditMembers5 = new JMenu("Edit Members");
        mnuiEditMembers5.addActionListener(this);
        mnuiDeleteMembers5 = new JMenu("Delete Member");
        mnuiDeleteMembers5.addActionListener(this);

        mnuiRegistration6 = new JMenu("Register");
        mnuiRegistration6.addMenuListener(new topMenuListener());
        mnuiLogin6 = new JMenu("Login");
        mnuiLogin6.addActionListener(this);
        mnuiViewMembers6 = new JMenu("View Members");
        mnuiViewMembers6.addActionListener(this);
        mnuiEditMembers6 = new JMenu("Edit Members");
        mnuiEditMembers6.addActionListener(this);
        mnuiDeleteMembers6 = new JMenu("Delete Member");
        mnuiDeleteMembers6.addActionListener(this);

        //Add JMenu to JMenuBar and assign JMenu to it's Action Litener for all 6 pages.
        mnubMain1.add(mnuiRegistration1);
        mnubMain1.add(mnuiLogin1);
        mnubMain1.add(mnuiViewMembers1);
        mnubMain1.add(mnuiEditMembers1);
        mnubMain1.add(mnuiDeleteMembers1);

        mnubMain2.add(mnuiRegistration2);
        mnubMain2.add(mnuiLogin2);
        mnubMain2.add(mnuiViewMembers2);
        mnubMain2.add(mnuiEditMembers2);
        mnubMain2.add(mnuiDeleteMembers2);

        mnubMain3.add(mnuiRegistration3);
        mnubMain3.add(mnuiLogin3);
        mnubMain3.add(mnuiViewMembers3);
        mnubMain3.add(mnuiEditMembers3);
        mnubMain3.add(mnuiDeleteMembers3);

        mnubMain4.add(mnuiRegistration4);
        mnubMain4.add(mnuiLogin4);
        mnubMain4.add(mnuiViewMembers4);
        mnubMain4.add(mnuiEditMembers4);
        mnubMain4.add(mnuiDeleteMembers4);

        mnubMain5.add(mnuiRegistration5);
        mnubMain5.add(mnuiLogin5);
        mnubMain5.add(mnuiViewMembers5);
        mnubMain5.add(mnuiEditMembers5);
        mnubMain5.add(mnuiDeleteMembers5);

        mnubMain6.add(mnuiRegistration6);
        mnubMain6.add(mnuiLogin6);
        mnubMain6.add(mnuiViewMembers6);
        mnubMain6.add(mnuiEditMembers6);
        mnubMain6.add(mnuiDeleteMembers6);

        //The border for Registraion.
        javax.swing.border.Border borderRegistration = BorderFactory.createTitledBorder("Regristration");

        pnlRegistration = new JPanel(); //Large panel for the sole purpose of Border "Registration".
        pnlRegistration.setBorder(borderRegistration);
        pnlRegistration.setLayout(new GridLayout(6, 0, 20, 15)); //GridLayout is set to 6 row

        pnlMenu1 = new JPanel(); //The JMenu buttons
        pnlMenu1.setLayout(new GridLayout(1, 1, 15, 15));
        pnlMenu1.add(mnubMain1);

        //JLabel and JTextField for first row
        lblRegisMC = new JLabel("Minecraft IGN");
        txtRegisMC = new JTextField("", 16);
        pnlRegis1 = new JPanel();
        pnlRegis1.setLayout(new GridLayout(1, 2, 15, 15));
        pnlRegis1.add(lblRegisMC);
        pnlRegis1.add(txtRegisMC);

        //JLabel and JTextField for second row
        lblRegisDisc = new JLabel("Discord");
        txtRegisDisc = new JTextField("");
        pnlRegis2 = new JPanel();
        pnlRegis2.setLayout(new GridLayout(1, 2, 15, 15));
        pnlRegis2.add(lblRegisDisc);
        pnlRegis2.add(txtRegisDisc);

        //JLabel and JPasswordField for third row
        lblRegisPass = new JLabel("Password");
        pfRegisPass = new JPasswordField("");
        pnlRegis3 = new JPanel();
        pnlRegis3.setLayout(new GridLayout(1, 3, 15, 15));
        pnlRegis3.add(lblRegisPass);
        pnlRegis3.add(pfRegisPass);

        //JLabel and JTextField for forth row
        lblRegisNote = new JLabel("Additional notes");
        txtRegisNotes = new JTextField("");
        pnlRegis4 = new JPanel();
        pnlRegis4.setLayout(new GridLayout(1, 2, 15, 15));
        pnlRegis4.add(lblRegisNote);
        pnlRegis4.add(txtRegisNotes);

        //JButton for fifth row
        btnRegisRegister = new JButton("Register");
        btnRegisRegister.addActionListener(this);
        pnlRegis5 = new JPanel();
        pnlRegis5.setLayout(new GridLayout(2, 1, 15, 15));
        pnlRegis5.add(btnRegisRegister);

        //All all the "mini-panel" to large panel.
        pnlRegistration.add(pnlMenu1);
        pnlRegistration.add(pnlRegis1);
        pnlRegistration.add(pnlRegis2);
        pnlRegistration.add(pnlRegis3);
        pnlRegistration.add(pnlRegis4);
        pnlRegistration.add(pnlRegis5);

        //The border for Login.
        javax.swing.border.Border borderLogin = BorderFactory.createTitledBorder("Login");

        pnlLogin = new JPanel(); //Large panel for the sole purpose of Border "Registration".
        pnlLogin.setBorder(borderLogin);
        pnlLogin.setLayout(new GridLayout(4, 0, 15, 15));

        pnlMenu2 = new JPanel();
        pnlMenu2.setLayout(new GridLayout(1, 1, 15, 15));
        pnlMenu2.add(mnubMain2);

        lblLoginMc = new JLabel("Your Minecraft or Discord");
        txtLoginMc = new JTextField("");
        pnlLogin1 = new JPanel();
        pnlLogin1.setLayout(new GridLayout(1, 2, 15, 15));
        pnlLogin1.add(lblLoginMc);
        pnlLogin1.add(txtLoginMc);

        lblLoginPassword = new JLabel("Password");
        pfLoginPassword = new JTextField("");
        pnlLogin2 = new JPanel();
        pnlLogin2.setLayout(new GridLayout(1, 2, 15, 15));
        pnlLogin2.add(lblLoginPassword);
        pnlLogin2.add(pfLoginPassword);

        btnLoginLogin = new JButton("Login");
        btnLoginLogin.addActionListener(this);
        pnlLogin3 = new JPanel();
        pnlLogin3.setLayout(new GridLayout(2, 1, 15, 15));
        pnlLogin3.add(btnLoginLogin);

        pnlLogin.add(pnlMenu2);
        pnlLogin.add(pnlLogin1);
        pnlLogin.add(pnlLogin2);
        pnlLogin.add(pnlLogin3);

        //The border for View Members.
        javax.swing.border.Border borderViewMembers = BorderFactory.createTitledBorder("View Members Information");

        pnlViewMembers = new JPanel(); //Large panel for the sole purpose of Border "View Members Information".
        pnlViewMembers.setBorder(borderViewMembers);
        pnlViewMembers.setLayout(new GridLayout(7, 0, 20, 15));

        pnlMenu3 = new JPanel();
        pnlMenu3.setLayout(new GridLayout(1, 1, 15, 15));
        pnlMenu3.add(mnubMain3);

        lblVM_Search = new JLabel("Search Minecraft IGN");
        txtVM_Search = new JTextField("");
        pnlVM_1 = new JPanel();
        pnlVM_1.setLayout(new GridLayout(1, 2, 15, 15));
        pnlVM_1.add(lblVM_Search);
        pnlVM_1.add(txtVM_Search);

        pnlVM_1A = new JPanel();
        btnVM_Search = new JButton("Search Username");
        btnVM_Search.addActionListener(this);
        pnlVM_1A.setLayout(new GridLayout(1, 1, 15, 15));
        pnlVM_1A.add(btnVM_Search);

        lblVM_MC = new JLabel("Minecraft IGN: ");
        txtVM_MC = new JTextField("");
        txtVM_MC.disable();
        pnlVM_2 = new JPanel();
        pnlVM_2.setLayout(new GridLayout(1, 2, 15, 15));
        pnlVM_2.add(lblVM_MC);
        pnlVM_2.add(txtVM_MC);

        lblVM_Disc = new JLabel("Discord: ");
        txtVM_Disc = new JTextField("");
        txtVM_Disc.disable();
        pnlVM_3 = new JPanel();
        pnlVM_3.setLayout(new GridLayout(1, 2, 15, 15));
        pnlVM_3.add(lblVM_Disc);
        pnlVM_3.add(txtVM_Disc);

        lblVM_Note = new JLabel("Additional Notes:");
        txtVM_Notes = new JTextField("");
        txtVM_Notes.disable();
        pnlVM_4 = new JPanel();
        pnlVM_4.setLayout(new GridLayout(1, 2, 15, 15));
        pnlVM_4.add(lblVM_Note);
        pnlVM_4.add(txtVM_Notes);

        pnlVM_5 = new JPanel();
        pnlVM_5.setLayout(new GridLayout(2, 1, 15, 15));

        pnlViewMembers.add(pnlMenu3);
        pnlViewMembers.add(pnlVM_1);
        pnlViewMembers.add(pnlVM_1A);
        pnlViewMembers.add(pnlVM_2);
        pnlViewMembers.add(pnlVM_3);
        pnlViewMembers.add(pnlVM_4);
        pnlViewMembers.add(pnlVM_5);

        //The border for Edit or Update Members.
        javax.swing.border.Border borderEditUpdateMembers = BorderFactory.createTitledBorder("Edit or Update Members Information");

        pnlEditMembers = new JPanel(); //Large panel for the sole purpose of Border "Edit Members Information".
        pnlEditMembers.setBorder(borderEditUpdateMembers);
        pnlEditMembers.setLayout(new GridLayout(8, 0, 20, 15));

        pnlMenu4 = new JPanel();
        pnlMenu4.setLayout(new GridLayout(1, 1, 15, 15));
        pnlMenu4.add(mnubMain4);

        lblEU_Search = new JLabel("Search Minecraft IGN");
        txtEU_Search = new JTextField("");
        pnlEU_1 = new JPanel();
        pnlEU_1.setLayout(new GridLayout(1, 2, 15, 15));
        pnlEU_1.add(lblEU_Search);
        pnlEU_1.add(txtEU_Search);

        btnEU_Search = new JButton("Search");
        btnEU_Search.addActionListener(this);
        pnlEU_1A = new JPanel();
        pnlEU_1A.setLayout(new GridLayout(1, 1, 15, 15));
        pnlEU_1A.add(btnEU_Search);

        lblEU_MC = new JLabel("Minecraft IGN: ");
        txtEU_MC = new JTextField("");
        txtEU_MC.disable();
        pnlEU_2 = new JPanel();
        pnlEU_2.setLayout(new GridLayout(1, 2, 15, 15));
        pnlEU_2.add(lblEU_MC);
        pnlEU_2.add(txtEU_MC);

        lblEU_Disc = new JLabel("Discord: ");
        txtEU_Disc = new JTextField("");
        pnlEU_3 = new JPanel();
        pnlEU_3.setLayout(new GridLayout(1, 2, 15, 15));
        pnlEU_3.add(lblEU_Disc);
        pnlEU_3.add(txtEU_Disc);

        lblEU_Note = new JLabel("Additional Notes:");
        txtEU_Notes = new JTextField("");
        pnlEU_4 = new JPanel();
        pnlEU_4.setLayout(new GridLayout(1, 2, 15, 15));
        pnlEU_4.add(lblEU_Note);
        pnlEU_4.add(txtEU_Notes);

        lblEU_Pass = new JLabel("Password:");
        pfEU_Pass = new JPasswordField("");
        pnlEU_5 = new JPanel();
        pnlEU_5.setLayout(new GridLayout(1, 2, 15, 15));
        pnlEU_5.add(lblEU_Pass);
        pnlEU_5.add(pfEU_Pass);

        btnEU_Update = new JButton("Update");
        btnEU_Update.addActionListener(this);
        btnEU_Update.setVisible(false);
        pnlEU_6 = new JPanel();
        pnlEU_6.setLayout(new GridLayout(1, 2, 15, 15));
        pnlEU_6.add(btnEU_Update);

        pnlEditMembers.add(pnlMenu4);
        pnlEditMembers.add(pnlEU_1);
        pnlEditMembers.add(pnlEU_1A);
        pnlEditMembers.add(pnlEU_2);
        pnlEditMembers.add(pnlEU_3);
        pnlEditMembers.add(pnlEU_4);
        pnlEditMembers.add(pnlEU_5);
        pnlEditMembers.add(pnlEU_6);

        //The border for Delete Members.
        javax.swing.border.Border borderDeleteMembers = BorderFactory.createTitledBorder("Delete Members Information");

        pnlDeleteMembers = new JPanel(); //Large panel for the sole purpose of Border "Delete Members Information".
        pnlDeleteMembers.setBorder(borderDeleteMembers);
        pnlDeleteMembers.setLayout(new GridLayout(4, 0, 20, 15));

        pnlMenu5 = new JPanel();
        pnlMenu5.setLayout(new GridLayout(1, 0, 15, 15));
        pnlMenu5.add(mnubMain5);

        lblDM_Search = new JLabel("Search Minecraft IGN");
        cbDM_Search = new JComboBox();
        pnlDM_1 = new JPanel();
        pnlDM_1.setLayout(new GridLayout(1, 1, 15, 15));
        pnlDM_1.add(lblDM_Search);
        pnlDM_1.add(cbDM_Search);

        btnDM_Delete = new JButton("Delete");
        btnDM_Delete.addActionListener(this);
        pnlDM_2 = new JPanel();
        pnlDM_2.setLayout(new GridLayout(1, 0, 5, 5));
        pnlDM_2.add(btnDM_Delete);

        pnlDeleteMembers.add(pnlMenu5);
        pnlDeleteMembers.add(pnlDM_1);
        pnlDeleteMembers.add(pnlDM_2);

        //The border for Delete Members.
        javax.swing.border.Border borderThreaded = BorderFactory.createTitledBorder("Multi Threaded");

        pnlThreaded = new JPanel(); //Large panel for the sole purpose of Border "Delete Members Information".
        pnlThreaded.setBorder(borderThreaded);
        pnlThreaded.setLayout(new GridLayout(4, 0, 20, 15));

        pnlMenu6 = new JPanel();
        pnlMenu6.setLayout(new GridLayout(1, 1, 15, 15));
        pnlMenu6.add(mnubMain6);

        lblMT_Input1 = new JLabel("Input number 1");
        txtMT_Input1 = new JTextField("");
        pnlMT_1 = new JPanel();
        pnlMT_1.setLayout(new GridLayout(1, 2, 15, 15));
        pnlMT_1.add(lblMT_Input1);
        pnlMT_1.add(txtMT_Input1);

        lblMT_Input2 = new JLabel("Input number 2");
        txtMT_Input2 = new JTextField("");
        pnlMT_2 = new JPanel();
        pnlMT_2.setLayout(new GridLayout(1, 2, 15, 15));
        pnlMT_2.add(lblMT_Input2);
        pnlMT_2.add(txtMT_Input2);

        btnMT_Begin = new JButton("Begin");
        btnMT_Begin.addActionListener(this);
        pnlMT_3 = new JPanel();
        pnlMT_3.setLayout(new GridLayout(1, 0, 15, 15));
        pnlMT_3.add(btnMT_Begin);

        pnlThreaded.add(pnlMenu6);
        pnlThreaded.add(pnlMT_1);
        pnlThreaded.add(pnlMT_2);
        pnlThreaded.add(pnlMT_3);

        c.add("Register", pnlRegistration);
        c.add("Login", pnlLogin);
        c.add("ViewMembers", pnlViewMembers);
        c.add("EditMembers", pnlEditMembers);
        c.add("DeleteMembers", pnlDeleteMembers);
        c.add("MultiThreaded", pnlThreaded);
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        dispose();
        System.exit(0);
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnRegisRegister) {
            
             /*EXPLAINATION:
            basically the sql statement that will login into nicecraft using the name root and password empty.
            the sql statement is insert mcIGN, mcDiscord, mcPassword and mcNotes from JTextField to the database. */
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/nicecraft", "root", "");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("insert into nicecraft ("
                        + "mcIGN, "
                        + "mcDiscord, "
                        + "mcPassword, "
                        + "mcNotes) VALUES ('"
                        + txtRegisMC.getText() + "', '"
                        + txtRegisDisc.getText() + "', '"
                        + pfRegisPass.getText() + "', '"
                        + txtRegisNotes.getText() + "');");

                // After the registration, there will be a println message stating that you have registered successfully.
                JFrame jfSuccess = new JFrame();
                JOptionPane.showMessageDialog(jfSuccess,"Successfully registered user to our database!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                
                //Replace the existing TextBox to empty.
                txtRegisMC.setText("");
                txtRegisDisc.setText("");
                pfRegisPass.setText("");
                txtRegisNotes.setText("");
                
                con.close();
            } catch (SQLIntegrityConstraintViolationException ex) {
                //This is a catch exception i have encountered upon testing, if the minecraft ign has already been registered.
                //This error message will show up, the primary key is IGN, so there can be no same primary key.
                JFrame jfError = new JFrame();
                JOptionPane.showMessageDialog(jfError,"This Minecraft IGN already exist in our database, please login instead.", "Custom Error Message", JOptionPane.WARNING_MESSAGE);
            } catch (SQLDataException ex) {
                JFrame jfError = new JFrame();
                JOptionPane.showMessageDialog(jfError,"None of the TextField above should contains more than 16 word.", "Custom Error Message", JOptionPane.WARNING_MESSAGE);
            } catch (Exception ex) {
                JFrame jfError = new JFrame();
                JOptionPane.showMessageDialog(jfError,ex, "Default Error Message with Exception", JOptionPane.WARNING_MESSAGE);
            } 
                
        } else if (e.getSource() == btnLoginLogin) {

            Boolean valid = false;

            /*EXPLAINATION:
                Okay this is pretty straight forward, what the sql statement will do is it will obtain information of mcIGN and mcPassword
                from the database, where it matches the txtLoginMc JTextField and pfLoginPassword JPasswordField.
             */
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/nicecraft", "root", "");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * "
                        + "from nicecraft where "
                        + "mcIGN=\'" + txtLoginMc.getText() + "\' and "
                        + "mcPassword=\'" + pfLoginPassword.getText() + "\';");

                while (rs.next()) {

                    if (rs.getString(1) == txtLoginMc.getText() && rs.getString(4) == pfLoginPassword.getText()) {
                        valid = false;
                        System.out.println("[False DEBUG] txtLoginMC (" + txtLoginMc.getText() + ") DB - mcIGN (" + rs.getString(1) + ") pfLoginPassword (" + pfLoginPassword.getText() + ") DB - mcPassword: (" + rs.getString(4) + ")");
                        JFrame jfError = new JFrame();
                        JOptionPane.showMessageDialog(jfError,"Incorrect Password", "Custom Error Message", JOptionPane.WARNING_MESSAGE);   
                    } else {
                        valid = true;
                        System.out.println("[True DEBUG] txtLoginMC (" + txtLoginMc.getText() + ") DB - mcIGN (" + rs.getString(1) + ") pfLoginPassword (" + pfLoginPassword.getText() + ") DB - mcPassword: (" + rs.getString(4) + ")");
                        JFrame jfSuccess = new JFrame();
                        JOptionPane.showMessageDialog(jfSuccess,"Successfully login", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);              }
                }

                con.close();
            } catch (SQLDataException ex) {
                JFrame jfError = new JFrame();
                JOptionPane.showMessageDialog(jfError,"None of the TextField above should contains more than 16 word.", "Custom Error Message", JOptionPane.WARNING_MESSAGE);
          } catch (Exception ex) {
                JFrame jfError = new JFrame();
                JOptionPane.showMessageDialog(jfError,ex, "Default Error Message with Exception", JOptionPane.WARNING_MESSAGE);
            }

        } else if (e.getSource() == btnVM_Search) {

            Boolean valid = false;

            /*EXPLAINATION:
                The search is pretty much similar to the login one as well, however, this time, instead of searching both mcIGN and
                mcPassword from the database and compare it with McIGN JTextField and pfLoginPassword JPasswordField, it only compare
                the Minecraft IGN JTextField with mcIGN, once they found a match, information will be displayed.
             */
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/nicecraft", "root", "");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select "
                        + "mcIGN,"
                        + "mcDiscord,"
                        + "mcNotes from nicecraft where "
                        + "mcIGN='" + txtVM_Search.getText() + "';");

                while (rs.next()) {
                    txtVM_MC.setText(rs.getString(1));
                    txtVM_Disc.setText(rs.getString(2));
                    txtVM_Notes.setText(rs.getString(3));
                    valid = true;
                }

                if (valid == true) {
                    JFrame jfSuccess = new JFrame();
                    JOptionPane.showMessageDialog(jfSuccess,"The Information has been displayed", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    //If the username does not exist in the database, it will return this custom error message which state that the user
                    //you have entered does not exist in the database
                    JFrame jfError = new JFrame();
                    JOptionPane.showMessageDialog(jfError,"This Minecraft does not exist in our database.", "Custom Error Message", JOptionPane.WARNING_MESSAGE);
                    txtVM_MC.setText("");
                    txtVM_Disc.setText("");
                    txtVM_Notes.setText("");
                }

                con.close();
            } catch (SQLDataException ex) {
                JFrame jfError = new JFrame();
                JOptionPane.showMessageDialog(jfError,"None of the TextField above should contains more than 16 word.", "Custom Error Message", JOptionPane.WARNING_MESSAGE);
          } catch (Exception ex) {
                JFrame jfError = new JFrame();
                JOptionPane.showMessageDialog(jfError,ex, "Default Error Message with Exception", JOptionPane.WARNING_MESSAGE);
            }

        } else if (e.getSource() == btnEU_Search) {

            Boolean valid = false;

            /*
                EXPLAINATION
                Once the user has typed in the a mcIGN with an existing member, their information will be displayed in the TextField
                
                If the mcIGN does not exist compared to JTextField information, then 4 JTextField (display result) will be changed to empty.
             */
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/nicecraft", "root", "");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select "
                        + "mcIGN,"
                        + "mcDiscord,"
                        + "mcNotes, "
                        + "mcPassword from nicecraft where "
                        + "mcIGN='" + txtEU_Search.getText() + "';");

                while (rs.next()) {
                    txtEU_MC.setText(rs.getString(1));
                    txtEU_Disc.setText(rs.getString(2));
                    txtEU_Notes.setText(rs.getString(3));
                    pfEU_Pass.setText(rs.getString(4));
                    valid = true;
                }

                if (valid == true) {
                    JFrame jfSuccess = new JFrame();
                    JOptionPane.showMessageDialog(jfSuccess,"The Information has been displayed", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                    btnEU_Update.setVisible(true);

                    /*
                    EXPLAINATION
                    
                    Additional constraint, users are only allowed to update users when they have searched the correct McIGN.
                    
                    Then only the Update button will be visible.
                    
                    This is to prevent users from updating people that they did not know exist in the database. 
                     */
                } else {
                    JFrame jfError = new JFrame();
                    JOptionPane.showMessageDialog(jfError,"This user name does not exist in our database", "Custom Error Message", JOptionPane.WARNING_MESSAGE);
                    txtEU_MC.setText("");
                    txtEU_Disc.setText("");
                    txtEU_Notes.setText("");
                    pfEU_Pass.setText("");
                    btnEU_Update.setVisible(false);
                }

                con.close();
            } catch (SQLDataException ex) {
                JFrame jfError = new JFrame();
                JOptionPane.showMessageDialog(jfError,"None of the TextField above should contains more than 16 word.", "Custom Error Message", JOptionPane.WARNING_MESSAGE);
          } catch (Exception ex) {
                JFrame jfError = new JFrame();
                JOptionPane.showMessageDialog(jfError,ex, "Default Error Message with Exception", JOptionPane.WARNING_MESSAGE);
            }
        } else if (e.getSource() == btnEU_Update) {

            /*
            EXPLAINATION
            This one is for users to edit database information after the Search button (edit member page)
                
            I have purposely made it so the users can't change the McIGN, which is the primary key.
                
            Or else, it will generate an unnecessary exception for the user (constraint).
            
            This uses the update sql statement to update from site to database.
             */
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/nicecraft", "root", "");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("update nicecraft set "
                        + "mcDiscord='" + txtEU_Disc.getText() + "',"
                        + "mcNotes='" + txtEU_Notes.getText() + "',"
                        + "mcPassword='" + pfEU_Pass.getText() + "' "
                        + "where mcIGN='" + txtEU_MC.getText() + "';");

                Boolean valid = true;

                if (valid == true) {
                    JFrame jfSuccess = new JFrame();
                    JOptionPane.showMessageDialog(jfSuccess,"The Information has been updated", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                } else {
                JFrame jfError = new JFrame();
                JOptionPane.showMessageDialog(jfError,"This Minecraft Username does not exist in our database!", "Custom Error Message", JOptionPane.WARNING_MESSAGE);
                }

                con.close();
            } catch (SQLDataException ex) {
                JFrame jfError = new JFrame();
                JOptionPane.showMessageDialog(jfError,"None of the TextField above should contains more than 16 word.", "Custom Error Message", JOptionPane.WARNING_MESSAGE);
          } catch (Exception ex) {
                JFrame jfError = new JFrame();
                JOptionPane.showMessageDialog(jfError,ex, "Default Error Message with Exception", JOptionPane.WARNING_MESSAGE);
            }

        } else if (e.getSource() == btnDM_Delete) {

            /*
            EXPLAINATION
            
            Once the user have refreshed the combo box and selected a mcIGN to be deleted, all they have to do is click the Delete
            
            Button and the user will be deleted.
            
            In this sql statement i uses delete and where, basically delete the database information of selected McIGN user.
             */
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/nicecraft", "root", "");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("delete from nicecraft where "
                        + "mcIGN='" + cbDM_Search.getSelectedItem() + "';");
                JFrame jfSuccess = new JFrame();
                JOptionPane.showMessageDialog(jfSuccess,"The Minecraft username has been deleted", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                cbDM_Search.removeAllItems();

                con.close();
            } catch (SQLDataException ex) {
                JFrame jfError = new JFrame();
                JOptionPane.showMessageDialog(jfError,"None of the TextField above should contains more than 16 word.", "Custom Error Message", JOptionPane.WARNING_MESSAGE);
          } catch (Exception ex) {
                JFrame jfError = new JFrame();
                JOptionPane.showMessageDialog(jfError,ex, "Default Error Message with Exception", JOptionPane.WARNING_MESSAGE);
            }

        } else if (e.getSource() == btnMT_Begin) {

            /*
            EXPLAINATION 
            
            This one is for the multi-thread part of the assignment, basically, after a user type in 2 different integer (time) and click on Begin
            
            beginThread = true meaning the code in Static void main string will run. Both time will be depends on user input of first and second
            
            JTextField.
             */            
            intInput1 = Integer.parseInt(txtMT_Input1.getText());
            intInput2 = Integer.parseInt(txtMT_Input2.getText());
            
            try {
            
            Thread firstThread = new Thread(runnable1);
            firstThread.start();

            Thread secondThread = new Thread(runnable2);
            secondThread.start();
            
            } catch (Exception ex) {
                JFrame jfError = new JFrame();
                JOptionPane.showMessageDialog(jfError,ex, "Default Error Message with Exception", JOptionPane.WARNING_MESSAGE);
            }

        }
    }

    void updatecB() {

        
            /*
            EXPLAINATION
            
            I believe this is one of the most efficient way to select members to delete, it will remove the need for (this user does not exist) error
            
            Basically what this sql statement does is when you click on the refresh button, it will select all the mcIGN from database.
            
            Then when ResultSet is running, it will add it to the ComboBox one by one until it end.
            
            That way, user can select mcIGN to be deleted from the ComboBox
             */
            
            cbDM_Search.removeAllItems();
            
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/nicecraft", "root", "");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select mcIGN from nicecraft;");

                while (rs.next()) {
                    cbDM_Search.addItem(rs.getString(1));
                }

                con.close();

            } catch (SQLDataException ex) {
                JFrame jfError = new JFrame();
                JOptionPane.showMessageDialog(jfError,"None of the TextField above should contains more than 16 word.", "Custom Error Message", JOptionPane.WARNING_MESSAGE);
          } catch (Exception ex) {
                JFrame jfError = new JFrame();
                JOptionPane.showMessageDialog(jfError,ex, "Default Error Message with Exception", JOptionPane.WARNING_MESSAGE);
            }
            
    }
    class topMenuListener implements MenuListener {

        @Override
        public void menuSelected(MenuEvent me) {
            if (me.getSource() == mnuiRegistration1) {
                //cLayout.show(c,"Register");
                cLayout.next(c);
            } else if (me.getSource() == mnuiLogin1) {
                cLayout.next(c);
            } else if (me.getSource() == mnuiViewMembers1) {
                cLayout.next(c);
            } else if (me.getSource() == mnuiEditMembers1) {
                cLayout.next(c);
            } else if (me.getSource() == mnuiDeleteMembers1) {
                cLayout.next(c);
            } else if (me.getSource() == mnuiRegistration2) {
                cLayout.next(c);
            } else if (me.getSource() == mnuiLogin2) {
                cLayout.next(c);
            } else if (me.getSource() == mnuiViewMembers2) {
                cLayout.next(c);
            } else if (me.getSource() == mnuiEditMembers2) {
                cLayout.next(c);
            } else if (me.getSource() == mnuiDeleteMembers2) {
                cLayout.next(c);
            } else if (me.getSource() == mnuiRegistration3) {
                cLayout.next(c);
            } else if (me.getSource() == mnuiLogin3) {
                cLayout.next(c);
            } else if (me.getSource() == mnuiViewMembers3) {
                cLayout.next(c);
            } else if (me.getSource() == mnuiEditMembers3) {
                cLayout.next(c);
            } else if (me.getSource() == mnuiDeleteMembers3) {
                cLayout.next(c);
            } else if (me.getSource() == mnuiRegistration4) {
                cLayout.next(c);
                updatecB();
            } else if (me.getSource() == mnuiLogin4) {
                cLayout.next(c);
                updatecB();
            } else if (me.getSource() == mnuiViewMembers4) {
                cLayout.next(c);
                updatecB();
            } else if (me.getSource() == mnuiEditMembers4) {
                cLayout.next(c);
                updatecB();
            } else if (me.getSource() == mnuiDeleteMembers4) {
                cLayout.next(c);
            } else if (me.getSource() == mnuiRegistration5) {
                cLayout.next(c);
            } else if (me.getSource() == mnuiLogin5) {
                cLayout.next(c);
            } else if (me.getSource() == mnuiViewMembers5) {
                cLayout.next(c);
            } else if (me.getSource() == mnuiEditMembers5) {
                cLayout.next(c);
            } else if (me.getSource() == mnuiDeleteMembers5) {
                cLayout.next(c);
            } else if (me.getSource() == mnuiRegistration6) {
                cLayout.next(c);
            } else if (me.getSource() == mnuiLogin6) {
                cLayout.next(c);
            } else if (me.getSource() == mnuiViewMembers6) {
                cLayout.next(c);
            } else if (me.getSource() == mnuiEditMembers6) {
                cLayout.next(c);
            } else if (me.getSource() == mnuiDeleteMembers6) {
                cLayout.next(c);
            }
        }

        @Override
        public void menuDeselected(MenuEvent me) {
        }

        @Override
        public void menuCanceled(MenuEvent me) {
        }
    }

    public class runnables implements Runnable {

        @Override
        public void run() {
            for (int i = intInput1; i < intInput2; i++) {
                System.out.println(Thread.currentThread().getName() + "\n[THREAD - 1] = " + i);
                                try {
                    Thread.sleep(intInput1);
                } catch (Exception ex) {
                    JFrame jfError = new JFrame();
                    JOptionPane.showMessageDialog(jfError,ex, "Default Error Message with Exception", JOptionPane.WARNING_MESSAGE);
                    }

            }
            
            intResult = intInput1 + intInput2;
            System.out.println("[TOTAL RESULT] = " + intResult);
        }

    }

    public static void main(String[] args) {
         
        nicecraft_staff_portal software;
        software = new nicecraft_staff_portal("NiceCraft Staff Portal");
        software.setSize(1000, 800);
        software.setVisible(true);
    }

}
