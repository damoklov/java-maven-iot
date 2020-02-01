package ua.lviv.iot.appliance.model;

import java.util.Objects;

public class WashingMachine extends HomeAppliance {
    private static final double DEFAULT_WASHING_TIME = 0.0;
    private static final int DEFAULT_CAPACITY = 0;

    private double washingTime;
    private int itemCapacity;

    public WashingMachine(int powerConsumption, double repairPrice, double hoursInMonthUsage, String locationInHouse, String applianceName, boolean needsPowerFromSocket, double washingTime, int itemCapacity) {
        super(powerConsumption, repairPrice, hoursInMonthUsage, locationInHouse, applianceName, needsPowerFromSocket);
        this.washingTime = washingTime;
        this.itemCapacity = itemCapacity;
    }

    public WashingMachine() {
        this(DEFAULT_POWER_CONSUMPTION, DEFAULT_USAGE, DEFAULT_REPAIR_PRICE, DEFAULT_LOCATION, DEFAULT_NAME, DEFAULT_SOCKET_STATE, DEFAULT_WASHING_TIME, DEFAULT_CAPACITY);
    }

    public double getWashingTime(){
        return this.washingTime;
    }

    public void setWashingTime(double washingTime){
        this.washingTime = washingTime;
    }

    public int getItemCapacity(){
        return this.itemCapacity;
    }

    public void setItemCapacity(int itemCapacity){
        this.itemCapacity = itemCapacity;
    }

    @Override
    public String toString() {
        return super.toString() + ", " +
                "time to wash: " + this.washingTime + "m, " +
                "item capacity: " + this.itemCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WashingMachine)) return false;
        if (!super.equals(o)) return false;
        WashingMachine that = (WashingMachine) o;
        return Double.compare(that.washingTime, washingTime) == 0 &&
                Double.compare(that.itemCapacity, itemCapacity) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), washingTime, itemCapacity);
    }
}

