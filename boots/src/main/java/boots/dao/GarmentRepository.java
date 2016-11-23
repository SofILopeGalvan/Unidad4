package boots.dao;

import org.springframework.data.repository.CrudRepository;

import boots.model.Garment;;

public interface GarmentRepository extends CrudRepository<Garment, Integer> {

}