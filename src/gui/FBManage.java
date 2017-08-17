package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import guiModules.FBDistributionModul;
import guiModules.FBLoaderModul;
import guiModules.FBRemovalModul;
import umfrage.Fragebogen;
import user.Creator;

import javax.swing.JTabbedPane;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JCheckBox;

public class FBManage extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void mainRun() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FBManage frame = new FBManage();
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
	public FBManage() {
		setTitle("QuestionMark");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("List", null, panel, null);
		
		DefaultListModel model = new DefaultListModel();
		JList list = new JList(model);
		list.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		border = BorderFactory.createLineBorder(Color.BLACK);
		list.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		//Display All FBS
		Creator currentUser = (Creator) Menu.getUser();
		ArrayList<Fragebogen> fbList = FBLoaderModul.loadFB(currentUser);
		Iterator<Fragebogen> fbListIt = fbList.iterator();
		Fragebogen currentFB;  
		while(fbListIt.hasNext()){
			currentFB = fbListIt.next();
			String titel = currentFB.getTitel();
			model.addElement(titel);
		}
		
		
		
		Border blackline = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder title;
		title = BorderFactory.createTitledBorder(blackline, "Verteilung");
		title.setTitleJustification(TitledBorder.CENTER);
		
		//btnVerteilen.setBorder(title);
		
		JButton btnAuswerten = new JButton("Auswerten");
		btnAuswerten.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAuswerten.setToolTipText("Auswertung nur verf\u00FCgbar wenn mind. ein Benutzer den Fragebogen ausgef\u00FCllt hat");
		btnAuswerten.setEnabled(false);
		
		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAbbrechen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//Close FBManage -> Return to Menu
				Menu.launchMenu();
				setVisible(false);
			}
		});
		
		JPanel verteilenPanel = new JPanel();
		verteilenPanel.setBorder(title);
		
		JButton btnLschen = new JButton("L\u00F6schen");
		btnLschen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(list.getSelectedIndex() != -1){
					int choice = list.getSelectedIndex();
					Fragebogen selected = fbList.get(choice);
					FBRemovalModul.removeFB((Creator) Menu.getUser(), selected);
					model.remove(choice);
				}
			
			}
		});
		btnLschen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnDebugg = new JButton("Debugg");
		btnDebugg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 316, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAbbrechen, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnAuswerten, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(verteilenPanel, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLschen, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
						.addComponent(btnDebugg))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(list, GroupLayout.PREFERRED_SIZE, 404, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(verteilenPanel, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAuswerten)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnLschen)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDebugg)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnAbbrechen)))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		
		JCheckBox chckbxKursA = new JCheckBox("Kurs A");
		chckbxKursA.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JCheckBox chckbxKursB = new JCheckBox("Kurs B");
		chckbxKursB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnVerteilen = new JButton("Verteilen");
		btnVerteilen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//Distribute FB selected if Kurs chosen
				if((chckbxKursA.isSelected() || chckbxKursB.isSelected()) && list.getSelectedIndex() != -1){
					//Security check
					if(chckbxKursA.isSelected()){
						int choice = list.getSelectedIndex();
						Fragebogen selected = fbList.get(choice);
						FBDistributionModul.distributeFB(Menu.getSystem(), true, selected, (Creator) Menu.getUser());
					}
					if(chckbxKursB.isSelected()){
						int choice = list.getSelectedIndex();
						Fragebogen selected = fbList.get(choice);
						FBDistributionModul.distributeFB(Menu.getSystem(), false, selected, (Creator) Menu.getUser());
					}
					
				}else{
					int choice = list.getSelectedIndex();
					Fragebogen selected = fbList.get(choice);
					System.out.println(selected.getFragen());
				}
				
				
			}
		});
		btnVerteilen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_verteilenPanel = new GroupLayout(verteilenPanel);
		gl_verteilenPanel.setHorizontalGroup(
			gl_verteilenPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_verteilenPanel.createSequentialGroup()
					.addGroup(gl_verteilenPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_verteilenPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_verteilenPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(chckbxKursA)
								.addComponent(chckbxKursB)))
						.addComponent(btnVerteilen, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 111, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_verteilenPanel.setVerticalGroup(
			gl_verteilenPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_verteilenPanel.createSequentialGroup()
					.addComponent(chckbxKursA)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxKursB)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnVerteilen, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
		);
		verteilenPanel.setLayout(gl_verteilenPanel);
		panel.setLayout(gl_panel);
	}
}
