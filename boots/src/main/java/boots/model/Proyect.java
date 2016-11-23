package boots.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="proyect")
public class Proyect  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(length=45)
	private String schedule;
	@Column(length=45)
	private String presentation;
	@Column(length=45)
	private String start_time;
	@Column(length=45)
	private String end_time;
	
		
	public Proyect( String schedule, String presentation, String start_time, String end_time) {
		super();
		
		this.schedule = schedule;
		this.presentation = presentation;
		this.start_time = start_time;
		this.end_time = end_time;
	}

	
	public Proyect() {
		this("","","","");
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the schedule
	 */
	public String getSchedule() {
		return schedule;
	}
	/**
	 * @param schedule the schedule to set
	 */
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	/**
	 * @return the presentation
	 */
	public String getPresentation() {
		return presentation;
	}
	/**
	 * @param presentation the presentation to set
	 */
	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}
	/**
	 * @return the starteTime
	 */
	
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getStart_time() {
		return start_time;
	}


	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}


	public String getEnd_time() {
		return end_time;
	}


	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}


	@Override
	public String toString() {
		return "Proyect [id=" + id + ", schedule=" + schedule + ", presentation=" + presentation + ", starteTime="
				+ start_time + ", endTime=" + end_time + "]";

	}
}
	
	