import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class Utils {

    static class RoundedButton extends JButton {
        public RoundedButton(String text) {
            super(text);
            setFocusPainted(false);
            setBorderPainted(false);
            setContentAreaFilled(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int width = getWidth();
            int height = getHeight();

            g2.setColor(getBackground());
            g2.fill(new RoundRectangle2D.Double(0, 0, width - 1, height - 1, 40, 40));

            super.paintComponent(g2);

            g2.dispose();
        }
    }
    static class RoundedLabel extends JLabel {
        public RoundedLabel(String text) {
            super(text);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int width = getWidth();
            int height = getHeight();

            g2.setColor(getBackground());
            g2.fill(new RoundRectangle2D.Double(0, 0, width - 1, height - 1, 40, 40));

            super.paintComponent(g2);

            g2.dispose();
        }
    }
    public static Color stringToColor(String shapeColor){
        // Remove the unnecessary prefix and suffix from the color string
        String colorCode = shapeColor.substring(shapeColor.indexOf("[") + 1, shapeColor.lastIndexOf("]"));

        // Split the color code into individual RGB values
        String[] rgbValues = colorCode.split(",");

        // Convert the RGB values from String to int
        int red = Integer.parseInt(rgbValues[0].substring(rgbValues[0].indexOf("=") + 1));
        int green = Integer.parseInt(rgbValues[1].substring(rgbValues[1].indexOf("=") + 1));
        int blue = Integer.parseInt(rgbValues[2].substring(rgbValues[2].indexOf("=") + 1));

        // Create a new Color object using the RGB values
        Color color = new Color(red, green, blue);

        return color;
    }
}
