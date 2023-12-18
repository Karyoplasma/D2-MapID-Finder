package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import actions.OpenButtonAction;
import actions.ShareButtonAction;
import net.miginfocom.swing.MigLayout;

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
		
		frmMapIdFinder = new JFrame();
		frmMapIdFinder.setTitle("Map ID Finder");
		frmMapIdFinder.setBounds(100, 100, 500, 200);
		frmMapIdFinder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMapIdFinder.getContentPane().setLayout(new MigLayout("", "[][][][][grow][][]", "[][][][][grow]"));
		
		btnOpen = new JButton(new OpenButtonAction(this));
		btnOpen.setFont(new Font("Tahoma", Font.BOLD, 14));
		frmMapIdFinder.getContentPane().add(btnOpen, "cell 0 0,grow");
		
		lblCharInfo = new JLabel("No character loaded");
		lblCharInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCharInfo.setFont(new Font("Tahoma", Font.BOLD, 14));
		frmMapIdFinder.getContentPane().add(lblCharInfo, "cell 0 1 7 1,grow");
		
		JLabel lblMapId = new JLabel("Map ID:");
		lblMapId.setFont(new Font("Tahoma", Font.BOLD, 14));
		frmMapIdFinder.getContentPane().add(lblMapId, "cell 0 2,grow");
		
		textFieldMapID = new JTextField();
		textFieldMapID.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldMapID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldMapID.setEditable(false);
		frmMapIdFinder.getContentPane().add(textFieldMapID, "cell 1 2 2 1,grow");
		textFieldMapID.setColumns(10);
		
		JLabel lblSeed = new JLabel("Seed:");
		lblSeed.setFont(new Font("Tahoma", Font.BOLD, 14));
		frmMapIdFinder.getContentPane().add(lblSeed, "cell 3 2,grow");
		
		textFieldSeed = new JTextField();
		textFieldSeed.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSeed.setEditable(false);
		textFieldSeed.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmMapIdFinder.getContentPane().add(textFieldSeed, "cell 4 2 3 1,grow");
		textFieldSeed.setColumns(10);
		
		JLabel lblNotes = new JLabel("Notes:");
		lblNotes.setFont(new Font("Tahoma", Font.BOLD, 14));
		frmMapIdFinder.getContentPane().add(lblNotes, "cell 0 3,grow");
		
		textFieldNotes = new JTextField();
		textFieldNotes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmMapIdFinder.getContentPane().add(textFieldNotes, "cell 1 3 6 1,grow");
		textFieldNotes.setColumns(10);
		
		btnShare = new JButton(new ShareButtonAction(this));
		btnShare.setFont(new Font("Tahoma", Font.BOLD, 14));
		frmMapIdFinder.getContentPane().add(btnShare, "cell 0 4 7 1,grow");
	}
	
	public String getCharInfo() {
		return this.lblCharInfo.getText();
	}
	
	public String getMapID() {
		return this.textFieldMapID.getText();
	}
	
	public String getSeed() {
		return textFieldSeed.getText();
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
