package com.example.smtpmailservice.app;

import com.example.smtpmailservice.adapter.ResultRequest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ResultServiceImplTest {

    @Test
    public void testResult(){

        ResultService resultService = new ResultServiceImpl();

        ResultRequest request = new ResultRequest();
        request.setResultCount(10); //結果有幾個數量   //4D 寫4, 賽車寫10
        request.setBalls(10);  //球的可能總數 0~9 寫10  1~10 也寫10, 由firstBall判斷起始球從哪一號開始
        request.setCanRepeat(1); //每球結果可否重複: 0:不能重複, 1:能重複
        Integer[] excArr = new Integer[] {1,2,3}; //預期結果 (可以不用填滿球數量)
        request.setExceptResult(Arrays.asList(excArr));
        request.setTestTimes(10000000); //要測試幾次
        request.setFirstBall(1); //第一球 是0還是1

        var result = resultService.getResult(request);
        System.out.println(result);

    }

}