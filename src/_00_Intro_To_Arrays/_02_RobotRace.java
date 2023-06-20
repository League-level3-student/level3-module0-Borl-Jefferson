package _00_Intro_To_Arrays;

import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import org.jointheleague.graphical.robot.Robot;

public class _02_RobotRace {
    // 1. make a main method
public static void main(String[] args) {
	boolean hadwon=false;
Random r = new Random();
        // 2. create an array of 5 robots.
Robot[] rob = new Robot[5];
Integer[] ger = new Integer[5];
for (int i = 0; i < ger.length; i++) {
	ger[i]=0;
}
        // 3. use a for loop to initialize the robots.
for(int i=0; i<rob.length; i++) {
	rob[i]= new Robot();
	rob[i].setSpeed(500);
	rob[i].moveTo(50+100*i, 500);
	
	
}
while(!hadwon){
	for(int i=0; i<rob.length; i++) {
	ger[i]+=r.nextInt(50);
	rob[i].move(ger[i]);
	
	rob[i].setAngle(ger[i+i]);
	
	
	
	
	if(rob[i].getY()<=0) {
		hadwon=true;
		JOptionPane.showMessageDialog(null, "Robot " + (i+1) + " has one!");
		break;
	}
}
}

while(hadwon) {
	for(int i=0; i<rob.length; i++) {
	rob[i].moveTo(r.nextInt(500)+50, r.nextInt(500)+50);
	
	}
	}
        // 4. make each robot start at the bottom of the screen, side by side, facing up
    
        // 5. use another for loop to iterate through the array and make each robot move
        // a random amount less than 50.
    
        // 6. use a while loop to repeat step 5 until a robot has reached the top of the
        // screen.
    
        // 7. declare that robot the winner and throw it a party!
    
        // 8. try different races with different amounts of robots.
    
        // 9. make the robots race around a circular track.
}
}
