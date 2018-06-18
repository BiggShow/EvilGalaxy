package frames;

import java.awt.Color;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.SwingUtilities;

public class BestConsole extends Console {


	private static final long serialVersionUID = 1L;
	Vector<String> matches = new Vector<>();
	JList<Object> list = new JList<>();
	

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BestConsole();
                Main ex = new Main();
                ex.setVisible(true);
            }
        });
    }
	
    public BestConsole() {

        JFrame frame = new JFrame();
        frame.setTitle("Game Console");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane.add(textField);
        frame.add(contentPane);
        frame.pack();
        frame.setVisible(true);
        //frame.setSize(600, 400);
        //frame.setBounds(100, 30, 650, 381);

        //JTextField f = new JTextField(10);

        new AutoSuggestor(textField, frame, null, Color.WHITE.brighter(), Color.BLUE, Color.RED, 0.75f) {
            @Override
            boolean wordTyped(String typedWord) {

                setDictionary(textField.getText());
                return super.wordTyped(typedWord);//now call super to check for any matches against newest dictionary
            }
        };

    }

}