import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.geom.RoundRectangle2D;
import java.util.Objects;

public class CountShapes extends JPanel implements ComponentListener, ActionListener {
    int fwidth, fheight;
    static JFrame frame;
    JButton btnCheck, btnReset;
    JLabel lblMainTitle, lblCircle, lblSquare, lblRectangle, lblTriangle, lblStar, lblImage2, lblImage1, lblCircleResult, lblSquareResult, lblRectangleResult, lblTriangleResult, lblStarResult;

    JTextField txtCircle, txtSquare, txtRectangle, txtTriangle, txtStar;

    @Override
    public void actionPerformed(ActionEvent e) {
        String circle = txtCircle.getText();
        String square = txtSquare.getText();
        String rectangle = txtRectangle.getText();
        String triangle = txtTriangle.getText();
        String star = txtStar.getText();

        if (e.getSource() == btnReset) {
            // Clear all text fields
            txtCircle.setText("");
            txtSquare.setText("");
            txtRectangle.setText("");
            txtTriangle.setText("");
            txtStar.setText("");

            // Remove the result labels
            remove(lblCircleResult);
            remove(lblSquareResult);
            remove(lblRectangleResult);
            remove(lblTriangleResult);
            remove(lblStarResult);

            // Repaint the panel to reflect the changes
            repaint();
        }
        if (e.getSource() == btnCheck) {
            /* Circle */
            if (circle.equals("7")) {
                lblCircleResult = new JLabel("<html>Correct</html>");
                lblCircleResult.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
                lblCircleResult.setForeground(Color.decode("#32a852"));
                lblCircleResult.setBounds(1250, 70, 200, 100);
                add(lblCircleResult);

                // Repaint the panel to reflect the changes
                repaint();
            } else {
                lblCircleResult = new JLabel("<html>Wrong</html>");
                lblCircleResult.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
                lblCircleResult.setForeground(Color.decode("#B70404"));
                lblCircleResult.setBounds(1250, 70, 200, 100);
                add(lblCircleResult);

                // Repaint the panel to reflect the changes
                repaint();
            }

            /* Square */
            if (square.equals("6")) {
                lblSquareResult = new JLabel("<html>Correct</html>");
                lblSquareResult.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
                lblSquareResult.setForeground(Color.decode("#32a852"));
                lblSquareResult.setBounds(1250, 140, 200, 100);
                add(lblSquareResult);

                // Repaint the panel to reflect the changes
                repaint();
            } else {
                lblSquareResult = new JLabel("<html>Wrong</html>");
                lblSquareResult.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
                lblSquareResult.setForeground(Color.decode("#B70404"));
                lblSquareResult.setBounds(1250, 140, 200, 100);
                add(lblSquareResult);

                // Repaint the panel to reflect the changes
                repaint();
            }

            /* Rectangle */
            if (rectangle.equals("9")) {
                lblRectangleResult = new JLabel("<html>Correct</html>");
                lblRectangleResult.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
                lblRectangleResult.setForeground(Color.decode("#32a852"));
                lblRectangleResult.setBounds(1250, 230, 200, 100);
                add(lblRectangleResult);

                // Repaint the panel to reflect the changes
                repaint();
            } else {
                lblRectangleResult = new JLabel("<html>Wrong</html>");
                lblRectangleResult.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
                lblRectangleResult.setForeground(Color.decode("#B70404"));
                lblRectangleResult.setBounds(1250, 230, 200, 100);
                add(lblRectangleResult);

                // Repaint the panel to reflect the changes
                repaint();
            }

            /* Triangle */
            if (triangle.equals("12")) {
                lblTriangleResult = new JLabel("<html>Correct</html>");
                lblTriangleResult.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
                lblTriangleResult.setForeground(Color.decode("#32a852"));
                lblTriangleResult.setBounds(1250, 320, 200, 100);
                add(lblTriangleResult);

                // Repaint the panel to reflect the changes
                repaint();
            } else {
                lblTriangleResult = new JLabel("<html>Wrong</html>");
                lblTriangleResult.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
                lblTriangleResult.setForeground(Color.decode("#B70404"));
                lblTriangleResult.setBounds(1250, 320, 200, 100);
                add(lblTriangleResult);

                // Repaint the panel to reflect the changes
                repaint();
            }
            /* Star */
            if (star.equals("2")) {
                lblStarResult = new JLabel("<html>Correct</html>");
                lblStarResult.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
                lblStarResult.setForeground(Color.decode("#32a852"));
                lblStarResult.setBounds(1250, 400, 200, 100);
                add(lblStarResult);

                // Repaint the panel to reflect the changes
                repaint();
            } else {
                lblStarResult = new JLabel("<html>Wrong</html>");
                lblStarResult.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
                lblStarResult.setForeground(Color.decode("#B70404"));
                lblStarResult.setBounds(1250, 400, 200, 100);
                add(lblStarResult);

                // Repaint the panel to reflect the changes
                repaint();
            }
        }
    }

