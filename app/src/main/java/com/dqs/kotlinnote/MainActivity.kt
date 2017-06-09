package com.dqs.kotlinnote

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.dqs.kotlinnote.login.LoginRegistrationActivity
import com.dqs.kotlinnote.note.*
import kotterknife.bindView
import java.lang.reflect.Modifier
import java.util.*


class MainActivity : AppCompatActivity() {
    val firstName: TextView by bindView(R.id.first_name)
    val note: Button by bindView(R.id.button03)
    val note04: Button by bindView(R.id.button04)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val next = findViewById(R.id.Button02) as Button
        next.setOnClickListener {
            Toast.makeText(this, "测试", Toast.LENGTH_SHORT).show()
            firstName.text = sum(4, 5)
        }

        note.setOnClickListener {
            firstName.text = _TestNote()
        }
        var mIsOpen: Boolean = true
        note04.setOnClickListener {
            if (mIsOpen) {
//            TestSourceAnnotation.setStatus(1); 直接设置数值编译器会直接提示错误
                TestSourceAnnotation.setStatus(TestSourceAnnotation.STATUS_CLOSE)
                mIsOpen = false
            } else {
                TestSourceAnnotation.setStatus(TestSourceAnnotation.STATUS_OPEN)
                mIsOpen = true
            }

            firstName.text = TestSourceAnnotation.getStatusDesc()
        }
        firstName.setText(R.string.app_wod)
    }

    fun sum(a: Int, b: Int): String {
        return (a + b).toString()
    }

    /**getMethod：获取类中的public方法
    getDeclaredMethod：获取类中的所有方法
    getField：获取类中的public字段（属性）
    getDeclaredField：获取类中的所有字段
     */
    fun _TestNote(): String {

        val sb = StringBuffer()
        val cls = TestRuntimeAnnotation::class.java
        sb.append("Class注解：").append("\n")
        val classInfo = cls.getAnnotation(ClassInfo::class.java)
        if (classInfo != null) {
            sb.append(Modifier.toString(cls.modifiers)).append(" ").append(cls.simpleName).append("\n")
            sb.append("注解值: ").append(classInfo.value).append("\n\n")
        }
        sb.append("Field注解：").append("\n")
        val fields = cls.declaredFields
        for (field in fields) {
            val fieldInfo = field.getAnnotation(FieldInfo::class.java)
            if (fieldInfo != null) {
                sb.append(Modifier.toString(field.modifiers)).append(" ")
                        .append(field.type.simpleName).append(" ")
                        .append(field.name).append("\n")
                sb.append("注解值: ").append(Arrays.toString(fieldInfo.value)).append("\n\n")
            }
        }
        sb.append("Method注解：").append("\n")
        val methods = cls.declaredMethods
        for (method in methods) {
            val methodInfo = method.getAnnotation(MethodInfo::class.java)
            if (methodInfo != null) {
                sb.append(Modifier.toString(method.modifiers)).append(" ")
                        .append(method.returnType.simpleName).append(" ")
                        .append(method.name).append("\n")
                sb.append("注解值: ").append("\n")
                sb.append("name: ").append(methodInfo.name).append("\n")
                sb.append("data: ").append(methodInfo.data).append("\n")
                sb.append("age: ").append(methodInfo.age).append("\n")
            }
        }
        return sb.toString()
    }
}
