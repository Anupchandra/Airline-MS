import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.awt.Insets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;

public class TicketStatus extends JFrame {

	private JPanel contentPane;
	private JTextField tfpnr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicketStatus frame = new TicketStatus();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connect()
	{
		try
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","anupchandra");
			return con;
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
			return null;
		}
	}
	/**
	 * Create the frame.
	 */
	public TicketStatus() {
		setTitle("Ticket Status");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 197);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{205, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{16, 0, 0, 0, 24, 23, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		contentPane.add(label, gbc_label);
		
		JLabel lblEnterBookingticketNumber = new JLabel("Enter Booking/Ticket number: ");
		lblEnterBookingticketNumber.setForeground(Color.WHITE);
		lblEnterBookingticketNumber.setFont(new Font("Arial Black", Font.PLAIN, 11));
		GridBagConstraints gbc_lblEnterBookingticketNumber = new GridBagConstraints();
		gbc_lblEnterBookingticketNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterBookingticketNumber.anchor = GridBagConstraints.EAST;
		gbc_lblEnterBookingticketNumber.gridx = 0;
		gbc_lblEnterBookingticketNumber.gridy = 1;
		contentPane.add(lblEnterBookingticketNumber, gbc_lblEnterBookingticketNumber);
		
		tfpnr = new JTextField();
		tfpnr.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GridBagConstraints gbc_tfpnr = new GridBagConstraints();
		gbc_tfpnr.insets = new Insets(0, 0, 5, 0);
		gbc_tfpnr.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfpnr.gridx = 2;
		gbc_tfpnr.gridy = 1;
		contentPane.add(tfpnr, gbc_tfpnr);
		tfpnr.setColumns(10);
		
		JButton btnNewButton = new JButton("Check Status");
		
		btnNewButton.setBackground(new Color(0, 0, 153));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 11));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridwidth = 3;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 3;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		JLabel lblProcessing = new JLabel("Processing..");
		lblProcessing.setVisible(false);
		
		JLabel lblInvalidTicketNumber = new JLabel("Invalid Ticket Number!");
		lblInvalidTicketNumber.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblInvalidTicketNumber.setForeground(Color.WHITE);
		lblInvalidTicketNumber.setVisible(false);
		GridBagConstraints gbc_lblInvalidTicketNumber = new GridBagConstraints();
		gbc_lblInvalidTicketNumber.gridwidth = 3;
		gbc_lblInvalidTicketNumber.insets = new Insets(0, 0, 5, 0);
		gbc_lblInvalidTicketNumber.gridx = 0;
		gbc_lblInvalidTicketNumber.gridy = 4;
		contentPane.add(lblInvalidTicketNumber, gbc_lblInvalidTicketNumber);
		lblProcessing.setForeground(Color.WHITE);
		lblProcessing.setFont(new Font("Arial Black", Font.PLAIN, 11));
		GridBagConstraints gbc_lblProcessing = new GridBagConstraints();
		gbc_lblProcessing.insets = new Insets(0, 0, 0, 5);
		gbc_lblProcessing.gridx = 0;
		gbc_lblProcessing.gridy = 5;
		contentPane.add(lblProcessing, gbc_lblProcessing);
		
		JProgressBar progressBar = new JProgressBar();
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.gridx = 2;
		gbc_progressBar.gridy = 5;
		contentPane.add(progressBar, gbc_progressBar);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String pnr = tfpnr.getText().toString();
				try
				{
					Connection con = connect();
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","anupchandra");
					String query = "Select * from RESERVATIONS where PNR = ?";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1,pnr);
					ResultSet rs = ps.executeQuery();
					if(!rs.next())
					{
						lblInvalidTicketNumber.setVisible(true);
					}
					else
					{	String query1 = "Select * from RESERVATIONS where PNR = ?";
						PreparedStatement ps2 = con.prepareStatement(query1);
						ps2.setString(1,pnr);
						ResultSet rs1 = ps.executeQuery();
						lblProcessing.setVisible(true);
						Object data1[][] = new Object[1][11];
						Object[] Colheads={"PNR","FLIGHT NO","TRAVEL DATE","FIRST NAME","LAST NAME","AGE","GENDER","ADDRESS","PHONE NUMBER","CLASS","STATUS"};
						for(int i1=0;i1<1;i1++)
						{
								rs1.next();
								for(int j1=0;j1<11;j1++)
								{
									data1[i1][j1]=rs1.getString(j1+1);
								}
						}
						JTable table=new JTable(data1,Colheads);
						int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
						int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
						JScrollPane jsp=new JScrollPane(table,v,h);
						Display disp = new Display();
						disp.getContentPane().add(jsp);
						disp.setVisible(true);
						ps2.close();
					}
					ps.close();
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

}
