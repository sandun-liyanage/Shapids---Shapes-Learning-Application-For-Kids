import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.prefs.Preferences;

public class DrawShapeLevel2 extends JPanel implements ActionListener {

    // trapezium, rhombus, parallelogram, pentagon, hexagon, heptagon
    int xShape, yShape, wShape, hShape;
    int x1, y1, x2, y2, x3, y3, x4, y4, x5, y5, x6, y6, x7, y7, angle = 0;
    double sx = 1, sy = 1;
    int result;
    static JFrame frame;
    JPanel panelDimension, panelButton;
    JTextField txtScaleX, txtScaleY, txtRotateAngle;
    JButton btnDrawTrapezium, btnDrawRhombus, btnDrawParallelogram, btnDrawPentagon, btnDrawHexagon, btnDrawHeptagon, btnClear, btnSave, btnStrokeColor, btnColor, btnScale, btnRotate;
    private static Color STROKE_COLOR = Color.BLACK;
    private static Color SHAPE_COLOR = Color.WHITE;
    private final ArrayList<Polygon> trapeziumList;
    private final ArrayList<Rectangle> rhombusList;
    private final ArrayList<Polygon> parallelogramList;
    private final ArrayList<Polygon> pentagonList;
    private final ArrayList<Polygon> hexagonList;
    private final ArrayList<Polygon> heptagonList;
    private static final int IMG_WIDTH = 50;
    private static final int GAP = 4;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(SHAPE_COLOR);

        for (Polygon currentTrapezium : trapeziumList) {

            AffineTransform oldTransform = g2d.getTransform();

            double angleTrapezium = Math.toRadians(angle);
            g2d.rotate(angleTrapezium, 100, 100);
            g2d.scale(sx, sy);

            g2d.fill(currentTrapezium);
            g2d.setColor(STROKE_COLOR);
            g2d.draw(currentTrapezium);

            g2d.setTransform(oldTransform);
        }

        for (Rectangle currentRhombus : rhombusList) {

            AffineTransform oldTransform = g2d.getTransform();

            double angleRhombus = Math.toRadians(angle + 45);
            g2d.rotate(angleRhombus, xShape, yShape);
            g2d.scale(sx, sy);

            g2d.fill(currentRhombus);
            g2d.setColor(STROKE_COLOR);
            g2d.draw(currentRhombus);

            g2d.setTransform(oldTransform);
        }

        for (Polygon currentParallelogram : parallelogramList) {

            AffineTransform oldTransform = g2d.getTransform();

            double angleParallelogram = Math.toRadians(angle);
            g2d.rotate(angleParallelogram, 100, 100);
            g2d.scale(sx, sy);

            g2d.fill(currentParallelogram);
            g2d.setColor(STROKE_COLOR);
            g2d.draw(currentParallelogram);

            g2d.setTransform(oldTransform);
        }

        for (Polygon currentPentagon : pentagonList) {

            AffineTransform oldTransform = g2d.getTransform();

            double anglePentagon = Math.toRadians(angle);
            g2d.rotate(anglePentagon, xShape, yShape);
            g2d.scale(sx, sy);

            g2d.fill(currentPentagon);
            g2d.setColor(STROKE_COLOR);
            g2d.draw(currentPentagon);

            g2d.setTransform(oldTransform);
        }

        for (Polygon currentHexagon : hexagonList) {

            AffineTransform oldTransform = g2d.getTransform();

            double angleHexagon = Math.toRadians(angle);
            g2d.rotate(angleHexagon, xShape, yShape);
            g2d.scale(sx, sy);

            g2d.fill(currentHexagon);
            g2d.setColor(STROKE_COLOR);
            g2d.draw(currentHexagon);

            g2d.setTransform(oldTransform);
        }

