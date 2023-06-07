import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.geom.RoundRectangle2D;
import java.util.prefs.Preferences;

public class Home extends JFrame implements ComponentListener, ActionListener {
    int fwidth, fheight;
    static JFrame frame;
    JButton btnGrade1, btnGrade2, btnBack;
    JLabel lblMainTitle,lblImage1;

    public Home() {
        super("Shapids");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addComponentListener(this);
        this.getContentPane().setBackground(Color.decode("#9ADCFF"));
        this.setSize(1400, 800);

        Preferences prefs = Preferences.userNodeForPackage(Home.class);
        String username = prefs.get("user.name", "Unknown");

        lblMainTitle = new JLabel("<html><center>Hello " + username + "<br>Welcome to Shapids!</center></html>");
        lblMainTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 60));
        lblMainTitle.setForeground(Color.decode("#163dc9"));
        add(lblMainTitle);

        btnGrade1 = new Utils.RoundedButton("<html><center>Level<br>1</center></html>");
        btnGrade1.setBackground(Color.decode("#65D269"));
        btnGrade1.setForeground(Color.WHITE);
        btnGrade1.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
        btnGrade1.setHorizontalAlignment(SwingConstants.CENTER);
        btnGrade1.addActionListener(this);
        add(btnGrade1);

        btnGrade2 = new Utils.RoundedButton("<html><center>Level<br>2</center></html>");
        btnGrade2.setBackground(Color.decode("#F87474"));
        btnGrade2.setForeground(Color.WHITE);
        btnGrade2.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
        btnGrade2.setHorizontalAlignment(SwingConstants.CENTER);
        btnGrade2.addActionListener(this);
        add(btnGrade2);

        btnBack = new Utils.RoundedButton("<html><center>Back</center></html>");
        btnBack.setBackground(Color.decode("#E6B325"));
        btnBack.setForeground(Color.WHITE);
        btnBack.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        btnBack.setHorizontalAlignment(SwingConstants.CENTER);
        btnBack.addActionListener(this);
        add(btnBack);

        ImageIcon imageIcon = new ImageIcon("images/dog.png");
        lblImage1 = new JLabel();
        lblImage1.setIcon(imageIcon);
        getContentPane().add(lblImage1);

        this.setVisible(true);
    }

    public static void main(String[] args) {

        Home home = new Home();

        frame.add(home);
        frame.setSize(1400, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Preferences prefs = Preferences.userNodeForPackage(Home.class);

        if (e.getSource() == btnGrade1) {
            prefs.put("level", "Level1");
            this.setVisible(false);
            new HomeLevel1();
        } else if (e.getSource() == btnGrade2) {
            prefs.put("level", "Level2");
            this.setVisible(false);
            new Score();
        } else if (e.getSource() == btnBack) {
            this.setVisible(false);
            new Welcome();
        }
    }

    @Override
    public void componentResized(ComponentEvent e) {
        fwidth = this.getWidth();
        fheight = this.getHeight();

        lblImage1.setBounds(((3 * fwidth / 4))-1100, (2 * fheight / 8), 500, 400);

        lblMainTitle.setBounds(((getWidth() - lblMainTitle.getPreferredSize().width) / 2)+50,
                ((getHeight() - lblMainTitle.getPreferredSize().height) / 6)-50,
                lblMainTitle.getPreferredSize().width,
                lblMainTitle.getPreferredSize().height);

        btnGrade1.setBounds((fwidth / 2) - 300 , fheight / 3, 350, 350);
        btnGrade2.setBounds((fwidth / 2) + 150, fheight / 3, 350, 350);



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
}
