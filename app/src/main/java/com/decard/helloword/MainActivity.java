package com.decard.helloword;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import javax.security.auth.callback.Callback;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("Tag","这是第一次修改后添加的日志信息");
        new Thread(() -> new Response().handle("this is a messsage", data -> System.out.println("回调方法接收的数据："+data))).start();
        System.out.println("异步回调,先做其他事");
    }
}
class Response{
    public void handle(String msg, CallBack callback){
        System.out.println("接收到的信息："+msg);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        callback.onResponse("请求完成，响应成功！");
    }
}
interface CallBack{
    void onResponse(String data);
}
