package frames;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;


@SuppressWarnings("serial")
public class ManualForm extends JFrame {
	
	/**
	 * 
	 */
	
	private JPanel contentPane;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManualForm readme = new ManualForm();
					readme.setVisible(true);
					readme.setResizable(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	
	
	public ManualForm() {
		setTitle("GAME CONTROLS");
		setSize(545, 530);
		setForeground(Color.WHITE);
		setBackground(Color.DARK_GRAY);
		setPreferredSize(new Dimension(950, 381));
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();

		JTextPane readme = new JTextPane();
		
		readme.setBackground(SystemColor.controlHighlight);
		readme.setFont(new Font("Arial", Font.BOLD | Font.PLAIN, 18));
		appendToPane(readme, "============= HOW TO PLAY ============="
				+ "\n"
				+ "\n"
				+ "\n"
				+"                MANUAL: "
				+ "\n"
				+ "\n"
				+ "Use the ARROWS to navigate your ship. "
				+ "\n"
				+ "Use 'SPACE' and 'CTRL' to fire, "
				+ "\n"
				+ "depends on which weapon is unlocked."
				+ "\n"
				+ "Use 'S' to mute the background music "
				+ "\n"
				+ "and 'A' to enable it."
				+ "\n"
				+ "Use 'P' for pausing the game."
				+ "\n"
				+ "Use 'R' for restart the game, even if a game is running."
				+ "\n"
				+ "Use 'E' for restart/resume (if not in a game), or switch to E A S Y."
				+ "\n"
				+ "Use 'M' for restart/resume (if not in a game), or switch to M E D I U M."
				+ "\n"
				+ "Use 'H' for restart/resume (if not in a game), or switch to H A R D."
				+ "\n"
				+ "Use 'G' to turn ON or OFF G O D M O D E."
				+ "\n"
				+ "Use 'C' to invoke the game C O N S O L E."
				+ "\n"
				+ "Use '2' and '3' to switch the level."
				+ "\n"
				+ "\n"
				+ "NB: Switching to a previous level is not allowed!", Color.MAGENTA);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)));
		readme.setFont(readme.getFont().deriveFont(18f));
        readme.setBackground(Color.DARK_GRAY);
		readme.setForeground(Color.WHITE);
		readme.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		readme.setEditable(false);
		scrollPane.setViewportView(readme);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void appendToPane(JTextPane tp, String msg, Color c)
    {
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

        int len = tp.getDocument().getLength();
        tp.setCaretPosition(len);
        tp.setCharacterAttributes(aset, false);
        tp.replaceSelection(msg);
    }

	

}