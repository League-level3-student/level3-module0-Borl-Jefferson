package _05_Pixel_Art;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class PixelArtMaker implements MouseListener, ActionListener{
	
    private JFrame window;
    private GridInputPanel gip;
    GridPanel gp;
    ColorSelectionPanel csp;
    JButton jb;
    JButton jb2; 

    public void start() {
        gip = new GridInputPanel(this);	
        window = new JFrame("Pixel Art");
        window.setLayout(new FlowLayout());
        window.setResizable(false);
        

        jb = new JButton();
        jb2 = new JButton();
        jb2.setText("load");
        jb.setText("save");
        jb.addActionListener(this);
        jb2.addActionListener(this);

        window.add(gip);
        window.add(jb);
        window.add(jb2);
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    public void submitGridData(int w, int h, int r, int c) {
        gp = new GridPanel(w, h, r, c);
        csp = new ColorSelectionPanel();
        window.remove(gip);
        window.add(gp);
        window.add(csp);
        gp.repaint();
        gp.addMouseListener(this);
        window.pack();
    }
    
  
    

    public static void main(String[] args) {
        new PixelArtMaker().start();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        gp.setColor(csp.getSelectedColor());
        System.out.println(csp.getSelectedColor());
        gp.clickPixel(e.getX(), e.getY());
        gp.repaint();
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
	public void actionPerformed(ActionEvent j) {
		// TODO Auto-generated method stub\
		//gp.save(JOptionPane.showInputDialog("Save name:"));
		if(j.getSource().equals(jb)) {
	try (FileOutputStream fos = new FileOutputStream(new File("src/_05_Pixel_Art/"+JOptionPane.showInputDialog("Save name:")+".dat")); 
			ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			
			oos.writeObject(gp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		
		if(j.getSource().equals(jb2)) {
			gp=load();
			window.removeAll();
			window.setVisible(false);
			
			window = new JFrame("Pixel Art");
	        window.setLayout(new FlowLayout());
	        window.setResizable(false);
			
			window.add(gip);
	        window.add(jb);
	        window.add(jb2);
	        window.pack();
	        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        window.setVisible(true);
	        
	        csp = new ColorSelectionPanel();
	        window.remove(gip);
	        window.add(gp);
	        window.add(csp);
	        gp.repaint();
	        gp.addMouseListener(this);
	        window.pack();
			}
		}
	
	private static GridPanel load() {
		
		try (FileInputStream fis = new FileInputStream(new File("src/_05_Pixel_Art/"+JOptionPane.showInputDialog("File name:")+".dat")); ObjectInputStream ois = new ObjectInputStream(fis)) {
			return (GridPanel) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// This can occur if the object we read from the file is not
			// an instance of any recognized class
			e.printStackTrace();
			return null;
		}
		
	}
}
