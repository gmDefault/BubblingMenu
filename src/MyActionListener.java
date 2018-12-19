import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyActionListener implements ActionListener {
	
	private String s;
	
	public MyActionListener(String s) {
		this.s = s;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Main.textArea.setText(s);
	} 

}
