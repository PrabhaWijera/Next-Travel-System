package com.example.prabhash.paymentserver.service;

import com.example.prabhash.paymentserver.dto.Payment_dto;
import com.example.prabhash.paymentserver.entity.Payment_entity;
import com.example.prabhash.paymentserver.repo.PaymentRepo;
import com.example.prabhash.paymentserver.res.Response;
import com.example.prabhash.paymentserver.service.custom.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PaymentService_impl implements PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;
    @Autowired
    private Response response;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<Response> search(String id) {
        Optional<Payment_entity> paymentEntity=paymentRepo.findById(id);
        if (paymentEntity.isPresent()){
            return createAndSendResponse(HttpStatus.FOUND.value(), "sucsss",modelMapper.map(paymentEntity.get(),Payment_dto.class));
        }
        return createAndSendResponse(HttpStatus.NOT_EXTENDED.value(), "error found vehicle",null);
    }

    @Override
    public ResponseEntity<Response> save(Payment_dto paymentDto) {
        if (search(paymentDto.getPayID()).getBody().getData()==null){
            paymentRepo.save(modelMapper.map(paymentDto,Payment_entity.class));
            return createAndSendResponse(HttpStatus.OK.value(),"save ok payment",null);
        }
        throw new RuntimeException("payment save not ok");
    }

    @Override
    public ResponseEntity<Response> update(Payment_dto paymentDto) {
        Optional<Payment_entity> existingPyment = paymentRepo.findById(paymentDto.getPayID());

        if (existingPyment.isPresent()) {
            // The vehicle with the given ID exists, so update it
            Payment_entity updatedEntity = modelMapper.map(paymentDto, Payment_entity.class);
            updatedEntity.setPayID(paymentDto.getPayID()); // Set the ID to ensure an update
            paymentRepo.save(updatedEntity);
            return createAndSendResponse(HttpStatus.OK.value(), "Payment updated successfully",null);
        } else {
            // The vehicle with the given ID does not exist, so create a new entry
            Payment_entity newEntity = modelMapper.map(paymentDto, Payment_entity.class);
            paymentRepo.save(newEntity);
            return createAndSendResponse(HttpStatus.OK.value(), "Payment created successfully",null );
        }
    }

    @Override
    public ResponseEntity<Response> delete(String id) {
        if (search(id).getBody().getData()!=null){
            paymentRepo.deleteById(id);
            return  createAndSendResponse(HttpStatus.OK.value(), "delete payment ok",null);
        }
        throw new RuntimeException("No delete payment");
    }

    @Override
    public ResponseEntity<Response> getAll() {
        List<Payment_entity>payEntities=paymentRepo.findAll();
        if (!payEntities.isEmpty()){
            List<Payment_dto>payDtos=new ArrayList<>();
            payEntities.forEach(payEntity -> {
                payDtos.add(modelMapper.map(payEntity,Payment_dto.class));
            });
            return createAndSendResponse(HttpStatus.OK.value(),"Success Guide",payDtos);
        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(),"No success",null);

    }

    @Override
    public ResponseEntity<Response> createAndSendResponse(int statusCode, String msg, Object data) {
        response.setStatusCode(statusCode);
        response.setMessage(msg);
        response.setData(data);
        System.out.println("Status Code : " + statusCode);
        System.out.println("Sent : " + HttpStatus.valueOf(statusCode));

        return new ResponseEntity<>(response, HttpStatusCode.valueOf(statusCode));

    }


}
