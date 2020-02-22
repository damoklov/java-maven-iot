package ua.lviv.iot.appliance.model;

import java.util.Objects;

public class HomeAppliance implements Comparable<HomeAppliance> {
    static final int DEFAULT_POWER_CONSUMPTION = 0;
    static final double DEFAULT_USAGE = 0.0;
    static final double DEFAULT_REPAIR_PRICE = 0.0;
    static final String DEFAULT_LOCATION = "N/A";
    static final String DEFAULT_NAME = "N/A";
    static final boolean DEFAULT_SOCKET_STATE = false;
    private static final double pricePerWatt = 0.01319;

    private int powerConsumption;
    private double hoursPerMonthUsage;
    private double repairPrice;
    private String locationInHouse;
    private String applianceName;
    private boolean pluggedIntoSocket;

    public HomeAppliance(int powerConsumption, double repairPrice, double hoursPerMonthUsage, String locationInHouse, String applianceName, boolean pluggedIntoSocket) {
        this.powerConsumption = powerConsumption;
        this.hoursPerMonthUsage = hoursPerMonthUsage;
        this.repairPrice = repairPrice;
        this.locationInHouse = locationInHouse;
        this.applianceName = applianceName;
        this.pluggedIntoSocket = pluggedIntoSocket;
    }

    public HomeAppliance() {
        this(DEFAULT_POWER_CONSUMPTION, DEFAULT_USAGE, DEFAULT_REPAIR_PRICE, DEFAULT_LOCATION, DEFAULT_NAME, DEFAULT_SOCKET_STATE);
    }

    public final double computeFinalMoneySpentPerMonthInUSD() {
        return HomeAppliance.pricePerWatt * this.powerConsumption * this.hoursPerMonthUsage;
    }

    public final double computeFinalPowerConsumptionInWatts() {
        return this.powerConsumption * this.hoursPerMonthUsage;
    }

    public int getPowerConsumption() {
        return this.powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public double getHoursPerMonthUsage() {
        return this.hoursPerMonthUsage;
    }

    public void setHoursPerMonthUsage(double hoursPerMonthUsage) {
        this.hoursPerMonthUsage = hoursPerMonthUsage;
    }

    public double getRepairPrice() {
        return this.repairPrice;
    }

    public void setRepairPrice(double repairPrice) {
        this.repairPrice = repairPrice;
    }

    public String getLocationInHouse() {
        return this.locationInHouse;
    }

    public void setLocationInHouse(String locationInHouse) {
        this.locationInHouse = locationInHouse;
    }

    public String getApplianceName() {
        return this.applianceName;
    }

    public void setApplianceName(String applianceName) {
        this.applianceName = applianceName;
    }

    public boolean getPluggedIntoSocket() {
        return this.pluggedIntoSocket;
    }

    public void setPluggedIntoSocket(boolean pluggedIntoSocket) {
        this.pluggedIntoSocket = pluggedIntoSocket;
    }

    private String booleanToString(boolean needsSocket) {
        return needsSocket ? "yes" : "no";
    }

    @Override
    public String toString() {
        return "{" + this.getClass().getSimpleName() + "} " +
                "power consumption: " + this.powerConsumption + "W, " +
                "hours pet month usage: " + this.hoursPerMonthUsage + ", " +
                "repair price: $" + this.repairPrice + ", " +
                "location: " + this.locationInHouse + ", " +
                "name: " + this.applianceName + ", " +
                "plugged into socket: " + booleanToString(this.pluggedIntoSocket);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HomeAppliance)) return false;
        HomeAppliance that = (HomeAppliance) o;
        return powerConsumption == that.powerConsumption &&
                Double.compare(that.hoursPerMonthUsage, hoursPerMonthUsage) == 0 &&
                Double.compare(that.repairPrice, repairPrice) == 0 &&
                pluggedIntoSocket == that.pluggedIntoSocket &&
                locationInHouse.equals(that.locationInHouse) &&
                applianceName.equals(that.applianceName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(powerConsumption, hoursPerMonthUsage, repairPrice, locationInHouse, applianceName, pluggedIntoSocket);
    }

    @Override
    public int compareTo(HomeAppliance o) {
        return (Integer.compare(this.getPowerConsumption(), ((HomeAppliance) o).getPowerConsumption()));
    }
}
