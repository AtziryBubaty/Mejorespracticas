import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Graphics graPixel;

        Imagen img = new Imagen();
        int mascara[] = {1,1,1,1,0,0,0,0};
        Punteado p1 = new Punteado(150,150,100,mascara);
        Grosor g1 = new Grosor(300, 300, 100, 5);
        Punteado p2 = new Punteado(450,150,100,mascara);
        Grosor g2 = new Grosor(600, 300, 100, 5);


        img.agregarObservador(g1);
        img.agregarObservador(p1);
        img.agregarObservador(g2);
        img.agregarObservador(p2);

        img.dibujar();
    }
}
