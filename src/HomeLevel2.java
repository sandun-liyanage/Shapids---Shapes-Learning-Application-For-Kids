import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.geom.RoundRectangle2D;


public class HomeLevel2 extends JFrame implements ComponentListener, ActionListener {
    int fwidth, fheight;
    static JFrame frame;
    JLabel lblTitle,lblImage;
    JButton btnLearnAdvanced, btnDrawAdvancedShapes, btnColorAdvancedShapes, btnHistory, btnFindAdvancedShapes, btn3dShapes, btnBack;

    public HomeLevel2() {
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

        btnLearnAdvanced = new Utils.RoundedButton("<html><center>Learn Advanced Shapes</center></html>");
        btnLearnAdvanced.setBackground(Color.decode("#95CD41"));
        btnLearnAdvanced.setForeground(Color.WHITE);
        btnLearnAdvanced.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        btnLearnAdvanced.setHorizontalAlignment(SwingConstants.CENTER);
        btnLearnAdvanced.addActionListener(this);
        add(btnLearnAdvanced);

        btnDrawAdvancedShapes = new Utils.RoundedButton("<html><center>Draw Advanced Shape</center></html>");
        btnDrawAdvancedShapes.setBackground(Color.decode("#FFA45B"));
        btnDrawAdvancedShapes.setForeground(Color.WHITE);
        btnDrawAdvancedShapes.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        btnDrawAdvancedShapes.setHorizontalAlignment(SwingConstants.CENTER);
        btnDrawAdvancedShapes.addActionListener(this);
        add(btnDrawAdvancedShapes);

        btnColorAdvancedShapes = new Utils.RoundedButton("<html><center>Color Shapes</center></html>");
        btnColorAdvancedShapes.setBackground(Color.decode("#de6fb1"));
        btnColorAdvancedShapes.setForeground(Color.WHITE);
        btnColorAdvancedShapes.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        btnColorAdvancedShapes.setHorizontalAlignment(SwingConstants.CENTER);
        btnColorAdvancedShapes.addActionListener(this);
        add(btnColorAdvancedShapes);

        btnFindAdvancedShapes = new Utils.RoundedButton("<html><center>Find Advanced Shapes</center></html>");
        btnFindAdvancedShapes.setBackground(Color.decode("#CA82F8"));
        btnFindAdvancedShapes.setForeground(Color.WHITE);
        btnFindAdvancedShapes.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        btnFindAdvancedShapes.setHorizontalAlignment(SwingConstants.CENTER);
        btnFindAdvancedShapes.addActionListener(this);
        add(btnFindAdvancedShapes);

        btn3dShapes = new Utils.RoundedButton("<html><center>3D Shapes</center></html>");
        btn3dShapes.setBackground(Color.decode("#FF7C7C"));
        btn3dShapes.setForeground(Color.WHITE);
        btn3dShapes.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        btn3dShapes.setHorizontalAlignment(SwingConstants.CENTER);
        btn3dShapes.addActionListener(this);
        add(btn3dShapes);

        btnHistory = new Utils.RoundedButton("<html><center>History</center></html>");
        btnHistory.setBackground(Color.decode("#6DA9E4"));
        btnHistory.setForeground(Color.WHITE);
        btnHistory.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        btnHistory.setHorizontalAlignment(SwingConstants.CENTER);
        btnHistory.addActionListener(this);
        add(btnHistory);

        ImageIcon imageIcon = new ImageIcon("images/login1.png");
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

        HomeLevel2 homeLevel2 = new HomeLevel2();

        frame.add(homeLevel2);
        frame.setSize(1400, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLearnAdvanced) {
            this.setVisible(false);
            new NavBarLevel2("LearnAdvanced");
        } else if (e.getSource() == btnDrawAdvancedShapes) {
            this.setVisible(false);
            new NavBarLevel2("DrawAdvanced");
        } else if (e.getSource() == btnColorAdvancedShapes) {
            this.setVisible(false);
            new NavBarLevel2("ColorAdvancedShape");
        } else if (e.getSource() == btnFindAdvancedShapes) {
            this.setVisible(false);
            new NavBarLevel2("FindAdvancedShape");
        } else if (e.getSource() == btn3dShapes) {
            this.setVisible(false);
            new NavBarLevel2("3dShapes");
        } else if (e.getSource() == btnHistory) {
            this.setVisible(false);
            new NavBarLevel2("History");
        } else if (e.getSource() == btnBack) {
            this.setVisible(false);
            new Home();
        }
    }

    @Override
    public void componentResized(ComponentEvent e) {
        fwidth = this.getWidth();
        fheight = this.getHeight();

        lblTitle.setBounds((fwidth / 2) - 375, 40, 750, 65);

        btnLearnAdvanced.setBounds((fwidth / 4) - 125, fheight / 6, 250, 250);
        btnDrawAdvancedShapes.setBounds((fwidth / 2) - 125, fheight / 6, 250, 250);
        btnColorAdvancedShapes.setBounds((3 * fwidth / 4) - 125, fheight / 6, 250, 250);

        btnFindAdvancedShapes.setBounds((fwidth / 4) - 125, (3 * fheight / 5) - 50, 250, 250);
        btn3dShapes.setBounds((fwidth / 2) - 125, (3 * fheight / 5) - 50, 250, 250);
        btnHistory.setBounds((3 * fwidth / 4) - 125, (3 * fheight / 5) - 50, 250, 250);

        lblImage.setBounds((3 * fwidth / 4)+55, (2 * fheight / 8)+150, 300, 400);

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
