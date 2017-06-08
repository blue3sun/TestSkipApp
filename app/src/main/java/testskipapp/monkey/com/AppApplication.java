package testskipapp.monkey.com;

import android.app.Activity;
import android.app.Application;

import java.util.ArrayList;

/**
 * Description:
 * Author: lanjing
 * Time: 2017/6/8 17:49
 */

public class AppApplication extends Application {
    private ArrayList<Activity> activities;
    private static AppApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        activities = new ArrayList<>();
    }
    public static AppApplication getInstance(){
        return instance;
    }

    public void addActivity(Activity activity){
        activities.add(activity);
    }

    public void deleteActivity(Activity activity){
        activities.remove(activity);
    }

    public int getActivitySize(){
        return activities.size();
    }


}
