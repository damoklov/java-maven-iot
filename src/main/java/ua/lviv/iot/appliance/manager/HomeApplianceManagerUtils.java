package ua.lviv.iot.appliance.manager;

import java.util.ArrayList;
import java.util.Comparator;

import ua.lviv.iot.appliance.model.HomeAppliance;

public class HomeApplianceManagerUtils {
  private static final HomeApplianceSorterByName APPLIANCE_SORTER = new HomeApplianceSorterByName();

  /**
   * Sorts appliance by time usage.
   * @result Sorted list of appliances.
   */
  public static void sortHomeApplianceByTimeUsage(ArrayList<HomeAppliance> homeApplianceList, SortType sortType) {
    /* Anonymous Inner Class */

    Comparator<HomeAppliance> comparator = new Comparator<HomeAppliance>() {

      @Override
      public int compare(HomeAppliance firstAppliance, HomeAppliance secondAppliance) {
        return Double.compare(firstAppliance.getHoursPerMonthUsage(),
                secondAppliance.getHoursPerMonthUsage());
      }
    };
    homeApplianceList.sort(sortType == SortType.ASCENDING ? comparator : comparator.reversed());
  }

  /**
   * Sorts appliance by power usage.
   * @result Sorted list of appliances.
   */
  public static void sortHomeApplianceByPowerUsage(ArrayList<HomeAppliance> homeApplianceList, SortType sortType) {
    Comparator<HomeAppliance> comparator = Comparator.comparing(HomeAppliance::getPowerConsumption);
    homeApplianceList.sort(sortType == SortType.ASCENDING ? comparator : comparator.reversed());
  }

  /**
   * Sorts appliance by name.
   * @result Sorted list of appliances.
   */
  public static void sortHomeApplianceByName(ArrayList<HomeAppliance> homeApplianceList, SortType sortType) {
    homeApplianceList.sort(sortType == SortType.ASCENDING ? APPLIANCE_SORTER : APPLIANCE_SORTER.reversed());
  }

  /**
   * Sorts appliance by repair price.
   * @result Sorted list of appliances.
   */
  public static void sortHomeApplianceByRepairPrice(ArrayList<HomeAppliance> homeApplianceList, SortType sortType) {
    homeApplianceList.sort(sortType == SortType.ASCENDING
            ? (o1, o2) -> (int) (o1.getRepairPrice() - o2.getRepairPrice())
            : (o1, o2) -> (int) (o2.getRepairPrice() - o1.getRepairPrice()));
  }

  static class HomeApplianceSorterByName implements Comparator<HomeAppliance> {
    @Override
    public int compare(HomeAppliance firstAppliance, HomeAppliance secondAppliance) {
      return firstAppliance.getApplianceName().compareTo(secondAppliance.getApplianceName());
    }
  }

  class HomeApplianceSorterByPowerUsage implements Comparator<HomeAppliance> {
    @Override
    public int compare(HomeAppliance firstAppliance, HomeAppliance secondAppliance) {
      return firstAppliance.getPowerConsumption() - secondAppliance.getPowerConsumption();
    }
  }
}
