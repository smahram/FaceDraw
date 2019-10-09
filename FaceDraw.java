//Sarah Mahram
//Face Draw

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;

class OvalDraw extends Oval{
    
    private Color c;
    public void setColor(Color cin){ 
        c = cin;
    }

    public OvalDraw(int positionXIn, int positionYIn, int widthIn, int heightIn){
       super(positionXIn, positionYIn, widthIn, heightIn);
      // System.out.println("Constructor");
       int R = (int)(Math.random()*256); //Random color for smiley faces 
       int G = (int)(Math.random()*256);
       int B = (int)(Math.random()*256);
       
        c = new Color(R,G,B);
    }

    public void paintComponent(Graphics g) {

            g.setColor(c);

            Graphics2D g2 = (Graphics2D)g;{
            g2.setStroke(new BasicStroke(10F));
            g2.fillOval(getPositionX(), getPositionY(), getWidth(), getHeight());


        }
        
     }
}
 

class Face extends OvalDraw{

    private OvalDraw eye;
    private OvalDraw eye1;
    private int Mouth; //1 = smile & 2 = frown & 0 = half smile  
    private OvalDraw positionXIn;
    private OvalDraw positionYIn;
    private OvalDraw widthIn;
    private OvalDraw heightIn;
    

    public Face(int positionXIn, int positionYIn, int widthIn, int heightIn){
       super(positionXIn, positionYIn, widthIn, heightIn);

         int eyeHeight = heightIn / 10; 
         int eyeWidth = eyeHeight * 1;
         int eyePositionX = positionXIn + (widthIn / 4) - (eyeWidth / 2);
         int eyePositionY = positionYIn + (heightIn / 3) - (eyeHeight * 2); 
             
         eye = new OvalDraw(eyePositionX, eyePositionY, eyeWidth, eyeHeight);
         eye.setColor(Color.black);
         eye1 = new OvalDraw(eyePositionX+75, eyePositionY+2, eyeWidth, eyeHeight);
         eye1.setColor(Color.black);
        
        Mouth = (int)(Math.random()*3);
        System.out.println(Mouth); 

    }  
     
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        eye.paintComponent(g);
        eye1.paintComponent(g);
        

        g.setColor(Color.black);
        if(Mouth == 2){
            //System.out.println("Frown");
            g.drawArc(getPositionX(), getPositionY()+(getHeight()/2), getWidth()-10, getHeight()-10, 45, 90);//Frown
        }
        else if(Mouth == 1){     
           g.drawArc(getPositionX()*1, getPositionY()+(getHeight()/80), (getWidth()-20), (getHeight()-9)+2, 180, 170);//Smile
        } 
        else{
           g.drawLine(getPositionX()+(getWidth()/4)/2, getPositionY()+(getHeight()/2), getPositionX()+(getWidth()+1)/1, getPositionY()+(getHeight()/2));//Neutral 
        }
         

     }
}

class FaceDrawPanel extends JPanel {
    
    public ArrayList<Face> faceList = new ArrayList<Face>();

    public FaceDrawPanel(){
        
       faceList.add(new Face(100,100,150,160));
       faceList.add(new Face(230,200,230,200));
       faceList.add(new Face(430, 300, 310, 240));
       faceList.add(new Face(100,350,200,300));
       faceList.add(new Face(640, 100, 200, 170));
       faceList.add(new Face(350,80,150,130));
       faceList.add(new Face(500, 130, 180, 190));
       faceList.add(new Face(260, 430, 260, 230));
       faceList.add(new Face(600, 350, 290, 220));
       faceList.add(new Face(120, 120, 170, 180));
      
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Random random = new Random();
        int randnum = random.nextInt(7) + 3;
        System.out.println("Random #:");
        System.out.println(randnum);
        
        for(int i=0; i<randnum; i++){
            
            faceList.get(i).paintComponent(g);
        }
        
    }
}

public class FaceDraw {
     public static void main(String[] args){
         System.out.println("Face Draw!");
 
         JFrame myFrame = new JFrame("Face Draw");
         myFrame.setBounds(200,90,900,700);
         myFrame.setBackground(Color.white);
         myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
         FaceDrawPanel myFaceDrawPanel = new FaceDrawPanel();
         myFrame.add(myFaceDrawPanel);
         myFrame.setVisible(true);     

            
     }
}