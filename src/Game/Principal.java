
package Game;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Principal {
    
    public static int reiniciarJuego=-1;
    
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null,"¿Estas lsito?");
        JFrame ventana = new JFrame("Game T-REX");
        Juego jueguito = new Juego();
        ventana.add(jueguito);
        ventana.setSize(1200, 400);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        while(true){
            
            if (jueguito.juegoFinalizado) {
                reiniciarJuego=JOptionPane.showConfirmDialog(null,"Haz perdido","Perdiste", JOptionPane.YES_NO_OPTION);
                if (reiniciarJuego==0) {
                    jueguito.juegoFinalizado=false;
                    Obstaculos.inc_x=-5;
                    Obstaculos.x=1200;
                    jueguito.puntos=0;
                    jueguito.nivel=1;
                    jueguito.vidas=3;
                    reiniciarJuego=-1;
                }else{
                    System.exit(0);
                }
            }else{
                jueguito.repaint();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (jueguito.pierdeVida) {
                    JOptionPane.showMessageDialog(null,"Cuidado");
                    jueguito.pierdeVida=false;
                    jueguito.vidas--;
                    Obstaculos.x=1200;
                    Personaje.saltando=false;
                    Personaje.y=250;
                }
            }
                 
        }
    }
}
