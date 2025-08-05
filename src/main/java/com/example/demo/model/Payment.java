package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.security.Timestamp;

@Entity
@Table(name = "payment")
public class Payment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long NumberCard;
  private String RefMonth;
  private Timestamp paymentDate;

  public Payment() {}

  public Payment(Long numberCard, String refMonth, Timestamp paymentDate) {
    NumberCard = numberCard;
    RefMonth = refMonth;
    this.paymentDate = paymentDate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getNumberCard() {
    return NumberCard;
  }

  public void setNumberCard(Long numberCard) {
    NumberCard = numberCard;
  }

  public String getRefMonth() {
    return RefMonth;
  }

  public void setRefMonth(String refMonth) {
    RefMonth = refMonth;
  }

  public Timestamp getPaymentDate() {
    return paymentDate;
  }

  public void setPaymentDate(Timestamp paymentDate) {
    this.paymentDate = paymentDate;
  }
}
