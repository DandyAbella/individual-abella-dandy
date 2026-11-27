package com.prestigegym.view;

import com.prestigegym.repository.DashboardRepository;
import com.prestigegym.repository.DashboardRepositoryImpl;

public class DashboardView {

    public static void display() {

        DashboardRepository dashboard =
                new DashboardRepositoryImpl();

        System.out.println();
        System.out.println("===== DASHBOARD =====");

        System.out.println(
                "Total Members : "
                        + dashboard.getTotalMembers());

        System.out.println(
                "Active Memberships : "
                        + dashboard.getActiveMemberships());

        System.out.println(
                "Today's Attendance : "
                        + dashboard.getTodayAttendance());

        System.out.println(
                "Total Revenue : PHP "
                        + dashboard.getTotalRevenue());
    }
}