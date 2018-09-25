package shadattonmoy.relativelayoutusingjava;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RelativeLayout main;
    TextView userName,password,msg;
    EditText userNameValue,passwordValue;
    Button loginButton;
    LayoutParams wrapContent,matchParent;
    int msgId =1,userNameId = 2,passwordId = 3,userNameValueId = 4,passwordValueId =5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        createMsgText();
        createUserNameText();
        createUserNameValue();
        main.addView(msg);
        main.addView(userName);
        main.addView(userNameValue);
        setContentView(main);
    }
    public void init()
    {
        main = new RelativeLayout(this);
        userName = new TextView(this);
        password = new TextView(this);
        msg = new TextView(this);
        userNameValue = new EditText(this);
        passwordValue = new EditText(this);
        wrapContent = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        matchParent = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        main.setLayoutParams(matchParent);
        main.setBackgroundColor(Color.WHITE);
    }

    public void createMsgText()
    {
        LayoutParams msgDim = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        msgDim.addRule(RelativeLayout.CENTER_HORIZONTAL);
        msg.setText("Please Login First ");
        msg.setId(msgId);
        msg.setLayoutParams(msgDim);
        msg.setTextColor(Color.BLACK);
    }
    public void createUserNameText()
    {
        LayoutParams userNameDim = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        userNameDim.addRule(RelativeLayout.BELOW,msgId);
        userName.setLayoutParams(userNameDim);
        userName.setText("User Name : ");
        userName.setTextColor(Color.BLACK);
        userName.setPadding(10,10,10,10);
        userName.setId(userNameId);
    }
    public void createUserNameValue()
    {
        LayoutParams userNameValueDim = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        userNameValueDim.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        userNameValueDim.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        userNameValueDim.addRule(RelativeLayout.RIGHT_OF,userNameId);
        userNameValueDim.addRule(RelativeLayout.BELOW,msgId);
        userNameValue.setLayoutParams(userNameValueDim);
        userNameValue.setTextColor(Color.BLACK);
        userNameValue.setPadding(5,5,5,5);
    }
}
