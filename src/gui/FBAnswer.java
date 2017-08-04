package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Color;

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

public class FBAnswer extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		
		JLabel label = new JLabel("Expose:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel label_1 = new JLabel("Titel:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblTitle = new JLabel("New label");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		JLabel lblExpose = new JLabel("New label");
		lblExpose.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_introPanel = new GroupLayout(introPanel);
		gl_introPanel.setHorizontalGroup(
			gl_introPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_introPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_introPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(label)
						.addComponent(label_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_introPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTitle)
						.addComponent(lblExpose))
					.addContainerGap(294, Short.MAX_VALUE))
		);
		gl_introPanel.setVerticalGroup(
			gl_introPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_introPanel.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_introPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(lblTitle))
					.addGap(33)
					.addGroup(gl_introPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(lblExpose))
					.addContainerGap(77, Short.MAX_VALUE))
		);
		introPanel.setLayout(gl_introPanel);
		
		JPanel currentQuestion = new JPanel();
		tabbedPane.addTab("Aktuelle Frage", null, currentQuestion, null);
		currentQuestion.setLayout(new CardLayout(0, 0));
		
		JPanel jaNeinPanel = new JPanel();
		currentQuestion.add(jaNeinPanel, "name_2156015829933633");
		
		JLabel lblFrage = new JLabel("Frage:");
		
		JLabel lblfrage = new JLabel("*Frage*");
		
		JLabel lblAntwort = new JLabel("Antwort:");
		
		JRadioButton rdbtnJa = new JRadioButton("Ja");
		
		JRadioButton rdbtnNein = new JRadioButton("Nein");
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNein);
		group.add(rdbtnJa);
		GroupLayout gl_jaNeinPanel = new GroupLayout(jaNeinPanel);
		gl_jaNeinPanel.setHorizontalGroup(
			gl_jaNeinPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jaNeinPanel.createSequentialGroup()
					.addGroup(gl_jaNeinPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jaNeinPanel.createSequentialGroup()
							.addGap(15)
							.addComponent(lblFrage, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
							.addGap(15)
							.addComponent(lblfrage, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jaNeinPanel.createSequentialGroup()
							.addGap(15)
							.addComponent(lblAntwort, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addComponent(rdbtnJa, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jaNeinPanel.createSequentialGroup()
							.addGap(93)
							.addComponent(rdbtnNein, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)))
					.addGap(31))
		);
		gl_jaNeinPanel.setVerticalGroup(
			gl_jaNeinPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jaNeinPanel.createSequentialGroup()
					.addGap(16)
					.addGroup(gl_jaNeinPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFrage)
						.addComponent(lblfrage, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jaNeinPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jaNeinPanel.createSequentialGroup()
							.addGap(4)
							.addComponent(lblAntwort))
						.addComponent(rdbtnJa))
					.addGap(8)
					.addComponent(rdbtnNein))
		);
		jaNeinPanel.setLayout(gl_jaNeinPanel);
		
		JPanel singlePanel = new JPanel();
		currentQuestion.add(singlePanel, "name_2156078322721197");
		
		JLabel label_2 = new JLabel("Frage:");
		
		JLabel label_3 = new JLabel("*Frage*");
		
		JLabel lblAntwort_1 = new JLabel("Antwort:");
		
		JComboBox comboBox = new JComboBox();
		GroupLayout gl_singlePanel = new GroupLayout(singlePanel);
		gl_singlePanel.setHorizontalGroup(
			gl_singlePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_singlePanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_singlePanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_singlePanel.createSequentialGroup()
							.addComponent(label_2)
							.addGap(15)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_singlePanel.createSequentialGroup()
							.addComponent(lblAntwort_1)
							.addGap(18)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(45, Short.MAX_VALUE))
		);
		gl_singlePanel.setVerticalGroup(
			gl_singlePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_singlePanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_singlePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_singlePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAntwort_1)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(78, Short.MAX_VALUE))
		);
		singlePanel.setLayout(gl_singlePanel);
		
		JPanel multiPanel = new JPanel();
		currentQuestion.add(multiPanel, "name_2156081212303551");
		
		JLabel label_4 = new JLabel("Frage:");
		
		JLabel label_5 = new JLabel("*Frage*");
		GroupLayout gl_multiPanel = new GroupLayout(multiPanel);
		gl_multiPanel.setHorizontalGroup(
			gl_multiPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_multiPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_4)
					.addGap(15)
					.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE))
		);
		gl_multiPanel.setVerticalGroup(
			gl_multiPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_multiPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_multiPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_4)
						.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(185, Short.MAX_VALUE))
		);
		multiPanel.setLayout(gl_multiPanel);
	}
}
