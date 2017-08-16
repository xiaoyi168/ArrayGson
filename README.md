# ArrayGson
  Gson工具类

*优化接收数据不对时的闪退问题

*提供解析纯数组json数据的方法
  
  

## 一.首先在项目的gradle中引用：
<pre><code>

    allprojects {
    repositories {
        jcenter()
        maven { url 'https://jitpack.io' }
        }
    }

</code></pre>

## 二.其次在dependencies中添加：
<pre><code>

dependencies {
   compile 'com.github.lmiot:ArrayGson:V1.1'

   }

</code></pre>


## 三.**解析json数据**，接收错误时返回null，而不是闪退
<pre><code>

       ArrayGson hGson = new ArrayGson();
             TestBean testBean = hGson.fromJson(res, TestBean.class);


</code></pre>

## 四.把对象变成json，此方法和gson原方法一致
<pre><code>
        ArrayGson hGson01 = new ArrayGson();
        TestBean testBean1 = new TestBean();
        String json = hGson01.toJson(testBean1);

</code></pre>

# 五：**解析纯数组json数据**

<pre><code>
 ArrayGson hGson = new ArrayGson();
 List<TestBean> list = hGson.fromJsonList(res, TestBean.class);
</code></pre>

## 六.CSDN博客地址：http://blog.csdn.net/alijiahua

