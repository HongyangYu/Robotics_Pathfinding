package Code_a_star;

//import java.awt.*;
import javax.swing.*;

public class Control_Panel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final int TEXT_LEN = 5; 
	
	public Control_Panel(){
		JLabel start_lb = new JLabel("START");
		
		JPanel start_input_panel = new JPanel();
		JLabel sx_lb = new JLabel("x:");
		JLabel sy_lb = new JLabel("y:");
		JTextField sx_text = new JTextField(TEXT_LEN); //input start x coordinate
		JTextField sy_text = new JTextField(TEXT_LEN); //input start y coordinate
		start_input_panel.add(sx_lb);
		start_input_panel.add(sx_text);
		start_input_panel.add(sy_lb);
		start_input_panel.add(sy_text);
//		start_input_panel.setLocation(1500, 100);
		
		JLabel target_lb = new JLabel("TARGET");
		JPanel target_input_panel = new JPanel();
		JLabel tx_lb = new JLabel("x:");
		JLabel ty_lb = new JLabel("y:");
		JTextField tx_text = new JTextField(TEXT_LEN); //input target x coordinate
		JTextField ty_text = new JTextField(TEXT_LEN); //input target y coordinate
		target_input_panel.add(tx_lb);
		target_input_panel.add(tx_text);
		target_input_panel.add(ty_lb);
		target_input_panel.add(ty_text);

//		target_input_panel.setLocation(1500, 200);

		JPanel button_panel = new JPanel();
		JButton start_bt = new JButton("Start");
		JButton reset_bt = new JButton("Reset");
		button_panel.add(start_bt);
		button_panel.add(reset_bt);

//		button_panel.setLocation(1500, 300);

//		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		add(start_lb);
		add(start_input_panel);
		add(target_lb);
		add(target_input_panel);
		add(button_panel);

		
		
	}

}
