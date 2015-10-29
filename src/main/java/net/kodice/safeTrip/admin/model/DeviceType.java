package net.kodice.safeTrip.admin.model;

import java.io.Serializable;
import java.lang.reflect.Field;

import javax.persistence.*;

/**
 * The persistent class for the "deviceType" database table.
 * 
 */
@Entity
@Table(name = "\"deviceType\"", schema = "configuration")
@NamedQuery(name = "DeviceType.findAll", query = "SELECT d FROM DeviceType d")
public class DeviceType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "DEVICETYPE_ID_GENERATOR", sequenceName = "deviceType_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEVICETYPE_ID_GENERATOR")
	@Column(unique = true, nullable = false)
	private Integer id;

	@Column(length = 20)
	private String description;

	private Boolean enabled;

	@Column(length = 50)
	private String image;

	public DeviceType() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		Field[] fields = this.getClass().getDeclaredFields();
		String result;
		String fieldList;
		String fieldValue;
		result = this.getClass().getCanonicalName() + "[";
		fieldList = "";
		for (Field f : fields) {
			fieldValue = "";
			if (f.getName() != "serialVersionUID") {
				try {
					if (f.get(this) != null)
						fieldValue = f.get(this).toString();
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}

				fieldList += f.getName() + ": " + fieldValue + ", ";
			}
		}
		result += (fieldList + "]").replace(", ]", " ]");
		return result;
	}

}