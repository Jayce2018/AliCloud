package com.jayce.alicloud.umsserver.dao;

import com.jayce.alicloud.umsserver.entity.LibraryBook;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface LibraryBookMapper extends Mapper<LibraryBook> {

    @Results(id = "ResultMap", value = {
            @Result(column="book_id", property="bookId"),
            @Result(column="book_name", property="bookName"),
            @Result(column="type", property="type"),
            @Result(column="status", property="status"),
            @Result(column="create_time", property="createTime"),
            @Result(column="update_time", property="updateTime"),
    })
    @Select("select * from  library_book")
    List<LibraryBook> selectTest();
}