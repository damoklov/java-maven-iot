package ua.lviv.iot.appliance.model;

import java.util.Objects;

public class Kettle extends HomeAppliance {
  private static final double DEFAULT_BOILING_TIME = 0.0;
  private static final double DEFAULT_CAPACITY = 0.0;

  private double timeToBoil;
  private double waterCapacity;

  /**
   * Creates object of appliance (Kettle).
   * @result object is created.
   */
  public Kettle(int powerConsumption, double repairPrice, double hoursInMonthUsage,
                String locationInHouse, String applianceName, boolean needsPowerFromSocket,
                double timeToBoil, double waterCapacity) {
    super(powerConsumption, repairPrice, hoursInMonthUsage,
            locationInHouse, applianceName, needsPowerFromSocket);
    this.timeToBoil = timeToBoil;
    this.waterCapacity = waterCapacity;
  }

  public Kettle() {
    this(DEFAULT_POWER_CONSUMPTION, DEFAULT_USAGE, DEFAULT_REPAIR_PRICE, DEFAULT_LOCATION,
            DEFAULT_NAME, DEFAULT_SOCKET_STATE, DEFAULT_BOILING_TIME, DEFAULT_CAPACITY);
  }

  public double getTimeToBoil() {
    return this.timeToBoil;
  }

  public void setTimeToBoil(double timeToBoil) {
    this.timeToBoil = timeToBoil;
  }

  public double getWaterCapacity() {
    return this.waterCapacity;
  }

  public void setWaterCapacity(double waterCapacity) {
    this.waterCapacity = waterCapacity;
  }

  @Override
  public String toString() {
    return super.toString() + ", "
            + "time to boil: " + this.timeToBoil + "s, "
            + "water capacity: " + this.waterCapacity + "L";
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (!(object instanceof Kettle)) {
      return false;
    }
    if (!super.equals(object)) {
      return false;
    }
    Kettle kettle = (Kettle) object;
    return Double.compare(kettle.timeToBoil, timeToBoil) == 0
            && Double.compare(kettle.waterCapacity, waterCapacity) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), timeToBoil, waterCapacity);
  }

  public String getHeaders() {
    return super.getHeaders() + ", timeToBoil, waterCapacity";
  }

  public String toCSV() {
    return super.toCSV() + ", " + this.timeToBoil + ", " + this.waterCapacity;
  }
}
