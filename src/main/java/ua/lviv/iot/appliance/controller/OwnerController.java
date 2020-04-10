package ua.lviv.iot.appliance.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.appliance.business.OwnerService;
import ua.lviv.iot.appliance.model.Owner;

@RequestMapping("/owners")
@RestController
public class OwnerController {
  @Autowired
  private OwnerService ownerService;

  @GetMapping
  public List<Owner> getAllOwners() {
    return this.ownerService.findAll();
  }

  @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  public Owner createOwner(@RequestBody Owner owner) {
    ownerService.createOwner(owner);
    return owner;
  }
  @GetMapping(path = "/{id}")
  public ResponseEntity<Owner> getOwner(@PathVariable("id") Integer ownerId) {
    return ownerService.getOwner(ownerId);
  }

  @PutMapping(path = "/{id}")
  public ResponseEntity<Owner>  updateOwner(@PathVariable("id") Integer ownerId, @RequestBody Owner owner) {
    return ownerService.updateOwner(owner, ownerId);
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Owner> deleteOwner(@PathVariable("id") Integer ownerId) {
    HttpStatus status = ownerService.deleteOwner(ownerId);
    return ResponseEntity.status(status).build();
  }
}