    public CountShapes() {
        this.addComponentListener(this);
        this.setBackground(Color.decode("#e3befa"));

        lblMainTitle = new JLabel("<html>Count the Shapes </html>");
        lblMainTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
        lblMainTitle.setForeground(Color.decode("#6A097D"));
        add(lblMainTitle);

        lblCircle = new JLabel("<html>Circle</html>");
        lblCircle.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
        lblCircle.setForeground(Color.decode("#95389E"));
        add(lblCircle);

        lblSquare = new JLabel("<html>Square</html>");
        lblSquare.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
        lblSquare.setForeground(Color.decode("#95389E"));
        add(lblSquare);

        lblRectangle = new JLabel("<html>Rectangle</html>");
        lblRectangle.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
        lblRectangle.setForeground(Color.decode("#95389E"));
        add(lblRectangle);

        lblTriangle = new JLabel("<html>Triangle</html>");
        lblTriangle.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
        lblTriangle.setForeground(Color.decode("#95389E"));
        add(lblTriangle);

        lblStar = new JLabel("<html>Star</html>");
        lblStar.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
        lblStar.setForeground(Color.decode("#95389E"));
        add(lblStar);


        txtCircle = new JTextField("");
        txtCircle.setBackground(Color.WHITE);
        txtCircle.setForeground(Color.BLACK);
        txtCircle.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        add(txtCircle);

        txtSquare = new JTextField("");
        txtSquare.setBackground(Color.WHITE);
        txtSquare.setForeground(Color.BLACK);
        txtSquare.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        add(txtSquare);

        txtRectangle = new JTextField("");
        txtRectangle.setBackground(Color.WHITE);
        txtRectangle.setForeground(Color.BLACK);
        txtRectangle.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        add(txtRectangle);

        txtTriangle = new JTextField("");
        txtTriangle.setBackground(Color.WHITE);
        txtTriangle.setForeground(Color.BLACK);
        txtTriangle.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        add(txtTriangle);

        txtStar = new JTextField("");
        txtStar.setBackground(Color.WHITE);
        txtStar.setForeground(Color.BLACK);
        txtStar.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        add(txtStar);

        btnCheck = new Utils.RoundedButton("<html><center>Check</center></html>");
        btnCheck.setBackground(Color.decode("#569DAA"));
        btnCheck.setForeground(Color.WHITE);
        btnCheck.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnCheck.setHorizontalAlignment(SwingConstants.CENTER);
        btnCheck.addActionListener(this);
        add(btnCheck);

        btnReset = new Utils.RoundedButton("<html><center>Reset</center></html>");
        btnReset.setBackground(Color.decode("#6C9BCF"));
        btnReset.setForeground(Color.WHITE);
        btnReset.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnReset.setHorizontalAlignment(SwingConstants.CENTER);
        btnReset.addActionListener(this);
        add(btnReset);


        lblImage2 = new JLabel(new ImageIcon("images/count.png"));
        add(lblImage2);

        lblImage1 = new JLabel(new ImageIcon("images/mouse.png"));
        add(lblImage1);

    }

    @Override
    public void componentResized(ComponentEvent e) {
        fwidth = this.getWidth();
        fheight = this.getHeight();

        lblMainTitle.setBounds((getWidth() - lblMainTitle.getPreferredSize().width) / 2,
                ((getHeight() - lblMainTitle.getPreferredSize().height) / 7) - 80,
                lblMainTitle.getPreferredSize().width,
                lblMainTitle.getPreferredSize().height);

        lblCircle.setBounds(((getWidth() - lblCircle.getPreferredSize().width) / 2) + 200,
                ((getHeight() - lblCircle.getPreferredSize().height) / 7),
                lblCircle.getPreferredSize().width,
                lblCircle.getPreferredSize().height);

        lblSquare.setBounds(((getWidth() - lblSquare.getPreferredSize().width) / 2) + 200,
                ((getHeight() - lblMainTitle.getPreferredSize().height) / 7) + 90,
                lblSquare.getPreferredSize().width,
                lblSquare.getPreferredSize().height);

        lblRectangle.setBounds(((getWidth() - lblRectangle.getPreferredSize().width) / 2) + 200,
                ((getHeight() - lblMainTitle.getPreferredSize().height) / 7) + 170,
                lblRectangle.getPreferredSize().width,
                lblRectangle.getPreferredSize().height);

        lblTriangle.setBounds(((getWidth() - lblTriangle.getPreferredSize().width) / 2) + 200,
                ((getHeight() - lblMainTitle.getPreferredSize().height) / 7) + 250,
                lblTriangle.getPreferredSize().width,
                lblTriangle.getPreferredSize().height);

        lblStar.setBounds(((getWidth() - lblStar.getPreferredSize().width) / 2) + 200,
                ((getHeight() - lblMainTitle.getPreferredSize().height) / 7) + 330,
                lblStar.getPreferredSize().width,
                lblStar.getPreferredSize().height);

        lblImage1.setBounds(((getWidth() - lblImage1.getPreferredSize().width) / 2) - 50,
                ((getHeight() - lblImage1.getPreferredSize().height) / 7) + 250,
                lblImage1.getPreferredSize().width,
                lblImage1.getPreferredSize().height);


        lblImage2.setBounds(((getWidth() - lblImage2.getPreferredSize().width) / 2) - 400,
                ((getHeight() - lblMainTitle.getPreferredSize().height) / 7),
                lblImage2.getPreferredSize().width,
                lblImage2.getPreferredSize().height);


        btnReset.setBounds((((fwidth / 2) - 400) / 2) + 950, (fheight / 3) + 280, 200, 80);

        btnCheck.setBounds((((fwidth / 2) - 400) / 2) + 700, (fheight / 3) + 280, 200, 80);

        txtCircle.setBounds(((fwidth / 2) + 1500) / 2, (fheight / 3) - 130, 100, 50);
        txtSquare.setBounds(((fwidth / 2) + 1500) / 2, (fheight / 3) - 50, 100, 50);
        txtRectangle.setBounds(((fwidth / 2) + 1500) / 2, (fheight / 3) + 30, 100, 50);
        txtTriangle.setBounds(((fwidth / 2) + 1500) / 2, (fheight / 3) + 110, 100, 50);
        txtStar.setBounds(((fwidth / 2) + 1500) / 2, (fheight / 3) + 190, 100, 50);
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

        CountShapes colorShapeCard = new CountShapes();
        NavBar nb = new NavBar();

        nb.add(colorShapeCard);

        frame.add(colorShapeCard);
        frame.setSize(1400, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
