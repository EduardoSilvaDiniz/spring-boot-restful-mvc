package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user_table")
public class Associated {
  @Id private Long numberCard;

  @NotNull(message = "associado precisa de um grupo")
  private Long groupId;

  private String name;

  public Associated() {}

	public Associated(Long numberCard, @NotNull(message = "associado precisa de um grupo") Long groupId, String name) {
		this.numberCard = numberCard;
		this.groupId = groupId;
		this.name = name;
	}

}
