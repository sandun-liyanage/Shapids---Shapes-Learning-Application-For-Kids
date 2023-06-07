import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.prefs.Preferences;

public class DrawShape extends JPanel implements ActionListener {

    int x, y, w, h;
    int x1, y1, x2, y2, x3, y3, angle = 0;
    double sx = 1, sy = 1;
    int result;
    static JFrame frame;
    JPanel panelDimension, panelButton;
    JTextField txtScaleX, txtScaleY, txtRotateAngle;
    JButton btnDrawLine, btnDrawRectangle, btnDrawSquare, btnDrawTriangle, btnDrawCircle, btnClear, btnSave, btnColor, btnScale, btnRotate;
    private static Color SHAPE_COLOR = Color.WHITE;
    private final ArrayList<Line2D> lineList;
    private final ArrayList<Rectangle> rectangleList;
    private final ArrayList<Rectangle> squareList;
    private final ArrayList<Polygon> triangleList;
    private final ArrayList<Ellipse2D> circleList;

    private static final int IMG_WIDTH = 50;
    private static final int GAP = 4;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(SHAPE_COLOR);

        for (Line2D currentLine : lineList) {

            AffineTransform oldTransform = g2d.getTransform();

            double angleLine = Math.toRadians(angle);
            g2d.rotate(angleLine, x1, y1);
            g2d.scale(sx, sy);

            g2d.draw(currentLine);

            g2d.setTransform(oldTransform);
        }

        for (Rectangle currentRectangle : rectangleList) {

            AffineTransform oldTransform = g2d.getTransform();

            g2d.rotate(Math.toRadians(angle), currentRectangle.getCenterX(), currentRectangle.getCenterY());
            g2d.scale(sx, sy);

            g2d.fill(currentRectangle);
            g2d.setColor(Color.BLACK);
            g2d.draw(currentRectangle);

            g2d.setTransform(oldTransform);

        }

        for (Rectangle currentSquare : squareList) {

            AffineTransform oldTransform = g2d.getTransform();

            g2d.rotate(Math.toRadians(angle), currentSquare.getCenterX(), currentSquare.getCenterY());
            g2d.scale(sx, sy);

            g2d.fill(currentSquare);
            g2d.setColor(Color.BLACK);
            g2d.draw(currentSquare);

            g2d.setTransform(oldTransform);

        }

        for (Polygon currentTriangle : triangleList) {

            AffineTransform oldTransform = g2d.getTransform();

            double angleTriangle = Math.toRadians(angle);
            g2d.rotate(angleTriangle, x1, y1);
            g2d.scale(sx, sy);

            g2d.fill(currentTriangle);
            g2d.setColor(Color.BLACK);
            g2d.draw(currentTriangle);

            g2d.setTransform(oldTransform);
        }

