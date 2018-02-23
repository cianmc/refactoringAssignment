import java.util.Map;
import javax.swing.JOptionPane;

public class BankTransactionsFunctions extends BankApplication {

	private static final long serialVersionUID = 1L;

	public static void deposit() {
		if(table.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No Accounts selected, please open or create a bank account", "WARNING", JOptionPane.WARNING_MESSAGE);
		} else {
			String accNum = JOptionPane.showInputDialog("Account number to deposit into: ");
			boolean found = false;
			if ( accNum == null || (accNum != null && ("".equals(accNum)))) {
				JOptionPane.showMessageDialog(null, "No account number entered", "ERROR", JOptionPane.ERROR_MESSAGE);
			}else {
				for (Map.Entry<Integer, BankAccount> entry : table.entrySet()) {
					if(accNum.equals(entry.getValue().getAccountNumber().trim())){
						found = true;
						String toDeposit = JOptionPane.showInputDialog("Account found, Enter Amount to Deposit: ");
						if ( toDeposit == null || (toDeposit != null && ("".equals(toDeposit)))) {
							JOptionPane.showMessageDialog(null, "No deposit ammount entered", "ERROR", JOptionPane.ERROR_MESSAGE);
						}else {
							if (!toDeposit.contains("-")) {
								entry.getValue().setBalance(entry.getValue().getBalance() + Double.parseDouble(toDeposit));
								displayDetails(entry.getKey());
							} else JOptionPane.showMessageDialog(null, "You cannot deposit a negative number", "ERROR", JOptionPane.ERROR_MESSAGE);
						}if (!found) {
							JOptionPane.showMessageDialog(null, "Account number " + accNum + " not found.");
						}
					}
				}
			}
		}
	}


	public static void withdraw() {
		if(table.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No Accounts selected, please open or create a bank account", "WARNING", JOptionPane.WARNING_MESSAGE);
		} else {
			String accNum = JOptionPane.showInputDialog("Account number to withdraw from: ");
			boolean found = false;
			if ( accNum == null || (accNum != null && ("".equals(accNum)))) {
				JOptionPane.showMessageDialog(null, "No account number entered", "ERROR", JOptionPane.ERROR_MESSAGE);
			} else {
				for (Map.Entry<Integer, BankAccount> entry : table.entrySet()) {
					if(accNum.equals(entry.getValue().getAccountNumber().trim())){
						String toWithdraw = JOptionPane.showInputDialog("Account found, Enter Amount to Withdraw: ");
						if ( toWithdraw == null || (toWithdraw != null && ("".equals(toWithdraw)))) {
							JOptionPane.showMessageDialog(null, "No deposit ammount entered", "ERROR", JOptionPane.ERROR_MESSAGE);
						}else {
							if (!toWithdraw.contains("-")) {
								found = true;
								if(entry.getValue().getAccountType().trim().equals("Current")){
									if(Double.parseDouble(toWithdraw) > entry.getValue().getBalance() + entry.getValue().getOverdraft())
										JOptionPane.showMessageDialog(null, "Transaction exceeds overdraft limit");
									else{
										entry.getValue().setBalance(entry.getValue().getBalance() - Double.parseDouble(toWithdraw));
										displayDetails(entry.getKey());
									}
								}
								else if(entry.getValue().getAccountType().trim().equals("Deposit")){
									if(Double.parseDouble(toWithdraw) <= entry.getValue().getBalance()){
										entry.getValue().setBalance(entry.getValue().getBalance()-Double.parseDouble(toWithdraw));
										displayDetails(entry.getKey());
									}
									else
										JOptionPane.showMessageDialog(null, "Insufficient funds.");
								}
							} else {
								JOptionPane.showMessageDialog(null, "You cannot withdraw a negitive number", "ERROR", JOptionPane.ERROR_MESSAGE);
								found = true;
							}
						} if (!found) {
							JOptionPane.showMessageDialog(null, "Account number " + accNum + " not found.");

						}
					} 
				}
			}
		}
	}

	public static void calculateIntrest() {
		if(table.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No Accounts selected, please open or create a bank account", "WARNING", JOptionPane.WARNING_MESSAGE);
		}else {
			if(!(interestRate == 0)) {
				for (Map.Entry<Integer, BankAccount> entry : table.entrySet()) {
					if(entry.getValue().getAccountType().equals("Deposit")){
						double equation = 1 + ((interestRate)/100);
						entry.getValue().setBalance(entry.getValue().getBalance()*equation);
						JOptionPane.showMessageDialog(null, "Balances Updated");
						displayDetails(entry.getKey());
					}
				}
			}
			JOptionPane.showMessageDialog(null, "No interest rate set", "Warning", JOptionPane.WARNING_MESSAGE);
		}
	}
}

