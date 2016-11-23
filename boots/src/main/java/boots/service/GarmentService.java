package boots.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import boots.dao.GarmentRepository;
import boots.model.Garment;
@Service @Transactional
public class GarmentService {
	private final GarmentRepository garmentRepository;
	
	public GarmentService(GarmentRepository garmentRepository){
		super();
		this.garmentRepository=garmentRepository;
	}
	
	public List<Garment> findAll(){
		List<Garment> garments = new ArrayList<Garment>();
		for(Garment garment : garmentRepository.findAll()){
			garments.add(garment);
		}
		return garments;
	}
	
	public void save(Garment garment){
		garmentRepository.save(garment);
	}
	
	public void delete(int id){
		garmentRepository.delete(id);
	}
	
	public Garment findOne (int id){
		return garmentRepository.findOne(id);
	}
}
