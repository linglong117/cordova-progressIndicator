package org.apache.cordova.plugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.ProgressDialog;
import android.util.Log;

public class ProgressIndicator extends CordovaPlugin {

    private ProgressDialog progressIndicator = null;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("show")) {
            String text = args.getString(0);
            String title = args.getString(2);
            //int pro = args.getInt(3); //bar 
            String pro = args.getString(3);//圆形            
            show(title,pro);
            callbackContext.success();
            return true;
        } else if (action.equals("hide")) {
            hide();
            callbackContext.success();
            return true;
        }

        return false;
    }

    /**
     * This show the ProgressDialog
     *
     * @param text - Message to display in the Progress Dialog
     */
    public void show(String text,String pro) {
        
        Log.i("ProgressIndicator-show->",text);

        if(progressIndicator!=null)
        {
            Log.i("progressIndicator-show->","having");
        }else {
            progressIndicator = new ProgressDialog(this.cordova.getActivity());
            
            
            /*
            // 设置进度条风格，风格为长形
            progressIndicator.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            
            // 设置ProgressDialog 标题
            progressIndicator.setTitle("Uploading..");
            
            // 设置ProgressDialog 提示信息
            //progressIndicator.setMessage("这是一个长形对话框进度条");
            // 设置ProgressDialog 标题图标
            //progressIndicator.setIcon(R.drawable.img2);
            // 设置ProgressDialog 进度条进度
            progressIndicator.setProgress(100);
            // 设置ProgressDialog 的进度条是否不明确
            progressIndicator.setIndeterminate(false);
            // 设置ProgressDialog 是否可以按退回按键取消
            progressIndicator.setCancelable(true);
            */
            
            // 设置进度条风格，风格为圆形，旋转的
            progressIndicator.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            // 设置ProgressDialog 标题
            //progressIndicator.setTitle(text);
            // 设置ProgressDialog 提示信息
            //progressIndicator.setMessage("这是一个圆形进度条对话框");
            // 设置ProgressDialog 标题图标
            //progressIndicator.setIcon(R.drawable.img1);
            // 设置ProgressDialog 的进度条是否不明确
            progressIndicator.setIndeterminate(false);
            // 设置ProgressDialog 是否可以按退回按键取消
            progressIndicator.setCancelable(true);
            
        }
        // 由线程来控制进度。
        // 让ProgressDialog显示
        progressIndicator.show();
        progressIndicator.setMessage(pro);

        //progressIndicator.setProgress(pro);
        
    }

    /**
     * This hide the ProgressDialog
     */
    public void hide() {
        if (progressIndicator != null) {
            progressIndicator.dismiss();
            progressIndicator = null;
        }
    }
}
