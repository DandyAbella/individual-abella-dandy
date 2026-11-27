package com.prestigegym.repository;

import com.prestigegym.model.MembershipPlan;
import java.util.List;

public interface MembershipPlanRepository {

    List<MembershipPlan> findAll();

    MembershipPlan findById(int id);

    void save(MembershipPlan plan);

    void update(MembershipPlan plan);

    void delete(int id);
}