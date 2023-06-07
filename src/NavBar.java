import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.Objects;
import java.util.prefs.Preferences;

public class NavBar extends JFrame implements ComponentListener, ActionListener {
    JPanel navBarPanel;
    JButton btnHome, btnLearnBasics, btnHistory, btnNewShape, btnColorShape, btnFindShape, btnSignOut;
    public int fwidth, bwidth;
    public Container contentPane;
    public Learn learn;
    public DrawShape drawShape;
    public ColorShapeCard colorShapeCard;
    public FindShapeCard findShapeCard;
    public History history;
    public ColorShapePage2 colorShapePage2;

    public NavBar() {
        super("Shapids");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addComponentListener(this);
        //this.getContentPane().setBackground(Color.decode("#5957ff"));
        this.setSize(1400, 800);

        navBarPanel = new JPanel();

        btnHome = new JButton("<html><center>Home</center></html>");
        //btnHome.setBounds(0, 0, bwidth, 80);
        btnHome.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnHome.setForeground(Color.WHITE);
        btnHome.setBackground(Color.decode("#EB455F"));
        btnHome.setBorderPainted(false);
        btnHome.addActionListener(this);
        navBarPanel.add(btnHome);

        btnLearnBasics = new JButton("<html><center>Learn Basics</center></html>");
        //btnLearnBasics.setBounds(0, 0, bwidth, 80);
        btnLearnBasics.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnLearnBasics.setForeground(Color.WHITE);
        btnLearnBasics.setBackground(Color.decode("#95CD41"));
        btnLearnBasics.setBorderPainted(false);
        btnLearnBasics.addActionListener(this);
        navBarPanel.add(btnLearnBasics);

        btnNewShape = new JButton("<html><center>New Shape</center></html>");
        //btnNewShape.setBounds(bwidth*2, 0, bwidth, 80);
        btnNewShape.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnNewShape.setForeground(Color.WHITE);
        btnNewShape.setBackground(Color.decode("#fc9444"));
        btnNewShape.setBorderPainted(false);
        btnNewShape.addActionListener(this);
        navBarPanel.add(btnNewShape);

        btnColorShape = new JButton("<html><center>Color Shape</center></html>");
        //btnColorShape.setBounds(bwidth*3, 0, bwidth, 80);
        btnColorShape.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnColorShape.setForeground(Color.WHITE);
        btnColorShape.setBackground(Color.decode("#de6fb1"));
        btnColorShape.setBorderPainted(false);
        btnColorShape.addActionListener(this);
        navBarPanel.add(btnColorShape);

        btnFindShape = new JButton("<html><center>Find Shape</center></html>");
        //btnColorShape.setBounds(bwidth*3, 0, bwidth, 80);
        btnFindShape.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnFindShape.setForeground(Color.WHITE);
        btnFindShape.setBackground(Color.decode("#CA82F8"));
        btnFindShape.setBorderPainted(false);
        btnFindShape.addActionListener(this);
        navBarPanel.add(btnFindShape);

        btnHistory = new JButton("<html><center>History</center></html>");
        //btnHistory.setBounds(bwidth, 0, bwidth, 80);
        btnHistory.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnHistory.setForeground(Color.WHITE);
        btnHistory.setBackground(Color.decode("#574ef5"));
        btnHistory.setBorderPainted(false);
        navBarPanel.add(btnHistory);

        btnSignOut = new JButton("<html><center>Sign Out</center></html>");
        //btnSignOut.setBounds(bwidth*4, 0, bwidth, 80);
        btnSignOut.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnSignOut.setForeground(Color.WHITE);
        btnSignOut.setBackground(Color.decode("#CDB30C"));
        btnSignOut.setBorderPainted(false);
        navBarPanel.add(btnSignOut);

        setLayout(new BorderLayout());
        add(navBarPanel, BorderLayout.NORTH);

        //this.setLayout(null);
        this.setVisible(true);

        //this.add(new Learn());

    }

