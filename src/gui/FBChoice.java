package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import guiModules.FBSLoaderModul;
import umfrage.FragebogenWithAntwortmoeglichkeit;
import user.Creator;
import user.Solver;
import user.User;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Font;
import javax.swing.JLabel;

public class FBChoice extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void mainRun() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FBChoice frame = new FBChoice();
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
	public FBChoice() {
		setTitle("QuestionMark");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		DefaultListModel model = new DefaultListModel();
		JList list = new JList(model);
		list.removeAll();
		list.setFont(new Font("Tahoma", Font.PLAIN, 20));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		User currentUser = Menu.getUser();
		if(!Menu.userIsCreator()){
			ArrayList<FragebogenWithAntwortmoeglichkeit> fbList = FBSLoaderModul.loadFBS((Solver) currentUser);
			//Iterate through list and add to Model from JLIST - List
			Iterator<FragebogenWithAntwortmoeglichkeit> fbListIt = fbList.iterator();
			FragebogenWithAntwortmoeglichkeit currentFB;
			while(fbListIt.hasNext()){
				currentFB = fbListIt.next();
				String titel = currentFB.getTitel();
				model.addElement(titel);
			}
		}
		//FBSLoaderModul.loadFBS(requestingUser);
		//Can Creator answer FBS?
		
		
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		border = BorderFactory.createLineBorder(Color.BLACK);
		list.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		JButton btnChoose = new JButton("Ausw\u00E4hlen");
		btnChoose.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnChoose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//IF FB Valid -> Open FB for answers
				int choice = list.getSelectedIndex();
				ArrayList<FragebogenWithAntwortmoeglichkeit> fbList = FBSLoaderModul.loadFBS((Solver) currentUser);
				FragebogenWithAntwortmoeglichkeit choosenFB = fbList.get(choice);
				FBAnswer.answerFB(choosenFB);
				setVisible(false);
				
			}
		});
		
		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAbbrechen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			//Close FBChoice -> return to Menu
				Menu.launchMenu();
				setVisible(false);
			}
		});
		
		JLabel lblId = new JLabel("ID: ");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel label = new JLabel("<ID>");
		label.setForeground(Color.BLUE);
		label.setText(currentUser.getVorname());
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnAbbrechen, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
							.addComponent(btnChoose, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblId)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label)
							.addGap(27))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
					.addComponent(list, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(btnChoose)
						.addGap(14)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblId)
							.addComponent(label))
						.addPreferredGap(ComponentPlacement.RELATED, 318, Short.MAX_VALUE)
						.addComponent(btnAbbrechen)
						.addContainerGap()))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
