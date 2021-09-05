package jp.sigre.parallel;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SimpleMain {

    public static void main(String[] args) {
        SampleJob sampleJob = new SampleJob();

//        System.out.println("-------直列実行------");
//        long startTime = System.currentTimeMillis();
//        IntStream.range(0,10).forEach(sampleJob::print);
//        long endTime = System.currentTimeMillis();
//        System.out.println("実行時間:" + TimeUnit.MILLISECONDS.toSeconds(endTime - startTime));

        System.out.println();
        System.out.println("-------並列実行------");
        long startTime2 = System.currentTimeMillis();
        IntStream.range(0,10).parallel().forEach(sampleJob::print);
        long endTime2 = System.currentTimeMillis();

        System.out.println("実行時間:" + (endTime2 - startTime2));
    }
}
