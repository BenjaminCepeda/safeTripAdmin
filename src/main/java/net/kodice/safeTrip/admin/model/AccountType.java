package net.kodice.safeTrip.admin.model;

import java.io.Serializable;
import javax.persistence.*;

import net.kodice.safeTrip.admin.model.core.GenericModel;

import java.util.Date;
import java.lang.reflect.Field;

/**
 * The persistent class for the "accountType" database table.
 * 
 */
@Entity
@Table(name = "\"accountType\"", schema = "configuration")
@NamedQuery(name = "AccountType.findAll", query = "SELECT a FROM AccountType a")
public class AccountType extends GenericModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "ACCOUNTTYPE_ID_GENERATOR", sequenceName = "configuration.\"accountType_id_seq\"")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNTTYPE_ID_GENERATOR")
	@Column(unique = true, nullable = false)
	private Integer id;

	@Column(length = 50)
	private String description;

	@Column(name = "\"hasValidityPeriod\"")
	private Boolean hasValidityPeriod;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "\"from\"")
	private Date from;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "\"to\"")
	private Date to;

	@Column(length = 50)
	private String image;

	@Column(name = "\"order\"")
	private Integer order;

	private Boolean enabled;

	public AccountType() {
		id = null;
		description = "";
		hasValidityPeriod = false;
		from = null;
		to = null;
		image = null;
		order = null;
		enabled = false;
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

	public Date getFrom() {
		return this.from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Boolean getHasValidityPeriod() {
		return this.hasValidityPeriod;
	}

	public void setHasValidityPeriod(Boolean hasValidityPeriod) {
		this.hasValidityPeriod = hasValidityPeriod;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getOrder() {
		return this.order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Date getTo() {
		return this.to;
	}

	public void setTo(Date to) {
		this.to = to;
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
		fieldList += "editable: " + new Boolean(getEditable()).toString();
		result += (fieldList + "]").replace(", ]", " ]");
		return result;
	}

}