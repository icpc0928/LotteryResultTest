package com.example.smtpmailservice.adapter;

import java.util.List;

public class ResultRequest {
    private Integer resultCount;//結果有幾個數量   //4D 寫4, 賽車寫10
    private Integer balls;      //球的可能總數 0~9 寫10  1~10 也寫10, 由firstBall判斷起始球從哪一號開始
    private Integer canRepeat;  //每球結果可否重複: 0:不能重複, 1:能重複
    private List<Integer> exceptResult;//預期結果 (可以不用填滿球數量)

    private Integer testTimes;  //要測試幾次

    private Integer firstBall; //第一球 是0還是1

    public Integer getResultCount() {
        return resultCount;
    }

    public void setResultCount(Integer resultCount) {
        this.resultCount = resultCount;
    }

    public Integer getBalls() {
        return balls;
    }

    public void setBalls(Integer balls) {
        this.balls = balls;
    }

    public Integer getCanRepeat() {
        return canRepeat;
    }

    public void setCanRepeat(Integer canRepeat) {
        this.canRepeat = canRepeat;
    }

    public List<Integer> getExceptResult() {
        return exceptResult;
    }

    public void setExceptResult(List<Integer> exceptResult) {
        this.exceptResult = exceptResult;
    }

    public Integer getTestTimes() {
        return testTimes;
    }

    public void setTestTimes(Integer testTimes) {
        this.testTimes = testTimes;
    }

    public Integer getFirstBall() {
        return firstBall;
    }

    public void setFirstBall(Integer firstBall) {
        this.firstBall = firstBall;
    }
}
