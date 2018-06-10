package pers.cabin.mybatis.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;

/**
 * Created by caiping on 2017/3/16.
 */
public class BaseDaoImpl {
    private SqlSessionTemplate sqlSessionTemplate = null;

    public SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
}
