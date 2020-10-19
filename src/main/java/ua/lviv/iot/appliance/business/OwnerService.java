package ua.lviv.iot.appliance.business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.appliance.dataaccess.OwnerRepository;
import ua.lviv.iot.appliance.model.Owner;

@Service
public class OwnerService extends AbstractService<Owner> {

  @Autowired
  private OwnerRepository ownerRepository;

  public Owner updateOwner(Owner owner, Integer ownerId) {
    if (ownerRepository.existsById(ownerId)) {
      Owner oldOwner = new Owner(ownerRepository.findById(ownerId).get());
      owner.setId(ownerId);
      ownerRepository.save(owner);
      return oldOwner;
    } else {
      return null;
    }
  }

  @Override
  protected JpaRepository<Owner, Integer> getRepository() {
    return ownerRepository;
  }

  public List<Owner> findAll() {
    return ownerRepository.findAll();
  }
}
