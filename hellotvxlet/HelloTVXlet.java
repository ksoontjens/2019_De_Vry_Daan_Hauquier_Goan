package hellotvxlet;

import java.awt.Color;
import java.awt.Image;
import java.awt.MediaTracker;
import javax.tv.xlet.*;
import org.havi.ui.HIcon;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HSinglelineEntry;
import org.havi.ui.HStaticText;
import org.havi.ui.HVisible;
import org.havi.ui.event.HTextEvent;
import org.havi.ui.event.HTextListener;


public class HelloTVXlet implements Xlet, HTextListener {
Image imgs[]= new Image[6];
String str[] = new String[]{"school", "film", "natuur", "kleur", "broadcast"};
int woord = 0;
String antwoord = str[woord];

int huidig=0;
      HIcon levels;
      
  HSinglelineEntry hst=new HSinglelineEntry(250,450,200,50,20);
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) {
      HScene scene=HSceneFactory.getInstance().getDefaultHScene();
      
      hst.setBackgroundMode(HVisible.BACKGROUND_FILL);
      hst.setBackground(Color.GRAY);
      
      hst.getTextContent(HVisible.NORMAL_STATE);
      hst.addHTextListener(this);
      scene.add(hst);
      scene.setVisible(true);
      
      // foto
       imgs[0]=scene.getToolkit().getImage("level1.png");
       imgs[1]=scene.getToolkit().getImage("level2.png");
       imgs[2]=scene.getToolkit().getImage("level3.png");
       imgs[3]=scene.getToolkit().getImage("level4.png");
       imgs[4]=scene.getToolkit().getImage("level5.png");
       imgs[5]=scene.getToolkit().getImage("gewonnen.png");
       
       MediaTracker mt=new MediaTracker(scene);
       mt.addImage(imgs[0], 0);
       mt.addImage(imgs[1], 1);
       mt.addImage(imgs[2], 2);
       mt.addImage(imgs[3], 3);
       mt.addImage(imgs[4], 4);
       mt.addImage(imgs[5], 5);
      
      levels=new HIcon(imgs[huidig],170,30,360,360);
      scene.add(levels);

      scene.validate();
 
      hst.requestFocus();
     
    }

    public void startXlet() {
    
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }

    public void textChanged(HTextEvent arg0) {

String guess = hst.getTextContent(HVisible.NORMAL_STATE).toString();
System.out.println(guess);

if (woord >= 5) {
        hst.setTextContent("Gewonnen", HVisible.NORMAL_STATE);
} 

if (guess.equals(antwoord)&& woord < 5) {
    hst.setTextContent("", HVisible.NORMAL_STATE);
    System.out.println("juist");
      huidig = huidig+1;
      levels.setGraphicContent(imgs[huidig], HVisible.NORMAL_STATE);
      woord = woord+1;
      antwoord = str[woord];
         
}
 

 }

    public void caretMoved(HTextEvent arg0) {
 //       throw new UnsupportedOperationException("Not supported yet.");
        
    }
}
