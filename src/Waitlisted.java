import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Waitlisted extends JFrame {

	private JPanel contentPane;
	private JTextField tfdate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Waitlisted frame = new Waitlisted();
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
	public Waitlisted() {
		setTitle("Waitlisted Passengers");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 335, 227);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{129, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 25, 0, 24, 0, 18, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblSelectFlight = new JLabel("Select Flight:");
		GridBagConstraints gbc_lblSelectFlight = new GridBagConstraints();
		gbc_lblSelectFlight.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelectFlight.anchor = GridBagConstraints.EAST;
		gbc_lblSelectFlight.gridx = 0;
		gbc_lblSelectFlight.gridy = 0;
		contentPane.add(lblSelectFlight, gbc_lblSelectFlight);
		
		JComboBox cbflno = new JComboBox();
		cbflno.setModel(new DefaultComboBoxModel(new String[] {"Bangalore to Delhi BADL84", "Bangalore to Mumbai BAMB86", "Chennai to Kolkata CHKL88", "Bangalore to Jaipur BAJP90", "Kochi to Mumbai KOMB92", "Bangalore to Kashmir BAKS94", "Bangalore to Dubai BADB96", "Bangalore to New York BANY98", "Bangalore to London BALN82"}));
		GridBagConstraints gbc_cbflno = new GridBagConstraints();
		gbc_cbflno.insets = new Insets(0, 0, 5, 5);
		gbc_cbflno.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbflno.gridx = 1;
		gbc_cbflno.gridy = 0;
		contentPane.add(cbflno, gbc_cbflno);
		
		JLabel lblNewLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblEnterTravelDate = new JLabel("Enter Travel Date:");
		GridBagConstraints gbc_lblEnterTravelDate = new GridBagConstraints();
		gbc_lblEnterTravelDate.anchor = GridBagConstraints.EAST;
		gbc_lblEnterTravelDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterTravelDate.gridx = 0;
		gbc_lblEnterTravelDate.gridy = 2;
		contentPane.add(lblEnterTravelDate, gbc_lblEnterTravelDate);
		
		tfdate = new JTextField();
		GridBagConstraints gbc_tfdate = new GridBagConstraints();
		gbc_tfdate.insets = new Insets(0, 0, 5, 5);
		gbc_tfdate.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfdate.gridx = 1;
		gbc_tfdate.gridy = 2;
		contentPane.add(tfdate, gbc_tfdate);
		tfdate.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 3;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JButton btnCheckStatus = new JButton("Check Status");
		
		GridBagConstraints gbc_btnCheckStatus = new GridBagConstraints();
		gbc_btnCheckStatus.insets = new Insets(0, 0, 5, 5);
		gbc_btnCheckStatus.gridwidth = 2;
		gbc_btnCheckStatus.gridx = 0;
		gbc_btnCheckStatus.gridy = 4;
		contentPane.add(btnCheckStatus, gbc_btnCheckStatus);
		
		JLabel lblRetrievingDetails = new JLabel("Retrieving Details....");
		lblRetrievingDetails.setVisible(false);
		
		JLabel lblNoDataReturned = new JLabel("No Data Returned.");
		lblNoDataReturned.setVisible(false);
		GridBagConstraints gbc_lblNoDataReturned = new GridBagConstraints();
		gbc_lblNoDataReturned.gridwidth = 3;
		gbc_lblNoDataReturned.insets = new Insets(0, 0, 5, 5);
		gbc_lblNoDataReturned.gridx = 0;
		gbc_lblNoDataReturned.gridy = 5;
		contentPane.add(lblNoDataReturned, gbc_lblNoDataReturned);
		GridBagConstraints gbc_lblRetrievingDetails = new GridBagConstraints();
		gbc_lblRetrievingDetails.gridwidth = 3;
		gbc_lblRetrievingDetails.gridx = 0;
		gbc_lblRetrievingDetails.gridy = 6;
		contentPane.add(lblRetrievingDetails, gbc_lblRetrievingDetails);
		
		btnCheckStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String flight = cbflno.getSelectedItem().toString();
				String date = tfdate.getText().toString();
				int rows = 0;
				
				try
				{
					Connection con = connect();
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","anupchandra");
					String query = "SELECT * FROM RESERVATIONS WHERE FLIGHTNO =? AND TDATE=? AND STATUS='W'";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1,flight);
					ps.setString(2,date);
					ResultSet rs = ps.executeQuery();
					/* boolean records = rs.next();
					if (!records ) 
					{
						lbldata.setVisible(true);
					} */
					while(rs.next())
					{
						rows++;
					}
					if(rows==0)
					{
						lblNoDataReturned.setVisible(true);
					}
					else
					{
					Object data1[][] = new Object[rows][11];
					lblRetrievingDetails.setVisible(true);
					Object[] Colheads={"PNR","FLIGHT NO","TRAVEL DATE","FIRST NAME","LAST NAME","AGE","GENDER","ADDRESS","PHONE NUMBER","CLASS","STATUS"};
					String query1 = "SELECT * FROM RESERVATIONS WHERE FLIGHTNO =? AND TDATE =? AND STATUS = 'W'";
					PreparedStatement ps1 = con.prepareStatement(query1);
					ps1.setString(1,flight);
					ps1.setString(2,date);
					ResultSet rs1 = ps1.executeQuery();	
					for(int i1=0;i1<rows;i1++)
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
					
					ps.close();
					ps1.close();
					rs.close();
					rs1.close();
					}
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
				
			}
		});
	}

}
