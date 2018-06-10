package pers.cabin.common.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pers.cabin.common.domain.SysLogDO;
import pers.cabin.common.domain.PageDO;
import pers.cabin.common.utils.Query;
@Service
public interface LogService {
	PageDO<SysLogDO> queryList(Query query);
	int remove(Long id);
	int batchRemove(List<Long> ids);
}
