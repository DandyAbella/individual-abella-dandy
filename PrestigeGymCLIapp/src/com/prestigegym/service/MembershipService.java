package com.prestigegym.service;

import com.prestigegym.model.Membership;
import java.util.List;

public interface MembershipService {

    List<Membership> getAllMemberships();

    Membership getMembershipById(int id);

    void addMembership(Membership membership);

    void updateMembership(Membership membership);

    void cancelMembership(int id);
}