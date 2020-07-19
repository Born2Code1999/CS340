public class Consumer implements Runnable {

    private int[] bufferArray;
    private int maximumBurstLengthK;
    private int maximumSleepTimeT;

    public Consumer(int[] bufferArray, int maximumBurstLengthK, int maximumSleepTimeT) {
        this.bufferArray = bufferArray;
        this.maximumBurstLengthK = maximumBurstLengthK;
        this.maximumSleepTimeT = maximumSleepTimeT;
    }

    public void run() {
        int data;
        int next_out = 0;

        while (true) {
            int t2 = (int) (maximumSleepTimeT * Math.random());
            try {
                Thread.sleep(t2 * 1000);
            } catch (InterruptedException e) {
                System.out.println("Consumer: InterruptedException: " + e.getMessage());
            }
            int k2 = (int) (Math.random() * maximumBurstLengthK);
            for (int i = 0; i < k2; i++) {
                data = bufferArray[(next_out + i) % bufferArray.length];
                if (data > 1) {
                    System.out.println("\nReporting The Occurence Of A Race Condition!");
                    System.exit(data);
                }
                bufferArray[(next_out + i) % bufferArray.length] = 0;
            }
            next_out = (next_out + k2) % bufferArray.length;
        }
    }
}
