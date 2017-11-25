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
import java.awt.Color;
import java.awt.Font;

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
		setBounds(100, 100, 444, 382);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{100, 57, 130, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 48, 0, 0, 0, 31, 35, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblReservations = new JLabel("Bookings:");
		lblReservations.setForeground(Color.WHITE);
		lblReservations.setFont(new Font("Arial Black", Font.PLAIN, 11));
		GridBagConstraints gbc_lblReservations = new GridBagConstraints();
		gbc_lblReservations.insets = new Insets(0, 0, 5, 5);
		gbc_lblReservations.gridx = 0;
		gbc_lblReservations.gridy = 0;
		contentPane.add(lblReservations, gbc_lblReservations);
		
		JButton btnReservations = new JButton("Ticket Reservation");
		btnReservations.setBackground(new Color(0, 0, 102));
		btnReservations.setForeground(Color.WHITE);
		btnReservations.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnReservations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reservation reserve = new Reservation();
				reserve.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnReservations = new GridBagConstraints();
		gbc_btnReservations.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnReservations.insets = new Insets(0, 0, 5, 5);
		gbc_btnReservations.gridx = 2;
		gbc_btnReservations.gridy = 0;
		contentPane.add(btnReservations, gbc_btnReservations);
		
		JButton btnCancellations = new JButton("Ticket Cancellation");
		btnCancellations.setBackground(new Color(0, 0, 102));
		btnCancellations.setForeground(Color.WHITE);
		btnCancellations.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnCancellations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cancellation cancel = new Cancellation();
				cancel.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnCancellations = new GridBagConstraints();
		gbc_btnCancellations.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancellations.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancellations.gridx = 2;
		gbc_btnCancellations.gridy = 1;
		contentPane.add(btnCancellations, gbc_btnCancellations);
		
		JButton btnRescheduleTicket = new JButton("Reschedule Ticket");
		btnRescheduleTicket.setBackground(new Color(0, 0, 102));
		btnRescheduleTicket.setForeground(Color.WHITE);
		btnRescheduleTicket.setFont(new Font("Arial Black", Font.PLAIN, 11));
		
		GridBagConstraints gbc_btnRescheduleTicket = new GridBagConstraints();
		gbc_btnRescheduleTicket.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRescheduleTicket.insets = new Insets(0, 0, 5, 5);
		gbc_btnRescheduleTicket.gridx = 2;
		gbc_btnRescheduleTicket.gridy = 2;
		contentPane.add(btnRescheduleTicket, gbc_btnRescheduleTicket);
		
		JLabel lblNewLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 3;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblEnquiry = new JLabel("Enquiry:");
		lblEnquiry.setForeground(Color.WHITE);
		lblEnquiry.setFont(new Font("Arial Black", Font.PLAIN, 11));
		GridBagConstraints gbc_lblEnquiry = new GridBagConstraints();
		gbc_lblEnquiry.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnquiry.gridx = 0;
		gbc_lblEnquiry.gridy = 4;
		contentPane.add(lblEnquiry, gbc_lblEnquiry);
		
		JButton btnConfirmed = new JButton("Confirmed Passengers");
		btnConfirmed.setBackground(new Color(0, 0, 102));
		btnConfirmed.setForeground(Color.WHITE);
		btnConfirmed.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnConfirmed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Confirmed confirm = new Confirmed();
				confirm.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnConfirmed = new GridBagConstraints();
		gbc_btnConfirmed.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnConfirmed.insets = new Insets(0, 0, 5, 5);
		gbc_btnConfirmed.gridx = 2;
		gbc_btnConfirmed.gridy = 4;
		contentPane.add(btnConfirmed, gbc_btnConfirmed);
		
		JButton btnWaitlistedPassengers = new JButton("Waitlisted Passengers");
		btnWaitlistedPassengers.setBackground(new Color(0, 0, 102));
		btnWaitlistedPassengers.setForeground(Color.WHITE);
		btnWaitlistedPassengers.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnWaitlistedPassengers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Waitlisted wait = new Waitlisted();
				wait.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnWaitlistedPassengers = new GridBagConstraints();
		gbc_btnWaitlistedPassengers.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnWaitlistedPassengers.insets = new Insets(0, 0, 5, 5);
		gbc_btnWaitlistedPassengers.gridx = 2;
		gbc_btnWaitlistedPassengers.gridy = 5;
		contentPane.add(btnWaitlistedPassengers, gbc_btnWaitlistedPassengers);
		
		JButton btnAvailableFlights = new JButton("Flight Enquiry");
		
		btnAvailableFlights.setBackground(new Color(0, 0, 102));
		btnAvailableFlights.setForeground(Color.WHITE);
		btnAvailableFlights.setFont(new Font("Arial Black", Font.PLAIN, 11));
		GridBagConstraints gbc_btnAvailableFlights = new GridBagConstraints();
		gbc_btnAvailableFlights.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAvailableFlights.insets = new Insets(0, 0, 5, 5);
		gbc_btnAvailableFlights.gridx = 2;
		gbc_btnAvailableFlights.gridy = 6;
		contentPane.add(btnAvailableFlights, gbc_btnAvailableFlights);
		
		JButton btnTicketStatus = new JButton("Ticket Status");
		btnTicketStatus.setBackground(new Color(0, 0, 102));
		btnTicketStatus.setForeground(Color.WHITE);
		btnTicketStatus.setFont(new Font("Arial Black", Font.PLAIN, 11));
		
		GridBagConstraints gbc_btnTicketStatus = new GridBagConstraints();
		gbc_btnTicketStatus.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnTicketStatus.insets = new Insets(0, 0, 5, 5);
		gbc_btnTicketStatus.gridx = 2;
		gbc_btnTicketStatus.gridy = 7;
		contentPane.add(btnTicketStatus, gbc_btnTicketStatus);
		
		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 8;
		contentPane.add(label, gbc_label);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBackground(new Color(0, 0, 102));
		btnClose.setForeground(Color.WHITE);
		btnClose.setFont(new Font("Arial Black", Font.PLAIN, 11));
		GridBagConstraints gbc_btnClose = new GridBagConstraints();
		gbc_btnClose.gridwidth = 6;
		gbc_btnClose.gridx = 0;
		gbc_btnClose.gridy = 9;
		contentPane.add(btnClose, gbc_btnClose);
		
		btnTicketStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TicketStatus ticket = new TicketStatus();
				ticket.setVisible(true);
			}
		});
		
		btnRescheduleTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Reschedule res = new Reschedule();
				res.setVisible(true);
			}
		});
		
		btnAvailableFlights.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FlightQuery query = new FlightQuery();
				query.setVisible(true);
			}
		});
	}

}
