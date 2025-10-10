package com.mzerek.springbootsolutions.jmh;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.Options;

public class BenchmarkRunner {

    public static void main(String[] args) throws Exception {
        Options options = new OptionsBuilder()
                .include(FactorialBenchmark.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(options).run();
    }
}
