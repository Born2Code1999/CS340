import java.util.Random;


public class Assignment1 {

    
    
    public static void main(String[] args) {
        int nTotalProcesses;
        int kCpuTimeInterval;
        int dAverageTotalCpuTime;
        int vStandardDeviation;
        
        CpuSimulator cpu = new CpuSimulator(100, 1000, 40 , 8);
        FirstComeFirstServeAlgorithm fcfs = new FirstComeFirstServeAlgorithm();
        fcfs.sortTheProcessesListAccordingly(cpu.getGeneratedProcesses());
        cpu.startCpuSimulation();
    }
    
}
