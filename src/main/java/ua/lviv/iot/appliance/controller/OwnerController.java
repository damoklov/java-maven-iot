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
    return ownerService.findAll();
  }

  @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  public ResponseEntity<Owner> createOwner(@RequestBody Owner owner) {
    Owner newOwner = ownerService.create(owner);
    if (newOwner != null) {
      return new ResponseEntity<>(newOwner, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<Owner> getOwner(@PathVariable("id") Integer ownerId) {
    Owner owner = ownerService.findById(ownerId);
    if (owner != null) {
      return new ResponseEntity<>(owner, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping(path = "/{id}")
  public ResponseEntity<Owner> updateOwner(@PathVariable("id") Integer ownerId, @RequestBody Owner owner) {
    Owner oldOwner = ownerService.updateOwner(owner, ownerId);
    if (oldOwner != null) {
      return new ResponseEntity<>(oldOwner, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Owner> deleteOwner(@PathVariable("id") Integer ownerId) {
    if (ownerService.delete(ownerId) != null) {
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
