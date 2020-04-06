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
    return homeApplianceService.getHomeAppliance(applianceId);
  }

  @GetMapping
  public List<HomeAppliance> getAllHomeAppliance() {
    return homeApplianceService.getAllHomeAppliance();
  }

  @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  public HomeAppliance createHomeAppliance(@RequestBody HomeAppliance appliance) {
    homeApplianceService.createHomeAppliance(appliance);
    return appliance;
  }

  @PutMapping(path = "/{id}")
  public ResponseEntity<HomeAppliance>  updateHomeAppliance(@PathVariable("id") Integer applianceId, @RequestBody HomeAppliance appliance) {
    return homeApplianceService.updateHomeAppliance(appliance, applianceId);
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<HomeAppliance> deleteHomeAppliance(@PathVariable("id") Integer applianceId) {
    HttpStatus status = homeApplianceService.deleteHomeAppliance(applianceId);
    return ResponseEntity.status(status).build();
  }

  public HomeApplianceService getHomeApplianceService() {
    return this.homeApplianceService;
  }

  public void setHomeApplianceService(HomeApplianceService homeApplianceService) {
    this.homeApplianceService = homeApplianceService;
  }
}
