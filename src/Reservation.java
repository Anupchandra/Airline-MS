import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;
import java.awt.event.ActionEvent;

public class Reservation extends JFrame {

	private JPanel contentPane;
	private JTextField tfdate;
	private JTextField tffname;
	private JTextField tflname;
	private JTextField tfage;
	private JTextField tfgender;
	private JTextField tfaddr;
	private JTextField tfphno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservation frame = new Reservation();
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
	public Reservation() {
		setTitle("Ticket Reservation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 424, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{114, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 27, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblFlightNumber = new JLabel("Flight Number:");
		GridBagConstraints gbc_lblFlightNumber = new GridBagConstraints();
		gbc_lblFlightNumber.anchor = GridBagConstraints.EAST;
		gbc_lblFlightNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblFlightNumber.gridx = 0;
		gbc_lblFlightNumber.gridy = 0;
		contentPane.add(lblFlightNumber, gbc_lblFlightNumber);
		
		JComboBox cbflight = new JComboBox();
		cbflight.setModel(new DefaultComboBoxModel(new String[] {"Bangalore to Delhi BADL84", "Bangalore to Mumbai BAMB86", "Chennai to Kolkata CHKL88", "Bangalore to Jaipur BAJP90", "Kochi to Mumbai KOMB92", "Bangalore to Kashmir BAKS94", "Bangalore to Dubai BADB96", "Bangalore to New York BANY98", "Bangalore to London BALN82"}));
		GridBagConstraints gbc_cbflight = new GridBagConstraints();
		gbc_cbflight.insets = new Insets(0, 0, 5, 5);
		gbc_cbflight.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbflight.gridx = 1;
		gbc_cbflight.gridy = 0;
		contentPane.add(cbflight, gbc_cbflight);
		
		JLabel lblTravelDate = new JLabel("Travel Date:");
		GridBagConstraints gbc_lblTravelDate = new GridBagConstraints();
		gbc_lblTravelDate.anchor = GridBagConstraints.EAST;
		gbc_lblTravelDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblTravelDate.gridx = 0;
		gbc_lblTravelDate.gridy = 1;
		contentPane.add(lblTravelDate, gbc_lblTravelDate);
		
		tfdate = new JTextField();
		GridBagConstraints gbc_tfdate = new GridBagConstraints();
		gbc_tfdate.insets = new Insets(0, 0, 5, 5);
		gbc_tfdate.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfdate.gridx = 1;
		gbc_tfdate.gridy = 1;
		contentPane.add(tfdate, gbc_tfdate);
		tfdate.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name:");
		GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
		gbc_lblFirstName.anchor = GridBagConstraints.EAST;
		gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstName.gridx = 0;
		gbc_lblFirstName.gridy = 2;
		contentPane.add(lblFirstName, gbc_lblFirstName);
		
		tffname = new JTextField();
		GridBagConstraints gbc_tffname = new GridBagConstraints();
		gbc_tffname.insets = new Insets(0, 0, 5, 5);
		gbc_tffname.fill = GridBagConstraints.HORIZONTAL;
		gbc_tffname.gridx = 1;
		gbc_tffname.gridy = 2;
		contentPane.add(tffname, gbc_tffname);
		tffname.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		GridBagConstraints gbc_lblLastName = new GridBagConstraints();
		gbc_lblLastName.anchor = GridBagConstraints.EAST;
		gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastName.gridx = 0;
		gbc_lblLastName.gridy = 3;
		contentPane.add(lblLastName, gbc_lblLastName);
		
		tflname = new JTextField();
		GridBagConstraints gbc_tflname = new GridBagConstraints();
		gbc_tflname.fill = GridBagConstraints.HORIZONTAL;
		gbc_tflname.insets = new Insets(0, 0, 5, 5);
		gbc_tflname.gridx = 1;
		gbc_tflname.gridy = 3;
		contentPane.add(tflname, gbc_tflname);
		tflname.setColumns(10);
		
		JLabel lblAge = new JLabel("Age:");
		GridBagConstraints gbc_lblAge = new GridBagConstraints();
		gbc_lblAge.anchor = GridBagConstraints.EAST;
		gbc_lblAge.insets = new Insets(0, 0, 5, 5);
		gbc_lblAge.gridx = 0;
		gbc_lblAge.gridy = 4;
		contentPane.add(lblAge, gbc_lblAge);
		
		tfage = new JTextField();
		GridBagConstraints gbc_tfage = new GridBagConstraints();
		gbc_tfage.insets = new Insets(0, 0, 5, 5);
		gbc_tfage.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfage.gridx = 1;
		gbc_tfage.gridy = 4;
		contentPane.add(tfage, gbc_tfage);
		tfage.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender:");
		GridBagConstraints gbc_lblGender = new GridBagConstraints();
		gbc_lblGender.anchor = GridBagConstraints.EAST;
		gbc_lblGender.insets = new Insets(0, 0, 5, 5);
		gbc_lblGender.gridx = 0;
		gbc_lblGender.gridy = 5;
		contentPane.add(lblGender, gbc_lblGender);
		
		tfgender = new JTextField();
		GridBagConstraints gbc_tfgender = new GridBagConstraints();
		gbc_tfgender.insets = new Insets(0, 0, 5, 5);
		gbc_tfgender.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfgender.gridx = 1;
		gbc_tfgender.gridy = 5;
		contentPane.add(tfgender, gbc_tfgender);
		tfgender.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address:");
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.anchor = GridBagConstraints.EAST;
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.gridx = 0;
		gbc_lblAddress.gridy = 6;
		contentPane.add(lblAddress, gbc_lblAddress);
		
		tfaddr = new JTextField();
		GridBagConstraints gbc_tfaddr = new GridBagConstraints();
		gbc_tfaddr.insets = new Insets(0, 0, 5, 5);
		gbc_tfaddr.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfaddr.gridx = 1;
		gbc_tfaddr.gridy = 6;
		contentPane.add(tfaddr, gbc_tfaddr);
		tfaddr.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		GridBagConstraints gbc_lblPhoneNumber = new GridBagConstraints();
		gbc_lblPhoneNumber.anchor = GridBagConstraints.EAST;
		gbc_lblPhoneNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoneNumber.gridx = 0;
		gbc_lblPhoneNumber.gridy = 7;
		contentPane.add(lblPhoneNumber, gbc_lblPhoneNumber);
		
		tfphno = new JTextField();
		GridBagConstraints gbc_tfphno = new GridBagConstraints();
		gbc_tfphno.insets = new Insets(0, 0, 5, 5);
		gbc_tfphno.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfphno.gridx = 1;
		gbc_tfphno.gridy = 7;
		contentPane.add(tfphno, gbc_tfphno);
		tfphno.setColumns(10);
		
		JLabel lblClass = new JLabel("Class:");
		GridBagConstraints gbc_lblClass = new GridBagConstraints();
		gbc_lblClass.anchor = GridBagConstraints.EAST;
		gbc_lblClass.insets = new Insets(0, 0, 5, 5);
		gbc_lblClass.gridx = 0;
		gbc_lblClass.gridy = 8;
		contentPane.add(lblClass, gbc_lblClass);
		
		JComboBox cbclass = new JComboBox();
		cbclass.setModel(new DefaultComboBoxModel(new String[] {"First Class", "Business Class", "Economy Class"}));
		GridBagConstraints gbc_cbclass = new GridBagConstraints();
		gbc_cbclass.insets = new Insets(0, 0, 5, 5);
		gbc_cbclass.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbclass.gridx = 1;
		gbc_cbclass.gridy = 8;
		contentPane.add(cbclass, gbc_cbclass);
		
		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 9;
		contentPane.add(label, gbc_label);
		
		JButton btnBookTickets = new JButton("Book Tickets");
		
		GridBagConstraints gbc_btnBookTickets = new GridBagConstraints();
		gbc_btnBookTickets.insets = new Insets(0, 0, 5, 0);
		gbc_btnBookTickets.gridwidth = 3;
		gbc_btnBookTickets.gridx = 0;
		gbc_btnBookTickets.gridy = 11;
		contentPane.add(btnBookTickets, gbc_btnBookTickets);
		
		JLabel lblNewLabel = new JLabel("Booking Confirmed");
		lblNewLabel.setVisible(false);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 12;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		btnBookTickets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setVisible(true);
				String flight = cbflight.getSelectedItem().toString();
				String fname = tffname.getText().toString();
				String lname = tflname.getText().toString();
				String date = tfdate.getText().toString();
				String class1 = cbclass.getSelectedItem().toString();
				String age = tfage.getText().toString();
				String phone = tfphno.getText();
				String gender = tfgender.getText().toString();
				String address = tfaddr.getText().toString();
				String status = "C";
				Random r = new Random();
				int pnr1 = r.nextInt(100000);
				
				try
				{
					Connection con = connect();
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","anupchandra");
					String query = "INSERT INTO RESERVATIONS VALUES(?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setInt(1,pnr1);
					ps.setString(2,flight);
					ps.setString(3,date);
					ps.setString(4,fname);
					ps.setString(5,lname);
					ps.setString(6,age);
					ps.setString(7,gender);
					ps.setString(8,address);
					ps.setString(9,phone);
					ps.setString(10,class1);
					ps.setString(11,status);
					ps.execute();
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
