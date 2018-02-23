import java.io.EOFException;
import java.io.IOException;

import javax.swing.JOptionPane;

public class ReadFileFunctions extends BankFileFunctions{

	private static final long serialVersionUID = 1L;
	
	public static void readRecords() {
		
	      RandomAccessBankAccount record = new RandomAccessBankAccount();

	      try {
	         while ( true ) {
	            do {
	            	if(input!=null)
	            		record.read( input );
	            } while ( record.getAccountID() == 0 );
	            
	            BankAccount ba = new BankAccount(record.getAccountID(), record.getAccountNumber(), record.getFirstName(),
	                    record.getSurname(), record.getAccountType(), record.getBalance(), record.getOverdraft());
	            
	            accountList.add(ba);
		
	        } // end while
	      } // end try
	      catch ( EOFException eofException ) // close file
	      {
	         return; // end of file was reached
	      } // end catch
	      catch ( IOException ioException )
	      {
	    	  JOptionPane.showMessageDialog(null, "Error reading file.");
	         System.exit( 1 );
	      } // end catch
	   }
}
