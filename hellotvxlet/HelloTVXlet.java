package hellotvxlet;

import java.awt.Color;
import java.awt.Image;
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
Image imgs[]=new Image[10];
int huidig=0;
      HIcon levels=new HIcon(imgs[huidig],170,30,360,360);
      
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
      // foto 1
       imgs[0]=scene.getToolkit().getImage("level1.png");
       imgs[1]=scene.getToolkit().getImage("level2.png");

      
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
System.out.println(   guess);

if (guess.equals("school")) {
    System.out.println("juist");
      levels.setGraphicContent(imgs[1], HVisible.NORMAL_STATE);
}
    }

    public void caretMoved(HTextEvent arg0) {
 //       throw new UnsupportedOperationException("Not supported yet.");
        
    }
}
