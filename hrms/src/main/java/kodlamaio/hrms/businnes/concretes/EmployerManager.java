package kodlamaio.hrms.businnes.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.businnes.abstracts.EmployerService;
import kodlamaio.hrms.core.abstracts.EmailVaidationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private EmailVaidationService emailValidationService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailVaidationService emailValidationService) {
		super();
		this.employerDao = employerDao;
		this.emailValidationService = emailValidationService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Data listelendi.");
	}

	@Override
	public Result add(Employer employer) {
		if(emailValidationService.isActive(employer) != null) {
			this.employerDao.save(employer);
		}
		return new SuccessResult("Employer added");
	}

}
