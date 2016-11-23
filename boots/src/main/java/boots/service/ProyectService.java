package boots.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import boots.dao.ProyectRepository;
import boots.model.Proyect;

@Service @Transactional
public class ProyectService {
	private final ProyectRepository proyectRepository;
	
	public ProyectService(ProyectRepository proyectRepository){
		super();
		this.proyectRepository=proyectRepository;
	}
	
	public List<Proyect> findAll(){
		List<Proyect> proyects = new ArrayList<Proyect>();
		for(Proyect proyect : proyectRepository.findAll()){
			proyects.add(proyect);
		}
		return proyects;
	}
	
	public void save(Proyect proyect){
		proyectRepository.save(proyect);
	}
	
	public void delete(int id){
		proyectRepository.delete(id);
	}
	
	public Proyect findOne (int id){
		return proyectRepository.findOne(id);
	}

}
