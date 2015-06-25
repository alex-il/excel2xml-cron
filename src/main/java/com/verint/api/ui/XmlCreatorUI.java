package com.verint.api.ui;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.verint.api.scheduler.XmlCreatorCron;
import com.verint.api.ui.filter.ExcelFilter;
import static com.verint.api.common.ApiProperties.*;

/*
 * FileChooserDemo.java uses these files:
 *   images/Open16.gif
 *   images/Save16.gif
 */
public class XmlCreatorUI extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4965778166609968250L;
	public static final String NEW_LINE = "\n";

	private JButton openButton, cleanButton, folderButton;
	protected static JTextArea log;
	private JFileChooser fc;
	private File file;
	private String outputFolder=ABSOLUTE_OUT_PATH;

	public XmlCreatorUI() {
		super(new BorderLayout());

		// Create the log first, because the action listeners
		// need to refer to it.
		log = new JTextArea(20, 40);
		log.setMargin(new Insets(5, 5, 5, 5));
		log.setEditable(false);
		JScrollPane logScrollPane = new JScrollPane(log);
		logScrollPane.setAutoscrolls(true);

		// Create a file chooser
		fc = new JFileChooser();
		fc.addChoosableFileFilter(new ExcelFilter());
		fc.setAcceptAllFileFilterUsed(false);

		openButton = new JButton("Open File...", createImageIcon("images/Open16.gif"));
		openButton.addActionListener(this);

		// Create the save button. We use the image from the JLF
		// Graphics Repository (but we extracted it from the jar).
		cleanButton = new JButton("Clean...", createImageIcon("images/Save16.gif"));
		cleanButton.addActionListener(this);

		folderButton = new JButton("Choose Folder", createImageIcon("images/Open16.gif"));
		folderButton.addActionListener(this);

		// For layout purposes, put the buttons in a separate panel
		JPanel buttonPanel = new JPanel(); // use FlowLayout
		buttonPanel.add(openButton);
		buttonPanel.add(folderButton);
		buttonPanel.add(cleanButton);

		// Add the buttons and the log to this panel.
		add(buttonPanel, BorderLayout.PAGE_START);
		add(logScrollPane, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {

		// Handle open button action.
		if (e.getSource() == openButton) {
			int returnVal = fc.showOpenDialog(XmlCreatorUI.this);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				file = fc.getSelectedFile();
				// This is where a real application would open the file.
				if (!file.exists()) {
					log.append(" The file does not exist");
					return;
				}
				final String absoluteFile = file.getAbsolutePath();
				log.append("Opening: " + absoluteFile + "." + NEW_LINE);

				XmlCreatorCron xmlCreator = new XmlCreatorCron(absoluteFile , outputFolder);
				SwingUtilities.invokeLater(xmlCreator);

			} else {
				log.append("Open command cancelled by user." + NEW_LINE);
			}
			log.setCaretPosition(log.getDocument().getLength());

			// Handle save button action.
		} else if (e.getSource() == cleanButton) {
			log.setText("");
			log.setCaretPosition(log.getDocument().getLength());
		} else if (e.getSource() == folderButton) {
			JFileChooser f = new JFileChooser();
			f.setCurrentDirectory(new java.io.File(ABSOLUTE_OUT_PATH));
			f.setDialogTitle("Choose Ouput Folder");
			f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			f.setAcceptAllFileFilterUsed(false);
			f.showDialog(null, "Choose");
			System.out.println(f.getCurrentDirectory());
			outputFolder = f.getSelectedFile().getAbsolutePath();
			System.out.println(outputFolder);
		}
	}

	/** Returns an ImageIcon, or null if the path was invalid. */
	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = XmlCreatorUI.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event dispatch thread.
	 */
	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("API Tester");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Add content to the window.
		frame.add(new XmlCreatorUI());

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void print(String s) {
		log.append(s);
	}

	public static void main(String[] args) {
		// Schedule a job for the event dispatch thread:
		// creating and showing this application's GUI.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// Turn off metal's use of bold fonts
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				createAndShowGUI();
			}
		});
	}

}
