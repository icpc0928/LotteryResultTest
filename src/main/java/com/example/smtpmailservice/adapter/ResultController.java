package com.example.smtpmailservice.adapter;



import com.example.smtpmailservice.app.ResultService;
import com.example.smtpmailservice.domain.RTPModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class ResultController {

    private final ResultService resultService;


    private final static Logger logger = LoggerFactory.getLogger(ResultController.class);

    public ResultController(ResultService resultService) {

        this.resultService = resultService;
    }

    @PostMapping(path = "/resultTest")
    public RTPModel sendMail(@RequestBody ResultRequest request){
        return resultService.getResult(request);
    }


}
