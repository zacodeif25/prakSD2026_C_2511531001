package pekan7_2511531001;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class SortingGUI_2511531001 extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	//komponen Input
	private JTextField txtNama_1001, txtNim_1001, txtProdi_1001;
	private JButton btnTambah_1001, btnHapus_1001, btnSort_1001, btnStep_1001, btnReset_1001;
	private JComboBox <String> comboAlgoritma_1001;
	
	//Tabel untuk menampilkan data
	private JTable table_1001;
	private DefaultTableModel tableModel_1001;
	
	//Area log untuk visualisasi langkah
	private JTextArea logArea_1001;
	
	//Data Mahasiswa 
	private ArrayList<Mahasiswa_2511531001> dataList_1001;
	private ArrayList<Mahasiswa_2511531001> workingList_1001;
	
	//State untuk sorting per step
	private String selectedAlgorithm_1001 = "";
	private boolean isSorting_1001 = false;
	
	//variabel untuk insertion sort
	private int insertionI_1001, insertionJ_1001;
	private Mahasiswa_2511531001 insertionKey_1001;
	private int insertionPhase_1001; // 0 = start, 1 = shifting, 2 = insert
	
	//variabel untuk selection sort
	private int selectionI_1001, selectionJ_1001, selectionMinIdx_1001;
	private int selectionPhase_1001; // 0 = menemukan minimal, 1= swap
	
	//variabel untuk bubble sort
	private int bubbleI_1001, bubbleJ_1001;
	private int bubblePhase_1001; // 0 = membandingkan, 1 = swap jika perlu
	
	private int stepCounter_1001 = 1;
	
	public SortingGUI_2511531001() {
		setTitle("Sorting Mahasiswa - Insertion | Selection | Bubble Sort");
		setSize(900,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout(10,10));
		
		dataList_1001 = new ArrayList<>();
		workingList_1001 = new ArrayList<>();
		
		//panel input
		JPanel inputPanel_1001 = new JPanel (new FlowLayout (FlowLayout.LEFT,10,10));
		inputPanel_1001.setBorder(BorderFactory.createTitledBorder("Input Data Mahasiswa"));
		
		txtNama_1001 = new JTextField(15);
		txtNim_1001 = new JTextField(15);
		txtProdi_1001 = new JTextField(15);
		
		btnTambah_1001 = new JButton("Tambah");
		btnHapus_1001 = new JButton ("Hapus Terpilih");
		
		inputPanel_1001.add(new JLabel("Nama:"));
		inputPanel_1001.add(txtNama_1001);
		inputPanel_1001.add(new JLabel("NIM:"));
		inputPanel_1001.add(txtNim_1001);
		inputPanel_1001.add(new JLabel ("Prodi:"));
		inputPanel_1001.add(txtProdi_1001);
		inputPanel_1001.add(btnTambah_1001);
		inputPanel_1001.add(btnHapus_1001);
		
		//panel Kontrol Sorting
		JPanel controlPanel_1001 = new JPanel( new FlowLayout (FlowLayout.CENTER, 15,10));
		controlPanel_1001.setBorder(BorderFactory.createTitledBorder("Kontrol Sorting"));
		
		comboAlgoritma_1001 = new JComboBox<>(new String [] {
				"Pilih Algoritma", "Insertion Sort", "Selection Sort", "Bubble Sort"
		});
		btnSort_1001 = new JButton ("Mulai Sorting");
		btnStep_1001 = new JButton ("Langkah Selanjutnya");
		btnReset_1001 = new JButton ("Reset");
		btnStep_1001.setEnabled(false);
		btnSort_1001.setEnabled(false);
		
		controlPanel_1001.add(new JLabel ("Algoritma"));
		controlPanel_1001.add(comboAlgoritma_1001);
		controlPanel_1001.add(btnSort_1001);
		controlPanel_1001.add(btnStep_1001);
		controlPanel_1001.add(btnReset_1001);
		
		//tabe data
		String [] columns_1001 = {"NO", "Nama", "NIM", "Program Studi"};
		tableModel_1001 = new DefaultTableModel (columns_1001, 0) {
			@Override
			public boolean isCellEditable (int row, int column) {
				return false;
			}
		};
		table_1001 = new JTable (tableModel_1001);
		table_1001.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		table_1001.setRowHeight(25);
		table_1001.setFont(new Font ("Arial", Font.PLAIN, 12));
		
		JScrollPane tableScroll_1001 = new JScrollPane (table_1001);
		tableScroll_1001.setPreferredSize(new Dimension (850,150));
		
		// area log visualisasi
		logArea_1001 = new JTextArea (12,70);
		logArea_1001.setEditable(false);
		logArea_1001.setFont(new Font ("Monospaced", Font.PLAIN, 11));
		logArea_1001.setBackground(new Color (245, 245, 245));
		JScrollPane logScroll_1001 = new JScrollPane (logArea_1001);
		logScroll_1001.setBorder(BorderFactory.createTitledBorder("Log Proses Sorting"));
		
		//susunan Layout
		JPanel topPanel_1001 = new JPanel (new BorderLayout (10,10));
		topPanel_1001.add(inputPanel_1001, BorderLayout.NORTH);
		
		JPanel centerPanel_1001 = new JPanel (new BorderLayout (10,10));
		centerPanel_1001.add(tableScroll_1001, BorderLayout.NORTH);
		centerPanel_1001.add(logScroll_1001, BorderLayout.CENTER);
		
		add (topPanel_1001, BorderLayout.NORTH);
		add (centerPanel_1001, BorderLayout.CENTER);
		add (controlPanel_1001, BorderLayout.SOUTH);
		
		//event handler
		btnTambah_1001.addActionListener(e -> tambahData_1001());
		btnHapus_1001.addActionListener(e-> hapusdata_1001());
		comboAlgoritma_1001.addActionListener(e-> updateButtonState_1001());
		btnSort_1001.addActionListener(e-> mulaiSorting_1001());
		btnStep_1001.addActionListener(e-> lakukanLangkah_1001());
		btnReset_1001.addActionListener(e-> reset_1001());
		
		}
	
	private void tambahData_1001() {
		String nama_1001 = txtNama_1001.getText().trim();
		String nim_1001 = txtNim_1001.getText().trim();
		String prodi_1001 = txtProdi_1001.getText().trim();
		
		if (nama_1001.isEmpty() || nim_1001.isEmpty() || prodi_1001.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Semua field harus diisi", "Input Error", JOptionPane.WARNING_MESSAGE);
			return;
		}
		Mahasiswa_2511531001 mhs_1001 = new Mahasiswa_2511531001 (nama_1001, nim_1001, prodi_1001);
		dataList_1001.add(mhs_1001);
		refreshTable_1001();
		
		txtNama_1001.setText("");
		txtNim_1001.setText("");
		txtProdi_1001.setText("");
		txtNama_1001.requestFocus();
		
		updateButtonState_1001();
	}
	
	private void hapusdata_1001() {
		int selectedRow_1001 = table_1001.getSelectedRow();
		if (selectedRow_1001 == -1) {
			JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus!", "warning", JOptionPane.WARNING_MESSAGE);
			return;
		}
		dataList_1001.remove(selectedRow_1001);
		refreshTable_1001();
		updateButtonState_1001();
	}
	
	private void refreshTable_1001() {
		tableModel_1001.setRowCount(0);
		for (int i_1001 = 0; i_1001 < dataList_1001.size(); i_1001++) {
			Mahasiswa_2511531001 m_1001 = dataList_1001.get(i_1001);
			tableModel_1001.addRow(new Object [] {
					(i_1001 + 1), m_1001.getNama_1001(), m_1001.getNim_1001(),m_1001.getProdi_1001()
			});
		}
	}
	
	private void updateButtonState_1001 () {
		boolean hasData_1001 = !dataList_1001.isEmpty();
		String selected_1001 = (String) comboAlgoritma_1001.getSelectedItem();
		btnSort_1001.setEnabled(hasData_1001 && !selected_1001.equals("Pilih Algoritma"));
	}
	
	private void mulaiSorting_1001 () {
		if (dataList_1001.isEmpty()) return;
		
		selectedAlgorithm_1001 = (String) comboAlgoritma_1001.getSelectedItem();
		workingList_1001 = new ArrayList<> ( dataList_1001); // mengcopy data
		isSorting_1001 = true;
		stepCounter_1001 = 1;
		btnStep_1001.setEnabled(true);
		btnSort_1001.setEnabled(false);
		comboAlgoritma_1001.setEnabled(false);
		logArea_1001.setText("");
		
		logArea_1001.append("===" + selectedAlgorithm_1001.toUpperCase() + "===\n");
		logArea_1001.append ("data awal : "+ listToString_1001 (workingList_1001)+ "\n");
		
		if (selectedAlgorithm_1001.equals("Insertion Sort")) {
			insertionI_1001 = 1;
			insertionPhase_1001 = 0;
		} else if (selectedAlgorithm_1001.equals("Selection Sort")) {
			selectionI_1001 = 0;
			selectionJ_1001 = 1;
			selectionPhase_1001 = 0;	
		} else if (selectedAlgorithm_1001.equals("Bubble Sort")){
			bubbleI_1001 = 0;
			bubbleJ_1001 = 0;
			bubblePhase_1001 = 0;
		}
		
		refreshTable_1001();
	}
	
	private void lakukanLangkah_1001() {
		if (!isSorting_1001) return;
		
		switch (selectedAlgorithm_1001) {
		case "Insertion Sort":
			langkahInsertion_1001();
			break;
		case "Selection Sort":
			langkahSelection_1001();
			break;
		case "Bubble Sort":
			langkahBubble_1001();
			break;
		}
		
		refreshTable_1001();
	}
	
	private void langkahInsertion_1001() {
		if (insertionI_1001 >= workingList_1001.size()) {
			selesaiSorting_1001();
			return;
		}
		
		if (insertionPhase_1001 == 0) {
			// mengambil key
			insertionKey_1001 = workingList_1001.get(insertionI_1001);
			insertionJ_1001 = insertionI_1001 -1;
			logArea_1001.append("Langkah " + stepCounter_1001 + ": Memproses \"" + insertionKey_1001.getNama_1001() + "\"\n");
			insertionPhase_1001 = 1;
		} else if (insertionPhase_1001 == 1) {
			// shifting
			if (insertionJ_1001 >=0 && workingList_1001.get(insertionJ_1001).getNama_1001().compareToIgnoreCase(insertionKey_1001.getNama_1001()) >0) {
				workingList_1001.set (insertionJ_1001 + 1, workingList_1001.get(insertionJ_1001));
				logArea_1001.append(" -> Shift\"" + workingList_1001.get(insertionJ_1001 + 1).getNama_1001()+ "\" ke kanan\n");
				insertionJ_1001--;
			}else {
				insertionPhase_1001 = 2;
				return;	
			}
		}
		else if (insertionPhase_1001 == 2) {
			//insert key
			workingList_1001.set(insertionJ_1001 + 1, insertionKey_1001);
			logArea_1001.append(" -> Insert \"" +insertionKey_1001.getNama_1001() + "\" di posisi " + (insertionJ_1001 + 2) + "\n" );
			logArea_1001.append(("Hasil Sementara: " + listToString_1001(workingList_1001)+ "\n\n"));
			
			insertionI_1001++;
			insertionPhase_1001 = 0;
			stepCounter_1001++;
			
			if (insertionI_1001 >= workingList_1001.size()) {
				selesaiSorting_1001();
			}
		}
	}
	
	private void langkahSelection_1001() {
		if (selectionI_1001 >= workingList_1001.size()-1) {
			selesaiSorting_1001();
			return;
		}
		
		if (selectionPhase_1001 ==0) {
			//mencari minimum
			if (selectionJ_1001 == selectionI_1001 + 1) {
				selectionMinIdx_1001 = selectionI_1001;
				logArea_1001.append("Langkah" + stepCounter_1001 + ": Pass" + (selectionI_1001 +1 ) +" - Mencari minimum dari index " + selectionI_1001 + "\n");
			}
			
			if (selectionJ_1001 < workingList_1001.size()) {
				if (workingList_1001.get(selectionJ_1001).getNama_1001().compareToIgnoreCase(workingList_1001.get(selectionMinIdx_1001).getNama_1001())< 0) {
					selectionMinIdx_1001 = selectionJ_1001;
					logArea_1001.append(" -> Ditemukan angka yang lebih kecil\""+ workingList_1001.get(selectionMinIdx_1001).getNama_1001()+ "\"\n");
				}
				selectionJ_1001++;
			} else {
				selectionPhase_1001 =1 ;
				selectionJ_1001 = selectionI_1001; // reset utk swap
				return;
			}
		}
		
		else if (selectionPhase_1001 == 1) {
			// swap bila perlu
			if (selectionMinIdx_1001 != selectionI_1001) {
				Mahasiswa_2511531001 temp_1001 = workingList_1001.get(selectionI_1001);
				workingList_1001.set(selectionI_1001, workingList_1001.get(selectionMinIdx_1001));
				workingList_1001.set(selectionMinIdx_1001, temp_1001);
				logArea_1001.append(" -> Swap: \"" + workingList_1001.get(selectionI_1001).getNama_1001()+"\" <-> \"" + workingList_1001.get(selectionMinIdx_1001).getNama_1001()+ "\"\n");
			}
			logArea_1001.append("Hasil Pass " + (selectionI_1001 + 1) + ": "+ listToString_1001(workingList_1001) + "\n\n");
			
			selectionI_1001++;
			selectionJ_1001 = selectionI_1001 + 1;
			selectionPhase_1001 = 0;
			stepCounter_1001++;
			
			if (selectionI_1001 >= workingList_1001.size()-1) {
				selesaiSorting_1001();
			}
		}
	}
	
	private void langkahBubble_1001() {
		if (bubbleI_1001 >= workingList_1001.size()-1) {
			selesaiSorting_1001();
			return;
		}
		
		if (bubblePhase_1001 == 0) {
			//komparasi
			if (bubbleJ_1001 == 0) {
				logArea_1001.append("Langkah" + stepCounter_1001 + ": Pass" + (bubbleI_1001 + 1) + "\n");
			}
			String namaKiri_1001 = workingList_1001.get(bubbleJ_1001).getNama_1001();
			String namaKanan_1001 = workingList_1001.get(bubbleJ_1001+ 1).getNama_1001();
			
			logArea_1001.append(" -> Bandingkan \"" + namaKiri_1001 + "\" vs \"" +namaKanan_1001 + "\"\n");
			
			if (namaKiri_1001.compareToIgnoreCase(namaKanan_1001)>0) {
				bubblePhase_1001 = 1; //perlu swap
			} else {
				bubbleJ_1001++;
				if (bubbleJ_1001 >= workingList_1001.size()-1-bubbleI_1001) {
					logArea_1001.append(("Hasil Pass "+ (bubbleI_1001 + 1) + ": " + listToString_1001(workingList_1001)+ "\n\n"));
					bubbleI_1001++;
					bubbleJ_1001 = 0;;
					stepCounter_1001++;
					if (bubbleI_1001 >= workingList_1001.size()-1) {
						selesaiSorting_1001();
					}
				}
			}
		}
		
		else if (bubblePhase_1001 == 1) {
			//swap
			Mahasiswa_2511531001 temp_1001 = workingList_1001.get(bubbleJ_1001);
			workingList_1001.set(bubbleJ_1001, workingList_1001.get(bubbleJ_1001+ 1));
			workingList_1001.set(bubbleJ_1001 + 1, temp_1001);
			logArea_1001.append("-> Swap dilakukan! \n");
			
			bubblePhase_1001 =0;
			bubbleJ_1001 ++;
			
			if (bubbleJ_1001 >= workingList_1001.size() -1- bubbleI_1001) {
				logArea_1001.append("Hasil Pass " + ( bubbleI_1001 + 1) + ": " + listToString_1001(workingList_1001) + "\n\n");
				bubbleI_1001++;
				bubbleJ_1001 = 0;
				stepCounter_1001 ++;
				if (bubbleI_1001 >= workingList_1001.size() - 1) {
					selesaiSorting_1001();
				}
			}
		}
	}
	
	private void selesaiSorting_1001() {
		logArea_1001.append("\n SORTING SELESAI!\n");
		logArea_1001.append("Hasil Akhir (A-Z): " + listToString_1001(workingList_1001) + "\n");
		isSorting_1001 = false;
		btnStep_1001.setEnabled(false);
		btnSort_1001.setEnabled(true);
		comboAlgoritma_1001.setEnabled(true);
		JOptionPane.showMessageDialog(this, "Sorting berhasil selesai diselesaikan", "Selesai", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void reset_1001 () {
		  dataList_1001.clear();
	        workingList_1001.clear();
	        refreshTable_1001();
	        logArea_1001.setText("");
	        comboAlgoritma_1001.setSelectedIndex(0);
	        btnStep_1001.setEnabled(false);
	        btnSort_1001.setEnabled(false);
	        comboAlgoritma_1001.setEnabled(true);
	        isSorting_1001 = false;
	        txtNama_1001.setText("");
	        txtNim_1001.setText("");
	        txtProdi_1001.setText("");
	}
	
	private String listToString_1001 (ArrayList<Mahasiswa_2511531001> list_1001) {
		StringBuilder sb_1001 = new StringBuilder("[");
		for (int i_1001 = 0; i_1001 < list_1001.size(); i_1001++) {
			sb_1001.append("\"").append(list_1001.get(i_1001).getNama_1001()).append("\"");
			if (i_1001 < list_1001.size()-1) sb_1001.append(", ");
		}
		sb_1001.append("]");
		return sb_1001.toString();
	}
	
	public static void main (String [] args) {
		EventQueue.invokeLater(() -> {
			try {
				SortingGUI_2511531001 frame = new SortingGUI_2511531001 ();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}
