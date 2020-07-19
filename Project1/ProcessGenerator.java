import java.util.ArrayList;
import java.util.Random;

public class ProcessGenerator {

    private ArrayList<Process> processesList = new ArrayList<>();
    private Random random = new Random();

    public ProcessGenerator(int nTotalProcesses, int kCpuTimeInterval, int dAverageTotalCpuTime, int vStandardDeviation) {

        for (int i = 0; i < nTotalProcesses; i++) {
            Process process = new Process();

            process.setArrivalTime((int) (random.nextDouble() * kCpuTimeInterval));
            process.setTotalCpuTime((int) (random.nextGaussian() * vStandardDeviation) + dAverageTotalCpuTime);
            processesList.add(process);

        }

    }

    public void displayAllGeneratedProcesses() {

        for (int i = 0; i < processesList.size(); i++) {
            System.out.println("Process: " + i + ", Active: " + processesList.get(i).isActive() + ", Arrival Time: " + processesList.get(i).getArrivalTime() + ", Total Cpu Time: " + processesList.get(i).getTotalCpuTime());
        }
    }

    public ArrayList<Process> getAllGeneratedProcesses() {
        
        return processesList;
    }
}
