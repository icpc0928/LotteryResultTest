package com.example.smtpmailservice.app;

import com.example.smtpmailservice.adapter.ResultRequest;
import com.example.smtpmailservice.domain.RTPModel;

public interface ResultService {

    RTPModel getResult(ResultRequest request);
}
