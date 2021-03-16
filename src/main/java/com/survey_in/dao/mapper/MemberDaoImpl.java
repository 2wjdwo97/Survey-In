package com.survey_in.dao.mapper;

import com.survey_in.entity.Member;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("memberDaoBean")
public class MemberDaoImpl implements MemberDao {

    private final SqlSession sqlSession;

    @Autowired
    public MemberDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<Member> getMembers() {
        return sqlSession.selectList("MemberMapper.getMembers");
    }

    @Override
    public void insertMember(Member member) {
        sqlSession.insert("MemberMapper.insertMember", member);
    }

    @Override
    public Member selectMember(String username) {
        return sqlSession.selectOne("MemberMapper.selectMember", username);
    }

    @Override
    public Member selectMemberBySurvey(int id) {
        return sqlSession.selectOne("MemberMapper.selectMemberBySurvey", id);
    }

    @Override
    public int selectMemberId(String username) {
        return sqlSession.selectOne("MemberMapper.selectMemberId", username);
    }

    @Override
    public void deleteMember(String username) {
        sqlSession.delete("MemberMapper.deleteMember", username);
    }

    public int countMember(Map<String, Integer> info) {
        return sqlSession.selectOne("MemberMapper.countMember", info);
    }

    public int getPoint(String from) {
        return sqlSession.selectOne("MemberMapper.getPoint", from);
    }

    public void addPoint(Map<String, Object> info) {
        sqlSession.update("MemberMapper.addPoint", info);
    }

    public void subPoint(Map<String, Object> info) {
        sqlSession.update("MemberMapper.subPoint", info);
    }
}
