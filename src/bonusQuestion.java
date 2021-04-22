import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class bonusQuestion {
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame();
        frame.setSize(700, 185);
        createUI(frame);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setTitle("Nine Countries");
        frame.setVisible(true);
    }

    /**
     * America
     * UK
     * Japan
     * South Korea
     * Poland
     * Israel
     * Canada
     * Germany
     * Sweden
     * @param frame
     */
    private static void createUI(JFrame frame) throws IOException {
        JButton[] buttons = {
                new JButton("United States"),
                new JButton("Poland"),
                new JButton("South Korea"),
                new JButton("Japan"),
                new JButton("United Kingdom"),
                new JButton("Israel"),
                new JButton("Canada"),
                new JButton("Germany"),
                new JButton("Sweden")
        };
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setBounds(resources.BUTTON[i]);
            int finalI = i;
            buttons[i].addActionListener(lam -> {
                try {
                    BufferedImage img = ImageIO.read(new File(resources.images[finalI]));
                    ImageIcon icon = new ImageIcon(img.getScaledInstance(img.getWidth()/2, img.getHeight()/2, Image.SCALE_DEFAULT));
                    JLabel label = new JLabel(icon);
                    JOptionPane.showMessageDialog(null, label, "Image", JOptionPane.PLAIN_MESSAGE);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            frame.add(buttons[i]);
        }
    }
}
class resources {
    static String[] images = {
            System.getProperty("user.dir") + "/resources/america.jpg",
            System.getProperty("user.dir") + "/resources/poland.jpg",
            System.getProperty("user.dir") + "/resources/south-korea.png",
            System.getProperty("user.dir") + "/resources/japan.jpg",
            System.getProperty("user.dir") + "/resources/uk.png",
            System.getProperty("user.dir") + "/resources/israel.jpg",
            System.getProperty("user.dir") + "/resources/canada.jpg",
            System.getProperty("user.dir") + "/resources/germany.jpg",
            System.getProperty("user.dir") + "/resources/sweden.jpg",
    };
    static Rectangle[] BUTTON = {
            new Rectangle(5, 5, 200, 25),
            new Rectangle(250, 5, 200, 25),
            new Rectangle(495, 5, 200, 25),
            new Rectangle(5, 55, 200, 25),
            new Rectangle(250, 55, 200, 25),
            new Rectangle(495, 55, 200, 25),
            new Rectangle(5,  105, 200, 25),
            new Rectangle(250, 105, 200, 25),
            new Rectangle(495, 105, 200, 25),
    };
}
