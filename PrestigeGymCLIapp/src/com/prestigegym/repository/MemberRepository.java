package com.prestigegym.repository;

import com.prestigegym.model.Member;
import java.util.List;

public interface MemberRepository {

    List<Member> findAll();

    Member findById(int id);

    void save(Member member);

    void update(Member member);

    void archive(int id);
}