package com.company.app;

import com.company.trains.Freight;
import com.company.trains.IC;
import com.company.trains.Passenger;

public class Main {

	public static void main(String[] args) {
		TrainCompany trainCompany = new TrainCompany();
		trainCompany.addTrain(new IC());
		trainCompany.addTrain(new IC());
		trainCompany.addTrain(new Passenger());
		trainCompany.addTrain(new Passenger());
		trainCompany.addTrain(new Freight());
		trainCompany.addTrain(new Freight());


		for (int i = 0; i < 24; i++) {
			trainCompany.calculateIncome();
		}
		System.out.println(trainCompany.getIncome());
		System.out.println(trainCompany.getExpenses());
		System.out.println(trainCompany.calculateProfit());
	}
}
