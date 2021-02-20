package com.qs.insurance.upms.repository;

import com.qs.insurance.upms.entity.SysDict;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface SysDictRepository extends ElasticsearchRepository<SysDict,Long> {

}
