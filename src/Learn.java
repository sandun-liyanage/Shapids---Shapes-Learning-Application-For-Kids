import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Learn extends JPanel{
    JButton rec, circle, square, triangle;
    List<String> selectedShapes = new ArrayList<>(); // list to store selected shapes

    public  NavBar nb;

    static JFrame frame1;

    Learn(){
        setSize(1400, 800);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setBackground(Color.decode("#cff29b"));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 1)); // change the layout manager to GridLayout with a single column
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 0, 20));
        buttonPanel.setBackground(Color.decode("#cff29b"));

        square = new JButton("Square");
        square.setAlignmentX(Component.LEFT_ALIGNMENT);
        square.setPreferredSize(new Dimension(150, 100)); // set same width and height for all buttons
        square.setFont(new Font("Calibri", Font.BOLD, 25));
        square.setBackground(Color.decode("#21825C"));
        square.setForeground(Color.WHITE);

        rec = new JButton("Rectangle");
        rec.setAlignmentX(Component.CENTER_ALIGNMENT);
        rec.setPreferredSize(new Dimension(150, 100)); // set same width and height for all buttons
        rec.setFont(new Font("Calibri", Font.BOLD, 25));
        rec.setBackground(Color.decode("#D14D72"));
        rec.setForeground(Color.WHITE);

        circle = new JButton("Circle");
        circle.setAlignmentX(Component.LEFT_ALIGNMENT);
        circle.setPreferredSize(new Dimension(150, 100)); // set same width and height for all buttons
        circle.setFont(new Font("Calibri", Font.BOLD, 25));
        circle.setBackground(Color.decode("#E86A33"));
        circle.setForeground(Color.WHITE);

        triangle = new JButton("Triangle");
        triangle.setAlignmentX(Component.LEFT_ALIGNMENT);
        triangle.setPreferredSize(new Dimension(150, 100)); // set same width and height for all buttons
        triangle.setFont(new Font("Calibri", Font.BOLD, 25));
        triangle.setBackground(Color.decode("#579BB1"));
        triangle.setForeground(Color.WHITE);

        buttonPanel.add(Box.createVerticalStrut(20));
        buttonPanel.add(square);

        buttonPanel.add(Box.createVerticalStrut(20));
        buttonPanel.add(rec);

        buttonPanel.add(Box.createVerticalStrut(20));
        buttonPanel.add(circle);

        buttonPanel.add(Box.createVerticalStrut(20));
        buttonPanel.add(triangle);
        buttonPanel.add(Box.createVerticalStrut(20));

        // add buttonPanel to the left side of the frame
        add(buttonPanel, BorderLayout.WEST);

        ActionListener shapeClick = new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                selectedShapes.add(e.getActionCommand());
                repaint();
            }
        };

        square.addActionListener(shapeClick);
        rec.addActionListener(shapeClick);
        circle.addActionListener(shapeClick);
        triangle .addActionListener(shapeClick);
    }

    @Override
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        Toolkit t=Toolkit.getDefaultToolkit();
        Image i=t.getImage("images/learnTeacher.jpg");
        g.drawImage(i, 800,100,550,400,this);

        for (String shape : selectedShapes) {
            switch (shape) {
                case "Square":
                    g.setColor(Color.decode("#21825C"));
                    g.fillRect(250, 40, 150, 150);
                    g.setFont(new Font("Calibri", Font.BOLD, 35));
                    g.drawString("This is a Square", 510, 100);
                    break;
                case "Rectangle":
                    g.setColor(Color.decode("#D14D72"));
                    g.fillRect(250, 210, 200, 120);
                    g.setFont(new Font("Calibri", Font.BOLD, 35));
                    g.drawString("This is a Rectangle", 510, 270);
                    break;
                case "Circle":
                    g.setColor(Color.decode("#E86A33"));
                    g.fillOval(250, 350, 160, 160);
                    g.setFont(new Font("Calibri", Font.BOLD, 35));
                    g.drawString("This is a Circle", 510, 440);
                    break;
                case "Triangle":
                    g2.setColor(Color.decode("#579BB1"));
                    int[] xValue3 ={330, 430, 230};
                    int[] yValue3 = {520, 670, 670};
                    g2.setStroke(new BasicStroke(3));
                    g2.fillPolygon(xValue3,yValue3,3);
                    g2.setFont(new Font("Calibri", Font.BOLD, 35));
                    g2.drawString("This is a Triangle", 510, 570);
                    break;
            }
        }
    }

    public static void main(final String[] arg) {

        Learn learn = new Learn();
        NavBar nb = new NavBar();
        nb.add(learn);
    }

}
