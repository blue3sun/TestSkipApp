package testskipapp.monkey.com;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

public class FirstActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);
        initView();
        openPage();
    }

    private void openPage() {
        try{
            Intent intent = getIntent();
            if(intent!=null){
                String page = intent.getStringExtra("page");
                if(!TextUtils.isEmpty(page)){
                    Intent intent2 = new Intent(FirstActivity.this,Class.forName(page));
                    //以标准方式打开，不需要添加flag
                    //intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent2);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void initView() {
        TextView tvTitle = (TextView)findViewById(R.id.tv_title);
        tvTitle.setText("FirstActivity");
        findViewById(R.id.btn_skip).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
