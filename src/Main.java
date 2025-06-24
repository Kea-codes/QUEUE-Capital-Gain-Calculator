import java.util.Scanner;

/*@	author K MAREMELA
 * Total Marks Main Class: 25
 * Compilation & Correct Execution Marks: 10
 */
public class Main {
	static LinkedQueue<Transaction> buyQueue = new LinkedQueue<Transaction>();
	static LinkedQueue<Transaction> sellQueue = new LinkedQueue<Transaction>();
	static int totalGain = 0;

	/**
	 * Process queue of transactions - determine if each transaction is a buy or
	 * sell transaction & add it to the appropriate queue
	 * 
	 * @param transactions - a queue of buy and sell transactions 15 marks
	 */
	public static void processTransactions(LinkedQueue<String> transactions) {
		// COMPLETE CODE HERE

		while (!transactions.isEmpty()) {
			String transaction = transactions.dequeue();
			System.out.println("Transaction: " + transaction);
			String[] parts = transaction.split(" ");
			String type = parts[0];
			int quantity = Integer.parseInt(parts[1]);
			int price = Integer.parseInt(parts[2]);
			Transaction newTransaction = new Transaction(quantity, price);
			if (type.equalsIgnoreCase("BUY")) {
				buyQueue.enqueue(newTransaction);
			} else if (type.equalsIgnoreCase("SELL")) {
				sellQueue.enqueue(newTransaction);
			}
		}
	}

	/**
	 * Calculate capital gain(loss)
	 * 
	 * @return totalGain 10 marks
	 */
	public static Integer calculateCapitalGainLoss() {
		// COMPLETE CODE HERE

		
		while (!sellQueue.isEmpty()) {
			Transaction sellTransaction = sellQueue.dequeue();
			int remainingQuantity = sellTransaction.getQuantity();
			int sellPrice = sellTransaction.getUnitPrice();
			while (remainingQuantity > 0 && !buyQueue.isEmpty()) {
				Transaction oldestBuy = buyQueue.first();
				int available = oldestBuy.getQuantity();
				if (available <= remainingQuantity) {
					totalGain += available * (sellPrice - oldestBuy.getUnitPrice());
					buyQueue.dequeue();
					remainingQuantity -= available;
				} else {
					totalGain += remainingQuantity * (sellPrice - oldestBuy.getUnitPrice());
					oldestBuy.setQuantity(available - remainingQuantity);
					remainingQuantity = 0;
				}
			}
			if (remainingQuantity > 0) {
				System.out.println("Error: Attempting to sell more shares than available.");
			}
		}

		return totalGain;
	}

	public static void main(String[] args) {
		String response = "";
		Scanner s = new Scanner(System.in);
		LinkedQueue<String> instructionQueue = new LinkedQueue<String>();
		Integer capGainLoss;

		while (!response.toLowerCase().equals("quit")) {
			System.out.println("Select option: ");
			System.out.println("1) Enter new transaction");
			System.out.println("2) Calculate capital gain or loss");
			System.out.println("or \"quit\" to quit.");
			response = s.nextLine();

			switch (response.toLowerCase()) {
			case "1": {
				System.out.println("Enter transaction:");
				response = s.nextLine();
				if (!response.equals(""))
					instructionQueue.enqueue(response);
			}
				break;
			case "2": {
				processTransactions(instructionQueue);
				capGainLoss = calculateCapitalGainLoss();
				if (capGainLoss == null)
					System.out.println("Unmatched sell transaction(s).");
				else
					System.out.println("Capital Gain/Loss: R " + capGainLoss);
			}
				break;
			case "quit":
				break;
			default:
				System.out.println("Incorrect option selected. Please try again.");
			}
		}
	}
}