package com.test.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.test.task.TaskTasklet;

@Configuration
@EnableBatchProcessing
public class JobConfiguration {

  @Autowired
  private StepBuilderFactory stepBuilderFactory;

  @Bean
  public Job finAnneeProductionJob(JobBuilderFactory jobBuilderFactory) {
    return jobBuilderFactory.get("job1").incrementer(new RunIdIncrementer()).flow(step()).end()
        .build();
  }

  @Bean
  public Step step() {
    return stepBuilderFactory.get("step1").tasklet(task()).build();
  }

  @Bean
  Tasklet task() {
    return new TaskTasklet();
  }

}
