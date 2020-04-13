package ua.lviv.iot.appliance.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.appliance.dataaccess.HomeApplianceRepository;
import ua.lviv.iot.appliance.model.HomeAppliance;


@Service
public class HomeApplianceService extends AbstractService<HomeAppliance> {

  @Autowired
  private HomeApplianceRepository homeApplianceRepository;

  public HomeAppliance updateHomeAppliance(HomeAppliance appliance, Integer applianceId) {
    if (homeApplianceRepository.existsById(applianceId)) {
      HomeAppliance oldAppliance = new HomeAppliance(homeApplianceRepository.findById(applianceId).get());
      appliance.setId(applianceId);
      homeApplianceRepository.save(appliance);
      return oldAppliance;
    } else {
      return null;
    }
  }

  @Override
  protected JpaRepository<HomeAppliance, Integer> getRepository() {
    return homeApplianceRepository;
  }

  public List<HomeAppliance> findAll() {
    return homeApplianceRepository.findAll();
  }
}
