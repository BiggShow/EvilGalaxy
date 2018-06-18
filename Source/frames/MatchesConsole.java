package frames;

import java.awt.event.*;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class MatchesConsole extends Console{
    JList list = new JList();
    Vector<String> matches = new Vector<>();
        
//------------------------------------------------------------------------------
    public static void main(String[] args) {
        new MatchesConsole();
    }
//------------------------------------------------------------------------------
    public MatchesConsole(){
        setLayout(new java.awt.FlowLayout());
        //add(statusLabel);
        setSize(600, 400);
        setBounds(100, 30, 650, 381);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textField.addKeyListener(new TextHandler());
        JScrollPane scrollPane = new JScrollPane();
        //statusLabel.setText("Match: " + matches.size());
        setVisible(true);
    }
//------------------------------------------------------------------------------
    public void initiateSearch(String lookFor){
    	
        lookFor = lookFor.toLowerCase();
        
        for(String each : commands){
            if(each.contains(lookFor)){
                matches.add(each);
                textArea.append("Match: " + each + "\n");
                getTextField().setText(each);
            }
        }
        //this.repaint();

        if(matches.size()!=0){
            list.setListData(matches);
        }else{
            matches.add("No Matches Found");
            list.setListData(matches);
        }

    }

//------------------------------------------------------------------------------

    class TextHandler implements KeyListener{
        @Override
        public void keyTyped(KeyEvent e){

        }

        @Override
        public void keyPressed(KeyEvent e){
        	
        	int key = e.getKeyCode();
        	
            if(key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN){
            	initiateSearch(textField.getText());
                return;	
            }
            
            
        }

        @Override
        public void keyReleased(KeyEvent e){

        }
    }
    
}