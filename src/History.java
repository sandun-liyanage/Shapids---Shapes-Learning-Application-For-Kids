import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.util.Objects;
import java.util.prefs.Preferences;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class History extends JPanel implements ComponentListener, ActionListener {
    static JFrame frame;
    JPanel panelActivity1, panelActivity2, panelActivity3, panelActivity4, panelActivity5, panelActivity6;
    JLabel lblImage, lblImage2, lblActivity1, lblActivity2, lblActivity3, lblActivity4, lblActivity5, lblActivity6, lblCompleted1, lblCompleted2, lblCompleted3, lblCompleted4, lblCompleted5, lblCompleted6;
    JButton btnEdit1, btnEdit2, btnEdit3, btnEdit4, btnEdit5, btnEdit6, btnDelete1, btnDelete2, btnDelete3, btnDelete4, btnDelete5, btnDelete6;
    int fwidth, fheight, padding = 25;

    public History() {

        this.addComponentListener(this);
        this.setBackground(Color.decode("#b8d7f5"));
        this.setSize(1400, 800);
        this.setLayout(null);

        ImageIcon imageIcon1 = new ImageIcon("images/kids1.png");
        lblImage = new JLabel();
        lblImage.setIcon(imageIcon1);
        add(lblImage);

        ImageIcon imageIcon2 = new ImageIcon("images/boy.png");
        lblImage2 = new JLabel();
        lblImage2.setIcon(imageIcon2);
        add(lblImage2);

        Preferences prefs = Preferences.userNodeForPackage(History.class);

        String line = prefs.get("line.name", "Unknown");
        String rectangle = prefs.get("rectangle.name", "Unknown");
        String square = prefs.get("square.name", "Unknown");
        String triangle = prefs.get("triangle.name", "Unknown");
        String circle = prefs.get("circle.name", "Unknown");

        String lineSavedOn = prefs.get("line.savedOn", "Unknown");
        String rectangleSavedOn = prefs.get("rectangle.savedOn", "Unknown");
        String squareSavedOn = prefs.get("square.savedOn", "Unknown");
        String triangleSavedOn = prefs.get("triangle.savedOn", "Unknown");
        String circleSavedOn = prefs.get("circle.savedOn", "Unknown");


        String trapezium = prefs.get("trapezium.name", "Unknown");
        String rhombus = prefs.get("rhombus.name", "Unknown");
        String parallelogram = prefs.get("parallelogram.name", "Unknown");
        String pentagon = prefs.get("pentagon.name", "Unknown");
        String hexagon = prefs.get("hexagon.name", "Unknown");
        String heptagon = prefs.get("heptagon.name", "Unknown");

        String trapeziumSavedOn = prefs.get("trapezium.savedOn", "Unknown");
        String rhombusSavedOn = prefs.get("rhombus.savedOn", "Unknown");
        String parallelogramSavedOn = prefs.get("parallelogram.savedOn", "Unknown");
        String pentagonSavedOn = prefs.get("pentagon.savedOn", "Unknown");
        String hexagonSavedOn = prefs.get("hexagon.savedOn", "Unknown");
        String heptagonSavedOn = prefs.get("heptagon.savedOn", "Unknown");


        panelActivity1 = new JPanel();
        panelActivity1.setBackground(Color.WHITE);
        panelActivity1.setLayout(null);
        //add(panelActivity1);

        panelActivity2 = new JPanel();
        panelActivity2.setBackground(Color.WHITE);
        panelActivity2.setLayout(null);
        //add(panelActivity2);

        panelActivity3 = new JPanel();
        panelActivity3.setBackground(Color.WHITE);
        panelActivity3.setLayout(null);
        //add(panelActivity3);

        panelActivity4 = new JPanel();
        panelActivity4.setBackground(Color.WHITE);
        panelActivity4.setLayout(null);
        //add(panelActivity4);

        panelActivity5 = new JPanel();
        panelActivity5.setBackground(Color.WHITE);
        panelActivity5.setLayout(null);
        //add(panelActivity5);

        panelActivity6 = new JPanel();
        panelActivity6.setBackground(Color.WHITE);
        panelActivity6.setLayout(null);
        //add(panelActivity6);

        lblActivity1 = new Utils.RoundedLabel("");
        lblActivity1.setBounds(25, 50 - 30, 200, 60);
        lblActivity1.setBackground(Color.decode("#FFE7C7"));
        lblActivity1.setForeground(Color.BLACK);
        lblActivity1.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        lblActivity1.setHorizontalAlignment(SwingConstants.CENTER);
        panelActivity1.add(lblActivity1);

        lblActivity2 = new Utils.RoundedLabel("");
        lblActivity2.setBounds(25, 50 - 30, 200, 60);
        lblActivity2.setBackground(Color.decode("#FFE7C7"));
        lblActivity2.setForeground(Color.BLACK);
        lblActivity2.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        lblActivity2.setHorizontalAlignment(SwingConstants.CENTER);
        panelActivity2.add(lblActivity2);

        lblActivity3 = new Utils.RoundedLabel("");
        lblActivity3.setBounds(25, 50 - 30, 200, 60);
        lblActivity3.setBackground(Color.decode("#FFE7C7"));
        lblActivity3.setForeground(Color.BLACK);
        lblActivity3.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        lblActivity3.setHorizontalAlignment(SwingConstants.CENTER);
        panelActivity3.add(lblActivity3);

        lblActivity4 = new Utils.RoundedLabel("");
        lblActivity4.setBounds(25, 50 - 30, 200, 60);
        lblActivity4.setBackground(Color.decode("#FFE7C7"));
        lblActivity4.setForeground(Color.BLACK);
        lblActivity4.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        lblActivity4.setHorizontalAlignment(SwingConstants.CENTER);
        panelActivity4.add(lblActivity4);

        lblActivity5 = new Utils.RoundedLabel("");
        lblActivity5.setBounds(25, 50 - 30, 200, 60);
        lblActivity5.setBackground(Color.decode("#FFE7C7"));
        lblActivity5.setForeground(Color.BLACK);
        lblActivity5.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        lblActivity5.setHorizontalAlignment(SwingConstants.CENTER);
        panelActivity5.add(lblActivity5);

        lblActivity6 = new Utils.RoundedLabel("");
        lblActivity6.setBounds(25, 50 - 30, 200, 60);
        lblActivity6.setBackground(Color.decode("#FFE7C7"));
        lblActivity6.setForeground(Color.BLACK);
        lblActivity6.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        lblActivity6.setHorizontalAlignment(SwingConstants.CENTER);
        panelActivity6.add(lblActivity6);

        lblCompleted1 = new Utils.RoundedLabel("Saved on 25/05/2023");
        lblCompleted1.setBounds(250, 50 - 30, 340, 60);
        //lblCompleted1.setBackground(new Color(243, 173, 255, 255));
        lblCompleted1.setForeground(Color.BLACK);
        lblCompleted1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        //lblCompleted1.setHorizontalAlignment(SwingConstants.CENTER);
        lblCompleted1.setBorder(new EmptyBorder(padding, padding, padding, padding));
        panelActivity1.add(lblCompleted1);

        lblCompleted2 = new Utils.RoundedLabel("Saved on 01/05/2023");
        lblCompleted2.setBounds(250, 50 - 30, 340, 60);
        //lblCompleted2.setBackground(new Color(243, 173, 255, 255));
        lblCompleted2.setForeground(Color.BLACK);
        lblCompleted2.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        //lblCompleted2.setHorizontalAlignment(SwingConstants.CENTER);
        lblCompleted2.setBorder(new EmptyBorder(padding, padding, padding, padding));
        panelActivity2.add(lblCompleted2);

        lblCompleted3 = new Utils.RoundedLabel("Saved on 25/04/2023");
        lblCompleted3.setBounds(250, 50 - 30, 340, 60);
        //lblCompleted3.setBackground(new Color(243, 173, 255, 255));
        lblCompleted3.setForeground(Color.BLACK);
        lblCompleted3.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        //lblCompleted3.setHorizontalAlignment(SwingConstants.CENTER);
        lblCompleted3.setBorder(new EmptyBorder(padding, padding, padding, padding));
        panelActivity3.add(lblCompleted3);

        lblCompleted4 = new Utils.RoundedLabel("Saved on 25/04/2023");
        lblCompleted4.setBounds(250, 50 - 30, 340, 60);
        //lblCompleted4.setBackground(new Color(243, 173, 255, 255));
        lblCompleted4.setForeground(Color.BLACK);
        lblCompleted4.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        //lblCompleted4.setHorizontalAlignment(SwingConstants.CENTER);
        lblCompleted4.setBorder(new EmptyBorder(padding, padding, padding, padding));
        panelActivity4.add(lblCompleted4);

        lblCompleted5 = new Utils.RoundedLabel("Saved on 25/04/2023");
        lblCompleted5.setBounds(250, 50 - 30, 340, 60);
        //lblCompleted5.setBackground(new Color(243, 173, 255, 255));
        lblCompleted5.setForeground(Color.BLACK);
        lblCompleted5.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        //lblCompleted5.setHorizontalAlignment(SwingConstants.CENTER);
        lblCompleted5.setBorder(new EmptyBorder(padding, padding, padding, padding));
        panelActivity5.add(lblCompleted5);

        lblCompleted6 = new Utils.RoundedLabel("Saved on 25/04/2023");
        lblCompleted6.setBounds(250, 50 - 30, 340, 60);
        //lblCompleted6.setBackground(new Color(243, 173, 255, 255));
        lblCompleted6.setForeground(Color.BLACK);
        lblCompleted6.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        //lblCompleted6.setHorizontalAlignment(SwingConstants.CENTER);
        lblCompleted6.setBorder(new EmptyBorder(padding, padding, padding, padding));
        panelActivity6.add(lblCompleted6);

        btnEdit1 = new Utils.RoundedButton("Edit");
        btnEdit1.setBounds(850 - 100 - 25 - 100 - 25, 50 - 25, 100, 50);
        btnEdit1.setBackground(new Color(107, 213, 237, 255));
        btnEdit1.setForeground(Color.BLACK);
        btnEdit1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnEdit1.setHorizontalAlignment(SwingConstants.CENTER);
        btnEdit1.addActionListener(this);
        panelActivity1.add(btnEdit1);

        btnEdit2 = new Utils.RoundedButton("Edit");
        btnEdit2.setBounds(850 - 100 - 25 - 100 - 25, 50 - 25, 100, 50);
        btnEdit2.setBackground(new Color(107, 213, 237, 255));
        btnEdit2.setForeground(Color.BLACK);
        btnEdit2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnEdit2.setHorizontalAlignment(SwingConstants.CENTER);
        btnEdit2.addActionListener(this);
        panelActivity2.add(btnEdit2);

        btnEdit3 = new Utils.RoundedButton("Edit");
        btnEdit3.setBounds(850 - 100 - 25 - 100 - 25, 50 - 25, 100, 50);
        btnEdit3.setBackground(new Color(107, 213, 237, 255));
        btnEdit3.setForeground(Color.BLACK);
        btnEdit3.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnEdit3.setHorizontalAlignment(SwingConstants.CENTER);
        btnEdit3.addActionListener(this);
        panelActivity3.add(btnEdit3);

        btnEdit4 = new Utils.RoundedButton("Edit");
        btnEdit4.setBounds(850 - 100 - 25 - 100 - 25, 50 - 25, 100, 50);
        btnEdit4.setBackground(new Color(107, 213, 237, 255));
        btnEdit4.setForeground(Color.BLACK);
        btnEdit4.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnEdit4.setHorizontalAlignment(SwingConstants.CENTER);
        btnEdit4.addActionListener(this);
        panelActivity4.add(btnEdit4);

        btnEdit5 = new Utils.RoundedButton("Edit");
        btnEdit5.setBounds(850 - 100 - 25 - 100 - 25, 50 - 25, 100, 50);
        btnEdit5.setBackground(new Color(107, 213, 237, 255));
        btnEdit5.setForeground(Color.BLACK);
        btnEdit5.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnEdit5.setHorizontalAlignment(SwingConstants.CENTER);
        btnEdit5.addActionListener(this);
        panelActivity5.add(btnEdit5);

        btnEdit6 = new Utils.RoundedButton("Edit");
        btnEdit6.setBounds(850 - 100 - 25 - 100 - 25, 50 - 25, 100, 50);
        btnEdit6.setBackground(new Color(107, 213, 237, 255));
        btnEdit6.setForeground(Color.BLACK);
        btnEdit6.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnEdit6.setHorizontalAlignment(SwingConstants.CENTER);
        btnEdit6.addActionListener(this);
        panelActivity6.add(btnEdit6);

        btnDelete1 = new Utils.RoundedButton("Delete");
        btnDelete1.setBounds(850 - 100 - 25, 50 - 25, 100, 50);
        btnDelete1.setBackground(Color.decode("#FFA8B5"));
        btnDelete1.setForeground(Color.BLACK);
        btnDelete1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnDelete1.setHorizontalAlignment(SwingConstants.CENTER);
        btnDelete1.addActionListener(this);
        panelActivity1.add(btnDelete1);

        btnDelete2 = new Utils.RoundedButton("Delete");
        btnDelete2.setBounds(850 - 100 - 25, 50 - 25, 100, 50);
        btnDelete2.setBackground(Color.decode("#FFA8B5"));
        btnDelete2.setForeground(Color.BLACK);
        btnDelete2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnDelete2.setHorizontalAlignment(SwingConstants.CENTER);
        btnDelete2.addActionListener(this);
        panelActivity2.add(btnDelete2);

        btnDelete3 = new Utils.RoundedButton("Delete");
        btnDelete3.setBounds(850 - 100 - 25, 50 - 25, 100, 50);
        btnDelete3.setBackground(Color.decode("#FFA8B5"));
        btnDelete3.setForeground(Color.BLACK);
        btnDelete3.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnDelete3.setHorizontalAlignment(SwingConstants.CENTER);
        btnDelete3.addActionListener(this);
        panelActivity3.add(btnDelete3);

        btnDelete4 = new Utils.RoundedButton("Delete");
        btnDelete4.setBounds(850 - 100 - 25, 50 - 25, 100, 50);
        btnDelete4.setBackground(Color.decode("#FFA8B5"));
        btnDelete4.setForeground(Color.BLACK);
        btnDelete4.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnDelete4.setHorizontalAlignment(SwingConstants.CENTER);
        btnDelete4.addActionListener(this);
        panelActivity4.add(btnDelete4);

        btnDelete5 = new Utils.RoundedButton("Delete");
        btnDelete5.setBounds(850 - 100 - 25, 50 - 25, 100, 50);
        btnDelete5.setBackground(Color.decode("#FFA8B5"));
        btnDelete5.setForeground(Color.BLACK);
        btnDelete5.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnDelete5.setHorizontalAlignment(SwingConstants.CENTER);
        btnDelete5.addActionListener(this);
        panelActivity5.add(btnDelete5);

        btnDelete6 = new Utils.RoundedButton("Delete");
        btnDelete6.setBounds(850 - 100 - 25, 50 - 25, 100, 50);
        btnDelete6.setBackground(Color.decode("#FFA8B5"));
        btnDelete6.setForeground(Color.BLACK);
        btnDelete6.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnDelete6.setHorizontalAlignment(SwingConstants.CENTER);
        btnDelete6.addActionListener(this);
        panelActivity6.add(btnDelete6);

        String storedLevel = prefs.get("level", "Unknown");

        if (Objects.equals(storedLevel, "Level1")) {
            if (!Objects.equals(line, "Unknown")) {
                lblActivity1.setText(line);
                lblCompleted1.setText("Saved on " + lineSavedOn);
                add(panelActivity1);
            }
            if (!Objects.equals(rectangle, "Unknown")) {
                lblActivity2.setText(rectangle);
                lblCompleted2.setText("Saved on " + rectangleSavedOn);
                add(panelActivity2);
            }
            if (!Objects.equals(square, "Unknown")) {
                lblActivity3.setText(square);
                lblCompleted3.setText("Saved on " + squareSavedOn);
                add(panelActivity3);
            }
            if (!Objects.equals(triangle, "Unknown")) {
                lblActivity4.setText(triangle);
                lblCompleted4.setText("Saved on " + triangleSavedOn);
                add(panelActivity4);
            }
            if (!Objects.equals(circle, "Unknown")) {
                lblActivity5.setText(circle);
                lblCompleted5.setText("Saved on " + circleSavedOn);
                add(panelActivity5);
            }
        }
        if (Objects.equals(storedLevel, "Level2")) {
            if (!Objects.equals(trapezium, "Unknown")) {
                lblActivity1.setText(trapezium);
                lblCompleted1.setText("Saved on " + trapeziumSavedOn);
                add(panelActivity1);
            }
            if (!Objects.equals(rhombus, "Unknown")) {
                lblActivity2.setText(rhombus);
                lblCompleted2.setText("Saved on " + rhombusSavedOn);
                add(panelActivity2);
            }
            if (!Objects.equals(parallelogram, "Unknown")) {
                lblActivity3.setText(parallelogram);
                lblCompleted3.setText("Saved on " + parallelogramSavedOn);
                add(panelActivity3);
            }
            if (!Objects.equals(pentagon, "Unknown")) {
                lblActivity4.setText(pentagon);
                lblCompleted4.setText("Saved on " + pentagonSavedOn);
                add(panelActivity4);
            }
            if (!Objects.equals(hexagon, "Unknown")) {
                lblActivity5.setText(hexagon);
                lblCompleted5.setText("Saved on " + hexagonSavedOn);
                add(panelActivity5);
            }
            if (!Objects.equals(heptagon, "Unknown")) {
                lblActivity6.setText(heptagon);
                lblCompleted6.setText("Saved on " + heptagonSavedOn);
                add(panelActivity6);
            }
        }


        setVisible(true);
    }

    @Override
    public void componentResized(ComponentEvent e) {
        fwidth = this.getWidth();
        fheight = this.getHeight();

        lblImage.setBounds(0, (2 * fheight / 8), 275, 275);
        lblImage2.setBounds(panelActivity1.getX() + panelActivity1.getWidth(), (4 * fheight / 8)-50, 500, 500);

        panelActivity1.setBounds((fwidth / 2) - 425, 50, 850, 100);
        panelActivity2.setBounds((fwidth / 2) - 425, 180, 850, 100);
        panelActivity3.setBounds((fwidth / 2) - 425, 310, 850, 100);
        panelActivity4.setBounds((fwidth / 2) - 425, 440, 850, 100);
        panelActivity5.setBounds((fwidth / 2) - 425, 570, 850, 100);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Preferences prefs = Preferences.userNodeForPackage(History.class);

        String storedLevel = prefs.get("level", "Unknown");

        if (Objects.equals(storedLevel, "Level1")) {
            if (e.getSource() == btnDelete1) {
                prefs.remove("line.name");
                remove(panelActivity1);
            } else if (e.getSource() == btnDelete2) {
                prefs.remove("rectangle.name");
                remove(panelActivity2);
            } else if (e.getSource() == btnDelete3) {
                prefs.remove("square.name");
                remove(panelActivity3);
            } else if (e.getSource() == btnDelete4) {
                prefs.remove("triangle.name");
                remove(panelActivity4);
            } else if (e.getSource() == btnDelete5) {
                prefs.remove("circle.name");
                remove(panelActivity5);
            } else if (e.getSource() == btnEdit1) {
                new NavBar("EditLine");
            } else if (e.getSource() == btnEdit2) {
                new NavBar("EditRectangle");
            } else if (e.getSource() == btnEdit3) {
                new NavBar("EditSquare");
            } else if (e.getSource() == btnEdit4) {
                new NavBar("EditTriangle");
            } else if (e.getSource() == btnEdit5) {
                new NavBar("EditCircle");
            }
        }

        if (Objects.equals(storedLevel, "Level2")) {
            if (e.getSource() == btnDelete1) {
                prefs.remove("trapezium.name");
                remove(panelActivity1);
            } else if (e.getSource() == btnDelete2) {
                prefs.remove("rhombus.name");
                remove(panelActivity2);
            } else if (e.getSource() == btnDelete3) {
                prefs.remove("parallelogram.name");
                remove(panelActivity3);
            } else if (e.getSource() == btnDelete4) {
                prefs.remove("pentagon.name");
                remove(panelActivity4);
            } else if (e.getSource() == btnDelete5) {
                prefs.remove("hexagon.name");
                remove(panelActivity5);
            } else if (e.getSource() == btnDelete6) {
                prefs.remove("heptagon.name");
                remove(panelActivity5);
            } else if (e.getSource() == btnEdit1) {
                new NavBarLevel2("EditTrapezium");
            } else if (e.getSource() == btnEdit2) {
                new NavBarLevel2("EditRhombus");
            } else if (e.getSource() == btnEdit3) {
                new NavBarLevel2("EditParallelogram");
            } else if (e.getSource() == btnEdit4) {
                new NavBarLevel2("EditPentagon");
            } else if (e.getSource() == btnEdit5) {
                new NavBarLevel2("EditHexagon");
            } else if (e.getSource() == btnEdit5) {
                new NavBarLevel2("EditHeptagon");
            }

        }


        revalidate();
        repaint();
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

    public static void main(String[] args) {
        History history = new History();

        NavBar nb = new NavBar();
        nb.add(history);

        frame.getContentPane().add(history);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
