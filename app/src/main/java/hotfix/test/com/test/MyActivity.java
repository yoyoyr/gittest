package hotfix.test.com.test;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

/**
 * hellochart饼状图的使用
 */
public class MyActivity extends Activity {
//    private ProgressBar progressBar;
//    private int i = 0;
//    private Handler handler = new Handler();

//    private Runnable runnable = new Runnable() {
//        @Override
//        public void run() {
//            i++;
//            if (i == 100) {
//                handler.removeCallbacks(this);
//            }
//            progressBar.setProgress(i);
//            handler.postDelayed(this, 100);
//        }
//    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        findViewById(R.id.update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoggerUtils.LOGD("检测到新版本，是否更新？");
                simpleDialog("检测到新版本，是否更新？");

            }
        });

        try {
            Print.say();
            Print.hello();
            Print.talk();
            Print.error();
        } catch (Exception e) {
            LoggerUtils.LOGE(e);
        }
    }


    public void simpleDialog(String title) {

        new MyMiddleDialog(this, title)
                .setYesListener(new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        LoggerUtils.LOGD("dialog.dismiss()");
                        progressDialog("交易数据", "正在更新...");
                    }
                })
                .setNoListener(new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }

    /**
     * 进度条对话框
     *
     * @param title
     * @param msg
     */
    public void progressDialog(String title, String msg) {
        LoggerUtils.LOGD("progressDialog");
        final MyprogressDialog dialog = new MyprogressDialog(100, MyActivity.this);
        dialog.show();
        //启动线程，模拟一个耗时的操作
        new Thread(new Runnable() {
            @Override
            public void run() {
                int Progress = 0;
                while (Progress < 100) {
                    try {
                        Thread.sleep(100);
                        Progress++;
                        dialog.setValue(Progress);// 进度条一次加10
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                dialog.dismiss();// 完成后消失
            }
        }).start();
    }


//    /**
//     * 简单饼状图
//     *
//     * @param view
//     */
//    public void simplePie(View view) {
//        startActivity(new Intent(this, SimplePieActivity.class).putExtra("title", "简单饼状图"));
//    }
//
//    /**
//     * 炸开的饼状图
//     *
//     * @param view
//     */
//    public void explodedPie(View view) {
//        startActivity(new Intent(this, ExplodedPieActivity.class).putExtra("title", "炸开的饼状图"));
//    }
//
//    /**
//     * 有中心圆的饼状图
//     *
//     * @param view
//     */
//    public void centerCirclePie(View view) {
//        startActivity(new Intent(this, CenterCirclePieActivity.class).putExtra("title", "有中心圆饼状图"));
//    }


}
