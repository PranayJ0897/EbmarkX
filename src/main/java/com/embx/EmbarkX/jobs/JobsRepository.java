package com.embx.EmbarkX.jobs;

import org.springframework.data.jpa.repository.JpaRepository;

//spring data jpa will automatically generates the implementation at the runtime we can use it in service class.
public interface JobsRepository extends JpaRepository<Jobs, Long> {
}
