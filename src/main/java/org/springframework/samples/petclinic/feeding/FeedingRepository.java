package org.springframework.samples.petclinic.feeding;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FeedingRepository extends CrudRepository<Feeding, Integer>{
    List<Feeding> findAll();
    
    @Query("SELECT f FROM FeedingType f")
    List<FeedingType> findAllFeedingTypes();
    
    @Query("SELECT f FROM FeedingType f WHERE f.name=?1")
    FeedingType findFeedingType(String nombre);
    
    
    
    Optional<Feeding> findById(int id);
    Feeding save(Feeding p);
}