        for (Polygon currentHeptagon : heptagonList) {

            AffineTransform oldTransform = g2d.getTransform();

            double angleHeptagon = Math.toRadians(angle);
            g2d.rotate(angleHeptagon, xShape, yShape);
            g2d.scale(sx, sy);

            g2d.fill(currentHeptagon);
            g2d.setColor(STROKE_COLOR);
            g2d.draw(currentHeptagon);

            g2d.setTransform(oldTransform);
        }

    }

    public DrawShapeLevel2() {
        /* Initializing array lists */
        trapeziumList = new ArrayList<Polygon>();
        rhombusList = new ArrayList<Rectangle>();
        parallelogramList = new ArrayList<Polygon>();
        pentagonList = new ArrayList<Polygon>();
        hexagonList = new ArrayList<Polygon>();
        heptagonList = new ArrayList<Polygon>();

        /* Drawing Panel Background Color */
        setBackground(Color.WHITE);

        /* Shape icon on top of Button */
        int xBtn = GAP;
        int yBtn = xBtn;
        int widthBtn = IMG_WIDTH - 2 * xBtn;
        int heightBtn = IMG_WIDTH - 2 * yBtn;

        BufferedImage trapeziumImg = new BufferedImage(IMG_WIDTH, IMG_WIDTH, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = trapeziumImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLACK);
        g2.fillPolygon(new int[]{xBtn + 10, xBtn + 10 + widthBtn / 2, xBtn + widthBtn, xBtn + 15 - widthBtn / 2}, new int[]{yBtn + 10, yBtn + 10, yBtn + 10 + heightBtn / 2, yBtn + 10 + heightBtn / 2}, 4);
        g2.dispose();

        BufferedImage rhombusImg = new BufferedImage(IMG_WIDTH, IMG_WIDTH, BufferedImage.TYPE_INT_ARGB);
        g2 = rhombusImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLACK);
        g2.rotate(Math.toRadians(45));
        g2.fillRect(xBtn + 20, yBtn - 10, widthBtn / 2, widthBtn / 2);
        g2.dispose();

        BufferedImage parallelogramImg = new BufferedImage(IMG_WIDTH, IMG_WIDTH, BufferedImage.TYPE_INT_ARGB);
        g2 = parallelogramImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLACK);
        g2.fillPolygon(new int[]{xBtn + 10, xBtn + 20 + widthBtn / 2, xBtn + 10 + widthBtn / 2, xBtn}, new int[]{yBtn + 10, yBtn + 10, yBtn + 10 + heightBtn / 2, yBtn + 10 + heightBtn / 2}, 4);
        g2.dispose();

        BufferedImage pentagonImg = new BufferedImage(IMG_WIDTH, IMG_WIDTH, BufferedImage.TYPE_INT_ARGB);
        g2 = pentagonImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int x = xBtn + 15, y = yBtn + 20;
        int radius = 20, sides = 5;
        int[] xPoints = new int[sides];
        int[] yPoints = new int[sides];
        for (int i = 0; i < sides; i++) {
            double angle = i * 2 * Math.PI / sides;
            xPoints[i] = (int) Math.round(x + radius * Math.cos(angle));
            yPoints[i] = (int) Math.round(y + radius * Math.sin(angle));
        }
        g2.setColor(Color.BLACK);
        //g2.fillPolygon(new int[]{xBtn, xBtn - widthBtn, xBtn + widthBtn}, new int[]{yBtn, yBtn + heightBtn, yBtn + heightBtn}, 3);
        g2.fillPolygon(xPoints, yPoints, sides);
        g2.dispose();

        BufferedImage hexagonImg = new BufferedImage(IMG_WIDTH, IMG_WIDTH, BufferedImage.TYPE_INT_ARGB);
        g2 = hexagonImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        x = xBtn + 15;
        y = yBtn + 20;
        sides = 6;
        xPoints = new int[sides];
        yPoints = new int[sides];
        for (int i = 0; i < sides; i++) {
            double angle = i * 2 * Math.PI / sides;
            xPoints[i] = (int) Math.round(x + radius * Math.cos(angle));
            yPoints[i] = (int) Math.round(y + radius * Math.sin(angle));
        }
        g2.setColor(Color.BLACK);
        g2.fillPolygon(xPoints, yPoints, sides);
        g2.dispose();

        BufferedImage heptagonImg = new BufferedImage(IMG_WIDTH, IMG_WIDTH, BufferedImage.TYPE_INT_ARGB);
        g2 = heptagonImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        x = xBtn + 15;
        y = yBtn + 20;
        sides = 7;
        xPoints = new int[sides];
        yPoints = new int[sides];
        for (int i = 0; i < sides; i++) {
            double angle = i * 2 * Math.PI / sides;
            xPoints[i] = (int) Math.round(x + radius * Math.cos(angle));
            yPoints[i] = (int) Math.round(y + radius * Math.sin(angle));
        }
        g2.setColor(Color.BLACK);
        //g2.fillPolygon(new int[]{xBtn, xBtn - widthBtn, xBtn + widthBtn}, new int[]{yBtn, yBtn + heightBtn, yBtn + heightBtn}, 3);
        g2.fillPolygon(xPoints, yPoints, sides);
        g2.dispose();

        /* Draw buttons Panel */
        //frame = new JFrame("Draw Shape");
        panelButton = new JPanel(new GridLayout(7, 1));
        //panelButton.setBackground(Color.decode("#f8f4f4"));
        panelButton.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridLayout layout = (GridLayout) panelButton.getLayout();
        layout.setHgap(20); // set horizontal padding
        layout.setVgap(20); // set vertical padding

        JPanel row11 = new JPanel(new GridLayout(1, 2)); // Select shape
        JPanel row12 = new JPanel(new GridLayout(1, 2)); // Select shape
        JPanel row13 = new JPanel(new GridLayout(1, 2)); // Select shape
        JPanel row2 = new JPanel(new GridLayout(1, 2)); // Pad color
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
        GridLayout layoutRow2 = (GridLayout) row2.getLayout();
        layoutRow2.setHgap(40); // set horizontal padding
        layoutRow2.setVgap(40); // set vertical padding

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

        /* Row 1 */
        btnDrawTrapezium = new JButton("Draw Trapezium");
        btnDrawTrapezium.setIcon(new ImageIcon(trapeziumImg));
        btnDrawTrapezium.setContentAreaFilled(false);
        btnDrawTrapezium.addActionListener(this);
        row11.add(btnDrawTrapezium);

        btnDrawRhombus = new JButton("Draw Rhombus");
        btnDrawRhombus.setIcon(new ImageIcon(rhombusImg));
        btnDrawRhombus.setContentAreaFilled(false);
        btnDrawRhombus.addActionListener(this);
        row11.add(btnDrawRhombus);

        btnDrawParallelogram = new JButton("Draw Parallelogram");
        btnDrawParallelogram.setIcon(new ImageIcon(parallelogramImg));
        btnDrawParallelogram.setContentAreaFilled(false);
        btnDrawParallelogram.addActionListener(this);
        row12.add(btnDrawParallelogram);

        btnDrawPentagon = new JButton("Draw Pentagon");
        btnDrawPentagon.setIcon(new ImageIcon(pentagonImg));
        btnDrawPentagon.setContentAreaFilled(false);
        btnDrawPentagon.addActionListener(this);
        row12.add(btnDrawPentagon);

        btnDrawHexagon = new JButton("Draw Hexagon");
        btnDrawHexagon.setIcon(new ImageIcon(hexagonImg));
        btnDrawHexagon.setContentAreaFilled(false);
        btnDrawHexagon.addActionListener(this);
        row13.add(btnDrawHexagon);

        btnDrawHeptagon = new JButton("Draw Heptagon");
        btnDrawHeptagon.setIcon(new ImageIcon(heptagonImg));
        btnDrawHeptagon.setContentAreaFilled(false);
        btnDrawHeptagon.addActionListener(this);
        row13.add(btnDrawHeptagon);

        /* Row 2 */
        btnStrokeColor = new Utils.RoundedButton("<html><center>Stroke<br>Color</center></html>");
        btnStrokeColor.setBackground(Color.BLACK);
        btnStrokeColor.addActionListener(this);
        row2.add(btnStrokeColor);

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
        btnScale.setBackground(Color.decode("#87CEEB"));
        btnScale.setForeground(Color.WHITE);
        btnScale.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        btnScale.addActionListener(this);
        row3.add(btnScale);

        /* Row 4 */
        row4.add(new JLabel("Rotate Angle:"));
        txtRotateAngle = new JTextField("0");
        row4.add(txtRotateAngle);

        btnRotate = new Utils.RoundedButton("Rotate");
        btnRotate.setBackground(Color.decode("#87CEEB"));
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

        panelButton.setBackground(Color.decode("#f7c79c"));

        //panelButton.setLayout(new GridLayout(2, 1));
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

    public DrawShapeLevel2(String shapeName, int a, int b, int c, int d, Double scaleX, Double scaleY, int shapeAngle, String shapeColor) {
        /* Initializing array lists */
        trapeziumList = new ArrayList<Polygon>();
        rhombusList = new ArrayList<Rectangle>();
        parallelogramList = new ArrayList<Polygon>();
        pentagonList = new ArrayList<Polygon>();
        hexagonList = new ArrayList<Polygon>();
        heptagonList = new ArrayList<Polygon>();

        if (Objects.equals(shapeName, "Trapezium")) {
            trapeziumList.add(new Polygon(new int[]{a + (c / 4), a + (c / 2), c, a}, new int[]{b, b, d, d}, 4));
            SHAPE_COLOR = Utils.stringToColor(shapeColor);
            sx = scaleX;
            sy = scaleY;
            angle = shapeAngle;

        } else if (Objects.equals(shapeName, "Rhombus")) {
            rhombusList.add(new Rectangle(a, b, c, c));
            SHAPE_COLOR = Utils.stringToColor(shapeColor);
            sx = scaleX;
            sy = scaleY;
            angle = shapeAngle;

        } else if (Objects.equals(shapeName, "Parallelogram")) {
            parallelogramList.add(new Polygon(new int[]{a + (c / 3), c, c - (c / 3), a}, new int[]{b, b, d, d}, 4));
            SHAPE_COLOR = Utils.stringToColor(shapeColor);
            sx = scaleX;
            sy = scaleY;
            angle = shapeAngle;

        } else if (Objects.equals(shapeName, "Pentagon")) {
            int x = a, y = b;
            int radius = c, sides = 5;
            int[] xPoints = new int[sides];
            int[] yPoints = new int[sides];
            for (int i = 0; i < sides; i++) {
                double angle = i * 2 * Math.PI / sides;
                xPoints[i] = (int) Math.round(x + radius * Math.cos(angle));
                yPoints[i] = (int) Math.round(y + radius * Math.sin(angle));
            }

            pentagonList.add(new Polygon(xPoints, yPoints, sides));
            SHAPE_COLOR = Utils.stringToColor(shapeColor);
            sx = scaleX;
            sy = scaleY;
            angle = shapeAngle;

        } else if (Objects.equals(shapeName, "Hexagon")) {
            int x = a, y = b;
            int radius = c, sides = 6;
            int[] xPoints = new int[sides];
            int[] yPoints = new int[sides];
            for (int i = 0; i < sides; i++) {
                double angle = i * 2 * Math.PI / sides;
                xPoints[i] = (int) Math.round(x + radius * Math.cos(angle));
                yPoints[i] = (int) Math.round(y + radius * Math.sin(angle));
            }

            hexagonList.add(new Polygon(xPoints, yPoints, sides));
            SHAPE_COLOR = Utils.stringToColor(shapeColor);
            sx = scaleX;
            sy = scaleY;
            angle = shapeAngle;

        } else if (Objects.equals(shapeName, "Heptagon")) {
            int x = a, y = b;
            int radius = c, sides = 7;
            int[] xPoints = new int[sides];
            int[] yPoints = new int[sides];
            for (int i = 0; i < sides; i++) {
                double angle = i * 2 * Math.PI / sides;
                xPoints[i] = (int) Math.round(x + radius * Math.cos(angle));
                yPoints[i] = (int) Math.round(y + radius * Math.sin(angle));
            }

            heptagonList.add(new Polygon(xPoints, yPoints, sides));
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

        BufferedImage trapeziumImg = new BufferedImage(IMG_WIDTH, IMG_WIDTH, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = trapeziumImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLACK);
        g2.fillPolygon(new int[]{xBtn + 10, xBtn + 10 + widthBtn / 2, xBtn + widthBtn, xBtn + 15 - widthBtn / 2}, new int[]{yBtn + 10, yBtn + 10, yBtn + 10 + heightBtn / 2, yBtn + 10 + heightBtn / 2}, 4);
        g2.dispose();

        BufferedImage rhombusImg = new BufferedImage(IMG_WIDTH, IMG_WIDTH, BufferedImage.TYPE_INT_ARGB);
        g2 = rhombusImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLACK);
        g2.rotate(Math.toRadians(45));
        g2.fillRect(xBtn + 20, yBtn - 10, widthBtn / 2, widthBtn / 2);
        g2.dispose();

        BufferedImage parallelogramImg = new BufferedImage(IMG_WIDTH, IMG_WIDTH, BufferedImage.TYPE_INT_ARGB);
        g2 = parallelogramImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLACK);
        g2.fillPolygon(new int[]{xBtn + 10, xBtn + 20 + widthBtn / 2, xBtn + 10 + widthBtn / 2, xBtn}, new int[]{yBtn + 10, yBtn + 10, yBtn + 10 + heightBtn / 2, yBtn + 10 + heightBtn / 2}, 4);
        g2.dispose();

        BufferedImage pentagonImg = new BufferedImage(IMG_WIDTH, IMG_WIDTH, BufferedImage.TYPE_INT_ARGB);
        g2 = pentagonImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int x = xBtn + 15, y = yBtn + 20;
        int radius = 20, sides = 5;
        int[] xPoints = new int[sides];
        int[] yPoints = new int[sides];
        for (int i = 0; i < sides; i++) {
            double angle = i * 2 * Math.PI / sides;
            xPoints[i] = (int) Math.round(x + radius * Math.cos(angle));
            yPoints[i] = (int) Math.round(y + radius * Math.sin(angle));
        }
        g2.setColor(Color.BLACK);
        //g2.fillPolygon(new int[]{xBtn, xBtn - widthBtn, xBtn + widthBtn}, new int[]{yBtn, yBtn + heightBtn, yBtn + heightBtn}, 3);
        g2.fillPolygon(xPoints, yPoints, sides);
        g2.dispose();

        BufferedImage hexagonImg = new BufferedImage(IMG_WIDTH, IMG_WIDTH, BufferedImage.TYPE_INT_ARGB);
        g2 = hexagonImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        x = xBtn + 15;
        y = yBtn + 20;
        sides = 6;
        xPoints = new int[sides];
        yPoints = new int[sides];
        for (int i = 0; i < sides; i++) {
            double angle = i * 2 * Math.PI / sides;
            xPoints[i] = (int) Math.round(x + radius * Math.cos(angle));
            yPoints[i] = (int) Math.round(y + radius * Math.sin(angle));
        }
        g2.setColor(Color.BLACK);
        g2.fillPolygon(xPoints, yPoints, sides);
        g2.dispose();

        BufferedImage heptagonImg = new BufferedImage(IMG_WIDTH, IMG_WIDTH, BufferedImage.TYPE_INT_ARGB);
        g2 = heptagonImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        x = xBtn + 15;
        y = yBtn + 20;
        sides = 7;
        xPoints = new int[sides];
        yPoints = new int[sides];
        for (int i = 0; i < sides; i++) {
            double angle = i * 2 * Math.PI / sides;
            xPoints[i] = (int) Math.round(x + radius * Math.cos(angle));
            yPoints[i] = (int) Math.round(y + radius * Math.sin(angle));
        }
        g2.setColor(Color.BLACK);
        //g2.fillPolygon(new int[]{xBtn, xBtn - widthBtn, xBtn + widthBtn}, new int[]{yBtn, yBtn + heightBtn, yBtn + heightBtn}, 3);
        g2.fillPolygon(xPoints, yPoints, sides);
        g2.dispose();

        /* Draw buttons Panel */
        //frame = new JFrame("Draw Shape");
        panelButton = new JPanel(new GridLayout(7, 1));
        //panelButton.setBackground(Color.decode("#f8f4f4"));
        panelButton.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridLayout layout = (GridLayout) panelButton.getLayout();
        layout.setHgap(20); // set horizontal padding
        layout.setVgap(20); // set vertical padding

        JPanel row11 = new JPanel(new GridLayout(1, 2)); // Select shape
        JPanel row12 = new JPanel(new GridLayout(1, 2)); // Select shape
        JPanel row13 = new JPanel(new GridLayout(1, 2)); // Select shape
        JPanel row2 = new JPanel(new GridLayout(1, 2)); // Pad color
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
        GridLayout layoutRow2 = (GridLayout) row2.getLayout();
        layoutRow2.setHgap(40); // set horizontal padding
        layoutRow2.setVgap(40); // set vertical padding

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

        /* Row 1 */
        btnDrawTrapezium = new JButton("Draw Trapezium");
        btnDrawTrapezium.setIcon(new ImageIcon(trapeziumImg));
        btnDrawTrapezium.setContentAreaFilled(false);
        btnDrawTrapezium.addActionListener(this);
        row11.add(btnDrawTrapezium);

        btnDrawRhombus = new JButton("Draw Rhombus");
        btnDrawRhombus.setIcon(new ImageIcon(rhombusImg));
        btnDrawRhombus.setContentAreaFilled(false);
        btnDrawRhombus.addActionListener(this);
        row11.add(btnDrawRhombus);

        btnDrawParallelogram = new JButton("Draw Parallelogram");
        btnDrawParallelogram.setIcon(new ImageIcon(parallelogramImg));
        btnDrawParallelogram.setContentAreaFilled(false);
        btnDrawParallelogram.addActionListener(this);
        row12.add(btnDrawParallelogram);

        btnDrawPentagon = new JButton("Draw Pentagon");
        btnDrawPentagon.setIcon(new ImageIcon(pentagonImg));
        btnDrawPentagon.setContentAreaFilled(false);
        btnDrawPentagon.addActionListener(this);
        row12.add(btnDrawPentagon);

        btnDrawHexagon = new JButton("Draw Hexagon");
        btnDrawHexagon.setIcon(new ImageIcon(hexagonImg));
        btnDrawHexagon.setContentAreaFilled(false);
        btnDrawHexagon.addActionListener(this);
        row13.add(btnDrawHexagon);

        btnDrawHeptagon = new JButton("Draw Heptagon");
        btnDrawHeptagon.setIcon(new ImageIcon(heptagonImg));
        btnDrawHeptagon.setContentAreaFilled(false);
        btnDrawHeptagon.addActionListener(this);
        row13.add(btnDrawHeptagon);

        /* Row 2 */
        btnStrokeColor = new Utils.RoundedButton("<html><center>Stroke<br>Color</center></html>");
        btnStrokeColor.setBackground(Color.BLACK);
        btnStrokeColor.addActionListener(this);
        row2.add(btnStrokeColor);

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
        btnScale.setBackground(Color.decode("#87CEEB"));
        btnScale.setForeground(Color.WHITE);
        btnScale.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        btnScale.addActionListener(this);
        row3.add(btnScale);

        /* Row 4 */
        row4.add(new JLabel("Rotate Angle:"));
        txtRotateAngle = new JTextField("0");
        row4.add(txtRotateAngle);

        btnRotate = new Utils.RoundedButton("Rotate");
        btnRotate.setBackground(Color.decode("#87CEEB"));
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

        //panelButton.setLayout(new GridLayout(2, 1));
        panelButton.add(row11);
        panelButton.add(row12);
        panelButton.add(row13);
        panelButton.add(row2);
        panelButton.add(row3);
        panelButton.add(row4);
        panelButton.add(row5);

        panelButton.setBackground(Color.decode("#f7c79c"));
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

    @Override
    public void actionPerformed(ActionEvent e) {

        // Show the dialog box to get values for x, y, w, h
        panelDimension = new JPanel(new GridLayout(2, 4));

        if (e.getSource() == btnDrawTrapezium) {

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

            result = JOptionPane.showConfirmDialog(this, panelDimension, "Create Trapezium", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                // Get the values from the dialog box
                try {
                    xShape = Integer.parseInt(xField.getText());
                    yShape = Integer.parseInt(yField.getText());
                    wShape = Integer.parseInt(wField.getText());
                    hShape = Integer.parseInt(hField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid input");
                    return;
                }

                trapeziumList.add(new Polygon(new int[]{xShape + (wShape / 4), xShape + (wShape / 2), wShape, xShape}, new int[]{yShape, yShape, hShape, hShape}, 4));
                // Repaint the frame to draw the shape
                //repaint();
            }

            rhombusList.clear();
            parallelogramList.clear();
            pentagonList.clear();
            hexagonList.clear();
            heptagonList.clear();

        } else if (e.getSource() == btnDrawRhombus) {

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

            result = JOptionPane.showConfirmDialog(this, panelDimension, "Create Rhombus", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                // Get the values from the dialog box
                try {
                    xShape = Integer.parseInt(xField.getText());
                    yShape = Integer.parseInt(yField.getText());
                    wShape = Integer.parseInt(wField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid input");
                    return;
                }

                rhombusList.add(new Rectangle(xShape, yShape, wShape, wShape));

                // Repaint the frame to draw the shape
                //repaint();
            }

            trapeziumList.clear();
            parallelogramList.clear();
            pentagonList.clear();
            hexagonList.clear();
            heptagonList.clear();

        } else if (e.getSource() == btnDrawParallelogram) {

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

            result = JOptionPane.showConfirmDialog(this, panelDimension, "Create Parallelogram", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                // Get the values from the dialog box
                try {
                    xShape = Integer.parseInt(xField.getText());
                    yShape = Integer.parseInt(yField.getText());
                    wShape = Integer.parseInt(wField.getText());
                    hShape = Integer.parseInt(hField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid input");
                    return;
                }

                parallelogramList.add(new Polygon(new int[]{xShape + (wShape / 3), wShape, wShape - (wShape / 3), xShape}, new int[]{yShape, yShape, hShape, hShape}, 4));
                // Repaint the frame to draw the shape
                //repaint();
            }

            trapeziumList.clear();
            rhombusList.clear();
            pentagonList.clear();
            hexagonList.clear();
            heptagonList.clear();

        } else if (e.getSource() == btnDrawPentagon) {

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

            result = JOptionPane.showConfirmDialog(this, panelDimension, "Create Pentagon", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                // Get the values from the dialog box
                try {
                    xShape = Integer.parseInt(xField.getText());
                    yShape = Integer.parseInt(yField.getText());
                    wShape = Integer.parseInt(wField.getText());
                    //h = Integer.parseInt(hField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid input");
                    return;
                }

                int x = xShape, y = yShape;
                int radius = wShape, sides = 5;
                int[] xPoints = new int[sides];
                int[] yPoints = new int[sides];
                for (int i = 0; i < sides; i++) {
                    double angle = i * 2 * Math.PI / sides;
                    xPoints[i] = (int) Math.round(x + radius * Math.cos(angle));
                    yPoints[i] = (int) Math.round(y + radius * Math.sin(angle));
                }

                pentagonList.add(new Polygon(xPoints, yPoints, sides));
                // Repaint the frame to draw the shape
                //repaint();
            }

            trapeziumList.clear();
            rhombusList.clear();
            parallelogramList.clear();
            hexagonList.clear();
            heptagonList.clear();

        } else if (e.getSource() == btnDrawHexagon) {

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

            result = JOptionPane.showConfirmDialog(this, panelDimension, "Create Hexagon", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                // Get the values from the dialog box
                try {
                    xShape = Integer.parseInt(xField.getText());
                    yShape = Integer.parseInt(yField.getText());
                    wShape = Integer.parseInt(wField.getText());
                    //h = Integer.parseInt(hField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid input");
                    return;
                }

                int x = xShape, y = yShape;
                int radius = wShape, sides = 6;
                int[] xPoints = new int[sides];
                int[] yPoints = new int[sides];
                for (int i = 0; i < sides; i++) {
                    double angle = i * 2 * Math.PI / sides;
                    xPoints[i] = (int) Math.round(x + radius * Math.cos(angle));
                    yPoints[i] = (int) Math.round(y + radius * Math.sin(angle));
                }

                hexagonList.add(new Polygon(xPoints, yPoints, sides));
                // Repaint the frame to draw the shape
                //repaint();
            }

            trapeziumList.clear();
            rhombusList.clear();
            parallelogramList.clear();
            pentagonList.clear();
            heptagonList.clear();

        } else if (e.getSource() == btnDrawHeptagon) {

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

            result = JOptionPane.showConfirmDialog(this, panelDimension, "Create Heptagon", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                // Get the values from the dialog box
                try {
                    xShape = Integer.parseInt(xField.getText());
                    yShape = Integer.parseInt(yField.getText());
                    wShape = Integer.parseInt(wField.getText());
                    //h = Integer.parseInt(hField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid input");
                    return;
                }

                int x = xShape, y = yShape;
                int radius = wShape, sides = 7;
                int[] xPoints = new int[sides];
                int[] yPoints = new int[sides];
                for (int i = 0; i < sides; i++) {
                    double angle = i * 2 * Math.PI / sides;
                    xPoints[i] = (int) Math.round(x + radius * Math.cos(angle));
                    yPoints[i] = (int) Math.round(y + radius * Math.sin(angle));
                }

                heptagonList.add(new Polygon(xPoints, yPoints, sides));
                // Repaint the frame to draw the shape
                //repaint();
            }

            trapeziumList.clear();
            rhombusList.clear();
            parallelogramList.clear();
            pentagonList.clear();
            hexagonList.clear();

        } else if (e.getSource() == btnStrokeColor) {
            Color c = JColorChooser.showDialog(this, "Choose Stroke Color", btnStrokeColor.getBackground());
            btnStrokeColor.setBackground(c);
            STROKE_COLOR = c;
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

            trapeziumList.clear();
            rhombusList.clear();
            parallelogramList.clear();
            pentagonList.clear();
            hexagonList.clear();
            heptagonList.clear();

        } else if (e.getSource() == btnSave) {

            LocalDateTime currentDateTime = LocalDateTime.now();
            Preferences prefs = Preferences.userNodeForPackage(DrawShape.class);

            if (trapeziumList.size() != 0) {
                prefs.put("trapezium.name", "Trapezium");
                prefs.put("trapezium.x", String.valueOf(xShape));
                prefs.put("trapezium.y", String.valueOf(yShape));
                prefs.put("trapezium.w", String.valueOf(wShape));
                prefs.put("trapezium.h", String.valueOf(hShape));
                prefs.put("trapezium.color", SHAPE_COLOR.toString());
                prefs.put("trapezium.sx", String.valueOf(sx));
                prefs.put("trapezium.sy", String.valueOf(sy));
                prefs.put("trapezium.angle", String.valueOf(angle));
                prefs.put("trapezium.savedOn", String.valueOf(currentDateTime));
            } else if (rhombusList.size() != 0) {
                prefs.put("rhombus.name", "Rhombus");
                prefs.put("rhombus.x", String.valueOf(xShape));
                prefs.put("rhombus.y", String.valueOf(yShape));
                prefs.put("rhombus.w", String.valueOf(wShape));
                prefs.put("rhombus.color", SHAPE_COLOR.toString());
                prefs.put("rhombus.sx", String.valueOf(sx));
                prefs.put("rhombus.sy", String.valueOf(sy));
                prefs.put("rhombus.angle", String.valueOf(angle));
                prefs.put("rhombus.savedOn", String.valueOf(currentDateTime));
            } else if (parallelogramList.size() != 0) {
                prefs.put("parallelogram.name", "Parallelogram");
                prefs.put("parallelogram.x", String.valueOf(xShape));
                prefs.put("parallelogram.y", String.valueOf(yShape));
                prefs.put("parallelogram.w", String.valueOf(wShape));
                prefs.put("parallelogram.h", String.valueOf(hShape));
                prefs.put("parallelogram.color", SHAPE_COLOR.toString());
                prefs.put("parallelogram.sx", String.valueOf(sx));
                prefs.put("parallelogram.sy", String.valueOf(sy));
                prefs.put("parallelogram.angle", String.valueOf(angle));
                prefs.put("parallelogram.savedOn", String.valueOf(currentDateTime));
            } else if (pentagonList.size() != 0) {
                prefs.put("pentagon.name", "Pentagon");
                prefs.put("pentagon.x", String.valueOf(xShape));
                prefs.put("pentagon.y", String.valueOf(yShape));
                prefs.put("pentagon.w", String.valueOf(wShape));
                prefs.put("pentagon.color", SHAPE_COLOR.toString());
                prefs.put("pentagon.sx", String.valueOf(sx));
                prefs.put("pentagon.sy", String.valueOf(sy));
                prefs.put("pentagon.angle", String.valueOf(angle));
                prefs.put("pentagon.savedOn", String.valueOf(currentDateTime));
            } else if (hexagonList.size() != 0) {
                prefs.put("hexagon.name", "Hexagon");
                prefs.put("hexagon.x", String.valueOf(xShape));
                prefs.put("hexagon.y", String.valueOf(yShape));
                prefs.put("hexagon.w", String.valueOf(wShape));
                prefs.put("hexagon.color", SHAPE_COLOR.toString());
                prefs.put("hexagon.sx", String.valueOf(sx));
                prefs.put("hexagon.sy", String.valueOf(sy));
                prefs.put("hexagon.angle", String.valueOf(angle));
                prefs.put("hexagon.savedOn", String.valueOf(currentDateTime));
            } else if (heptagonList.size() != 0) {
                prefs.put("heptagon.name", "Heptagon");
                prefs.put("heptagon.x", String.valueOf(xShape));
                prefs.put("heptagon.y", String.valueOf(yShape));
                prefs.put("heptagon.w", String.valueOf(wShape));
                prefs.put("heptagon.color", SHAPE_COLOR.toString());
                prefs.put("heptagon.sx", String.valueOf(sx));
                prefs.put("heptagon.sy", String.valueOf(sy));
                prefs.put("heptagon.angle", String.valueOf(angle));
                prefs.put("heptagon.savedOn", String.valueOf(currentDateTime));
            }

            JOptionPane.showMessageDialog(null, "Your shape has been saved successfully. Navigate to the History to tab to view your shape.",
                    "Information", JOptionPane.INFORMATION_MESSAGE);

        }

        repaint();

    }


    public static void main(String[] args) {

        DrawShapeLevel2 drawShapeLevel2 = new DrawShapeLevel2();
        NavBar nb = new NavBar();
        nb.add(drawShapeLevel2);

        frame.getContentPane().add(drawShapeLevel2);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
