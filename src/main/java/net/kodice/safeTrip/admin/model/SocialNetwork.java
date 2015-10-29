package net.kodice.safeTrip.admin.model;

import java.io.Serializable;
import java.lang.reflect.Field;

import javax.persistence.*;

/**
 * The persistent class for the "socialNetwork" database table.
 * 
 */
@Entity
@Table(name = "\"socialNetwork\"", schema = "configuration")
@NamedQuery(name = "SocialNetwork.findAll", query = "SELECT s FROM SocialNetwork s")
public class SocialNetwork implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SOCIALNETWORK_ID_GENERATOR", sequenceName = "socialNetwork_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SOCIALNETWORK_ID_GENERATOR")
	@Column(unique = true, nullable = false)
	private Integer id;

	private Boolean enabled;

	@Column(length = 50)
	private String name;

	@Column(name = "\"userIdFormat\"", length = 100)
	private String userIdFormat;

	public SocialNetwork() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserIdFormat() {
		return this.userIdFormat;
	}

	public void setUserIdFormat(String userIdFormat) {
		this.userIdFormat = userIdFormat;
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