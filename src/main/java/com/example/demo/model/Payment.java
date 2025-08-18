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
@Getter
@Setter
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
    this.NumberCard = numberCard;
    this.RefMonth = refMonth;
    this.paymentDate = paymentDate;
  }
}
