package Main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by joao on 23-05-2016.
 */
public class KeyInput extends KeyAdapter {

    private  Handler handler;
    private boolean[] keyDown = new boolean[4];

    public KeyInput(Handler handler){
    	this.handler=handler;
    	keyDown[0]=false; //W
    	keyDown[1]=false; //S
    	keyDown[2]=false; //D
    	keyDown[3]=false; //A
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        for(int i=0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Player){
                if(key == KeyEvent.VK_W){
                	 tempObject.setVelY(-5);
                	 keyDown[0] = true;
                }
                if(key == KeyEvent.VK_S){
                    tempObject.setVelY(5);
                    keyDown[1] = true;
                }
                if(key == KeyEvent.VK_D){
                    tempObject.setVelX(5);
                    keyDown[2] = true;
                }
                if(key == KeyEvent.VK_A){
                    tempObject.setVelX(-5);
                    keyDown[3] = true;
                }
            }
        }
        
        if(key == KeyEvent.VK_ESCAPE)
        	System.exit(1);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        
        for(int i=0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Player){
                if(key == KeyEvent.VK_W)
                	 keyDown[0] = false;
                if(key == KeyEvent.VK_S)
                	 keyDown[1] = false;
                if(key == KeyEvent.VK_D)
                	 keyDown[2] = false;
                if(key == KeyEvent.VK_A)
                	 keyDown[3] = false;
                
                //vetical movement
                if(!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
                
                //horizontal movement
                if(!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);
            }
        }
    }
}
