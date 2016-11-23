package boots.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="garment")

public class Garment  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
	@Column(length=45)
private String Color;
	@Column(length=45)
private String size;
	@Column(length=45)
private String type;
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
 * @return the color
 */
public String getColor() {
	return Color;
}
/**
 * @param color the color to set
 */
public void setColor(String color) {
	Color = color;
}
/**
 * @return the size
 */
public String getSize() {
	return size;
}
/**
 * @param size the size to set
 */
public void setSize(String size) {
	this.size = size;
}
/**
 * @return the type
 */
public String getType() {
	return type;
}
/**
 * @param type the type to set
 */
public void setType(String type) {
	this.type = type;
}
public Garment( String color, String size, String type) {
	super();

	Color = color;
	this.size = size;
	this.type = type;
}
public Garment() {
	
	this("","","");
	// TODO Auto-generated constructor stub
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Garment [id=" + id + ", Color=" + Color + ", size=" + size + ", type=" + type + "]";
}


}
