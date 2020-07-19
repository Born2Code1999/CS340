import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FirstComeFirstServeAlgorithm {
    
    
    
    public ArrayList<Process> sortTheProcessesListAccordingly(ArrayList<Process> processesList){
        Collections.sort(processesList, new Comparator<Process>() {
            public int compare(Process p1, Process p2) {
                if (p1.getArrivalTime() > p2.getArrivalTime()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        return processesList;
    }
}
 