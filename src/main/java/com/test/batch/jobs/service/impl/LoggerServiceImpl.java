package com.test.batch.jobs.service.impl;

import org.springframework.stereotype.Service;
import com.test.batch.jobs.service.LoggerService;

@Service
public class LoggerServiceImpl implements LoggerService {

  @Override
  public void log() {
    System.out.println("ok passed");
  }
}
