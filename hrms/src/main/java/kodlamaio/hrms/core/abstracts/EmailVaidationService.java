package kodlamaio.hrms.core.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.abstracts.User;

public interface EmailVaidationService {
	Result isActive(User user);
}
