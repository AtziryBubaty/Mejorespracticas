import java.awt.*;
import java.awt.image.BufferedImage;

public class Grosor implements Observador{


    private int xc, yc, r, grosor;

    public Grosor(int xc, int yc, int r, int Grosor){
        this.xc = xc;
        this.yc = yc;
        this.r = r;
        this.grosor = Grosor;
    }


    @Override
    public void update(BufferedImage bu) {
        int x = -r;
        int y = 0;
        int err = 2-2*r;

        do {
            for(int i = grosor - 1; i > 0; i--) {

                //abajo hacia derecha
                bu.setRGB(xc - x, yc + y, Color.BLACK.getRGB());
                bu.setRGB(xc - x-i, yc + y, Color.BLACK.getRGB());
                bu.setRGB(xc - x+i, yc + y, Color.BLACK.getRGB());
                bu.setRGB(xc - x, yc + y-i, Color.BLACK.getRGB());
                bu.setRGB(xc - x, yc + y+i, Color.BLACK.getRGB());

                //abajo hacia izquierda
                bu.setRGB(xc - y, yc - x, Color.BLACK.getRGB());
                bu.setRGB(xc - y-i, yc - x, Color.BLACK.getRGB());
                bu.setRGB(xc - y+i, yc - x, Color.BLACK.getRGB());
                bu.setRGB(xc - y, yc - x-i, Color.BLACK.getRGB());
                bu.setRGB(xc - y, yc - x+i, Color.BLACK.getRGB());

                //arriba hacia la izquierda
                bu.setRGB(xc + x, yc - y, Color.BLACK.getRGB());
                bu.setRGB(xc + x+i, yc - y, Color.BLACK.getRGB());
                bu.setRGB(xc + x-i, yc - y, Color.BLACK.getRGB());
                bu.setRGB(xc + x, yc - y+i, Color.BLACK.getRGB());
                bu.setRGB(xc + x, yc - y-i, Color.BLACK.getRGB());

                //arriba hacia la derecha
                bu.setRGB(xc + y, yc + x, Color.BLACK.getRGB());
                bu.setRGB(xc + y+i, yc + x, Color.BLACK.getRGB());
                bu.setRGB(xc + y-i, yc + x, Color.BLACK.getRGB());
                bu.setRGB(xc + y, yc + x+i, Color.BLACK.getRGB());
                bu.setRGB(xc + y, yc + x-i, Color.BLACK.getRGB());
            }
            r = err;
            if (r > x)
                err += ++x*2+1; /* e_xy+e_x > 0 */
            if (r <= y)
                err += ++y*2+1; /* e_xy+e_y < 0*/
        } while (x < 0);
    }
}
