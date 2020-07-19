import java.util.ArrayList;

public class CpuSimulator {

    private ArrayList<Process> generatedProcesses = new ArrayList<>();
    private ArrayList<Process> arrivedProcesses = new ArrayList<>();
    private ArrayList<Process> terminatedProcesses = new ArrayList<>();
    private int cpuTime = 0;

    public CpuSimulator(int nTotalProcesses, int kCpuTimeInterval, int dAverageTotalCpuTime, int vStandardDeviation) {

        ProcessGenerator pg = new ProcessGenerator(nTotalProcesses, kCpuTimeInterval, dAverageTotalCpuTime, vStandardDeviation);
        generatedProcesses = pg.getAllGeneratedProcesses();

    }

    public void startCpuSimulation() {

        cpuTime = generatedProcesses.get(0).getArrivalTime();
        while (true) {
            checkForArrivedProcesses();

            if (arrivedProcesses.isEmpty() == false) {
                runProcessForOneUnitTime(arrivedProcesses);
            }

            if (arrivedProcesses.isEmpty() == true && generatedProcesses.isEmpty() == true) {
                break;
            }
        }

        displayAverageTurnaroundTime();
    }

    public void checkForArrivedProcesses() {
        if (generatedProcesses.isEmpty() == false) {
            while (generatedProcesses.get(0).getArrivalTime() <= cpuTime) {
                arrivedProcesses.add(generatedProcesses.remove(0));
                displayActiveAndTerminatedProcessesTable();
                if (generatedProcesses.isEmpty() == true) {
                    break;
                }
            }
        }
    }

    public void runProcessForOneUnitTime(ArrayList<Process> arrivedProcesses) {

        Process currentlyRunningProcess = arrivedProcesses.get(0);
        currentlyRunningProcess.setRemainingCpuTime(currentlyRunningProcess.getRemainingCpuTime() - 1);
        checkForProcessTermination(currentlyRunningProcess);
        cpuTime++;

    }

    public void checkForProcessTermination(Process currentlyRunningProcess) {
        if (currentlyRunningProcess.getRemainingCpuTime() == 0) {
            currentlyRunningProcess.setTurnAroundTime(cpuTime - currentlyRunningProcess.getArrivalTime());
            currentlyRunningProcess.setIsActiveBool(false);
            terminatedProcesses.add(arrivedProcesses.remove(0));
            displayActiveAndTerminatedProcessesTable();
        }
    }

    public double getAverageTurnaroundTime(ArrayList<Process> terminatedProcesses) {
        int sumOfAllTurnaroundTimes = 0;
        for (int i = 0; i < terminatedProcesses.size(); i++) {
            sumOfAllTurnaroundTimes += terminatedProcesses.get(i).getTurnAroundTime();
        }
        double averageTurnaroundTime = sumOfAllTurnaroundTimes / terminatedProcesses.size();
        return averageTurnaroundTime;
    }

    public ArrayList<Process> getGeneratedProcesses() {
        return generatedProcesses;
    }

    public void displayActiveAndTerminatedProcessesTable() {
        displayActiveAndTerminatedProcessesTableHeading();

        Process p;
        int i = 0;
        for (i = 0; i < terminatedProcesses.size(); i++) {
            p = terminatedProcesses.get(i);
            System.out.println("P " + i + "\t|\t" + p.getIsActiveInt() + "\t|\t" + p.getArrivalTime() + "\t|\t" + p.getTotalCpuTime() + "\t|\t" + p.getRemainingCpuTime() + "\t|\t" + p.getTurnAroundTime());
        }
        for (int j = 0; j < arrivedProcesses.size(); j++) {
            p = arrivedProcesses.get(j);
            System.out.println("P " + (i + j) + "\t|\t" + p.getIsActiveInt() + "\t|\t" + p.getArrivalTime() + "\t|\t" + p.getTotalCpuTime() + "\t|\t" + p.getRemainingCpuTime() + "\t|\t" + p.getTurnAroundTime());
        }
        System.out.println("\n__________________________________________________________________________________\n");
    }

    public void displayActiveAndTerminatedProcessesTableHeading() {
        System.out.println("----CPU Time: " + cpuTime + "----\n");
        System.out.printf("%5s %12s %15s %16s %17s %15s", "Process", "Active", "Arrival", "Total CPU", "Remaining CPU", "Turnaround");
        System.out.println();
        System.out.printf("%34s %16s %15s %15s", "Time", "Time", "Time", "Time");
        System.out.println("\n");
    }
    
    public void displayTerminatedProcesses(){
        Process p;
        int i;
        for (i = 0; i < terminatedProcesses.size(); i++) {
            p = terminatedProcesses.get(i);
            System.out.println("P " + i + "\t|\t" + p.getIsActiveInt() + "\t|\t" + p.getArrivalTime() + "\t|\t" + p.getTotalCpuTime() + "\t|\t" + p.getRemainingCpuTime() + "\t|\t" + p.getTurnAroundTime());
        }
    }
    public void displayActiveProcesses(){
        Process p;
        int i = terminatedProcesses.size();
        for (int j = 0; j < arrivedProcesses.size(); j++) {
            p = arrivedProcesses.get(j);
            System.out.println("P " + (i + j) + "\t|\t" + p.getIsActiveInt() + "\t|\t" + p.getArrivalTime() + "\t|\t" + p.getTotalCpuTime() + "\t|\t" + p.getRemainingCpuTime() + "\t|\t" + p.getTurnAroundTime());
        }
    }

    public void displayAverageTurnaroundTime() {
        System.out.println("Average Turnaround time : " + getAverageTurnaroundTime(terminatedProcesses));
    }
}
