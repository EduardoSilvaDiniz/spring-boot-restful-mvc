package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Payment;
import com.example.demo.service.PaymentService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
  private final PaymentService paymentService;

  public PaymentController(PaymentService paymentService) {
    this.paymentService = paymentService;
  }

  @GetMapping("/payment")
  public List<Payment> getAll() {
    return paymentService.getAll();
  }

  @PostMapping("/payment")
  public Payment create(@RequestBody Payment newPayment) {
    return paymentService.save(newPayment);
  }

  @PutMapping("/payment/{id}")
  public Payment replace(@RequestBody Payment newPayment, @PathVariable Long id) {
    return paymentService.replace(newPayment, id);
  }

  @DeleteMapping("/payment/{id}")
  public void delete(@PathVariable Long id) {
    paymentService.deleteById(id);
  }
}
