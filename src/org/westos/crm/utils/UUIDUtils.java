package org.westos.crm.utils;

import org.apache.taglibs.standard.tag.common.sql.DataSourceUtil;

import java.util.UUID;

public class UUIDUtils {
    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String string= uuid.toString().replace("-", "");
        //System.out.println(replace.length());
        return string;
    }
}
