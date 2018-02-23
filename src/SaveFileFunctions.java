import javax.swing.*;
import java.io.*;

public class SaveFileFunctions extends BankFileFunctions {

	private static final long serialVersionUID = 1L;
	
	public static void saveOpenValues(){		
		if (openValues){
			surnameTextField.setEditable(false);
			firstNameTextField.setEditable(false);
				
			accountList.get(currentItem).setSurname(surnameTextField.getText());
			accountList.get(currentItem).setFirstName(firstNameTextField.getText());
		}
	}
	
	public static void saveToFileAs() {

		fc = new JFileChooser();

		int returnVal = fc.showSaveDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			fileToSaveAs = file.getName();
			JOptionPane.showMessageDialog(null, "Accounts saved to " + file.getName());
		} else {
			JOptionPane.showMessageDialog(null, "Save cancelled by user");
		} try {
			if(fc.getSelectedFile()==null){
				JOptionPane.showMessageDialog(null, "Cancelled");
			}
			else
				output = new RandomAccessFile(fc.getSelectedFile(), "rw" );
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	public static void saveToFile(){

		RandomAccessBankAccount record = new RandomAccessBankAccount();

		for (BankAccount ba : accountList) {
			record.setAccountID(ba.getAccountID());
			record.setAccountNumber(ba.getAccountNumber());
			record.setFirstName(ba.getFirstName());
			record.setSurname(ba.getSurname());
			record.setAccountType(ba.getAccountType());
			record.setBalance(ba.getBalance());
			record.setOverdraft(ba.getOverdraft());

			if(output!=null){

				try {
					record.write( output );
				} catch (IOException u) {
					u.printStackTrace();
				}
			}  
		}  
	}

}
