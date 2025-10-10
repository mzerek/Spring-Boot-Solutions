package com.mzerek.springbootsolutions.controller;

import io.micrometer.core.instrument.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicInteger;


//https://medium.com/javarevisited/unlocking-precision-metrics-in-spring-boot-with-micrometer-a-comprehensive-guide-6d72d6eaaf00
@RestController
@RequestMapping(value = "/api/v2")
public class MicrometerController {

    private final Counter myCounter;
    private final Timer myTimer;
    private final AtomicInteger myGauge = new AtomicInteger();

    private final DistributionSummary summary;

    public MicrometerController(MeterRegistry registry) {
        myCounter = Counter.builder("mz.counter")
                .description("Counts something")
                .tags("region", "europe")
                .register(registry);

        myTimer = Timer.builder("mz.timer")
                .description("Times something")
                .tags("region", "europe")
                .register(registry);

        Gauge.builder("mz.gauge", myGauge, AtomicInteger::get)
                .description("Gauges something")
                .tags("region", "europe")
                .register(registry);

        this.summary = DistributionSummary.builder("custom.distribution.summary")
                .description("A custom distribution summary")
                .tags("region", "us-west")
                .register(registry);
    }

    @GetMapping("/increment")
    public void incrementCounter() {
        myCounter.increment();
    }

    @GetMapping("/time")
    public void timeSomething() {
        myTimer.record(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @GetMapping("/setGauge")
    public void setGauge(@RequestParam int value) {
        myGauge.set(value);
    }

    @GetMapping("/record")
    public void record(@RequestParam double amount) {
        summary.record(amount);
    }
}
