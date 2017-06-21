package com.example.a.t11_webview;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    ProgressDialog dlg;

    class MyWebViewClient extends WebViewClient{
         @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon){
             super.onPageStarted(view, url, favicon);
             dlg.show();
         }
         public void onPageFinished(WebView view, String url){
             super.onPageFinished(view, url);
             dlg.dismiss();
         }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://www.naver.com");
        dlg=new ProgressDialog(this);

        WebSettings ws =webView.getSettings();
        ws.setJavaScriptEnabled(true);

        Button btnGo = (Button) findViewById(R.id.btnGo);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.editAddress);
                String address = editText.getText().toString();
                webView.loadUrl(address);
            }
        });
    }
    public void onBackPressed(){
        if(webView.canGoBack()){
            webView.goBack();
        }else{
            super.onBackPressed();
        }
    }
}
