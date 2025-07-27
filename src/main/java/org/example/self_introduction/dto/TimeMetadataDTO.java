package org.example.self_introduction.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
public class TimeMetadataDTO {

    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    protected TimeMetadataDTO() {}

    protected TimeMetadataDTO(LocalDateTime createdAt, LocalDateTime updatedAt) {

        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static TimeMetadataDTO now() {

        LocalDateTime now = LocalDateTime.now();
        return new TimeMetadataDTO(now,now);
    }

    public static TimeMetadataDTO of(LocalDateTime createdAt, LocalDateTime updatedAt){

        return new TimeMetadataDTO(createdAt,updatedAt);
    }
}
