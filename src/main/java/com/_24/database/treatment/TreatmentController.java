package com._24.database.treatment;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/treatments")
public class TreatmentController {

    private final TreatmentService treatmentService;

    public TreatmentController(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }

    @GetMapping
    public List<TreatmentResponse> findAll(
            @RequestParam(defaultValue = "false") boolean includeInactive
    ) {
        return treatmentService.findAll(includeInactive);
    }

    @GetMapping("/{id}")
    public TreatmentResponse findById(@PathVariable Long id) {
        return treatmentService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TreatmentResponse create(@Valid @RequestBody TreatmentRequest request) {
        return treatmentService.create(request);
    }

    @PutMapping("/{id}")
    public TreatmentResponse update(
            @PathVariable Long id,
            @Valid @RequestBody TreatmentRequest request
    ) {
        return treatmentService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        treatmentService.delete(id);
    }
}
