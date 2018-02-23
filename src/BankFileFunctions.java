
import java.io.RandomAccessFile;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class BankFileFunctions extends BankApplication{

	private static final long serialVersionUID = 1L;
	protected static RandomAccessFile input;
	protected static RandomAccessFile output;
	protected static JFileChooser fc;
	protected static String fileToSaveAs = "";

	public static void writeFile(){
		if(accountList.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No Accounts selected, please open or create a bank account", "WARNING", JOptionPane.WARNING_MESSAGE);
		} else {
		OpenFileFunctions.openFileWrite();
		SaveFileFunctions.saveToFile();
		CloseFileFunctions.closeFile();
		}
	}

	public static void saveFileAs(){
		if(accountList.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No Accounts selected, please open or create a bank account", "WARNING", JOptionPane.WARNING_MESSAGE);
		} else {
		SaveFileFunctions.saveToFileAs();
		SaveFileFunctions.saveToFile();	
		CloseFileFunctions.closeFile();
		}
	}

	public static void readFile(){
		OpenFileFunctions.openFileRead();
		ReadFileFunctions.readRecords();
		CloseFileFunctions.closeFile();		
	}
	public static void openFile() {
		readFile();
		currentItem=0;
		displayDetails(currentItem);
	}

}
