
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class BankNavigateFunctions extends BankApplication{

	private static final long serialVersionUID = 1L;

	// Navigate to first item in HashMap
	public static void firstItem() {
		if(accountList.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No Accounts selected, please open or create a bank account", "WARNING", JOptionPane.WARNING_MESSAGE);
		} else {
			saveOpenValues();
			currentItem=0;
			accountList.get(currentItem);
			displayDetails(currentItem);
		}
	}

	// Navigate to last item in HashMap
	public static void lastItem() {
		if(accountList.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No Accounts selected, please open or create a bank account", "WARNING", JOptionPane.WARNING_MESSAGE);
		} else {
			saveOpenValues();
			currentItem = accountList.size() -1;
			accountList.get(currentItem);
			displayDetails(currentItem);
		}
	}

	// Navigate to next item in HashMap
	public static void nextItem() {
		if(accountList.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No Accounts selected, please open or create a bank account", "WARNING", JOptionPane.WARNING_MESSAGE);
		} else {
			saveOpenValues();
			if (currentItem < (accountList.size() - 1)) {
				currentItem++;
			}
			accountList.get(currentItem);
			displayDetails(currentItem);
		}
	}

	// Navigate to previous item in HashMap
	public static void previousItem() {
		if(accountList.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No Accounts selected, please open or create a bank account", "WARNING", JOptionPane.WARNING_MESSAGE);
		} else {
			saveOpenValues();
			if (currentItem > 0) {
				currentItem--;
			}
			accountList.get(currentItem);
			displayDetails(currentItem);
		}
	}

	// find account by account number
	public static void findByAccountNumber() {
		if(accountList.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No Accounts selected, please open or create a bank account", "WARNING", JOptionPane.WARNING_MESSAGE);
		} else {
			String accNum = JOptionPane.showInputDialog("Search for account number: ");
			boolean found = false;
			if ( accNum == null || (accNum != null && ("".equals(accNum)))) {
				JOptionPane.showMessageDialog(null, "No account number entered", "ERROR", JOptionPane.ERROR_MESSAGE);
			}else {
				for (BankAccount ba : accountList) {
					if(accNum.equals(ba.getAccountNumber().trim())){
						found = true;
						accountIDTextField.setText(ba.getAccountID()+"");
						accountNumberTextField.setText(ba.getAccountNumber());
						surnameTextField.setText(ba.getSurname());
						firstNameTextField.setText(ba.getFirstName());
						accountTypeTextField.setText(ba.getAccountType());
						balanceTextField.setText(ba.getBalance()+"");
						overdraftTextField.setText(ba.getOverdraft()+"");						
					}			 
				}
				if(found) {
					JOptionPane.showMessageDialog(null, "Account number " + accNum + " found.");	
				} else {
					JOptionPane.showMessageDialog(null, "Account number " + accNum + " not found.");
				}
			}
		}
	}

	// find account by surname
	public static void findBySurname() {
		if(accountList.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No Accounts selected, please open or create a bank account", "WARNING", JOptionPane.WARNING_MESSAGE);
		} else {
			String sName = JOptionPane.showInputDialog("Search for surname: ");
			boolean found = false;
			if ( sName == null || (sName != null && ("".equals(sName)))) {
				JOptionPane.showMessageDialog(null, "No surname entered", "ERROR", JOptionPane.ERROR_MESSAGE);
			}else {
				for (BankAccount ba : accountList) {
					if(sName.equalsIgnoreCase(ba.getSurname().trim())){
						found = true;
						accountIDTextField.setText(ba.getAccountID()+"");
						accountNumberTextField.setText(ba.getAccountNumber());
						surnameTextField.setText(ba.getSurname());
						firstNameTextField.setText(ba.getFirstName());
						accountTypeTextField.setText(ba.getAccountType());
						balanceTextField.setText(ba.getBalance()+"");
						overdraftTextField.setText(ba.getOverdraft()+"");
					}
				}		
				if(found) {
					JOptionPane.showMessageDialog(null, "Surname " + sName + " found.");
				} else {
					JOptionPane.showMessageDialog(null, "Surname " + sName + " not found.");
				}
			}
		}
	}

	// list all the records in a table
	public static void listAllRecords() {
		if(accountList.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No Accounts selected, please open or create a bank account", "WARNING", JOptionPane.WARNING_MESSAGE);
		} else {
			JFrame frame = new JFrame("TableDemo");

			String col[] = {"ID","Number","Name", "Account Type", "Balance", "Overdraft"};

			DefaultTableModel tableModel = new DefaultTableModel(col, 0);
			jTable = new JTable(tableModel);
			JScrollPane scrollPane = new JScrollPane(jTable);
			jTable.setAutoCreateRowSorter(true);

			for (BankAccount ba : accountList) {

				Object[] objs = {ba.getAccountID(), ba.getAccountNumber(), 
						ba.getFirstName().trim() + " " + ba.getSurname().trim(), 
						ba.getAccountType(), ba.getBalance(), 
						ba.getOverdraft()};

				tableModel.addRow(objs);
			}
			frame.setSize(600,500);
			frame.add(scrollPane);
			frame.setVisible(true);	
		}

	}
}
