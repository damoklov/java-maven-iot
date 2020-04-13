package ua.lviv.iot.appliance.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name = "owner")
public class Owner {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String fullName;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "Appliance_Owner",
            joinColumns = { @JoinColumn(name = "owner_id", nullable = false)},
            inverseJoinColumns = { @JoinColumn(name = "appliance_id", nullable = false)})
  @JsonIgnoreProperties("owners")
  private Set<HomeAppliance> appliances;

  public Owner() {
  }

  public Owner(String fullName, Integer id) {
    this.fullName = fullName;
    this.id = id;
  }

  public Owner(Owner owner) {
    this(owner.getFullName(),
            owner.getId());
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public Set<HomeAppliance> getAppliances() {
    return appliances;
  }

  public void setAppliances(Set<HomeAppliance> appliances) {
    this.appliances = appliances;
  }


}
