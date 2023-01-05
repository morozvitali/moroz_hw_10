package src.main.java.hillel.hw;

public class MyThread implements Runnable {
    //Thread thr;
    private float[] inputArray;
    public MyThread(float[] inputArray) {
        this.inputArray = inputArray;
    }

    @Override
    public void run() {
        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = (float) (inputArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}