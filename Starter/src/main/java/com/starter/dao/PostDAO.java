package com.starter.dao;

import com.starter.entities.PostEntity;

public interface PostDAO extends BaseCrudDAO<PostEntity> {

	PostEntity selectByAlias(String alias);

}
