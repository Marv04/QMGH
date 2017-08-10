package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MainWindow {
	
	/**
	 * PRIVATE ADMIN ACCOUNT 
	 * ZU VORSTELLUNGSZWECKEN
	 * ACC: Admin
	 * PSW: Admin123
	 */
	
	private String adminName = "Admin";
	private String adminPsw  = "Admin123";
	
	/**
	 * Generierter Code von WindowBuilder
	 * |
	 * V
	 */
	
	
	private JFrame frmQuestionmark;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmQuestionmark.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmQuestionmark = new JFrame();
		frmQuestionmark.setResizable(false);
		frmQuestionmark.setTitle("QuestionMark");
		frmQuestionmark.setBounds(100, 100, 500, 300);
		frmQuestionmark.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{478, 0};
		gridBagLayout.rowHeights = new int[]{37, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		frmQuestionmark.getContentPane().setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		frmQuestionmark.getContentPane().add(panel, gbc_panel);
		
		JLabel lblWillkommenBeiQuestionmark = new JLabel("Willkommen bei QuestionMark");
		lblWillkommenBeiQuestionmark.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblWillkommenBeiQuestionmark);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("CheckBox.background"));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		frmQuestionmark.getContentPane().add(panel_1, gbc_panel_1);
		
		JLabel lblUserid = new JLabel("UserID:");
		lblUserid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setColumns(15);
		
		JLabel lblPasswort = new JLabel("Passwort:");
		lblPasswort.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		passwordField = new JPasswordField();
		passwordField.setColumns(15);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnHelp = new JButton("Help");
		btnHelp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel label = new JLabel("");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnNewButton = new JButton("Login");
		
		//Händischer Code
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Handle Login Button pressed
				if(textField.getText().equals("")){
					//Name war korrekt
					//Char Array to String
					String psw = new String(passwordField.getPassword());
					if(psw.equals("")){
						//Psw war korrekt
						Menu.launchMenu();
						frmQuestionmark.setVisible(false); //Login Window verschwindet
						//SubstituteTreiber.mainRun(); //Vorstellungsmenü wird geöffnet
					}else{
						//Login PSW fehlerhaft
						label.setText("Login fehlerhaft!");
					}
				}else{
					//Login Benutzer fehlerhaft
					label.setText("Login fehlerhaft!");
				}
			}
		});
		
		/**
		 * Generierter Code von WindowBuilder
		 * |
		 * V
		 */
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(7)
							.addComponent(btnHelp)
							.addGap(12)
							.addComponent(btnNewButton))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblPasswort)
								.addComponent(lblUserid))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label)
									.addGap(92))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(341))
								.addComponent(passwordField, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(398))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblUserid)))
					.addGap(5)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPasswort))
					.addGap(5)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnHelp)
						.addComponent(btnNewButton)))
		);
		panel_1.setLayout(gl_panel_1);
		
		
	}

}
