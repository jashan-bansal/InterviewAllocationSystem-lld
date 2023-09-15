package InterviewAllocationSystem.Models;

import InterviewAllocationSystem.Enum.InterviewSlots;
import InterviewAllocationSystem.Enum.InterviewTypes;

public class InterviewMetaData {
    String interVieweeName;
    String interViewerName;
    InterviewSlots slot;
    InterviewTypes interviewType;

    public InterviewMetaData(String interVieweeName, String interViewerName, InterviewSlots interviewSlots, InterviewTypes interviewTypes) {
        this.interVieweeName = interVieweeName;
        this.interViewerName = interViewerName;
        this.slot = interviewSlots;
        this.interviewType = interviewTypes;
    }

    public String getInterVieweeName() {
        return this.interVieweeName;
    }

    public String getInterViewerName() {
        return this.interViewerName;
    }

    public InterviewSlots getSlot() {
        return this.slot;
    }

    public InterviewTypes getInterviewType() {
        return this.interviewType;
    }



}
