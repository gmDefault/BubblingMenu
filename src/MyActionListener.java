import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyActionListener implements ActionListener {
	
	private String s;
	
	public MyActionListener(String s) {
		this.s = s;
	}
	// Met à jour le bouton cliqué
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Main.textArea.setText(s);
	} 

}
