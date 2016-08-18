package com.starter.dao;

import com.starter.entities.PostEntity;

public interface PostDAO extends BaseDAO<PostEntity> {

	PostEntity selectByAlias(String alias);

}
