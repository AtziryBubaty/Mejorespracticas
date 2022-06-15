import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Singleton extends JFrame{
    static private Singleton instance=new Singleton();
    private BufferedImage buffer;
    private Graphics graPixel;

    private Singleton(){
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Dimension tamanioPanatalla = miPantalla.getScreenSize();
        int altoPantalla = tamanioPanatalla.height;
        int anchoPantalla = tamanioPanatalla.width;

        setSize(anchoPantalla / 2, altoPantalla / 2);
        setLocation(anchoPantalla / 4, altoPantalla / 4);

        setLayout(null);
    }

    private void circuloBrensenham(int xc, int yc, int r, BufferedImage buff) {
        int x = - r;
        int y = 0;
        int error = 2 - 2 * r;

        do {
            buff.setRGB(xc - x, yc + y, Color.yellow.getRGB());
            buff.setRGB(xc - y, yc - x, Color.pink.getRGB());
            buff.setRGB(xc + x, yc - y, Color.black.getRGB());
            buff.setRGB(xc + y, yc + x, Color.red.getRGB());

            r = error;
            if (r > x) {
                error += ++x * 2 + 1;
            }
            if (r <= y) {
                error += ++y * 2 + 1;
            }
        } while (x < 0);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(buffer, 0, 0, null);
    }

    public void face(){
        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        graPixel = buffer.createGraphics();
        circuloBrensenham(200, 200, 130, buffer);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static Singleton getinstance(){
        return instance;
    }
}
