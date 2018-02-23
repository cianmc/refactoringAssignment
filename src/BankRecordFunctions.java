import javax.swing.JOptionPane;

public class BankRecordFunctions extends BankApplication{

	private static final long serialVersionUID = 1L;

	public static void createItem() {
		new CreateBankDialog(table);
	}

	public static void modifyItem() {
		if (table.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No Accounts selected, please open or create a bank account", "WARNING", JOptionPane.WARNING_MESSAGE);
		}else{
			surnameTextField.setEditable(true);
			firstNameTextField.setEditable(true);
			openValues = true;
		}
	}

	public static void deleteItem() {
		if (table.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No Accounts selected, please open or create a bank account", "WARNING", JOptionPane.WARNING_MESSAGE);
		}else{
			table.remove(currentItem);
			JOptionPane.showMessageDialog(null, "Account Deleted");
			currentItem=0;
			while(!table.containsKey(currentItem)){
				currentItem++;
			}
			displayDetails(currentItem);
		}
	}

	public static void setOverdraft() {
		if (table.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No Accounts selected, please open or create a bank account", "WARNING", JOptionPane.WARNING_MESSAGE);
		}else{
			if(table.get(currentItem).getAccountType().trim().equals("Current")){
				String newOverdraftStr = JOptionPane.showInputDialog(null, "Enter new Overdraft", JOptionPane.OK_CANCEL_OPTION);
				if ( newOverdraftStr == null || (newOverdraftStr != null && ("".equals(newOverdraftStr)))) {
					JOptionPane.showMessageDialog(null, "No overdraft number entered", "ERROR", JOptionPane.ERROR_MESSAGE);	
				} else {
					int overDraft = Integer.parseInt(newOverdraftStr);
					if (overDraft <= 0) {
						JOptionPane.showMessageDialog(null, "Overdraft cannot be 0% or a minus number", "ERROR", JOptionPane.ERROR_MESSAGE);
					}else {
						newOverdraftStr = Integer.toString(overDraft);
						overdraftTextField.setText(newOverdraftStr);
						table.get(currentItem).setOverdraft(Double.parseDouble(newOverdraftStr));
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "Overdraft only applies to Current Accounts");
			}
		}
	}

	public static void setIntrest() {
		if (table.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No Accounts selected, please open or create a bank account", "WARNING", JOptionPane.WARNING_MESSAGE);
		}else{
			String interestRateStr = JOptionPane.showInputDialog("Enter Interest Rate: (do not type the % sign)");
			if(interestRateStr.contains("%")) {
				JOptionPane.showMessageDialog(null, "Please do not enter in the % sign", "WARNING", JOptionPane.WARNING_MESSAGE);
			}else {
				if ( interestRateStr == null || (interestRateStr != null && ("".equals(interestRateStr)))) {
					JOptionPane.showMessageDialog(null, "No intrest rate entered", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else {
					int interest = Integer.parseInt(interestRateStr);
					if (interest <= 0 || interest >=100) {
						JOptionPane.showMessageDialog(null, "Intrest rate cannot be 0% or a minus number, it also cannot be greater than 100%", "ERROR", JOptionPane.ERROR_MESSAGE);
					}else {
						interestRateStr = Integer.toString(interest);
						interestRate = Double.parseDouble(interestRateStr);
						JOptionPane.showMessageDialog(null, "Intrest rate set at " + interestRateStr + "%", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
					} 
				}
			}
		}
	}
}
