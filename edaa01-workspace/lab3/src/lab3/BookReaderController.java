package lab3;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.Map;

import javax.swing.*;

import textproc.GeneralWordCounter;

public class BookReaderController {

	public BookReaderController(GeneralWordCounter counter) {

		SwingUtilities.invokeLater(() -> createWindow(counter, "BookReader", 100, 300));
	}

	private void createWindow(GeneralWordCounter counter, String title, int width, int height) {

		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = frame.getContentPane();
		
		var model = new SortedListModel<>(counter.getWordList());
		
		
		var list = new JList<>(model);
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setPreferredSize( new Dimension( 200, 300 ) );
		
		pane.add(scrollPane, BorderLayout.NORTH);
		
		
		// Controls
		JPanel controlsPanel = new JPanel();
		
		JButton alphBtn = new JButton("Alphabetic");
		JButton freqBtn = new JButton("Frequency");
		
		JTextField searchTxt = new JTextField();
		searchTxt.setPreferredSize( new Dimension( 200, 24 ) );
		
		JButton searchBtn = new JButton("Find");
		
		// Adding
		controlsPanel.add(alphBtn);
		controlsPanel.add(freqBtn);
		controlsPanel.add(searchTxt);
		controlsPanel.add(searchBtn);		
		
		// Event listeners
		alphBtn.addActionListener((e) -> model.sort((m1, m2) -> m1.getKey().compareTo(m2.getKey())));
		
		freqBtn.addActionListener((e) -> model.sort((m1, m2) -> m2.getValue() - m1.getValue()));
		
		searchBtn.addActionListener((e) -> {
			String txt = searchTxt.getText().trim().toLowerCase(); // V1, trimming and lowercasing
			
			// Loop through model and scroll to element if found
			for(int i = 0; i < model.getSize(); i++) {
				
				if(model.getElementAt(i).getKey().equals(txt)) {
					list.ensureIndexIsVisible(i);
					list.setSelectedIndex(i);
					return;
				}
			}
			
			JOptionPane.showMessageDialog(null, "Inga resultat hittades"); // V2, dialog box with message on no results
			
			
		});
		
		searchTxt.addActionListener(e -> searchBtn.doClick()); // V3, search on enter
		
		pane.add(controlsPanel, BorderLayout.SOUTH);
		
		
		
		frame.pack();
		frame.setVisible(true);
	}
}
