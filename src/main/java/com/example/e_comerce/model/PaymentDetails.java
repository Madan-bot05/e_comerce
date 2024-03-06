package com.example.e_comerce.model;

import com.example.e_comerce.user.domain.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDetails {
//    private String paymentMethord;
    private String status;
    private String paymentId;
    private String razorpayPaymentLinkId;
    private String razorpayPaymentLinkStatus;
    private String razorpayPaymentLinkReferenceId;
    private String razorpayPaymentId;

//    public PaymentDetails(String status, String paymentId, String razorpayPaymentLinkId, String razorpayPaymentLinkStatus, String razorpayPaymentLinkReferenceId, String razorpayPaymentId) {
////        this.paymentMethord = paymentMethord;
//        this.status = status;
//        this.paymentId = paymentId;
//        this.razorpayPaymentLinkId = razorpayPaymentLinkId;
//        this.razorpayPaymentLinkStatus = razorpayPaymentLinkStatus;
//        this.razorpayPaymentLinkReferenceId = razorpayPaymentLinkReferenceId;
//        this.razorpayPaymentId = razorpayPaymentId;
//    }
//
//    public PaymentDetails() {
//    }
//
////    public String getPaymentMethord() {
////        return paymentMethord;
////    }
////
////    public void setPaymentMethord(String paymentMethord) {
////        this.paymentMethord = paymentMethord;
////    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(PaymentStatus status) {
//        this.status = status;
//    }
//
//    public String getPaymentId() {
//        return paymentId;
//    }
//
//    public void setPaymentId(String paymentId) {
//        this.paymentId = paymentId;
//    }
//
//    public String getRazorpayPaymentLinkId() {
//        return razorpayPaymentLinkId;
//    }
//
//    public void setRazorpayPaymentLinkId(String razorpayPaymentLinkId) {
//        this.razorpayPaymentLinkId = razorpayPaymentLinkId;
//    }
//
//    public String getRazorpayPaymentLinkStatus() {
//        return razorpayPaymentLinkStatus;
//    }
//
//    public void setRazorpayPaymentLinkStatus(String razorpayPaymentLinkStatus) {
//        this.razorpayPaymentLinkStatus = razorpayPaymentLinkStatus;
//    }
//
//    public String getRazorpayPaymentLinkReferenceId() {
//        return razorpayPaymentLinkReferenceId;
//    }
//
//    public void setRazorpayPaymentLinkReferenceId(String razorpayPaymentLinkReferenceId) {
//        this.razorpayPaymentLinkReferenceId = razorpayPaymentLinkReferenceId;
//    }
//
//    public String getRazorpayPaymentId() {
//        return razorpayPaymentId;
//    }
//
//    public void setRazorpayPaymentId(String razorpayPaymentId) {
//        this.razorpayPaymentId = razorpayPaymentId;
//    }
}
