package org.Ike.Api.sys.service;

import org.Ike.Api.sys.model.DictionaryDto;

import java.util.List;

/**
 * <pre>
 * Author: taixiaomin
 * Created at : 2018/3/14
 * Version    : 1.0
 * </pre>
 */
public interface DictionaryService {

    List<DictionaryDto> getDictByParentCode(String parentCode);
}
