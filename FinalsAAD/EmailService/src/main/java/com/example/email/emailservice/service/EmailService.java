package com.example.email.emailservice.service;


import com.example.email.emailservice.dto.EmailDetails;
import com.example.email.emailservice.dto.PackageDetailsDTO;
import com.example.email.emailservice.entity.OTP;
import com.example.email.emailservice.response.Response;
import com.example.email.emailservice.service.custom.OTPService;
import com.fasterxml.uuid.Generators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private OTPService otpService;
    @Autowired
    private OTP otp;
    @Autowired
    private Response response;

    public ResponseEntity<Response> sendEmail(EmailDetails email) {
        System.out.println("Sending Email to: " + email.getToEmail());
        String otp = generateAndSaveOtp(email.getToEmail());
        String body = "Dear " + email.getName() + ",\n\n" + "Welcome aboard!.\n\n" +  "\n\n" + "Use the OTP below to complete your signup:\n" + otp + "\n\n" + "Regards,\n" + "Prabhash Wijerathna - Team NextTravel.";
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("prabhash04wije@gmail.com");
        message.setTo(email.getToEmail());
        message.setText(body);
        message.setSubject("NextTravel - Welcome Aboard!");
        mailSender.send(message);
        response.setStatusCode(200);
        response.setMessage("Email sent successfully");
        response.setData(otp);
        return new ResponseEntity<>(response, org.springframework.http.HttpStatus.OK);


    }
    public ResponseEntity<Response> sendPackageDetails(PackageDetailsDTO packageDetails) {
        String body = "Dear " + packageDetails.getOwnerFullName() + ",\n\n" +
                "Thank you for booking with us!\n\n" +
                "Booking Details:\n" +
               /* "Owner FullName : " + packageDetails.getOwnerFullName() + "\n" +*/
                "Owner Email: " + packageDetails.getOwnerEmail() + "\n" +
                "OwnerCardNumber: " + packageDetails.getOwnerCardNumber() + "\n" +
                "Payment Date : " + packageDetails.getPaymentDate() + "\n" +
                "Payment Amount: " + packageDetails.getPaymentAmount() + "\n" +

                "Regards,\n" +
                "Prabhash Wijerathna - Team NextTravel.";

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("prabhash04wije@gmail.com");
            message.setSubject("NextTravel - Booking Confirmation!");
            message.setTo(packageDetails.getOwnerEmail());
            message.setText(body);
            mailSender.send(message);
        } catch (MailException exception){
            throw new RuntimeException("An error occurred while sending the email! :" + exception.getLocalizedMessage());
        }


        response.setStatusCode(200);
        response.setMessage("Email sent successfully");
        response.setData(null);
        return new ResponseEntity<>(response, org.springframework.http.HttpStatus.OK);
    }

    private String generateAndSaveOtp(String email) {
        String otpCode = Generators.randomBasedGenerator().generate().toString();
        otp.setEmail(email);
        otp.setOtp(otpCode);
        otpService.saveOTP(otp);
        return otpCode;


    }

}




