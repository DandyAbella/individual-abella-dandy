package com.prestigegym.service;

import com.prestigegym.model.Attendance;

import java.util.List;

public interface AttendanceService {

    List<Attendance> getAllAttendance();

    void checkIn(int memberId);

    void checkOut(int attendanceId);
}