package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name = "employers")
@PrimaryKeyJoinColumn(name="id")
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class Employer extends User{
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="website")
	private String website;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@OneToMany(mappedBy= "employer")
	private List<JobAnnouncement> jobAnnouncements;
}
