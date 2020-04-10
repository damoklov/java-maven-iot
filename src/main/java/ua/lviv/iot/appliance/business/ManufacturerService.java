package ua.lviv.iot.appliance.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.lviv.iot.appliance.dataaccess.ManufacturerRepository;
import ua.lviv.iot.appliance.model.Manufacturer;

@Service
public class ManufacturerService {
  @Autowired
  private ManufacturerRepository manufacturerRepository;

  public Manufacturer createManufacturer(Manufacturer manufacturer) {
    return manufacturerRepository.save(manufacturer);
  }

  public ResponseEntity<Manufacturer> getManufacturer(Integer manufacturerId) {
    if (manufacturerRepository.existsById(manufacturerId)) {
      Manufacturer manufacturer = manufacturerRepository.findById(manufacturerId).get();
      return new ResponseEntity<>(manufacturer, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<Manufacturer> updateManufacturer(Manufacturer manufacturer, Integer manufacturerId) {
    if (manufacturerRepository.existsById(manufacturerId)) {
      Manufacturer oldManufacturer = new Manufacturer(manufacturerRepository.findById(manufacturerId).get());
      manufacturer.setId(manufacturerId);
      manufacturerRepository.save(manufacturer);
      return new ResponseEntity<>(oldManufacturer, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  public List<Manufacturer> getAllManufacturers() {
    return manufacturerRepository.findAll();
  }

  public HttpStatus deleteManufacturer(Integer manufacturerId) {
    if (manufacturerRepository.existsById(manufacturerId)) {
      manufacturerRepository.deleteById(manufacturerId);
      return HttpStatus.OK;
    } else {
      return HttpStatus.NOT_FOUND;
    }
  }

  public List<Manufacturer> findAll() {
    return this.manufacturerRepository.findAll();
  }
}
