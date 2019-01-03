package com.example.util;

import com.example.common.PageList;
import org.springframework.data.domain.Page;

public class ApiBeanUtils {
    private ApiBeanUtils() {
    }

    public static <T> PageList<T> convert2PageList(Page<T> page) {
        PageList<T> pageList = new PageList<>();
        pageList.setPageIndex(page.getNumber() + 1);
        pageList.setPageSize(page.getSize());
        pageList.setTotalPages(page.getTotalPages());
        pageList.setTotalElements(page.getTotalElements());
        pageList.setList(page.getContent());
        return pageList;
    }
}
