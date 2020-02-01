package ua.lviv.iot.appliance.model;

import de.smartics.util.test.theories.ObjectTheories;
import net.sf.beanrunner.BeanRunner;
import org.junit.experimental.theories.DataPoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TVTest extends ObjectTheories {
    private TV TVWithParameters;
    private TV TVDefault;
    private BeanRunner beanRunner = new BeanRunner();
    @DataPoint
    public final static TV TVForOverrideMethodsTest = new TV();
    @DataPoint
    public final static TV TVForOverrideMethodsTest2 = new TV(60, 25.5, 60.0, "Bedroom", "Lamp", false, Quality.FHD, 15);

    @BeforeEach
    void setUp() {
        beanRunner.addTestValue(Quality.class, Quality.FHD);
        TVWithParameters = new TV(60, 25.5, 60.0, "Bathroom", "Washer", true, Quality.HD, 7);
        TVDefault = new TV();
    }

    @Test
    void testSettersAndGetters() throws Exception {
        beanRunner.testBean(TVWithParameters);
    }
}