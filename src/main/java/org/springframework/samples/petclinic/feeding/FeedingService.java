package org.springframework.samples.petclinic.feeding;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

 

public class FeedingService {
	
	@Autowired
	private FeedingRepository feedingRepository;
	
    public List<Feeding> getAll(){
        return feedingRepository.findAll();
    }

    public List<FeedingType> getAllFeedingTypes(){
        return feedingRepository.findAllFeedingTypes();
    }

    public FeedingType getFeedingType(String typeName) {
        return feedingRepository.findFeedingType(typeName);
    }

    @Transactional(rollbackFor = UnfeasibleFeedingException.class)
    public Feeding save(Feeding f) throws UnfeasibleFeedingException {
        if (f.pet.getType()==f.feedingType.getPetType()) {
        	return feedingRepository.save(f);

        	
        }else {
        	throw new UnfeasibleFeedingException();
        }    
    }

    
}
