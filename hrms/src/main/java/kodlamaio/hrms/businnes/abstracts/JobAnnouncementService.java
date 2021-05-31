package kodlamaio.hrms.businnes.abstracts;

import java.time.LocalDate;
import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAnnouncement;

public interface JobAnnouncementService {
	DataResult<List<JobAnnouncement>> getAll();
	Result add(JobAnnouncement jobAnnouncement);
	
	DataResult<List<JobAnnouncement>> getByIsActiveTrue();
	DataResult<List<JobAnnouncement>> getByDeadlineLessThanEqual(LocalDate date);
	DataResult<List<JobAnnouncement>> getByIsActiveTrueAndDeadlineLessThanEqual(LocalDate date);
	DataResult<List<JobAnnouncement>> getByIsActiveTrueAndEmployer_CompanyName(String companyName);
	DataResult<List<JobAnnouncement>> getByEmployerId(int id);
}
