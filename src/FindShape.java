import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.awt.geom.*;
import java.text.AttributedString;

import javax.swing.*;

public class FindShape extends JPanel {
    static JFrame frame;
    private Shape rectangle, square, triangle, circle, oval, star;
    Arc2D.Double semiCircle;
    private boolean isRectangleSelected = false;
    private boolean isSquareSelected = false;
    private boolean isSquareSelected1 = false;
    private boolean isCircleSelected = false;
    private boolean isCircleSelected1 = false;
    private boolean isOvalSelected = false;
    private boolean isOvalSelected1 = false;
    private boolean isTriangleSelected = false;
    private boolean isTriangleSelected1 = false;
    private boolean isStarSelected = false;
    private boolean isStarSelected1 = false;
    private boolean isSemiCircleSelected = false;
    private boolean isSemiCircleSelected1 = false;
    private static final String RECTANGLE_TEXT = "RECTANGLE", SQUARE_TEXT = "SQUARE", CIRCLE_TEXT = "CIRCLE", OVAL_TEXT = "OVAL", TRIANGLE_TEXT = "TRIANGLE", STAR_TEXT = "STAR", SEMI_CIRCLE_TEXT = "SEMI CIRCLE";
    String htmlInstructions = "<html><h1>Select The Triangle</h1></html>";

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        /* Rectangle */
        rectangle = new Rectangle2D.Double((double) ((getWidth() / 4) - 250) / 2, 100, 250, 150);

        /* Square */
        square = new Rectangle2D.Double(((double) getWidth() / 4) + (double) ((getWidth() / 4) - 150) / 2, 100, 150, 150);

        /* Triangle */
        int x1 = ((int) (((double) 2 * getWidth() / 4) + (getWidth() / 4) / 2)) - 75;
        int x2 = ((int) (((double) 2 * getWidth() / 4) + (getWidth() / 4) / 2)) + 75;
        int x3 = (int) (((double) 2 * getWidth() / 4) + (getWidth() / 4) / 2);
        int[] xTrianglePoints = {x1, x2, x3};
        int[] yTrianglePoints = {200, 200, 100};
        triangle = new Polygon(xTrianglePoints, yTrianglePoints, 3);

        /* Circle */
        circle = new Ellipse2D.Double(((double) (3 * getWidth()) / 4) + (double) ((getWidth() / 4) - 150) / 2, 100, 150, 150);

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
        //int[] yStarPoints = {0, 36, 36, 54, 96, 72, 96, 54, 36, 36};
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
        g2d.draw(triangle);
        g2d.draw(rectangle);
        g2d.draw(oval);
        g2d.draw(circle);
        g2d.draw(star);
        g2d.draw(square);
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

            g2d.setColor(Color.decode("#E0144C"));
            g2d.fill(rectangle);

            // Get the size of the text
            int txtWidth = fm.stringWidth(RECTANGLE_TEXT);
            int txtHeight = fm.getHeight();
            // Draw the text in the center of the panel
            int x = ((getWidth() / 4) - txtWidth) / 2;
            int y = (getHeight() - txtHeight) / 2 + fm.getAscent();
            g.drawString(RECTANGLE_TEXT, x, 280);

