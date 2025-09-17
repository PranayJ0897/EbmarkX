package com.embx.EmbarkX.jobs;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobsServiceImpl implements JobsService {
    //jobsRepository is a bean managed by spring which will be autowired by the constructor at the runtime
    //    List<Jobs> jobs = new ArrayList<>();
    JobsRepository jobsRepository;

    public JobsServiceImpl(JobsRepository jobsRepository) {
        this.jobsRepository = jobsRepository;
    }

    @Override
    public List<Jobs> findAll() {
        return jobsRepository.findAll();
    }

    @Override
    public String createJob(Jobs job) {
        jobsRepository.save(job);
        return "Job created successfully!";
    }

    @Override
    public Jobs findByid(Long id) {
        return jobsRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
        try {
            jobsRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateJob(Long id, Jobs job) {
        Optional<Jobs> jobsOptional = jobsRepository.findById(id);
        if (jobsOptional.isPresent()) {
            Jobs j = jobsOptional.get();
            j.setTitle(job.getTitle());
            j.setDescription(job.getDescription());
            j.setMaxSalary(job.getMaxSalary());
            j.setMinSalary(job.getMinSalary());
            jobsRepository.save(j);
            return true;
        }

        return false;
    }
}
