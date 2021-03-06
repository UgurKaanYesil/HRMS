package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_announcements")
public class JobAnnouncement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="description")
	private String description;
	
	@Column(name="min_salary")
	private int minSalary;
	
	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="oopen_positions")
	private int openPositions;
	
	@Column(name="deadline")
	private LocalDate deadline;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@Column(name="release_date")
	private LocalDate releaseDate;
	
	@JsonIgnoreProperties({"user_id","web_address","phone_number","email","password"})
	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	@JsonIgnoreProperties({"id"})
	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;
	
	@JsonIgnoreProperties({"id"})
	@ManyToOne()
	@JoinColumn(name="position_id")
	private JobPosition jobPosition;
}
