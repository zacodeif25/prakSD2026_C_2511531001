package Pekan9_2511531001;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class PetaBandara_2511531001 extends JFrame {

    private final String[] nodes_1001 = {
        "Terminal 1", "Terminal 2", "Terminal 3",
        "Check-In", "Imigrasi", "Gate A",
        "Gate B", "Gate C", "Baggage Claim",
        "Parkir", "Food Court", "Musholla",
        "Toilet", "Informasi", "Pintu Darurat",
        "Zona Penjemputan", "Taxi Service"
    };

    private final Map<String, ArrayList<String>> adjList_1001 = new LinkedHashMap<String, ArrayList<String>>();
    private final Map<String, int[]> nodePos_1001 = new LinkedHashMap<String, int[]>();
    private final Map<String, String> nodeColor_1001 = new HashMap<String, String>();

    private String startNode_1001 = "";
    private String goalNode_1001  = "";

    private JComboBox<String> cbStart_1001;
    private JComboBox<String> cbGoal_1001;
    private GraphPanel_1001   graphPanel_1001;
    private JTextArea         resultArea_1001;

    public PetaBandara_2511531001() {
    	getContentPane().setForeground(new Color(255, 255, 255));
        initGraph_1001();
        initGUI_1001();
        resetGraph_1001();
    }

    private void initGraph_1001() {
        nodePos_1001.put("Parkir",          new int[]{50,  160});
        nodePos_1001.put("Terminal 1",      new int[]{150, 320});
        nodePos_1001.put("Check-In",        new int[]{250, 160});
        nodePos_1001.put("Imigrasi",        new int[]{350, 320});
        nodePos_1001.put("Baggage Claim",   new int[]{450, 160});
        nodePos_1001.put("Food Court",      new int[]{550, 320});
        nodePos_1001.put("Musholla",        new int[]{650, 160});
        nodePos_1001.put("Gate C",          new int[]{750, 320});

        nodePos_1001.put("Terminal 2",      new int[]{150, 80});
        nodePos_1001.put("Terminal 3",      new int[]{450, 80});
        nodePos_1001.put("Gate A",          new int[]{650, 80});
        nodePos_1001.put("Pintu Darurat",   new int[]{850, 80});
        
        nodePos_1001.put("Toilet",          new int[]{850, 160});
        nodePos_1001.put("Informasi",       new int[]{50,  400});
        nodePos_1001.put("Gate B",          new int[]{550, 400});
        nodePos_1001.put("Zona Penjemputan",new int[]{850, 320});
        nodePos_1001.put("Taxi Service",    new int[]{850, 400});

        for (String n : nodes_1001) adjList_1001.put(n, new ArrayList<String>());

        addEdge_1001("Parkir",        "Terminal 1");
        addEdge_1001("Terminal 1",    "Check-In");
        addEdge_1001("Check-In",      "Imigrasi");
        addEdge_1001("Imigrasi",      "Baggage Claim"); 
        addEdge_1001("Baggage Claim", "Food Court");
        addEdge_1001("Food Court",    "Musholla");
        addEdge_1001("Musholla",      "Gate C");
        addEdge_1001("Imigrasi",      "Gate C"); 
        addEdge_1001("Terminal 1",    "Terminal 2");
        addEdge_1001("Baggage Claim", "Terminal 3");
        addEdge_1001("Musholla",      "Gate A");
        addEdge_1001("Food Court",    "Gate B");
        addEdge_1001("Parkir",        "Informasi");
        addEdge_1001("Gate C",        "Toilet");
        addEdge_1001("Gate C",        "Zona Penjemputan");
        addEdge_1001("Zona Penjemputan", "Taxi Service");
        addEdge_1001("Toilet",        "Pintu Darurat");
    }

    private void addEdge_1001(String u, String v) {
        adjList_1001.get(u).add(v);
        adjList_1001.get(v).add(u);
    }

    public ArrayList<String> BFS(String start_1001, String goal_1001) {
        Map<String, String>  parent_1001  = new LinkedHashMap<String, String>();
        ArrayList<String>    visited_1001 = new ArrayList<String>();
        LinkedList<String>   queue_1001   = new LinkedList<String>();

        parent_1001.put(start_1001, null);
        queue_1001.add(start_1001);

        while (!queue_1001.isEmpty()) {
            String curr_1001 = queue_1001.poll();
            visited_1001.add(curr_1001);
            nodeColor_1001.put(curr_1001, "visited");

            if (curr_1001.equals(goal_1001)) {
                return buildPath_1001(parent_1001, goal_1001, visited_1001, "BFS");
            }

            for (String neighbor_1001 : adjList_1001.get(curr_1001)) {
                if (!parent_1001.containsKey(neighbor_1001)) {
                    parent_1001.put(neighbor_1001, curr_1001);
                    queue_1001.add(neighbor_1001);
                }
            }
        }
        showNoPath_1001("BFS", visited_1001);
        return new ArrayList<String>();
    }

    public ArrayList<String> DFS(String start_1001, String goal_1001) {
        Map<String, String>  parent_1001  = new LinkedHashMap<String, String>();
        ArrayList<String>    visited_1001 = new ArrayList<String>();
        ArrayDeque<String>   stack_1001   = new ArrayDeque<String>();

        stack_1001.push(start_1001);
        parent_1001.put(start_1001, null);

        while (!stack_1001.isEmpty()) {
            String curr_1001 = stack_1001.pop();
            if (visited_1001.contains(curr_1001)) continue;

            visited_1001.add(curr_1001);
            nodeColor_1001.put(curr_1001, "visited");

            if (curr_1001.equals(goal_1001)) {
                return buildPath_1001(parent_1001, goal_1001, visited_1001, "DFS");
            }

            ArrayList<String> neighbors_1001 = new ArrayList<String>(adjList_1001.get(curr_1001));
            Collections.reverse(neighbors_1001);
            for (String neighbor_1001 : neighbors_1001) {
                if (!visited_1001.contains(neighbor_1001)) {
                    if (!parent_1001.containsKey(neighbor_1001))
                        parent_1001.put(neighbor_1001, curr_1001);
                    stack_1001.push(neighbor_1001);
                }
            }
        }
        showNoPath_1001("DFS", visited_1001);
        return new ArrayList<String>();
    }

    private ArrayList<String> buildPath_1001(Map<String, String> parent_1001,
                                              String goal_1001,
                                              ArrayList<String> visited_1001,
                                              String algo_1001) {
        ArrayList<String> path_1001 = new ArrayList<String>();
        String cur_1001 = goal_1001;
        while (cur_1001 != null) {
            path_1001.add(0, cur_1001);
            cur_1001 = parent_1001.get(cur_1001);
        }
        for (String n : path_1001) nodeColor_1001.put(n, "path");

        StringBuilder sb_1001 = new StringBuilder();
        sb_1001.append("=== Hasil Pencarian ").append(algo_1001).append(" ===\n");
        sb_1001.append("Jalur           : ").append(joinList_1001(path_1001, " -> ")).append("\n");
        sb_1001.append("Node Dikunjungi : ").append(joinList_1001(visited_1001, ", ")).append("\n");
        sb_1001.append("Jumlah Node Dieksplorasi : ").append(visited_1001.size()).append("\n");
        sb_1001.append("Panjang Jalur   : ").append(path_1001.size() - 1).append(" langkah\n");

        resultArea_1001.setText(sb_1001.toString());
        displayGraph_1001();
        return path_1001;
    }

    private String joinList_1001(ArrayList<String> list_1001, String sep_1001) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list_1001.size(); i++) {
            if (i > 0) sb.append(sep_1001);
            sb.append(list_1001.get(i));
        }
        return sb.toString();
    }

    private void showNoPath_1001(String algo_1001, ArrayList<String> visited_1001) {
        resultArea_1001.setText("=== Hasil Pencarian " + algo_1001 + " ===\n"
            + "Jalur tidak ditemukan!\n"
            + "Node Dikunjungi : " + joinList_1001(visited_1001, ", ") + "\n"
            + "Jumlah Node Dieksplorasi : " + visited_1001.size() + "\n");
        displayGraph_1001();
    }

    public void displayGraph_1001() {
        graphPanel_1001.repaint();
    }

    public void displayPath_1001(ArrayList<String> path_1001) {
        if (path_1001.isEmpty()) {
            resultArea_1001.append("\n[Tidak ada jalur untuk ditampilkan]");
        }
    }

    public void resetGraph_1001() {
        for (String n : nodes_1001) nodeColor_1001.put(n, "default");
        resultArea_1001.setText("Hasil Pencarian :\nJalur :\nNode Dikunjungi :\nJumlah Node Dieksplorasi : 0");
        displayGraph_1001();
    }

    private void initGUI_1001() {
        setTitle("PENCARIAN JALUR BANDARA - BFS & DFS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(8, 8));
        getContentPane().setBackground(new Color(255, 255, 255));

        JLabel header_1001 = new JLabel("PENCARIAN JALUR MENGGUNAKAN BFS DAN DFS", SwingConstants.CENTER);
        header_1001.setFont(new Font("SansSerif", Font.BOLD, 16));
        header_1001.setForeground(Color.WHITE);
        header_1001.setBackground(new Color(81, 140, 70));
        header_1001.setOpaque(true);
        header_1001.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        JPanel controlPanel_1001 = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 8));
        controlPanel_1001.setBackground(new Color(230, 158, 87));

        controlPanel_1001.add(makeLabel_1001("Lokasi Awal   :"));
        cbStart_1001 = new JComboBox<String>(nodes_1001);
        cbStart_1001.setFont(new Font("SansSerif", Font.PLAIN, 13));
        cbStart_1001.setSelectedItem("Parkir");
        controlPanel_1001.add(cbStart_1001);

        controlPanel_1001.add(makeLabel_1001("Lokasi Tujuan :"));
        cbGoal_1001 = new JComboBox<String>(nodes_1001);
        cbGoal_1001.setFont(new Font("SansSerif", Font.PLAIN, 13));
        cbGoal_1001.setSelectedItem("Gate C");
        controlPanel_1001.add(cbGoal_1001);

        JButton btnBFS_1001 = makeButton_1001("[ BFS ]", new Color(0, 160, 80));
        btnBFS_1001.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetGraph_1001();
                startNode_1001 = (String) cbStart_1001.getSelectedItem();
                goalNode_1001  = (String) cbGoal_1001.getSelectedItem();
                if (startNode_1001.equals(goalNode_1001)) {
                    JOptionPane.showMessageDialog(null, "Lokasi awal dan tujuan tidak boleh sama!");
                    return;
                }
                BFS(startNode_1001, goalNode_1001);
            }
        });

        JButton btnDFS_1001 = makeButton_1001("[ DFS ]", new Color(60, 100, 200));
        btnDFS_1001.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetGraph_1001();
                startNode_1001 = (String) cbStart_1001.getSelectedItem();
                goalNode_1001  = (String) cbGoal_1001.getSelectedItem();
                if (startNode_1001.equals(goalNode_1001)) {
                    JOptionPane.showMessageDialog(null, "Lokasi awal dan tujuan tidak boleh sama!");
                    return;
                }
                DFS(startNode_1001, goalNode_1001);
            }
        });

        JButton btnReset_1001 = makeButton_1001("[ RESET ]", new Color(200, 60, 60));
        btnReset_1001.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetGraph_1001();
            }
        });

        controlPanel_1001.add(btnBFS_1001);
        controlPanel_1001.add(btnDFS_1001);
        controlPanel_1001.add(btnReset_1001);

        JPanel north_1001 = new JPanel(new BorderLayout());
        north_1001.add(header_1001, BorderLayout.NORTH);
        north_1001.add(controlPanel_1001, BorderLayout.SOUTH);
        getContentPane().add(north_1001, BorderLayout.NORTH);

        graphPanel_1001 = new GraphPanel_1001();
        graphPanel_1001.setPreferredSize(new Dimension(900, 480));
        graphPanel_1001.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.GRAY), "  VISUALISASI GRAPH  ",
            TitledBorder.LEFT, TitledBorder.TOP,
            new Font("Monospaced", Font.BOLD, 12), Color.BLACK));
        graphPanel_1001.setBackground(new Color(255,255,255));
        getContentPane().add(graphPanel_1001, BorderLayout.CENTER);

        resultArea_1001 = new JTextArea(7, 60);
        resultArea_1001.setFont(new Font("Monospaced", Font.BOLD, 12));
        resultArea_1001.setBackground(new Color(230, 158, 87));
        resultArea_1001.setForeground(new Color(0, 64, 0));
        resultArea_1001.setEditable(false);
        resultArea_1001.setBorder(BorderFactory.createEmptyBorder(6, 8, 6, 8));
        JScrollPane scroll_1001 = new JScrollPane(resultArea_1001);
        scroll_1001.setToolTipText("");
        scroll_1001.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128)), "  Hasil Pencarian  ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 100, 0)));
        getContentPane().add(scroll_1001, BorderLayout.SOUTH);

        pack();
        setMinimumSize(new Dimension(950, 750));
        setLocationRelativeTo(null);
    }

    private JLabel makeLabel_1001(String text_1001) {
        JLabel lbl = new JLabel(text_1001);
        lbl.setForeground(Color.WHITE);
        lbl.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 13));
        return lbl;
    }

    private JButton makeButton_1001(String text_1001, Color bg_1001) {
        JButton btn = new JButton(text_1001);
        btn.setBackground(bg_1001);
        btn.setForeground(new Color(0, 0, 0));
        btn.setFont(new Font("Monospaced", Font.BOLD, 13));
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(6, 14, 6, 14));
        return btn;
    }

    class GraphPanel_1001 extends JPanel {

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2_1001 = (Graphics2D) g;
            g2_1001.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Garis putus-putus untuk semua edge
            float[] dashPattern = {8.0f, 5.0f};
            g2_1001.setStroke(new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dashPattern, 0.0f));

            HashSet<String> drawn_1001 = new HashSet<String>();
            for (String u : adjList_1001.keySet()) {
                for (String v : adjList_1001.get(u)) {
                    String key_1001 = u.compareTo(v) < 0 ? u + "|" + v : v + "|" + u;
                    if (drawn_1001.contains(key_1001)) continue;
                    drawn_1001.add(key_1001);

                    int[] pu = nodePos_1001.get(u);
                    int[] pv = nodePos_1001.get(v);

                    String cu = nodeColor_1001.containsKey(u) ? nodeColor_1001.get(u) : "default";
                    String cv = nodeColor_1001.containsKey(v) ? nodeColor_1001.get(v) : "default";

                    if (cu.equals("path") && cv.equals("path")) {
                        g2_1001.setColor(new Color(200, 160, 0));
                        // Garis path lebih tebal dan solid
                        g2_1001.setStroke(new BasicStroke(3f));
                    } else {
                        g2_1001.setColor(new Color(100, 100, 100));
                        g2_1001.setStroke(new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dashPattern, 0.0f));
                    }

                    g2_1001.drawLine(pu[0], pu[1], pv[0], pv[1]);
                }
            }

            // Node hanya berupa teks, tanpa bentuk visual
            for (String n : nodes_1001) {
                int[] p = nodePos_1001.get(n);
                String col_1001 = nodeColor_1001.containsKey(n) ? nodeColor_1001.get(n) : "default";

                Color textColor;
                if (col_1001.equals("visited")) {
                    textColor = new Color(200, 100, 0);
                } else if (col_1001.equals("path")) {
                    textColor = new Color(0, 150, 50);
                } else {
                    textColor = new Color(30, 30, 30);
                }

                g2_1001.setColor(textColor);
                g2_1001.setFont(new Font("SansSerif", Font.BOLD, 11));
                FontMetrics fm_1001 = g2_1001.getFontMetrics();
                String[] parts_1001 = n.split(" ", 2);
                if (parts_1001.length == 2) {
                    int w1 = fm_1001.stringWidth(parts_1001[0]);
                    int w2 = fm_1001.stringWidth(parts_1001[1]);
                    g2_1001.drawString(parts_1001[0], p[0] - w1 / 2, p[1] - 4);
                    g2_1001.drawString(parts_1001[1], p[0] - w2 / 2, p[1] + 10);
                } else {
                    int w = fm_1001.stringWidth(n);
                    g2_1001.drawString(n, p[0] - w / 2, p[1] + 4);
                }
            }

            drawLegend_1001(g2_1001);
        }

        private void drawLegend_1001(Graphics2D g2) {
            int lx = 10, ly = getHeight() - 70;
            g2.setFont(new Font("SansSerif", Font.BOLD, 11));
            g2.setColor(Color.BLACK);
            g2.drawString("Keterangan:", lx, ly);

            g2.setFont(new Font("SansSerif", Font.PLAIN, 10));
            g2.setColor(new Color(30, 30, 30));
            g2.drawString("● Belum Dikunjungi", lx, ly + 18);

            g2.setColor(new Color(200, 100, 0));
            g2.drawString("● Dikunjungi", lx + 140, ly + 18);

            g2.setColor(new Color(0, 150, 50));
            g2.drawString("● Jalur Ditemukan", lx + 250, ly + 18);
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PetaBandara_2511531001().setVisible(true);
            }
        });
    }
}