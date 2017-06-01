package com.dqs.kotlinnote.note;

/**
 * 作者：Denqs on 2017/6/1.
 *  测试运行时注解
 */
@ClassInfo("Test Class")
public class TestRuntimeAnnotation {
    @FieldInfo(value = {1, 2})
    public String fieldInfo = "FieldInfo";

    @FieldInfo(10086)
    public int i = 100;

    @MethodInfo(name = "BlueBird", data = "Big")
    public static String getMethodInfo() {
        return TestRuntimeAnnotation.class.getSimpleName();
    }
}
