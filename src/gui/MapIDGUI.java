package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class MapIDGUI {

	private JFrame frmMapIdFinder;
	private JLabel lblCharInfo;
	private JTextField textFieldMapID;
	private JTextField textFieldSeed;
	private JTextField textFieldNotes;
	private JButton btnShare;
	private JButton btnOpen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MapIDGUI window = new MapIDGUI();
					window.frmMapIdFinder.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MapIDGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		MapIDFinderActionListener actionListener = new MapIDFinderActionListener(this);
		
		frmMapIdFinder = new JFrame();
		frmMapIdFinder.setTitle("Map ID Finder");
		frmMapIdFinder.setResizable(false);
		frmMapIdFinder.setBounds(100, 100, 450, 224);
		frmMapIdFinder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMapIdFinder.getContentPane().setLayout(null);
		
		btnOpen = new JButton("Open");
		btnOpen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnOpen.setBounds(180, 10, 90, 25);
		btnOpen.addActionListener(actionListener);
		frmMapIdFinder.getContentPane().add(btnOpen);
		
		lblCharInfo = new JLabel("No character loaded");
		lblCharInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCharInfo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCharInfo.setBounds(10, 40, 424, 17);
		frmMapIdFinder.getContentPane().add(lblCharInfo);
		
		JLabel lblMapId = new JLabel("Map ID:");
		lblMapId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMapId.setBounds(10, 77, 48, 17);
		frmMapIdFinder.getContentPane().add(lblMapId);
		
		textFieldMapID = new JTextField();
		textFieldMapID.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldMapID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldMapID.setEditable(false);
		textFieldMapID.setBounds(68, 74, 157, 23);
		frmMapIdFinder.getContentPane().add(textFieldMapID);
		textFieldMapID.setColumns(10);
		
		JLabel lblSeed = new JLabel("Seed:");
		lblSeed.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSeed.setBounds(235, 77, 35, 17);
		frmMapIdFinder.getContentPane().add(lblSeed);
		
		textFieldSeed = new JTextField();
		textFieldSeed.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSeed.setEditable(false);
		textFieldSeed.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldSeed.setBounds(280, 74, 154, 23);
		frmMapIdFinder.getContentPane().add(textFieldSeed);
		textFieldSeed.setColumns(10);
		
		JLabel lblNotes = new JLabel("Notes:");
		lblNotes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNotes.setBounds(10, 113, 40, 17);
		frmMapIdFinder.getContentPane().add(lblNotes);
		
		textFieldNotes = new JTextField();
		textFieldNotes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldNotes.setBounds(60, 110, 374, 23);
		frmMapIdFinder.getContentPane().add(textFieldNotes);
		textFieldNotes.setColumns(10);
		
		btnShare = new JButton("Share");
		btnShare.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnShare.setBounds(359, 146, 75, 39);
		btnShare.addActionListener(actionListener);
		frmMapIdFinder.getContentPane().add(btnShare);
	}
	
	public String getCharInfo() {
		return this.lblCharInfo.getText();
	}
	
	public String getMapID() {
		return this.textFieldMapID.getText();
	}

	public String getSeed() {
		return this.textFieldSeed.getText();
	}

	public String getNotes() {
		return this.textFieldNotes.getText();
	}

	public JButton getBtnShare() {
		return this.btnShare;
	}

	public JButton getBtnOpen() {
		return this.btnOpen;
	}

	public void setCharInfo(String text) {
		this.lblCharInfo.setText(text);
	}

	public void setTextFieldMapID(String text) {
		this.textFieldMapID.setText(text);
	}

	public void setTextFieldSeed(String text) {
		this.textFieldSeed.setText(text);
	}

	public void blankNotes() {
		this.textFieldNotes.setText("");
	}

	public JFrame getFrmMapIdFinder() {
		return this.frmMapIdFinder;
	}
}
