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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Cancellation extends JFrame {

	private JPanel contentPane;
	private JTextField tfpnr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cancellation frame = new Cancellation();
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
	public Cancellation() {
		setTitle("Ticket Cancellation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 359, 147);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{162, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 24, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblEnterTheTicket = new JLabel("Enter PNR Number:");
		GridBagConstraints gbc_lblEnterTheTicket = new GridBagConstraints();
		gbc_lblEnterTheTicket.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterTheTicket.anchor = GridBagConstraints.EAST;
		gbc_lblEnterTheTicket.gridx = 0;
		gbc_lblEnterTheTicket.gridy = 0;
		contentPane.add(lblEnterTheTicket, gbc_lblEnterTheTicket);
		
		tfpnr = new JTextField();
		GridBagConstraints gbc_tfpnr = new GridBagConstraints();
		gbc_tfpnr.insets = new Insets(0, 0, 5, 0);
		gbc_tfpnr.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfpnr.gridx = 1;
		gbc_tfpnr.gridy = 0;
		contentPane.add(tfpnr, gbc_tfpnr);
		tfpnr.setColumns(10);
		
		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 1;
		gbc_label.gridy = 1;
		contentPane.add(label, gbc_label);
		
		JButton btnCancelTicket = new JButton("Cancel Ticket");
		
		GridBagConstraints gbc_btnCancelTicket = new GridBagConstraints();
		gbc_btnCancelTicket.insets = new Insets(0, 0, 5, 0);
		gbc_btnCancelTicket.gridwidth = 2;
		gbc_btnCancelTicket.gridx = 0;
		gbc_btnCancelTicket.gridy = 2;
		contentPane.add(btnCancelTicket, gbc_btnCancelTicket);
		
		JLabel lblNewLabel = new JLabel("Booking Cancelled.");
		lblNewLabel.setVisible(false);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		btnCancelTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setVisible(true);
				int pnr = Integer.parseInt(tfpnr.getText());
				String query = "DELETE FROM RESERVATIONS WHERE PNR=?";
				try
				{
					Connection con = connect();
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","anupchandra");
					PreparedStatement ps1 = con.prepareStatement(query);
					ps1.setInt(1,pnr);
					ps1.executeUpdate();
					ps1.close();
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
	}

}
