
import java.io.RandomAccessFile;
import javax.swing.JFileChooser;

public class BankFileFunctions extends BankApplication{

	private static final long serialVersionUID = 1L;
	protected static RandomAccessFile input;
	protected static RandomAccessFile output;
	protected static JFileChooser fc;
	protected static String fileToSaveAs = "";

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
