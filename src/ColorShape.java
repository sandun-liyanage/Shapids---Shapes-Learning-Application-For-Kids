import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.awt.geom.*;
import java.text.AttributedString;

import javax.swing.*;

public class ColorShape extends JPanel implements ActionListener {
    static JFrame frame;
    JButton btnColor;
    private Shape rectangle, square, triangle, circle, oval, star;
    Arc2D.Double semiCircle;
    private boolean isRectangleSelected = false;
    private boolean isSquareSelected = false;
    private boolean isCircleSelected = false;
    private boolean isOvalSelected = false;
    private boolean isTriangleSelected = false;
    private boolean isStarSelected = false;
    private boolean isSemiCircleSelected = false;
    private Color GLOBAL_COLOR, RECTANGLE_COLOR, SQUARE_COLOR, CIRCLE_COLOR, OVAL_COLOR, TRIANGLE_COLOR, STAR_COLOR, SEMI_CIRCLE_COLOR;
    private static final String RECTANGLE_TEXT = "RECTANGLE", SQUARE_TEXT = "SQUARE", CIRCLE_TEXT = "CIRCLE", OVAL_TEXT = "OVAL", TRIANGLE_TEXT = "TRIANGLE", STAR_TEXT = "STAR", SEMI_CIRCLE_TEXT = "SEMI CIRCLE";
    String htmlInstructions = "<html><h2>Let's color shapes</h2><ol><li>Color the Rectangle in <font color='red'>Red</font>.</li><li>Color the Square in <font color='blue'>Blue</font>.</li><li>Color the Triangle in <font color='purple'>Purple</font>.</li><li>Color the Circle in <font color='green'>Green</font>.</li><li>Color the Oval in <font color='orange'>Orange</font>.</li><li>Color the Star in <font color='yellow'>Yellow</font>.</li><li>Color the Semi Circle in <font color='navy'>Navy</font>.</li></ol></html>";

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        /* Borders */
        g2d.drawLine(getWidth() / 4, 0, getWidth() / 4, getHeight());
        g2d.drawLine(2 * getWidth() / 4, 0, 2 * getWidth() / 4, getHeight());
        g2d.drawLine(3 * getWidth() / 4, 0, 3 * getWidth() / 4, getHeight());
        g2d.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);

        /* Rectangle */
        rectangle = new Rectangle2D.Double((double) ((getWidth() / 4) - 250) / 2, 50, 250, 150);

        /* Square */
        square = new Rectangle2D.Double(((double) getWidth() / 4) + (double) ((getWidth() / 4) - 150) / 2, 50, 150, 150);

        /* Triangle */
        int x1 = ((int) (((double) 2 * getWidth() / 4) + (getWidth() / 4) / 2)) - 75;
        int x2 = ((int) (((double) 2 * getWidth() / 4) + (getWidth() / 4) / 2)) + 75;
        int x3 = (int) (((double) 2 * getWidth() / 4) + (getWidth() / 4) / 2);
        int[] xTrianglePoints = {x1, x2, x3};
        int[] yTrianglePoints = {200, 200, 50};
        triangle = new Polygon(xTrianglePoints, yTrianglePoints, 3);

        /* Circle */
        circle = new Ellipse2D.Double(((double) (3 * getWidth()) / 4) + (double) ((getWidth() / 4) - 150) / 2, 50, 150, 150);

        /* Oval */
        oval = new Ellipse2D.Double((double) ((getWidth() / 4) - 250) / 2, 400, 250, 130);

        /* Star */
        int starDiff = (getWidth() / 4) + ((getWidth() / 4) - 108) / 2;
        int s1 = 55 + starDiff;
        int s2 = 67 + starDiff;
        int s3 = 109 + starDiff;
        int s4 = 73 + starDiff;
        int s5 = 83 + starDiff;
        int s6 = 55 + starDiff;
        int s7 = 27 + starDiff;
        int s8 = 37 + starDiff;
        int s9 = 1 + starDiff;
        int s10 = 43 + starDiff;
        int[] xStarPoints = {s1, s2, s3, s4, s5, s6, s7, s8, s9, s10};
        int[] yStarPoints = {400, 436, 436, 454, 496, 472, 496, 454, 436, 436};
        star = new Polygon(xStarPoints, yStarPoints, 10);

        /* Semi Circle */
        int xSemiCircle = ((2 * getWidth()) / 4) + ((getWidth() / 4) - 200) / 2;
        int ySemiCircle = 400;
        int diameter = 200;
        semiCircle = new Arc2D.Double(Arc2D.PIE);
        semiCircle.setFrame(xSemiCircle, ySemiCircle, diameter, diameter);
        semiCircle.setAngleStart(0);
        semiCircle.setAngleExtent(180);

        /* Frame Borders of Shape */
        g2d.draw(rectangle);
        g2d.draw(square);
        g2d.draw(triangle);
        g2d.draw(circle);
        g2d.draw(oval);
        g2d.draw(star);
        g2d.draw(semiCircle);

        /* Rounded Rectangle */
        int width = 300;
        int height = 300;
        int arcWidth = 50;
        int arcHeight = 50;

        /* String Font Size */
        Font font = new Font("Arial", Font.BOLD, 35);
        g.setFont(font);
        FontMetrics fm = g.getFontMetrics();

        if (isRectangleSelected) {

            g2d.setColor(RECTANGLE_COLOR);
            g2d.fill(rectangle);

            // Get the size of the text
            int txtWidth = fm.stringWidth(RECTANGLE_TEXT);
            int txtHeight = fm.getHeight();
            // Draw the text in the center of the panel
            int x = ((getWidth() / 4) - txtWidth) / 2;
            int y = (getHeight() - txtHeight) / 2 + fm.getAscent();
            g.drawString(RECTANGLE_TEXT, x, 280);

            g2d.setStroke(new BasicStroke(5));
            g2d.drawRoundRect(((getWidth() / 4) - 300) / 2, 20, width, height, arcWidth, arcHeight);
        }

        if (isSquareSelected) {

            g2d.setColor(SQUARE_COLOR);
            g2d.fill(square);

            // Get the size of the text
            int txtWidth = fm.stringWidth(SQUARE_TEXT);
            int txtHeight = fm.getHeight();
            // Draw the text in the center of the panel
            int x = ((3 * getWidth() / 4) - txtWidth) / 2;
            int y = (getHeight() - txtHeight) / 2 + fm.getAscent();
            g.drawString(SQUARE_TEXT, x, 280);

            g2d.setStroke(new BasicStroke(5));
            g2d.drawRoundRect((getWidth() / 4) + ((getWidth() / 4) - 300) / 2, 20, width, height, arcWidth, arcHeight);
        }

        if (isTriangleSelected) {

            g2d.setColor(TRIANGLE_COLOR);
            g2d.fill(triangle);

            // Get the size of the text
            int txtWidth = fm.stringWidth(TRIANGLE_TEXT);
            int txtHeight = fm.getHeight();
            // Draw the text in the center of the panel
            int x = ((5 * getWidth() / 4) - txtWidth) / 2;
            int y = (getHeight() - txtHeight) / 2 + fm.getAscent();
            g.drawString(TRIANGLE_TEXT, x, 280);

            g2d.setStroke(new BasicStroke(5));
            g2d.drawRoundRect(((2 * getWidth()) / 4) + ((getWidth() / 4) - 300) / 2, 20, width, height, arcWidth, arcHeight);
        }

        if (isCircleSelected) {

            g2d.setColor(CIRCLE_COLOR);
            g2d.fill(circle);

            // Get the size of the text
            int txtWidth = fm.stringWidth(CIRCLE_TEXT);
            int txtHeight = fm.getHeight();
            // Draw the text in the center of the panel
            int x = ((7 * getWidth() / 4) - txtWidth) / 2;
            int y = (getHeight() - txtHeight) / 2 + fm.getAscent();
            g.drawString(CIRCLE_TEXT, x, 280);

            g2d.setStroke(new BasicStroke(5));
            g2d.drawRoundRect(((3 * getWidth()) / 4) + ((getWidth() / 4) - 300) / 2, 20, width, height, arcWidth, arcHeight);
        }

        if (isOvalSelected) {

            g2d.setColor(OVAL_COLOR);
            g2d.fill(oval);

            // Get the size of the text
            int txtWidth = fm.stringWidth(OVAL_TEXT);
            int txtHeight = fm.getHeight();
            // Draw the text in the center of the panel
            int x = ((getWidth() / 4) - txtWidth) / 2;
            int y = (getHeight() - txtHeight) / 2 + fm.getAscent();
            g.drawString(OVAL_TEXT, x, (getHeight() / 2) + 280);

            g2d.setStroke(new BasicStroke(5));
            g2d.drawRoundRect(((getWidth() / 4) - 300) / 2, 370, width, height, arcWidth, arcHeight);
        }

        if (isStarSelected) {

            g2d.setColor(STAR_COLOR);
            g2d.fill(star);

            // Get the size of the text
            int txtWidth = fm.stringWidth(STAR_TEXT);
            int txtHeight = fm.getHeight();
            // Draw the text in the center of the panel
            int x = ((3 * getWidth() / 4) - txtWidth) / 2;
            int y = (getHeight() - txtHeight) / 2 + fm.getAscent();
            g.drawString(STAR_TEXT, x, (getHeight() / 2) + 280);

            g2d.setStroke(new BasicStroke(5));
            g2d.drawRoundRect((getWidth() / 4) + ((getWidth() / 4) - 300) / 2, 370, width, height, arcWidth, arcHeight);
        }

        if (isSemiCircleSelected) {

            g2d.setColor(SEMI_CIRCLE_COLOR);
            g2d.fill(semiCircle);

            // Get the size of the text
            int txtWidth = fm.stringWidth(SEMI_CIRCLE_TEXT);
            int txtHeight = fm.getHeight();
            // Draw the text in the center of the panel
            int x = ((5 * getWidth() / 4) - txtWidth) / 2;
            int y = (getHeight() - txtHeight) / 2 + fm.getAscent();
            g.drawString(SEMI_CIRCLE_TEXT, x, (getHeight() / 2) + 280);

            g2d.setStroke(new BasicStroke(5));
            g2d.drawRoundRect(((2 * getWidth()) / 4) + ((getWidth() / 4) - 300) / 2, 370, width, height, arcWidth, arcHeight);
        }

        g2d.setColor(Color.BLACK);

        g2d.setStroke(new BasicStroke(5));
        g2d.drawRoundRect(((3 * getWidth()) / 4) + ((getWidth() / 4) - 300) / 2, 370, width, height, arcWidth, arcHeight);
    }

    public ColorShape() {

        this.setBackground(Color.decode("#fac8e6"));
        this.setSize(1400, 800);
        this.setLayout(null);

        setLayout(null);

        JLabel lblInstructions = new JLabel(htmlInstructions);
        lblInstructions.setBounds(1077, 335, 280, 300);
        lblInstructions.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        add(lblInstructions);

        btnColor = new Utils.RoundedButton("<html><center>Choose<br>Color</center></html>");
        btnColor.setBounds(1150, 610, 100, 50);
        btnColor.setBackground(Color.WHITE);
        btnColor.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        btnColor.addActionListener(this);
        add(btnColor);


        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point p = e.getPoint();

                if (rectangle.contains(p)) {
                    isRectangleSelected = true;
                    RECTANGLE_COLOR = GLOBAL_COLOR;
                } else if (square.contains(p)) {
                    isSquareSelected = true;
                    SQUARE_COLOR = GLOBAL_COLOR;
                } else if (triangle.contains(p)) {
                    isTriangleSelected = true;
                    TRIANGLE_COLOR = GLOBAL_COLOR;
                } else if (circle.contains(p)) {
                    isCircleSelected = true;
                    CIRCLE_COLOR = GLOBAL_COLOR;
                } else if (oval.contains(p)) {
                    isOvalSelected = true;
                    OVAL_COLOR = GLOBAL_COLOR;
                } else if (star.contains(p)) {
                    isStarSelected = true;
                    STAR_COLOR = GLOBAL_COLOR;
                } else if (semiCircle.contains(p)) {
                    isSemiCircleSelected = true;
                    SEMI_CIRCLE_COLOR = GLOBAL_COLOR;
                }
                repaint();
            }
        });

    }

    public static void main(String[] args) {

        ColorShape colorShape = new ColorShape();
        NavBar nb = new NavBar();
        nb.add(colorShape);

        frame.getContentPane().add(colorShape);
        frame.setSize(1400, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnColor) {
            Color c = JColorChooser.showDialog(this, "Choose", btnColor.getBackground());
            btnColor.setBackground(c);
            GLOBAL_COLOR = c;
        }
    }
}
