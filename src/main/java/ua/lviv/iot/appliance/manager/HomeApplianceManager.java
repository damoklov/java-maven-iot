package ua.lviv.iot.appliance.manager;

import ua.lviv.iot.appliance.model.HomeAppliance;

import java.util.ArrayList;


public class HomeApplianceManager {
    private ArrayList<HomeAppliance> listOfHomeAppliances;

    public HomeApplianceManager() {
        this.listOfHomeAppliances = new ArrayList<>();
    }

    public void addHomeAppliance(HomeAppliance homeAppliance){
        this.listOfHomeAppliances.add(homeAppliance);
    }

    public void removeHomeApplianceAtIndex(int index){
        this.listOfHomeAppliances.remove(index);
    }

    public HomeAppliance getHomeApplianceAtIndex(int index){
        return this.listOfHomeAppliances.get(index);
    }

    public void addMultipleHomeAppliances(ArrayList<HomeAppliance> homeAppliances){
        this.listOfHomeAppliances.addAll(homeAppliances);
    }

    public HomeAppliance findMostCostlyApplianceByPowerUsage(){
        HomeApplianceManagerUtils.sortHomeApplianceByPowerUsage(this.listOfHomeAppliances, SortType.DESCENDING);
        return this.listOfHomeAppliances.get(0);
    }

    public double summarizeTotalMoneySpent() {
        double totalMoneySpent = 0.0;
        for (HomeAppliance homeAppliance : this.listOfHomeAppliances) {
            totalMoneySpent += homeAppliance.computeFinalMoneySpentPerMonthInUSD();
        }
        return totalMoneySpent;
    }

    public double summarizeTotalPowerUsage() {
        double totalPowerUsed = 0.0;
        for (HomeAppliance homeAppliance : this.listOfHomeAppliances) {
            totalPowerUsed += homeAppliance.computeFinalPowerConsumptionInWatts();
        }
        return totalPowerUsed;
    }

    public ArrayList<HomeAppliance> getAllHomeAppliance(){
        return this.listOfHomeAppliances;
    }
}
