
import java.io.RandomAccessFile;
import javax.swing.JFileChooser;

public class BankFileFunctions extends BankApplication{

	private static final long serialVersionUID = 1L;
	protected static RandomAccessFile input;
	protected static RandomAccessFile output;
	protected static JFileChooser fc;
	protected static String fileToSaveAs = "";

	/*	public void displayDetails(int currentItem) {	
		accountIDTextField.setText(table.get(currentItem).getAccountID()+"");
		accountNumberTextField.setText(table.get(currentItem).getAccountNumber());
		surnameTextField.setText(table.get(currentItem).getSurname());
		firstNameTextField.setText(table.get(currentItem).getFirstName());
		accountTypeTextField.setText(table.get(currentItem).getAccountType());
		balanceTextField.setText(table.get(currentItem).getBalance()+"");
		if(accountTypeTextField.getText().trim().equals("Current"))
			overdraftTextField.setText(table.get(currentItem).getOverdraft()+"");
		else
			overdraftTextField.setText("Only applies to current accs");
	}*/


	public static void writeFile(){
		OpenFileFunctions.openFileWrite();
		SaveFileFunctions.saveToFile();
		CloseFileFunctions.closeFile();
	}

	public static void saveFileAs(){
		SaveFileFunctions.saveToFileAs();
		SaveFileFunctions.saveToFile();	
		CloseFileFunctions.closeFile();
	}

	public static void readFile(){
		OpenFileFunctions.openFileRead();
		ReadFileFunctions.readRecords();
		CloseFileFunctions.closeFile();		
	}
	public static void openFile() {
		readFile();
		currentItem=0;
		while(!table.containsKey(currentItem)){
			currentItem++;
		}
		displayDetails(currentItem);
	}

}
