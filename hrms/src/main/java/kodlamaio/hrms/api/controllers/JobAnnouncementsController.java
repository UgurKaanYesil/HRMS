package kodlamaio.hrms.api.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.businnes.abstracts.JobAnnouncementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAnnouncement;

@RestController
@RequestMapping("api/jobAnnouncements")
public class JobAnnouncementsController {

	private JobAnnouncementService jobAnnouncementService;
	
	@Autowired
	public JobAnnouncementsController(JobAnnouncementService jobAnnouncementService) {
		super();
		this.jobAnnouncementService = jobAnnouncementService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAnnouncement>> getAll(){
		return this.jobAnnouncementService.getAll();
	}
	
	@PostMapping("/add")
    public Result add(@RequestBody JobAnnouncement jobAnnouncement){
        return this.jobAnnouncementService.add(jobAnnouncement);
    }
	
	@GetMapping("/getByIsActiveTrue")
    public DataResult<List<JobAnnouncement>> getByIsActiveTrue() {
        return this.jobAnnouncementService.getByIsActiveTrue();
    }
    
    @GetMapping("/getByApplicationDeadline")
    public DataResult<List<JobAnnouncement>> getByApplicationDeadline(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return this.jobAnnouncementService.getByDeadlineLessThanEqual(date);
    }
    
    @GetMapping("/getByActiveAndApplicationDeadline")
    public DataResult<List<JobAnnouncement>> getByIsActiveTrueAndApplicationDeadlineLessThanEqual(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return this.jobAnnouncementService.getByIsActiveTrueAndDeadlineLessThanEqual(date);
    }
    
    @GetMapping("/getByIsActiveAndCompanyName")
    public DataResult<List<JobAnnouncement>> getByIsActiveAndEmployer_CompanyName(@RequestParam String companyName) {
        return this.jobAnnouncementService.getByIsActiveTrueAndEmployer_CompanyName(companyName);
    }
    
    @GetMapping("/getByEmployer")
    public DataResult<List<JobAnnouncement>> getByEmployer(@RequestParam int id) {
        return this.jobAnnouncementService.getByEmployerId(id);
    }
}
