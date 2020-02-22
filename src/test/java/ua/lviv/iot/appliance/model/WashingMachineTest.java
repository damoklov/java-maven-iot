package ua.lviv.iot.appliance.model;

import de.smartics.util.test.theories.ObjectTheories;
import net.sf.beanrunner.BeanRunner;
import org.junit.experimental.theories.DataPoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WashingMachineTest extends ObjectTheories {
    private WashingMachine washingMachineWithParameters;
    private WashingMachine washingMachineDefault;
    private BeanRunner beanRunner = new BeanRunner();
    @DataPoint
    public final static WashingMachine washingMachineForOverrideMethodsTest = new WashingMachine();
    @DataPoint
    public final static WashingMachine washingMachineForOverrideMethodsTest2 = new WashingMachine(60, 25.5, 60.0, "Bedroom", "Lamp", false, 120.0, 35);

    @BeforeEach
    void setUp() {
        washingMachineWithParameters = new WashingMachine(60, 25.5, 60.0, "Bathroom", "Washer", true, 100.0, 40);
        washingMachineDefault = new WashingMachine();
    }

    @Test
    void testSettersAndGetters() throws Exception {
        beanRunner.testBean(washingMachineWithParameters);
    }
}