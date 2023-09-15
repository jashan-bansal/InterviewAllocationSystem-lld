package InterviewAllocationSystem.Models;

import InterviewAllocationSystem.Enum.InterviewSlots;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Interviewee {
    String name;
    List<InterviewSlots> interviewSlots;

    Map<InterviewSlots, Boolean> interviewSlotBookedStatus;

    public Interviewee(String name, List<InterviewSlots> avaiableInterviewSlots) {
        this.name = name;
        this.interviewSlots = avaiableInterviewSlots;
        this.interviewSlotBookedStatus = new HashMap<>();
        for(InterviewSlots interviewSlots : avaiableInterviewSlots) {
            this.interviewSlotBookedStatus.put(interviewSlots, false);
        }
    }

    public String getName() {
        return this.name;
    }

    public List<InterviewSlots> getInterviewSlots() {
        return this.interviewSlots;
    }

    public Boolean getInterviewSlotBookedStatus(InterviewSlots interviewSlots) {
        return this.interviewSlotBookedStatus.get(interviewSlots);
    }

    public void setInterviewSlotBookedStatus(InterviewSlots interviewSlots, Boolean isBooked) {
        this.interviewSlotBookedStatus.put(interviewSlots, isBooked);
    }

}
