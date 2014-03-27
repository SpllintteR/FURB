package dev;

public class Main {

	public static int REPETITIONS = 10;
	public static int AMMOUNT = 100;
	
	public static void main(String[] args) {
		BankAccount bank = new BankAccount();
		
		WithdrawThread withdraw = new WithdrawThread(bank, AMMOUNT);
		DepositThread deposit = new DepositThread(bank, AMMOUNT);
		withdraw.start();
		deposit.start();
		while(withdraw.isAlive() || deposit.isAlive()){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
