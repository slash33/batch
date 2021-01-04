package com.test.task;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import com.test.service.LoggerService;

public class TaskTasklet implements Tasklet, InitializingBean {

  @Value("${job.test}")
  private String test;

  @Autowired
  private LoggerService loggerService;

  @Override
  public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext)
      throws Exception {

    System.out.println("date test : " + test);
    this.loggerService.log();

    return RepeatStatus.FINISHED;
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    // nothing needed
  }

}
