package org.Ike.Core.sys.sequence.mapper;

import org.Ike.Api.sys.model.SysSequence;
import org.Ike.Api.sys.model.SysSequenceKey;

public interface SysSequenceMapper {

    int insert(SysSequence record);

    int insertSelective(SysSequence record);

    SysSequence selectByPrimaryKey(SysSequenceKey key);

    int updateByPrimaryKeySelective(SysSequence record);

    int updateByPrimaryKey(SysSequence record);

    SysSequence querySequence(SysSequence model);
}