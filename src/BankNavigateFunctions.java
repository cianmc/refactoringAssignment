
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class BankNavigateFunctions extends BankApplication{

	private static final long serialVersionUID = 1L;

	// Navigate to first item in HashMap
	public static void firstItem() {
		saveOpenValues();
		currentItem=0;
		while(!table.containsKey(currentItem)){
			currentItem++;
		}
		displayDetails(currentItem);
	}

	// Navigate to last item in HashMap
	public static void lastItem() {
		saveOpenValues();
		currentItem =29;
		while(!table.containsKey(currentItem)){
			currentItem--;
		}
		displayDetails(currentItem);
	}

	// Navigate to next item in HashMap
	public static void nextItem() {
		ArrayList<Integer> keyList = new ArrayList<Integer>();
		int i=0;
		while(i<TABLE_SIZE){
			i++;
			if(table.containsKey(i))
				keyList.add(i);
		}
		int maxKey = Collections.max(keyList);
		saveOpenValues();	
		if(currentItem<maxKey){
			currentItem++;
			while(!table.containsKey(currentItem)){
				currentItem++;
			}
		}
		displayDetails(currentItem);
	}

	// Navigate to previous item in HashMap
	public static void previousItem() {
		ArrayList<Integer> keyList = new ArrayList<Integer>();
		int i=0;
		while(i<TABLE_SIZE){
			i++;
			if(table.containsKey(i))
				keyList.add(i);
		}
		int minKey = Collections.min(keyList);
		if(currentItem>minKey){
			currentItem--;
			while(!table.containsKey(currentItem)){
				currentItem--;
			}
		}
		displayDetails(currentItem);
	}

	// find account by account number
	public static void findByAccountNumber() {
		String accNum = JOptionPane.showInputDialog("Search for account number: ");
		boolean found = false;

		for (Map.Entry<Integer, BankAccount> entry : table.entrySet()) {

			if(accNum.equals(entry.getValue().getAccountNumber().trim())){
				found = true;
				accountIDTextField.setText(entry.getValue().getAccountID()+"");
				accountNumberTextField.setText(entry.getValue().getAccountNumber());
				surnameTextField.setText(entry.getValue().getSurname());
				firstNameTextField.setText(entry.getValue().getFirstName());
				accountTypeTextField.setText(entry.getValue().getAccountType());
				balanceTextField.setText(entry.getValue().getBalance()+"");
				overdraftTextField.setText(entry.getValue().getOverdraft()+"");						

			}			 
		}
		if(found)
			JOptionPane.showMessageDialog(null, "Account number " + accNum + " found.");
		else
			JOptionPane.showMessageDialog(null, "Account number " + accNum + " not found.");
	}

	// find account by surname
	public static void findBySurname() {
		String sName = JOptionPane.showInputDialog("Search for surname: ");
		boolean found = false;

		for (Map.Entry<Integer, BankAccount> entry : table.entrySet()) {

			if(sName.equalsIgnoreCase((entry.getValue().getSurname().trim()))){
				found = true;
				accountIDTextField.setText(entry.getValue().getAccountID()+"");
				accountNumberTextField.setText(entry.getValue().getAccountNumber());
				surnameTextField.setText(entry.getValue().getSurname());
				firstNameTextField.setText(entry.getValue().getFirstName());
				accountTypeTextField.setText(entry.getValue().getAccountType());
				balanceTextField.setText(entry.getValue().getBalance()+"");
				overdraftTextField.setText(entry.getValue().getOverdraft()+"");
			}
		}		
		if(found)
			JOptionPane.showMessageDialog(null, "Surname  " + sName + " found.");
		else
			JOptionPane.showMessageDialog(null, "Surname " + sName + " not found.");
	}

	// list all the records in a table
	public static void listAllRecords() {
		JFrame frame = new JFrame("TableDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		String col[] = {"ID","Number","Name", "Account Type", "Balance", "Overdraft"};

		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		jTable = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(jTable);
		jTable.setAutoCreateRowSorter(true);

		for (Map.Entry<Integer, BankAccount> entry : table.entrySet()) {

			Object[] objs = {entry.getValue().getAccountID(), entry.getValue().getAccountNumber(), 
					entry.getValue().getFirstName().trim() + " " + entry.getValue().getSurname().trim(), 
					entry.getValue().getAccountType(), entry.getValue().getBalance(), 
					entry.getValue().getOverdraft()};

			tableModel.addRow(objs);
		}
		frame.setSize(600,500);
		frame.add(scrollPane);
		frame.setVisible(true);	
	}
}
