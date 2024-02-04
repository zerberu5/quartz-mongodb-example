package org.quartzer.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartzer.dto.MyData;
import org.quartzer.job.RandomNumJob;
import org.quartzer.persistence.MyDataRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api")
@Slf4j
@OpenAPIDefinition(info = @Info(title = "Quartzer", description = "Just a controller to trigger a job"))
public class DataReceiver {

    private final Scheduler scheduler;
    private final MyDataRepository myDataRepository;
    private int counter;

    public DataReceiver(Scheduler scheduler, MyDataRepository myDataRepository) {
        this.myDataRepository = myDataRepository;
        this.scheduler = scheduler;
    }

    @GetMapping("/quartz")
    public ResponseEntity<String> triggerProm() throws SchedulerException {
        log.info("trigger");

        Trigger trigger = TriggerBuilder.newTrigger().startNow().build();

        String keyName = String.valueOf(UUID.randomUUID());
        JobDetail randomNumJob = JobBuilder.newJob(RandomNumJob.class)
                .withIdentity(keyName)
                .storeDurably()
                .build();

        log.info("Identity/KeyName: " + keyName);

//        MyData myData = new MyData();
//        myData.setValue(5);
//        myDataRepository.save(myData);
        scheduler.addJob(randomNumJob, true, true);
        scheduler.scheduleJob(randomNumJob, trigger);
        return ResponseEntity.ok("Passt");
    }
}
