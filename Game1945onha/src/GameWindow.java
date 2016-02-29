/**
 * Created by ASUS on 2/27/2016.
 */

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameWindow extends Frame implements Runnable,MouseListener,MouseMotionListener {

    BufferedImage background;
    BufferedImage planeImage1;
    BufferedImage planeImage;
    int planeX = 200;
    int planeY = 300;
    int plane1X=100;
    int plane1Y=150;

    int direction = 0;

    public GameWindow() {
        //thiet lap tieu de cho cua so
        this.setTitle("TechKids - code the change");
        //thiet lap kich thuoc cho cua so
        this.setSize(400, 640);
        //thiet lap xem cua so co hien thi hay khong
        this.setVisible(true);
        //khi an vao nut X thi thoat
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        //load Image tu thu muc Resource
        try {
            background = ImageIO.read(new File("Resources/Background.png"));
            planeImage = ImageIO.read(new File("Resources/PLANE1.png"));
            planeImage1 =ImageIO.read(new File("Resources/PLANE2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.addMouseListener(this);
        //doan code de bat su kien bam phim
        this.addKeyListener(new KeyListener() {
            //truoc khi bam
            @Override
            public void keyTyped(KeyEvent e) {

            }
            //khi dang giu phim
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_A) {
                    direction = 3;
                } else if(e.getKeyCode() == KeyEvent.VK_D) {
                    direction = 4;
                } else if(e.getKeyCode() == KeyEvent.VK_W) {
                    direction = 1;
                } else if(e.getKeyCode() == KeyEvent.VK_S) {
                    direction = 2;
                }
            }
            //khi nhac phim len
            @Override
            public void keyReleased(KeyEvent e) {
                direction = 0;
            }
        });
    }
    //ham ve
    //ve~ moi. thu o day
    @Override
    public void paint(Graphics g) {

        super.paint(g);

        g.drawImage(background, 0, 0, null);

        g.drawImage(planeImage, planeX, planeY, null);
        g.drawImage(planeImage1,plane1X,plane1Y,null);

        //g.drawLine(0,0, 100, 100);
    }
    //Game Loop
    //Vong Lap game
    @Override
    public void run() {
        int count = 0;
        while(true) {

            if(direction == 1) {
                planeY-=3;
            }
            if(direction == 2){
                planeY+=3;
            }
            if(direction == 3){
                planeX-=3;
            }
            if(direction == 4){
                planeX+=3;
            }

            repaint();
            System.out.println(count++);

            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        plane1X = e.getX();
        plane1Y = e.getY();

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        plane1X = e.getX();
        plane1Y = e.getY();

    }
}
