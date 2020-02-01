package ua.lviv.iot.appliance.manager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HomeApplianceManagerUtilsTest extends HomeApplianceManagerTest {

    @Test
    void sortHomeApplianceByPowerUsage() {
        HomeApplianceManagerUtils.sortHomeApplianceByPowerUsage(homeApplianceManager.getAllHomeAppliance(), SortType.DESCENDING);
        assertEquals(testWashingMachine, homeApplianceManager.getHomeApplianceAtIndex(0));
        assertEquals(testTV1, homeApplianceManager.getHomeApplianceAtIndex(1));
        assertEquals(testTV2, homeApplianceManager.getHomeApplianceAtIndex(2));
        assertEquals(testKettle, homeApplianceManager.getHomeApplianceAtIndex(3));
        HomeApplianceManagerUtils.sortHomeApplianceByPowerUsage(homeApplianceManager.getAllHomeAppliance(), SortType.ASCENDING);
        assertEquals(testKettle, homeApplianceManager.getHomeApplianceAtIndex(0));
        assertEquals(testTV2, homeApplianceManager.getHomeApplianceAtIndex(1));
        assertEquals(testTV1, homeApplianceManager.getHomeApplianceAtIndex(2));
        assertEquals(testWashingMachine, homeApplianceManager.getHomeApplianceAtIndex(3));
    }

    @Test
    void sortHomeApplianceByName() {
        HomeApplianceManagerUtils.sortHomeApplianceByName(homeApplianceManager.getAllHomeAppliance(), SortType.DESCENDING);
        assertEquals(testWashingMachine, homeApplianceManager.getHomeApplianceAtIndex(0));
        assertEquals(testTV2, homeApplianceManager.getHomeApplianceAtIndex(1));
        assertEquals(testTV1, homeApplianceManager.getHomeApplianceAtIndex(2));
        assertEquals(testKettle, homeApplianceManager.getHomeApplianceAtIndex(3));
        HomeApplianceManagerUtils.sortHomeApplianceByName(homeApplianceManager.getAllHomeAppliance(), SortType.ASCENDING);
        assertEquals(testKettle, homeApplianceManager.getHomeApplianceAtIndex(0));
        assertEquals(testTV1, homeApplianceManager.getHomeApplianceAtIndex(1));
        assertEquals(testTV2, homeApplianceManager.getHomeApplianceAtIndex(2));
        assertEquals(testWashingMachine, homeApplianceManager.getHomeApplianceAtIndex(3));
    }

    @Test
    void sortHomeApplianceByTimeUsage() {
        HomeApplianceManagerUtils.sortHomeApplianceByTimeUsage(homeApplianceManager.getAllHomeAppliance(), SortType.DESCENDING);
        assertEquals(testTV1, homeApplianceManager.getHomeApplianceAtIndex(0));
        assertEquals(testTV2, homeApplianceManager.getHomeApplianceAtIndex(1));
        assertEquals(testKettle, homeApplianceManager.getHomeApplianceAtIndex(2));
        assertEquals(testWashingMachine, homeApplianceManager.getHomeApplianceAtIndex(3));
        HomeApplianceManagerUtils.sortHomeApplianceByTimeUsage(homeApplianceManager.getAllHomeAppliance(), SortType.ASCENDING);
        assertEquals(testWashingMachine, homeApplianceManager.getHomeApplianceAtIndex(0));
        assertEquals(testKettle, homeApplianceManager.getHomeApplianceAtIndex(1));
        assertEquals(testTV2, homeApplianceManager.getHomeApplianceAtIndex(2));
        assertEquals(testTV1, homeApplianceManager.getHomeApplianceAtIndex(3));
    }
}
