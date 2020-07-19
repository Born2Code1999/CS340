## Simulation Assignment
The simulation maintains the current time, t, which is initialized to 0 and is incremented after each simulation
step. Each simulation step then consists of the following actions within the repeat loop:
repeat
increment t
if there is at least one active process
choose from the active processes a process Pᵢ to run next,
according to the scheduling algorithm.
decrement Rᵢ (Pᵢ has accumulated 1 CPU time unit)
if Rᵢ == 0 (process i has terminated)
set active flag of Pᵢ = 0
TTᵢ = t - Aᵢ
end if
until Rᵢ == 0 for all n processes (all processes have terminated)
compute the average turnaround time, ATT, by averaging all values TTᵢ
Page 2 of 5
Design
1. Implement the above simulation in Java for the First Come First Serve scheduling algorithm.
2. Choose a value for n.
3. Choose a value for k, which is the time interval during which processes may arrive. Ex: k = 100.
4. Using a random number generator, derive n arrival times, Ai, for all processes, distributed uniformly within
the interval [0 : k]. Note: the java.util.Random class provides a random number generator. Create an instance
of this class and use the nextDouble() method to get a random number from the range of 0.0 to 1.0. Multiply
the random number by k to generate an arrival time Ai.
5. Choose an average total CPU time, d, and a standard deviation, v, and derive n total CPU times, Ti, using a
normal (Gaussian) distribution. Note: the java.util.Random class instance from number 3 above also has a
nextGaussian() method which generates a Gaussian distributed random number from the range of 0.0 to 1.0.
Multiply the Gaussian distributed random number by the standard deviation v and add the average total CPU
time d to generate a total CPU time Ti.
6. The values d and v should be selected relative to k. For simplicity, v could be just be a fixed percentage of d.
The value k/n represents the frequency of process arrivals. When d is much smaller than k/n, then most
processes run in isolation, without having to compete with other processes for the CPU. On the other hand,
when d is much larger than k/n, then many processes will overlap in time and compete for the CPU. Choose
a value for d that is much larger than k/n.
7. One or more classes implement the simulator and one or more classes implement the First Come First Serve
scheduling algorithm.
8. Create a driver class and make the name of the driver class Assignment1 containing only one method:
public static void main(String args[]). The main method receives, via the command line
arguments, the values for n, k, d, and v, in that order. The main method creates the simulator object, the
scheduling algorithm object, and initiates the execution of the simulator.
I compile and run your program via the command line using the Java JDK. Therefore, the command I type
to execute your program is java Assignment1. I’ll test your program with my own values for n, k, d, and v.
For example, if n = 100, k = 1000, d = 40, and v = 8 then the command to run the program is:
java Assignment1 100 1000 40 8
