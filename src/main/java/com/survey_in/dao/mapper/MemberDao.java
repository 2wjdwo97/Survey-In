package com.survey_in.dao.mapper;

import com.survey_in.entity.Member;

import java.util.List;

public interface MemberDao {
    List<Member> getMembers();
    void insertMember(Member member);
    Member selectMember(String username);
    int selectMemberId(String username);
    void deleteMember(String username);
}
