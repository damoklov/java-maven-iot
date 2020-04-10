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
    return manufacturerService.getManufacturer(manufacturerId);
  }

  @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  public Manufacturer createManufacturer(@RequestBody Manufacturer manufacturer) {
    manufacturerService.createManufacturer(manufacturer);
    return manufacturer;
  }

  @PutMapping(path = "/{id}")
  public ResponseEntity<Manufacturer>  updateManufacturer(@PathVariable("id") Integer manufacturerId, @RequestBody Manufacturer manufacturer) {
    return manufacturerService.updateManufacturer(manufacturer, manufacturerId);
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Manufacturer> deleteManufacturer(@PathVariable("id") Integer manufacturerId) {
    HttpStatus status = manufacturerService.deleteManufacturer(manufacturerId);
    return ResponseEntity.status(status).build();
  }

  public ManufacturerService getManufacturerService() {
    return manufacturerService;
  }

  public void setManufacturerService(ManufacturerService manufacturerService) {
    this.manufacturerService = manufacturerService;
  }
}
