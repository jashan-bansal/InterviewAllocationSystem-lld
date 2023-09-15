package InterviewAllocationSystem.Interfaces;

import InterviewAllocationSystem.Models.Interview;
import InterviewAllocationSystem.Models.InterviewMetaData;
import InterviewAllocationSystem.Models.Interviewee;
import InterviewAllocationSystem.Services.InterviewAllocationInfo;
import InterviewAllocationSystem.Services.InterviewerManager;

import java.util.List;

public interface InterviewAllocationStrategy {
    InterviewMetaData allocate(Interviewee interviewee, InterviewerManager interviewerManager, InterviewAllocationInfo interviewAllocationInfo);
}
