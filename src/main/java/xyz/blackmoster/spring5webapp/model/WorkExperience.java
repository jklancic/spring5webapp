package xyz.blackmoster.spring5webapp.model;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class WorkExperience {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "uuid", updatable = false, nullable = false)
	private UUID uuid;
	
	@ManyToOne
	@JoinColumn(name = "companyUuid", nullable = false)
	private Company company;
	
	private Date started;
	
	private Date ended;
	
	private String title;
	
	private String description;

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Date getStarted() {
		return started;
	}

	public void setStarted(Date started) {
		this.started = started;
	}

	public Date getEnded() {
		return ended;
	}

	public void setEnded(Date ended) {
		this.ended = ended;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		WorkExperience that = (WorkExperience) o;
		return Objects.equals(uuid, that.uuid);
	}

	@Override
	public int hashCode() {

		return Objects.hash(uuid);
	}

	@Override
	public String toString() {
		return "WorkExperience{" +
			"uuid=" + uuid +
			", company=" + company +
			", started=" + started +
			", ended=" + ended +
			", title='" + title + '\'' +
			", description='" + description + '\'' +
			'}';
	}
}
