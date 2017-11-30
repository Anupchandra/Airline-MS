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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FlightQuery extends JFrame {

	private JPanel contentPane;
	private JTextField tfdate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlightQuery frame = new FlightQuery();
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
	public FlightQuery() {
		setTitle("Flight Query ");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 356, 193);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{114, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 19, 0, 23, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Select Flight:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 11));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JComboBox cbflightno = new JComboBox();
		cbflightno.setBackground(new Color(0, 0, 102));
		cbflightno.setForeground(Color.WHITE);
		cbflightno.setFont(new Font("Arial Black", Font.PLAIN, 11));
		cbflightno.setModel(new DefaultComboBoxModel(new String[] {"Bangalore to Delhi BADL84", "Bangalore to Mumbai BAMB86", "Chennai to Kolkata CHKL88", "Bangalore to Jaipur BAJP90", "Kochi to Mumbai KOMB92", "Bangalore to Kashmir BAKS94", "Bangalore to Dubai BADB96", "Bangalore to New York BANY98", "Bangalore to London BALN82"}));
		GridBagConstraints gbc_cbflightno = new GridBagConstraints();
		gbc_cbflightno.insets = new Insets(0, 0, 5, 0);
		gbc_cbflightno.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbflightno.gridx = 1;
		gbc_cbflightno.gridy = 0;
		contentPane.add(cbflightno, gbc_cbflightno);
		
		JLabel lblNewLabel_1 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblEnterDate = new JLabel("Enter Date:");
		lblEnterDate.setForeground(Color.WHITE);
		lblEnterDate.setFont(new Font("Arial Black", Font.PLAIN, 11));
		GridBagConstraints gbc_lblEnterDate = new GridBagConstraints();
		gbc_lblEnterDate.anchor = GridBagConstraints.EAST;
		gbc_lblEnterDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterDate.gridx = 0;
		gbc_lblEnterDate.gridy = 2;
		contentPane.add(lblEnterDate, gbc_lblEnterDate);
		
		tfdate = new JTextField();
		GridBagConstraints gbc_tfdate = new GridBagConstraints();
		gbc_tfdate.insets = new Insets(0, 0, 5, 0);
		gbc_tfdate.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfdate.gridx = 1;
		gbc_tfdate.gridy = 2;
		contentPane.add(tfdate, gbc_tfdate);
		tfdate.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 3;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JButton btnNewButton = new JButton("QueryDetails");
		
		btnNewButton.setBackground(new Color(0, 0, 102));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 11));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 4;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		JLabel lblProcessing = new JLabel("Processing....");
		lblProcessing.setVisible(false);
		lblProcessing.setForeground(Color.WHITE);
		lblProcessing.setFont(new Font("Arial Black", Font.PLAIN, 11));
		GridBagConstraints gbc_lblProcessing = new GridBagConstraints();
		gbc_lblProcessing.gridwidth = 2;
		gbc_lblProcessing.gridx = 0;
		gbc_lblProcessing.gridy = 5;
		contentPane.add(lblProcessing, gbc_lblProcessing);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String flightno = cbflightno.getSelectedItem().toString();
				String date = tfdate.getText().toString();
				Connection con = connect();
				try
				{
					String query = "UPDATE FLIGHTS SET FLIGHTNO = ?,FLDATE = ?";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1,flightno);
					ps.setString(2,date);
					ps.execute();
					//ps.close();
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				try
				{
					String query1 = "Select * from Flights";
					PreparedStatement ps2 = con.prepareStatement(query1);
					ResultSet rs1 = ps2.executeQuery();
					lblProcessing.setVisible(true);
					Object data1[][] = new Object[1][8];
					Object[] Colheads={"FLIGHT NO","TRAVEL DATE","FIRST CLASS SEATS","BUSINESS CLASS SEATS","ECONOMY CLASS SEATS","FC PRICE","BC PRICE","EC PRICE"};
					for(int i1=0;i1<1;i1++)
					{
							rs1.next();
							for(int j1=0;j1<8;j1++)
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
					//ps2.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		
		
	}

}
