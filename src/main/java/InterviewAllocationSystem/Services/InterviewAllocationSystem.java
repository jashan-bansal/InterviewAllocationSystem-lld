package InterviewAllocationSystem.Services;

import InterviewAllocationSystem.Interfaces.InterviewAllocationStrategy;
import InterviewAllocationSystem.Models.Allocation;
import InterviewAllocationSystem.Models.InterviewMetaData;
import InterviewAllocationSystem.Models.Interviewee;
import InterviewAllocationSystem.StartegyManager.InterviewStrategyManager;


public class InterviewAllocationSystem {
    private IntervieweeManager intervieweeManager;
    private InterviewerManager interviewerManager;
    private InterviewMetaData interviewMetaData;
    private InterviewAllocationStrategy interviewAllocationStrategy;
    private InterviewStrategyManager interviewStrategyManager;

    private InterviewAllocationInfo interviewAllocationInfo;

    public InterviewAllocationSystem(IntervieweeManager intervieweeManager, InterviewerManager interviewerManager, InterviewAllocationInfo interviewAllocationInfo) {
        this.interviewerManager = interviewerManager;
        this.intervieweeManager = intervieweeManager;
        this.interviewStrategyManager = new InterviewStrategyManager();
        this.interviewAllocationInfo = interviewAllocationInfo;
    }

    public void assignInterviewer(Allocation allocationDetails) {
        try {
            Interviewee interviewee = intervieweeManager.getInterviewDetails(allocationDetails.getIntervieweeName());
            InterviewAllocationStrategy interviewAllocationStrategy = this.interviewStrategyManager.determineStartegy(allocationDetails.getAllocationStategy());
            interviewAllocationStrategy.allocate(interviewee, this.interviewerManager, this.interviewAllocationInfo);

        } catch (Exception exception) {
            System.out.println("Error occured while allocation interviewer."+ exception.getMessage());
        }
    }

    public void printAllocatedInterviews() {
        try {
            this.interviewAllocationInfo.getInterviewMetaDataMap().forEach((key, value) -> {
                value.forEach(metadata -> {
                    System.out.println(metadata.getInterVieweeName() + ", " + metadata.getInterviewType() + ", " +
                            metadata.getSlot() + ", " + metadata.getInterViewerName());
                });
            });
        } catch (Exception exception) {
            System.out.println("Error occured while printing interview details"+ exception.getMessage());
        }
    }

}
