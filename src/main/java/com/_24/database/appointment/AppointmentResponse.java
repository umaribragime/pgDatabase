package com._24.database.appointment;

import java.time.LocalTime;
import java.time.LocalDate;

public record AppointmentResponse (
        LocalDate date,
        LocalTime startTime,
        LocalTime endTime,
        boolean available
){

}
