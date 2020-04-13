package ua.lviv.iot.appliance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.appliance.business.HomeApplianceService;
import ua.lviv.iot.appliance.model.HomeAppliance;


@RequestMapping("/appliance")
@RestController
public class HomeApplianceController {

  @Autowired
  private HomeApplianceService homeApplianceService;

  @GetMapping(path = "/{id}")
  public ResponseEntity<HomeAppliance> getHomeAppliance(@PathVariable("id") Integer applianceId) {
    HomeAppliance homeAppliance = homeApplianceService.findById(applianceId);
    if (homeAppliance != null) {
      return new ResponseEntity<>(homeAppliance, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping
  public List<HomeAppliance> getAllHomeAppliance() {
    return homeApplianceService.getAll();
  }

  @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  public ResponseEntity<HomeAppliance> createHomeAppliance(@RequestBody HomeAppliance appliance) {
    HomeAppliance homeAppliance = homeApplianceService.create(appliance);
    if (homeAppliance != null) {
      return new ResponseEntity<>(homeAppliance, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping(path = "/{id}")
  public ResponseEntity<HomeAppliance>  updateHomeAppliance(@PathVariable("id") Integer applianceId, @RequestBody HomeAppliance appliance) {
    HomeAppliance oldAppliance = homeApplianceService.updateHomeAppliance(appliance, applianceId);
    if (oldAppliance != null) {
      return new ResponseEntity<>(oldAppliance, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<HomeAppliance> deleteHomeAppliance(@PathVariable("id") Integer applianceId) {
    if (homeApplianceService.delete(applianceId) != null) {
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
