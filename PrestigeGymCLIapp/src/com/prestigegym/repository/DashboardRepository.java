package com.prestigegym.repository;

public interface DashboardRepository {

    int getTotalMembers();

    int getActiveMemberships();

    int getTodayAttendance();

    double getTotalRevenue();
}