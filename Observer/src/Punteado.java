import java.awt.*;
import java.awt.image.BufferedImage;

public class Punteado implements Observador{

    private int xCent, yCent, r, mascara[];

    public Punteado(int xCent, int yCent, int r, int mascara[]){
        this.xCent = xCent;
        this.yCent = yCent;
        this.r = r;
        this.mascara = mascara;
    }

    @Override
    public void update(BufferedImage bu) {
        int x,y;
        int contadorMascara = 0;

        for (int i=0; i<360; i++){
            x = (int)(xCent+r*Math.cos(Math.toRadians(i)));
            y = (int)(yCent+r*Math.sin(Math.toRadians(i)));
            if(mascara[contadorMascara] == 1){
                bu.setRGB(x,y, Color.BLACK.getRGB());
            }
            contadorMascara++;
            if(contadorMascara >= mascara.length){
                contadorMascara = 0;
            }
        }
    }
}
