package org.Ike.Core.sys.dict.domain;

import org.Ike.Api.sys.domain.DictionaryDomain;
import org.Ike.Api.sys.model.DictionaryDto;
import org.Ike.Api.sys.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <pre>
 * Author: taixiaomin
 * Created at : 2018/3/14
 * Version    : 1.0
 * </pre>
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class DictionaryDomainImpl implements DictionaryDomain {

    @Autowired
    private DictionaryService dictionaryService;

    public List<DictionaryDto> getDictByParentCode(String parentCode) {
        return dictionaryService.getDictByParentCode(parentCode);
    }


}
