package testskipapp.monkey.com;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

/**
 * Description:
 * Author: lanjing
 * Time: 2017/6/8 17:46
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        dealWithSkip();
    }

    //处理跳转的逻辑
    private void dealWithSkip() {
        Intent intent = getIntent();
        if(intent!=null){
            String action = intent.getAction();
            Uri data = intent.getData();
            if(!TextUtils.isEmpty(action)&&action.equals("android.intent.action.monkey")){
                String page = data.getQueryParameter("page");
                int size = AppApplication.getInstance().getActivitySize();


            }
        }else{
            Intent intent1 = new Intent(SplashActivity.this,FirstActivity.class);
            startActivity(intent1);
        }
    }
}
