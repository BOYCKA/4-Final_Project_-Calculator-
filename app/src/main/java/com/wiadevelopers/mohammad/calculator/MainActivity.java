package com.wiadevelopers.mohammad.calculator;

import android.app.Activity;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity
{
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    Button btnPlus,btnSub,btnMul,btnDiv,btnAC,btnC,btnSign,btnEqual;

    TextView txtResult;
    Animation zoomIn;

    float num1,num2;
    String OP="";
    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        initialize();
    }



    public void Button_Click(View v)
    {
        int id = v.getId();
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.button_select);
        mp.start();

        if (id == R.id.btn0)
        {
            String tmp = txtResult.getText().toString().trim();
            if (!tmp.equalsIgnoreCase("0.0"))
            {
                txtResult.startAnimation(zoomIn);
                txtResult.append("0");
                //txtResult.setText(tmp + "0");
            }
        }
        else if (id == R.id.btn1)
            setNum(1);
        else if (id == R.id.btn2)
            setNum(2);
        else if (id == R.id.btn3)
            setNum(3);
        else if (id == R.id.btn4)
            setNum(4);
        else if (id == R.id.btn5)
            setNum(5);
        else if (id == R.id.btn6)
            setNum(6);
        else if (id == R.id.btn7)
            setNum(7);
        else if (id == R.id.btn8)
            setNum(8);
        else if (id == R.id.btn9)
            setNum(9);
        else if (id == R.id.btnPlus)
        {
            num1 = Float.parseFloat(txtResult.getText().toString());
            OP = "+";
        }
        else if (id == R.id.btnSub)
        {
            num1 = Float.parseFloat(txtResult.getText().toString());
            OP = "-";
        }
        else if (id == R.id.btnMul)
        {
            num1 = Float.parseFloat(txtResult.getText().toString());
            OP = "x";
        }
        else if (id == R.id.btnDiv)
        {
            num1 = Float.parseFloat(txtResult.getText().toString());
            OP = "/";
        }
        else if (id == R.id.btnEqual)
        {
            num2 = Float.parseFloat(txtResult.getText().toString());
            float result = 0;
            if (OP == "+")
                result = num1 + num2;
            else if (OP == "-")
                result = num1 - num2;
            else if (OP == "x")
                result = num1 * num2;
            else if (OP == "/")
                result = num1 / num2;

            txtResult.setText(result+"");
            num1 = num2 = 0;
            OP = "";
        }
        else if (id == R.id.btnAC || id == R.id.btnC)
        {
            num1 = num2 = 0;
            OP = "";
            txtResult.setText("0.0");
            flag = false;
        }
        else if (id == R.id.btnSign)
        {
            float NUM = Float.parseFloat(txtResult.getText().toString());
            if (NUM != 0)
                txtResult.setText((NUM* -1)+"");
        }



    }

    void setNum(int num)
    {
        String tmp = txtResult.getText().toString();
        txtResult.startAnimation(zoomIn);
        if (OP == "")
        {
            if (tmp.equalsIgnoreCase("0.0"))
                txtResult.setText(num + "");
            else
                txtResult.setText(tmp + num + "");
        }
        else
        {
            if (flag == false)
            {
                txtResult.setText(num + "");
                flag = true;
            }
            else
                txtResult.setText(tmp + num);
        }
    }

    void initialize()
    {

        txtResult.setText("0.0");
        zoomIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
        setTextFont();
        setTextSize();
    }

    void setTextFont()
    {
        Typeface custom_font = Typeface.createFromAsset(getAssets(),"fonts/helvetika.ttf");
        btn0.setTypeface(custom_font);
        btn1.setTypeface(custom_font);
        btn2.setTypeface(custom_font);
        btn3.setTypeface(custom_font);
        btn4.setTypeface(custom_font);
        btn5.setTypeface(custom_font);
        btn6.setTypeface(custom_font);
        btn7.setTypeface(custom_font);
        btn8.setTypeface(custom_font);
        btn9.setTypeface(custom_font);
        btnAC.setTypeface(custom_font);
        btnC.setTypeface(custom_font);
        btnSign.setTypeface(custom_font);
        btnDiv.setTypeface(custom_font);
        btnMul.setTypeface(custom_font);
        btnSub.setTypeface(custom_font);
        btnPlus.setTypeface(custom_font);
        btnEqual.setTypeface(custom_font);

        txtResult.setTypeface(custom_font);
    }

    void setTextSize()
    {
        int SIZE = 25;
        btn0.setTextSize(SIZE);
        btn1.setTextSize(SIZE);
        btn2.setTextSize(SIZE);
        btn3.setTextSize(SIZE);
        btn4.setTextSize(SIZE);
        btn5.setTextSize(SIZE);
        btn6.setTextSize(SIZE);
        btn7.setTextSize(SIZE);
        btn8.setTextSize(SIZE);
        btn9.setTextSize(SIZE);

        btnAC.setTextSize(SIZE);
        btnSign.setTextSize(SIZE);
        btnC.setTextSize(SIZE);
        btnEqual.setTextSize(SIZE);
        btnDiv.setTextSize(SIZE);
        btnPlus.setTextSize(SIZE);
        btnSub.setTextSize(SIZE*2);
        btnMul.setTextSize(SIZE);

        txtResult.setTextSize((float) (SIZE*2.5));
    }

    void findViews()
    {
        btn0 = (Button)findViewById(R.id.btn0);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        btn7 = (Button)findViewById(R.id.btn7);
        btn8 = (Button)findViewById(R.id.btn8);
        btn9 = (Button)findViewById(R.id.btn9);

        btnPlus = (Button)findViewById(R.id.btnPlus);
        btnSub 	= (Button)findViewById(R.id.btnSub);
        btnMul 	= (Button)findViewById(R.id.btnMul);
        btnDiv 	= (Button)findViewById(R.id.btnDiv);

        btnEqual = (Button)findViewById(R.id.btnEqual);
        btnC 	 = (Button)findViewById(R.id.btnC);
        btnAC 	 = (Button)findViewById(R.id.btnAC);
        btnSign 	 = (Button)findViewById(R.id.btnSign);

        txtResult = (TextView)findViewById(R.id.txtResult);
    }
}
