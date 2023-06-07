import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class LearnLevel2 extends JPanel {

    JButton rhombus, parallelogram, trapezium, level1, next;
    List<String> selectedShapes = new ArrayList<>(); // list to store selected shapes
    private static final int SIDE_LENGTH = 50;

    LearnLevel2() {

        setSize(1400, 800);
        setLayout(new BorderLayout());
        setBackground(Color.decode("#cff29b"));

        JPanel buttonPanel = new JPanel();

        JPanel levelPanel = new JPanel();

        buttonPanel.setLayout(new GridLayout(0, 1));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 0, 20));
        buttonPanel. setBackground(Color.decode("#cff29b"));

        levelPanel.setLayout(new GridLayout(0, 3));
        levelPanel.setBorder(BorderFactory.createEmptyBorder(10, 100, 10, 100));

        rhombus = new JButton("Rhombus");
        rhombus.setAlignmentX(Component.CENTER_ALIGNMENT);
        rhombus.setPreferredSize(new Dimension(150, 100));
        rhombus.setFont(new Font("Calibri", Font.BOLD, 25));
        rhombus.setBackground(Color.decode("#646FD4"));
        rhombus.setForeground(Color.WHITE);

        parallelogram = new JButton("Parallelogram");
        parallelogram.setAlignmentX(Component.LEFT_ALIGNMENT);
        parallelogram.setPreferredSize(new Dimension(200, 100));
        parallelogram.setFont(new Font("Calibri", Font.BOLD, 25));
        parallelogram.setBackground(Color.decode("#F0A500"));
        parallelogram.setForeground(Color.WHITE);

        trapezium = new JButton("Trapezium");
        trapezium.setAlignmentX(Component.LEFT_ALIGNMENT);
        trapezium.setPreferredSize(new Dimension(150, 100));
        trapezium.setFont(new Font("Calibri", Font.BOLD, 25));
        trapezium.setBackground(Color.decode("#9A208C"));
        trapezium.setForeground(Color.WHITE);

        level1 = new JButton("Go Back to Level 1");
        level1.setAlignmentX(Component.LEFT_ALIGNMENT);
        level1.setPreferredSize(new Dimension(200, 70));
        level1.setFont(new Font("Calibri", Font.BOLD, 25));
        level1.setBackground(Color.decode("#14C38E"));
        level1.setForeground(Color.WHITE);

        ActionListener listenerLevel1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NavBar("Learn");
            }
        };

        level1.addActionListener(listenerLevel1);

        next = new JButton("Next - Explore More Shapes ");
        next.setAlignmentX(Component.LEFT_ALIGNMENT);
        next.setPreferredSize(new Dimension(100, 70));
        next.setFont(new Font("Calibri", Font.BOLD, 25));
        next.setBackground(Color.decode("#14C38E"));
        next.setForeground(Color.WHITE);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NavBarLevel2("LearnLevel2Next");
            }
        };

        next.addActionListener(listener);


        buttonPanel.add(Box.createVerticalStrut(50));
        buttonPanel.add(Box.createVerticalStrut(50));
        buttonPanel.add(rhombus);
        buttonPanel.add(Box.createVerticalStrut(50));
        buttonPanel.add(Box.createVerticalStrut(50));
        buttonPanel.add(parallelogram);
        buttonPanel.add(Box.createVerticalStrut(30));
        buttonPanel.add(Box.createVerticalStrut(50));
        buttonPanel.add(trapezium);
        buttonPanel.add(Box.createVerticalStrut(30));
        buttonPanel.add(Box.createVerticalStrut(50));


        levelPanel.add(level1);
        levelPanel.add(Box.createHorizontalStrut(30));

        levelPanel.add(next);
        levelPanel.setBackground(Color.decode("#cff29b"));

        // add buttonPanel to the left side of the frame
        add(buttonPanel, BorderLayout.WEST);

        add(levelPanel, BorderLayout.AFTER_LAST_LINE);

        ActionListener shapeClick = new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                selectedShapes.add(e.getActionCommand());
                repaint();
            }
        };

        rhombus.addActionListener(shapeClick);
        parallelogram.addActionListener(shapeClick);
        trapezium.addActionListener(shapeClick);

    }


    @Override
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        Toolkit t = Toolkit.getDefaultToolkit();
        Image i = t.getImage("images/learnTeacher.jpg");
        g.drawImage(i, 800, 100, 550, 400, this);


        Image i2 = t.getImage("arrow4.gif");
        g.drawImage(i2, 450, 570, 100, 100, this);

        for (String shape : selectedShapes) {
            switch (shape) {
                case "Rhombus":
                    g2.setColor(Color.decode("#646FD4"));
                    int[] xValue4 = {50+250, 150+250, 250+250, 150+250};
                    int[] yValue4 = {190-50, 290-50, 190-50, 90-50};
                    g2.setStroke(new BasicStroke(3));
                    g2.fillPolygon(xValue4, yValue4, 4);
                    g2.setFont(new Font("Calibri", Font.BOLD, 35));
                    g2.drawString("This is a Rhombus", 530, 150);
                    break;
                case "Parallelogram":
                    g2.setColor(Color.decode("#F0A500"));
                    int[] xValueP = {50+250, 175+250, 250+250, 125+250};
                    int[] yValueP = {335-50, 335-50, 460-50, 460-50};
                    g2.setStroke(new BasicStroke(3));
                    g2.fillPolygon(xValueP, yValueP, 4);
                    g2.setFont(new Font("Calibri", Font.BOLD, 35));
                    g2.drawString("This is a Parallelogram", 470, 350);
                    break;
                case "Trapezium":
                    g2.setColor(Color.decode("#9A208C"));
                    int[] xValueT = {100+250, 200+250, 250+250, 50+250};
                    int[] yValueT = {500-50, 500-50, 600-50, 600-50};
                    g2.setStroke(new BasicStroke(3));
                    g2.fillPolygon(xValueT, yValueT, 4);
                    g2.setFont(new Font("Calibri", Font.BOLD, 35));
                    g2.drawString("This is a Trapezium ", 520, 520);
                    break;
            }
        }
    }

    public static void main(final String[] arg) {

        LearnLevel2 s = new LearnLevel2();
        NavBar nb = new NavBar();
        nb.add(s);
    }
}
