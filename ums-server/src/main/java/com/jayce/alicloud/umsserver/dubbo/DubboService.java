package com.jayce.alicloud.umsserver.dubbo;

import com.jayce.alicloud.umsserver.common.base.BaseServiceInterFace;
import com.jayce.alicloud.umsserver.dao.LibraryBookMapper;
import com.jayce.alicloud.umsserver.entity.LibraryBook;

import java.util.List;

public interface DubboService extends BaseServiceInterFace<LibraryBookMapper, LibraryBook> {
    List<LibraryBook> umsDubbo();

    String umsDubboConfig();
}
