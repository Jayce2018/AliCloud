package com.jayce.alicloud.umsserver.dubbo;

import com.jayce.alicloud.umsserver.entity.LibraryBook;

import java.util.List;

public interface DubboService {
    List<LibraryBook> umsDubbo();

    String umsDubboConfig();
}
