import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class Welcome extends JFrame implements ComponentListener, ActionListener {
    int fwidth, fheight;
    static JFrame frame;
    JButton btnSignIn, btnSignUp;
    JLabel lblMainTitle, lblSubTitle, lblImage1, lblImage2, lblImage3;

    public Welcome() {
        super("Shapids");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addComponentListener(this);
        this.getContentPane().setBackground(Color.decode("#9ADCFF"));
        this.setSize(1400, 800);

        lblMainTitle = new JLabel("<html><center>Welcome to Shapids!<br><i><h1>Shape up your learning adventure with fun and interactive shapes!</h1></i></center></html>");
        lblMainTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 60));
        lblMainTitle.setForeground(Color.decode("#544179"));
        add(lblMainTitle);

        lblSubTitle = new JLabel("<html><center><i>Create Your Free Account by clicking the Sign Up button<br>If you already have an account click the Login button</i></center></html>");
        lblSubTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
        lblSubTitle.setForeground(Color.decode("#A12568"));
        add(lblSubTitle);

        btnSignIn = new Utils.RoundedButton("<html><center>Login</center></html>");
        btnSignIn.setBackground(Color.decode("#FF8AAE"));
        btnSignIn.setForeground(Color.WHITE);
        btnSignIn.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
        btnSignIn.setHorizontalAlignment(SwingConstants.CENTER);
        btnSignIn.addActionListener(this);
        add(btnSignIn);

        btnSignUp = new Utils.RoundedButton("<html><center>Signup</center></html>");
        btnSignUp.setBackground(Color.decode("#FF8AAE"));
        btnSignUp.setForeground(Color.WHITE);
        btnSignUp.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
        btnSignUp.setHorizontalAlignment(SwingConstants.CENTER);
        btnSignUp.addActionListener(this);
        add(btnSignUp);

        ImageIcon imageIcon1 = new ImageIcon("images/kids.png");
        lblImage1 = new JLabel();
        lblImage1.setIcon(imageIcon1);
        getContentPane().add(lblImage1);

        ImageIcon imageIcon2 = new ImageIcon("images/welcome2.png");
        lblImage2 = new JLabel();
        lblImage2.setIcon(imageIcon2);
        getContentPane().add(lblImage2);

        ImageIcon imageIcon3 = new ImageIcon("images/paperplanekids.png");
        lblImage3 = new JLabel();
        lblImage3.setIcon(imageIcon3);
        getContentPane().add(lblImage3);


        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSignIn) {
            this.setVisible(false);
            new LoginForm();
        } else if (e.getSource() == btnSignUp) {
            this.setVisible(false);
            new SignupForm();
        }
    }

    @Override
    public void componentResized(ComponentEvent e) {
        fwidth = this.getWidth();
        fheight = this.getHeight();

        lblImage1.setBounds(350, 100, 800, 500);
        lblImage2.setBounds(fwidth - 410, 350, 400, 400);
        lblImage3.setBounds(fwidth - 1380, 50, 400, 500);

        lblMainTitle.setBounds((getWidth() - lblMainTitle.getPreferredSize().width) / 2,
                ((getHeight() - lblMainTitle.getPreferredSize().height) / 6)-50,
                lblMainTitle.getPreferredSize().width,
                lblMainTitle.getPreferredSize().height);

        lblSubTitle.setBounds(((getWidth() - lblSubTitle.getPreferredSize().width) / 2)-80,
                (3*(getHeight() - lblSubTitle.getPreferredSize().height) / 6)+150,
                lblSubTitle.getPreferredSize().width,
                lblSubTitle.getPreferredSize().height);

        btnSignIn.setBounds(((fwidth / 2) - 200) - 50, (3*fheight / 5)+150, 200, 80);
        btnSignUp.setBounds((fwidth / 2) -10, (3*fheight / 5)+150, 200, 80);
    }

    public static void main(String[] args) {

        Welcome welcome = new Welcome();

        frame.add(welcome);
        frame.setSize(1400, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
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
}
