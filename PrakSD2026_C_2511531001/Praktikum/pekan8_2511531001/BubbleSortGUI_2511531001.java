package pekan8_2511531001;
import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class BubbleSortGUI_2511531001 extends JFrame {

	private static final long serialVersionUID = 1L;
	private int [] array_1001;
	private JLabel[] labelArray_1001;
	private JButton stepButton_1001, resetButton_1001, setButton_1001;
	private JTextField inputField_1001;
	private JPanel panelArray_1001;
	private JTextArea stepArea_1001;
	
	private int i_1001 = 1, j_1001;
	private boolean sorting_1001 = false;
	private int stepCount_1001 = 1;


	/**
	 * Create the frame.
	 */
	public BubbleSortGUI_2511531001() {
		setTitle("Bubble Sort Langkah per Langkah");
		setSize(750,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout (new BorderLayout());
		
		//panel input
		JPanel inputPanel_1001 = new JPanel (new FlowLayout());
		inputField_1001 = new JTextField (30);
		setButton_1001 = new JButton ("Set Array");
		inputPanel_1001.add(new JLabel ("Masukkan angka (pisahkan dengan koma):"));
		inputPanel_1001.add(inputField_1001);
		inputPanel_1001.add(setButton_1001);
		
		//panel array visual
		panelArray_1001 = new JPanel();
		panelArray_1001.setLayout (new FlowLayout());
		
		//panel kontrol 
		JPanel controlPanel_1001 = new JPanel ();
		stepButton_1001 = new JButton ("Langkah Selanjutnya");
		resetButton_1001 = new JButton ("Reset");
		stepButton_1001.setEnabled(false);
		controlPanel_1001.add(stepButton_1001);
		controlPanel_1001.add(resetButton_1001);

		//Area teks untuk log langkah-langkah
		stepArea_1001 = new JTextArea (8,60);
		stepArea_1001.setEditable(false);
		stepArea_1001.setFont(new Font ("Monospaced", Font.PLAIN,14));
		JScrollPane scrollPane_1001 = new JScrollPane (stepArea_1001);
		
		//Tambahkan panel ke frame
		add(inputPanel_1001, BorderLayout.NORTH);
		add(panelArray_1001, BorderLayout.CENTER);
		add(controlPanel_1001,BorderLayout.SOUTH);
		add(scrollPane_1001, BorderLayout.EAST);
		
		//event Set Array 
		setButton_1001.addActionListener ( e -> setArrayFromInput_1001());
		
		//event Langkah Selanjutnya
		stepButton_1001.addActionListener ( e-> performStep_1001());
		
		//event Reset
		resetButton_1001.addActionListener(e -> reset_1001());
	}
	
	private void setArrayFromInput_1001() {
		String text_1001 = inputField_1001.getText().trim();
		if ( text_1001.isEmpty()) return;
		String [] parts_1001 = text_1001.split(",");
		array_1001 = new int [parts_1001.length];
		
		try {
			for ( int k_1001 = 0; k_1001 < parts_1001.length; k_1001++) {
				array_1001 [k_1001] = Integer.parseInt(parts_1001[k_1001].trim());
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Masukkan hanya angka yang dipisahkan" + " dengan koma !" , "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		i_1001 = 0;
		j_1001 = 0;
		stepCount_1001 =1;
		sorting_1001 = true;
		stepButton_1001.setEnabled(true);
		stepArea_1001.setText("");
		panelArray_1001.removeAll();
		labelArray_1001 = new JLabel [array_1001.length];
		for (int k_1001 = 0; k_1001 < array_1001.length; k_1001++) {
			labelArray_1001[k_1001] = new JLabel (String.valueOf(array_1001[k_1001]));
			labelArray_1001[k_1001].setFont(new Font ("Arial", Font.BOLD,24));
			labelArray_1001[k_1001].setOpaque(true);
			labelArray_1001[k_1001].setBackground(Color.WHITE);
			labelArray_1001[k_1001].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			labelArray_1001[k_1001].setPreferredSize(new Dimension (50,50));
			labelArray_1001[k_1001].setHorizontalAlignment(SwingConstants.CENTER);
			panelArray_1001.add(labelArray_1001[k_1001]);
		}
		panelArray_1001.revalidate();
		panelArray_1001.repaint();
	}
	
	private void performStep_1001() {
		if ( !sorting_1001 || i_1001 >= array_1001.length - 1) {
		sorting_1001 = false;
		stepButton_1001.setEnabled(false);
		JOptionPane.showMessageDialog(this, "Sorting selesai!");
		return;
		}
		
	resetHighlights_1001 ();
	StringBuilder stepLog_1001 = new StringBuilder();
	labelArray_1001[j_1001].setBackground(Color.cyan);
	labelArray_1001[j_1001+1].setBackground(Color.cyan);
	if (array_1001[j_1001] > array_1001 [j_1001+1]) {
		//swap
		int temp_1001 = array_1001[j_1001];
		array_1001[j_1001] = array_1001[j_1001+1];
		array_1001[j_1001+1] = temp_1001;
		labelArray_1001[j_1001].setBackground(Color.RED);
		labelArray_1001[j_1001+1].setBackground(Color.RED);
		stepLog_1001.append("Langkah ").append(stepCount_1001).append(":Menukar elemen ke-").append(j_1001).append(" (").append(array_1001[j_1001+1])
		.append(") dengan ke-").append(j_1001+1).append(" (").append(array_1001[j_1001]).append(")\n");
	} else {
		stepLog_1001.append("Langkah ").append(stepCount_1001).append(":Tidak ada pertukaran elemen ke-").append(j_1001).append(" dan ke-").append(j_1001+1)
		.append("\n");
		
		stepLog_1001.append("Hasil : ").append(arrayToString_1001(array_1001)).append("\n\n");
		stepArea_1001.append(stepLog_1001.toString());
		updateLabels_1001();
		j_1001++;
		if (j_1001 >= array_1001.length - i_1001 - 1) {
			j_1001 =0;
			i_1001++;
		}
		stepCount_1001++;
		if (i_1001 >= array_1001.length - 1) {
			sorting_1001 = false;
			stepButton_1001.setEnabled(false);
			JOptionPane.showMessageDialog(this, "Sorting selsai!");
		}}
}
	
	private void updateLabels_1001() {
		for(int k_1001 = 0; k_1001<array_1001.length; k_1001++) {
			labelArray_1001[k_1001].setText(String.valueOf(array_1001[k_1001]));
		}
	}
	
	private void resetHighlights_1001 () {
		for (JLabel label_1001 : labelArray_1001) {
			label_1001.setBackground(Color.white);
		}
	}
	private void reset_1001() {
		inputField_1001.setText("");
		panelArray_1001.removeAll();
		panelArray_1001.revalidate();
		panelArray_1001.repaint();
		stepArea_1001.setText("");
		stepButton_1001.setEnabled(false);
		sorting_1001 = false;
		i_1001 = 0;
		j_1001 = 0;
		stepCount_1001 = 1;
	}
	
	private String arrayToString_1001 (int [] arr_1001) {
		StringBuilder sb_1001 = new StringBuilder();
		for (int k_1001 = 0; k_1001 < arr_1001.length; k_1001 ++) {
			sb_1001.append(arr_1001[k_1001]);
			if (k_1001 < arr_1001.length-1) sb_1001.append(", ");
		}
		return sb_1001.toString();
	}
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BubbleSortGUI_2511531001 frame = new BubbleSortGUI_2511531001();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
}
