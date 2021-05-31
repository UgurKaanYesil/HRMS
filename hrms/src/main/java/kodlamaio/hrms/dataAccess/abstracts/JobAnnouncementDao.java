package kodlamaio.hrms.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobAnnouncement;

public interface JobAnnouncementDao extends JpaRepository<JobAnnouncement, Integer>{

	List<JobAnnouncement> getByIsActiveTrue();
	List<JobAnnouncement> getByDeadlineLessThanEqual(LocalDate date);
	List<JobAnnouncement> getByIsActiveTrueAndDeadlineLessThanEqual(LocalDate date);
	List<JobAnnouncement> getByIsActiveTrueAndEmployer_CompanyName(String companyName);
	List<JobAnnouncement> getByEmployerId(int id);
	JobAnnouncement getById(int id);
}
