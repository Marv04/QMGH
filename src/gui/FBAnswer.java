package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FBAnswer extends JFrame {

	private JPanel contentPane;
	private int currentQ = 0;
	/**
	 * Launch the application.
	 */
	public static void mainRun() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FBAnswer frame = new FBAnswer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FBAnswer() {
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		setTitle("QuestionMark");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.NORTH);
		
		JPanel introPanel = new JPanel();
		introPanel.setBackground(Color.WHITE);
		tabbedPane.addTab("Beschreibung", null, introPanel, null);
		
		JLabel lbl_1 = new JLabel("Expose:");
		lbl_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel label_1 = new JLabel("Titel:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblTitle = new JLabel("New label");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		//Title_Set
		lblTitle.setText("Autoumfrage");
		border = BorderFactory.createLineBorder(Color.BLACK);
		lblTitle.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		JLabel lblExpose = new JLabel("New label");
		lblExpose.setVerticalAlignment(SwingConstants.TOP);
		lblExpose.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		//Expose_Set
		lblExpose.setText("<html>" + "Wir wollen alles wissen was Sie uns zu dem Thema sagen können, danke!" + "</html>");
		border = BorderFactory.createLineBorder(Color.BLACK);
		lblExpose.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(Color.RED);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));

		
		//Wrapped by HTML usage -> Dokument explanation
		
		
		GroupLayout gl_introPanel = new GroupLayout(introPanel);
		gl_introPanel.setHorizontalGroup(
			gl_introPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_introPanel.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_introPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_1)
						.addComponent(lbl_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_introPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_introPanel.createSequentialGroup()
							.addComponent(lblTitle)
							.addGap(18)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblExpose, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_introPanel.setVerticalGroup(
			gl_introPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_introPanel.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_introPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(lblTitle)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_introPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl_1)
						.addComponent(lblExpose, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(136, Short.MAX_VALUE))
		);
		introPanel.setLayout(gl_introPanel);
		
		JPanel currentQuestion = new JPanel();
		
		
		tabbedPane.addTab("Frage " + (currentQ + 1), null, currentQuestion, null);
		currentQuestion.setLayout(new CardLayout(0, 0));
		
		JPanel jaNeinPanel = new JPanel();
		currentQuestion.add(jaNeinPanel, "jaNeinChoice");
		
		JLabel lbl_3 = new JLabel("Frage:");
		lbl_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblFrage = new JLabel("<html>" + "Wie viele Autos?Wie viele Autos?Wie viele Autos?Wie viele Autos?Wie viele Autos?Wie viele Autos?" + "</html>");
		lblFrage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFrage.setVerticalAlignment(SwingConstants.TOP);
		border = BorderFactory.createLineBorder(Color.BLACK);
		lblFrage.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		
		JLabel lblAntwort = new JLabel("Antwort:");
		lblAntwort.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JRadioButton rdbtnJa = new JRadioButton("Ja");
		rdbtnJa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JRadioButton rdbtnNein = new JRadioButton("Nein");
		rdbtnNein.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNein);
		group.add(rdbtnJa);
		
		JButton btnNext = new JButton("N\u00E4chste Frage");
		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//next question
				if(rdbtnJa.isSelected()){
					//-> Boolean answer = true
				}else if (rdbtnNein.isSelected()){
					//-> Boolean answer = false
				}else{
					//No answer selected
				}
				
				
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_jaNeinPanel = new GroupLayout(jaNeinPanel);
		gl_jaNeinPanel.setHorizontalGroup(
			gl_jaNeinPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jaNeinPanel.createSequentialGroup()
					.addGroup(gl_jaNeinPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jaNeinPanel.createSequentialGroup()
							.addGap(15)
							.addGroup(gl_jaNeinPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_jaNeinPanel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblAntwort, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
									.addGap(47)
									.addGroup(gl_jaNeinPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(rdbtnNein, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
										.addComponent(rdbtnJa, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_jaNeinPanel.createSequentialGroup()
									.addComponent(lbl_3, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
									.addGap(15)
									.addComponent(lblFrage, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_jaNeinPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(31, Short.MAX_VALUE))
		);
		gl_jaNeinPanel.setVerticalGroup(
			gl_jaNeinPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jaNeinPanel.createSequentialGroup()
					.addGap(16)
					.addGroup(gl_jaNeinPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl_3)
						.addComponent(lblFrage, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_jaNeinPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAntwort)
						.addComponent(rdbtnJa))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnNein)
					.addGap(100)
					.addComponent(btnNext)
					.addGap(176))
		);
		jaNeinPanel.setLayout(gl_jaNeinPanel);
		
		JPanel singlePanel = new JPanel();
		currentQuestion.add(singlePanel, "singleChoice");
		
		JLabel label_2 = new JLabel("Frage:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblFrageSingle = new JLabel("*Frage*");
		lblFrageSingle.setVerticalAlignment(SwingConstants.TOP);
		lblFrageSingle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		border = BorderFactory.createLineBorder(Color.BLACK);
		lblFrageSingle.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		JLabel lblAntwort_1 = new JLabel("Antwort:");
		lblAntwort_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JComboBox comboBox = new JComboBox();
		
		JButton btnNext2 = new JButton("N\u00E4chste Frage");
		btnNext2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//Next question
				//Get selected index, -> int
			}
		});
		btnNext2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_singlePanel = new GroupLayout(singlePanel);
		gl_singlePanel.setHorizontalGroup(
			gl_singlePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_singlePanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_singlePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNext2, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_singlePanel.createSequentialGroup()
							.addGroup(gl_singlePanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAntwort_1)
								.addComponent(label_2))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_singlePanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblFrageSingle, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE))))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		gl_singlePanel.setVerticalGroup(
			gl_singlePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_singlePanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_singlePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2)
						.addComponent(lblFrageSingle, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_singlePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAntwort_1)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(73)
					.addComponent(btnNext2)
					.addContainerGap(176, Short.MAX_VALUE))
		);
		singlePanel.setLayout(gl_singlePanel);
		
		JPanel multiPanel = new JPanel();
		currentQuestion.add(multiPanel, "multiChoice");
		
		JLabel label_4 = new JLabel("Frage:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblFrageMulti = new JLabel("*Frage*");
		lblFrageMulti.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFrageMulti.setVerticalAlignment(SwingConstants.TOP);
		border = BorderFactory.createLineBorder(Color.BLACK);
		lblFrageMulti.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		JLabel lblAntwort_2 = new JLabel("Antwort:");
		lblAntwort_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JCheckBox multiAnswer1 = new JCheckBox("multiAnswer1");
		multiAnswer1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JCheckBox multiAnswer2 = new JCheckBox("multiAnswer2");
		multiAnswer2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JCheckBox multiAnswer3 = new JCheckBox("multiAnswer3");
		multiAnswer3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JCheckBox multiAnswer4 = new JCheckBox("multiAnswer4");
		multiAnswer4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JCheckBox multiAnswer5 = new JCheckBox("multiAnswer5");
		multiAnswer5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		

		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//---Testzwecke
				if(comboBox_1.getSelectedIndex() == 0){
					//JA/NEIN
					CardLayout cl = (CardLayout)(currentQuestion.getLayout());
				    cl.show(currentQuestion, "jaNeinChoice");
				   
				}else if(comboBox_1.getSelectedIndex() == 1){
					//Single-Choice
					CardLayout cl = (CardLayout)(currentQuestion.getLayout());
				    cl.show(currentQuestion, "singleChoice");
				    
				}else if(comboBox_1.getSelectedIndex() == 2){
					//Multiple-Choice
					CardLayout cl = (CardLayout)(currentQuestion.getLayout());
				    cl.show(currentQuestion, "multiChoice");
				}else{
					//Error
					
				}
				//----ENDE
				
			}
		});
		
		JButton btnNext3 = new JButton("N\u00E4chste Frage");
		btnNext3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			//Next question
			//Get selected indexes -> int? - 01234	
				
			
			}
		});
		btnNext3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		
		
		GroupLayout gl_multiPanel = new GroupLayout(multiPanel);
		gl_multiPanel.setHorizontalGroup(
			gl_multiPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_multiPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_multiPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNext3, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_multiPanel.createSequentialGroup()
							.addComponent(label_4)
							.addGap(15)
							.addComponent(lblFrageMulti, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_multiPanel.createSequentialGroup()
							.addComponent(lblAntwort_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_multiPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(multiAnswer1)
								.addComponent(multiAnswer2)
								.addComponent(multiAnswer3)
								.addComponent(multiAnswer4)
								.addComponent(multiAnswer5))))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		gl_multiPanel.setVerticalGroup(
			gl_multiPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_multiPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_multiPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFrageMulti, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_multiPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAntwort_2)
						.addComponent(multiAnswer1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(multiAnswer2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(multiAnswer3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(multiAnswer4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(multiAnswer5)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNext3)
					.addContainerGap(171, Short.MAX_VALUE))
		);
		multiPanel.setLayout(gl_multiPanel);
	}
}
