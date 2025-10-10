package com.mzerek.springbootsolutions.jmh;

import org.openjdk.jmh.annotations.*;

@State(Scope.Benchmark)
public class FactorialBenchmark {

    @Param({"10", "20", "30"})
    public int number;

    @Benchmark
    public long factorial() {
        return calculateFactorial(number);
    }

    private long calculateFactorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * calculateFactorial(n - 1);
    }
}
