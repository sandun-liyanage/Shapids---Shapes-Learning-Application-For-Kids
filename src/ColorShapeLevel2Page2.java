import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class ColorShapeLevel2Page2 extends JPanel implements ActionListener {
    static JFrame frame;
    JPanel panelInstructions, row1, cell1, cell2, cell3, cell4, cell5;
    private static final int SIDE_LENGTH = 50;
    JLabel lblHeading;
    JButton btnColor, btnReset, btnPrevious, btnNext;
    private Shape rhombus,rhombus1, rectangle,rectangle1, trapezium, trapezium1, parallelogram, parallelogram1,parallelogram3,hexagon1,pentagon1,pentagon2,pentagon3,pentagon4,circle,circle1, hexagon, pentagon11, pentagon22, pentagon33, pentagon44;
    private boolean isParallelogramSelected = false, isRhombusSelected = false;
    private boolean isTrapeziumSelected = false, isRectangleSelected = false, isCircleSelected = false;
    private boolean isHexagonSelected = false, isTriangle4Selected = false;
    private boolean isCircle4Selected = false, isPentagon11Selected = false, isPentagon22Selected = false, isPentagon33Selected = false, isPentagon44Selected = false;
    private Color GLOBAL_COLOR, RHOMBUS_COLOR,RECTANGLE_COLOR, TRAPEZIUM_COLOR, PARALLELOGRAM_COLOR, CIRCLE_COLOR, HEXAGON_COLOR, PENTAGON11_COLOR, PENTAGON22_COLOR, PENTAGON33_COLOR, PENTAGON44_COLOR;
    private static final int IMG_WIDTH = 70;
    private static final int GAP = 4;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        /* Border */
        g2d.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());

        int rhombusXposition = ((getWidth() / 4) - 200) / 2;
        int[] xValueRhombus = {rhombusXposition+1100, 1200 + rhombusXposition, 1300 + rhombusXposition, 1200 + rhombusXposition};
        int[] yValueRhombus = {140, 240, 140, 40};
        rhombus = new Polygon(xValueRhombus, yValueRhombus, 4);

        int rhombusXposition1 = ((getWidth() / 4) - 200) / 2;
        int[] xValueRhombus1 = {rhombusXposition1+400, 500 + rhombusXposition1, 600 + rhombusXposition1, 500 + rhombusXposition1};
        int[] yValueRhombus1 = {140, 240, 140, 40};
        rhombus1 = new Polygon(xValueRhombus1, yValueRhombus1, 4);

        int trapeziumXposition = (2 * getWidth() / 4) + ((getWidth() / 4) - 250) / 2;
        int[] xValueTrapezium = {50 + trapeziumXposition, 200+trapeziumXposition, 250 + trapeziumXposition, trapeziumXposition};
        int[] yValueTrapezium = {470, 470, 570, 570};
        trapezium = new Polygon(xValueTrapezium, yValueTrapezium, 4);

        int trapeziumXposition1 = (2 * getWidth() / 4) + ((getWidth() / 4) - 250) / 2;
        int[] xValueTrapezium1 = {-650 + trapeziumXposition1, -500+trapeziumXposition1, -450 + trapeziumXposition1, -700+trapeziumXposition1};
        int[] yValueTrapezium1 = {470, 470, 570, 570};
        trapezium1 = new Polygon(xValueTrapezium1, yValueTrapezium1, 4);

        rectangle = new Rectangle2D.Double(((double) getWidth() / 4)+510, 360, 20, 110);

        rectangle1 = new Rectangle2D.Double(160, 270, 20, 200);

        int parallelogramXposition = (getWidth() / 4) + ((getWidth() / 4) - 50) / 2;
        int[] xValueParallelogram = {770+parallelogramXposition/5, 970 + parallelogramXposition/5, 1070 + parallelogramXposition/5, 870 + parallelogramXposition/5};
        int[] yValueParallelogram = {2085/5, 2085/5, 2210/5, 2210/5};
        parallelogram = new Polygon(xValueParallelogram, yValueParallelogram, 4);


        int parallelogramXposition3 = (getWidth() / 4) + ((getWidth() / 4) - 400) / 2;
        int[] xValueParallelogram3 = {100+parallelogramXposition3/5, 300 + parallelogramXposition3/5, 400 + parallelogramXposition3/5, 200 + parallelogramXposition3/5};
        int[] yValueParallelogram3 = {2085/5, 2085/5, 2210/5, 2210/5};
        parallelogram3 = new Polygon(xValueParallelogram3, yValueParallelogram3, 4);


        int centerXHexagon = (getWidth() / 4) / 2;
        int centerYHexagon = getHeight() / 2;
        int radiusHexagon = SIDE_LENGTH * 2;
        int[] xValueHexagon = new int[6];
        int[] yValueHexagon = new int[6];
        for (int a = 0; a < 6; a++) {

            double angle = Math.toRadians((double) (a * 360) / 6);

            xValueHexagon[a] = (int) Math.round(centerXHexagon + radiusHexagon * Math.cos(angle))/2;
            yValueHexagon[a] = (int) Math.round(centerYHexagon + radiusHexagon * Math.sin(angle))/2;

            xValueHexagon[a] += 780;
            yValueHexagon[a] += 80;

        }

        hexagon = new Polygon(xValueHexagon, yValueHexagon, 6);


        int centerXHexagon1 = (getWidth() / 4) / 2;
        int centerYHexagon1 = getHeight() / 2;
        int radiusHexagon1 = SIDE_LENGTH * 2;
        int[] xValueHexagon1 = new int[6];
        int[] yValueHexagon1 = new int[6];
        for (int a = 0; a < 6; a++) {

            double angle = Math.toRadians((double) (a * 360) / 6);

            xValueHexagon1[a] = (int) Math.round(centerXHexagon1 + radiusHexagon1 * Math.cos(angle))/2;
            yValueHexagon1[a] = (int) Math.round(centerYHexagon1 + radiusHexagon1 * Math.sin(angle))/2;

            xValueHexagon1[a] += 80;
            yValueHexagon1[a] += 80;

        }
        hexagon1 = new Polygon(xValueHexagon1, yValueHexagon1, 6);

        /*Pentagons*/

        int centerX2 = ((3 * getWidth()) / 4) +((getWidth() / 4)) / 2;
        int centerY2 = getHeight() / 2;
        int radius2 = 100;

        int sides = 5;
        int[] xValuePentagon = new int[sides];
        int[] yValuePentagon = new int[sides];

        double angle1 = Math.toRadians(55); // Starting angle
        double angleIncrement = 2 * Math.PI / sides;
        // Calculate the coordinates for the pentagon
        for (int i = 0; i < sides; i++) {

            xValuePentagon[i] = (int) (centerX2 + radius2 * Math.cos(angle1))/2;
            yValuePentagon[i] = (int) (centerY2 + radius2 * Math.sin(angle1))/2;
            angle1 += angleIncrement;

            xValuePentagon[i] += -440;
            yValuePentagon[i] += -3;
        }

        pentagon1 = new Polygon(xValuePentagon, yValuePentagon, 5);


        int centerX11 = ((3 * getWidth()) / 4) +((getWidth() / 4)) / 2;
        int centerY11 = getHeight() / 2;
        int radius11 = 100;

        int sides11 = 5;
        int[] xValuePentagon11 = new int[sides];
        int[] yValuePentagon11 = new int[sides];

        double angle11 = Math.toRadians(55); // Starting angle
        double angleIncrement11 = 2 * Math.PI / sides;
        // Calculate the coordinates for the pentagon
        for (int i = 0; i < sides; i++) {

            xValuePentagon11[i] = (int) (centerX11 + radius11 * Math.cos(angle11))/2;
            yValuePentagon11[i] = (int) (centerY11 + radius11 * Math.sin(angle11))/2;
            angle11 += angleIncrement11;

            xValuePentagon11[i] += 260;
            yValuePentagon11[i] += -3;
        }

        pentagon11 = new Polygon(xValuePentagon11, yValuePentagon11, 5);



        double angle2 = Math.toRadians(90); // Starting angle
        double angleIncrement2 = 2 * Math.PI / sides;
        // Calculate the coordinates for the pentagon
        for (int i = 0; i < sides; i++) {

            xValuePentagon[i] = (int) (centerX2 + radius2 * Math.cos(angle2))/2;
            yValuePentagon[i] = (int) (centerY2 + radius2 * Math.sin(angle2))/2;
            angle2 += angleIncrement2;

            xValuePentagon[i] += -440;
            yValuePentagon[i] += 160;
        }

        pentagon2 = new Polygon(xValuePentagon, yValuePentagon, 5);



        int[] xValuePentagon22 = new int[sides];
        int[] yValuePentagon22 = new int[sides];


        double angle22 = Math.toRadians(90); // Starting angle
        double angleIncrement22 = 2 * Math.PI / sides;
        // Calculate the coordinates for the pentagon
        for (int i = 0; i < sides; i++) {

            xValuePentagon22[i] = (int) (centerX2 + radius2 * Math.cos(angle22))/2;
            yValuePentagon22[i] = (int) (centerY2 + radius2 * Math.sin(angle22))/2;
            angle22 += angleIncrement22;

            xValuePentagon22[i] += 260;
            yValuePentagon22[i] += 165;
        }

        pentagon22 = new Polygon(xValuePentagon22, yValuePentagon22, 5);



        double angle3 = Math.toRadians(70); // Starting angle
        double angleIncrement3 = 2 * Math.PI / sides;
        // Calculate the coordinates for the pentagon
        for (int i = 0; i < sides; i++) {

            xValuePentagon[i] = (int) (centerX2 + radius2 * Math.cos(angle3))/2;
            yValuePentagon[i] = (int) (centerY2 + radius2 * Math.sin(angle3))/2;
            angle3 += angleIncrement3;

            xValuePentagon[i] += -360;
            yValuePentagon[i] += 80;
        }

        pentagon3 = new Polygon(xValuePentagon, yValuePentagon, 5);


        int[] xValuePentagon33 = new int[sides];
        int[] yValuePentagon33 = new int[sides];

        double angle33 = Math.toRadians(70); // Starting angle
        double angleIncrement33 = 2 * Math.PI / sides;
        // Calculate the coordinates for the pentagon
        for (int i = 0; i < sides; i++) {

            xValuePentagon33[i] = (int) (centerX2 + radius2 * Math.cos(angle33))/2;
            yValuePentagon33[i] = (int) (centerY2 + radius2 * Math.sin(angle33))/2;
            angle33 += angleIncrement33;

            xValuePentagon33[i] += 340;
            yValuePentagon33[i] += 80;
        }

        pentagon33 = new Polygon(xValuePentagon33, yValuePentagon33, 5);


        double angle4 = Math.toRadians(105); // Starting angle
        double angleIncrement4 = 2 * Math.PI / sides;
        // Calculate the coordinates for the pentagon
        for (int i = 0; i < sides; i++) {

            xValuePentagon[i] = (int) (centerX2 + radius2 * Math.cos(angle4))/2;
            yValuePentagon[i] = (int) (centerY2 + radius2 * Math.sin(angle4))/2;
            angle4 += angleIncrement4;

            xValuePentagon[i] += -520;
            yValuePentagon[i] += 80;
        }

        pentagon4 = new Polygon(xValuePentagon, yValuePentagon, 5);

        int[] xValuePentagon44 = new int[sides];
        int[] yValuePentagon44 = new int[sides];

        double angle44 = Math.toRadians(105); // Starting angle
        double angleIncrement44 = 2 * Math.PI / sides;
        // Calculate the coordinates for the pentagon
        for (int i = 0; i < sides; i++) {

            xValuePentagon44[i] = (int) (centerX2 + radius2 * Math.cos(angle44))/2;
            yValuePentagon44[i] = (int) (centerY2 + radius2 * Math.sin(angle44))/2;
            angle44 += angleIncrement44;

            xValuePentagon44[i] += 180;
            yValuePentagon44[i] += 80;
        }

        pentagon44 = new Polygon(xValuePentagon44, yValuePentagon44, 5);

        circle = new Ellipse2D.Double( 290, -50, 150, 150);

        circle1 = new Ellipse2D.Double( 990, -50, 150, 150);



        /* To be colored */
        g2d.draw(rhombus);
        g2d.draw(trapezium);
        g2d.draw(rectangle);
        g2d.draw(parallelogram);
        g2d.draw(circle1);
        g2d.draw(hexagon);
        g2d.draw(pentagon11);
        g2d.draw(pentagon22);
        g2d.draw(pentagon33);
        g2d.draw(pentagon44);

        g2d.drawArc(261,195,400,500,10,45);
        g2d.drawArc(961,195,400,500,10,45);


        /* Colored */

        g2d.setColor(Color.BLUE);
        g2d.fill(rhombus1);
        g2d.setColor(Color.BLACK);
        g2d.fill(trapezium1);
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fill(rectangle1);

        g2d.setColor(Color.GREEN);
        g2d.fill(parallelogram3);
        g2d.setColor(Color.PINK);
        g2d.fill(hexagon1);
        g2d.setColor(Color.RED);
        g2d.fill(pentagon1);
        g2d.setColor(Color.RED);
        g2d.fill(pentagon2);
        g2d.setColor(Color.RED);
        g2d.fill(pentagon3);
        g2d.setColor(Color.RED);
        g2d.fill(pentagon4);
        g2d.setColor(Color.YELLOW);
        g2d.fill(circle);




        if (isRhombusSelected) {

            g2d.setColor(RHOMBUS_COLOR);
            g2d.fill(rhombus);
        }

        if (isTrapeziumSelected) {

            g2d.setColor(TRAPEZIUM_COLOR);
            g2d.fill(trapezium);
        }

        if (isRectangleSelected) {

            g2d.setColor(RECTANGLE_COLOR);
            g2d.fill(rectangle);
        }
        if (isParallelogramSelected) {

            g2d.setColor(PARALLELOGRAM_COLOR);
            g2d.fill(parallelogram);
        }

        if (isCircleSelected) {

            g2d.setColor(CIRCLE_COLOR);
            g2d.fill(circle1);
        }
        if (isHexagonSelected) {

            g2d.setColor(HEXAGON_COLOR);
            g2d.fill(hexagon);
        }
        if (isPentagon11Selected) {

            g2d.setColor(PENTAGON11_COLOR);
            g2d.fill(pentagon11);
        }

        if (isPentagon22Selected) {

            g2d.setColor(PENTAGON22_COLOR);
            g2d.fill(pentagon22);
        }

        if (isPentagon33Selected) {

            g2d.setColor(PENTAGON33_COLOR);
            g2d.fill(pentagon33);
        }

        if (isPentagon44Selected) {

            g2d.setColor(PENTAGON44_COLOR);
            g2d.fill(pentagon44);
        }


    }

    public ColorShapeLevel2Page2() {

        /* Drawing Panel Background Color */
        setBackground(Color.decode("#fac8e6"));

        /* Shape icon on top of Button */
        int xBtn = GAP;
        int yBtn = xBtn;
        int widthBtn = IMG_WIDTH - 2 * xBtn;
        int heightBtn = IMG_WIDTH - 2 * yBtn;

        panelInstructions = new JPanel(new GridLayout(1, 1));

        row1 = new JPanel(new GridLayout(1, 3)); // Instructions

        cell1 = new JPanel(new GridLayout(1, 1)); // Previous
        cell2 = new JPanel(new GridLayout(1, 1)); // Title
        cell3 = new JPanel(new GridLayout(1, 1)); // Color Pad
        cell4 = new JPanel(new GridLayout(1, 1)); // Reset
        cell5 = new JPanel(new GridLayout(1, 1)); // Next


        row1.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
        GridLayout layoutRow1 = (GridLayout) row1.getLayout();
        layoutRow1.setHgap(20); // set horizontal padding


        cell1.setBorder(BorderFactory.createEmptyBorder(30, 40, 20, 30));
        GridLayout layoutCell1 = (GridLayout) cell1.getLayout();
        layoutCell1.setHgap(20); // set horizontal padding
        layoutCell1.setVgap(20); // set vertical padding

        cell3.setBorder(BorderFactory.createEmptyBorder(30, 60, 20, 60));
        GridLayout layoutCell3 = (GridLayout) cell3.getLayout();
        layoutCell3.setHgap(20); // set horizontal padding
        layoutCell3.setVgap(20); // set vertical padding

        cell4.setBorder(BorderFactory.createEmptyBorder(30, 60, 20, 60));
        GridLayout layoutCell4 = (GridLayout) cell4.getLayout();
        layoutCell4.setHgap(20); // set horizontal padding
        layoutCell4.setVgap(20); // set vertical padding

        cell5.setBorder(BorderFactory.createEmptyBorder(30, 40, 20, 40));
        GridLayout layoutCell5 = (GridLayout) cell5.getLayout();
        layoutCell5.setHgap(20); // set horizontal padding
        layoutCell5.setVgap(20); // set vertical padding

        btnPrevious = new JButton("<html><center>Previous</center></html>");
        btnPrevious.setBackground(Color.decode("#002147"));
        btnPrevious.setForeground(Color.decode("#FFFFFF"));
        btnPrevious.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        btnPrevious.addActionListener(this);
        cell1.add(btnPrevious);

        lblHeading = new JLabel("<html><center>Color the shapes in the Flower and Kite.</center></html>");
        lblHeading.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
        cell2.add(lblHeading);


        btnColor = new Utils.RoundedButton("<html><center>Choose Color</center></html>");
        btnColor.setBackground(Color.WHITE);
        btnColor.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        btnColor.addActionListener(this);
        cell3.add(btnColor);

        btnReset = new Utils.RoundedButton("<html><center>Reset</center></html>");
        btnReset.setBackground(Color.decode("#ff0404"));
        btnReset.setForeground(Color.WHITE);
        btnReset.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        btnColor.setBorder(new LineBorder(Color.BLACK));
        btnReset.addActionListener(this);
        cell4.add(btnReset);

        btnNext = new JButton("<html><center>Next</center></html>");
        btnNext.setBackground(Color.decode("#002147"));
        btnNext.setForeground(Color.decode("#FFFFFF"));
        btnNext.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        btnNext.addActionListener(this);
        cell5.add(btnNext);

        //row1.add(cell1);
        row1.add(cell2);
        row1.add(cell3);
        row1.add(cell4);
        //row1.add(cell5);

        row1.setBackground(Color.decode("#ffb0f7"));
        cell4.setBackground(Color.decode("#ffb0f7"));
        cell3.setBackground(Color.decode("#ffb0f7"));
        cell2.setBackground(Color.decode("#ffb0f7"));

        panelInstructions.add(row1);

        Dimension preferredSize = new Dimension(200, 100);
        panelInstructions.setPreferredSize(preferredSize);

        setLayout(new BorderLayout());
        add(panelInstructions, BorderLayout.SOUTH);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point p = e.getPoint();

                if (rhombus.contains(p)) {
                    isRhombusSelected = true;
                    RHOMBUS_COLOR = GLOBAL_COLOR;
                } else if (trapezium.contains(p)) {
                    isTrapeziumSelected = true;
                    TRAPEZIUM_COLOR = GLOBAL_COLOR;

                } else if (rectangle.contains(p)) {
                    isRectangleSelected = true;
                    RECTANGLE_COLOR = GLOBAL_COLOR;

                } else if (parallelogram.contains(p)) {
                    isParallelogramSelected = true;
                    PARALLELOGRAM_COLOR = GLOBAL_COLOR;

                } else if (circle1.contains(p)) {
                    isCircleSelected = true;
                    CIRCLE_COLOR = GLOBAL_COLOR;

                } else if (hexagon.contains(p)) {
                    isHexagonSelected = true;
                    HEXAGON_COLOR = GLOBAL_COLOR;

                } else if (pentagon11.contains(p)) {
                    isPentagon11Selected = true;
                    PENTAGON11_COLOR = GLOBAL_COLOR;

                } else if (pentagon22.contains(p)) {
                    isPentagon22Selected = true;
                    PENTAGON22_COLOR = GLOBAL_COLOR;
                }

                 else if (pentagon33.contains(p)) {
                isPentagon33Selected = true;
                PENTAGON33_COLOR = GLOBAL_COLOR;
                }
                else if (pentagon44.contains(p)) {
                    isPentagon44Selected = true;
                    PENTAGON44_COLOR = GLOBAL_COLOR;
                }

                repaint();
            }
        });

        btnNext.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnNext.setBackground(Color.decode("#009DDB")); // set hover color
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnNext.setBackground(Color.decode("#002147")); // set default color
            }
        });

        btnPrevious.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnPrevious.setBackground(Color.decode("#009DDB")); // set hover color
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnPrevious.setBackground(Color.decode("#002147")); // set default color
            }
        });

    }

    public static void main(String[] args) {

        ColorShapeLevel2Page2 colorShapePage2 = new ColorShapeLevel2Page2();
        NavBarLevel2 nb = new NavBarLevel2();
        nb.add(colorShapePage2);

        frame.getContentPane().add(colorShapePage2);
        frame.setSize(1400, 800);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //contentPane = this.getContentPane();

        if (e.getSource() == btnColor) {
            Color c = JColorChooser.showDialog(this, "Choose", btnColor.getBackground());
            btnColor.setBackground(c);
            GLOBAL_COLOR = c;
        } else if (e.getSource() == btnReset) {
            Color transparent = new Color(0, 0, 0, 0);
            RHOMBUS_COLOR = transparent;
            TRAPEZIUM_COLOR = transparent;
            RECTANGLE_COLOR = transparent;
            PARALLELOGRAM_COLOR = transparent;
            CIRCLE_COLOR = transparent;

            PENTAGON11_COLOR = transparent;

            PENTAGON22_COLOR = transparent;
            PENTAGON33_COLOR = transparent;
            PENTAGON44_COLOR = transparent;

        }
        repaint();
    }

}
