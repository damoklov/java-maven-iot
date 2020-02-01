package ua.lviv.iot.appliance.model;

import de.smartics.util.test.theories.CompareToTheory;
import org.junit.experimental.theories.DataPoint;

public class HomeApplianceCompareToTest extends CompareToTheory<HomeAppliance> {
    @DataPoint
    public static final HomeAppliance homeApplianceForComparingTests = new HomeAppliance();
    @DataPoint
    public final static HomeAppliance homeApplianceForComparingTests2 = new HomeAppliance(60, 25.5, 60.0, "Bedroom", "Lamp", false);
    @DataPoint
    public final static HomeAppliance homeApplianceForComparingTests3 = new HomeAppliance(80, 45.5, 60.0, "Bedroom", "Huge Lamp", true);
}
