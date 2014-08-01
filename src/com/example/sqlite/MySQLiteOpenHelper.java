package com.example.sqlite;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.content.Context;


public class MySQLiteOpenHelper extends SQLiteOpenHelper {
	
	/**
	 * @param context 呼び出しコンテキスト
	 * @param name 利用DB名
	 * @param factory カーソルファクトリー
	 * @param version DBバージョン
	 */
	
	public MySQLiteOpenHelper(Context context){
		super(context,"20140021201762.sqlite3",null,1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO 自動生成されたメソッド・スタブ
		db.execSQL("CREATE TABLE IF NOT EXISTS " + 
				"Hitokoto( id INTEGER PRIMARY KEY NOT NULL , pass TEXT)");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO 自動生成されたメソッド・スタブ
		db.execSQL("drop table Hitokoto");
		onCreate(db);

	}

	public void insertHitokoto(SQLiteDatabase db, String inputid,
			String inputpass) {
		// TODO 自動生成されたメソッド・スタブ
		String sqlstr = "INSERT INTO Hitokoto (id) values('" + inputid + "');";
		String sqlstr2 = "INSERT INTO Hitokoto (pass) values('" + inputpass + "');";
			try{
				//トランザクション開始
				db.beginTransaction();
				db.execSQL(sqlstr);
				db.execSQL(sqlstr2);
				//トランザクション成功
				db.setTransactionSuccessful();
			}catch(SQLException e){
				Log.e("ERROR",e.toString());
			}finally{
				//トランザクション終了
				db.endTransaction();
			}
		return;
		
	}
	


}
