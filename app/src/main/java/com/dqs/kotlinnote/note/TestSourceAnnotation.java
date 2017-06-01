package com.dqs.kotlinnote.note;

import android.support.annotation.IntDef;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 作者：Denqs on 2017/6/1.
 * 测试源码注解
 */

public class TestSourceAnnotation {
    // 状态值
    public static final int STATUS_OPEN = 1;
    public static final int STATUS_CLOSE = 2;

    private static int sStatus = STATUS_OPEN;


    private TestSourceAnnotation() {
    }

    @Retention(RetentionPolicy.SOURCE)
    @Target(ElementType.PARAMETER)
    @IntDef({STATUS_OPEN, STATUS_CLOSE})
    public @interface Status {
    }

    public static void setStatus(@Status int status) {
        sStatus = status;
    }

    public static int getStatus() {
        return sStatus;
    }

    public static String getStatusDesc() {
        if (sStatus == STATUS_OPEN) {
            return "打开状态";
        } else {
            return "关闭状态";
        }
    }
}
