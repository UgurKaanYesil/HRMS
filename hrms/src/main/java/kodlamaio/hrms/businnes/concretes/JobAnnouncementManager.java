package kodlamaio.hrms.businnes.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.businnes.abstracts.JobAnnouncementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAnnouncementDao;
import kodlamaio.hrms.entities.concretes.JobAnnouncement;
@Service
public class JobAnnouncementManager implements JobAnnouncementService{

	private JobAnnouncementDao jobAnnouncementDao;
	
	public JobAnnouncementManager(JobAnnouncementDao jobAnnouncementDao) {
		super();
		this.jobAnnouncementDao = jobAnnouncementDao;
	}

	@Override
	public DataResult<List<JobAnnouncement>> getAll() {
		return new SuccessDataResult<List<JobAnnouncement>>
		(this.jobAnnouncementDao.findAll());
	}

	@Override
	public Result add(JobAnnouncement jobAnnouncement) {
		jobAnnouncement.getReleaseDate().equals(LocalDate.now());
		this.jobAnnouncementDao.save(jobAnnouncement);
		return new SuccessResult("Job Announcement added");
	}

	@Override
	public DataResult<List<JobAnnouncement>> getByIsActiveTrue() {
		return new SuccessDataResult<List<JobAnnouncement>>
		(this.jobAnnouncementDao.getByIsActiveTrue());
	}

	@Override
	public DataResult<List<JobAnnouncement>> getByDeadlineLessThanEqual(LocalDate date) {
		return new SuccessDataResult<List<JobAnnouncement>>
		(this.jobAnnouncementDao.getByDeadlineLessThanEqual(date));
	}

	@Override
	public DataResult<List<JobAnnouncement>> getByIsActiveTrueAndDeadlineLessThanEqual(LocalDate date) {
		return new SuccessDataResult<List<JobAnnouncement>>
		(this.jobAnnouncementDao.getByIsActiveTrueAndDeadlineLessThanEqual(date));
	}

	@Override
	public DataResult<List<JobAnnouncement>> getByIsActiveTrueAndEmployer_CompanyName(String companyName) {
		return new SuccessDataResult<List<JobAnnouncement>>
		(this.jobAnnouncementDao.getByIsActiveTrueAndEmployer_CompanyName(companyName));
	}

	@Override
	public DataResult<List<JobAnnouncement>> getByEmployerId(int id) {
		return new SuccessDataResult<List<JobAnnouncement>>
		(this.jobAnnouncementDao.getByEmployerId(id));
	}

}
