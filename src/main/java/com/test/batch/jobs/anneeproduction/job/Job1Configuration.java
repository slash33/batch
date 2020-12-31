package com.test.batch.jobs.anneeproduction.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class Job1Configuration {

  @Autowired
  private StepBuilderFactory stepBuilderFactory;

  @Bean
  public Job finAnneeProductionJob(JobBuilderFactory jobBuilderFactory) {
    return jobBuilderFactory.get("job1").incrementer(new RunIdIncrementer()).flow(step1()).end()
        .build();
  }

  @Bean("step1")
  public Step step1() {
    return stepBuilderFactory.get("step1").tasklet(task1()).build();
  }

  @Bean
  Task1Tasklet task1() {
    return new Task1Tasklet();
  }

}
