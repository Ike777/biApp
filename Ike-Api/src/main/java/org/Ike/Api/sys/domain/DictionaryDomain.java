package org.Ike.Api.sys.domain;

import org.Ike.Api.sys.model.DictionaryDto;

import java.util.List;

/**
 * <pre>
 * Author: taixiaomin
 * Created at : 2018/3/14
 * Version    : 1.0
 * </pre>
 */
public interface DictionaryDomain {

    List<DictionaryDto> getDictByParentCode(String parentCode);
}
