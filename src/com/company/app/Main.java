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

	    
	//ez mire jo?, siman addnal hoza adod ahhoz a listahoz is, ha nem akarsz filterezni.
	trainCompany.addICTrainsToIcList();
	trainCompany.addPassengerTrainsToPassengerList();

        for (int i = 0; i < 24; i++) {
            trainCompany.calculateMonthlyFreightRevenue();
            trainCompany.calculateMonthlyICRevenue();
            trainCompany.calculateMonthlyPassengerRevenue();
        }

		System.out.println(trainCompany.getProfit());
    }
}
