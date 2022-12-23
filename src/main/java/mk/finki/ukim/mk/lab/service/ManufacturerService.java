package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManufacturerService {
    List<Manufacturer> findAll();

}
