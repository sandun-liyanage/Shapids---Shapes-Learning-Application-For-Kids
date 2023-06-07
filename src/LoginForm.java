import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import java.awt.event.ActionEvent;
import java.util.prefs.Preferences;

public class LoginForm extends JFrame implements ComponentListener {
    static JFrame frame;
    private JLabel lblTitle, lblBackground, lblEmail, lblPassword, lblImage, lblImage2;
    private JTextField txtEmail;
    private JPasswordField txtPassword;
    private JButton btnSubmit, btnBack;
    int fwidth, fheight;
    public Home home;


    public LoginForm() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addComponentListener(this);
        this.getContentPane().setBackground(Color.decode("#9ADCFF"));
        this.setSize(1400, 800);
        this.setLayout(null);

        lblTitle = new Utils.RoundedLabel("Sign In");
        lblTitle.setBackground(Color.decode("#C67ACE"));
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblTitle);


        lblEmail = new Utils.RoundedLabel("Email");
        lblEmail.setBackground(Color.decode("#fcacc5"));
        lblEmail.setForeground(Color.WHITE);
        lblEmail.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        add(lblEmail);

        lblPassword = new Utils.RoundedLabel("Password");
        lblPassword.setBackground(Color.decode("#fcacc5"));
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        add(lblPassword);


        txtEmail = new JTextField("");
        txtEmail.setBackground(Color.WHITE);
        txtEmail.setForeground(Color.BLACK);
        txtEmail.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        add(txtEmail);

        txtPassword = new JPasswordField();
        txtPassword.setBackground(Color.WHITE);
        txtPassword.setForeground(Color.BLACK);
        txtPassword.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        add(txtPassword);

        btnSubmit = new Utils.RoundedButton("Submit");
        btnSubmit.setBackground(Color.decode("#4e6cd9"));
        btnSubmit.setForeground(Color.WHITE);
        btnSubmit.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        btnSubmit.setHorizontalAlignment(SwingConstants.CENTER);
        add(btnSubmit);

        btnBack = new Utils.RoundedButton("<html><center>Back</center></html>");
        btnBack.setBackground(Color.decode("#E6B325"));
        btnBack.setForeground(Color.WHITE);
        btnBack.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        btnBack.setHorizontalAlignment(SwingConstants.CENTER);
        add(btnBack);

        ImageIcon imageIcon = new ImageIcon("images/login1.png");
        lblImage = new JLabel();
        lblImage.setIcon(imageIcon);
        getContentPane().add(lblImage);

        ImageIcon imageIcon2 = new ImageIcon("images/login2.png");
        lblImage2 = new JLabel();
        lblImage2.setIcon(imageIcon2);
        getContentPane().add(lblImage2);

        lblBackground = new Utils.RoundedLabel("");
        lblBackground.setBackground(Color.decode("#fcacc5"));
        lblBackground.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblBackground);


        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Preferences prefs = Preferences.userNodeForPackage(LoginForm.class);

                String email = txtEmail.getText();
                String password = new String(txtPassword.getPassword());

                // Perform validation and save user data
                if (Objects.equals(email, "") || password.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter all fields", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    //JOptionPane.showMessageDialog(panel, "Signup successful!");

                    String userEmail = prefs.get("user.email", "Unknown");
                    String userPassword = prefs.get("user.password", "Unknown");

                    if (Objects.equals(userEmail, email) && Objects.equals(userPassword, password)) {
                        home = new Home();
                        LoginForm.this.setVisible(false);
                        home.setVisible(true);
                    } else if (!Objects.equals(userEmail, email) && Objects.equals(userPassword, password)) {
                        JOptionPane.showMessageDialog(null, "Invalid Email. Please Try again!", "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (Objects.equals(userEmail, email) && !Objects.equals(userPassword, password)) {
                        JOptionPane.showMessageDialog(null, "Invalid Password. Please Try again!", "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (!Objects.equals(userEmail, email) && !Objects.equals(userPassword, password)) {
                        JOptionPane.showMessageDialog(null, "Invalid Email and Password. Please Try again!", "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (Objects.equals(email, "Unknown") || password.equals("Unknown")) {
                        JOptionPane.showMessageDialog(null, "This account does not exist. Please create an account.", "Error", JOptionPane.ERROR_MESSAGE);
                    }


                }
            }
        });

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Welcome();
            }
        });

        setVisible(true);
    }

    @Override
    public void componentResized(ComponentEvent e) {
        fwidth = this.getWidth();
        fheight = this.getHeight();

        lblBackground.setBounds((fwidth / 2) - 500, (fheight / 8), 1000, 600);

        lblTitle.setBounds((fwidth / 2) - 100, (fheight / 8) - 30, 250, 100);


        lblEmail.setBounds((fwidth / 4), (3 * fheight / 8) - 10, 200, 70);
        lblPassword.setBounds((fwidth / 4), (4 * fheight / 8), 200, 70);


        txtEmail.setBounds((fwidth / 4) + 300, (3 * fheight / 8) - 10, 350, 50);
        txtPassword.setBounds((fwidth / 4) + 300, (4 * fheight / 8), 350, 50);


        lblImage.setBounds((3 * fwidth / 4) - 200, (2 * fheight / 8) - 200, 300, 300);
        lblImage2.setBounds((3 * fwidth / 4) - 900, (2 * fheight / 8) + 200, 300, 300);

        btnSubmit.setBounds((fwidth / 2) - 100, (6 * fheight / 8) - 100, 200, 70);

        btnBack.setBounds((fwidth / 4) - 325, 20, 150, 100);
    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }

    public static void main(String[] args) {

        LoginForm loginForm = new LoginForm();

        frame.add(loginForm);
        frame.setSize(1400, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
