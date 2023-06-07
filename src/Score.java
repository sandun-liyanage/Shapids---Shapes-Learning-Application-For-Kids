import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;

public class Score extends JFrame implements ComponentListener {
    static JFrame frame;
    JLabel lblMainTitle, lblImage, lblImage2, lblImage1, lblMainTitle2;
    JButton btnLevel2;
    int fwidth, fheight;

    public Score() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addComponentListener(this);
        this.getContentPane().setBackground(new Color(143, 193, 255, 255));
        this.setSize(1400, 800);
        this.setLayout(null);

        lblMainTitle = new JLabel("<html><center>Level 1 has Completed</center></html>");
        lblMainTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 55));
        lblMainTitle.setForeground(Color.decode("#140e0e"));
        add(lblMainTitle);

        lblMainTitle2 = new JLabel("<html><center>Explore more about shapes <br> Go & Check </center></html>");
        lblMainTitle2.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        lblMainTitle2.setForeground(Color.decode("#3314e3"));
        add(lblMainTitle2);

        ImageIcon imageIcon1 = new ImageIcon("images/stars.png");
        lblImage = new JLabel();
        lblImage.setIcon(imageIcon1);
        getContentPane().add(lblImage);

        ImageIcon imageIcon2 = new ImageIcon("images/boy2.png");
        lblImage1 = new JLabel();
        lblImage1.setIcon(imageIcon2);
        getContentPane().add(lblImage1);

        ImageIcon imageIcon3 = new ImageIcon("images/boy3.png");
        lblImage2 = new JLabel();
        lblImage2.setIcon(imageIcon3);
        getContentPane().add(lblImage2);

        btnLevel2 = new Utils.RoundedButton("<html><center>Level 2</center></html>");
        btnLevel2.setBackground(Color.decode("#7e48db"));
        btnLevel2.setForeground(Color.WHITE);
        btnLevel2.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        btnLevel2.setHorizontalAlignment(SwingConstants.CENTER);
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new HomeLevel2();
            }
        };
        btnLevel2.addActionListener(actionListener);
        getContentPane().add(btnLevel2);

        setVisible(true);
    }

    @Override
    public void componentResized(ComponentEvent e) {
        fwidth = this.getWidth();
        fheight = this.getHeight();

        lblMainTitle.setBounds(((getWidth() - lblMainTitle.getPreferredSize().width) / 2),
                ((getHeight() - lblMainTitle.getPreferredSize().height) / 7) + 80,
                lblMainTitle.getPreferredSize().width,
                lblMainTitle.getPreferredSize().height);

        lblMainTitle2.setBounds(((getWidth() - lblMainTitle.getPreferredSize().width) / 2),
                ((getHeight() - lblMainTitle2.getPreferredSize().height) / 7) + 250,
                lblMainTitle2.getPreferredSize().width,
                lblMainTitle2.getPreferredSize().height);

        lblImage.setBounds((fwidth / 2) - 200, (4 * fheight / 8) - 500, 700, 400);
        lblImage1.setBounds((fwidth / 2) + 250, (4 * fheight / 8) - 250, 700, 600);
        lblImage2.setBounds((fwidth / 2) - 650, (4 * fheight / 8) - 400, 700, 600);

        btnLevel2.setBounds((fwidth / 2) - 125, (fheight / 3) + 250, 250, 100);
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
        Score score = new Score();
        frame = new JFrame();
        frame.add(score);
        frame.setSize(1400, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
