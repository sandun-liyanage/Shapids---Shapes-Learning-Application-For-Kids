import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.geom.RoundRectangle2D;


public class HomeLevel1 extends JFrame implements ComponentListener, ActionListener {
    int fwidth, fheight;
    static JFrame frame;
    JLabel lblTitle,lblImage;
    JButton btnLearnBasics, btnDrawShapes, btnColorShapes, btnHistory, btnFindShapes, btnPlayShapes, btnBack;

    public HomeLevel1() {
        super("Shapids");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addComponentListener(this);
        this.getContentPane().setBackground(Color.decode("#9ADCFF"));
        this.setSize(1400, 800);
        this.setLayout(null);

        lblTitle = new JLabel("<html><center>Select an activity to begin</center></html>");
        lblTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
        lblTitle.setForeground(Color.decode("#163dc9"));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblTitle);

        btnLearnBasics = new Utils.RoundedButton("<html><center>Learn Basics</center></html>");
        btnLearnBasics.setBackground(Color.decode("#95CD41"));
        btnLearnBasics.setForeground(Color.WHITE);
        btnLearnBasics.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        btnLearnBasics.setHorizontalAlignment(SwingConstants.CENTER);
        btnLearnBasics.addActionListener(this);
        add(btnLearnBasics);

        btnDrawShapes = new Utils.RoundedButton("<html><center>Draw New Shape</center></html>");
        btnDrawShapes.setBackground(Color.decode("#FFA45B"));
        btnDrawShapes.setForeground(Color.WHITE);
        btnDrawShapes.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        btnDrawShapes.setHorizontalAlignment(SwingConstants.CENTER);
        btnDrawShapes.addActionListener(this);
        add(btnDrawShapes);

        btnColorShapes = new Utils.RoundedButton("<html><center>Color Shapes</center></html>");
        btnColorShapes.setBackground(Color.decode("#de6fb1"));
        btnColorShapes.setForeground(Color.WHITE);
        btnColorShapes.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        btnColorShapes.setHorizontalAlignment(SwingConstants.CENTER);
        btnColorShapes.addActionListener(this);
        add(btnColorShapes);

        btnFindShapes = new Utils.RoundedButton("<html><center>Find Shapes</center></html>");
        btnFindShapes.setBackground(Color.decode("#CA82F8"));
        btnFindShapes.setForeground(Color.WHITE);
        btnFindShapes.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        btnFindShapes.setHorizontalAlignment(SwingConstants.CENTER);
        btnFindShapes.addActionListener(this);
        add(btnFindShapes);

        btnPlayShapes = new Utils.RoundedButton("<html><center>Play Shapes</center></html>");
        btnPlayShapes.setBackground(Color.decode("#FF7C7C"));
        btnPlayShapes.setForeground(Color.WHITE);
        btnPlayShapes.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        btnPlayShapes.setHorizontalAlignment(SwingConstants.CENTER);
        btnPlayShapes.addActionListener(this);
        add(btnPlayShapes);

        btnHistory = new Utils.RoundedButton("<html><center>History</center></html>");
        btnHistory.setBackground(Color.decode("#6DA9E4"));
        btnHistory.setForeground(Color.WHITE);
        btnHistory.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        btnHistory.setHorizontalAlignment(SwingConstants.CENTER);
        btnHistory.addActionListener(this);
        add(btnHistory);

        ImageIcon imageIcon = new ImageIcon("images/login2.png");
        lblImage = new JLabel();
        lblImage.setIcon(imageIcon);
        getContentPane().add(lblImage);

        btnBack = new Utils.RoundedButton("<html><center>Back</center></html>");
        btnBack.setBackground(Color.decode("#E6B325"));
        btnBack.setForeground(Color.WHITE);
        btnBack.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        btnBack.setHorizontalAlignment(SwingConstants.CENTER);
        btnBack.addActionListener(this);
        add(btnBack);

        this.setVisible(true);
    }

    public static void main(String[] args) {

        HomeLevel1 homeLevel1 = new HomeLevel1();

        frame.add(homeLevel1);
        frame.setSize(1400, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLearnBasics) {
            this.setVisible(false);
            new NavBar("Learn");
        } else if (e.getSource() == btnDrawShapes) {
            this.setVisible(false);
            new NavBar("DrawShape");
        } else if (e.getSource() == btnColorShapes) {
            this.setVisible(false);
            new NavBar("ColorShape");
        } else if (e.getSource() == btnFindShapes) {
            this.setVisible(false);
            new NavBar("FindShape");
        } else if (e.getSource() == btnPlayShapes) {
            this.setVisible(false);
            new NavBar("PlayShape");
        } else if (e.getSource() == btnHistory) {
            this.setVisible(false);
            new NavBar("History");
        } else if (e.getSource() == btnBack) {
            this.setVisible(false);
            new Home();
        }
    }

    @Override
    public void componentResized(ComponentEvent e) {
        fwidth = this.getWidth();
        fheight = this.getHeight();

        lblTitle.setBounds((fwidth / 2) - 375, 30, 750, 65);

        btnLearnBasics.setBounds((fwidth / 4) - 125, fheight / 6, 250, 250);
        btnDrawShapes.setBounds((fwidth / 2) - 125, fheight / 6, 250, 250);
        btnColorShapes.setBounds((3 * fwidth / 4) - 125, fheight / 6, 250, 250);

        btnFindShapes.setBounds((fwidth / 4) - 125, (3 * fheight / 5) - 50, 250, 250);
        btnPlayShapes.setBounds((fwidth / 2) - 125, (3 * fheight / 5) - 50, 250, 250);
        btnHistory.setBounds((3 * fwidth / 4) - 125, (3 * fheight / 5) - 50, 250, 250);

        lblImage.setBounds((3 * fwidth / 4)+80, (2 * fheight / 8)+150, 300, 400);

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
