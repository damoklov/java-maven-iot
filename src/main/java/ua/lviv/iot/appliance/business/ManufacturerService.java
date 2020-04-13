package ua.lviv.iot.appliance.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.appliance.dataaccess.ManufacturerRepository;
import ua.lviv.iot.appliance.model.Manufacturer;

@Service
public class ManufacturerService extends AbstractService<Manufacturer> {

  @Autowired
  private ManufacturerRepository manufacturerRepository;

  public Manufacturer updateManufacturer(Manufacturer manufacturer, Integer manufacturerId) {
    if (manufacturerRepository.existsById(manufacturerId)) {
      Manufacturer oldManufacturer = new Manufacturer(manufacturerRepository.findById(manufacturerId).get());
      manufacturer.setId(manufacturerId);
      manufacturerRepository.save(manufacturer);
      return oldManufacturer;
    } else {
      return null;
    }
  }

  @Override
  protected JpaRepository<Manufacturer, Integer> getRepository() {
    return manufacturerRepository;
  }

  public List<Manufacturer> findAll() {
    return manufacturerRepository.findAll();
  }
}
