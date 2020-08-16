package com.company.app;

import com.company.trains.Freight;
import com.company.trains.IC;
import com.company.trains.Passenger;
import com.company.trains.Train;
import com.company.util.RandomUtil;


import java.util.ArrayList;
import java.util.List;


public class TrainCompany {
    private List<Freight> freightTrains = new ArrayList<>();
    private List<IC> ICtrains = new ArrayList<>();
    private List<Passenger> passangerTrains = new ArrayList<Passenger>();

     private float expenses;
     private float income;
     private float profit;
     private final int MINPASSANGERS = 115;
     private final int MAXPASSANGERS = 250;
     private final int ICBLITZCHANCE = 8;
     private final int DAYSINAMONTH =  30;


     public void addTrain(Train train){
         if(train instanceof  IC){
             ICtrains.add((IC) train);
             expenses +=  train.getCost();
         }else if(train instanceof Passenger){
             passangerTrains.add((Passenger) train);
             expenses += train.getCost();
         }else{
             freightTrains.add((Freight) train);
             expenses += train.getCost();
         }
    }

    public void calculateMonthlyICRevenue(){
        float monthlyRevenue =0;
        int passengersPerMonth =0;
        for (int i = 0; i < DAYSINAMONTH; i++) {
            for (IC iCtrain : ICtrains) {
                int passengers = RandomUtil.generateRandomNumberBetween(MINPASSANGERS, MAXPASSANGERS);
                int passengersWhoBuyOntrain = passengers / 4;
                int passengersWhoBuyTicketOnline = passengers - passengersWhoBuyOntrain;
                monthlyRevenue += iCtrain.getTicketPrice() * passengersWhoBuyTicketOnline;
                passengersPerMonth += passengersWhoBuyTicketOnline;
            }
        }
        if(RandomUtil.generateRandomNumberBetween(1,100) < ICBLITZCHANCE){
            monthlyRevenue += punishtrainBlitzers(passengersPerMonth);
        }
        income += monthlyRevenue;
    }

    public float punishtrainBlitzers(int passengersPerMonth){
        return (passengersPerMonth / 5) * 6;
    }

    public void calculateMonthlyPassengerRevenue(){
        float monthlyRevenue =0;
        int passengersPerMonth =0;
        for (int i = 0; i < DAYSINAMONTH; i++) {
            for (Passenger passengerTrain : passangerTrains) {
                int passengers = RandomUtil.generateRandomNumberBetween(MINPASSANGERS, MAXPASSANGERS);
                int passengersWhoBuyOntrain = passengers / 4;
                int passengersWhoBuyTicketOnline = passengers - passengersWhoBuyOntrain;
                monthlyRevenue += passengerTrain.getTicketPrice() * passengersWhoBuyTicketOnline;
                passengersPerMonth += passengersWhoBuyTicketOnline;
            }
        }
        if(RandomUtil.generateRandomNumberBetween(1,100) < ICBLITZCHANCE){
            monthlyRevenue += punishtrainBlitzers(passengersPerMonth);
        }
        income += monthlyRevenue;
    }

     public void calculateMonthlyFreightRevenue(){
         for (Freight train: freightTrains) {
                 float monthlyRevenue = 550;
                 if(RandomUtil.generateRandomNumberBetween(1,100)<35)
                     monthlyRevenue += 110;
                    income += monthlyRevenue;
         }
    }

    public void calculateIncome(){
        calculateMonthlyFreightRevenue();
        calculateMonthlyICRevenue();
        calculateMonthlyPassengerRevenue();
    }


    public float getExpenses() {
        return expenses;
    }

    public float getIncome() {
        return income;
    }

    public double calculateProfit(){
         return this.profit = income -expenses;
    }

    @Override
    public String toString() {
        return "TrainCompany{" +
                "profit=" + profit +
                '}';
    }
}
