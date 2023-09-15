package InterviewAllocationSystem.Models;

import InterviewAllocationSystem.Enum.AllocationStarategy;

public class Allocation {
    String intervieweeName;
    AllocationStarategy allocationStategy;

    public Allocation(String intervieweeName) {
        this.intervieweeName = intervieweeName;
        this.allocationStategy = AllocationStarategy.DEFAULT;
    }

    public AllocationStarategy getAllocationStategy() { return  this.allocationStategy; }

    public String getIntervieweeName() {
        return this.intervieweeName;
    }
}
