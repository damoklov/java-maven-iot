package ua.lviv.iot.appliance.manager;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import ua.lviv.iot.appliance.model.HomeAppliance;

public class HomeApplianceWriter {
  private Writer writer;

  public void setWriter(final Writer writer) {
    this.writer = writer;
  }

  /**
   * Writes data to a CSV file.
   * @result CSV file with objects' information.
   */
  public void writeToFile(List<HomeAppliance> appliances) throws IOException {
    for (HomeAppliance currentAppliance : appliances) {
      writeLine(this.writer, currentAppliance.getHeaders());
      writeLine(this.writer, currentAppliance.toCSV());
    }
    this.writer.flush();
  }

  private void writeLine(Writer writer, String line) throws IOException {
    writer.write(line + "\n");
  }

  @Override
  public String toString() {
    return this.writer.toString();
  }
}
