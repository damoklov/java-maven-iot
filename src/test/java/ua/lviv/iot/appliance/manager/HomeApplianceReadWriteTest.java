package ua.lviv.iot.appliance.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.appliance.model.HomeAppliance;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeApplianceReadWriteTest extends HomeApplianceManagerTest {
  private static final String OUTPUT_PATH = "appliance.csv";
  private HomeApplianceWriter writer;

  @BeforeEach
  public void setUp() {
    super.setUp();
    this.writer = new HomeApplianceWriter();
  }

  @Test
  void testHomeApplianceWriter() {
    try (Writer fileWriter = new FileWriter(OUTPUT_PATH);) {
      this.writer.setWriter(fileWriter);
      this.writer.writeToFile(homeApplianceManager.getAllHomeAppliance());
    } catch (IOException e) {
      System.out.println("Error while writing to file!");
      e.printStackTrace();
    }
  }

  @Test
  void testHomeApplianceWriterToString() {
    List<HomeAppliance> homeAppliances = homeApplianceManager.getAllHomeAppliance();

    try (Writer expectedWriter = new StringWriter()) {
      this.writer.setWriter(expectedWriter);
      this.writer.writeToFile(homeAppliances);
    } catch (IOException e) {
      e.printStackTrace();
    }

    StringBuilder expectedString = new StringBuilder();
    for (HomeAppliance currentAppliance : homeAppliances) {
      expectedString.append(currentAppliance.getHeaders()).append("\n").append(currentAppliance.toCSV()).append("\n");
    }

    assertEquals(expectedString.toString(), this.writer.toString());
  }

  @Test
  void testHomeApplianceReader() {
      List<String> lines = HomeApplianceReader.readLinesFromFile(OUTPUT_PATH);
      System.out.println(lines);
  }
}