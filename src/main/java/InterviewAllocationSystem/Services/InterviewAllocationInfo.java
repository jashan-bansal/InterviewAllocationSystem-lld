package InterviewAllocationSystem.Services;

import InterviewAllocationSystem.Models.InterviewMetaData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InterviewAllocationInfo {
    Map<String, List<InterviewMetaData>> interviewMetaDataMap;

    public InterviewAllocationInfo() {
        this.interviewMetaDataMap = new HashMap<>();
    }

    public Map<String, List<InterviewMetaData>> getInterviewMetaDataMap(){
        return this.interviewMetaDataMap;
    }

    public void registerInterviewMetaData(InterviewMetaData interviewMetaData){
        List<InterviewMetaData> interviewMetaDataList = this.getAllocatedInterviewInfo(interviewMetaData.getInterVieweeName());

        if (interviewMetaDataList == null) {
            interviewMetaDataList = new ArrayList<>();
        }

        interviewMetaDataList.add(interviewMetaData);
        this.interviewMetaDataMap.put(interviewMetaData.getInterVieweeName(), interviewMetaDataList);
    }

    public List<InterviewMetaData>  getAllocatedInterviewInfo(String intervieweeName){
        return this.interviewMetaDataMap.get(intervieweeName) != null ? this.interviewMetaDataMap.get(intervieweeName) : new ArrayList<>();
    }
}
