package testskipapp.monkey.com;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;

/**
 * 参考资料:
 * https://mp.weixin.qq.com/s?__biz=MzA5MzI3NjE2MA==&mid=2650239904&idx=1&sn=d3375d4d2388e1777b730c610bbb68eb&chksm=886382cfbf140bd9b4e1f3c0e9acd1a71bc9bedc48e8165f64f9f3f8afbb80c276a97a8f7531&mpshare=1&scene=23&srcid=0608ZGYXBJRaV0JfPPo2fmX4#rd
 * Author: lanjing
 * Time: 2017/6/8 17:46
 */

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dealWithSkip();
    }

    //处理跳转的逻辑
    private void dealWithSkip() {
        try{
            Intent intent = getIntent();
            if(intent!=null){
                String action = intent.getAction();
                Uri data = intent.getData();
                if(!TextUtils.isEmpty(action)&&action.equals("android.intent.action.VIEW")){
                    String page = data.getQueryParameter("page");
                    int size = AppApplication.getInstance().getActivitySize();
                    if(size>1){
                        //如果打开过app  则此次直接打开需要打开的页面即可
                        Intent intent2 = new Intent(SplashActivity.this,Class.forName(page));
                        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent2);
                        finish();
                    }else{
                        //以前没有打开过页面  则先打开主页面 然后再打开此次需要打开的页面
                        //避免按返回键的时候直接退出应用体验不好
                        Intent intent1 = new Intent(SplashActivity.this,FirstActivity.class);
                        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent1.putExtra("page",page);
                        startActivity(intent1);
                        finish();
                    }
                }else{
                    //不是从浏览器打开的 正常启动
                    startFristActivity();
                }
            }else{
                //不是从浏览器打开的 正常启动
                startFristActivity();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void startFristActivity(){
        Intent intent1 = new Intent(SplashActivity.this,FirstActivity.class);
        startActivity(intent1);
        finish();
    }
}
