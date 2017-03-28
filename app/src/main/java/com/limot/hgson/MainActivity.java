package com.limot.hgson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.limot.mylibrary.ArrayGson;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String res="[\n" +
                "  {\n" +
                "    \"sessionID\": \"54d296cf1b3b41a5418ebd722a351ec8\",\n" +
                "    \"nDevID\": \"31877430\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"sessionID\": \"54d296cf1b3b41a5418ebd722a351ec8\",\n" +
                "    \"nDevID\": \"31877430\"\n" +
                "  }\n" +
                "]";



        //方法一：解析json数据，接收错误时返回null，而不是闪退
        ArrayGson hGson = new ArrayGson();
        TestBean testBean = hGson.fromJson(res, TestBean.class);


        //方法二：把对象变成json，此方法和gson原方法一致：

        ArrayGson hGson01 = new ArrayGson();
        TestBean testBean1 = new TestBean();
        String json = hGson01.toJson(testBean1);



        //方法三：解析纯数组json数据

        List<TestBean> list = hGson.fromJsonList(res, TestBean.class);


    }
}
