package org.Ike.Core.sys.mapper;

import org.Ike.Api.sys.model.Dictionary;

public interface DictionaryMapper {
    int insert(Dictionary record);

    int insertSelective(Dictionary record);

    Dictionary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dictionary record);

    int updateByPrimaryKey(Dictionary record);
}