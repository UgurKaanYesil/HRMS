package kodlamaio.hrms.businnes.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.businnes.abstracts.JobSeekerService;
import kodlamaio.hrms.core.abstracts.MernisValidationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{
	
	private JobSeekerDao jobSeekerDao;
	private MernisValidationService mernisvalidationService;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, MernisValidationService mernisvalidationService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.mernisvalidationService = mernisvalidationService;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		
		return new SuccessDataResult<List<JobSeeker>>
		(this.jobSeekerDao.findAll(),"Data listelendi.");
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		if(mernisvalidationService.validate(jobSeeker) != null) {
			this.jobSeekerDao.save(jobSeeker);
		}
		return new SuccessResult("JobSeeker added.");
	}

	

	

}
