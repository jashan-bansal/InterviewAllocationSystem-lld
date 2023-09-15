package InterviewAllocationSystem.StartegyManager;

import InterviewAllocationSystem.Enum.AllocationStarategy;
import InterviewAllocationSystem.Implemenatations.BasicAllocationStrategy;
import InterviewAllocationSystem.Interfaces.InterviewAllocationStrategy;

public class InterviewStrategyManager {

    public InterviewAllocationStrategy determineStartegy(AllocationStarategy allocationStarategy) {
        //write a factory to choose a strategy
        return new BasicAllocationStrategy();
    }
}
