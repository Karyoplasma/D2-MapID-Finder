package gui;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import core.D2CharFileParser;

public class MapIDFinderActionListener implements ActionListener {
	private MapIDGUI finder;
	
	public MapIDFinderActionListener(MapIDGUI finder){
		super();
		this.finder = finder;	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.finder.getBtnOpen()) {
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Diablo II Save File (*.d2s)", "d2s");
			chooser.setFileFilter(filter);
			chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
			int returnVal = chooser.showOpenDialog(this.finder.getFrmMapIdFinder());
			
			if(returnVal == JFileChooser.APPROVE_OPTION) {
			   	try {
			   		File charFile = chooser.getSelectedFile();
				    D2CharFileParser charParser = new D2CharFileParser(charFile);
			
				    int mapSeed = charParser.getMapID();
					int charLvl = charParser.getCharacterLevel();
					String charClass = charParser.getCharacterClass();
					String charDiff = charParser.getCharacterDifficulty();
					String charName = charParser.getCharacterName();
					
					this.finder.setCharInfo(String.format("%s - Level %d %s (%s)", charName, charLvl, charClass, charDiff));
			   		this.finder.setTextFieldMapID(this.formatMapID(mapSeed));
			   		this.finder.setTextFieldSeed(Integer.toString(mapSeed));
					this.finder.blankNotes();
			    } catch (IOException exception) {
			    	this.finder.setCharInfo("Error when parsing char file!");
			    	exception.printStackTrace();
			    }   
			}
		} else {
			if (e.getSource() == this.finder.getBtnShare()){
				if (this.finder.getSeed().isEmpty()) {
					return;
				} else {
					StringBuffer buffer = new StringBuffer("Shared by: ");
					
					buffer.append(this.finder.getCharInfo());
					buffer.append(System.getProperty("line.separator"));
					buffer.append(System.getProperty("line.separator"));
					buffer.append("-seed ");
					buffer.append(this.finder.getSeed());
					buffer.append(System.getProperty("line.separator"));
					buffer.append(System.getProperty("line.separator"));
					buffer.append("Notes: ").append(this.finder.getNotes());
					StringSelection shareData = new StringSelection(buffer.toString());
					Toolkit.getDefaultToolkit().getSystemClipboard().setContents(shareData, null);
					JOptionPane.showMessageDialog(this.finder.getFrmMapIdFinder(), "Copied to clipboard!", "Information" ,JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		}		
	}

	private String formatMapID(int seed) {
		StringBuffer buffer = new StringBuffer();
		char[] mapSeedHex = String.format("%08x", seed).toCharArray();
		
		for (int i = 1; i <= mapSeedHex.length; i++) {
			buffer.append(mapSeedHex[i-1]);
		    if ((i % 2) == 0) {
		    	buffer.append(" ");
		    }				    	
		}
		
		return buffer.toString();
	}

}
