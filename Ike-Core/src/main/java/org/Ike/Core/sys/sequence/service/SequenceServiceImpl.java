package org.Ike.Core.sys.sequence.service;

import com.system.exception.BusinessException;
import org.Ike.Api.sys.model.SysSequence;
import org.Ike.Api.sys.service.SequenceService;
import org.Ike.Core.sys.sequence.mapper.SysSequenceMapper;
import org.apache.http.impl.cookie.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * <pre>
 * Author: taixiaomin
 * Created at : 2018/3/14
 * Version    : 1.0
 * </pre>
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class SequenceServiceImpl implements SequenceService {

    private static final Logger logger = LoggerFactory.getLogger(SequenceServiceImpl.class);

    @Autowired
    private SysSequenceMapper sequenceMapper;

    private synchronized String generateSysNo(String tableName) throws BusinessException {
        String orderNo = "";
        try {
            SysSequence model = new SysSequence();
            model.setStartDate(new Date());
            model.setTableName(tableName);
            SysSequence sequence = sequenceMapper.querySequence(model);
            if (sequence == null) {
                model.setNextVal(0);
                model.setIncrement(1);
                model.setUpdateTime(new Date());
                sequenceMapper.insert(model);
                sequence = sequenceMapper.querySequence(model);
            }

            Integer _nextval = sequence.getNextVal() + sequence.getIncrement();
            sequence.setNextVal(_nextval);
            sequence.setUpdateTime(new Date());
            sequenceMapper.updateByPrimaryKeySelective(sequence);
            orderNo += this.padLeft(_nextval.toString(), 3, '0');
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BusinessException("error", "error");
        }
        return orderNo;
    }

    private String padLeft(String str, int length, char ch) {
        if (str.length() >= length) {
            return str;
        }
        int len = length - str.length();
        if (len <= 0) {
            return str;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            builder.append(ch);
        }
        builder.append(str);
        return builder.toString();
    }

    public String generateRegionNo() {
        String tableName = "ike_map_region";
        String prefix = "RC";
        return prefix + generateSysNo(tableName);
    }
}
