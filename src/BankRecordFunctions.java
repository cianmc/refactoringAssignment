import javax.swing.JOptionPane;

public class BankRecordFunctions extends BankApplication{

	private static final long serialVersionUID = 1L;

	public static void createItem() {
		new CreateBankDialog(table);
	}
	
	public static void modifyItem() {
		surnameTextField.setEditable(true);
		firstNameTextField.setEditable(true);
		openValues = true;
	}
	
	public static void deleteItem() {
		table.remove(currentItem);
		JOptionPane.showMessageDialog(null, "Account Deleted");
		currentItem=0;
		while(!table.containsKey(currentItem)){
			currentItem++;
		}
		displayDetails(currentItem);
	}
	
	public static void setOverdraft() {
		if(table.get(currentItem).getAccountType().trim().equals("Current")){
			String newOverdraftStr = JOptionPane.showInputDialog(null, "Enter new Overdraft", JOptionPane.OK_CANCEL_OPTION);
			overdraftTextField.setText(newOverdraftStr);
			table.get(currentItem).setOverdraft(Double.parseDouble(newOverdraftStr));
		}
		else
			JOptionPane.showMessageDialog(null, "Overdraft only applies to Current Accounts");
	}
	
	public static void setIntrest() {
		String interestRateStr = JOptionPane.showInputDialog("Enter Interest Rate: (do not type the % sign)");
		if(interestRateStr!=null)
			interestRate = Double.parseDouble(interestRateStr);
	}
}
