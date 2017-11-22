import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

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
import javax.swing.JPasswordField;

public class LoginPanel extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPanel frame = new LoginPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			public void close()
			{
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginPanel() {
		setTitle("Login Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 244, 190);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{84, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblUsername = new JLabel("UserName: ");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.anchor = GridBagConstraints.EAST;
		gbc_lblUsername.gridx = 0;
		gbc_lblUsername.gridy = 1;
		contentPane.add(lblUsername, gbc_lblUsername);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 2;
		contentPane.add(lblPassword, gbc_lblPassword);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 2;
		contentPane.add(passwordField, gbc_passwordField);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridwidth = 3;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 4;
		contentPane.add(btnNewButton, gbc_btnNewButton);
<<<<<<< HEAD
		
		JLabel lblInvalidLoginCredentials = new JLabel("Invalid Login Credentials!");
		lblInvalidLoginCredentials.setVisible(false);
		
		JLabel lblLoginSucessful = new JLabel("Login Sucessful!");
		lblLoginSucessful.setVisible(false);
		GridBagConstraints gbc_lblLoginSucessful = new GridBagConstraints();
		gbc_lblLoginSucessful.gridwidth = 2;
		gbc_lblLoginSucessful.insets = new Insets(0, 0, 5, 5);
		gbc_lblLoginSucessful.gridx = 0;
		gbc_lblLoginSucessful.gridy = 5;
		contentPane.add(lblLoginSucessful, gbc_lblLoginSucessful);
		GridBagConstraints gbc_lblInvalidLoginCredentials = new GridBagConstraints();
		gbc_lblInvalidLoginCredentials.gridwidth = 4;
		gbc_lblInvalidLoginCredentials.gridx = 0;
		gbc_lblInvalidLoginCredentials.gridy = 6;
		contentPane.add(lblInvalidLoginCredentials, gbc_lblInvalidLoginCredentials);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = tfuser.getText().toString();
				@SuppressWarnings("deprecation")
				String password = tfpass.getText().toString();
				
				String user = null;
				String pass = null;
				try
				{
					Connection con = connect();
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","anupchandra");
					String query = "SELECT * FROM LOGIN";
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(query);
					while(rs.next())
					{
						user = rs.getString(1);
						pass = rs.getString(2);
					}
				 if ((username.equals(user) && password.equals(pass)))
				{
					try
					{
						lblLoginSucessful.setVisible(true);
						lblInvalidLoginCredentials.setVisible(false);
						MainPanel main = new MainPanel();
						main.setVisible(true);
						LoginPanel login = new LoginPanel();
						login.setVisible(false);
						login.dispose();
					}
					catch(Exception e4)
					{
						e4.printStackTrace();
					}
				}
				 else
				 {
					 lblInvalidLoginCredentials.setVisible(true);
				 }
				}
				catch(Exception e6)
				{
					e6.printStackTrace();
				}
			}
		});
		
		
=======
>>>>>>> parent of 27e2cac... Next Commit xD
	}

}
