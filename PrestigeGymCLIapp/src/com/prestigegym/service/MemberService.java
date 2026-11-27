package com.prestigegym.service;

import com.prestigegym.model.Member;
import java.util.List;

public interface MemberService {

    List<Member> getAllMembers();

    Member getMemberById(int id);

    void addMember(Member member);

    void updateMember(Member member);

    void archiveMember(int id);
}