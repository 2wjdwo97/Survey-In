package com.survey_in.dao.mapper;

import com.survey_in.entity.Option;

import java.util.List;

public interface OptionDao {
    void insertOption(Option option);
    public List<Option> selectOptions(int question_id);
}
