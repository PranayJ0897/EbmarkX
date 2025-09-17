package com.embx.EmbarkX.jobs;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobsController {

    //The below code is consistent in terms of response and have greater control on response.

    private JobsService jobsService;

    public JobsController(JobsService jobsService) {
        this.jobsService = jobsService;
    }

    @GetMapping()
    private ResponseEntity<List<Jobs>> listJob() {
        return new ResponseEntity<>(jobsService.findAll(), HttpStatus.OK);
    }

    @PostMapping()
    private ResponseEntity<String> createJob(@RequestBody Jobs job) {
        return new ResponseEntity<>(jobsService.createJob(job), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Jobs> jobById(@PathVariable Long id) {
        return new ResponseEntity<>(jobsService.findByid(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<String> deleteJobById(@PathVariable Long id) {
        boolean result = jobsService.deleteJobById(id);
        if (result)
            return new ResponseEntity<>("Job deleted successfully!", HttpStatus.OK);
        return new ResponseEntity<>("Job not found!", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    private ResponseEntity<String> updateJobs(@PathVariable Long id, @RequestBody Jobs jobs) {
        boolean result = jobsService.updateJob(id, jobs);
        if (result)
            return new ResponseEntity<>("Job updated successfully!", HttpStatus.OK);
        return new ResponseEntity<>("Job not found!", HttpStatus.NOT_FOUND);
    }
}
