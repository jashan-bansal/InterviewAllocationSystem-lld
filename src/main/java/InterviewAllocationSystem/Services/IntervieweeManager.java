package InterviewAllocationSystem.Services;

import InterviewAllocationSystem.Enum.InterviewSlots;
import InterviewAllocationSystem.Models.Interviewee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntervieweeManager {
    Map<String, Interviewee> interviewees = new HashMap<>();

    public void registerInterviewee(String name, List<InterviewSlots> avaiableInterviewSlots) {
        Interviewee interviewee = new Interviewee(name, avaiableInterviewSlots);
        interviewees.put(name, interviewee);
    }

    public Interviewee getInterviewDetails(String name) {
        if (interviewees.get(name) == null) return null;

        return interviewees.get(name);
    }
}
