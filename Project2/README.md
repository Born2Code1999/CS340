## Producer Consumer Assignment
Design
1. You will implement Java code for the bounded buffer problem discussed in the lecture on threads and observe
a race condition. The file Factory.java on the course website’s Notes webpage can help with this assignment.
2. The buffer is a large array of n integers, initialized to all zeros.
3. The producer and the consumer are separate concurrent threads in your program.
4. The producer executes short bursts of random duration. During each burst of length k1, the producer adds a
1 to the next k1 slots of the buffer, modulo n.
5. The consumer also executes short bursts of random duration. During each burst of length k2, the consumer
reads the next k2 slots, modulo n, and resets each to 0.
6. If any slot contains a number greater than 1, then a race condition has been detected: the consumer was unable
to keep up and thus the producer has added a 1 to a slot that has not yet been reset.
7. Both producer and consumer sleep periodically for random time intervals to emulate unpredictable execution
speeds.
8. The producer thread pseudo code:
while (true)
{
 generate random integer k1 using k.
 for i from 0 to (k1 – 1)
 {
 buffer[(next_in + i) mod n] += 1
 }
 next_in = (next_in + k1) mod n
 generate random integer t1 using t
 sleep for t1 seconds
}
Page 2 of 5
9. The consumer thread pseudo code:
while (true)
{
 generate random integer t2 using t
 sleep for t2 seconds
 generate random integer k2 using k
 for i from 0 to (k2 – 1)
 {
 data = buffer[(next_out + i) mod n]
 if (data > 1) exit and report race condition
 buffer[(next_out + i) mod n] = 0
 }
 next_out = (next_out + k2) mod n
}
10. A thread which executes a call to the Thread.sleep(m) method sleeps, does nothing, for m milliseconds. Since
the values t1 and t2 are the number of seconds to put a thread to sleep then that value must be multiplied by
1,000 before passing it as the parameter to the Thread.sleep method.
11. Create a driver class and make the name of the driver class Assignment2 containing only one method:
public static void main(String args[]).
The main method receives, via the command line arguments, the values for n, k, and t, in that order. The main
method creates and initializes the buffer array, then creates the producer and consumer objects, then starts the
producer and consumer objects, and then executes a join on the producer and the consumer objects. Executing
a join on a thread object is done by calling its join() method.
I compile and run your program via the command line using the Java JDK. Therefore, the command I type
to execute your program is java Assignment2. I will test your program with my own values for n, k, and t.
For example, if n = 100, k = 22, and t = 60 then the command to run the program is:
java Assignment2 100 22 60
12. Experiment with different values of n, k, and t until you observe a race condition. Reporting the race condition
means the consumer prints the message that a race condition occurred. Your program will not terminate on
its own. You will terminate it yourself when you experiment with the different values of n, k, and t. If, after
a reasonable amount of time, your program does not print the race condition message, then just stop your
program. If your program does print the race condition message, then just stop your program. When you find
a combination of values for n, k, and t that cause a race condition, add a comment to the top of your
Assignment2.java file listing those values. It will be at this point that you can submit your assignment.