    public NavBar(String page) {
        super("Shapids");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addComponentListener(this);
        //this.getContentPane().setBackground(Color.decode("#5957ff"));
        this.setSize(1400, 800);

        Preferences prefs = Preferences.userNodeForPackage(NavBar.class);

        navBarPanel = new JPanel();
        navBarPanel.setBackground(Color.decode("#a6d4f7"));

        btnHome = new JButton("<html><center>Home</center></html>");
        //btnHome.setBounds(0, 0, bwidth, 80);
        btnHome.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnHome.setForeground(Color.WHITE);
        btnHome.setBackground(Color.decode("#EB455F"));
        btnHome.setBorderPainted(false);
        btnHome.addActionListener(this);
        navBarPanel.add(btnHome);

        btnLearnBasics = new JButton("<html><center>Learn Basics</center></html>");
        //btnLearnBasics.setBounds(0, 0, bwidth, 80);
        btnLearnBasics.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnLearnBasics.setForeground(Color.WHITE);
        btnLearnBasics.setBackground(Color.decode("#95CD41"));
        btnLearnBasics.setBorderPainted(false);
        btnLearnBasics.addActionListener(this);
        navBarPanel.add(btnLearnBasics);

        btnNewShape = new JButton("<html><center>New Shape</center></html>");
        //btnNewShape.setBounds(bwidth*2, 0, bwidth, 80);
        btnNewShape.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnNewShape.setForeground(Color.WHITE);
        btnNewShape.setBackground(Color.decode("#fc9444"));
        btnNewShape.setBorderPainted(false);
        btnNewShape.addActionListener(this);
        navBarPanel.add(btnNewShape);

        btnColorShape = new JButton("<html><center>Color Shape</center></html>");
        //btnColorShape.setBounds(bwidth*3, 0, bwidth, 80);
        btnColorShape.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnColorShape.setForeground(Color.WHITE);
        btnColorShape.setBackground(Color.decode("#de6fb1"));
        btnColorShape.setBorderPainted(false);
        btnColorShape.addActionListener(this);
        navBarPanel.add(btnColorShape);

        btnFindShape = new JButton("<html><center>Find Shape</center></html>");
        //btnColorShape.setBounds(bwidth*3, 0, bwidth, 80);
        btnFindShape.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnFindShape.setForeground(Color.WHITE);
        btnFindShape.setBackground(Color.decode("#CA82F8"));
        btnFindShape.setBorderPainted(false);
        btnFindShape.addActionListener(this);
        navBarPanel.add(btnFindShape);

        btnHistory = new JButton("<html><center>History</center></html>");
        //btnHistory.setBounds(bwidth, 0, bwidth, 80);
        btnHistory.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnHistory.setForeground(Color.WHITE);
        btnHistory.setBackground(Color.decode("#574ef5"));
        btnHistory.setBorderPainted(false);
        btnHistory.addActionListener(this);
        navBarPanel.add(btnHistory);

        btnSignOut = new JButton("<html><center>Sign Out</center></html>");
        //btnSignOut.setBounds(bwidth*4, 0, bwidth, 80);
        btnSignOut.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnSignOut.setForeground(Color.WHITE);
        btnSignOut.setBackground(Color.decode("#CDB30C"));
        btnSignOut.setBorderPainted(false);
        btnSignOut.addActionListener(this);
        navBarPanel.add(btnSignOut);

        setLayout(new BorderLayout());
        add(navBarPanel, BorderLayout.NORTH);

        //this.setLayout(null);
        this.setVisible(true);

        if (Objects.equals(page, "Learn")) {
            this.add(new Learn());
        } else if (Objects.equals(page, "DrawShape")) {
            this.add(new DrawShape());
        } else if (Objects.equals(page, "ColorShape")) {
            this.add(new ColorShapeCard());
        } else if (Objects.equals(page, "ColorShapeLevel1Page1")) {
            this.add(new ColorShape());
        } else if (Objects.equals(page, "ColorShapeLevel1Page2")) {
            this.add(new ColorShapePage2());
        } else if (Objects.equals(page, "FindShape")) {
            this.add(new FindShapeCard());
        } else if (Objects.equals(page, "FindShapeLevel1Page1")) {
            this.add(new FindShape());
        } else if (Objects.equals(page, "FindShapeLevel1Page2")) {
            this.add(new CountShapes());
        } else if (Objects.equals(page, "PlayShape")) {
            this.add(new RandomShape());
        } else if (Objects.equals(page, "History")) {
            this.add(new History());
        } else if (Objects.equals(page, "EditLine")) {

            String lineName = prefs.get("line.name", "Unknown");
            String lineX1 = prefs.get("line.x1", "Unknown");
            String lineY1 = prefs.get("line.y1", "Unknown");
            String lineX2 = prefs.get("line.x2", "Unknown");
            String lineY2 = prefs.get("line.y2", "Unknown");
            String lineColor = prefs.get("line.color", "Unknown");
            String lineSx = prefs.get("line.sx", "Unknown");
            String lineSy = prefs.get("line.sy", "Unknown");
            String lineAngle = prefs.get("line.angle", "Unknown");

            this.add(new DrawShape(lineName, Integer.parseInt(lineX1), Integer.parseInt(lineY1), Integer.parseInt(lineX2), Integer.parseInt(lineY2), 0, 0, Double.parseDouble(lineSx), Double.parseDouble(lineSy), Integer.parseInt(lineAngle), lineColor));
        } else if (Objects.equals(page, "EditRectangle")) {

            String rectangleName = prefs.get("rectangle.name", "Unknown");
            String rectangleX = prefs.get("rectangle.x", "Unknown");
            String rectangleY = prefs.get("rectangle.y", "Unknown");
            String rectangleW = prefs.get("rectangle.w", "Unknown");
            String rectangleH = prefs.get("rectangle.h", "Unknown");
            String rectangleColor = prefs.get("rectangle.color", "Unknown");
            String rectangleSx = prefs.get("rectangle.sx", "Unknown");
            String rectangleSy = prefs.get("rectangle.sy", "Unknown");
            String rectangleAngle = prefs.get("rectangle.angle", "Unknown");

            this.add(new DrawShape(rectangleName, Integer.parseInt(rectangleX), Integer.parseInt(rectangleY), Integer.parseInt(rectangleW), Integer.parseInt(rectangleH), 0, 0, Double.parseDouble(rectangleSx), Double.parseDouble(rectangleSy), Integer.parseInt(rectangleAngle), rectangleColor));
        } else if (Objects.equals(page, "EditSquare")) {

            String squareName = prefs.get("square.name", "Unknown");
            String squareX = prefs.get("square.x", "Unknown");
            String squareY = prefs.get("square.y", "Unknown");
            String squareW = prefs.get("square.w", "Unknown");
            String squareColor = prefs.get("square.color", "Unknown");
            String squareSx = prefs.get("square.sx", "Unknown");
            String squareSy = prefs.get("square.sy", "Unknown");
            String squareAngle = prefs.get("square.angle", "Unknown");

            this.add(new DrawShape(squareName, Integer.parseInt(squareX), Integer.parseInt(squareY), Integer.parseInt(squareW), Integer.parseInt(squareW), 0, 0, Double.parseDouble(squareSx), Double.parseDouble(squareSy), Integer.parseInt(squareAngle), squareColor));
        } else if (Objects.equals(page, "EditTriangle")) {

            String triangleName = prefs.get("triangle.name", "Unknown");
            String triangleX1 = prefs.get("triangle.x1", "Unknown");
            String triangleY1 = prefs.get("triangle.y1", "Unknown");
            String triangleX2 = prefs.get("triangle.x2", "Unknown");
            String triangleY2 = prefs.get("triangle.y2", "Unknown");
            String triangleX3 = prefs.get("triangle.x3", "Unknown");
            String triangleY3 = prefs.get("triangle.y3", "Unknown");
            String triangleColor = prefs.get("triangle.color", "Unknown");
            String triangleSx = prefs.get("triangle.sx", "Unknown");
            String triangleSy = prefs.get("triangle.sy", "Unknown");
            String triangleAngle = prefs.get("triangle.angle", "Unknown");

            this.add(new DrawShape(triangleName, Integer.parseInt(triangleX1), Integer.parseInt(triangleY1), Integer.parseInt(triangleX2), Integer.parseInt(triangleY2), Integer.parseInt(triangleX3), Integer.parseInt(triangleY3), Double.parseDouble(triangleSx), Double.parseDouble(triangleSy), Integer.parseInt(triangleAngle), triangleColor));
        } else if (Objects.equals(page, "EditCircle")) {

            String circleName = prefs.get("circle.name", "Unknown");
            String circleX = prefs.get("circle.x", "Unknown");
            String circleY = prefs.get("circle.y", "Unknown");
            String circleW = prefs.get("circle.w", "Unknown");
            String circleColor = prefs.get("circle.color", "Unknown");
            String circleSx = prefs.get("circle.sx", "Unknown");
            String circleSy = prefs.get("circle.sy", "Unknown");
            String circleAngle = prefs.get("circle.angle", "Unknown");

            this.add(new DrawShape(circleName, Integer.parseInt(circleX), Integer.parseInt(circleY), Integer.parseInt(circleW), Integer.parseInt(circleW), 0, 0, Double.parseDouble(circleSx), Double.parseDouble(circleSy), Integer.parseInt(circleAngle), circleColor));
        }


    }

