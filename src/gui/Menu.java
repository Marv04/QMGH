package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.border.LineBorder;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Window.Type;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void launchMenu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setResizable(false);
		setTitle("       QuestionMark");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblMainmenu = new JLabel("Mainmenu");
		lblMainmenu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblMainmenu);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblUserid = new JLabel("UserID:");
		lblUserid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblUserid = new GridBagConstraints();
		gbc_lblUserid.anchor = GridBagConstraints.EAST;
		gbc_lblUserid.insets = new Insets(0, 0, 5, 5);
		gbc_lblUserid.gridx = 0;
		gbc_lblUserid.gridy = 0;
		panel_1.add(lblUserid, gbc_lblUserid);
		
		JLabel lblNewLabel = new JLabel("<ID>");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel label_1 = new JLabel("1.");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 4;
		panel_1.add(label_1, gbc_label_1);
		
		JButton btnFragebogenErstellen = new JButton("Fragebogen erstellen");
		btnFragebogenErstellen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_btnFragebogenErstellen = new GridBagConstraints();
		gbc_btnFragebogenErstellen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnFragebogenErstellen.insets = new Insets(0, 0, 5, 0);
		gbc_btnFragebogenErstellen.gridx = 2;
		gbc_btnFragebogenErstellen.gridy = 4;
		panel_1.add(btnFragebogenErstellen, gbc_btnFragebogenErstellen);
		
		JLabel label_2 = new JLabel("2.");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 5;
		panel_1.add(label_2, gbc_label_2);
		
		JButton btnFragebogenVerwalten = new JButton("Fragebogen verwalten");
		btnFragebogenVerwalten.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_btnFragebogenVerwalten = new GridBagConstraints();
		gbc_btnFragebogenVerwalten.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnFragebogenVerwalten.insets = new Insets(0, 0, 5, 0);
		gbc_btnFragebogenVerwalten.gridx = 2;
		gbc_btnFragebogenVerwalten.gridy = 5;
		panel_1.add(btnFragebogenVerwalten, gbc_btnFragebogenVerwalten);
		
		JLabel label_3 = new JLabel("3.");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 1;
		gbc_label_3.gridy = 6;
		panel_1.add(label_3, gbc_label_3);
		
		JButton btnFragebogenAusfllen = new JButton("Fragebogen ausf\u00FCllen");
		btnFragebogenAusfllen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_btnFragebogenAusfllen = new GridBagConstraints();
		gbc_btnFragebogenAusfllen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnFragebogenAusfllen.insets = new Insets(0, 0, 5, 0);
		gbc_btnFragebogenAusfllen.gridx = 2;
		gbc_btnFragebogenAusfllen.gridy = 6;
		panel_1.add(btnFragebogenAusfllen, gbc_btnFragebogenAusfllen);
		
		JLabel label_4 = new JLabel("4.");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 0, 5);
		gbc_label_4.gridx = 1;
		gbc_label_4.gridy = 7;
		panel_1.add(label_4, gbc_label_4);
		
		JButton btnProgrammBeenden = new JButton("Programm beenden");
		btnProgrammBeenden.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//Close Programm
				System.exit(0);
			}
		});
		btnProgrammBeenden.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_btnProgrammBeenden = new GridBagConstraints();
		gbc_btnProgrammBeenden.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnProgrammBeenden.gridx = 2;
		gbc_btnProgrammBeenden.gridy = 7;
		panel_1.add(btnProgrammBeenden, gbc_btnProgrammBeenden);
	}

}
