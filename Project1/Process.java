public class Process {

    private int arrivalTime;
    private boolean isActiveBool = true;
    private int isActiveInt = 1;
    private int totalCpuTime;
    private int remainingCpuTime;
    private int turnAroundTime;

    public Process() {
    }

    public Process(int arrivalTime, boolean isActive, int totalCpuTime) {
        this.arrivalTime = arrivalTime;
        this.isActiveBool = isActive;
        this.totalCpuTime = totalCpuTime;
        this.remainingCpuTime = totalCpuTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public boolean isActive() {
        return isActiveBool;
    }

    public void setIsActiveBool(boolean isActiveBool) {
        this.isActiveBool = isActiveBool;
        if (isActiveBool) {
            isActiveInt = 1;
        } else {
            isActiveInt = 0;
        }
    }

    public int getIsActiveInt() {
        return isActiveInt;
    }

    public int getTotalCpuTime() {
        return totalCpuTime;
    }

    public void setTotalCpuTime(int totalCpuTime) {
        this.totalCpuTime = totalCpuTime;
        this.remainingCpuTime = totalCpuTime;
    }

    public int getTurnAroundTime() {
        return turnAroundTime;
    }

    public void setTurnAroundTime(int turnAroundTime) {
        this.turnAroundTime = turnAroundTime;
    }

    public void setRemainingCpuTime(int remainingCpuTime) {
        this.remainingCpuTime = remainingCpuTime;
    }

    public int getRemainingCpuTime() {
        return remainingCpuTime;
    }

}
