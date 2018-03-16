package org.Ike.Core.sys.dict.mapper;

import org.Ike.Api.sys.model.Dictionary;

import java.util.List;

public interface DictionaryMapper {

    List<Dictionary> selectByParentCode(String var1);
}