package tw.edu.bio.thu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SequenceAnalysisTool extends JFrame{
	private JButton open, save, exit, GCanalysis;
	private Class_Sequence sp1;
	private JFileChooser filechooser = new JFileChooser();
	private JTextArea showfile = new JTextArea();
	private String sequence;
	
	
	
	public SequenceAnalysisTool() {
		
		setLayout(new BorderLayout());
		
		open = new JButton("open");
		open.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				filechooser.showOpenDialog(null);
				File inputfile = filechooser.getSelectedFile();
				
				try
				{
					FileReader fr = new FileReader(inputfile);
					BufferedReader br = new BufferedReader(fr);
					
					while((sequence = br.readLine()) != null)
					{
						showfile.append(sequence + '\n');
						sp1 = new Class_Sequence(sequence);
					}
					
					fr.close();
					
				}
				catch(Exception ee)
				{
					System.out.println(ee.toString());
				}
				
				
			}
		});
		
		
		save = new JButton("save");
		exit = new JButton("exit");
				
		JPanel top = new JPanel(new FlowLayout());
		top.add(open); top.add(save); top.add(exit);
		
		GCanalysis = new JButton("GCanalysis");
		GCanalysis.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				sp1.meansureGCcontent();
				showfile.append("" + sp1.getGCcontent());
			}
		});
		
		JPanel left = new JPanel(new FlowLayout());
		left.add(GCanalysis);
		
		add(top,BorderLayout.NORTH);
		add(left,BorderLayout.WEST);
		add(showfile,BorderLayout.CENTER);
					
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
			
	}
	
class Class_Sequence 
{
	private double GCcontent;
	private String inputSequence; 
				
	Class_Sequence(String inputSequence)
	{
		this.inputSequence = inputSequence;
		sequenceCheck(inputSequence);
	}


//-----序列確認-----
		
	//確認輸入的sequence是否符合atcg或ATCG
	void sequenceCheck(String sequence)
	{
		if(sequence.matches("^[ATCGatcg]{1,}$") )
		{
			showfile.append("Sequence OK" + '\n');
		}
		else
		{
			showfile.append("Incorrect input!" + '\n');
		}
	}
		
//-----GC content相關-----
		
	//計算GC content
	void meansureGCcontent()
	{
//		for(int i = 0; i < inputSequence.length(); i++)
//		{
//			if(inputSequence.charAt(i) == '[cG]')
//			{
//				
//			}
//		}
	}
		
	//取得GC content
	double getGCcontent()
	{
		return GCcontent;
	}
		
}
	
}
