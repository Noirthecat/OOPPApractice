package com.company.app;

import com.company.trains.Freight;
import com.company.trains.IC;
import com.company.trains.Passenger;
import com.company.trains.Train;
import com.company.util.RandomUtil;


import java.util.ArrayList;
import java.util.List;


public class TrainCompany {
    private List<Train> trains = new ArrayList<Train>();
    private List<IC> ICtrains = new ArrayList<>();
    private List<Passenger> passangerTrains = new ArrayList<>();

     private float expenses;
     private float income;
     private float profit;
     private final int MINPASSANGERS = 115;
     private final int MAXPASSANGERS = 250;
     private final int PASSENGERBLITZCHANCE = 10;
     private final int ICBLITZCHANCE = 8;
     private final int CHANCEOFFREIGHTTOGOFOREIGN = 35;
     private final int DAYSINAMONTH =  30;


     public void addTrain(Train train){
        trains.add(train);
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
         for (Train train: trains) {
             if(train instanceof Freight){
                 float monthlyRevenue = 550;
                 if(RandomUtil.generateRandomNumberBetween(1,100)<35)
                     monthlyRevenue += 110;
                    profit += monthlyRevenue;
             }
         }
    }

    public void addICTrainsToIcList(){
        for (Train train : trains) {
            if(train instanceof  IC){
                ICtrains.add((IC)train);
            }
        }
    }

    public void addPassengerTrainsToPassengerList(){
        for (Train train : trains) {
            if(train instanceof Passenger){
                passangerTrains.add((Passenger)train);
            }
        }
    }

    public float getProfit() {
        return profit;
    }

    @Override
    public String toString() {
        return "TrainCompany{" +
                "profit=" + profit +
                '}';
    }
}
