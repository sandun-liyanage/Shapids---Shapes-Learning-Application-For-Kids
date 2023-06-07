import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class FindShapeLevel2 extends JPanel {
    static JFrame frame;
    private Shape rhombus, parallelogram, trapezium, pentagon, hexagon, heptagon, octagon;

    private boolean isRhombusSelected = false;
    private boolean isParallelogramSelected = false;
    private boolean isPentagonSelected = false;
    private boolean isHexagonSelected = false;
    private boolean isTrapeziumSelected = false;
    private boolean isHeptagonSelected = false;
    private boolean isOctagonSelected = false;
    private static final int SIDE_LENGTH = 50;
    private static final String RHOMBUS_TEXT = "RHOMBUS", PARALLELOGRAM_TEXT = "PARALLELOGRAM", PENTAGON_TEXT = "PENTAGON", HEXAGON_TEXT = "HEXAGON", TRAPEZIUM_TEXT = "TRAPEZIUM", HEPTAGON_TEXT = "HEPTAGON", OCTAGON_TEXT = "OCTAGON";
    String htmlInstructions = "<html><h1>Select the Octagon</h1></html>";

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        /* Rhombus */
        int rhombusXposition = ((getWidth() / 4) - 200) / 2;
        int[] xValueRhombus = {rhombusXposition, 100 + rhombusXposition, 200 + rhombusXposition, 100 + rhombusXposition};
        int[] yValueRhombus = {190, 290, 190, 90};
        rhombus = new Polygon(xValueRhombus, yValueRhombus, 4);

        /* Parallelogram */
        int parallelogramXposition = (getWidth() / 4) + ((getWidth() / 4) - 300) / 2;
        int[] xValueParallelogram = {parallelogramXposition, 200 + parallelogramXposition, 300 + parallelogramXposition, 100 + parallelogramXposition};
        int[] yValueParallelogram = {135, 135, 260, 260};
        parallelogram = new Polygon(xValueParallelogram, yValueParallelogram, 4);

        /* Trapezium */
        int trapeziumXposition = (2 * getWidth() / 4) + ((getWidth() / 4) - 250) / 2;
        int[] xValueTrapezium = {50 + trapeziumXposition, 200 + trapeziumXposition, 250 + trapeziumXposition, trapeziumXposition};
        int[] yValueTrapezium = {150, 150, 250, 250};
        trapezium = new Polygon(xValueTrapezium, yValueTrapezium, 4);

        /* Pentagon */
        int centerX2 = ((3 * getWidth()) / 4) + ((getWidth() / 4)) / 2;
        int centerY2 = getHeight() / 2;
        int radius2 = 100;

        int sides = 5;
        int[] xValuePentagon = new int[sides];
        int[] yValuePentagon = new int[sides];

        double angle1 = Math.toRadians(55); // Starting angle
        double angleIncrement = 2 * Math.PI / sides;
        // Calculate the coordinates for the pentagon
        for (int i = 0; i < sides; i++) {

            xValuePentagon[i] = (int) (centerX2 + radius2 * Math.cos(angle1));
            yValuePentagon[i] = (int) (centerY2 + radius2 * Math.sin(angle1));
            angle1 += angleIncrement;

            //xValuePentagon[i] += 300;
            yValuePentagon[i] += -150;
        }

        pentagon = new Polygon(xValuePentagon, yValuePentagon, 5);

        /* Hexagon */
        int centerXHexagon = (getWidth() / 4) / 2;
        int centerYHexagon = getHeight() / 2;
        int radiusHexagon = SIDE_LENGTH * 2;

        // Calculate the x and y coordinates of the seven points on the circumference of the circle
        int[] xValueHexagon = new int[6];
        int[] yValueHexagon = new int[6];
        for (int a = 0; a < 6; a++) {

            double angle = Math.toRadians((double) (a * 360) / 6);

            xValueHexagon[a] = (int) Math.round(centerXHexagon + radiusHexagon * Math.cos(angle));
            yValueHexagon[a] = (int) Math.round(centerYHexagon + radiusHexagon * Math.sin(angle));

            //xValueHexagon[a] -= 180;
            yValueHexagon[a] += 140;

        }

        hexagon = new Polygon(xValueHexagon, yValueHexagon, 6);

        /* Heptagon */
        int centerX = (getWidth() / 4) + ((getWidth() / 4)) / 2;
        int centerY = getHeight() / 2;
        int radius = SIDE_LENGTH * 2;

        // Calculate the x and y coordinates of the seven points on the circumference of the circle
        int[] xValueHeptagon = new int[7];
        int[] yValueHeptagon = new int[7];
        for (int a = 0; a < 7; a++) {

            double angle = Math.toRadians((double) (a * 360) / 7);

            xValueHeptagon[a] = (int) Math.round(centerX + radius * Math.cos(angle));
            yValueHeptagon[a] = (int) Math.round(centerY + radius * Math.sin(angle));

            //xValueHeptagon[a] -= 180;
            yValueHeptagon[a] += 140;

        }
        heptagon = new Polygon(xValueHeptagon, yValueHeptagon, 7);

        /* Octagon */
        int centerX1 = (2 * getWidth() / 4) + ((getWidth() / 4)) / 2;
        int centerY1 = getHeight() / 2;
        int radius1 = 100; // Adjust the radius as needed

        int[] xValueOctagon = new int[8];
        int[] yValueOctagon = new int[8];

        // Calculate the coordinates for the octagon
        for (int i = 0; i < 8; i++) {
            double angle = Math.toRadians(45 * i);
            xValueOctagon[i] = (int) (centerX1 + radius1 * Math.cos(angle));
            yValueOctagon[i] = (int) (centerY1 + radius1 * Math.sin(angle));

            //xValueOctagon[i] += 170;
            yValueOctagon[i] += 140;
        }
        octagon = new Polygon(xValueOctagon, yValueOctagon, 8);

        /* Frame Borders of Shape */
        g2d.draw(rhombus);
        g2d.draw(parallelogram);
        g2d.draw(trapezium);
        g2d.draw(pentagon);
        g2d.draw(hexagon);
        g2d.draw(heptagon);
        g2d.draw(octagon);

        /* Rounded Rectangle */
        int width = 300;
        int height = 300;
        int arcWidth = 50;
        int arcHeight = 50;

        /* String Font Size */
        Font font = new Font("Arial", Font.BOLD, 30);
        g.setFont(font);
        FontMetrics fm = g.getFontMetrics();

        if (isRhombusSelected) {

            g2d.setColor(Color.decode("#E0144C"));
            g2d.fill(rhombus);

            // Get the size of the text
            int txtWidth = fm.stringWidth(RHOMBUS_TEXT);
            int txtHeight = fm.getHeight();
            // Draw the text in the center of the panel
            int x = ((getWidth() / 4) - txtWidth) / 2;
            int y = (getHeight() - txtHeight) / 2 + fm.getAscent();
            g.drawString(RHOMBUS_TEXT, x, 330);

            g2d.setStroke(new BasicStroke(5));
            g2d.drawRoundRect(((getWidth() / 4) - 300) / 2, 70, width, height, arcWidth, arcHeight);
        }

        if (isParallelogramSelected) {

            g2d.setColor(Color.decode("#E38B29"));
            g2d.fill(parallelogram);

            // Get the size of the text
            int txtWidth = fm.stringWidth(PARALLELOGRAM_TEXT);
            int txtHeight = fm.getHeight();
            // Draw the text in the center of the panel
            int x = ((3 * getWidth() / 4) - txtWidth) / 2;
            int y = (getHeight() - txtHeight) / 2 + fm.getAscent();
            g.drawString(PARALLELOGRAM_TEXT, x, 330);

            g2d.setStroke(new BasicStroke(5));
            g2d.drawRoundRect((getWidth() / 4) + ((getWidth() / 4) - 300) / 2, 70, width, height, arcWidth, arcHeight);
        }

        if (isTrapeziumSelected) {

            g2d.setColor(Color.decode("#14C38E"));
            g2d.fill(trapezium);

            // Get the size of the text
            int txtWidth = fm.stringWidth(TRAPEZIUM_TEXT);
            int txtHeight = fm.getHeight();
            // Draw the text in the center of the panel
            int x = ((5 * getWidth() / 4) - txtWidth) / 2;
            int y = (getHeight() - txtHeight) / 2 + fm.getAscent();
            g.drawString(TRAPEZIUM_TEXT, x, 330);

            g2d.setStroke(new BasicStroke(5));
            g2d.drawRoundRect(((2 * getWidth()) / 4) + ((getWidth() / 4) - 300) / 2, 70, width, height, arcWidth, arcHeight);
        }

        if (isPentagonSelected) {

            g2d.setColor(Color.decode("#F56EB3"));
            g2d.fill(pentagon);

            // Get the size of the text
            int txtWidth = fm.stringWidth(PENTAGON_TEXT);
            int txtHeight = fm.getHeight();
            // Draw the text in the center of the panel
            int x = ((7 * getWidth() / 4) - txtWidth) / 2;
            int y = (getHeight() - txtHeight) / 2 + fm.getAscent();
            g.drawString(PENTAGON_TEXT, x, 330);

            g2d.setStroke(new BasicStroke(5));
            g2d.drawRoundRect(((3 * getWidth()) / 4) + ((getWidth() / 4) - 300) / 2, 70, width, height, arcWidth, arcHeight);
        }

        if (isHexagonSelected) {

            g2d.setColor(Color.decode("#FE6244"));
            g2d.fill(hexagon);

            // Get the size of the text
            int txtWidth = fm.stringWidth(HEXAGON_TEXT);
            int txtHeight = fm.getHeight();
            // Draw the text in the center of the panel
            int x = ((getWidth() / 4) - txtWidth) / 2;
            int y = (getHeight() - txtHeight) / 2 + fm.getAscent();
            g.drawString(HEXAGON_TEXT, x, (getHeight() / 2) + 280);

            g2d.setStroke(new BasicStroke(5));
            g2d.drawRoundRect(((getWidth() / 4) - 300) / 2, 370, width, height, arcWidth, arcHeight);
        }

        if (isHeptagonSelected) {

            g2d.setColor(Color.decode("#A31ACB"));
            g2d.fill(heptagon);

            // Get the size of the text
            int txtWidth = fm.stringWidth(HEPTAGON_TEXT);
            int txtHeight = fm.getHeight();
            // Draw the text in the center of the panel
            int x = ((3 * getWidth() / 4) - txtWidth) / 2;
            int y = (getHeight() - txtHeight) / 2 + fm.getAscent();
            g.drawString(HEPTAGON_TEXT, x, (getHeight() / 2) + 280);

            g2d.setStroke(new BasicStroke(5));
            g2d.drawRoundRect((getWidth() / 4) + ((getWidth() / 4) - 300) / 2, 370, width, height, arcWidth, arcHeight);
        }

        if (isOctagonSelected) {

            g2d.setColor(Color.decode("#0081B4"));
            g2d.fill(octagon);

            // Get the size of the text
            int txtWidth = fm.stringWidth(OCTAGON_TEXT);
            int txtHeight = fm.getHeight();
            // Draw the text in the center of the panel
            int x = ((5 * getWidth() / 4) - txtWidth) / 2;
            int y = (getHeight() - txtHeight) / 2 + fm.getAscent();
            g.drawString(OCTAGON_TEXT, x, (getHeight() / 2) + 280);

            g2d.setStroke(new BasicStroke(5));
            g2d.drawRoundRect(((2 * getWidth()) / 4) + ((getWidth() / 4) - 300) / 2, 370, width, height, arcWidth, arcHeight);
        }

        g2d.setColor(Color.BLACK);

        g2d.setStroke(new BasicStroke(5));
        g2d.drawRoundRect(((3 * getWidth()) / 4) + ((getWidth() / 4) - 300) / 2, 370, width, height, arcWidth, arcHeight);
    }

    public FindShapeLevel2() {

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
        lblInstructions2.setBounds(1075, 140, 290, 700);
        lblInstructions2.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        add(lblInstructions2);


        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point p = e.getPoint();

                if (rhombus.contains(p)) {
                    if (isOctagonSelected) {
                        isRhombusSelected = true;
                        lblInstructions.setText("<html><h2>Nice.. Now Select The Trapezium</h2></html>");
                        lblInstructions1.setVisible(false);
                    } else {
                        lblInstructions1.setVisible(true);
                    }
                } else if (parallelogram.contains(p)) {
                    if (isOctagonSelected && isRhombusSelected && isTrapeziumSelected && isHeptagonSelected && isPentagonSelected && isHexagonSelected) {
                        isParallelogramSelected = true;
                        lblInstructions.setText("<html><h2>Awesome.. you found all shapes correctly</h2></html>");
                        lblInstructions1.setVisible(false);
                        //btnColor.setVisible(true);
                    } else {
                        lblInstructions1.setVisible(true);
                    }
                } else if (trapezium.contains(p)) {
                    if (isOctagonSelected && isRhombusSelected) {
                        isTrapeziumSelected = true;
                        lblInstructions.setText("<html><h2>Nice.. Now Select The Heptagon</h2></html>");
                        lblInstructions1.setVisible(false);
                    } else {
                        lblInstructions1.setVisible(true);
                    }
                } else if (pentagon.contains(p)) {
                    if (isOctagonSelected && isRhombusSelected && isTrapeziumSelected && isHeptagonSelected) {
                        isPentagonSelected = true;
                        lblInstructions.setText("<html><h2>Nice.. Now Select The Hexagon</h2></html>");
                        lblInstructions1.setVisible(false);
                    } else {
                        lblInstructions1.setVisible(true);
                    }
                } else if (hexagon.contains(p)) {
                    if (isOctagonSelected && isRhombusSelected && isTrapeziumSelected && isHeptagonSelected && isPentagonSelected) {
                        isHexagonSelected = true;
                        lblInstructions.setText("<html><h2>Nice.. Now Select The parallelogram</h2></html>");
                        lblInstructions1.setVisible(false);
                    } else {
                        lblInstructions1.setVisible(true);
                    }
                } else if (heptagon.contains(p)) {
                    if (isOctagonSelected && isRhombusSelected && isTrapeziumSelected) {
                        isHeptagonSelected = true;
                        lblInstructions.setText("<html><h2>Nice.. Now Select The Pentagon</h2></html>");
                        lblInstructions1.setVisible(false);
                    } else {
                        lblInstructions1.setVisible(true);
                    }
                } else if (octagon.contains(p)) {
                    isOctagonSelected = true;
                    lblInstructions.setText("<html><h2>Good.. Now Select The Rhombus</h2></html>");
                    lblInstructions1.setVisible(false);
                } /*else {
                    isRectangleSelected = false;
                    isEllipseSelected = false;
                }*/
                repaint();
            }
        });

    }

    public static void main(String[] args) {

        FindShapeLevel2 findShape = new FindShapeLevel2();
        NavBar nb = new NavBar();
        nb.add(findShape);

        frame.getContentPane().add(findShape);
        frame.setSize(1400, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
