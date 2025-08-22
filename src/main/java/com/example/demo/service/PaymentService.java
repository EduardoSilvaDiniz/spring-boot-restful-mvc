package com.example.demo.service;

import com.example.demo.model.Payment;
import com.example.demo.repository.PaymentRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
  private final PaymentRepository paymentRepository;

  public PaymentService(PaymentRepository paymentRepository) {
    this.paymentRepository = paymentRepository;
  }

  public List<Payment> getAll() {
    return paymentRepository.findAll();
  }

	public Optional<Payment> getById(Long id){
		return paymentRepository.findById(id);
	}

  public Payment save(Payment newPayment) {
    return paymentRepository.save(newPayment);
  }

  public Payment replace(Payment newPayment, Long id) {
    return paymentRepository
        .findById(id)
        .map(
            payment -> {
              payment.setPaymentDate(newPayment.getPaymentDate());
              payment.setRefMonth(newPayment.getRefMonth());
              return paymentRepository.save(payment);
            })
        .orElseGet(
            () -> {
              return paymentRepository.save(newPayment);
            });
  }

  public void deleteById(Long id) {
    paymentRepository.deleteById(id);
  }
}
