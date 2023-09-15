package InterviewAllocationSystem.Models;

import InterviewAllocationSystem.Enum.InterviewSlots;
import InterviewAllocationSystem.Enum.InterviewTypes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Interviewer {
    String name;
    int yearsOfExperience;
    List<InterviewTypes> interviewTypes;
    List<InterviewSlots> interviewSlots;
    Map<InterviewSlots, Boolean> interviewSlotStatus;

    public Interviewer(String name, List<InterviewTypes> interviewTypes, int yearsOfExperience, List<InterviewSlots> avaiableInterviewSlots) {
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
        this.interviewTypes = interviewTypes;
        this.interviewSlots = avaiableInterviewSlots;
        this.interviewSlotStatus = new HashMap<>();
        for (InterviewSlots interviewSlot: avaiableInterviewSlots) {
            this.interviewSlotStatus.put(interviewSlot, false);
        }
    }

    public String getName() {
        return this.name;
    }

    public int getYearsOfExperience() {
        return this.yearsOfExperience;
    }

    public List<InterviewTypes> getInterviewTypes() {
        return this.interviewTypes;
    }

    public List<InterviewSlots> getInterviewSlots() {
        return this.interviewSlots;
    }

    public void setInterviewSlotStatus(InterviewSlots slot, Boolean isAvail) {
        this.interviewSlotStatus.put(slot, isAvail);
    }

    public Map<InterviewSlots, Boolean> getInterviewSlotStatus() {
        return this.interviewSlotStatus;
    }

}
