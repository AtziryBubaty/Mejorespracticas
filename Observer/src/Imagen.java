import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Imagen extends JFrame implements Observado {

    private BufferedImage buffer;
    private Graphics graPixel;
    private final ArrayList<Observador> observadores;

    public Imagen(){
        observadores = new ArrayList<Observador>();

        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Dimension tamPanatalla = miPantalla.getScreenSize();
        int pantallaWidth = tamPanatalla.width;
        int pantallaHeight = tamPanatalla.height;

        setSize(pantallaWidth/2, pantallaHeight/2);
        setLocation(pantallaWidth/4, pantallaHeight/4);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    @Override
    public void dibujar() {
        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        graPixel = buffer.createGraphics();

        for (Observador img:observadores){
            img.update(buffer);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(buffer, 0, 0, this);
    }
}
