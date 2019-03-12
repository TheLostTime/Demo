package com.example.demo.Mapper;

import com.example.demo.Entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    @Insert("insert into user values(NULL,#{name})")
    public void insertUser(@Param("name") String name);

    @Delete("delete from user where id=#{id}")
    public void deleteUser(@Param("id") Integer id);

    @Update("update user set name=#{name} where id=#{id}")
    public void updateUser(@Param("name") String name ,@Param("id") Integer id);

    @Select("select * from user where id=${id}")
    public User queryUser(@Param("id") Integer id);
}
