package hotfix.test.com.test;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MyprogressDialog extends Dialog {

    private ProgressBar progressBar;
    private TextView percent;
    private int max;
    Handler handler = new Handler();
    DecimalFormat decimalFomat = new DecimalFormat(".00");

    public MyprogressDialog(int max, Context context) {
        super(context);
        this.max = max;
    }

    public MyprogressDialog(Context context, int theme) {
        super(context, theme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoggerUtils.LOGD("create");
        View view = getLayoutInflater().inflate(R.layout.progress_dialog, null);

        progressBar = view.findViewById(R.id.progressBar);
        progressBar.setMax(max);
        percent = view.findViewById(R.id.percent);
        setContentView(view);
        LoggerUtils.LOGD("setContentView");
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
    }

    public void setValue(final int value) {
//        System.out.println("value = " + value);
        if (progressBar == null || percent == null) {
            return;
        }
        handler.post(new Runnable() {
            @Override
            public void run() {
                progressBar.setProgress(value);
                percent.setText(decimalFomat.format(((float) value / max) * 100) + "%");
            }
        });
    }
}
