package com.javaСourse.hibernate.oneToMany_xml.dao;

public interface DAO<Entity, Key> {
	void create(Entity entity);
	Entity read(Key key);
	void update(Entity entity);
	void delete(Entity entity);
}
