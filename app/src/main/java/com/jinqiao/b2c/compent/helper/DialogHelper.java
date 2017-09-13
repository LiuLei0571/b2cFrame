package com.jinqiao.b2c.compent.helper;

import android.app.Dialog;
import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jinqiao.b2c.R;

/**
 * @author Created by liulei on 16-11-12.
 */
public class DialogHelper {

    public static boolean isShowing = false;

    public static class Btn {

        public Btn(int btn, View.OnClickListener clickListener) {
            this.btn = btn;
            this.clickListener = clickListener;
        }
        public Btn(String btn, View.OnClickListener clickListener) {
            this.btnString = btn;
            this.clickListener = clickListener;
        }
        int btn;
        String btnString;
        View.OnClickListener clickListener;
    }


    public static class BtnTv {

        public BtnTv(String btn, View.OnClickListener clickListener) {
            this.btn = btn;
            this.clickListener = clickListener;
        }

        String btn;
        View.OnClickListener clickListener;
    }

    public static Dialog showDialog(Context context, String title, String content, int gravity, Btn... btns) {
        if (context == null) return null;

        final Dialog dialog = new Dialog(context, R.style.Dialog);
        dialog.setCancelable(false);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_common, null);

        TextView titleView = (TextView) view.findViewById(R.id.dialog_title);
        TextView contentView = (TextView) view.findViewById(R.id.dialog_content);

        if (!TextUtils.isEmpty(title)) {
            titleView.setText(title);
        } else {
            titleView.setVisibility(View.GONE);
        }
        contentView.setText(Html.fromHtml(content));
        contentView.setGravity(gravity);

        Button leftButton = (Button) view.findViewById(R.id.dialog_btn_left);
        Button rightButton = (Button) view.findViewById(R.id.dialog_btn_right);
        View leftLine = view.findViewById(R.id.dialog_line_left);
        View rightLine = view.findViewById(R.id.dialog_line_right);
        Button button = (Button) view.findViewById(R.id.dialog_btn);
        LinearLayout buttons = (LinearLayout) view.findViewById(R.id.dialog_btns);