        for (Ellipse2D currentCircle : circleList) {

            AffineTransform oldTransform = g2d.getTransform();

            g2d.scale(sx, sy);

            g2d.fill(currentCircle);
            g2d.setColor(Color.BLACK);
            g2d.draw(currentCircle);

            g2d.setTransform(oldTransform);
        }

    }



    public DrawShape() {
        /* Initializing array lists */
        lineList = new ArrayList<Line2D>();
        rectangleList = new ArrayList<Rectangle>();
        squareList = new ArrayList<Rectangle>();
        triangleList = new ArrayList<Polygon>();
        circleList = new ArrayList<Ellipse2D>();

        /* Drawing Panel Background Color */
        setBackground(Color.WHITE);

        /* Shape icon on top of Button */
        int xBtn = GAP;
        int yBtn = xBtn;
        int widthBtn = IMG_WIDTH - 2 * xBtn;
        int heightBtn = IMG_WIDTH - 2 * yBtn;

        BufferedImage lineImg = new BufferedImage(IMG_WIDTH, IMG_WIDTH, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = lineImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLACK);
        g2.drawLine(xBtn, yBtn, widthBtn, heightBtn);
        g2.dispose();

        BufferedImage rectangleImg = new BufferedImage(IMG_WIDTH, IMG_WIDTH, BufferedImage.TYPE_INT_ARGB);
        g2 = rectangleImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLACK);
        g2.fillRect(xBtn, yBtn * 4, widthBtn * 2, heightBtn / 2);
        g2.dispose();

        BufferedImage squareImg = new BufferedImage(IMG_WIDTH, IMG_WIDTH, BufferedImage.TYPE_INT_ARGB);
        g2 = squareImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLACK);
        g2.fillRect(xBtn, yBtn, widthBtn, heightBtn);
        g2.dispose();

        BufferedImage triangleImg = new BufferedImage(IMG_WIDTH, IMG_WIDTH, BufferedImage.TYPE_INT_ARGB);
        g2 = triangleImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLACK);
        g2.fillPolygon(new int[]{xBtn + widthBtn / 2, xBtn, xBtn + widthBtn}, new int[]{yBtn, yBtn + heightBtn, yBtn + heightBtn}, 3);
        g2.dispose();

        BufferedImage circleImg = new BufferedImage(IMG_WIDTH, IMG_WIDTH, BufferedImage.TYPE_INT_ARGB);
        g2 = circleImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLACK);
        g2.fillOval(xBtn, yBtn, widthBtn, heightBtn);
        g2.dispose();

        /* Draw buttons Panel */
        //frame = new JFrame("Draw Shape");
        panelButton = new JPanel(new GridLayout(7, 1));
        panelButton.setBackground(Color.decode("#f7c79c"));
        //panelButton.setBackground(Color.decode("#f8f4f4"));
        panelButton.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridLayout layout = (GridLayout) panelButton.getLayout();
        layout.setHgap(20); // set horizontal padding
        layout.setVgap(20); // set vertical padding

        JPanel row11 = new JPanel(new GridLayout(1, 2)); // Select shape
        JPanel row12 = new JPanel(new GridLayout(1, 2)); // Select shape
        JPanel row13 = new JPanel(new GridLayout(1, 2)); // Select shape
        JPanel row2 = new JPanel(new GridLayout(1, 1)); // Pad color
        JPanel row3 = new JPanel(new GridLayout(1, 5)); // Scaling
        JPanel row4 = new JPanel(new GridLayout(1, 3)); // Rotate
        JPanel row5 = new JPanel(new GridLayout(1, 1)); // Save, Clear

        row11.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        GridLayout layoutRow11 = (GridLayout) row11.getLayout();
        layoutRow11.setHgap(20); // set horizontal padding
        layoutRow11.setVgap(20); // set vertical padding

        row12.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        GridLayout layoutRow12 = (GridLayout) row12.getLayout();
        layoutRow12.setHgap(20); // set horizontal padding
        layoutRow12.setVgap(20); // set vertical padding

        row13.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        GridLayout layoutRow13 = (GridLayout) row13.getLayout();
        layoutRow13.setHgap(20); // set horizontal padding
        layoutRow13.setVgap(20); // set vertical padding

        row2.setBorder(BorderFactory.createEmptyBorder(10, 150, 10, 150));

        row3.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        GridLayout layoutRow3 = (GridLayout) row3.getLayout();
        layoutRow3.setHgap(20); // set horizontal padding
        layoutRow3.setVgap(20); // set vertical padding

        row4.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        GridLayout layoutRow4 = (GridLayout) row4.getLayout();
        layoutRow4.setHgap(20); // set horizontal padding
        layoutRow4.setVgap(20); // set vertical padding

        row5.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        GridLayout layoutRow5 = (GridLayout) row5.getLayout();
        layoutRow5.setHgap(30); // set horizontal padding
        layoutRow5.setVgap(20); // set vertical padding

        JLabel emptyLabel1 = new JLabel();

        /* Row 1 */
        btnDrawLine = new JButton("Draw Line");
        btnDrawLine.setIcon(new ImageIcon(lineImg));
        btnDrawLine.setContentAreaFilled(false);
        btnDrawLine.addActionListener(this);
        row11.add(btnDrawLine);

        btnDrawRectangle = new JButton("Draw Rectangle");
        btnDrawRectangle.setIcon(new ImageIcon(rectangleImg));
        btnDrawRectangle.setContentAreaFilled(false);
        btnDrawRectangle.addActionListener(this);
        row11.add(btnDrawRectangle);

        btnDrawSquare = new JButton("Draw Square");
        btnDrawSquare.setIcon(new ImageIcon(squareImg));
        btnDrawSquare.setContentAreaFilled(false);
        btnDrawSquare.addActionListener(this);
        row12.add(btnDrawSquare);

        btnDrawTriangle = new JButton("Draw Triangle");
        btnDrawTriangle.setIcon(new ImageIcon(triangleImg));
        btnDrawTriangle.setContentAreaFilled(false);
        btnDrawTriangle.addActionListener(this);
        row12.add(btnDrawTriangle);

        btnDrawCircle = new JButton("Draw Circle");
        btnDrawCircle.setIcon(new ImageIcon(circleImg));
        btnDrawCircle.setContentAreaFilled(false);
        btnDrawCircle.addActionListener(this);
        row13.add(btnDrawCircle);

        row13.add(emptyLabel1);

        /* Row 2 */
        btnColor = new Utils.RoundedButton("<html><center>Choose<br>Color</center></html>");
        btnColor.setBackground(Color.WHITE);
        btnColor.addActionListener(this);
        row2.add(btnColor);

        /* Row 3 */
        row3.add(new JLabel("Scale x:"));
        txtScaleX = new JTextField("1");
        row3.add(txtScaleX);

        row3.add(new JLabel("Scale y:"));
        txtScaleY = new JTextField("1");
        row3.add(txtScaleY);

        btnScale = new Utils.RoundedButton("Scale");
        btnScale.setBackground(Color.decode("#009FBD"));
        btnScale.setForeground(Color.WHITE);
        btnScale.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        btnScale.addActionListener(this);
        row3.add(btnScale);

        /* Row 4 */
        row4.add(new JLabel("Rotate Angle:"));
        txtRotateAngle = new JTextField("0");
        row4.add(txtRotateAngle);

        btnRotate = new Utils.RoundedButton("Rotate");
        btnRotate.setBackground(Color.decode("#576CBC"));
        btnRotate.setForeground(Color.WHITE);
        btnRotate.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        btnRotate.addActionListener(this);
        row4.add(btnRotate);

        /* Row 5 */
        btnSave = new Utils.RoundedButton("Save");
        //btnSave.setContentAreaFilled(false);
        btnSave.setBackground(Color.decode("#088404"));
        btnSave.setForeground(Color.WHITE);
        btnSave.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        btnSave.addActionListener(this);
        row5.add(btnSave);

        btnClear = new Utils.RoundedButton("Clear");
        //btnClear.setContentAreaFilled(false);
        btnClear.setBackground(Color.decode("#ff0404"));
        btnClear.setForeground(Color.WHITE);
        btnClear.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        btnClear.addActionListener(this);
        row5.add(btnClear);

        panelButton.add(row11);
        panelButton.add(row12);
        panelButton.add(row13);
        panelButton.add(row2);
        panelButton.add(row3);
        panelButton.add(row4);
        panelButton.add(row5);

        row11.setBackground(Color.decode("#f7c79c"));
        row12.setBackground(Color.decode("#f7c79c"));
        row13.setBackground(Color.decode("#f7c79c"));
        row2.setBackground(Color.decode("#f7c79c"));
        row3.setBackground(Color.decode("#f7c79c"));
        row4.setBackground(Color.decode("#f7c79c"));
        row5.setBackground(Color.decode("#f7c79c"));

        setLayout(new BorderLayout());
        add(panelButton, BorderLayout.EAST);

    }

    public DrawShape(String shapeName, int a, int b, int c, int d, int e, int f, Double scaleX, Double scaleY, int shapeAngle, String shapeColor) {
        /* Initializing array lists */
        lineList = new ArrayList<Line2D>();
        rectangleList = new ArrayList<Rectangle>();
        squareList = new ArrayList<Rectangle>();
        triangleList = new ArrayList<Polygon>();
        circleList = new ArrayList<Ellipse2D>();

        if (Objects.equals(shapeName, "Line")) {
            lineList.add(new Line2D.Double(a, b, c, d));
            SHAPE_COLOR = Utils.stringToColor(shapeColor);
            sx = scaleX;
            sy = scaleY;
            angle = shapeAngle;

        } else if (Objects.equals(shapeName, "Rectangle")) {
            rectangleList.add(new Rectangle(a, b, c, d));
            SHAPE_COLOR = Utils.stringToColor(shapeColor);
            sx = scaleX;
            sy = scaleY;
            angle = shapeAngle;

        } else if (Objects.equals(shapeName, "Square")) {
            squareList.add(new Rectangle(a, b, c, d));
            SHAPE_COLOR = Utils.stringToColor(shapeColor);
            sx = scaleX;
            sy = scaleY;
            angle = shapeAngle;

        } else if (Objects.equals(shapeName, "Triangle")) {
            triangleList.add(new Polygon(new int[]{a, c, e}, new int[]{b, d, f}, 3));
            SHAPE_COLOR = Utils.stringToColor(shapeColor);
            sx = scaleX;
            sy = scaleY;
            angle = shapeAngle;

        } else if (Objects.equals(shapeName, "Circle")) {
            circleList.add(new Ellipse2D.Double(a, b, c, d));
            SHAPE_COLOR = Utils.stringToColor(shapeColor);
            sx = scaleX;
            sy = scaleY;
            angle = shapeAngle;

        }
        repaint();


        /* Drawing Panel Background Color */
        setBackground(Color.WHITE);


        /* Shape icon on top of Button */
        int xBtn = GAP;
        int yBtn = xBtn;
        int widthBtn = IMG_WIDTH - 2 * xBtn;
        int heightBtn = IMG_WIDTH - 2 * yBtn;

        BufferedImage lineImg = new BufferedImage(IMG_WIDTH, IMG_WIDTH, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = lineImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLACK);
        g2.drawLine(xBtn, yBtn, widthBtn, heightBtn);
        g2.dispose();

        BufferedImage rectangleImg = new BufferedImage(IMG_WIDTH, IMG_WIDTH, BufferedImage.TYPE_INT_ARGB);
        g2 = rectangleImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLACK);
        g2.fillRect(xBtn, yBtn * 4, widthBtn * 2, heightBtn / 2);
        g2.dispose();

        BufferedImage squareImg = new BufferedImage(IMG_WIDTH, IMG_WIDTH, BufferedImage.TYPE_INT_ARGB);
        g2 = squareImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLACK);
        g2.fillRect(xBtn, yBtn, widthBtn, heightBtn);
        g2.dispose();

        BufferedImage triangleImg = new BufferedImage(IMG_WIDTH, IMG_WIDTH, BufferedImage.TYPE_INT_ARGB);
        g2 = triangleImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLACK);
        g2.fillPolygon(new int[]{xBtn + widthBtn / 2, xBtn, xBtn + widthBtn}, new int[]{yBtn, yBtn + heightBtn, yBtn + heightBtn}, 3);
        g2.dispose();

        BufferedImage circleImg = new BufferedImage(IMG_WIDTH, IMG_WIDTH, BufferedImage.TYPE_INT_ARGB);
        g2 = circleImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLACK);
        g2.fillOval(xBtn, yBtn, widthBtn, heightBtn);
        g2.dispose();

        /* Draw buttons Panel */
        //frame = new JFrame("Draw Shape");
        panelButton = new JPanel(new GridLayout(7, 1));
        panelButton.setBackground(Color.decode("#f7c79c"));
        panelButton.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridLayout layout = (GridLayout) panelButton.getLayout();
        layout.setHgap(20); // set horizontal padding
        layout.setVgap(20); // set vertical padding

        JPanel row11 = new JPanel(new GridLayout(1, 2)); // Select shape
        JPanel row12 = new JPanel(new GridLayout(1, 2)); // Select shape
        JPanel row13 = new JPanel(new GridLayout(1, 2)); // Select shape
        JPanel row2 = new JPanel(new GridLayout(1, 1)); // Pad color
        JPanel row3 = new JPanel(new GridLayout(1, 5)); // Scaling
        JPanel row4 = new JPanel(new GridLayout(1, 3)); // Rotate
        JPanel row5 = new JPanel(new GridLayout(1, 1)); // Save, Clear

        row11.setBackground(Color.decode("#f7c79c"));
        row12.setBackground(Color.decode("#f7c79c"));
        row13.setBackground(Color.decode("#f7c79c"));
        row2.setBackground(Color.decode("#f7c79c"));
        row3.setBackground(Color.decode("#f7c79c"));
        row4.setBackground(Color.decode("#f7c79c"));
        row5.setBackground(Color.decode("#f7c79c"));

        row11.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        GridLayout layoutRow11 = (GridLayout) row11.getLayout();
        layoutRow11.setHgap(20); // set horizontal padding
        layoutRow11.setVgap(20); // set vertical padding

        row12.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        GridLayout layoutRow12 = (GridLayout) row12.getLayout();
        layoutRow12.setHgap(20); // set horizontal padding
        layoutRow12.setVgap(20); // set vertical padding

        row13.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        GridLayout layoutRow13 = (GridLayout) row13.getLayout();
        layoutRow13.setHgap(20); // set horizontal padding
        layoutRow13.setVgap(20); // set vertical padding

        row2.setBorder(BorderFactory.createEmptyBorder(10, 150, 10, 150));
        //GridLayout layoutRow2 = (GridLayout) row2.getLayout();
        //layoutRow2.setHgap(10); // set horizontal padding
        //layoutRow2.setVgap(10); // set vertical padding

        row3.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        GridLayout layoutRow3 = (GridLayout) row3.getLayout();
        layoutRow3.setHgap(20); // set horizontal padding
        layoutRow3.setVgap(20); // set vertical padding

        row4.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        GridLayout layoutRow4 = (GridLayout) row4.getLayout();
        layoutRow4.setHgap(20); // set horizontal padding
        layoutRow4.setVgap(20); // set vertical padding

        row5.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        GridLayout layoutRow5 = (GridLayout) row5.getLayout();
        layoutRow5.setHgap(30); // set horizontal padding
        layoutRow5.setVgap(20); // set vertical padding

        JLabel emptyLabel1 = new JLabel();

        /* Row 1 */
        btnDrawLine = new JButton("Draw Line");
        btnDrawLine.setIcon(new ImageIcon(lineImg));
        btnDrawLine.setContentAreaFilled(false);
        btnDrawLine.addActionListener(this);
        row11.add(btnDrawLine);

        btnDrawRectangle = new JButton("Draw Rectangle");
        btnDrawRectangle.setIcon(new ImageIcon(rectangleImg));
        btnDrawRectangle.setContentAreaFilled(false);
        btnDrawRectangle.addActionListener(this);
        row11.add(btnDrawRectangle);

        btnDrawSquare = new JButton("Draw Square");
        btnDrawSquare.setIcon(new ImageIcon(squareImg));
        btnDrawSquare.setContentAreaFilled(false);
        btnDrawSquare.addActionListener(this);
        row12.add(btnDrawSquare);

        btnDrawTriangle = new JButton("Draw Triangle");
        btnDrawTriangle.setIcon(new ImageIcon(triangleImg));
        btnDrawTriangle.setContentAreaFilled(false);
        btnDrawTriangle.addActionListener(this);
        row12.add(btnDrawTriangle);

        btnDrawCircle = new JButton("Draw Circle");
        btnDrawCircle.setIcon(new ImageIcon(circleImg));
        btnDrawCircle.setContentAreaFilled(false);
        btnDrawCircle.addActionListener(this);
        row13.add(btnDrawCircle);

        row13.add(emptyLabel1);

        /* Row 2 */
        btnColor = new Utils.RoundedButton("<html><center>Choose<br>Color</center></html>");
        btnColor.setBackground(Color.WHITE);
        btnColor.addActionListener(this);
        row2.add(btnColor);

        /* Row 3 */
        row3.add(new JLabel("Scale x:"));
        txtScaleX = new JTextField("1");
        row3.add(txtScaleX);

        row3.add(new JLabel("Scale y:"));
        txtScaleY = new JTextField("1");
        row3.add(txtScaleY);

        btnScale = new Utils.RoundedButton("Scale");
        btnScale.setBackground(Color.decode("#009FBD"));
        btnScale.setForeground(Color.WHITE);
        btnScale.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        btnScale.addActionListener(this);
        row3.add(btnScale);

        /* Row 4 */
        row4.add(new JLabel("Rotate Angle:"));
        txtRotateAngle = new JTextField("0");
        row4.add(txtRotateAngle);

        btnRotate = new Utils.RoundedButton("Rotate");
        btnRotate.setBackground(Color.decode("#576CBC"));
        btnRotate.setForeground(Color.WHITE);
        btnRotate.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        btnRotate.addActionListener(this);
        row4.add(btnRotate);

        /* Row 5 */
        btnSave = new Utils.RoundedButton("Save");
        //btnSave.setContentAreaFilled(false);
        btnSave.setBackground(Color.decode("#32a852"));
        btnSave.setForeground(Color.WHITE);
        btnSave.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        btnSave.addActionListener(this);
        row5.add(btnSave);

        btnClear = new Utils.RoundedButton("Clear");
        //btnClear.setContentAreaFilled(false);
        btnClear.setBackground(Color.decode("#ff0404"));
        btnClear.setForeground(Color.WHITE);
        btnClear.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        btnClear.addActionListener(this);
        row5.add(btnClear);

        //panelButton.setLayout(new GridLayout(2, 1));
        panelButton.add(row11);
        panelButton.add(row12);
        panelButton.add(row13);
        panelButton.add(row2);
        panelButton.add(row3);
        panelButton.add(row4);
        panelButton.add(row5);


        setLayout(new BorderLayout());
        add(panelButton, BorderLayout.EAST);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Show the dialog box to get values for x, y, w, h
        panelDimension = new JPanel(new GridLayout(2, 4));

        if (e.getSource() == btnDrawLine) {

            panelDimension.add(new JLabel("Start x:"));
            JTextField xStartField = new JTextField(5);
            panelDimension.add(xStartField);

            panelDimension.add(new JLabel("End x:"));
            JTextField xEndField = new JTextField(5);
            panelDimension.add(xEndField);

            panelDimension.add(new JLabel("Start y:"));
            JTextField yStartField = new JTextField(5);
            panelDimension.add(yStartField);

            panelDimension.add(new JLabel("End y:"));
            JTextField yEndField = new JTextField(5);
            panelDimension.add(yEndField);

            result = JOptionPane.showConfirmDialog(this, panelDimension, "Create Line", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                // Get the values from the dialog box
                try {
                    x1 = Integer.parseInt(xStartField.getText());
                    y1 = Integer.parseInt(yStartField.getText());
                    x2 = Integer.parseInt(xEndField.getText());
                    y2 = Integer.parseInt(yEndField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid input");
                    return;
                }

                lineList.add(new Line2D.Double(x1, y1, x2, y2));

                // Repaint the frame to draw the shape
                //repaint();
            }

            rectangleList.clear();
            squareList.clear();
            triangleList.clear();
            circleList.clear();

        } else if (e.getSource() == btnDrawRectangle) {

            panelDimension.add(new JLabel("x:"));
            JTextField xField = new JTextField(5);
            panelDimension.add(xField);

            panelDimension.add(new JLabel("Width:"));
            JTextField wField = new JTextField(5);
            panelDimension.add(wField);

            panelDimension.add(new JLabel("y:"));
            JTextField yField = new JTextField(5);
            panelDimension.add(yField);

            panelDimension.add(new JLabel("Height:"));
            JTextField hField = new JTextField(5);
            panelDimension.add(hField);

            result = JOptionPane.showConfirmDialog(this, panelDimension, "Create Rectangle", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                // Get the values from the dialog box
                try {
                    x = Integer.parseInt(xField.getText());
                    y = Integer.parseInt(yField.getText());
                    w = Integer.parseInt(wField.getText());
                    h = Integer.parseInt(hField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid input");
                    return;
                }
                rectangleList.add(new Rectangle(x, y, w, h));
                // Repaint the frame to draw the shape
                //repaint();
            }

            lineList.clear();
            squareList.clear();
            triangleList.clear();
            circleList.clear();

        } else if (e.getSource() == btnDrawSquare) {

            panelDimension.add(new JLabel("x:"));
            JTextField xField = new JTextField(5);
            panelDimension.add(xField);

            panelDimension.add(new JLabel("Width:"));
            JTextField wField = new JTextField(5);
            panelDimension.add(wField);

            panelDimension.add(new JLabel("y:"));
            JTextField yField = new JTextField(5);
            panelDimension.add(yField);

            panelDimension.add(new JLabel(""));
            //JTextField hField = new JTextField(5);
            //panelDimension.add(hField);

            result = JOptionPane.showConfirmDialog(this, panelDimension, "Create Square", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                // Get the values from the dialog box
                try {
                    x = Integer.parseInt(xField.getText());
                    y = Integer.parseInt(yField.getText());
                    w = Integer.parseInt(wField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid input");
                    return;
                }

                squareList.add(new Rectangle(x, y, w, w));

                // Repaint the frame to draw the shape
                //repaint();
            }

            lineList.clear();
            rectangleList.clear();
            triangleList.clear();
            circleList.clear();

        } else if (e.getSource() == btnDrawTriangle) {

            panelDimension.add(new JLabel("x1:"));
            JTextField x1Field = new JTextField(5);
            panelDimension.add(x1Field);

            panelDimension.add(new JLabel("x2:"));
            JTextField x2Field = new JTextField(5);
            panelDimension.add(x2Field);

            panelDimension.add(new JLabel("x3:"));
            JTextField x3Field = new JTextField(5);
            panelDimension.add(x3Field);

            panelDimension.add(new JLabel("y1:"));
            JTextField y1Field = new JTextField(5);
            panelDimension.add(y1Field);

            panelDimension.add(new JLabel("y2:"));
            JTextField y2Field = new JTextField(5);
            panelDimension.add(y2Field);

            panelDimension.add(new JLabel("y3:"));
            JTextField y3Field = new JTextField(5);
            panelDimension.add(y3Field);

            result = JOptionPane.showConfirmDialog(this, panelDimension, "Create Triangle", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                // Get the values from the dialog box
                try {
                    x1 = Integer.parseInt(x1Field.getText());
                    x2 = Integer.parseInt(x2Field.getText());
                    x3 = Integer.parseInt(x3Field.getText());
                    y1 = Integer.parseInt(y1Field.getText());
                    y2 = Integer.parseInt(y2Field.getText());
                    y3 = Integer.parseInt(y3Field.getText());

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid input");
                    return;
                }

                triangleList.add(new Polygon(new int[]{x1, x2, x3}, new int[]{y1, y2, y3}, 3));

                // Repaint the frame to draw the shape
                //repaint();
            }

            lineList.clear();
            rectangleList.clear();
            squareList.clear();
            circleList.clear();

        } else if (e.getSource() == btnDrawCircle) {

            panelDimension.add(new JLabel("x:"));
            JTextField xField = new JTextField(5);
            panelDimension.add(xField);

            panelDimension.add(new JLabel("Width:"));
            JTextField wField = new JTextField(5);
            panelDimension.add(wField);

            panelDimension.add(new JLabel("y:"));
            JTextField yField = new JTextField(5);
            panelDimension.add(yField);

            panelDimension.add(new JLabel(""));
            //JTextField hField = new JTextField(5);
            //panelDimension.add(hField);

            result = JOptionPane.showConfirmDialog(this, panelDimension, "Create Circle", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                // Get the values from the dialog box
                try {
                    x = Integer.parseInt(xField.getText());
                    y = Integer.parseInt(yField.getText());
                    w = Integer.parseInt(wField.getText());
                    //h = Integer.parseInt(hField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid input");
                    return;
                }

                circleList.add(new Ellipse2D.Double(x, y, w, w));
                // Repaint the frame to draw the shape
                //repaint();
            }

            lineList.clear();
            rectangleList.clear();
            squareList.clear();
            triangleList.clear();

        } else if (e.getSource() == btnColor) {
            Color c = JColorChooser.showDialog(this, "Choose", btnColor.getBackground());
            btnColor.setBackground(c);
            SHAPE_COLOR = c;
        } else if (e.getSource() == btnScale) {
            sx = Double.parseDouble(txtScaleX.getText());
            sy = Double.parseDouble(txtScaleY.getText());
        } else if (e.getSource() == btnRotate) {
            angle = Integer.parseInt(txtRotateAngle.getText());
        } else if (e.getSource() == btnClear) {

            lineList.clear();
            rectangleList.clear();
            squareList.clear();
            triangleList.clear();
            circleList.clear();

        } else if (e.getSource() == btnSave) {

            System.out.println("Save");

            LocalDateTime currentDateTime = LocalDateTime.now();
            Preferences prefs = Preferences.userNodeForPackage(DrawShape.class);

            if (lineList.size() != 0) {
                prefs.put("line.name", "Line");
                prefs.put("line.x1", String.valueOf(x1));
                prefs.put("line.y1", String.valueOf(y1));
                prefs.put("line.x2", String.valueOf(x2));
                prefs.put("line.y2", String.valueOf(y2));
                prefs.put("line.color", SHAPE_COLOR.toString());
                prefs.put("line.sx", String.valueOf(sx));
                prefs.put("line.sy", String.valueOf(sy));
                prefs.put("line.angle", String.valueOf(angle));
                prefs.put("line.savedOn", String.valueOf(currentDateTime));
            } else if (rectangleList.size() != 0) {
                prefs.put("rectangle.name", "Rectangle");
                prefs.put("rectangle.x", String.valueOf(x));
                prefs.put("rectangle.y", String.valueOf(y));
                prefs.put("rectangle.w", String.valueOf(w));
                prefs.put("rectangle.h", String.valueOf(h));
                prefs.put("rectangle.color", SHAPE_COLOR.toString());
                prefs.put("rectangle.sx", String.valueOf(sx));
                prefs.put("rectangle.sy", String.valueOf(sy));
                prefs.put("rectangle.angle", String.valueOf(angle));
                prefs.put("rectangle.savedOn", String.valueOf(currentDateTime));
            } else if (squareList.size() != 0) {
                prefs.put("square.name", "Square");
                prefs.put("square.x", String.valueOf(x));
                prefs.put("square.y", String.valueOf(y));
                prefs.put("square.w", String.valueOf(w));
                prefs.put("square.color", SHAPE_COLOR.toString());
                prefs.put("square.sx", String.valueOf(sx));
                prefs.put("square.sy", String.valueOf(sy));
                prefs.put("square.angle", String.valueOf(angle));
                prefs.put("square.savedOn", String.valueOf(currentDateTime));
            } else if (triangleList.size() != 0) {
                prefs.put("triangle.name", "Triangle");
                prefs.put("triangle.x1", String.valueOf(x1));
                prefs.put("triangle.y1", String.valueOf(y1));
                prefs.put("triangle.x2", String.valueOf(x2));
                prefs.put("triangle.y2", String.valueOf(y2));
                prefs.put("triangle.x3", String.valueOf(x3));
                prefs.put("triangle.y3", String.valueOf(y3));
                prefs.put("triangle.color", SHAPE_COLOR.toString());
                prefs.put("triangle.sx", String.valueOf(sx));
                prefs.put("triangle.sy", String.valueOf(sy));
                prefs.put("triangle.angle", String.valueOf(angle));
                prefs.put("triangle.savedOn", String.valueOf(currentDateTime));
            } else if (circleList.size() != 0) {
                prefs.put("circle.name", "Circle");
                prefs.put("circle.x", String.valueOf(x));
                prefs.put("circle.y", String.valueOf(y));
                prefs.put("circle.w", String.valueOf(w));
                prefs.put("circle.color", SHAPE_COLOR.toString());
                prefs.put("circle.sx", String.valueOf(sx));
                prefs.put("circle.sy", String.valueOf(sy));
                prefs.put("circle.angle", String.valueOf(angle));
                prefs.put("circle.savedOn", String.valueOf(currentDateTime));
            }

            JOptionPane.showMessageDialog(null, "Your shape has been saved successfully. Navigate to the History to tab to view your shape.",
                    "Information", JOptionPane.INFORMATION_MESSAGE);

        }

        repaint();

    }

    public static void main(String[] args) {

        DrawShape drawShape = new DrawShape();
        NavBar nb = new NavBar();
        nb.add(drawShape);

        frame.getContentPane().add(drawShape);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
