package com.prestigegym.repository;

import com.prestigegym.model.Attendance;

import java.util.List;

public interface AttendanceRepository {

    List<Attendance> findAll();

    void checkIn(int memberId);

    void checkOut(int attendanceId);
}