package ua.lviv.iot.appliance.model;

import java.util.Objects;

public class TV extends HomeAppliance {
  private static final Quality DEFAULT_QUALITY = null;
  private static final int DEFAULT_CHANNELS = 0;

  private Quality quality;
  private int numChannelsAvailable;

  /**
   * Creates object of appliance (TV).
   * @result object is created.
   */
  public TV(int powerConsumption, double repairPrice, double hoursInMonthUsage,
            String locationInHouse, String applianceName, boolean needsPowerFromSocket,
            Quality quality, int numChannelsAvailable) {
    super(powerConsumption, repairPrice, hoursInMonthUsage,
            locationInHouse, applianceName, needsPowerFromSocket);
    this.quality = quality;
    this.numChannelsAvailable = numChannelsAvailable;
  }

  public TV() {
    this(DEFAULT_POWER_CONSUMPTION, DEFAULT_USAGE, DEFAULT_REPAIR_PRICE, DEFAULT_LOCATION,
            DEFAULT_NAME, DEFAULT_SOCKET_STATE, DEFAULT_QUALITY, DEFAULT_CHANNELS);
  }

  public Quality getQuality() {
    return this.quality;
  }

  public void setQuality(Quality quality) {
    this.quality = quality;
  }

  public int getNumChannelsAvailable() {
    return this.numChannelsAvailable;
  }

  public void setNumChannelsAvailable(int numChannelsAvailable) {
    this.numChannelsAvailable = numChannelsAvailable;
  }

  @Override
  public String toString() {
    return super.toString() + ", "
            + "manufacturer: " + this.quality + ", "
            + "channels available: " + this.numChannelsAvailable;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (!(object instanceof TV)) {
      return false;
    }
    if (!super.equals(object)) {
      return false;
    }
    TV tv = (TV) object;
    return numChannelsAvailable == tv.numChannelsAvailable
            && quality == tv.quality;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), quality, numChannelsAvailable);
  }

  public String getHeaders() {
    return super.getHeaders() + ", quality, numChannelsAvailable";
  }

  public String toCSV() {
    return super.toCSV() + ", " + this.quality + ", " + this.numChannelsAvailable;
  }

}
