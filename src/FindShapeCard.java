import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.geom.RoundRectangle2D;

public class FindShapeCard extends JPanel implements ComponentListener, ActionListener {
    int fwidth, fheight;
    static JFrame frame;
    JButton btnFindShape, btnCountShape;
    JLabel lblMainTitle, lblImage;

    public FindShapeCard() {
        this.addComponentListener(this);
        this.setBackground(Color.decode("#e3befa"));

        lblMainTitle = new JLabel("<html>Click a tab to find shapes!</html>");
        lblMainTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 60));
        lblMainTitle.setForeground(Color.decode("#C539B4"));
        add(lblMainTitle);

        btnFindShape = new Utils.RoundedButton("<html><center>Find<br>Shapes</center></html>");
        btnFindShape.setBackground(Color.decode("#C9F4AA"));
        btnFindShape.setForeground(Color.BLACK);
        btnFindShape.setFont(new Font("Comic Sans MS", Font.BOLD, 55));
        btnFindShape.setHorizontalAlignment(SwingConstants.CENTER);
        btnFindShape.addActionListener(this);
        add(btnFindShape);

        btnCountShape = new Utils.RoundedButton("<html><center>Count<br>Shapes</center></html>");
        btnCountShape.setBackground(Color.decode("#FFE9B1"));
        btnCountShape.setForeground(Color.BLACK);
        btnCountShape.setFont(new Font("Comic Sans MS", Font.BOLD, 55));
        btnCountShape.setHorizontalAlignment(SwingConstants.CENTER);
        btnCountShape.addActionListener(this);
        add(btnCountShape);

        ImageIcon imageIcon = new ImageIcon("images/dog2.png");
        lblImage = new JLabel();
        lblImage.setIcon(imageIcon);
        add(lblImage);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnFindShape) {
            new NavBar("FindShapeLevel1Page1");
        } else if (e.getSource() == btnCountShape) {
            new NavBar("FindShapeLevel1Page2");
        }
    }

    @Override
    public void componentResized(ComponentEvent e) {
        fwidth = this.getWidth();
        fheight = this.getHeight();

        lblMainTitle.setBounds((getWidth() - lblMainTitle.getPreferredSize().width) / 2,
                ((getHeight() - lblMainTitle.getPreferredSize().height) / 7)-20,
                lblMainTitle.getPreferredSize().width,
                lblMainTitle.getPreferredSize().height);

        lblImage.setBounds((3 * fwidth / 4)-640, (2 * fheight / 8)+70, 500, 400);


        btnFindShape.setBounds(((fwidth / 2) - 400) / 2, fheight / 3, 350, 350);
        btnCountShape.setBounds((fwidth / 2) + ((fwidth / 2) - 400) / 2, fheight / 3, 350, 350);
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

        FindShapeCard findShapeCard = new FindShapeCard();
        NavBar nb = new NavBar();

        nb.add(findShapeCard);

        frame.add(findShapeCard);
        frame.setSize(1400, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