    public void actionPerformed(ActionEvent e) {
        //Main main = new Main();
        contentPane = this.getContentPane();

        // handle the button click event
        if (e.getSource() == btnHome) {
            this.setVisible(false);
            new HomeLevel1();

        } else if (e.getSource() == btnLearnBasics) {
            for (Component c : contentPane.getComponents()) {
                if (c instanceof DrawShape || c instanceof ColorShapeCard || c instanceof ColorShape || c instanceof ColorShapePage2 || c instanceof FindShapeCard || c instanceof FindShape || c instanceof CountShapes || c instanceof RandomShape || c instanceof History) {
                    contentPane.remove(c);
                }
            }
            contentPane.revalidate(); // refresh the container
            contentPane.repaint(); // repaint the container
            learn = new Learn();
            this.add(learn);
            this.setVisible(true);

        } else if (e.getSource() == btnNewShape) {
            for (Component c : contentPane.getComponents()) {
                if (c instanceof Learn || c instanceof ColorShapeCard || c instanceof ColorShape || c instanceof ColorShapePage2 || c instanceof FindShapeCard || c instanceof FindShape || c instanceof CountShapes || c instanceof RandomShape || c instanceof History) {
                    contentPane.remove(c);
                }
            }
            contentPane.revalidate(); // refresh the container
            contentPane.repaint(); // repaint the container
            drawShape = new DrawShape();
            this.add(drawShape);
            this.setVisible(true);

        } else if (e.getSource() == btnColorShape) {
            for (Component c : contentPane.getComponents()) {
                if (c instanceof Learn || c instanceof DrawShape || c instanceof ColorShape || c instanceof ColorShapePage2 || c instanceof FindShapeCard || c instanceof FindShape || c instanceof CountShapes || c instanceof RandomShape || c instanceof History) {
                    contentPane.remove(c);
                }
            }
            contentPane.revalidate(); // refresh the container
            contentPane.repaint();
            colorShapeCard = new ColorShapeCard();
            this.add(colorShapeCard);
            this.setVisible(true);

        } else if (e.getSource() == btnFindShape) {
            for (Component c : contentPane.getComponents()) {
                if (c instanceof Learn || c instanceof DrawShape || c instanceof ColorShapeCard || c instanceof ColorShape || c instanceof ColorShapePage2 || c instanceof FindShape || c instanceof CountShapes || c instanceof RandomShape || c instanceof History) {
                    contentPane.remove(c);
                }
            }
            contentPane.revalidate(); // refresh the container
            contentPane.repaint();
            findShapeCard = new FindShapeCard();
            this.add(findShapeCard);
            this.setVisible(true);

        } else if (e.getSource() == btnHistory) {
            for (Component c : contentPane.getComponents()) {
                if (c instanceof Learn || c instanceof DrawShape || c instanceof ColorShapeCard || c instanceof ColorShape || c instanceof ColorShapePage2 || c instanceof FindShapeCard || c instanceof FindShape || c instanceof CountShapes || c instanceof RandomShape) {
                    contentPane.remove(c);
                }
            }
            contentPane.revalidate(); // refresh the container
            contentPane.repaint();
            history = new History();
            this.add(history);
            this.setVisible(true);

        } else if (e.getSource() == btnSignOut) {
            this.setVisible(false);
            new Welcome();
        }
    }

    @Override
    public void componentResized(ComponentEvent e) {
        fwidth = this.getWidth();
        bwidth = fwidth / 7;
       // float bwidth2 = Float.valueOf(bwidth);

        navBarPanel.setPreferredSize(new Dimension(fwidth, 50));

        btnHome.setPreferredSize(new Dimension(100, 40));
        btnLearnBasics.setPreferredSize(new Dimension(170, 40));
        btnNewShape.setPreferredSize(new Dimension(150, 40));
        btnColorShape.setPreferredSize(new Dimension(150, 40));
        btnFindShape.setPreferredSize(new Dimension(150, 40));
        btnHistory.setPreferredSize(new Dimension(100, 40));
        btnSignOut.setPreferredSize(new Dimension(120, 40));


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

    /*public static void main(String[] args) {



    }*/
}
