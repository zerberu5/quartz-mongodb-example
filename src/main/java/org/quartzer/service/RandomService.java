package org.quartzer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Slf4j
public class RandomService {

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
