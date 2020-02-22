package ua.lviv.iot.appliance.model;

import de.smartics.util.test.theories.ObjectTheories;
import net.sf.beanrunner.BeanRunner;
import org.junit.experimental.theories.DataPoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeApplianceTest extends ObjectTheories{
    private HomeAppliance homeApplianceWithParameters;
    private HomeAppliance homeApplianceDefault;
    private BeanRunner beanRunner = new BeanRunner();
    @DataPoint
    public final static HomeAppliance homeApplianceForOverrideMethodsTest = new HomeAppliance();
    @DataPoint
    public final static HomeAppliance homeApplianceForOverrideMethodsTest2 = new HomeAppliance(60, 25.5, 60.0, "Bedroom", "Lamp", false);

    @BeforeEach
    void setUp() {
        homeApplianceWithParameters = new HomeAppliance(60, 25.5, 60.0, "Bedroom", "Lamp", true);
        homeApplianceDefault = new HomeAppliance();
    }

    @Test
    void testSettersAndGetters() throws Exception {
        beanRunner.testBean(homeApplianceWithParameters);
    }

    @Test
    void computeFinalMoneySpentPerMonthInUSD() {
        final double expectedMoneySpent = 0.01319 * 60 * 60.0;
        assertEquals(expectedMoneySpent, homeApplianceWithParameters.computeFinalMoneySpentPerMonthInUSD());
    }

    @Test
    void computeFinalPowerConsumptionInWatts() {
        final double expectedPowerConsumption = 60 * 60.0;
        assertEquals(expectedPowerConsumption, homeApplianceWithParameters.computeFinalPowerConsumptionInWatts());
    }
}


