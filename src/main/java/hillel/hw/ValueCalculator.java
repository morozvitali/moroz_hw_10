package src.main.java.hillel.hw;

import java.util.Arrays;
public class ValueCalculator {
    private float[] array;
    private int value;
    private int half;
    public static final int MILLION = 1_000_000;

    public void doCalc() throws InterruptedException {
        long start = System.currentTimeMillis();

        setValues(array);

        float[] array1 = new float[half];
        float[] array2;
        if (value % 2 == 0) {
            array2 = new float[half];
        } else {
            array2 = new float[half + 1];
        }

        System.arraycopy(array, 0, array1, 0, array1.length);
        System.arraycopy(array, array1.length, array2, 0, array2.length);

        Thread firstThread = new Thread(new MyThread(array1));
        Thread secondThread = new Thread(new MyThread(array2));

        firstThread.start();
        secondThread.start();

        firstThread.join();
        secondThread.join();

        System.arraycopy(array1, 0, array, 0, half);
        System.arraycopy(array2, 0, array, array1.length, array2.length);

        calculateTime(start);
    }
    public ValueCalculator() {
        this.value = (int) ((Math.random() * MILLION + MILLION));
        this.half = this.value / 2;
        this.array = new float[this.value];
    }
    public void setValues(float[] array) {
        Arrays.fill(array, (float) (Math.random() * 10));
    }
    public void calculateTime(long start) {
        long finish = System.currentTimeMillis();
        long result = finish - start;
        System.out.printf("Time from begin of application: %s", result);
    }
}

