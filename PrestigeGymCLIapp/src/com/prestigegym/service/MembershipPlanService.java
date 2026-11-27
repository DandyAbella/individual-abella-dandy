package com.prestigegym.service;

import com.prestigegym.model.MembershipPlan;
import java.util.List;

public interface MembershipPlanService {

    List<MembershipPlan> getAllPlans();

    MembershipPlan getPlanById(int id);

    void updatePlan(MembershipPlan plan);

}
