package ua.lviv.iot.appliance.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

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

  private Map<Integer, HomeAppliance> homeAppliance = new HashMap<>();
  private AtomicInteger idCounter = new AtomicInteger();

  @Autowired
  private HomeApplianceService homeApplianceService;

  @GetMapping(path = "/{id}")
  public HomeAppliance getHomeAppliance(@PathVariable("id") Integer applianceId) {
    return homeAppliance.get(applianceId);
  }

  @GetMapping
  public List<HomeAppliance> getAllHomeAppliance() {
    return new LinkedList<>(homeAppliance.values());
  }

  @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  public HomeAppliance createHomeAppliance(@RequestBody HomeAppliance appliance) {
    appliance.setId(idCounter.incrementAndGet());
    homeAppliance.put(appliance.getId(), appliance);
    homeApplianceService.createHomeAppliance(appliance);
    return appliance;
  }

  @PutMapping(path = "/{id}")
  public HomeAppliance updateHomeAppliance(@PathVariable("id") Integer applianceId, @RequestBody HomeAppliance appliance) {
    appliance.setId(applianceId);
    return homeAppliance.put(applianceId, appliance);
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity deleteHomeAppliance(@PathVariable("id") Integer applianceId) {
    HttpStatus status = homeAppliance.remove(applianceId) == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
    return ResponseEntity.status(status).build();
  }

  public HomeApplianceService getHomeApplianceService() {
    return this.homeApplianceService;
  }

  public void setHomeApplianceService(HomeApplianceService homeApplianceService) {
    this.homeApplianceService = homeApplianceService;
  }
}
