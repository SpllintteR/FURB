package dev;

import static dev.Main.REPETITIONS;

import java.util.Random;

public class DepositThread extends Thread {

	private BankAccount account;
	private double ammount;

	public DepositThread(BankAccount account, double ammount) {
		 this.account = account;
		 this.ammount = ammount;
	}
	
	@Override
	public void run() {
		try{
			for(int i = 0; i < REPETITIONS && !isInterrupted(); i++){
				account.deposit(ammount);
				sleep(new Random().nextInt(400));
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
}
