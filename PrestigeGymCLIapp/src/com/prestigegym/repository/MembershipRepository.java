package com.prestigegym.repository;

import com.prestigegym.model.Membership;
import java.util.List;

public interface MembershipRepository {

    List<Membership> findAll();

    Membership findById(int id);

    void save(Membership membership);

    void update(Membership membership);

    void cancel(int id);
}