import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Representation extends JFrame {

    ArrayList<Integer> seq;

    public Representation( FCFS f,SSTF s,Scan scn ,Cscan cs ,Look l,Clook cl,OptimizedAlgo opt) {

        super("Disk Scheduling");

        this.seq=new ArrayList<>();
        setSize(1030, 650);

        JButton fcfs = new JButton("FCFS");
        JButton sstf = new JButton("SSTF");
        JButton scan = new JButton("SCAN");
        JButton look = new JButton("LOOK");
        JButton cscan = new JButton("CSCAN");
        JButton clook = new JButton("CLOOK");
        JButton optimized = new JButton("Optimized");

        fcfs.setBounds(20, 5, 130, 40);
        sstf.setBounds(160, 5, 130, 40);
        scan.setBounds(300, 5, 130, 40);
        look.setBounds(440, 5, 130, 40);
        cscan.setBounds(580, 5, 130, 40);
        clook.setBounds(720, 5, 130, 40);
        optimized.setBounds(860, 5, 130, 40);

        add(fcfs);
        add(sstf);
        add(scan);
        add(look);
        add(cscan);
        add(clook);
        add(optimized);


        fcfs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                seq=new ArrayList<>();
                seq.addAll(f.getSequence());
                JPanel chartPanel = createChartPanel("FCFS");
                chartPanel.setBounds(0, 60, 970, 500);
                add(chartPanel);
                chartPanel.revalidate();
                chartPanel.repaint();
            }
        });

        sstf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                seq=new ArrayList<>();
                seq.addAll(s.getSequence());
                JPanel chartPanel = createChartPanel("SSTF");
                chartPanel.setBounds(0, 60, 970, 500);
                add(chartPanel, BorderLayout.CENTER);
                chartPanel.revalidate();
                chartPanel.repaint();
            }
        });

        scan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                seq=new ArrayList<>();
                seq.addAll(scn.getSequence());
                JPanel chartPanel = createChartPanel("SCAN");
                chartPanel.setBounds(0, 60, 970, 500);
                add(chartPanel, BorderLayout.CENTER);
                chartPanel.revalidate();
                chartPanel.repaint();
            }
        });

        look.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                seq=new ArrayList<>();
                seq.addAll(l.getSequence());
                JPanel chartPanel = createChartPanel("LOOK");
                chartPanel.setBounds(0, 60, 970, 500);
                add(chartPanel, BorderLayout.CENTER);
                chartPanel.revalidate();
                chartPanel.repaint();
            }
        });
        cscan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                seq=new ArrayList<>();
                seq.addAll(cs.getSequence());
                JPanel chartPanel = createChartPanel("C-SCAN");
                chartPanel.setBounds(0, 60, 970, 500);
                add(chartPanel, BorderLayout.CENTER);
                chartPanel.revalidate();
                chartPanel.repaint();
            }
        });
        clook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                seq=new ArrayList<>();
                seq.addAll(cl.getSequence());
                JPanel chartPanel = createChartPanel("C-LOOK");
                chartPanel.setBounds(0, 60, 970, 500);
                add(chartPanel, BorderLayout.CENTER);
                chartPanel.revalidate();
                chartPanel.repaint();
            }
        });
        optimized.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                seq=new ArrayList<>();
                seq.addAll(opt.getSequence());
                JPanel chartPanel = createChartPanel("Optimized Algorithm");
                chartPanel.setBounds(0, 60, 970, 500);
                add(chartPanel, BorderLayout.CENTER);
                chartPanel.revalidate();
                chartPanel.repaint();
            }
        });
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private JPanel createChartPanel(String name) {

        DefaultCategoryDataset dataset = createDataset();
        name = "Head Movement Sequence of " + name;
        JFreeChart chart = ChartFactory.createLineChart(
                name, "", "Head position",
                dataset, PlotOrientation.HORIZONTAL, false, false, false
        );

        CategoryPlot plot = chart.getCategoryPlot();
        LineAndShapeRenderer renderer = new LineAndShapeRenderer();
        plot.setRenderer(renderer);

        return new ChartPanel(chart);
    }

    private DefaultCategoryDataset createDataset() {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int i = 0; i < seq.size(); i++) {

            dataset.addValue(seq.get(i),"",(i+1)+"");

        }

        return dataset;
    }
}


