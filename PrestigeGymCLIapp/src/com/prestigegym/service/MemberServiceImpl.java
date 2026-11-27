package com.prestigegym.service;

import com.prestigegym.model.Member;
import com.prestigegym.repository.MemberRepository;
import com.prestigegym.repository.MemberRepositoryImpl;

import java.util.List;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository repository =
            new MemberRepositoryImpl();

    @Override
    public List<Member> getAllMembers() {
        return repository.findAll();
    }

    @Override
    public Member getMemberById(int id) {
        return repository.findById(id);
    }

    @Override
    public void addMember(Member member) {
        repository.save(member);
    }

    @Override
    public void updateMember(Member member) {
        repository.update(member);
    }

    @Override
    public void archiveMember(int id) {
        repository.archive(id);
    }
}