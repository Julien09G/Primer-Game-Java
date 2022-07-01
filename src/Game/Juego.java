
package Game;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;


public class Juego extends JPanel{
    Personaje personaje1 = new Personaje(this);
    Obstaculos obstaculo1 = new Obstaculos(this);
    Fondo fondo1 = new Fondo();
    
    public boolean juegoFinalizado = false;
    public boolean pierdeVida = false;
    public int puntos = 0;
    public int vidas =3;
    public int nivel=1;
    
    public Juego(){
        addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                personaje1.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
          
            }
    });
        setFocusable(true);
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D)g;
        g2.setPaint(Color.WHITE);
        
        dibujar(g2);
        dibujarPuntaje(g2);
    }
    
    public void dibujar(Graphics2D g){
        switch (nivel) {
            case 1: g.setColor(Color.YELLOW);
                    fondo1.paint(g);
                break;
            case 2: g.setColor(Color.PINK);
                    fondo1.paint(g);
                break;
            case 3: g.setColor(Color.MAGENTA);
                    fondo1.paint(g);
                break;
            case 4: g.setColor(Color.CYAN);
                    fondo1.paint(g);
                break;
            case 5: g.setColor(Color.GREEN);
                    fondo1.paint(g);
                break;
            case 6: g.setColor(Color.WHITE);
                    fondo1.paint(g);
                break;
        }
        
        g.setColor(Color.BLACK);
        personaje1.paint(g);
        
        g.setColor(Color.RED);
        obstaculo1.paint(g);  
        
        obstaculo1.mover();
        personaje1.mover();
    }
    
    public void dibujarPuntaje(Graphics2D g){
       Graphics2D g1=g, g2=g;
       Font score = new Font("Arial", Font.BOLD,30);
       g.setFont(score);
       g.setColor(Color.BLACK);
       
       g1.drawString("Vidas:" + vidas,20,30);
       g1.drawString("Puntaje:" + puntos,1000,30);
       g1.drawString("Nivel:" + nivel,500,30);
       
        if (juegoFinalizado) {
            g2.setColor(Color.red);
            g2.drawString("Haz Periddo", ((float)getBounds().getCenterX()/2)+170,70);
        }
    }
    
    public void finJuego(){
        juegoFinalizado=true;
    }
    
    public void pierdeVida(){
        pierdeVida=true;
    }
}
