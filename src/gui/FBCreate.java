package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import java.awt.CardLayout;
import javax.swing.border.LineBorder;

import guiModules.FBCreationModul;
import umfrage.Frage;
import user.Creator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class FBCreate extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField singleChoiceAnswerField;
	private int questionCount = 0;
	private int answerCount = 0;
	private int answerCount2 = 0;
	private String FBTitel = "";
	private String FBExpose = "";
	private JTextField answerFieldMulti;
	private ArrayList<Frage> fragenList = new ArrayList<Frage>();
	
	
	/**
	 * Launch the application.
	 */
	public static void mainRun() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FBCreate frame = new FBCreate();
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
	public FBCreate() {
		setTitle("QuestionMark");
		setBackground(Color.WHITE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Beschreibung", null, panel, null);
		
		
		JLabel lblTitel = new JLabel("Titel:");
		lblTitel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		textField.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(1, 1, 1, 1)));
		textField.setColumns(10);
		
		JLabel lblExpose = new JLabel("Expose:");
		lblExpose.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		border = BorderFactory.createLineBorder(Color.BLACK);
		textArea.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(1, 1, 1, 1)));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblExpose)
						.addComponent(lblTitel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
						.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTitel))
					.addGap(33)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblExpose)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(77, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel frage1Panel = new JPanel();
		frage1Panel.setBackground(Color.WHITE);
		
		
		tabbedPane.addTab("Frage " + (questionCount+1), null, frage1Panel, null);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBackground(Color.WHITE);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Ja/Nein", "Single-Choice", "Multiple-Choice"}));
		
		JLabel lblFragentyp = new JLabel("Fragentyp:");
		lblFragentyp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_frage1Panel = new GroupLayout(frage1Panel);
		gl_frage1Panel.setHorizontalGroup(
			gl_frage1Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_frage1Panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_frage1Panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_frage1Panel.createSequentialGroup()
							.addComponent(lblFragentyp)
							.addGap(18)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_frage1Panel.setVerticalGroup(
			gl_frage1Panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_frage1Panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_frage1Panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFragentyp)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 354, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_3.setLayout(new CardLayout(0, 0));
		
		JPanel jaNeinPanel = new JPanel();
		jaNeinPanel.setBackground(Color.LIGHT_GRAY);
		panel_3.add(jaNeinPanel, "janein");
		
		JLabel lblTitel_1 = new JLabel("Titel:");
		lblTitel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JTextArea jaNeinTitle = new JTextArea();
		jaNeinTitle.setLineWrap(true);
		jaNeinTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		border = BorderFactory.createLineBorder(Color.BLACK);
		jaNeinTitle.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(1, 1, 1, 1)));
		
		
		
		JLabel lblAntwortmglichkeiten = new JLabel("Antwortm\u00F6glichkeiten:");
		lblAntwortmglichkeiten.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblJanein = new JLabel("Ja/Nein");
		lblJanein.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		GroupLayout gl_jaNeinPanel = new GroupLayout(jaNeinPanel);
		gl_jaNeinPanel.setHorizontalGroup(
			gl_jaNeinPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jaNeinPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jaNeinPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jaNeinPanel.createSequentialGroup()
							.addComponent(lblTitel_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(jaNeinTitle, GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE))
						.addGroup(gl_jaNeinPanel.createSequentialGroup()
							.addComponent(lblAntwortmglichkeiten)
							.addGap(18)
							.addComponent(lblJanein)))
					.addContainerGap())
		);
		gl_jaNeinPanel.setVerticalGroup(
			gl_jaNeinPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jaNeinPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jaNeinPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTitel_1)
						.addComponent(jaNeinTitle, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_jaNeinPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAntwortmglichkeiten)
						.addComponent(lblJanein))
					.addContainerGap(125, Short.MAX_VALUE))
		);
		DefaultListModel<String> model = new DefaultListModel<String>();
		
		JList<String> listAnswers = new JList<String>(model);
		listAnswers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		jaNeinPanel.setLayout(gl_jaNeinPanel);
		
		JPanel singleChoicePanel = new JPanel();
		singleChoicePanel.setBackground(Color.LIGHT_GRAY);
		panel_3.add(singleChoicePanel, "singlechoice");
		
		JLabel label = new JLabel("Titel:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JTextArea singleTitle = new JTextArea();
		singleTitle.setLineWrap(true);
		singleTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel label_1 = new JLabel("Antwortm\u00F6glichkeiten:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		singleChoiceAnswerField = new JTextField();
		singleChoiceAnswerField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		singleChoiceAnswerField.setColumns(10);
		
		JButton btnHinzufgen = new JButton("Hinzuf\u00FCgen");
		btnHinzufgen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//Antwortmöglichkeit Hinzufügen Single Choice
				if(!singleChoiceAnswerField.getText().equals("")){
					if(answerCount < 5){
						System.out.println("Added " + singleChoiceAnswerField.getText() + " to Answers at " + answerCount);
						model.addElement(singleChoiceAnswerField.getText());
						answerCount++;	
					}
					
				}else{
					
				}
			}
		});
		
		JButton btnEntfernen = new JButton("Entfernen");
		btnEntfernen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			//Handle remove button pressed
				int selected = listAnswers.getSelectedIndex();
				if(selected != -1){
					model.remove(selected);
					answerCount--;
				}
				
			
			}
		});
		
		
		GroupLayout gl_singleChoicePanel = new GroupLayout(singleChoicePanel);
		gl_singleChoicePanel.setHorizontalGroup(
			gl_singleChoicePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_singleChoicePanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_singleChoicePanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_singleChoicePanel.createSequentialGroup()
							.addGroup(gl_singleChoicePanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_singleChoicePanel.createSequentialGroup()
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(singleTitle, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_singleChoicePanel.createSequentialGroup()
									.addGroup(gl_singleChoicePanel.createParallelGroup(Alignment.LEADING)
										.addComponent(singleChoiceAnswerField, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
										.addComponent(listAnswers, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_singleChoicePanel.createParallelGroup(Alignment.LEADING)
										.addComponent(btnHinzufgen, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
										.addComponent(btnEntfernen, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))))
							.addGap(24))
						.addGroup(gl_singleChoicePanel.createSequentialGroup()
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(231, Short.MAX_VALUE))))
		);
		gl_singleChoicePanel.setVerticalGroup(
			gl_singleChoicePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_singleChoicePanel.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_singleChoicePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(singleTitle, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_singleChoicePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnHinzufgen)
						.addComponent(singleChoiceAnswerField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_singleChoicePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(listAnswers, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEntfernen))
					.addGap(95))
		);
		singleChoicePanel.setLayout(gl_singleChoicePanel);
		
		JPanel multipleChoicePanel = new JPanel();
		multipleChoicePanel.setBackground(Color.LIGHT_GRAY);
		panel_3.add(multipleChoicePanel, "multiplechoice");
		multipleChoicePanel.setLayout(null);
		
		JLabel label_2 = new JLabel("Titel:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_2.setBounds(15, 18, 47, 25);
		multipleChoicePanel.add(label_2);
		
		JTextArea multiTitle = new JTextArea();
		multiTitle.setLineWrap(true);
		multiTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		multiTitle.setBounds(68, 16, 355, 121);
		multipleChoicePanel.add(multiTitle);
		
		DefaultListModel model2 = new DefaultListModel();
		JButton button = new JButton("Hinzuf\u00FCgen");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(answerCount2 < 5){
					model2.addElement(answerFieldMulti.getText());
					answerCount2++;
				}
			
			}
		});
		button.setBounds(216, 180, 207, 29);
		multipleChoicePanel.add(button);
		JList list = new JList(model2);
		JButton button_1 = new JButton("Entfernen");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selected = list.getSelectedIndex();
				if(selected != -1){
					model2.remove(selected);
					answerCount2--;
				}
			
			}
		});
		button_1.setBounds(216, 227, 207, 29);
		multipleChoicePanel.add(button_1);
		
		answerFieldMulti = new JTextField();
		answerFieldMulti.setFont(new Font("Tahoma", Font.PLAIN, 20));
		answerFieldMulti.setColumns(10);
		answerFieldMulti.setBounds(15, 180, 192, 31);
		multipleChoicePanel.add(answerFieldMulti);
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(15, 227, 192, 109);
		multipleChoicePanel.add(list);
		
		JLabel label_3 = new JLabel("Antwortm\u00F6glichkeiten:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_3.setBounds(15, 146, 201, 25);
		multipleChoicePanel.add(label_3);
		frage1Panel.setLayout(gl_frage1Panel);
		
		
		
		//ComboBox Listener:
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Handle Card Switching JCardLayout
				if(comboBox.getSelectedIndex() == 0){
					//JA/NEIN
					CardLayout cl = (CardLayout)(panel_3.getLayout());
				    cl.show(panel_3, "janein");
				}else if(comboBox.getSelectedIndex() == 1){
					//Single-Choice
					CardLayout cl = (CardLayout)(panel_3.getLayout());
				    cl.show(panel_3, "singlechoice");
				}else if(comboBox.getSelectedIndex() == 2){
					//Multiple-Choice
					CardLayout cl = (CardLayout)(panel_3.getLayout());
				    cl.show(panel_3, "multiplechoice");
				}else{
					//Error
					
				}
				
			}
		});
		
		//Neue Frage
		JPanel frageAddPanel = new JPanel();
		frageAddPanel.setBackground(Color.WHITE);
		frageAddPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
		tabbedPane.addTab("+ Frage", null, frageAddPanel, null);
		JButton btnFragebogenAbspeichern = new JButton("Fragebogen abspeichern");
		btnFragebogenAbspeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnFragebogenAbspeichern.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//-> Daten übergeben; letztes Fragenpacket einsammeln
				//Handle grabbing info
				//-> Handle finish (if questionCount == 9)?
				//next question
				if(comboBox.getSelectedIndex() == 0){
					//JA/NEIN
					ArrayList<String> antworten = new ArrayList<String>();
					antworten.add("Ja");
					antworten.add("Nein");
					fragenList.add(new Frage(jaNeinTitle.getText(), 0, antworten));
				}else if(comboBox.getSelectedIndex() == 1){
					//Single-Choice
					if(!model.isEmpty()){
						ArrayList<String> antworten = new ArrayList<String>();
						for(int i = 0; i<model.size();i++){
							antworten.add((String) model.elementAt(i));
						}
						fragenList.add(new Frage(singleTitle.getText(), 1, antworten));	
					}else{
						System.err.println("Warning List supposedly empty");
					}
				}else if(comboBox.getSelectedIndex() == 2){
					//Multiple-Choice
					if(!model2.isEmpty()){
						ArrayList<String> antworten = new ArrayList<String>();
						for(int i = 0; i<model2.size();i++){
							antworten.add((String) model2.elementAt(i));
						}
						fragenList.add(new Frage(multiTitle.getText(), 2, antworten));	
						
					}else{
						System.err.println("Warning List supposedly empty#2");
					}
				}else{
					//Error
					
				}
			
			//Save data 
			FBTitel = textField.getText();
			FBExpose = textArea.getText();
			
			//Clear OldInput -> redirect to new panel
			comboBox.setSelectedIndex(0);
			jaNeinTitle.setText("");
			singleTitle.setText("");
			multiTitle.setText("");
			model.clear();
			singleChoiceAnswerField.setText("");
			model2.clear();
			answerFieldMulti.setText("");
			
			//Handle transfer
			
			System.err.println(FBCreationModul.createFB((Creator) Menu.getUser(), FBTitel, FBExpose, fragenList));
			System.err.println(fragenList);
			//FBCreationModul.createFB(fbCreator, FBTitel, FBExpose, frageDaten)
				//-> frageDaten muss 3D sein (ist aktuell 2D)
			//If boolean = true;
			setVisible(false);
			Menu.launchMenu();
			}
		});
		JLabel lblFgenSieEine = new JLabel("F\u00FCgen Sie eine weitere Frage hinzu:");
		lblFgenSieEine.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JLabel lbl_count = new JLabel("*5*");
		JButton btnNeueFrage = new JButton("Neue Frage");
		btnNeueFrage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				answerCount = 0;
				answerCount2 = 0;
				//handle new Q
				if(questionCount<10){
					if(questionCount == 8){
						btnNeueFrage.setEnabled(false);
						//btnFragebogenAbspeichern.setEnabled(true);
					}
				
				
				//Handle grabbing info
				//-> Handle finish (if questionCount == 9)?
				//next question
				if(comboBox.getSelectedIndex() == 0){
					//JA/NEIN
					ArrayList<String> antworten = new ArrayList<String>();
					antworten.add("Ja");
					antworten.add("Nein");
					fragenList.add(new Frage(jaNeinTitle.getText(), 0, antworten));
				}else if(comboBox.getSelectedIndex() == 1){
					//Single-Choice
					if(!model.isEmpty()){
						ArrayList<String> antworten = new ArrayList<String>();
						for(int i = 0; i<model.size();i++){
							antworten.add((String) model.elementAt(i));
						}
					fragenList.add(new Frage(singleTitle.getText(), 1, antworten));	
					
					}else{
						System.err.println("Warning List supposedly empty");
					}
				}else if(comboBox.getSelectedIndex() == 2){
					//Multiple-Choice
					if(!model2.isEmpty()){
						ArrayList<String> antworten = new ArrayList<String>();
						for(int i = 0; i<model2.size();i++){
							antworten.add((String) model2.elementAt(i));
						}
						fragenList.add(new Frage(multiTitle.getText(), 2, antworten));	
						
					}else{
						System.err.println("Warning List supposedly empty#2");
					}
				}else{
					//Error
					
				}
				
			//Save data 
			//Clear OldInput -> redirect to new panel
			comboBox.setSelectedIndex(0);
			jaNeinTitle.setText("");
			singleTitle.setText("");
			multiTitle.setText("");
			model.clear();
			singleChoiceAnswerField.setText("");
			model2.clear();
			answerFieldMulti.setText("");
			//Handle transfer
			
			questionCount++;
			
			lbl_count.setText("" + (questionCount + 1));
			tabbedPane.setTitleAt(1, "Frage " + (questionCount + 1));
			//frage1Panel.
			}}
		});
		btnNeueFrage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		lbl_count.setText("" + (questionCount +1));
		lbl_count.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblFragen = new JLabel("/ 10 Fragen");
		lblFragen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFragebogenAbspeichern.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_frageAddPanel = new GroupLayout(frageAddPanel);
		gl_frageAddPanel.setHorizontalGroup(
			gl_frageAddPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_frageAddPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_frageAddPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnFragebogenAbspeichern, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblFgenSieEine, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_frageAddPanel.createSequentialGroup()
							.addComponent(btnNeueFrage)
							.addGap(34)
							.addComponent(lbl_count)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblFragen)))
					.addContainerGap(144, Short.MAX_VALUE))
		);
		gl_frageAddPanel.setVerticalGroup(
			gl_frageAddPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_frageAddPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFgenSieEine)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_frageAddPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNeueFrage)
						.addComponent(lbl_count)
						.addComponent(lblFragen))
					.addGap(18)
					.addComponent(btnFragebogenAbspeichern)
					.addContainerGap(286, Short.MAX_VALUE))
		);
		frageAddPanel.setLayout(gl_frageAddPanel);
	
	}
}
