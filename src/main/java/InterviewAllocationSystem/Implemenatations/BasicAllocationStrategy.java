package InterviewAllocationSystem.Implemenatations;

import InterviewAllocationSystem.Enum.InterviewSlots;
import InterviewAllocationSystem.Enum.InterviewTypes;
import InterviewAllocationSystem.Interfaces.InterviewAllocationStrategy;
import InterviewAllocationSystem.Models.Interview;
import InterviewAllocationSystem.Models.InterviewMetaData;
import InterviewAllocationSystem.Models.Interviewee;
import InterviewAllocationSystem.Models.Interviewer;
import InterviewAllocationSystem.Services.InterviewAllocationInfo;
import InterviewAllocationSystem.Services.InterviewerManager;

import java.util.List;
import java.util.Map;

public class BasicAllocationStrategy implements InterviewAllocationStrategy {
    public InterviewMetaData allocate(Interviewee interviewee, InterviewerManager interviewerManager, InterviewAllocationInfo interviewAllocationInfo) {
        //write basic allocation startegy
        InterviewMetaData interviewMetaData = null;
        List<Interviewer> interviewers = interviewerManager.getInterviewers();
        try {

            for (InterviewTypes interviewType : InterviewTypes.values()) {
                List<InterviewMetaData> interviewMetaDataList = interviewAllocationInfo.getAllocatedInterviewInfo(interviewee.getName());

                for (InterviewSlots interviewSlot: interviewee.getInterviewSlots()) {

                    //means slot is already booked
                    if (interviewee.getInterviewSlotBookedStatus(interviewSlot) == true) continue;

                    InterviewMetaData allocatedInterviewMetaData = this.allocateInterview(interviewee, interviewers, interviewType,
                            interviewSlot, interviewMetaDataList);

                    if (allocatedInterviewMetaData != null) {
                        interviewAllocationInfo.registerInterviewMetaData(allocatedInterviewMetaData);
                        interviewee.setInterviewSlotBookedStatus(allocatedInterviewMetaData.getSlot(), true);
                        break;
                    }
                }
            }

        } catch (Exception exception) {
        }

        return interviewMetaData;
    }


    private InterviewMetaData allocateInterview(Interviewee interviewee, List<Interviewer> interviewers, InterviewTypes interviewType,
                                                InterviewSlots interviewSlot, List<InterviewMetaData> interviewMetaDataList) {

        InterviewMetaData interviewMetaData = null;

        for (Interviewer interviewer : interviewers) {

            if (!checkIfEligibleForInterview(interviewee, interviewer, interviewMetaDataList)) continue;

            List<InterviewSlots> interviewSlots = interviewer.getInterviewSlots();
            Map<InterviewSlots, Boolean> interviewSlotsStatus = interviewer.getInterviewSlotStatus();

            for (InterviewSlots interviewerInterviewSlot : interviewSlots) {
                if (interviewSlotsStatus.get(interviewerInterviewSlot) == false
                        && interviewee.getInterviewSlots().contains(interviewerInterviewSlot)
                        && interviewee.getInterviewSlotBookedStatus(interviewerInterviewSlot) != true) {
                    //allocate the interview
                    interviewMetaData = new InterviewMetaData(interviewee.getName(), interviewer.getName(),
                            interviewSlot, interviewType);

                    break;
                }
            }
        }
        return interviewMetaData;

    }

    private Boolean checkIfEligibleForInterview(Interviewee interviewee, Interviewer interviewer, List<InterviewMetaData> interviewMetaDataList) {
        Boolean isEligible = true;

        for (InterviewMetaData interviewMetaData: interviewMetaDataList){
            if (!interviewMetaData.getInterViewerName().isEmpty() && interviewMetaData.getInterViewerName().equalsIgnoreCase(interviewer.getName())) {
                isEligible = false;
                break;
            }
        }

        return isEligible;
    }

}
