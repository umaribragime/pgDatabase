package com._24.database.treatment;

import java.math.BigDecimal;
import java.time.Instant;

public record TreatmentResponse(
        Long id,
        String name,
        String description,
        BigDecimal price,
        Integer durationMinutes,
        boolean active,
        Instant createdAt,
        Instant updatedAt
) {
    public static TreatmentResponse from(Treatment treatment) {
        return new TreatmentResponse(
                treatment.getId(),
                treatment.getName(),
                treatment.getDescription(),
                treatment.getPrice(),
                treatment.getDurationMinutes(),
                treatment.isActive(),
                treatment.getCreatedAt(),
                treatment.getUpdatedAt()
        );
    }
}
