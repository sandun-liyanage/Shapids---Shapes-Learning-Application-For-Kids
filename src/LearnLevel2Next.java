import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class LearnLevel2Next extends JPanel {
    JButton rec, circle, square, back;
    List<String> selectedShapes = new ArrayList<>(); // list to store selected shapes
    private static final int SIDE_LENGTH = 50;

    LearnLevel2Next() {
        setSize(1400, 800);
        setLayout(new BorderLayout());
        setBackground(Color.decode("#cff29b"));

        JPanel buttonPanel = new JPanel();

        JPanel levelPanel = new JPanel();

        buttonPanel.setLayout(new GridLayout(0, 1)); // change the layout manager to GridLayout with a single column
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 0, 20));

        rec = new JButton("Pentagon");
        rec.setAlignmentX(Component.CENTER_ALIGNMENT);
        rec.setPreferredSize(new Dimension(150, 100)); // set same width and height for all buttons
        rec.setFont(new Font("Calibri", Font.BOLD, 25));
        rec.setBackground(Color.decode("#EA5C2B"));
        rec.setForeground(Color.WHITE);

        circle = new JButton("Hexagon");
        circle.setAlignmentX(Component.LEFT_ALIGNMENT);
        circle.setPreferredSize(new Dimension(150, 100)); // set same width and height for all buttons
        circle.setFont(new Font("Calibri", Font.BOLD, 25));
        circle.setBackground(Color.decode("#9254C8"));
        circle.setForeground(Color.WHITE);

        square = new JButton("Heptagon");
        square.setAlignmentX(Component.LEFT_ALIGNMENT);
        square.setPreferredSize(new Dimension(150, 100)); // set same width and height for all buttons
        square.setFont(new Font("Calibri", Font.BOLD, 25));
        square.setBackground(Color.decode("#EF2F88"));
        square.setForeground(Color.WHITE);

        back = new JButton("Back");
        back.setAlignmentX(Component.LEFT_ALIGNMENT);
        back.setPreferredSize(new Dimension(200, 70)); // set same width and height for all buttons
        back.setFont(new Font("Calibri", Font.BOLD, 25));
        back.setBackground(Color.decode("#14C38E"));
        back.setForeground(Color.WHITE);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NavBarLevel2("LearnAdvanced");
            }
        };

        back.addActionListener(listener);

        buttonPanel.add(Box.createVerticalStrut(50));
        buttonPanel.add(Box.createVerticalStrut(50));
        buttonPanel.add(rec);
        buttonPanel.add(Box.createVerticalStrut(50));
        buttonPanel.add(Box.createVerticalStrut(50));
        buttonPanel.add(circle);
        buttonPanel.add(Box.createVerticalStrut(30));
        buttonPanel.add(Box.createVerticalStrut(50));
        buttonPanel.add(square);
        buttonPanel.add(Box.createVerticalStrut(30));
        buttonPanel.add(Box.createVerticalStrut(50));
        buttonPanel.setBackground(Color.decode("#cff29b"));


        levelPanel.add(back);
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

        rec.addActionListener(shapeClick);
        circle.addActionListener(shapeClick);
        square.addActionListener(shapeClick);

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
                case "Pentagon":
                    g2.setColor(Color.decode("#EA5C2B"));
                    int[] xValue5 = {50 + 220, 150 + 220, 250 + 220, 200 + 220, 100 + 220};
                    int[] yValue5 = {180- 50, 80- 50, 180- 50, 280- 50, 280- 50};
                    g2.setStroke(new BasicStroke(3));
                    g2.fillPolygon(xValue5, yValue5, 5);
                    g2.setFont(new Font("Calibri", Font.BOLD, 35));
                    g2.drawString("This is a Pentagon", 500, 150);
                    break;
                case "Hexagon":
                    g2.setColor(Color.decode("#9254C8"));
                    int[] xValue6 = {100 + 220, 200 + 220, 250 + 220, 200 + 220, 100 + 220, 50 + 220};
                    int[] yValue6 = {290- 50, 290- 50, 365- 50, 440- 50, 440- 50, 365- 50};
                    g2.setStroke(new BasicStroke(3));
                    g2.fillPolygon(xValue6, yValue6, 6);
                    g2.setFont(new Font("Calibri", Font.BOLD, 35));
                    g2.drawString("This is a Hexagon", 500, 320);
                    break;
                case "Heptagon":
                    g2.setColor(Color.decode("#EF2F88"));
                    int centerX = getWidth() / 2;
                    int centerY = getHeight() / 2;
                    int radius = SIDE_LENGTH * 2;

                    // Calculate the x and y coordinates of the seven points on the circumference of the circle
                    int[] xPoints = new int[7];
                    int[] yPoints = new int[7];
                    for (int a = 0; a < 7; a++) {

                        double angle = Math.toRadians(a * 360 / 7);

                        xPoints[a] = (int) Math.round(centerX + radius * Math.cos(angle));
                        yPoints[a] = (int) Math.round(centerY + radius * Math.sin(angle));

                        xPoints[a] -= 430 -100;
                        yPoints[a] += 210 - 50;

                    }

                    // Draw the heptagon using the calculated points
                    g2.fillPolygon(xPoints, yPoints, 7);
                    g2.setFont(new Font("Calibri", Font.BOLD, 35));
                    g2.drawString("This is a Heptagon", 500, 520);

                    break;

            }
        }

    }

    public static void main(final String[] arg) {
        LearnLevel2Next s = new LearnLevel2Next();
        NavBar nb = new NavBar();
        nb.add(s);

    }
}