            g2d.setStroke(new BasicStroke(5));
            g2d.drawRoundRect(((getWidth() / 4) - 300) / 2, 70, width, height, arcWidth, arcHeight);
        }

        if (isSquareSelected) {

            g2d.setColor(Color.decode("#E38B29"));
            g2d.fill(square);

            // Get the size of the text
            int txtWidth = fm.stringWidth(SQUARE_TEXT);
            int txtHeight = fm.getHeight();

            // Draw the text in the center of the panel
            int x = ((3 * getWidth() / 4) - txtWidth) / 2;
            int y = (getHeight() - txtHeight) / 2 + fm.getAscent();

            g.drawString(SQUARE_TEXT, x, 280);


            g2d.setStroke(new BasicStroke(5));
            g2d.drawRoundRect((getWidth() / 4) + ((getWidth() / 4) - 300) / 2, 70, width, height, arcWidth, arcHeight);
        }

        if (isTriangleSelected) {

            g2d.setColor(Color.decode("#14C38E"));
            g2d.fill(triangle);

            // Get the size of the text
            int txtWidth = fm.stringWidth(TRIANGLE_TEXT);
            int txtHeight = fm.getHeight();

            // Draw the text in the center of the panel
            int x = ((5 * getWidth() / 4) - txtWidth) / 2;
            int y = (getHeight() - txtHeight) / 2 + fm.getAscent();
            g.drawString(TRIANGLE_TEXT, x, 280);

            g2d.setStroke(new BasicStroke(5));
            g2d.drawRoundRect(((2 * getWidth()) / 4) + ((getWidth() / 4) - 300) / 2, 70, width, height, arcWidth, arcHeight);
        }

        if (isCircleSelected) {

            g2d.setColor(Color.decode("#F56EB3"));
            g2d.fill(circle);

            // Get the size of the text
            int txtWidth = fm.stringWidth(CIRCLE_TEXT);
            int txtHeight = fm.getHeight();
            // Draw the text in the center of the panel
            int x = ((7 * getWidth() / 4) - txtWidth) / 2;
            int y = (getHeight() - txtHeight) / 2 + fm.getAscent();
            g.drawString(CIRCLE_TEXT, x, 280);

            g2d.setStroke(new BasicStroke(5));
            g2d.drawRoundRect(((3 * getWidth()) / 4) + ((getWidth() / 4) - 300) / 2, 70, width, height, arcWidth, arcHeight);
        }

        if (isOvalSelected) {

            g2d.setColor(Color.decode("#FE6244"));
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

            g2d.setColor(Color.decode("#A31ACB"));
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

            g2d.setColor(Color.decode("#0081B4"));
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
        g2d.drawRoundRect((((3 * getWidth()) / 4) + ((getWidth() / 4) - 300) / 2), 370, width, height, arcWidth, arcHeight);
    }

    public FindShape() {

        this.setBackground(Color.decode("#e3befa"));
        this.setSize(1400, 800);
        this.setLayout(null);

        setLayout(null);

        JLabel lblInstructions = new JLabel(htmlInstructions);
        lblInstructions.setBounds(400, -120, 280, 300);
        lblInstructions.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        add(lblInstructions);

        JLabel lblInstructions1 = new JLabel("<html><h1>Wrong Selection! Try Again...</h1></html>");
        lblInstructions1.setBounds(800, -120, 450, 300);
        lblInstructions1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        add(lblInstructions1);
        lblInstructions1.setVisible(false);

        JLabel lblInstructions2 = new JLabel("<html><h1>Find and select the mentioned shape. <br/> If you get it wrong, Try again... <br/> Continue until you find all shapes.</h1></html>");
        lblInstructions2.setBounds(1070, 140, 300, 700);
        lblInstructions2.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        add(lblInstructions2);


        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point p = e.getPoint();

                if (rectangle.contains(p)) {


                    if (isTriangleSelected && isOvalSelected && isSquareSelected && isSemiCircleSelected && isCircleSelected && isStarSelected) {
                        isRectangleSelected = true;
                        lblInstructions.setText("<html><h2>Awesome.. you found all shapes correctly</h2></html>");
                        lblInstructions1.setVisible(false);
                    } else {
                        lblInstructions1.setVisible(true);
                    }
                } else if (square.contains(p)) {
                    if (isTriangleSelected && isOvalSelected) {
                        isSquareSelected = true;
                        lblInstructions.setText("<html><h2>Awesome.. Now Select The Semi Circle</h2></html>");
                        lblInstructions1.setVisible(false);
                    } else {
                        lblInstructions1.setVisible(true);
                    }
                } else if (triangle.contains(p)) {
                    isTriangleSelected = true;
                    lblInstructions.setText("<html><h2>Good.. Now Select The Oval</h2></html>");
                    lblInstructions1.setVisible(false);
                } else if (circle.contains(p)) {
                    if (isTriangleSelected && isOvalSelected && isSquareSelected && isSemiCircleSelected) {
                        isCircleSelected = true;
                        lblInstructions.setText("<html><h2>Nice.. Now Select The Star</h2></html>");
                        lblInstructions1.setVisible(false);
                    } else {
                        lblInstructions1.setVisible(true);
                    }
                } else if (oval.contains(p)) {
                    if (isTriangleSelected) {
                        isOvalSelected = true;
                        lblInstructions.setText("<html><h2>Nice.. Now Select The Square</h2></html>");
                        lblInstructions1.setVisible(false);
                    } else {
                        lblInstructions1.setVisible(true);
                    }
                } else if (star.contains(p)) {
                    if (isTriangleSelected && isOvalSelected && isSquareSelected && isSemiCircleSelected && isCircleSelected) {
                        isStarSelected = true;
                        lblInstructions.setText("<html><h2>Good.. Now Select The Rectangle</h2></html>");
                        lblInstructions1.setVisible(false);
                    } else {
                        lblInstructions1.setVisible(true);
                    }
                } else if (semiCircle.contains(p)) {
                    if (isTriangleSelected && isOvalSelected && isSquareSelected) {
                        isSemiCircleSelected = true;
                        lblInstructions.setText("<html><h2>Great.. Now Select The Circle</h2></html>");
                        lblInstructions1.setVisible(false);
                    } else {
                        lblInstructions1.setVisible(true);
                    }
                }
                repaint();
            }
        });

    }

    public static void main(String[] args) {

        FindShape findShape = new FindShape();
        NavBar nb = new NavBar();
        nb.add(findShape);

        frame.getContentPane().add(findShape);
        frame.setSize(1400, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
