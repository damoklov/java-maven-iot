package ua.lviv.iot.appliance.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "manufacturer")
public class Manufacturer {
  private String name;
  private Integer foundationYear;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @OneToMany(mappedBy = "manufacturer", fetch = FetchType.EAGER)
  @JsonIgnoreProperties("manufacturer")
  private Set<HomeAppliance> appliances;

  public Manufacturer() {
  }

  public Manufacturer(String name, Integer foundationYear, Integer id) {
    this.name = name;
    this.foundationYear = foundationYear;
    this.id = id;
  }

  public Manufacturer(Manufacturer manufacturer) {
    this(manufacturer.getName(), manufacturer.getFoundationYear(), manufacturer.getId());
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getFoundationYear() {
    return foundationYear;
  }

  public void setFoundationYear(Integer foundationYear) {
    this.foundationYear = foundationYear;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Set<HomeAppliance> getAppliances() {
    return appliances;
  }

  public void setAppliances(Set<HomeAppliance> appliances) {
    this.appliances = appliances;
  }
}
