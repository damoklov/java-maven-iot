package ua.lviv.iot.appliance.business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.lviv.iot.appliance.dataaccess.OwnerRepository;
import ua.lviv.iot.appliance.model.Owner;

@Service
public class OwnerService {
  @Autowired
  private OwnerRepository ownerRepository;

  public Owner createOwner(Owner owner) {
    return ownerRepository.save(owner);
  }

  public List<Owner> findAll() {
    return this.ownerRepository.findAll();
  }

  public ResponseEntity<Owner> getOwner(Integer ownerId) {
    if (ownerRepository.existsById(ownerId)) {
      Owner owner = ownerRepository.findById(ownerId).get();
      return new ResponseEntity<>(owner, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<Owner> updateOwner(Owner owner, Integer ownerId) {
    if (ownerRepository.existsById(ownerId)) {
      Owner oldOwner = new Owner(ownerRepository.findById(ownerId).get());
      owner.setId(ownerId);
      ownerRepository.save(owner);
      return new ResponseEntity<>(oldOwner, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  public List<Owner> getAllOwners() {
    return ownerRepository.findAll();
  }

  public HttpStatus deleteOwner(Integer ownerId) {
    if (ownerRepository.existsById(ownerId)) {
      ownerRepository.deleteById(ownerId);
      return HttpStatus.OK;
    } else {
      return HttpStatus.NOT_FOUND;
    }
  }
}
