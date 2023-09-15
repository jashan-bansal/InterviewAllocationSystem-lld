package InterviewAllocationSystem.Services;

import InterviewAllocationSystem.Enum.InterviewSlots;
import InterviewAllocationSystem.Enum.InterviewTypes;
import InterviewAllocationSystem.Models.Interviewee;
import InterviewAllocationSystem.Models.Interviewer;

import java.util.ArrayList;
import java.util.List;

public class InterviewerManager {
    List<Interviewer> interviewers = new ArrayList<>();

    public void registerInterviewer(String name, List<InterviewTypes> interviewTypes, int yearsOfExperience,
                                    List<InterviewSlots> avaiableInterviewSlots) {
        Interviewer interviewer = new Interviewer(name, interviewTypes, yearsOfExperience, avaiableInterviewSlots);
        interviewers.add(interviewer);
    }

    public  List<Interviewer> getInterviewers(){
        return this.interviewers;
    }

}
