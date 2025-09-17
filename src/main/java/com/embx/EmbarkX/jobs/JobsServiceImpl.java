package com.embx.EmbarkX.jobs;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class JobsServiceImpl implements JobsService {

    List<Jobs> jobs = new ArrayList<>();

    @Override
    public List<Jobs> findAll() {
        return jobs;
    }

    @Override
    public String createJob(Jobs job) {
        jobs.add(job);
        return "Job created successfully!";
    }

    @Override
    public Jobs findByid(Long id) {
        Jobs j = null;
        for (Jobs job : jobs) {
            if (Objects.equals(id, job.getId())) {
                j = job;
            } else {
                j = new Jobs(1L, "Dummy Jobs", "This is a dummy job", "2000", "1000");
            }
        }
        return j;
    }

    @Override
    public String deleteJobById(Long id) {
        String result = "";
        if (jobs.isEmpty()) {
            result = "Job not found!";
        }
        for (int i = 0; i < jobs.size(); i++) {
            if (Objects.equals(id, jobs.get(i).getId())) {
                jobs.remove(jobs.get(i));
                result = "Job deleted successfully!";
            } else {
                result = "Job not found!";
            }
        }


        return result;
    }

    @Override
    public boolean updateJob(Long id, Jobs job) {
        for (Jobs j : jobs) {
            if (j.getId().equals(id)) {
                j.setTitle(job.getTitle());
                j.setDescription(job.getDescription());
                j.setMinSalary(job.getMinSalary());
                j.setMaxSalary(job.getMaxSalary());
                return true;
            }
        }
        return false;
    }
}
