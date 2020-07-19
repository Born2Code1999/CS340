public class Producer implements Runnable {

    private int[] bufferArray;
    private int maximumBurstLengthK;
    private int maximumSleepTimeT;

    public Producer(int[] bufferArray, int maximumBurstLengthK, int maximumSleepTimeT) {
        this.bufferArray = bufferArray;
        this.maximumBurstLengthK = maximumBurstLengthK;
        this.maximumSleepTimeT = maximumSleepTimeT;
    }

    public void run() {
        int next_in = 0;
        while (true) {
            int k1 = (int) (Math.random() * maximumBurstLengthK);
            for (int i = 0; i < k1; i++) {
                bufferArray[(next_in + i) % bufferArray.length] += 1;
            }
            next_in = (next_in + k1) % bufferArray.length;
            int t1 = (int) (maximumSleepTimeT * Math.random());
            try {
                Thread.sleep(t1 * 1000);
            } catch (InterruptedException e) {
                System.out.println("Producer: InterruptedException: " + e.getMessage());
            }
        }
    }
}
