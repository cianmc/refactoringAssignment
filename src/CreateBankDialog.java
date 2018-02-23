
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.*;
import javax.swing.*;

import net.miginfocom.swing.MigLayout;

public class CreateBankDialog extends JFrame {

	private static final long serialVersionUID = 1L;

	ArrayList<BankAccount> accountList;

	private JLabel accountNumberLabel, firstNameLabel, surnameLabel, accountTypeLabel, balanceLabel, overdraftLabel;
	private JComboBox<String> comboBox;
	private JTextField accountNumberTextField;
	private final JTextField firstNameTextField, surnameTextField, accountTypeTextField, balanceTextField, overdraftTextField;

	public CreateBankDialog(ArrayList<BankAccount> accounts) {

		super("Add Bank Details");

		accountList = accounts;

		setLayout(new BorderLayout());

		JPanel dataPanel = new JPanel(new MigLayout());

		String[] comboTypes = {"Current", "Deposit"};

		comboBox = new JComboBox<>(comboTypes);

		accountNumberLabel = new JLabel("Account Number: ");
		accountNumberTextField = new JTextField(8);
		accountNumberTextField.setEditable(true);

		dataPanel.add(accountNumberLabel, "growx, pushx");
		dataPanel.add(accountNumberTextField, "growx, pushx, wrap");

		surnameLabel = new JLabel("Last Name: ");
		surnameTextField = new JTextField(15);
		surnameTextField.setEditable(true);

		dataPanel.add(surnameLabel, "growx, pushx");
		dataPanel.add(surnameTextField, "growx, pushx, wrap");

		firstNameLabel = new JLabel("First Name: ");
		firstNameTextField = new JTextField(15);
		firstNameTextField.setEditable(true);

		dataPanel.add(firstNameLabel, "growx, pushx");
		dataPanel.add(firstNameTextField, "growx, pushx, wrap");

		accountTypeLabel = new JLabel("Account Type: ");
		accountTypeTextField = new JTextField(5);
		accountTypeTextField.setEditable(true);

		dataPanel.add(accountTypeLabel, "growx, pushx");	
		dataPanel.add(comboBox, "growx, pushx, wrap");

		balanceLabel = new JLabel("Balance: ");
		balanceTextField = new JTextField(10);
		balanceTextField.setText("0.0");
		balanceTextField.setEditable(false);

		dataPanel.add(balanceLabel, "growx, pushx");
		dataPanel.add(balanceTextField, "growx, pushx, wrap");

		overdraftLabel = new JLabel("Overdraft: ");
		overdraftTextField = new JTextField(10);
		overdraftTextField.setText("0.0");
		overdraftTextField.setEditable(false);

		dataPanel.add(overdraftLabel, "growx, pushx");
		dataPanel.add(overdraftTextField, "growx, pushx, wrap");

		add(dataPanel, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel(new FlowLayout());
		JButton addButton = new JButton("Add");
		JButton cancelButton = new JButton("Cancel");

		buttonPanel.add(addButton);
		buttonPanel.add(cancelButton);

		add(buttonPanel, BorderLayout.SOUTH);

		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String accountNumber = accountNumberTextField.getText();
				String surname = surnameTextField.getText();
				String firstName = firstNameTextField.getText();
				String accountType = comboBox.getSelectedItem().toString();

				if(surname.isEmpty() || firstName.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter in both your firstname and surname", "WARNING", JOptionPane.WARNING_MESSAGE);
				}else{
					int accNum = Integer.parseInt(accountNumber);
					if(accNum <= 0) {
						JOptionPane.showMessageDialog(null, "Account number cannot be 0 or a negative number", "WARNING", JOptionPane.WARNING_MESSAGE);
					}else accountNumber = Integer.toString(accNum);
					if (accountNumber == null || !(accountNumber.length()== 8)) {
						JOptionPane.showMessageDialog(null, "Account Number needs to be a unique 8 digit number");
					} else {
							boolean accNumTaken=false;
							int accID = 1;
							
							if (!accountList.isEmpty()) {
							BankAccount ba = accountList.get(accountList.size()-1);
							int checkAcc = ba.getAccountID();
							while(checkAcc == accID) {
								accID++;
								}
							}
							for (BankAccount bA : accountList) {					
								if(bA.getAccountNumber().trim().equals(accountNumberTextField.getText())){
									accNumTaken=true;	
								}
							}

							if(!accNumTaken){
								BankAccount account = new BankAccount(accID, accountNumber, surname, firstName, accountType, 0.0, 0.0);
								accountList.add(account);
								BankNavigateFunctions.firstItem();
								dispose();
							}
							else{
								JOptionPane.showMessageDialog(null, "Account Number must be unique");
							}
						}
					}
				}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		setSize(400,800);
		pack();
		setVisible(true);

	}
}