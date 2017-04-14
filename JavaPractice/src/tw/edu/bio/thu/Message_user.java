package tw.edu.bio.thu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Message_user extends JFrame{
	private JButton send;
	private JTextArea messageWindows = new JTextArea();
	private JTextField stringSend = new JTextField(40);
	private String IP;
	
	public static void main(String[] args) {
		new Message_user();

	}
	
	Message_user()
	{
		setLayout(new BorderLayout());
				
		send = new JButton("Send");
		send.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				new sendMessage(stringSend.getText());		
			}
		});
		
		JPanel down = new JPanel(new FlowLayout());
		down.add(stringSend); down.add(send);
		
		add(down,BorderLayout.SOUTH);
		
		JPanel left = new JPanel(new FlowLayout());
		JPanel right = new JPanel(new FlowLayout());
		JPanel top = new JPanel(new FlowLayout());
		
		add(top, BorderLayout.NORTH);
		add(right, BorderLayout.WEST);
		add(left, BorderLayout.EAST);
		
		setSize(640,480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(messageWindows,BorderLayout.CENTER);
//		IP = JOptionPane.showInputDialog("Input a IP you want to send to:");
		new getMessage();
		
	}
	
	class sendMessage
	{
		byte[] sendingBuffer;

		public sendMessage()
		{
			this("");
		}
		public sendMessage(String sendMessage) {
			try
			{
				sendingBuffer = sendMessage.getBytes();	
				Socket ssocket = new Socket(InetAddress.getByName("192.168.1.171"),4444);
				OutputStream oout = ssocket.getOutputStream();
				oout.write(sendingBuffer);
				stringSend.setText(null);
				oout.flush();
				oout.close();
				ssocket.close();
				System.out.println("ok");

			}catch(Exception e)
			{
				System.out.println(e.toString());
			}
		}
	}

	class getMessage
	{
		byte[] gettingBuffer = new byte[4096];

		public getMessage() {
			while(true)
			{
				try
				{
					ServerSocket sgsocket = new ServerSocket(4444);
					Socket ssocket = sgsocket.accept();
					BufferedReader buf = new BufferedReader(new InputStreamReader(ssocket.getInputStream()));
					String gString;
					while((gString = buf.readLine()) != null)
					{
						String hostAddress = ssocket.getInetAddress().getHostAddress();
						messageWindows.append(hostAddress + ":" + gString + " (" + new Date().toString() + ") " +'\n');
					}
					System.out.println("ok");
					ssocket.close();
					sgsocket.close();
					
				}catch(Exception e)
				{
					System.out.println(e.toString());
				}
			}
		}
	}

}
