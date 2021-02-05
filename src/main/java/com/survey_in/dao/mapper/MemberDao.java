package com.survey_in.dao.mapper;

import com.survey_in.entity.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MemberDao {
    @Select("select * from MEMBER")
    List<Member> getList();
    Member get(int i);

    @Insert("INSERT INTO MEMBER (USERNAME, PWD, NAME, GENDER, AGE, BIRTHDAY, EMAIL, JOB) " +
            "VALUES(#{username}, #{pwd}, #{name}, #{gender}, #{age}, #{birthday}, #{email}, #{job})")
    void insert(Member member);
}
