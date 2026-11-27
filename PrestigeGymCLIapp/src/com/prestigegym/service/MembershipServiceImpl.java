package com.prestigegym.service;

import com.prestigegym.model.Membership;
import com.prestigegym.repository.MembershipRepository;
import com.prestigegym.repository.MembershipRepositoryImpl;

import java.util.List;

public class MembershipServiceImpl
        implements MembershipService {

    private final MembershipRepository repository =
            new MembershipRepositoryImpl();

    @Override
    public List<Membership> getAllMemberships() {
        return repository.findAll();
    }

    @Override
    public Membership getMembershipById(int id) {
        return repository.findById(id);
    }

    @Override
    public void addMembership(Membership membership) {
        repository.save(membership);
    }

    @Override
    public void updateMembership(Membership membership) {
        repository.update(membership);
    }

    @Override
    public void cancelMembership(int id) {
        repository.cancel(id);
    }
}