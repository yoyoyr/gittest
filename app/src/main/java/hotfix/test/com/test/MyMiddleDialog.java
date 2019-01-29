package hotfix.test.com.test;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class MyMiddleDialog extends Dialog {

    private TextView tip, yes, no;
    private String title;
    private DialogInterface.OnClickListener yesClick, noClick;

    public MyMiddleDialog(Context context, String title) {
        super(context);
        this.title = title;
    }

    public MyMiddleDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.my_dialog, null);
        this.setContentView(layout);

        yes = layout.findViewById(R.id.yes);
        if (yesClick != null) {
            yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    yesClick.onClick(MyMiddleDialog.this, 0);
                }
            });
        }
        no = layout.findViewById(R.id.no);
        if (noClick != null) {
            no.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    noClick.onClick(MyMiddleDialog.this, 1);
                }
            });
        }
        tip = layout.findViewById(R.id.tip);
        if (title != null) {
            tip.setText(title);
        }

        getWindow().setBackgroundDrawableResource(android.R.color.transparent);

    }

    public MyMiddleDialog setTip(String data) {
        if (data != null) {
            tip.setText(data);
        }
        return this;
    }

    public MyMiddleDialog setYesListener(final DialogInterface.OnClickListener listener) {
        yesClick = listener;

        return this;
    }

    public MyMiddleDialog setNoListener(final DialogInterface.OnClickListener listener) {
        noClick = listener;
        return this;
    }
}