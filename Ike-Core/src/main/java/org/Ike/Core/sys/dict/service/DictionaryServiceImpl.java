package org.Ike.Core.sys.dict.service;

import org.Ike.Api.sys.model.Dictionary;
import org.Ike.Api.sys.model.DictionaryDto;
import org.Ike.Api.sys.service.DictionaryService;
import org.Ike.Core.sys.dict.mapper.DictionaryMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Author: taixiaomin
 * Created at : 2018/3/14
 * Version    : 1.0
 * </pre>
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    private DictionaryMapper dictionaryMapper;

    public List<DictionaryDto> getDictByParentCode(String parentCode) {
        List<Dictionary> list = dictionaryMapper.selectByParentCode(parentCode);
        List<DictionaryDto> results = new ArrayList<DictionaryDto>();
        for (Dictionary dict : list) {
            DictionaryDto dto = new DictionaryDto();
            BeanUtils.copyProperties(dict, dto);
            results.add(dto);
        }
        return results;
    }
}
