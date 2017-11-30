import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.BevelBorder;

public class Reschedule extends JFrame {

	private JPanel contentPane;
	private JTextField tfpnr;
	private JTextField tfnewdate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reschedule frame = new Reschedule();
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
	public Reschedule() {
		setTitle("Reschedule Tickets");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 223);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{191, 0, 0};
		gbl_contentPane.rowHeights = new int[]{23, 20, 0, 20, 35, 24, 23, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblEnterBookingticketNumber = new JLabel("Enter Booking/Ticket Number:");
		lblEnterBookingticketNumber.setForeground(Color.WHITE);
		lblEnterBookingticketNumber.setFont(new Font("Arial Black", Font.PLAIN, 11));
		GridBagConstraints gbc_lblEnterBookingticketNumber = new GridBagConstraints();
		gbc_lblEnterBookingticketNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterBookingticketNumber.anchor = GridBagConstraints.EAST;
		gbc_lblEnterBookingticketNumber.gridx = 0;
		gbc_lblEnterBookingticketNumber.gridy = 0;
		contentPane.add(lblEnterBookingticketNumber, gbc_lblEnterBookingticketNumber);
		
		tfpnr = new JTextField();
		tfpnr.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GridBagConstraints gbc_tfpnr = new GridBagConstraints();
		gbc_tfpnr.insets = new Insets(0, 0, 5, 0);
		gbc_tfpnr.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfpnr.gridx = 1;
		gbc_tfpnr.gridy = 0;
		contentPane.add(tfpnr, gbc_tfpnr);
		tfpnr.setColumns(10);
		
		JLabel label_1 = new JLabel("");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 1;
		contentPane.add(label_1, gbc_label_1);
		
		JLabel lblEnterTentativeReschedule = new JLabel("Enter tentative Reschedule Date:");
		lblEnterTentativeReschedule.setForeground(Color.WHITE);
		lblEnterTentativeReschedule.setFont(new Font("Arial Black", Font.PLAIN, 11));
		GridBagConstraints gbc_lblEnterTentativeReschedule = new GridBagConstraints();
		gbc_lblEnterTentativeReschedule.anchor = GridBagConstraints.EAST;
		gbc_lblEnterTentativeReschedule.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterTentativeReschedule.gridx = 0;
		gbc_lblEnterTentativeReschedule.gridy = 2;
		contentPane.add(lblEnterTentativeReschedule, gbc_lblEnterTentativeReschedule);
		
		tfnewdate = new JTextField();
		tfnewdate.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GridBagConstraints gbc_tfnewdate = new GridBagConstraints();
		gbc_tfnewdate.insets = new Insets(0, 0, 5, 0);
		gbc_tfnewdate.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfnewdate.gridx = 1;
		gbc_tfnewdate.gridy = 2;
		contentPane.add(tfnewdate, gbc_tfnewdate);
		tfnewdate.setColumns(10);
		
		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 3;
		contentPane.add(label, gbc_label);
		
		JButton btnNewButton = new JButton("Reschedule Ticket");
		btnNewButton.setBackground(new Color(0, 0, 153));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 11));
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 4;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Invalid Booking/Ticket Number!");
		lblNewLabel.setVisible(false);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 11));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 5;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblTicketRescheduled = new JLabel("Ticket Rescheduled!");
		lblTicketRescheduled.setVisible(false);
		lblTicketRescheduled.setForeground(Color.WHITE);
		lblTicketRescheduled.setFont(new Font("Arial Black", Font.PLAIN, 11));
		GridBagConstraints gbc_lblTicketRescheduled = new GridBagConstraints();
		gbc_lblTicketRescheduled.insets = new Insets(0, 0, 0, 5);
		gbc_lblTicketRescheduled.gridx = 0;
		gbc_lblTicketRescheduled.gridy = 6;
		contentPane.add(lblTicketRescheduled, gbc_lblTicketRescheduled);
		
		JLabel lblPleaseEnterThe = new JLabel("Please enter the correct Date Format!");
		lblPleaseEnterThe.setVisible(false);
		lblPleaseEnterThe.setForeground(Color.WHITE);
		lblPleaseEnterThe.setFont(new Font("Arial Black", Font.PLAIN, 11));
		GridBagConstraints gbc_lblPleaseEnterThe = new GridBagConstraints();
		gbc_lblPleaseEnterThe.gridx = 1;
		gbc_lblPleaseEnterThe.gridy = 6;
		contentPane.add(lblPleaseEnterThe, gbc_lblPleaseEnterThe);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pnr = tfpnr.getText().toString();
				String date = tfnewdate.getText().toString();
				if(pnr.equals(""))
				{
					lblNewLabel.setVisible(true);
				}
				String datePattern = "\\d{2}-\\d{2}-\\d{4}";
				Boolean isDate2 = date.matches(datePattern);
				if(isDate2)
				{
				try
				{
					Connection con = connect();
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","anupchandra");
					String query = "UPDATE RESERVATIONS SET TDATE = ? WHERE PNR = ?";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1,date);
					ps.setString(2,pnr);
					ps.execute();
					ps.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				}
				else
				{
					lblPleaseEnterThe.setVisible(true);
				}
			}
		});
	}

}
