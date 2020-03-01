package ua.lviv.iot.appliance.model;

import de.smartics.util.test.theories.ObjectTheories;
import net.sf.beanrunner.BeanRunner;
import org.junit.experimental.theories.DataPoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class KettleTest extends ObjectTheories {
  @DataPoint
  public final static Kettle kettleForOverrideMethodsTest = new Kettle();
  @DataPoint
  public final static Kettle kettleForOverrideMethodsTest2 = new Kettle(60, 25.5, 60.0, "Bedroom", "Lamp", false, 120.0, 2.4);
  private Kettle kettleWithParameters;
  private Kettle kettleDefault;
  private BeanRunner beanRunner = new BeanRunner();

  @BeforeEach
  void setUp() {
    kettleWithParameters = new Kettle(60, 25.5, 60.0, "Bathroom", "Washer", true, 20.0, 1.5);
    kettleDefault = new Kettle();
  }

  @Test
  void testSettersAndGetters() throws Exception {
    beanRunner.testBean(kettleWithParameters);
  }
}