package ua.lviv.iot.appliance.business;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class AbstractService<T> {

  protected abstract JpaRepository<T,Integer> getRepository();

  public T create(T t) {
    return getRepository().save(t);
  }

  public T findById(Integer id) {
    return getRepository().findById(id).get();
  }

  public List<T> getAll() {
    return getRepository().findAll();
  }

  public T delete(Integer id) {
    T possibleObject = getRepository().findById(id).get();
    getRepository().deleteById(id);
    return possibleObject;
  }

  public List<T> findAll() {
    return getRepository().findAll();
  }

}
