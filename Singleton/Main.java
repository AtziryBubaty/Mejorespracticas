import javax.swing.*;

public class Main extends JFrame{
    public static void main(String[] args) {
        Singleton singleton=Singleton.getinstance();
        singleton.face();
    }
}