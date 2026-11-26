package com.prestigegym.repository;

import com.prestigegym.model.MembershipPlan;
import java.util.List;

public interface MembershipPlanRepository {

    List<MembershipPlan> findAll();

}