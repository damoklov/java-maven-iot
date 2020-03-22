package ua.lviv.iot.appliance.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.appliance.model.HomeAppliance;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RequestMapping("/appliance")
@RestController
public class HomeApplianceController {

  private static Map<Integer, HomeAppliance> homeApplianceHashMap = new HashMap<>();
  private static AtomicInteger idCounter = new AtomicInteger();

  @GetMapping
  public List<HomeAppliance> getHomeAppliance(){
    return new LinkedList<>(homeApplianceHashMap.values());
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<Object> getHomeAppliance(final @PathVariable("id") Integer applianceId){
    HomeAppliance homeAppliance = homeApplianceHashMap.get(applianceId);
    ResponseEntity<Object> response = homeAppliance == null? new ResponseEntity<>(HttpStatus.NOT_FOUND)
            : new ResponseEntity<>(homeAppliance, HttpStatus.OK);
    return response;
  }

  @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
  public HomeAppliance createHomeAppliance(final @RequestBody HomeAppliance homeAppliance){
    homeAppliance.setId(idCounter.incrementAndGet());
    homeApplianceHashMap.put(homeAppliance.getId(), homeAppliance);
    return homeAppliance;
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Object> deleteHomeAppliance(final @PathVariable("id") Integer applianceId){
    HttpStatus status = homeApplianceHashMap.remove(applianceId) == null? HttpStatus.NOT_FOUND
            : HttpStatus.OK;
    return ResponseEntity.status(status).build();
  }

  @PutMapping(path = "/{id}")
  public ResponseEntity<Object> updateHomeAppliance(final @PathVariable("id") Integer applianceId, final @RequestBody HomeAppliance homeAppliance){
    homeAppliance.setId(applianceId);
    ResponseEntity<Object> response = homeApplianceHashMap.put(applianceId, homeAppliance) == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
            : new ResponseEntity<>(homeAppliance, HttpStatus.OK);
    return response;
  }
}
