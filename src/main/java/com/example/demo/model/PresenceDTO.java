package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PresenceDTO {
    private Long numberCard;
    private Long meetingId;
    private Boolean isPresence;

    public PresenceDTO() {
		}

		public PresenceDTO(Long numberCard, Long meetingId, Boolean isPresence) {
			this.numberCard = numberCard;
			this.meetingId = meetingId;
			this.isPresence = isPresence;
		}

		public Presence toEntity() {
        return new Presence(isPresence, numberCard, meetingId);
    }
}
