package com.embx.EmbarkX.jobs;

import java.util.List;

public interface JobsService {

    List<Jobs> findAll();

    String createJob(Jobs jobs);

    Jobs findByid(Long id);

    String deleteJobById(Long id);

    boolean updateJob(Long id, Jobs job);
}
