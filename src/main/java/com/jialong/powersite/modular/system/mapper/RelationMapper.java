package com.jialong.powersite.modular.system.mapper;

import com.jialong.powersite.modular.system.model.Relation;
import org.springframework.stereotype.Repository;

@Repository
public interface RelationMapper {

    void insertRelation(Relation relation);
}
