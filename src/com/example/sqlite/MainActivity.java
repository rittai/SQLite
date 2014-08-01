package com.example.sqlite;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{
	
	SQLiteDatabase sdb = null;
	MySQLiteOpenHelper helper = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//LinearLayout ll = new LinearLayout(this);
		//ll.setOrientation(LinearLayout.HORIZONTAL);
		//setContentView(ll);
	}
	
	@Override
	protected void onResume(){
		super.onResume();
		Button btnENTRY = (Button)findViewById(R.id.button2);
		btnENTRY.setOnClickListener(this);
	}

	@Override
	public void onClick(View v){
		//Intent intent = null;
		switch(v.getId()){//どのボタンが押されたか判定
		case R.id.button2:
			//エディットテキストからの入力内容を取り出す
			EditText id = (EditText)findViewById(R.id.editText1);
			EditText pass = (EditText)findViewById(R.id.editText2);
			
			String inputid = id.getText().toString();
			String inputpass = pass.getText().toString();
			
			//inputがnullでない、かつ、空でない場合のみ、if文内を実行
			if(inputid != null && ! inputid.isEmpty()){
				//if(inputpass != null && ! inputpass.isEmpty()){
					//MySQLiteOpenHelperのインサートメソッドを呼び出し
					helper.insertHitokoto(sdb,inputid,inputpass);
				}
			//}
				//入力欄をクリア
				id.setText("");
				pass.setText("");
				break;
			}
			/*
		case R.id.button3:
			String query_select = "SELECT * FROM Hitokoto";
			
			Cursor cursor = sdb.rawQuery(query_select,null);
			startManagingCursor(cursor);
			
			String result_str = "";
			
			while(cursor.moveToNext()){
				int index_id = cursor.getColumnIndex("id");
				int index_pass = cursor.getColumnIndex("pass");
				int id2 = cursor.getInt(index_id);
				int pass2 = cursor.getInt(index_pass);
				
				result_str  +="ID：" +id2+"名前：" + pass2 + "¥n";
			}
			//内容表示用のTextView
			TextView tv = new TextView(this);
			tv.setText(result_str);
			ViewGroup ll = null;
			ll.addView(tv);
			*/
		}
	}

	

