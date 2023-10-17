package com.example.smtpmailservice.domain;

import java.util.ArrayList;
import java.util.List;

public class RTPModel {

    int testTimes;
    int hitCount;

    List<Integer> expectResult;

    String report;


    public RTPModel() {
        this.testTimes = 0;
        this.hitCount = 0;
        this.expectResult = new ArrayList<>();
        this.report = "";
    }

    synchronized public void setRTPModel(RTPModel rtpModel){
        setTestTimes(rtpModel.getTestTimes());
        setHitCount(rtpModel.getHitCount());

    }


    public String getReport() {
        return report;
    }

    public void setReport(){
        if(hitCount == 0) return;
        float hitOdd = (float)testTimes / hitCount;
        this.report = "平均每 " + hitOdd + " 次中一次";

    }

    synchronized public void setTestTimes(int testTimes) {
        this.testTimes += testTimes;
    }
    synchronized public void setHitCount(int hitCount) {
        this.hitCount += hitCount;
    }

    public int getTestTimes() {
        return testTimes;
    }

    public int getHitCount() {
        return hitCount;
    }

    public List<Integer> getExpectResult() {
        return expectResult;
    }

    public void setExpectResult(List<Integer> expectResult) {
        this.expectResult = expectResult;
    }


}
