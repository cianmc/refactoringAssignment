
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class BankApplication extends JFrame {

	private static final long serialVersionUID = 1L;
	static ArrayList<BankAccount> accountList = new ArrayList<BankAccount>();

	private JMenuBar menuBar;
	private JMenu navigateMenu, recordsMenu, transactionsMenu, fileMenu, exitMenu;
	private JMenuItem nextItem, prevItem, firstItem, lastItem, findByAccount, findBySurname, listAll, createItem, modifyItem, deleteItem, setOverdraft, setInterest, deposit, withdraw, calcInterest, open, save, saveAs, closeApp;
	private JButton firstItemButton, lastItemButton, nextItemButton, prevItemButton;
	private JLabel accountIDLabel, accountNumberLabel, firstNameLabel, surnameLabel, accountTypeLabel, balanceLabel, overdraftLabel;
	protected static JTextField accountIDTextField, accountNumberTextField, firstNameTextField, surnameTextField, accountTypeTextField, balanceTextField, overdraftTextField;
	protected static JTable jTable;
	protected static double interestRate;

	protected static int currentItem = 0;

	protected static boolean openValues;

	public BankApplication() {

		super("Bank Application");

		initComponents();
	}

	public void initComponents() {
		setLayout(new BorderLayout());
		JPanel displayPanel = new JPanel(new MigLayout());

		accountIDLabel = new JLabel("Account ID: ");
		accountIDTextField = new JTextField(15);
		accountIDTextField.setEditable(false);

		displayPanel.add(accountIDLabel, "growx, pushx");
		displayPanel.add(accountIDTextField, "growx, pushx, wrap");

		accountNumberLabel = new JLabel("Account Number: ");
		accountNumberTextField = new JTextField(15);
		accountNumberTextField.setEditable(false);

		displayPanel.add(accountNumberLabel, "growx, pushx");
		displayPanel.add(accountNumberTextField, "growx, pushx, wrap");

		surnameLabel = new JLabel("Last Name: ");
		surnameTextField = new JTextField(15);
		surnameTextField.setEditable(false);

		displayPanel.add(surnameLabel, "growx, pushx");
		displayPanel.add(surnameTextField, "growx, pushx, wrap");

		firstNameLabel = new JLabel("First Name: ");
		firstNameTextField = new JTextField(15);
		firstNameTextField.setEditable(false);

		displayPanel.add(firstNameLabel, "growx, pushx");
		displayPanel.add(firstNameTextField, "growx, pushx, wrap");

		accountTypeLabel = new JLabel("Account Type: ");
		accountTypeTextField = new JTextField(5);
		accountTypeTextField.setEditable(false);

		displayPanel.add(accountTypeLabel, "growx, pushx");
		displayPanel.add(accountTypeTextField, "growx, pushx, wrap");

		balanceLabel = new JLabel("Balance: ");
		balanceTextField = new JTextField(10);
		balanceTextField.setEditable(false);

		displayPanel.add(balanceLabel, "growx, pushx");
		displayPanel.add(balanceTextField, "growx, pushx, wrap");

		overdraftLabel = new JLabel("Overdraft: ");
		overdraftTextField = new JTextField(10);
		overdraftTextField.setEditable(false);

		displayPanel.add(overdraftLabel, "growx, pushx");
		displayPanel.add(overdraftTextField, "growx, pushx, wrap");

		add(displayPanel, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel(new GridLayout(1, 4));

		nextItemButton = new JButton(new ImageIcon("next.png"));
		prevItemButton = new JButton(new ImageIcon("prev.png"));
		firstItemButton = new JButton(new ImageIcon("first.png"));
		lastItemButton = new JButton(new ImageIcon("last.png"));

		buttonPanel.add(firstItemButton);
		buttonPanel.add(prevItemButton);
		buttonPanel.add(nextItemButton);
		buttonPanel.add(lastItemButton);

		add(buttonPanel, BorderLayout.SOUTH);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		navigateMenu = new JMenu("Navigate");

		nextItem = new JMenuItem("Next Item");
		prevItem = new JMenuItem("Previous Item");
		firstItem = new JMenuItem("First Item");
		lastItem = new JMenuItem("Last Item");
		findByAccount = new JMenuItem("Find by Account Number");
		findBySurname = new JMenuItem("Find by Surname");
		listAll = new JMenuItem("List All Records");

		navigateMenu.add(nextItem);
		navigateMenu.add(prevItem);
		navigateMenu.add(firstItem);
		navigateMenu.add(lastItem);
		navigateMenu.add(findByAccount);
		navigateMenu.add(findBySurname);
		navigateMenu.add(listAll);

		menuBar.add(navigateMenu);

		recordsMenu = new JMenu("Records");

		createItem = new JMenuItem("Create Item");
		modifyItem = new JMenuItem("Modify Item");
		deleteItem = new JMenuItem("Delete Item");
		setOverdraft = new JMenuItem("Set Overdraft");
		setInterest = new JMenuItem("Set Interest");

		recordsMenu.add(createItem);
		recordsMenu.add(modifyItem);
		recordsMenu.add(deleteItem);
		recordsMenu.add(setOverdraft);
		recordsMenu.add(setInterest);

		menuBar.add(recordsMenu);

		transactionsMenu = new JMenu("Transactions");

		deposit = new JMenuItem("Deposit");
		withdraw = new JMenuItem("Withdraw");
		calcInterest = new JMenuItem("Calculate Interest");

		transactionsMenu.add(deposit);
		transactionsMenu.add(withdraw);
		transactionsMenu.add(calcInterest);

		menuBar.add(transactionsMenu);

		fileMenu = new JMenu("File");

		open = new JMenuItem("Open File");
		save = new JMenuItem("Save File");
		saveAs = new JMenuItem("Save As");

		fileMenu.add(open);
		fileMenu.add(save);
		fileMenu.add(saveAs);

		menuBar.add(fileMenu);

		exitMenu = new JMenu("Exit");

		closeApp = new JMenuItem("Close Application");

		exitMenu.add(closeApp);

		menuBar.add(exitMenu);

		// Navigation Action Listeners
		ActionListener first = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BankNavigateFunctions.firstItem();
			}
		};

		ActionListener next = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				BankNavigateFunctions.nextItem();
			}
		};

		ActionListener prev = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BankNavigateFunctions.previousItem();				
			}
		};

		ActionListener last = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BankNavigateFunctions.lastItem();
			}
		};

		findBySurname.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				BankNavigateFunctions.findBySurname();
			}
		});

		findByAccount.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				BankNavigateFunctions.findByAccountNumber();
			}
		});

		listAll.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				BankNavigateFunctions.listAllRecords();
			}
		});

		nextItemButton.addActionListener(next);
		nextItem.addActionListener(next);

		prevItemButton.addActionListener(prev);
		prevItem.addActionListener(prev);

		firstItemButton.addActionListener(first);
		firstItem.addActionListener(first);

		lastItemButton.addActionListener(last);
		lastItem.addActionListener(last);

		// Records Action Listeners
		createItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				BankRecordFunctions.createItem();		
			}
		});


		modifyItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				BankRecordFunctions.modifyItem();
			}
		});

		deleteItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				BankRecordFunctions.deleteItem();
			}
		});

		setOverdraft.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				BankRecordFunctions.setOverdraft();
			}
		});

		setInterest.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				BankRecordFunctions.setIntrest();
			}
		});

		// Transactions Action Listeners
		deposit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				BankTransactionsFunctions.deposit();
			}
		});

		withdraw.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				BankTransactionsFunctions.withdraw();
			}
		});

		calcInterest.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				BankTransactionsFunctions.calculateIntrest();
			}
		});	

		// File Action Listeners
		open.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				BankFileFunctions.openFile();
			}
		});

		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				BankFileFunctions.writeFile();
			}
		});

		saveAs.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				BankFileFunctions.saveFileAs();
			}
		});

		// Exit Action Listeners
		closeApp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(accountList.isEmpty()) {
					dispose();
				}else {
					int answer = JOptionPane.showConfirmDialog(BankApplication.this, "Do you want to save before quitting?");
					if (answer == JOptionPane.YES_OPTION) {
						BankFileFunctions.saveFileAs();
						dispose();
					}else if(answer == JOptionPane.NO_OPTION) {
						dispose();
					}else if(answer == JOptionPane.CANCEL_OPTION) {
						JOptionPane.showMessageDialog(null, "Cancelled", "NOTICE", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});	
	}// end of initCompnents


	public static void saveOpenValues() {
		SaveFileFunctions.saveOpenValues();
	}

	public static void displayDetails(Integer currentItem) {
		accountIDTextField.setText(accountList.get(currentItem).getAccountID()+"");
		accountNumberTextField.setText(accountList.get(currentItem).getAccountNumber());
		surnameTextField.setText(accountList.get(currentItem).getSurname());
		firstNameTextField.setText(accountList.get(currentItem).getFirstName());
		accountTypeTextField.setText(accountList.get(currentItem).getAccountType());
		balanceTextField.setText(accountList.get(currentItem).getBalance()+"");
		if(accountTypeTextField.getText().trim().equals("Current"))
			overdraftTextField.setText(accountList.get(currentItem).getOverdraft()+"");
		else
			overdraftTextField.setText("Only applies to current accs");
	}

	public static void main(String[] args) {
		BankApplication ba = new BankApplication();
		ba.setSize(1200,400);
		ba.pack();
		ba.setVisible(true);
	}
}




