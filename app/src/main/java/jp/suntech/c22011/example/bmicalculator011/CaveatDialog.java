package jp.suntech.c22011.example.bmicalculator011;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class CaveatDialog extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //ダイアログビルダーを生成
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //ダイアログのタイトルを設定
        builder.setTitle("警告");
        //メッセージ設定
        builder.setMessage("適切な肥満度を求めるためには、6歳未満の場合はカウブ指数が、6歳から１５歳まではローレル指数が使われます。");
        //ボタン設定
        builder.setPositiveButton("確認", new DialogButtonClickListener());


        //ダイアログオブジェクトを生成し、リターン。
        AlertDialog dialog = builder.create();
        return dialog;
    }

    //ダイアログのアクションボタンが押された時の処理をする
    private class DialogButtonClickListener implements DialogInterface.OnClickListener {

        @Override
        public void onClick(DialogInterface dialog, int which) {
            //トーストメッセージ用文字列変数を用意
            String msg = "確認しました";

            //トースト表示
            Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
        }
    }
}