        if (btns != null) {
            int length = btns.length;

            if (length == 1) {
                final Btn btn1 = btns[0];
                buttons.removeView(rightButton);
                buttons.removeView(leftButton);
                leftLine.setVisibility(View.GONE);
                rightLine.setVisibility(View.GONE);
                button.setText(btn1.btn);
                button.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        closeDialog(dialog);
                        if (btn1.clickListener != null) {
                            btn1.clickListener.onClick(v);
                        }
                    }
                });
            } else if (length == 2) {
                buttons.removeView(button);
                final Btn btn1 = btns[0];
                final Btn btn2 = btns[1];
                leftButton.setText(btn1.btn);
                leftButton.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        closeDialog(dialog);
                        if (btn1.clickListener != null) {
                            btn1.clickListener.onClick(v);
                        }
                    }
                });

                leftLine.setVisibility(View.VISIBLE);
                rightLine.setVisibility(View.GONE);

                rightButton.setText(btn2.btn);
                rightButton.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        closeDialog(dialog);
                        if (btn2.clickListener != null) {
                            btn2.clickListener.onClick(v);
                        }
                    }
                });

            } else {
                buttons.removeAllViews();
            }

        }

        dialog.setContentView(view);
        dialog.show();
        isShowing = true;
        return dialog;
    }

    public static Dialog showDialog(Context context, String title, String content, int gravity, BtnTv... btns) {
        if (context == null) return null;

        final Dialog dialog = new Dialog(context, R.style.Dialog);
        dialog.setCanceledOnTouchOutside(true);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_common, null);

        TextView titleView = (TextView) view.findViewById(R.id.dialog_title);
        TextView contentView = (TextView) view.findViewById(R.id.dialog_content);

        if (!TextUtils.isEmpty(title)) {
            titleView.setText(title);
        } else {
            titleView.setVisibility(View.GONE);
        }
        contentView.setText(Html.fromHtml(content));
        contentView.setGravity(gravity);

        Button leftButton = (Button) view.findViewById(R.id.dialog_btn_left);
        Button rightButton = (Button) view.findViewById(R.id.dialog_btn_right);
        View leftLine = view.findViewById(R.id.dialog_line_left);
        View rightLine = view.findViewById(R.id.dialog_line_right);
        Button button = (Button) view.findViewById(R.id.dialog_btn);
        LinearLayout buttons = (LinearLayout) view.findViewById(R.id.dialog_btns);

        if (btns != null) {
            int length = btns.length;

            if (length == 1) {
                final BtnTv btn1 = btns[0];
                buttons.removeView(rightButton);
                buttons.removeView(leftButton);
                leftLine.setVisibility(View.GONE);
                rightLine.setVisibility(View.GONE);
                button.setText(btn1.btn);
                button.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        closeDialog(dialog);
                        if (btn1.clickListener != null) {
                            btn1.clickListener.onClick(v);
                        }
                    }
                });
            } else if (length == 2) {
                buttons.removeView(button);
                final BtnTv btn1 = btns[0];
                final BtnTv btn2 = btns[1];
                leftButton.setText(btn1.btn);
                leftButton.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        closeDialog(dialog);
                        if (btn1.clickListener != null) {
                            btn1.clickListener.onClick(v);
                        }
                    }
                });

                leftLine.setVisibility(View.VISIBLE);
                rightLine.setVisibility(View.GONE);

                rightButton.setText(btn2.btn);
                rightButton.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        closeDialog(dialog);
                        if (btn2.clickListener != null) {
                            btn2.clickListener.onClick(v);
                        }
                    }
                });

            } else {
                buttons.removeAllViews();
            }

        }

        dialog.setContentView(view);
        dialog.show();
        return dialog;
    }

    public static Dialog showDialog(Context context, int title, String content, int gravity, Btn... btns) {
        if (context == null) return null;
        final Dialog dialog = new Dialog(context, R.style.Dialog);
        dialog.setCancelable(false);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_common, null);

        TextView titleView = (TextView) view.findViewById(R.id.dialog_title);
        TextView contentView = (TextView) view.findViewById(R.id.dialog_content);

        if (title != 0) {
            try {
                titleView.setText(title);
            } catch (Exception e) {
                titleView.setVisibility(View.GONE);
            }
        } else {
            titleView.setVisibility(View.GONE);
        }
        contentView.setText(content);
        contentView.setGravity(gravity);

        Button leftButton = (Button) view.findViewById(R.id.dialog_btn_left);
        Button rightButton = (Button) view.findViewById(R.id.dialog_btn_right);
        View leftLine = view.findViewById(R.id.dialog_line_left);
        View rightLine = view.findViewById(R.id.dialog_line_right);
        Button button = (Button) view.findViewById(R.id.dialog_btn);
        LinearLayout buttons = (LinearLayout) view.findViewById(R.id.dialog_btns);

        if (btns != null) {
            int length = btns.length;

            if (length == 1) {
                final Btn btn1 = btns[0];
                buttons.removeView(rightButton);
                buttons.removeView(leftButton);
                leftLine.setVisibility(View.GONE);
                rightLine.setVisibility(View.GONE);
                button.setText(btn1.btn);
                button.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        closeDialog(dialog);
                        if (btn1.clickListener != null) {
                            btn1.clickListener.onClick(v);
                        }
                    }
                });
            } else if (length == 2) {
                buttons.removeView(button);
                final Btn btn1 = btns[0];
                final Btn btn2 = btns[1];
                leftButton.setText(btn1.btn);
                leftButton.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        closeDialog(dialog);
                        if (btn1.clickListener != null) {
                            btn1.clickListener.onClick(v);
                        }
                    }
                });

                leftLine.setVisibility(View.VISIBLE);
                rightLine.setVisibility(View.GONE);

                rightButton.setText(btn2.btn);
                rightButton.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        closeDialog(dialog);
                        if (btn2.clickListener != null) {
                            btn2.clickListener.onClick(v);
                        }
                    }
                });

            } else {
                buttons.removeAllViews();
            }

        }

        dialog.setContentView(view);
        dialog.show();
        return dialog;
    }





    public static void closeDialog(Dialog dialog) {
        try {
            if (dialog != null) {
                dialog.dismiss();
            }
        } catch (Exception e) {

        }
    }




    public static abstract class AbstractOnItemClickListener implements AdapterView.OnItemClickListener {
        private Dialog dialog;

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (dialog != null) {
                dialog.dismiss();
            }
            onItemClick(parent, view, position);
        }

        public void setDialog(Dialog dialog) {
            this.dialog = dialog;
        }

        public abstract void onItemClick(AdapterView<?> parent, View view, int position);
    }

}
