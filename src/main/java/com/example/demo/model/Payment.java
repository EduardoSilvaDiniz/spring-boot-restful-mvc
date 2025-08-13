package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.security.Timestamp;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "payment")
@Getter
@Setter
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
}
