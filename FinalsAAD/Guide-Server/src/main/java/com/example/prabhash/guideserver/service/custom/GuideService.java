package com.example.prabhash.guideserver.service.custom;

import com.example.prabhash.guideserver.dto.Guide_dto;
import com.example.prabhash.guideserver.res.Response;
import com.example.prabhash.guideserver.service.SuperService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GuideService extends SuperService<Guide_dto,String> {

    ResponseEntity<Response> deleteAllGuides(List<String> guideID);



}
