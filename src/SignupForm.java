import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.util.Objects;
import java.util.prefs.Preferences;

public class SignupForm extends JFrame implements ComponentListener {
    static JFrame frame;
    private JPanel panel;
    private JLabel lblTitle, lblBackground, lblName, lblEmail, lblPassword, lblRepeatPassword, lblImage;
    private JTextField txtName, txtEmail;
    private JPasswordField txtPassword, txtRepeatPassword;
    private JButton btnSubmit, btnBack;
    int fwidth, fheight;
    public LoginForm login;

    public SignupForm() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addComponentListener(this);
        this.getContentPane().setBackground(Color.decode("#9ADCFF"));
        this.setSize(1400, 800);
        this.setLayout(null);

        lblTitle = new Utils.RoundedLabel("Sign Up");
        lblTitle.setBackground(Color.decode("#C67ACE"));
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblTitle);

        lblName = new Utils.RoundedLabel("Name");
        lblName.setBackground(Color.decode("#fcacc5"));
        lblName.setForeground(Color.WHITE);
        lblName.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        add(lblName);

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

        lblRepeatPassword = new Utils.RoundedLabel("Repeat Password");
        lblRepeatPassword.setBackground(Color.decode("#fcacc5"));
        lblRepeatPassword.setForeground(Color.WHITE);
        lblRepeatPassword.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        add(lblRepeatPassword);

        txtName = new JTextField("");
        txtName.setBackground(Color.WHITE);
        txtName.setForeground(Color.BLACK);
        txtName.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        add(txtName);

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

        txtRepeatPassword = new JPasswordField();
        txtRepeatPassword.setBackground(Color.WHITE);
        txtRepeatPassword.setForeground(Color.BLACK);
        txtRepeatPassword.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        add(txtRepeatPassword);

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

        ImageIcon imageIcon = new ImageIcon("images/mouse.png");
        lblImage = new JLabel();
        lblImage.setIcon(imageIcon);
        getContentPane().add(lblImage);

        lblBackground = new Utils.RoundedLabel("");
        lblBackground.setBackground(Color.decode("#fcacc5"));
        lblBackground.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblBackground);

        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Preferences prefs = Preferences.userNodeForPackage(SignupForm.class);

                String name = txtName.getText();
                String email = txtEmail.getText();
                String password = new String(txtPassword.getPassword());
                String repeatPassword = new String(txtRepeatPassword.getPassword());

                // Validating all fields
                if (Objects.equals(name, "") || Objects.equals(email, "") || password.equals("") || repeatPassword.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter all fields", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!password.equals(repeatPassword)) {
                    JOptionPane.showMessageDialog(null, "Passwords did not match. Please try again!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    //JOptionPane.showMessageDialog(panel, "Signup successful!");

                    prefs.put("user.name", name);
                    prefs.put("user.email", email);
                    prefs.put("user.password", password);

                    login = new LoginForm();
                    SignupForm.this.setVisible(false);
                    login.setVisible(true);
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

        lblName.setBounds((fwidth / 4), (2 * fheight / 8), 200, 70);
        lblEmail.setBounds((fwidth / 4), (3 * fheight / 8), 200, 70);
        lblPassword.setBounds((fwidth / 4), (4 * fheight / 8), 200, 70);
        lblRepeatPassword.setBounds((fwidth / 4), (5 * fheight / 8), 300, 70);

        txtName.setBounds((fwidth / 4) + 300, (2 * fheight / 8), 350, 50);
        txtEmail.setBounds((fwidth / 4) + 300, (3 * fheight / 8), 350, 50);
        txtPassword.setBounds((fwidth / 4) + 300, (4 * fheight / 8), 350, 50);
        txtRepeatPassword.setBounds((fwidth / 4) + 300, (5 * fheight / 8), 350, 50);

        lblImage.setBounds((3 * fwidth / 4), (2 * fheight / 8), 300, 400);

        btnSubmit.setBounds((fwidth / 2) - 100, (6 * fheight / 8), 200, 70);

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

        SignupForm signupForm = new SignupForm();

        frame.add(signupForm);
        frame.setSize(1400, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
