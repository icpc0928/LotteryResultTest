package com.example.smtpmailservice.domain;

import com.example.smtpmailservice.adapter.ResultRequest;
import com.example.smtpmailservice.app.ResultServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ResultLogic implements Runnable{

    int testTimes; //幾次

    ResultRequest request;
    private final static Logger logger = LoggerFactory.getLogger(ResultLogic.class);


    public ResultLogic(int testTimes, ResultRequest request) {
        this.testTimes = testTimes;
        this.request = request;
    }

    @Override
    public void run() {
        List<Integer> except = request.getExceptResult();
        boolean canRepeat = request.getCanRepeat() != 0;
        int totalBall = request.getBalls();         //球數總量 0~9 || 1~10 || 1~80(keno)
        int resultCount = request.getResultCount(); //結果有幾個數量
        int firstBall = request.getFirstBall();

        int sumHitTimes = 0;

        RTPModel rtpModel = new RTPModel();

        for(int i = 0; i < testTimes; i++){
            List<Integer> originBallBag = new ArrayList<>();
            List<Integer> testResult = new ArrayList<>();
            for(int b = firstBall; b < (totalBall + firstBall); b++){
                originBallBag.add(b);
            }

            for(int t = 0; t < except.size(); t++){
                int get = getBall(originBallBag, canRepeat);
                testResult.add(get);
            }
            if(checkExcept(except, testResult)){
                sumHitTimes++;
            }
        }

        rtpModel.setTestTimes(testTimes);
        rtpModel.setHitCount(sumHitTimes);
        ResultServiceImpl.rtpModel.setRTPModel(rtpModel);
    }

    private boolean checkExcept(List<Integer> expect, List<Integer> testResult) {
        for(int i = 0; i < expect.size(); i++){
            int exceptBall = expect.get(i);
            if(exceptBall != testResult.get(i)){
                return false;
            }
        }
        return true;
    }

    private int getBall(List<Integer> originBallBag, boolean canRepeat) {
        int rand = (int)(Math.random() * originBallBag.size());
        if(canRepeat){
            return originBallBag.get(rand);
        }else{
            return originBallBag.remove(rand);
        }
    }


}
