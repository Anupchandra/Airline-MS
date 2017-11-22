import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Waitlisted extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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

	/**
	 * Create the frame.
	 */
	public Waitlisted() {
		setTitle("Waitlisted Passengers");
<<<<<<< HEAD
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 335, 227);
=======
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 335, 218);
>>>>>>> parent of 27e2cac... Next Commit xD
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Bangalore to Delhi BADL84", "Bangalore to Mumbai BAMB86", "Chennai to Kolkata CHKL88", "Bangalore to Jaipur BAJP90", "Kochi to Mumbai KOMB92", "Bangalore to Kashmir BAKS94", "Bangalore to Dubai BADB96", "Bangalore to New York BANY98", "Bangalore to London BALN82"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		contentPane.add(comboBox, gbc_comboBox);
		
		JLabel lblNewLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
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
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 3;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JButton btnCheckStatus = new JButton("Check Status");
		
		GridBagConstraints gbc_btnCheckStatus = new GridBagConstraints();
		gbc_btnCheckStatus.insets = new Insets(0, 0, 5, 0);
		gbc_btnCheckStatus.gridwidth = 2;
		gbc_btnCheckStatus.gridx = 0;
		gbc_btnCheckStatus.gridy = 4;
		contentPane.add(btnCheckStatus, gbc_btnCheckStatus);
		
		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 1;
		gbc_label.gridy = 5;
		contentPane.add(label, gbc_label);
		
		JLabel lblRetrievingDetails = new JLabel("Retrieving Details....");
		lblRetrievingDetails.setVisible(false);
		GridBagConstraints gbc_lblRetrievingDetails = new GridBagConstraints();
		gbc_lblRetrievingDetails.gridwidth = 3;
		gbc_lblRetrievingDetails.gridx = 0;
		gbc_lblRetrievingDetails.gridy = 6;
		contentPane.add(lblRetrievingDetails, gbc_lblRetrievingDetails);
		
		btnCheckStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblRetrievingDetails.setVisible(true);
			}
		});
	}

}
