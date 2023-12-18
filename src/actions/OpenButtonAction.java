package actions;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import core.D2CharFileParser;
import gui.MapIDGUI;

public class OpenButtonAction extends AbstractAction {

	private static final long serialVersionUID = -6602620070956375681L;
	private MapIDGUI gui;

	public OpenButtonAction(MapIDGUI gui) {
		putValue(Action.NAME, "Open");
		this.gui = gui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Diablo II Save File (*.d2s)", "d2s");
		chooser.setFileFilter(filter);
		chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
		int returnVal = chooser.showOpenDialog(this.gui.getFrmMapIdFinder());

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try {
				File charFile = chooser.getSelectedFile();
				D2CharFileParser charParser = new D2CharFileParser(charFile);
				int mapSeed = charParser.getMapID();
				int charLvl = charParser.getCharacterLevel();
				String charClass = charParser.getCharacterClass();
				String charDiff = charParser.getCharacterDifficulty();
				String charName = charParser.getCharacterName();

				this.gui.setCharInfo(String.format("%s - Level %d %s (%s)", charName, charLvl, charClass, charDiff));
				this.gui.setTextFieldMapID(this.formatMapID(mapSeed));
				this.gui.setTextFieldSeed(Integer.toUnsignedString(mapSeed));
				this.gui.blankNotes();
			} catch (IOException exception) {
				this.gui.setCharInfo("Error when parsing char file!");
				exception.printStackTrace();
			}
		}
	}

	private String formatMapID(int seed) {
		StringBuffer buffer = new StringBuffer();
		char[] mapSeedHex = String.format("%08x", seed).toCharArray();

		for (int i = 1; i <= mapSeedHex.length; i++) {
			buffer.append(mapSeedHex[i - 1]);
			if ((i % 2) == 0) {
				buffer.append(" ");
			}
		}

		return buffer.toString().toUpperCase();
	}
}
