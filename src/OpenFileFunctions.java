import javax.swing.*;
import java.io.*;

public class OpenFileFunctions extends BankFileFunctions{

	private static final long serialVersionUID = 1L;
	
	public static void openFileRead() {
		accountList.clear();
		fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(null);

		if (returnVal == JFileChooser.CANCEL_OPTION) {
			JOptionPane.showMessageDialog(null, "Cancelled");
		} else {
		} try {
			if(fc.getSelectedFile()!=null)
				input = new RandomAccessFile( fc.getSelectedFile(), "r" );
		} catch ( IOException ioException ) {
			JOptionPane.showMessageDialog(null, "File Does Not Exist.");
		} // end catch
	} // end method openFile
	
	public static void openFileWrite()
	{
		if(fileToSaveAs!=""){
			try {
				output = new RandomAccessFile( fileToSaveAs, "rw" );
				JOptionPane.showMessageDialog(null, "Accounts saved to " + fileToSaveAs);
			} catch ( IOException ioException ){
				JOptionPane.showMessageDialog(null, "File does not exist.");
			} // end catch
		} else
			SaveFileFunctions.saveToFileAs();
	}
}
