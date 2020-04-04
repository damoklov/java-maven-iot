package ua.lviv.iot.appliance.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.appliance.model.HomeAppliance;

public interface HomeApplianceRepository extends JpaRepository<HomeAppliance, Integer> {
}
