package kodlamaio.hrms.core.adapters;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.abstracts.MernisValidationService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class MernisServiceAdapter implements MernisValidationService{

	@Override
	public Result validate(JobSeeker jobSeeker) {
		
		return new SuccessResult("Doğrulandı.");
	}

}
