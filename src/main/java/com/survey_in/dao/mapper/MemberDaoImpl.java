package com.survey_in.dao.mapper;

import com.survey_in.entity.Member;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("memberDaoBean")
public class MemberDaoImpl implements MemberDao{

    private final SqlSession sqlSession;

    @Autowired
    public MemberDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<Member> getMembers() {
        return sqlSession.selectOne("MemberMapper.getMembers");
    }

    @Override
    public void insertMember(Member member) {
        sqlSession.insert("MemberMapper.insertMember", member);
    }

    @Override
    public Member selectMember(String id) {
        return (Member) sqlSession.selectOne("MemberMapper.selectMember", id);
    }

    @Override
    public int selectMemberId(String id) {
        return sqlSession.selectOne("MemberMapper.selectMemberId", id);
    }

    @Override
    public void deleteMember(String id) {

    }
}
