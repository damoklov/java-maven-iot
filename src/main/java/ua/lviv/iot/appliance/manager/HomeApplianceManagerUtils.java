package ua.lviv.iot.appliance.manager;

import ua.lviv.iot.appliance.model.HomeAppliance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HomeApplianceManagerUtils {
    public static void sortHomeApplianceByPowerUsage(ArrayList<HomeAppliance> homeApplianceList, SortType sortType){
        Collections.sort(homeApplianceList, powerComparator);
        if (sortType == SortType.ASCENDING){
            Collections.reverse(homeApplianceList);
        }
    }

    public static void sortHomeApplianceByName(ArrayList<HomeAppliance> homeApplianceList, SortType sortType){
        Collections.sort(homeApplianceList, nameComparator);
        if (sortType == SortType.DESCENDING){
            Collections.reverse(homeApplianceList);
        }
    }

    public static void sortHomeApplianceByTimeUsage(ArrayList<HomeAppliance> homeApplianceList, SortType sortType){
        Collections.sort(homeApplianceList, usageComparator);
        if (sortType == SortType.ASCENDING){
            Collections.reverse(homeApplianceList);
        }
    }

    private static Comparator<HomeAppliance> powerComparator = new Comparator<>() {
        @Override
        public int compare(HomeAppliance homeAppliance1, HomeAppliance homeAppliance2) {
            return (Integer.compare(homeAppliance2.getPowerConsumption(), homeAppliance1.getPowerConsumption()));
        }
    };

    private static Comparator<HomeAppliance> nameComparator = new Comparator<>() {
        @Override
        public int compare(HomeAppliance homeAppliance1, HomeAppliance homeAppliance2) {
            return (homeAppliance1.getApplianceName().compareTo(homeAppliance2.getApplianceName()));
        }
    };

    private static Comparator<HomeAppliance> usageComparator = new Comparator<>() {
        @Override
        public int compare(HomeAppliance homeAppliance1, HomeAppliance homeAppliance2) {
            return (Double.compare(homeAppliance2.getHoursPerMonthUsage(), homeAppliance1.getHoursPerMonthUsage()));
        }
    };
}
