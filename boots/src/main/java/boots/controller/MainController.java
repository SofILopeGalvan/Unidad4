package boots.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boots.model.Garment;
import boots.model.Proyect;
import boots.model.Task;
import boots.service.GarmentService;
import boots.service.ProyectService;
import boots.service.TaskService;

@Controller
public class MainController {
  
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private ProyectService proyectService;
	@Autowired
	private ProyectService garmentService;
	
	@GetMapping("/")
	public String home(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME");
		return "index";
	}
	
	
	
	@GetMapping("/HomeTask")
	public String homeTa(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOMETask");
		return "index";
	}
	
	
	
	
	
	
	@GetMapping("/all-tasks")
	public String allTasks(HttpServletRequest request){
		request.setAttribute("tasks", taskService.findAll());
		request.setAttribute("mode", "MODE_TASKS");
		return "index";
	}
	
	@GetMapping("/new-task")
	public String newTask(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW");
		return "index";
	}
	
	@PostMapping("/save-task")
	public String saveTask(@ModelAttribute Task task, BindingResult bindingResult, HttpServletRequest request){
		taskService.save(task);
		request.setAttribute("tasks", taskService.findAll());
		request.setAttribute("mode", "MODE_TASKS");
		return "index";
	}
	
	@GetMapping("/update-task")
	public String updateTask(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("task", taskService.findOne(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "index";
	}
	
	@GetMapping("/delete-task")
	public String deleteTask(@RequestParam int id, HttpServletRequest request){
		taskService.delete(id);
		request.setAttribute("tasks", taskService.findAll());
		request.setAttribute("mode", "MODE_TASKS");
		return "index";
	}
	
	
	
	
	
	
	
	@GetMapping("/all-proyects")
	public String allProyects(HttpServletRequest request){
		request.setAttribute("proyects", proyectService.findAll());
		request.setAttribute("mode", "MODE_PROYECTS");
		return "index";
	}
	
	@GetMapping("/new-proyect")
	public String newProyect(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW_PROYECT");
		return "index";
	}
	
	@PostMapping("/save-proyect")
	public String saveProyect(@ModelAttribute Proyect proyect, BindingResult bindingResult, HttpServletRequest request){
		proyectService.save(proyect);
		request.setAttribute("proyects", proyectService.findAll());
		request.setAttribute("mode", "MODE_PROYECTS");
		return "index";
	}
	
	@GetMapping("/update-proyect")
	public String updateProyect(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("proyect", proyectService.findOne(id));
		request.setAttribute("mode", "MODE_UPDATE_PROYECT");
		return "index";
	}
	
	@GetMapping("/delete-proyect")
	public String deleteProyect(@RequestParam int id, HttpServletRequest request){
		proyectService.delete(id);
		request.setAttribute("proyects", proyectService.findAll());
		request.setAttribute("mode", "MODE_PROYECTS");
		return "index";
	}
	
	
	
	
	

	
	@GetMapping("/all-garments")
	public String allGarments(HttpServletRequest request){
		request.setAttribute("garments", garmentService.findAll());
		request.setAttribute("mode", "MODE_GARMENTS");
		return "index";
	}
	
	@GetMapping("/new-garment")
	public String newGarment(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW_GARMENT");
		return "index";
	}
	
	@PostMapping("/save-garment")
	public String saveGarment(@ModelAttribute Garment garment, BindingResult bindingResult, HttpServletRequest request){
		garmentService.save(null);
		request.setAttribute("garments", garmentService.findAll());
		request.setAttribute("mode", "MODE_GARMENTS");
		return "index";
	}
	
	@GetMapping("/update-garment")
	public String updateGarment(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("garment", garmentService.findOne(id));
		request.setAttribute("mode", "MODE_UPDATE_GARMENT");
		return "index";
	}
	
	@GetMapping("/delete-garment")
	public String deleteGarment(@RequestParam int id, HttpServletRequest request){
		garmentService.delete(id);
		request.setAttribute("garments", garmentService.findAll());
		request.setAttribute("mode", "MODE_GARMENTS");
		return "index";
	}
	
	
	
	
	
 }
