import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.geom.RoundRectangle2D;

public class ColorShapeCard extends JPanel implements ComponentListener, ActionListener {
    int fwidth, fheight;
    static JFrame frame;
    JButton btnColorShape1, btnColorShape2;
    JLabel lblMainTitle, lblImage;

    public ColorShapeCard() {
        this.addComponentListener(this);
        this.setBackground(Color.decode("#fac8e6"));

        lblMainTitle = new JLabel("<html>Click a tab to color shapes!</html>");
        lblMainTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 60));
        lblMainTitle.setForeground(Color.decode("#D23369"));
        add(lblMainTitle);

        btnColorShape1 = new Utils.RoundedButton("<html><center>Color<br>Shapes</center></html>");
        btnColorShape1.setBackground(Color.decode("#A5BDFD"));
        btnColorShape1.setForeground(Color.WHITE);
        btnColorShape1.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
        btnColorShape1.setHorizontalAlignment(SwingConstants.CENTER);
        btnColorShape1.addActionListener(this);
        ImageIcon imageIcon1 = new ImageIcon("images/basicShapes.png");
        btnColorShape1.setIcon(imageIcon1);
        add(btnColorShape1);

        btnColorShape2 = new Utils.RoundedButton("<html><center>Color<br>Train</center></html>");
        btnColorShape2.setBackground(Color.decode("#97DECE"));
        btnColorShape2.setForeground(Color.WHITE);
        btnColorShape2.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
        btnColorShape2.setHorizontalAlignment(SwingConstants.CENTER);
        btnColorShape2.addActionListener(this);
        ImageIcon imageIcon2 = new ImageIcon("images/colorTrain.png");
        btnColorShape2.setIcon(imageIcon2);
        add(btnColorShape2);


        ImageIcon imageIcon = new ImageIcon("images/dog3.png");
        lblImage = new JLabel();
        lblImage.setIcon(imageIcon);
        add(lblImage);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnColorShape1) {
            new NavBar("ColorShapeLevel1Page1");
        } else if (e.getSource() == btnColorShape2) {
            new NavBar("ColorShapeLevel1Page2");
        }
    }

    @Override
    public void componentResized(ComponentEvent e) {
        fwidth = this.getWidth();
        fheight = this.getHeight();

        lblImage.setBounds((3 * fwidth / 4)-600, (2 * fheight / 8), 500, 400);

        lblMainTitle.setBounds((getWidth() - lblMainTitle.getPreferredSize().width) / 2,
                ((getHeight() - lblMainTitle.getPreferredSize().height) / 7)-20,
                lblMainTitle.getPreferredSize().width,
                lblMainTitle.getPreferredSize().height);

        btnColorShape1.setBounds(((fwidth / 2) - 400) / 2, fheight / 3, 350, 350);
        btnColorShape2.setBounds((fwidth / 2) + ((fwidth / 2) - 400) / 2, fheight / 3, 365, 350);
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

        ColorShapeCard colorShapeCard = new ColorShapeCard();
        NavBar nb = new NavBar();

        nb.add(colorShapeCard);

        frame.add(colorShapeCard);
        frame.setSize(1400, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
