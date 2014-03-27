package dev;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

	private double ammount;
	private Lock lock = new ReentrantLock();
	
	public void withdraw(double ammount) throws InterruptedException {
		lock.lock();
		System.out.println("lock with");
		try{
			//System.out.println("Withdrawing " + ammount);
			double newBallance = this.ammount - ammount;
			//System.out.println("new Balance is " + newBallance);
			this.ammount = newBallance;
		}finally{
			lock.unlock();
			System.out.println("unlock with");
		}
	}

	public void deposit(double ammount) {
		lock.lock();
		System.out.println("lock dep");
		try{
			//System.out.println("Depositing " + ammount);
			double newBallance = this.ammount + ammount;
			//System.out.println("new Balance is " + newBallance);
			this.ammount = newBallance;
		}finally{
			lock.unlock();
			System.out.println("unlock dep");
		}
	}

}
