import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainPanel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPanel frame = new MainPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainPanel() {
		setTitle("Main Menu");
		setBounds(100, 100, 342, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{100, 57, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 48, 0, 0, 0, 31, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblReservations = new JLabel("Bookings:");
		GridBagConstraints gbc_lblReservations = new GridBagConstraints();
		gbc_lblReservations.insets = new Insets(0, 0, 5, 5);
		gbc_lblReservations.gridx = 0;
		gbc_lblReservations.gridy = 0;
		contentPane.add(lblReservations, gbc_lblReservations);
		
		JButton btnReservations = new JButton("Ticket Reservation");
		btnReservations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reservation reserve = new Reservation();
				reserve.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnReservations = new GridBagConstraints();
		gbc_btnReservations.anchor = GridBagConstraints.WEST;
		gbc_btnReservations.insets = new Insets(0, 0, 5, 0);
		gbc_btnReservations.gridx = 2;
		gbc_btnReservations.gridy = 0;
		contentPane.add(btnReservations, gbc_btnReservations);
		
		JButton btnCancellations = new JButton("Ticket Cancellation");
		btnCancellations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cancellation cancel = new Cancellation();
				cancel.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnCancellations = new GridBagConstraints();
		gbc_btnCancellations.anchor = GridBagConstraints.WEST;
		gbc_btnCancellations.insets = new Insets(0, 0, 5, 0);
		gbc_btnCancellations.gridx = 2;
		gbc_btnCancellations.gridy = 1;
		contentPane.add(btnCancellations, gbc_btnCancellations);
		
		JLabel lblNewLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 2;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblEnquiry = new JLabel("Enquiry:");
		GridBagConstraints gbc_lblEnquiry = new GridBagConstraints();
		gbc_lblEnquiry.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnquiry.gridx = 0;
		gbc_lblEnquiry.gridy = 3;
		contentPane.add(lblEnquiry, gbc_lblEnquiry);
		
		JButton btnConfirmed = new JButton("Confirmed Passengers");
		btnConfirmed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Confirmed confirm = new Confirmed();
				confirm.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnConfirmed = new GridBagConstraints();
		gbc_btnConfirmed.insets = new Insets(0, 0, 5, 0);
		gbc_btnConfirmed.gridx = 2;
		gbc_btnConfirmed.gridy = 3;
		contentPane.add(btnConfirmed, gbc_btnConfirmed);
		
		JButton btnWaitlistedPassengers = new JButton("Waitlisted Passengers");
		btnWaitlistedPassengers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Waitlisted wait = new Waitlisted();
				wait.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnWaitlistedPassengers = new GridBagConstraints();
		gbc_btnWaitlistedPassengers.insets = new Insets(0, 0, 5, 0);
		gbc_btnWaitlistedPassengers.gridx = 2;
		gbc_btnWaitlistedPassengers.gridy = 4;
		contentPane.add(btnWaitlistedPassengers, gbc_btnWaitlistedPassengers);
		
		JButton btnAvailableFlights = new JButton("Seat Availability");
		GridBagConstraints gbc_btnAvailableFlights = new GridBagConstraints();
		gbc_btnAvailableFlights.anchor = GridBagConstraints.WEST;
		gbc_btnAvailableFlights.insets = new Insets(0, 0, 5, 0);
		gbc_btnAvailableFlights.gridx = 2;
		gbc_btnAvailableFlights.gridy = 5;
		contentPane.add(btnAvailableFlights, gbc_btnAvailableFlights);
		
		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 2;
		gbc_label.gridy = 6;
		contentPane.add(label, gbc_label);
		
		JButton btnClose = new JButton("Close");
		GridBagConstraints gbc_btnClose = new GridBagConstraints();
		gbc_btnClose.gridwidth = 3;
		gbc_btnClose.gridx = 0;
		gbc_btnClose.gridy = 7;
		contentPane.add(btnClose, gbc_btnClose);
	}

}
