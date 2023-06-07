import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class ColorShapePage2 extends JPanel implements ActionListener {
    static JFrame frame;
    JPanel panelInstructions, row1, cell1, cell2, cell3, cell4, cell5;
    JLabel lblHeading;
    JButton btnColor, btnReset, btnPrevious, btnNext;
    private Shape rectangle1, rectangle2, rectangle3, rectangle4, rectangle5, rectangle6, square1, square2, square3, square4, square5, square6, triangle1, triangle2, triangle3, triangle4, circle1, circle2, circle3, circle4, circle5, circle6;
    private boolean isRectangle2Selected = false, isRectangle4Selected = false;
    private boolean isSquare2Selected = false, isSquare4Selected = false, isSquare6Selected = false;
    private boolean isTriangle2Selected = false, isTriangle4Selected = false;
    private boolean isCircle4Selected = false, isCircle5Selected = false, isCircle6Selected = false;
    private Color GLOBAL_COLOR, RECTANGLE2_COLOR, RECTANGLE4_COLOR, SQUARE2_COLOR, SQUARE4_COLOR, SQUARE6_COLOR, TRIANGLE2_COLOR, TRIANGLE4_COLOR, CIRCLE4_COLOR, CIRCLE5_COLOR, CIRCLE6_COLOR;
    private static final int IMG_WIDTH = 70;
    private static final int GAP = 4;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        /* Border */
        g2d.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());

        /* Rectangle */
        rectangle1 = new Rectangle2D.Double(((double) getWidth() / 4) + 100, 100, 200, 300);
        rectangle2 = new Rectangle2D.Double(((double) (3 * getWidth()) / 4) + 100, 100, 200, 300);

        rectangle3 = new Rectangle2D.Double(((double) getWidth() / 4) + 100 - 25, 50, 250, 50);
        rectangle4 = new Rectangle2D.Double(((double) (3 * getWidth()) / 4) + 100 - 25, 50, 250, 50);

        rectangle5 = new Rectangle2D.Double(rectangle1.getBounds().x + rectangle1.getBounds().getWidth() / 2 - 37.5, 150, 75, 100);
        rectangle6 = new Rectangle2D.Double(rectangle2.getBounds().x + rectangle2.getBounds().getWidth() / 2 - 37.5, 150, 75, 100);

        /* Square */
        square1 = new Rectangle2D.Double(((double) getWidth() / 4) - 100, 200, 200, 200);
        square2 = new Rectangle2D.Double(((double) 3 * getWidth() / 4) - 100, 200, 200, 200);

        square3 = new Rectangle2D.Double(((double) getWidth() / 4) - 200, 300, 100, 100);
        square4 = new Rectangle2D.Double(((double) 3 * getWidth() / 4) - 200, 300, 100, 100);

        square5 = new Rectangle2D.Double(square1.getBounds().x, square1.getBounds().y - 50, 50, 50);
        square6 = new Rectangle2D.Double(square2.getBounds().x, square2.getBounds().y - 50, 50, 50);

        /* Triangle */
        int x1 = (getWidth() / 4) - 200;
        int x2 = (getWidth() / 4) - 200 + 100;
        int x3 = (getWidth() / 4) - 200 + 50;
        int[] xTriangle1Points = {x1, x2, x3};
        int[] yTriangle1Points = {300, 300, 200};
        triangle1 = new Polygon(xTriangle1Points, yTriangle1Points, 3);

        int x4 = (3 * getWidth() / 4) - 200;
        int x5 = (3 * getWidth() / 4) - 200 + 100;
        int x6 = (3 * getWidth() / 4) - 200 + 50;
        int[] xTriangle2Points = {x4, x5, x6};
        triangle2 = new Polygon(xTriangle2Points, yTriangle1Points, 3);

        int x7 = square1.getBounds().x;
        int x8 = square1.getBounds().x + 50;
        int x9 = square1.getBounds().x + 25;
        int[] xTriangle3Points = {x7, x8, x9};
        int[] yTriangle3Points = {square5.getBounds().y, square5.getBounds().y, square5.getBounds().y - 50};
        triangle3 = new Polygon(xTriangle3Points, yTriangle3Points, 3);

        int x10 = square2.getBounds().x;
        int x11 = square2.getBounds().x + 50;
        int x12 = square2.getBounds().x + 25;
        int[] xTriangle4Points = {x10, x11, x12};
        triangle4 = new Polygon(xTriangle4Points, yTriangle3Points, 3);

        /* Circle */
        circle1 = new Ellipse2D.Double(square1.getBounds().x, square1.getBounds().y + 200 - 50, 100, 100);
        circle2 = new Ellipse2D.Double(square1.getBounds().x + 120, square1.getBounds().y + 200 - 70, 120, 120);
        circle3 = new Ellipse2D.Double(square1.getBounds().x + 260, square1.getBounds().y + 200 - 70, 120, 120);

        circle4 = new Ellipse2D.Double(square2.getBounds().x, square2.getBounds().y + 200 - 50, 100, 100);
        circle5 = new Ellipse2D.Double(square2.getBounds().x + 120, square2.getBounds().y + 200 - 70, 120, 120);
        circle6 = new Ellipse2D.Double(square2.getBounds().x + 260, square2.getBounds().y + 200 - 70, 120, 120);


        /* Frame Borders of Shape */
        /* To be colored */
        g2d.draw(rectangle2);
        g2d.draw(rectangle4);

        g2d.draw(square2);
        g2d.draw(square4);
        g2d.draw(square6);

        g2d.draw(circle4);
        g2d.draw(circle5);
        g2d.draw(circle6);

        g2d.draw(triangle2);
        g2d.draw(triangle4);

        /* Colored */

        g2d.setColor(Color.GRAY);
        g2d.fill(rectangle1);
        g2d.setColor(Color.BLACK);
        g2d.fill(rectangle3);

        g2d.setColor(Color.BLUE);
        g2d.fill(square1);
        g2d.setColor(Color.PINK);
        g2d.fill(square3);
        g2d.setColor(Color.MAGENTA);
        g2d.fill(square5);

        g2d.setColor(Color.DARK_GRAY);
        g2d.fill(circle1);
        g2d.setColor(Color.BLACK);
        g2d.fill(circle2);
        g2d.fill(circle3);

        g2d.setColor(Color.GREEN);
        g2d.fill(triangle1);
        g2d.setColor(Color.ORANGE);
        g2d.fill(triangle3);


        if (isRectangle2Selected) {

            g2d.setColor(RECTANGLE2_COLOR);
            g2d.fill(rectangle2);
        }

        if (isRectangle4Selected) {

            g2d.setColor(RECTANGLE4_COLOR);
            g2d.fill(rectangle4);
        }

        if (isSquare2Selected) {

            g2d.setColor(SQUARE2_COLOR);
            g2d.fill(square2);

        }

        if (isSquare4Selected) {

            g2d.setColor(SQUARE4_COLOR);
            g2d.fill(square4);

        }

        if (isSquare6Selected) {

            g2d.setColor(SQUARE6_COLOR);
            g2d.fill(square6);

        }

        if (isTriangle2Selected) {

            g2d.setColor(TRIANGLE2_COLOR);
            g2d.fill(triangle2);
        }

        if (isTriangle4Selected) {

            g2d.setColor(TRIANGLE4_COLOR);
            g2d.fill(triangle4);
        }

        if (isCircle4Selected) {

            g2d.setColor(CIRCLE4_COLOR);
            g2d.fill(circle4);
        }

        if (isCircle5Selected) {

            g2d.setColor(CIRCLE5_COLOR);
            g2d.fill(circle5);
        }

        if (isCircle6Selected) {

            g2d.setColor(CIRCLE6_COLOR);
            g2d.fill(circle6);
        }

        g2d.setColor(Color.BLACK);
        g2d.fill(rectangle5);
        g2d.fill(rectangle6);

    }

    public ColorShapePage2() {

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

        lblHeading = new JLabel("<html><center>Color the shapes in the Train.</center></html>");
        lblHeading.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
        cell2.add(lblHeading);

        btnColor = new Utils.RoundedButton("<html><center>Choose Color</center></html>");
        btnColor.setBackground(Color.WHITE);
        btnColor.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        btnColor.addActionListener(this);
        btnColor.setBorder(new LineBorder(Color.BLACK));
        cell3.add(btnColor);

        btnReset = new Utils.RoundedButton("<html><center>Reset</center></html>");
        btnReset.setBackground(Color.decode("#ff0404"));
        btnReset.setForeground(Color.WHITE);
        btnReset.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        btnReset.addActionListener(this);
        cell4.add(btnReset);

        btnNext = new JButton("<html><center>Next</center></html>");
        btnNext.setBackground(Color.decode("#002147"));
        btnNext.setForeground(Color.decode("#FFFFFF"));
        btnNext.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        btnNext.addActionListener(this);
        cell5.add(btnNext);

        row1.add(cell2);
        row1.add(cell3);
        row1.add(cell4);

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

                if (rectangle2.contains(p)) {
                    isRectangle2Selected = true;
                    RECTANGLE2_COLOR = GLOBAL_COLOR;
                } else if (rectangle4.contains(p)) {
                    isRectangle4Selected = true;
                    RECTANGLE4_COLOR = GLOBAL_COLOR;
                } else if (square2.contains(p)) {
                    isSquare2Selected = true;
                    SQUARE2_COLOR = GLOBAL_COLOR;
                } else if (square4.contains(p)) {
                    isSquare4Selected = true;
                    SQUARE4_COLOR = GLOBAL_COLOR;
                } else if (square6.contains(p)) {
                    isSquare6Selected = true;
                    SQUARE6_COLOR = GLOBAL_COLOR;
                } else if (triangle2.contains(p)) {
                    isTriangle2Selected = true;
                    TRIANGLE2_COLOR = GLOBAL_COLOR;
                } else if (triangle4.contains(p)) {
                    isTriangle4Selected = true;
                    TRIANGLE4_COLOR = GLOBAL_COLOR;
                } else if (circle4.contains(p)) {
                    isCircle4Selected = true;
                    CIRCLE4_COLOR = GLOBAL_COLOR;
                } else if (circle5.contains(p)) {
                    isCircle5Selected = true;
                    CIRCLE5_COLOR = GLOBAL_COLOR;
                } else if (circle6.contains(p)) {
                    isCircle6Selected = true;
                    CIRCLE6_COLOR = GLOBAL_COLOR;
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

        ColorShapePage2 colorShapePage2 = new ColorShapePage2();
        NavBar nb = new NavBar();
        nb.add(colorShapePage2);

        frame.getContentPane().add(colorShapePage2);
        frame.setSize(1400, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
            RECTANGLE2_COLOR = transparent;
            RECTANGLE4_COLOR = transparent;
            SQUARE2_COLOR = transparent;
            SQUARE4_COLOR = transparent;
            SQUARE6_COLOR = transparent;
            TRIANGLE2_COLOR = transparent;
            TRIANGLE4_COLOR = transparent;
            CIRCLE4_COLOR = transparent;
            CIRCLE5_COLOR = transparent;
            CIRCLE6_COLOR = transparent;
        }
        repaint();
    }

}
