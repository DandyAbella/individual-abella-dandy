package com.prestigegym.service;

import com.prestigegym.model.MembershipPlan;
import com.prestigegym.repository.*;

import java.util.List;

public class MembershipPlanServiceImpl
        implements MembershipPlanService {

    private final MembershipPlanRepository repository =
            new MembershipPlanRepositoryImpl();

    @Override
    public List<MembershipPlan> getAllPlans() {
        return repository.findAll();
    }
}