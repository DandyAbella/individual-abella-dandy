package com.prestigegym.service;

import com.prestigegym.model.Attendance;
import com.prestigegym.repository.AttendanceRepository;
import com.prestigegym.repository.AttendanceRepositoryImpl;

import java.util.List;

public class AttendanceServiceImpl
        implements AttendanceService {

    private final AttendanceRepository repository =
            new AttendanceRepositoryImpl();

    @Override
    public List<Attendance> getAllAttendance() {
        return repository.findAll();
    }

    @Override
    public void checkIn(int memberId) {
        repository.checkIn(memberId);
    }

    @Override
    public void checkOut(int attendanceId) {
        repository.checkOut(attendanceId);
    }
}