package org.quartzer.job;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Slf4j
public class RandomNumJob implements Job {
    // Man kann aus irgendeinem Grund keinen Service injecten

    // Ist mandatory
    public RandomNumJob() {
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        createRandomNum();
    }

    public int createRandomNum() {
        int randomNum = new Random().nextInt((100 - 1) + 1) + 1;

        if (randomNum < 50) {
            log.warn("random num {} smaller than 50", randomNum);
        } else {
            log.error("random num {} bigger than 50", randomNum);
        }

        return randomNum;
    }
}
