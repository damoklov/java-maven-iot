package ua.lviv.iot.appliance.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.lviv.iot.appliance.dataaccess.HomeApplianceRepository;
import ua.lviv.iot.appliance.model.HomeAppliance;


@Service
public class HomeApplianceService {

  @Autowired
  private HomeApplianceRepository homeApplianceRepository;

  public HomeAppliance createHomeAppliance(HomeAppliance appliance) {
    return homeApplianceRepository.save(appliance);
  }

  public ResponseEntity<HomeAppliance> getHomeAppliance(Integer applianceId) {
    if (homeApplianceRepository.existsById(applianceId)) {
      HomeAppliance appliance = homeApplianceRepository.findById(applianceId).get();
      return new ResponseEntity<>(appliance,HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<HomeAppliance> updateHomeAppliance(HomeAppliance appliance, Integer applianceId) {
    if (homeApplianceRepository.existsById(applianceId)) {
      appliance.setId(applianceId);
      HomeAppliance updatedSweater = homeApplianceRepository.save(appliance);
      return new ResponseEntity<>(updatedSweater, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  public List<HomeAppliance> getAllHomeAppliance() {
    return homeApplianceRepository.findAll();
  }

  public HttpStatus deleteHomeAppliance(Integer applianceId) {
    if (homeApplianceRepository.existsById(applianceId)) {
      homeApplianceRepository.deleteById(applianceId);
      return HttpStatus.OK;
    } else {
      return HttpStatus.NOT_FOUND;
    }
  }

  public List<HomeAppliance> findAll() {
    return homeApplianceRepository.findAll();
  }
}
