import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class RandomShape extends JPanel implements ActionListener {

    int x, y, w, h, circleX, circleY, circleR;
    static JFrame frame;
    JPanel btnPanel;
    JButton btnDrawSquare, btnDrawRectangle, btnDrawCircle, btnReset;
    private ArrayList<Rectangle> squareList;
    private ArrayList<Rectangle> rectangleList;
    private ArrayList<Ellipse2D> circleList;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (Rectangle currentSquare : squareList) {
            int red = (int) (Math.random() * 256);
            int green = (int) (Math.random() * 256);
            int blue = (int) (Math.random() * 256);

            g2d.setColor(new Color(red, green, blue));
            g2d.fill(currentSquare);
        }

        for (Rectangle currentRectangle : rectangleList) {
            int red = (int) (Math.random() * 256);
            int green = (int) (Math.random() * 256);
            int blue = (int) (Math.random() * 256);

            g2d.setColor(new Color(red, green, blue));
            g2d.fill(currentRectangle);
        }

        for (Ellipse2D currentCircle : circleList) {
            int red = (int) (Math.random() * 256);
            int green = (int) (Math.random() * 256);
            int blue = (int) (Math.random() * 256);

            g2d.setColor(new Color(red, green, blue));
            g2d.fill(currentCircle);
        }

    }

    public RandomShape() {

        squareList = new ArrayList<Rectangle>();
        rectangleList = new ArrayList<Rectangle>();
        circleList = new ArrayList<Ellipse2D>();

        //frame = new JFrame("Draw Shape");
        setBackground(Color.BLACK);

        btnPanel = new JPanel();

        btnPanel.setBackground(Color.BLACK);

        btnDrawSquare = new Utils.RoundedButton("Draw Square");
        btnDrawSquare.setBackground(Color.decode("#1DB9C3"));
        btnDrawSquare.setForeground(Color.WHITE);
        btnDrawSquare.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        btnDrawSquare.addActionListener(this);
        btnPanel.add(btnDrawSquare);

        btnDrawRectangle = new Utils.RoundedButton("Draw Rectangle");
        btnDrawRectangle.setBackground(Color.decode("#E93B81"));
        btnDrawRectangle.setForeground(Color.WHITE);
        btnDrawRectangle.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        btnDrawRectangle.addActionListener(this);
        btnPanel.add(btnDrawRectangle);

        btnDrawCircle = new Utils.RoundedButton("Draw Circle");
        btnDrawCircle.setBackground(Color.decode("#81B214"));
        btnDrawCircle.setForeground(Color.WHITE);
        btnDrawCircle.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        btnDrawCircle.addActionListener(this);
        btnPanel.add(btnDrawCircle);

        btnReset = new Utils.RoundedButton("Reset");
        btnReset.setBackground(Color.decode("#CD1818"));
        btnReset.setForeground(Color.WHITE);
        btnReset.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        btnReset.addActionListener(this);
        btnPanel.add(btnReset);

        setLayout(new BorderLayout());
        add(btnPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnDrawSquare) {
            x = (int) (Math.random() * 1400);
            y = (int) (Math.random() * 800);
            w = (int) (Math.random() * 150);

            squareList.add(new Rectangle(x, y, w, w));
        } else if (e.getSource() == btnDrawRectangle) {
            x = (int) (Math.random() * 1400);
            y = (int) (Math.random() * 800);
            w = (int) (Math.random() * 200);
            h = (int) (Math.random() * 150);

            rectangleList.add(new Rectangle(x, y, w, h));
        } else if (e.getSource() == btnDrawCircle) {
            circleX = (int) (Math.random() * 1400);
            circleY = (int) (Math.random() * 800);
            circleR = (int) (Math.random() * 150);

            circleList.add(new Ellipse2D.Double(circleX, circleY, circleR, circleR));
        } else if (e.getSource() == btnReset) {
            squareList.clear();
            rectangleList.clear();
            circleList.clear();
        }

        // Repaint the frame to draw the shape
        repaint();

    }

    public static void main(String[] args) {
        RandomShape randomShape = new RandomShape();
        NavBar nb = new NavBar();

        nb.add(randomShape);

        frame.getContentPane().add(randomShape);
        frame.setSize(1400, 800);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}
