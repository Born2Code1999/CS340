//Race Condition Occurs When
// n = 100
// k = 25
// t = 5

public class Assignment2 {

    public static void main(String[] args) {
        int bufferSizeN = Integer.parseInt(args[0]);
        int maximumBurstLengthK = Integer.parseInt(args[1]);
        int maximumSleepTimeT = Integer.parseInt(args[2]);

	int[] bufferArray = new int[bufferSizeN];

        Thread producer = new Thread(new Producer(bufferArray, maximumBurstLengthK, maximumSleepTimeT));
        Thread consumer = new Thread(new Consumer(bufferArray, maximumBurstLengthK, maximumSleepTimeT));

        try {
            producer.start();
            consumer.start();
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
