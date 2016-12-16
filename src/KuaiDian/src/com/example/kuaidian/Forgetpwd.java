package com.example.kuaidian;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Forgetpwd extends Activity implements OnClickListener{
	public static final String TAG = MainActivity.class.getName();
	private ImageView IdCode;  
    private EditText idCode,accout;
    private Button btn1,btn2;
    private String realCode;  
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.forgetpwd);  
  
        idCode = (EditText) findViewById(R.id.yanzheng);  
        btn2= (Button) findViewById(R.id.button2); 
        btn1= (Button) findViewById(R.id.button1);  
        btn1.setOnClickListener(this);  
        IdCode = (ImageView) findViewById(R.id.showCode);  
        //将验证码用图片的形式显示出来  
        IdCode.setImageBitmap(Identifying_code.getInstance().createBitmap());  
        realCode = Identifying_code.getInstance().getCode().toLowerCase();  
        IdCode.setOnClickListener(this);  
    }  
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {  
        case R.id.showCode:  
        	IdCode.setImageBitmap(Identifying_code.getInstance().createBitmap());  
            realCode = Identifying_code.getInstance().getCode().toLowerCase();  
            Log.v(TAG,"realCode"+realCode);  
            break;  
        case R.id.button1:  
            String phoneCode = idCode.getText().toString().toLowerCase();  
            String msg = "生成的验证码："+realCode+"输入的验证码:"+phoneCode;  
            Toast.makeText(Forgetpwd.this,msg,Toast.LENGTH_LONG).show();  

            if (phoneCode.equals(realCode)) {  
                Intent intent =new Intent(Forgetpwd.this,Newcode.class);
                startActivity(intent);
                Toast.makeText(Forgetpwd.this, phoneCode + "验证码正确", Toast.LENGTH_SHORT).show();  
                
            } else {  
                Toast.makeText(Forgetpwd.this, phoneCode + "验证码错误", Toast.LENGTH_SHORT).show();  
            }  
            break;  
         
    }  
}  

}
