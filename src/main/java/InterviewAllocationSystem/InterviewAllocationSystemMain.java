package InterviewAllocationSystem;

import InterviewAllocationSystem.Enum.InterviewSlots;
import InterviewAllocationSystem.Enum.InterviewTypes;
import InterviewAllocationSystem.Models.Allocation;
import InterviewAllocationSystem.Models.InterviewMetaData;
import InterviewAllocationSystem.Models.Interviewer;
import InterviewAllocationSystem.Services.InterviewAllocationInfo;
import InterviewAllocationSystem.Services.InterviewAllocationSystem;
import InterviewAllocationSystem.Services.IntervieweeManager;
import InterviewAllocationSystem.Services.InterviewerManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class InterviewAllocationSystemMain {

    public static void main(String[] args) {
//        SpringApplication.run(InterviewAllocationSystemMain.class, args);

        InterviewerManager interviewerManager = new InterviewerManager();
        IntervieweeManager  intervieweeManager = new IntervieweeManager();
        InterviewAllocationInfo interviewAllocationInfo = new InterviewAllocationInfo();
        InterviewAllocationSystem interviewAllocationSystem = new InterviewAllocationSystem(intervieweeManager, interviewerManager, interviewAllocationInfo);

        List<InterviewTypes> interviewTypes = new ArrayList<>();
        interviewTypes.add(InterviewTypes.MC);
        interviewTypes.add(InterviewTypes.PSDS);

        List<InterviewSlots> avaiableInterviewSlots = new ArrayList<>();
        avaiableInterviewSlots.add(InterviewSlots.SLOT_1);
        avaiableInterviewSlots.add(InterviewSlots.SLOT_2);
        interviewerManager.registerInterviewer("Int1", interviewTypes, 2, avaiableInterviewSlots);

        avaiableInterviewSlots = new ArrayList<>();
        avaiableInterviewSlots.add(InterviewSlots.SLOT_2);
        avaiableInterviewSlots.add(InterviewSlots.SLOT_3);
        avaiableInterviewSlots.add(InterviewSlots.SLOT_4);
        interviewerManager.registerInterviewer("Int2", interviewTypes, 2, avaiableInterviewSlots);

        avaiableInterviewSlots = new ArrayList<>();
        avaiableInterviewSlots.add(InterviewSlots.SLOT_1);
        avaiableInterviewSlots.add(InterviewSlots.SLOT_2);
        intervieweeManager.registerInterviewee("C1", avaiableInterviewSlots);

        avaiableInterviewSlots = new ArrayList<>();
        avaiableInterviewSlots.add(InterviewSlots.SLOT_3);
        avaiableInterviewSlots.add(InterviewSlots.SLOT_4);
        intervieweeManager.registerInterviewee("C2", avaiableInterviewSlots);

        Allocation allocationDetails1 = new Allocation("C1");
        interviewAllocationSystem.assignInterviewer(allocationDetails1);

        Allocation allocationDetails2 = new Allocation("C2");
        interviewAllocationSystem.assignInterviewer(allocationDetails2);

        interviewAllocationSystem.printAllocatedInterviews();
    }
}
