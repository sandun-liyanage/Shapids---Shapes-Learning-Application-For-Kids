import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.Objects;
import java.util.prefs.Preferences;

public class NavBarLevel2 extends JFrame implements ComponentListener, ActionListener {
    JPanel navBarPanel;
    JButton btnHome, btnLearnAdvanced, btnHistory, btnNewAdvancedShape, btnColorAdvancedShape, btnFindAdvancedShape, btnSignOut;
    public int fwidth, bwidth;
    public Container contentPane;
    public LearnLevel2 learnLevel2;
    public DrawShapeLevel2 drawShapeLevel2;
    public ColorShapeLevel2Card colorShapeLevel2Card;
    public FindShapeLevel2 findShapeLevel2;
    public History history;
    public ColorShapeLevel2Page2 colorShapeLevel2Page2;

    public NavBarLevel2() {
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

        btnLearnAdvanced = new JButton("<html><center>Learn Advanced</center></html>");
        //btnLearnBasics.setBounds(0, 0, bwidth, 80);
        btnLearnAdvanced.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnLearnAdvanced.setForeground(Color.WHITE);
        btnLearnAdvanced.setBackground(Color.decode("#95CD41"));
        btnLearnAdvanced.setBorderPainted(false);
        btnLearnAdvanced.addActionListener(this);
        navBarPanel.add(btnLearnAdvanced);

        btnNewAdvancedShape = new JButton("<html><center>New Shape</center></html>");
        //btnNewShape.setBounds(bwidth*2, 0, bwidth, 80);
        btnNewAdvancedShape.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnNewAdvancedShape.setForeground(Color.WHITE);
        btnNewAdvancedShape.setBackground(Color.decode("#FFA45B"));
        btnNewAdvancedShape.setBorderPainted(false);
        btnNewAdvancedShape.addActionListener(this);
        navBarPanel.add(btnNewAdvancedShape);

        btnColorAdvancedShape = new JButton("<html><center>Color Shape</center></html>");
        //btnColorShape.setBounds(bwidth*3, 0, bwidth, 80);
        btnColorAdvancedShape.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnColorAdvancedShape.setForeground(Color.WHITE);
        btnColorAdvancedShape.setBackground(Color.decode("#de6fb1"));
        btnColorAdvancedShape.setBorderPainted(false);
        btnColorAdvancedShape.addActionListener(this);
        navBarPanel.add(btnColorAdvancedShape);

        btnFindAdvancedShape = new JButton("<html><center>Find Shape</center></html>");
        //btnColorShape.setBounds(bwidth*3, 0, bwidth, 80);
        btnFindAdvancedShape.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnFindAdvancedShape.setForeground(Color.WHITE);
        btnFindAdvancedShape.setBackground(Color.decode("#CA82F8"));
        btnFindAdvancedShape.setBorderPainted(false);
        btnFindAdvancedShape.addActionListener(this);
        navBarPanel.add(btnFindAdvancedShape);

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

    public NavBarLevel2(String page) {
        super("Shapids");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addComponentListener(this);
        //this.getContentPane().setBackground(Color.decode("#5957ff"));
        this.setSize(1400, 800);

        Preferences prefs = Preferences.userNodeForPackage(NavBarLevel2.class);

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

        btnLearnAdvanced = new JButton("<html><center>Learn Advanced</center></html>");
        //btnLearnBasics.setBounds(0, 0, bwidth, 80);
        btnLearnAdvanced.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnLearnAdvanced.setForeground(Color.WHITE);
        btnLearnAdvanced.setBackground(Color.decode("#95CD41"));
        btnLearnAdvanced.setBorderPainted(false);
        btnLearnAdvanced.addActionListener(this);
        navBarPanel.add(btnLearnAdvanced);

        btnNewAdvancedShape = new JButton("<html><center>New Shape</center></html>");
        //btnNewShape.setBounds(bwidth*2, 0, bwidth, 80);
        btnNewAdvancedShape.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnNewAdvancedShape.setForeground(Color.WHITE);
        btnNewAdvancedShape.setBackground(Color.decode("#FFA45B"));
        btnNewAdvancedShape.setBorderPainted(false);
        btnNewAdvancedShape.addActionListener(this);
        navBarPanel.add(btnNewAdvancedShape);

        btnColorAdvancedShape = new JButton("<html><center>Color Shape</center></html>");
        //btnColorShape.setBounds(bwidth*3, 0, bwidth, 80);
        btnColorAdvancedShape.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnColorAdvancedShape.setForeground(Color.WHITE);
        btnColorAdvancedShape.setBackground(Color.decode("#de6fb1"));
        btnColorAdvancedShape.setBorderPainted(false);
        btnColorAdvancedShape.addActionListener(this);
        navBarPanel.add(btnColorAdvancedShape);

        btnFindAdvancedShape = new JButton("<html><center>Find Shape</center></html>");
        //btnColorShape.setBounds(bwidth*3, 0, bwidth, 80);
        btnFindAdvancedShape.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnFindAdvancedShape.setForeground(Color.WHITE);
        btnFindAdvancedShape.setBackground(Color.decode("#CA82F8"));
        btnFindAdvancedShape.setBorderPainted(false);
        btnFindAdvancedShape.addActionListener(this);
        navBarPanel.add(btnFindAdvancedShape);

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

        if (Objects.equals(page, "LearnAdvanced")) {
            this.add(new LearnLevel2());
        } else if (Objects.equals(page, "LearnLevel2Next")) {
            this.add(new LearnLevel2Next());
        } else if (Objects.equals(page, "DrawAdvanced")) {
            this.add(new DrawShapeLevel2());
        } else if (Objects.equals(page, "ColorAdvancedShape")) {
            this.add(new ColorShapeLevel2Card());
        } else if (Objects.equals(page, "ColorShapeLevel2Page1")) {
            this.add(new ColorShapeLevel2());
        } else if (Objects.equals(page, "ColorShapeLevel2Page2")) {
            this.add(new ColorShapeLevel2Page2());
        } else if (Objects.equals(page, "FindAdvancedShape")) {
            this.add(new FindShapeLevel2());
        } else if (Objects.equals(page, "3dShapes")) {

            //this.add(ThreeDShape.main());
            final GLProfile profile = GLProfile.get(GLProfile.GL2);
            GLCapabilities capabilities = new GLCapabilities(profile);
            final GLCanvas glcanvas = new GLCanvas(capabilities);

            ThreeDShape combinedShapes = new ThreeDShape();
            glcanvas.addGLEventListener(combinedShapes);
            glcanvas.setSize(1400, 700);

            //NavBarLevel2 nb2 = new NavBarLevel2();
            this.add(glcanvas);

            final FPSAnimator animator = new FPSAnimator(glcanvas, 300, true);
            animator.start();

        } else if (Objects.equals(page, "History")) {
            this.add(new History());
        } else if (Objects.equals(page, "EditTrapezium")) {

            String trapeziumName = prefs.get("trapezium.name", "Unknown");
            String trapeziumX = prefs.get("trapezium.x", "Unknown");
            String trapeziumY = prefs.get("trapezium.y", "Unknown");
            String trapeziumW = prefs.get("trapezium.w", "Unknown");
            String trapeziumH = prefs.get("trapezium.h", "Unknown");
            String trapeziumColor = prefs.get("trapezium.color", "Unknown");
            String trapeziumSx = prefs.get("trapezium.sx", "Unknown");
            String trapeziumSy = prefs.get("trapezium.sy", "Unknown");
            String trapeziumAngle = prefs.get("trapezium.angle", "Unknown");

            this.add(new DrawShapeLevel2(trapeziumName, Integer.parseInt(trapeziumX), Integer.parseInt(trapeziumY), Integer.parseInt(trapeziumW), Integer.parseInt(trapeziumH), Double.parseDouble(trapeziumSx), Double.parseDouble(trapeziumSy), Integer.parseInt(trapeziumAngle), trapeziumColor));
        } else if (Objects.equals(page, "EditRhombus")) {

            String rhombusName = prefs.get("rhombus.name", "Unknown");
            String rhombusX = prefs.get("rhombus.x", "Unknown");
            String rhombusY = prefs.get("rhombus.y", "Unknown");
            String rhombusW = prefs.get("rhombus.w", "Unknown");
            String rhombusColor = prefs.get("rhombus.color", "Unknown");
            String rhombusSx = prefs.get("rhombus.sx", "Unknown");
            String rhombusSy = prefs.get("rhombus.sy", "Unknown");
            String rhombusAngle = prefs.get("rhombus.angle", "Unknown");

            this.add(new DrawShapeLevel2(rhombusName, Integer.parseInt(rhombusX), Integer.parseInt(rhombusY), Integer.parseInt(rhombusW), 0, Double.parseDouble(rhombusSx), Double.parseDouble(rhombusSy), Integer.parseInt(rhombusAngle), rhombusColor));
        } else if (Objects.equals(page, "EditParallelogram")) {

            String parallelogramName = prefs.get("parallelogram.name", "Unknown");
            String parallelogramX = prefs.get("parallelogram.x", "Unknown");
            String parallelogramY = prefs.get("parallelogram.y", "Unknown");
            String parallelogramW = prefs.get("parallelogram.w", "Unknown");
            String parallelogramH = prefs.get("parallelogram.h", "Unknown");
            String parallelogramColor = prefs.get("parallelogram.color", "Unknown");
            String parallelogramSx = prefs.get("parallelogram.sx", "Unknown");
            String parallelogramSy = prefs.get("parallelogram.sy", "Unknown");
            String parallelogramAngle = prefs.get("parallelogram.angle", "Unknown");

            this.add(new DrawShapeLevel2(parallelogramName, Integer.parseInt(parallelogramX), Integer.parseInt(parallelogramY), Integer.parseInt(parallelogramW), Integer.parseInt(parallelogramH), Double.parseDouble(parallelogramSx), Double.parseDouble(parallelogramSy), Integer.parseInt(parallelogramAngle), parallelogramColor));
        } else if (Objects.equals(page, "EditPentagon")) {

            String pentagonName = prefs.get("pentagon.name", "Unknown");
            String pentagonX = prefs.get("pentagon.x", "Unknown");
            String pentagonY = prefs.get("pentagon.y", "Unknown");
            String pentagonW = prefs.get("pentagon.w", "Unknown");
            String pentagonColor = prefs.get("pentagon.color", "Unknown");
            String pentagonSx = prefs.get("pentagon.sx", "Unknown");
            String pentagonSy = prefs.get("pentagon.sy", "Unknown");
            String pentagonAngle = prefs.get("pentagon.angle", "Unknown");

            this.add(new DrawShapeLevel2(pentagonName, Integer.parseInt(pentagonX), Integer.parseInt(pentagonY), Integer.parseInt(pentagonW), 0, Double.parseDouble(pentagonSx), Double.parseDouble(pentagonSy), Integer.parseInt(pentagonAngle), pentagonColor));
        } else if (Objects.equals(page, "EditHexagon")) {

            String hexagonName = prefs.get("hexagon.name", "Unknown");
            String hexagonX = prefs.get("hexagon.x", "Unknown");
            String hexagonY = prefs.get("hexagon.y", "Unknown");
            String hexagonW = prefs.get("hexagon.w", "Unknown");
            String hexagonColor = prefs.get("hexagon.color", "Unknown");
            String hexagonSx = prefs.get("hexagon.sx", "Unknown");
            String hexagonSy = prefs.get("hexagon.sy", "Unknown");
            String hexagonAngle = prefs.get("hexagon.angle", "Unknown");

            this.add(new DrawShapeLevel2(hexagonName, Integer.parseInt(hexagonX), Integer.parseInt(hexagonY), Integer.parseInt(hexagonW), 0, Double.parseDouble(hexagonSx), Double.parseDouble(hexagonSy), Integer.parseInt(hexagonAngle), hexagonColor));
        } else if (Objects.equals(page, "EditHeptagon")) {

            String heptagonName = prefs.get("heptagon.name", "Unknown");
            String heptagonX = prefs.get("heptagon.x", "Unknown");
            String heptagonY = prefs.get("heptagon.y", "Unknown");
            String heptagonW = prefs.get("heptagon.w", "Unknown");
            String heptagonColor = prefs.get("heptagon.color", "Unknown");
            String heptagonSx = prefs.get("heptagon.sx", "Unknown");
            String heptagonSy = prefs.get("heptagon.sy", "Unknown");
            String heptagonAngle = prefs.get("heptagon.angle", "Unknown");

            this.add(new DrawShapeLevel2(heptagonName, Integer.parseInt(heptagonX), Integer.parseInt(heptagonY), Integer.parseInt(heptagonW), 0, Double.parseDouble(heptagonSx), Double.parseDouble(heptagonSy), Integer.parseInt(heptagonAngle), heptagonColor));
        }

    }

    public void actionPerformed(ActionEvent e) {
        //Main main = new Main();
        contentPane = this.getContentPane();

        // handle the button click event
        if (e.getSource() == btnHome) {
            this.setVisible(false);
            new HomeLevel2();
        } else if (e.getSource() == btnLearnAdvanced) {
            for (Component c : contentPane.getComponents()) {
                if (c instanceof LearnLevel2Next || c instanceof DrawShapeLevel2 || c instanceof ColorShapeLevel2Card || c instanceof ColorShapeLevel2 || c instanceof ColorShapeLevel2Page2 || c instanceof RandomShape || c instanceof FindShapeLevel2 || c instanceof History || c instanceof GLCanvas) {
                    //System.out.println(c);
                    contentPane.remove(c);
                }
            }
            contentPane.revalidate(); // refresh the container
            contentPane.repaint(); // repaint the container
            learnLevel2 = new LearnLevel2();
            this.add(learnLevel2);
            this.setVisible(true);

        } else if (e.getSource() == btnNewAdvancedShape) {
            for (Component c : contentPane.getComponents()) {
                if (c instanceof LearnLevel2 || c instanceof LearnLevel2Next || c instanceof ColorShapeLevel2Card || c instanceof ColorShapeLevel2 || c instanceof ColorShapeLevel2Page2 || c instanceof RandomShape || c instanceof FindShapeLevel2 || c instanceof History || c instanceof GLCanvas) {
                    //System.out.println(c);
                    contentPane.remove(c);
                }
            }
            contentPane.revalidate(); // refresh the container
            contentPane.repaint(); // repaint the container
            drawShapeLevel2 = new DrawShapeLevel2();
            this.add(drawShapeLevel2);
            this.setVisible(true);

        } else if (e.getSource() == btnColorAdvancedShape) {
            for (Component c : contentPane.getComponents()) {
                if (c instanceof LearnLevel2 || c instanceof LearnLevel2Next || c instanceof DrawShapeLevel2 || c instanceof ColorShapeLevel2 || c instanceof ColorShapeLevel2Page2 || c instanceof RandomShape || c instanceof FindShapeLevel2 || c instanceof History || c instanceof GLCanvas) {
                    //System.out.println(c);
                    contentPane.remove(c);
                }
            }
            contentPane.revalidate(); // refresh the container
            contentPane.repaint();
            colorShapeLevel2Card = new ColorShapeLevel2Card();
            this.add(colorShapeLevel2Card);
            this.setVisible(true);

        } else if (e.getSource() == btnFindAdvancedShape) {
            for (Component c : contentPane.getComponents()) {
                if (c instanceof LearnLevel2 || c instanceof LearnLevel2Next || c instanceof DrawShapeLevel2 || c instanceof ColorShapeLevel2Card || c instanceof ColorShapeLevel2 || c instanceof ColorShapeLevel2Page2 || c instanceof RandomShape || c instanceof History || c instanceof GLCanvas) {
                    //System.out.println(c);
                    contentPane.remove(c);
                }
            }
            contentPane.revalidate(); // refresh the container
            contentPane.repaint();
            findShapeLevel2 = new FindShapeLevel2();
            this.add(findShapeLevel2);
            this.setVisible(true);

        } else if (e.getSource() == btnHistory) {
            for (Component c : contentPane.getComponents()) {
                if (c instanceof LearnLevel2 || c instanceof LearnLevel2Next || c instanceof DrawShapeLevel2 || c instanceof ColorShapeLevel2Card || c instanceof ColorShapeLevel2 || c instanceof ColorShapeLevel2Page2 || c instanceof FindShapeLevel2 || c instanceof GLCanvas) {
                    //System.out.println(c);
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
        bwidth = (fwidth / 7);

        navBarPanel.setPreferredSize(new Dimension(fwidth, 50));

        btnHome.setPreferredSize(new Dimension(100, 40));
        btnLearnAdvanced.setPreferredSize(new Dimension(200, 40));
        btnNewAdvancedShape.setPreferredSize(new Dimension(150, 40));
        btnColorAdvancedShape.setPreferredSize(new Dimension(150, 40));
        btnFindAdvancedShape.setPreferredSize(new Dimension(150, 40));
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
