package com._24.database.treatment;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TreatmentService {

    private final TreatmentRepository treatmentRepository;

    public TreatmentService(TreatmentRepository treatmentRepository) {
        this.treatmentRepository = treatmentRepository;
    }

    @Transactional(readOnly = true)
    public List<TreatmentResponse> findAll(boolean includeInactive) {
        List<Treatment> treatments = includeInactive
                ? treatmentRepository.findAll()
                : treatmentRepository.findAllByActiveTrue();
        return treatments.stream().map(TreatmentResponse::from).toList();
    }

    @Transactional(readOnly = true)
    public TreatmentResponse findById(Long id) {
        return treatmentRepository.findById(id)
                .map(TreatmentResponse::from)
                .orElseThrow(() -> new EntityNotFoundException("Treatment not found: " + id));
    }

    public TreatmentResponse create(TreatmentRequest request) {
        Treatment treatment = new Treatment();
        applyRequest(treatment, request);
        return TreatmentResponse.from(treatmentRepository.save(treatment));
    }

    public TreatmentResponse update(Long id, TreatmentRequest request) {
        Treatment treatment = treatmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Treatment not found: " + id));
        applyRequest(treatment, request);
        return TreatmentResponse.from(treatmentRepository.save(treatment));
    }

    public void delete(Long id) {
        Treatment treatment = treatmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Treatment not found: " + id));
        treatmentRepository.delete(treatment);
    }

    private void applyRequest(Treatment treatment, TreatmentRequest request) {
        treatment.setName(request.name());
        treatment.setDescription(request.description());
        treatment.setPrice(request.price());
        treatment.setDurationMinutes(request.durationMinutes());
        treatment.setActive(request.active() == null || request.active());
    }
}
