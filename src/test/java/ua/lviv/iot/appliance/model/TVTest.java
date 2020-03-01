package ua.lviv.iot.appliance.model;

import de.smartics.util.test.theories.ObjectTheories;
import net.sf.beanrunner.BeanRunner;
import org.junit.experimental.theories.DataPoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TVTest extends ObjectTheories {
  @DataPoint
  public final static TV TvForOverrideMethodsTest = new TV();
  @DataPoint
  public final static TV TvForOverrideMethodsTest2 = new TV(60, 25.5, 60.0, "Bedroom", "Lamp", false, Quality.FHD, 15);
  private TV TVWithParameters;
  private TV TVDefault;
  private BeanRunner beanRunner = new BeanRunner();

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