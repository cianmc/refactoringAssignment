import java.io.IOException;

import javax.swing.JOptionPane;

public class CloseFileFunctions extends BankFileFunctions{

	private static final long serialVersionUID = 1L;

	public static void closeFile() 
	   {
	      try // close file and exit
	      {
	         if ( input != null )
	            input.close();
	      } // end try
	      catch ( IOException ioException )
	      {
	    	  JOptionPane.showMessageDialog(null, "Error closing file.");//System.exit( 1 );
	      } // end catch
	   } // end method closeFile
}
