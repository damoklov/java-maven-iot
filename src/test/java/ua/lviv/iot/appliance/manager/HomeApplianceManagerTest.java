package ua.lviv.iot.appliance.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.appliance.model.HomeAppliance;
import ua.lviv.iot.appliance.model.Kettle;
import ua.lviv.iot.appliance.model.Quality;
import ua.lviv.iot.appliance.model.TV;
import ua.lviv.iot.appliance.model.WashingMachine;

public class HomeApplianceManagerTest {
  protected HomeApplianceManager homeApplianceManager;
  protected TV testTV1;
  protected TV testTV2;
  protected Kettle testKettle;
  protected WashingMachine testWashingMachine;

  /**
   * Create test objects.
   * @result Test objects will be created,
   *         and homeApplianceManager will no longer be <code>null</code>
   */
  @BeforeEach
  public void setUp() {
    testTV1 = new TV(120, 70.00, 117.5, "Living Room", "Plasma", true, Quality.UHD, 42);
    testTV2 = new TV(80, 27.50, 84.2, "Kitchen", "Small TV", true, Quality.HD, 42);
    testKettle = new Kettle(0, 45.00, 40.0, "Kitchen", "Kettle", false, 20.0, 2.5);
    testWashingMachine = new WashingMachine(200, 115.00, 38.0, "Bathroom", "Washer", true, 60.0, 30);
    homeApplianceManager = new HomeApplianceManager();
    homeApplianceManager.addHomeAppliance(testTV1);
    homeApplianceManager.addHomeAppliance(testTV2);
    homeApplianceManager.addHomeAppliance(testKettle);
    homeApplianceManager.addHomeAppliance(testWashingMachine);
  }

  @Test
  public void testAddHomeAppliance() {
    assertEquals(4, homeApplianceManager.getAllHomeAppliance().size());
    homeApplianceManager.addHomeAppliance(new TV());
    assertEquals(5, homeApplianceManager.getAllHomeAppliance().size());
    assertEquals(new TV(), homeApplianceManager.getHomeApplianceAtIndex(4));
  }

  @Test
  public void testRemoveHomeApplianceAtIndex() {
    assertEquals(4, homeApplianceManager.getAllHomeAppliance().size());
    assertEquals(new Kettle(0, 45.00, 40.0, "Kitchen", "Kettle", false, 20.0, 2.5), this.homeApplianceManager.getHomeApplianceAtIndex(2));
    homeApplianceManager.removeHomeApplianceAtIndex(2);
    assertNotEquals(new Kettle(0, 45.00, 40.0, "Kitchen", "Kettle", false, 20.0, 2.5), this.homeApplianceManager.getHomeApplianceAtIndex(2));
    assertEquals(3, homeApplianceManager.getAllHomeAppliance().size());
  }

  @Test
  public void testAddMultipleHomeAppliances() {
    ArrayList<HomeAppliance> listOfHomeAppliances = new ArrayList<>();
    listOfHomeAppliances.add(new TV());
    listOfHomeAppliances.add(new WashingMachine());
    assertEquals(4, homeApplianceManager.getAllHomeAppliance().size());
    homeApplianceManager.addMultipleHomeAppliances(listOfHomeAppliances);
    assertEquals(6, homeApplianceManager.getAllHomeAppliance().size());
  }

  @Test
  public void testFindMostCostlyApplianceByPowerUsage() {
    assertEquals(new WashingMachine(200, 115.00, 38.0, "Bathroom", "Washer", true, 60.0, 30), homeApplianceManager.getHomeApplianceAtIndex(3));
    for (int currentIndex = 0; currentIndex < homeApplianceManager.getAllHomeAppliance().size(); currentIndex++) {
      assertTrue(homeApplianceManager.findMostCostlyApplianceByPowerUsage().getPowerConsumption() >= homeApplianceManager.getAllHomeAppliance().get(currentIndex).getPowerConsumption());
    }
  }

  @Test
  public void testSummarizeTotalMoneySpent() {
    final double DELTA = 0.000000003;
    final double expectedTotalMoneySpend = (120 * 117.5 + 80 * 84.2 + 0 * 40.0 + 200 * 38.0) * 0.01319;
    assertEquals(expectedTotalMoneySpend, homeApplianceManager.summarizeTotalMoneySpent(), DELTA);
  }

  @Test
  public void testSummarizeTotalPowerUsage() {
    final double expectedTotalPowerUsage = 120 * 117.5 + 80 * 84.2 + 0 * 40.0 + 200 * 38.0;
    assertEquals(expectedTotalPowerUsage, homeApplianceManager.summarizeTotalPowerUsage());
  }

  @Test
  public void testGetAllHomeAppliance() {
    final ArrayList<HomeAppliance> expectedArrayOfAppliance = new ArrayList<>(homeApplianceManager.getAllHomeAppliance());
    assertEquals(expectedArrayOfAppliance, homeApplianceManager.getAllHomeAppliance());
  }
}