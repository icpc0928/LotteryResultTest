package com.example.smtpmailservice.app;

import com.example.smtpmailservice.adapter.ResultRequest;
import com.example.smtpmailservice.domain.RTPModel;
import com.example.smtpmailservice.domain.ResultLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ResultServiceImpl implements ResultService {

    private final static Logger logger = LoggerFactory.getLogger(ResultServiceImpl.class);

    int threadNum = 10;

    public static RTPModel rtpModel = new RTPModel();

    @Override
    public RTPModel getResult(ResultRequest request) {
        rtpModel = new RTPModel();
        int totalTimes = request.getTestTimes();
        int oneThreadTimes = totalTimes / threadNum;


        ExecutorService exe = Executors.newFixedThreadPool(threadNum);

        for(int i = 0; i < threadNum; i++){
            ResultLogic resultLogic = new ResultLogic(oneThreadTimes, request);
            exe.execute(resultLogic);
        }

        exe.shutdown();
        while(true){
            if(exe.isTerminated()){
                logger.info("All threads done!");
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        rtpModel.setReport();
        return rtpModel;
    }
}
