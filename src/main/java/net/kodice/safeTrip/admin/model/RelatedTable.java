package net.kodice.safeTrip.admin.model;

import java.io.Serializable;
import javax.persistence.*;

import net.kodice.safeTrip.admin.model.core.GenericModel;

import java.util.List;
import java.lang.reflect.Field;

/**
 * The persistent class for the "relatedTable" database table.
 * 
 */
@Entity
@Table(name = "\"relatedTable\"", schema = "configuration")
@NamedQuery(name = "RelatedTable.findAll", query = "SELECT r FROM RelatedTable r")
public class RelatedTable extends GenericModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "RELATEDTABLE_ID_GENERATOR", sequenceName = "relatedTable_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RELATEDTABLE_ID_GENERATOR")
	@Column(unique = true, nullable = false)
	private Integer id;

	private Boolean enabled;

	@Column(name = "\"relatedTableName\"", length = 50)
	private String relatedTableName;

	// bi-directional many-to-one association to Status
	@OneToMany(mappedBy = "relatedTable")
	private List<Status> statuses;

	public RelatedTable() {
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

	public String getRelatedTableName() {
		return this.relatedTableName;
	}

	public void setRelatedTableName(String relatedTableName) {
		this.relatedTableName = relatedTableName;
	}

	public List<Status> getStatuses() {
		return this.statuses;
	}

	public void setStatuses(List<Status> statuses) {
		this.statuses = statuses;
	}

	public Status addStatus(Status status) {
		getStatuses().add(status);
		status.setRelatedTable(this);

		return status;
	}

	public Status removeStatus(Status status) {
		getStatuses().remove(status);
		status.setRelatedTable(null);

		return status;
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