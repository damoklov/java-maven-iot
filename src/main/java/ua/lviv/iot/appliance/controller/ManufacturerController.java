package ua.lviv.iot.appliance.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.appliance.business.ManufacturerService;
import ua.lviv.iot.appliance.model.Manufacturer;

@RequestMapping("/manufacturers")
@RestController
public class ManufacturerController {

  @Autowired
  private ManufacturerService manufacturerService;

  @GetMapping
  public List<Manufacturer> getAllManufacturers() {
    return manufacturerService.findAll();
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<Manufacturer> getManufacturer(@PathVariable("id") Integer manufacturerId) {
    Manufacturer manufacturer = manufacturerService.findById(manufacturerId);
    if (manufacturer != null) {
      return new ResponseEntity<>(manufacturer, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  public ResponseEntity<Manufacturer> createManufacturer(@RequestBody Manufacturer manufacturer) {
    Manufacturer newManufacturer = manufacturerService.create(manufacturer);
    if (newManufacturer != null) {
      return new ResponseEntity<>(newManufacturer, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping(path = "/{id}")
  public ResponseEntity<Manufacturer> updateManufacturer(@PathVariable("id") Integer manufacturerId, @RequestBody Manufacturer manufacturer) {
    Manufacturer oldManufacturer = manufacturerService.updateManufacturer(manufacturer, manufacturerId);
    if (oldManufacturer != null) {
      return new ResponseEntity<>(oldManufacturer, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Manufacturer> deleteManufacturer(@PathVariable("id") Integer manufacturerId) {
    if (manufacturerService.delete(manufacturerId) != null) {
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