/*
The task for your second assignment is to construct a system that will allow users to define a data structure representing a collection of records that can be displayed both by means of a dialog that can be scrolled through and by means of a table to give an overall view of the collection contents. 
The user should be able to carry out tasks such as adding records to the collection, modifying the contents of records, and deleting records from the collection, as well as being able to save and retrieve the contents of the collection to and from external random access files.
The records in the collection will represent bank account records with the following fields:

AccountID (this will be an integer unique to a particular account and 
will be automatically generated when a new account record is created)

AccountNumber (this will be a string of eight digits and should also 
be unique - you will need to check for this when creating a new record)

Surname (this will be a string of length 20)

FirstName (this will be a string of length 20)

AccountType (this will have two possible options - "Current " and 
"Deposit" - and again will be selected from a drop down list when 
entering a record)

Balance (this will a real number which will be initialised to 0.0 
and can be increased or decreased by means of transactions)

Overdraft (this will be a real number which will be initialised 
to 0.0 but can be updated by means of a dialog - it only applies 
to current accounts)

You may consider whether you might need more than one class to deal with bank accounts.
The system should be menu-driven, with the following menu options:

Navigate: First, Last, Next, Previous, Find By Account Number 
(allows you to find a record by account number entered via a 
dialog box), Find By Surname (allows you to find a record by 
surname entered via a dialog box),List All (displays the 
contents of the collection as a dialog containing a JTable)

Records: Create, Modify, Delete, Set Overdraft (this should 
use a dialog to allow you to set or update the overdraft for 
a current account), Set Interest Rate (this should allow you 
to set the interest rate for deposit accounts by means of a 
dialog)

Transactions: Deposit, Withdraw (these should use dialogs which
allow you to specify an account number and the amount to withdraw
or deposit, and should check that a withdrawal would not cause
the overdraft limit for a current account to be exceeded, or be 
greater than the balance in a deposit account, before the balance 
is updated), Calculate Interest (this calculates the interest rate 
for all deposit accounts and updates the balances)

File: Open, Save, Save As (these should use JFileChooser dialogs. 
The random access file should be able to hold 25 records. The position 
in which a record is stored and retrieved will be determined by its account 
number by means of a hashing procedure, with a standard method being used when 
dealing with possible hash collisions)

Exit Application (this should make sure that the collection is saved - or that 
the user is given the opportunity to save the collection - before the application closes)

When presenting the results in a JTable for the List All option, the records should be sortable on all fields, but not editable (changing the records or adding and deleting records can only be done through the main dialog).
For all menu options in your program, you should perform whatever validation, error-checking and exception-handling you consider to be necessary.
The programs Person.java and PersonApplication.java (from OOSD2) and TableDemo.java may be of use to you in constructing your interfaces. The set of Java programs used to create, edit and modify random access files will also provide you with a basis for your submission.

 */