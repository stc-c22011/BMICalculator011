package jp.suntech.c22011.example.bmicalculator011;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //ボタンの用意
        Button bt_keisan = findViewById(R.id.bt_keisan);
        //名前クリアボタンであるボタンオブジェクトを表示
        Button bt_clear = findViewById(R.id.bt_clear);

        //リスナオブジェクトの用意
        HelloListener listener = new HelloListener();

        //表示ボタンにリスナを設定
        bt_keisan.setOnClickListener(listener);
        //名前クリアボタンにリスナを設定
        bt_clear.setOnClickListener(listener);

    }

    //ボタンをクリックしたときのリスナクラス
    private class HelloListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            //年齢入力欄であるEditTextオブジェクトを取得
            EditText inputA = findViewById(R.id.et_age);
            //身長入力欄であるEditTextオブジェクトを取得
            EditText inputH = findViewById(R.id.et_height);
            //体重入力欄であるEditTextオブジェクトを取得
            EditText inputW = findViewById(R.id.et_weight);

            //メッセージを表示するTextViewオブジェクトを取得
            TextView output1 = findViewById(R.id.tv_himando_ot);
            TextView output2 = findViewById(R.id.tv_tekisei_ot);
            TextView output3 = findViewById(R.id.tv_taijyu_ot);
            TextView output4 = findViewById(R.id.tv_weight_ot);

            //タップされた画面部品のidのＲ値を取得
            int id = v.getId();

            //計算ボタンの時
            if (id == R.id.bt_keisan) {
                //入力された年齢、身長、体重の文字列を取得する(float型)

                Float inputfltA = Float.parseFloat(inputA.getText().toString());
                Float inputfltH = Float.parseFloat(inputH.getText().toString());
                Float inputfltW = Float.parseFloat(inputW.getText().toString());
                float BMI = inputfltW / ((inputfltH / 100) * (inputfltH / 100));
                float tekisei = (22 * (inputfltH / 100) * (inputfltH / 100));


                output1.setText("あなたの肥満度は");

                //BMで求める
                if (inputfltA >= 16) {

                    if (BMI < 18.5) {
                        output2.setText("低体重");
                        output2.setTextColor(getResources().getColor(R.color.colorLowWeight));

                    } else if (BMI > 18.5 && BMI < 25) {
                        output2.setText("普通体重");
                        output2.setTextColor(getResources().getColor(R.color.colorNormalWeight));

                    } else if (BMI > 25 && BMI < 30) {
                        output2.setText("肥満(1度)");
                        output2.setTextColor(getResources().getColor(R.color.colorObesity1));

                    } else if (BMI > 30 && BMI < 35) {
                        output2.setText("肥満(2度)");
                        output2.setTextColor(getResources().getColor(R.color.colorObesity2));

                    } else if (BMI > 35 && BMI < 40) {
                        output2.setText("肥満(3度)");
                        output2.setTextColor(getResources().getColor(R.color.colorObesity3));

                    } else if (BMI > 40) {
                        output2.setText("肥満(4度)");
                        output2.setTextColor(getResources().getColor(R.color.colorObesity4));
                    }

                    output3.setText("あなたの適正体重は");
                    output4.setText(String.format("%.1f",tekisei) + "Kg");
                }

                //ローレル指数で求める
                if (inputfltA < 16 && inputfltA >= 6) {
                    CaveatDialog dialogFragment = new CaveatDialog();
                    dialogFragment.show(getSupportFragmentManager(), "CaveatDialog");

                    float laurel = inputfltW / ((inputfltH / 100) * (inputfltH / 100) * (inputfltH / 100)) * 10;

                    if (laurel < 100) {
                        output2.setText("やせすぎ");
                        output2.setTextColor(getResources().getColor(R.color.colorLowWeight));

                    } else if (laurel > 100 && laurel < 115) {
                        output2.setText("やせてる");
                        output2.setTextColor(getResources().getColor(R.color.colorLowWeight));

                    } else if (laurel > 115 && laurel < 145) {
                        output2.setText("ふつう");
                        output2.setTextColor(getResources().getColor(R.color.colorNormalWeight));

                    } else if (laurel > 145 && laurel < 160) {
                        output2.setText("太っている");
                        output2.setTextColor(getResources().getColor(R.color.colorObesity2));

                    } else if (laurel > 160) {
                        output2.setText("太りすぎ");
                        output2.setTextColor(getResources().getColor(R.color.colorObesity3));
                    }

                }

                //カウブ指数で求める（BMIと同じ求め方で機銃のみ違う）3～5歳
                if (inputfltA >= 3 && inputfltA < 6) {
                    CaveatDialog dialogFragment = new CaveatDialog();
                    dialogFragment.show(getSupportFragmentManager(), "CaveatDialog");

                    if (BMI < 14.5) {
                        output2.setText("やせぎみ");
                        output2.setTextColor(getResources().getColor(R.color.colorLowWeight));

                    } else if (BMI > 14.5 && BMI < 16.5) {
                        output2.setText("ふつう");
                        output2.setTextColor(getResources().getColor(R.color.colorNormalWeight));

                    } else if (BMI > 16.5) {
                        output2.setText("ふとりぎみ");
                        output2.setTextColor(getResources().getColor(R.color.colorObesity3));
                    }
                }

                //カウブ指数で求める（BMIと同じ求め方で機銃のみ違う）　1，2歳
                if (inputfltA >= 1 && inputfltA < 3) {
                    CaveatDialog dialogFragment = new CaveatDialog();
                    dialogFragment.show(getSupportFragmentManager(), "CaveatDialog");

                    if (BMI < 15.5) {
                        output2.setText("やせぎみ");
                        output2.setTextColor(getResources().getColor(R.color.colorLowWeight));

                    } else if (BMI > 15.5 && BMI < 17.0) {
                        output2.setText("ふつう");
                        output2.setTextColor(getResources().getColor(R.color.colorNormalWeight));

                    } else if (BMI > 17.0) {
                        output2.setText("ふとりぎみ");
                        output2.setTextColor(getResources().getColor(R.color.colorObesity3));
                    }
                }
            }
            //クリアボタンの時
            if (id == R.id.bt_clear) {
                //入力欄に空文字を設定
                inputA.setText("");
                inputH.setText("");
                inputW.setText("");
                //メッセージ表示欄に空文字を設定
                output1.setText("");
                output2.setText("");
                output3.setText("");
                output4.setText("");
            }


        }
    }
}