package kodlamaio.hrms.core.adapters;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.abstracts.EmailVaidationService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.abstracts.User;

@Service
public class EmailValidationAdapter implements EmailVaidationService{

	@Override
	public Result isActive(User user) {
		
		return new SuccessResult(user.getEmail() + " doğrulandı.");
	}

}
