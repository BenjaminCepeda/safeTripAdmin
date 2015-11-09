package net.kodice.safeTrip.admin.model;

import java.io.Serializable;
import java.lang.reflect.Field;

import javax.persistence.*;

import net.kodice.safeTrip.admin.model.core.GenericModel;


/**
 * The persistent class for the status database table.
 * 
 */
@Entity
@Table(name="status", schema="configuration")
@NamedQuery(name="Status.findAll", query="SELECT s FROM Status s")
public class Status extends GenericModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="STATUS_ID_GENERATOR", sequenceName="status_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STATUS_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(length=50)
	private String description;

	private Boolean enabled;

	private Integer order;

	//bi-directional many-to-one association to RelatedTable
	@ManyToOne
	@JoinColumn(name="\"relatedTableId\"")
	private RelatedTable relatedTable;

	public Status() {
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

	public Integer getOrder() {
		return this.order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public RelatedTable getRelatedTable() {
		return this.relatedTable;
	}

	public void setRelatedTable(RelatedTable relatedTable) {
		this.relatedTable = relatedTable;
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
					if (f.get(this)!= null)
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