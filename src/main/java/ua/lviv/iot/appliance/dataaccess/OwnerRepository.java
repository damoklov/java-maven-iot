package ua.lviv.iot.appliance.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.appliance.model.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer> {

}
