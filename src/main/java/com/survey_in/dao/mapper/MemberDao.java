package com.survey_in.dao.mapper;

import com.survey_in.entity.Member;

import java.util.List;
import java.util.Map;

public interface MemberDao {
    List<Member> getMembers();
    void insertMember(Member member);
    Member selectMember(String username);
    Member selectMemberBySurvey(int id);
    int selectMemberId(String username);
    void deleteMember(String username);

    int countMember(Map<String, Integer> info);
    int getPoint(String from);
    void addPoint(Map<String, Object> info);
    void subPoint(Map<String, Object> info);
}