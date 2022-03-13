package jp.sigre.parallel;

import java.util.ArrayList;
import java.util.List;

public class SampleJob {

    private boolean bool = true;

    public void print(int i) {

        int waitMills = bool ? 1000 : 2000;
        try {
            Thread.sleep(waitMills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(i + " : " + waitMills + " : " + Thread.currentThread().getName());

        bool = !bool;
    }
}
