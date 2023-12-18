package actions;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;

import gui.MapIDGUI;

public class ShareButtonAction extends AbstractAction {

	private static final long serialVersionUID = -3935112301831852842L;
	private MapIDGUI gui;

	public ShareButtonAction(MapIDGUI gui) {
		putValue(Action.NAME, "Share");
		this.gui = gui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.gui.getSeed().isEmpty()) {
			return;
		} else {
			StringBuffer buffer = new StringBuffer("Shared by: ");

			buffer.append(this.gui.getCharInfo());
			buffer.append(System.getProperty("line.separator"));
			buffer.append(System.getProperty("line.separator"));
			buffer.append("-seed ");
			buffer.append(this.gui.getSeed());
			buffer.append(System.getProperty("line.separator"));
			buffer.append(System.getProperty("line.separator"));
			buffer.append("Notes: ").append(this.gui.getNotes());
			StringSelection shareData = new StringSelection(buffer.toString());
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(shareData, null);
			JOptionPane.showMessageDialog(this.gui.getFrmMapIdFinder(), "Copied to clipboard!", "Information",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
