package com.example.cdemoutil;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class LocalDBOperation extends SQLiteOpenHelper {

	
	public LocalDBOperation(Context context, String dbName,
			CursorFactory factory, int version) {
		super(context, dbName, factory, version);
	}

	//Create Tables Start
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("Create Table If Not Exists " + DatabaseInter.TABLE_USER_INFO.TABLE_NAME + "("+DatabaseInter.TABLE_USER_INFO.ID+" Text Primary Key, "+DatabaseInter.TABLE_USER_INFO.USR_NAME+" Text, "+DatabaseInter.TABLE_USER_INFO.PASSWORD+" Text, "+DatabaseInter.TABLE_USER_INFO.NAME+" Text, "+DatabaseInter.TABLE_USER_INFO.PHONE_NO+" Text, "+DatabaseInter.TABLE_BUDDY_INFO.EMAIL+" Text, "+DatabaseInter.TABLE_USER_INFO.PHOTO_PATH+" Text, "+DatabaseInter.TABLE_USER_INFO.ABOUT+" Text)");
		db.execSQL("Create Table If Not Exists " + DatabaseInter.TABLE_BUDDY_INFO.TABLE_NAME + "("+DatabaseInter.TABLE_BUDDY_INFO.ID+" Text, "+DatabaseInter.TABLE_BUDDY_INFO.NAME+" Text, "+DatabaseInter.TABLE_BUDDY_INFO.PHONE_NO+" Text, "+DatabaseInter.TABLE_BUDDY_INFO.EMAIL+" Text, "+DatabaseInter.TABLE_BUDDY_INFO.PHOTO_PATH+" Text, "+DatabaseInter.TABLE_BUDDY_INFO.ABOUT+" Text)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}

	public void createBuddyConversationTable(String buddyId) {
		SQLiteDatabase db = getWritableDatabase();
		String tableName = DatabaseInter.TABLE_BUDDY_CONVERSATION.TABLE_NAME + buddyId;
		try {
			db.execSQL("Drop Table If Exists "+tableName);
			db.execSQL("Create Table " + tableName + "("+DatabaseInter.TABLE_BUDDY_CONVERSATION.ID+" Text, "+DatabaseInter.TABLE_BUDDY_CONVERSATION.MESSAGE+" Text, "+DatabaseInter.TABLE_BUDDY_CONVERSATION.PHOTO_PATH+" Text, "+DatabaseInter.TABLE_BUDDY_CONVERSATION.VIDEO_PATH+" Text)");
		} catch(SQLException sqlE) {
			sqlE.printStackTrace();
		} finally {
			if(db != null) {
				db.close();
			}
		}
	}
	//Create Tables End
	
	//Insert Data into Tables Start
	public void insertUserData(ArrayList<String> data) {
		SQLiteDatabase db = getWritableDatabase();
		ContentValues cv = new ContentValues();
		
		try {
			cv.put(DatabaseInter.TABLE_USER_INFO.ID, data.get(0));
			cv.put(DatabaseInter.TABLE_USER_INFO.USR_NAME, data.get(1));
			cv.put(DatabaseInter.TABLE_USER_INFO.PASSWORD, data.get(2));
			cv.put(DatabaseInter.TABLE_USER_INFO.NAME, data.get(3));
			cv.put(DatabaseInter.TABLE_USER_INFO.PHONE_NO, data.get(4));
			cv.put(DatabaseInter.TABLE_USER_INFO.EMAIL, data.get(5));
			cv.put(DatabaseInter.TABLE_USER_INFO.PHOTO_PATH, data.get(6));
			cv.put(DatabaseInter.TABLE_USER_INFO.ABOUT, data.get(7));
			
			db.insert(DatabaseInter.TABLE_USER_INFO.TABLE_NAME, null, cv);
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(db != null) {
				db.close();
			}
		}
	}
	
	public void insertBuddyData(ArrayList<String> data) {
		SQLiteDatabase db = getWritableDatabase();
		ContentValues cv = new ContentValues();
		
		try {
			cv.put(DatabaseInter.TABLE_BUDDY_INFO.ID, data.get(0));
			cv.put(DatabaseInter.TABLE_BUDDY_INFO.NAME, data.get(1));
			cv.put(DatabaseInter.TABLE_BUDDY_INFO.PHONE_NO, data.get(2));
			cv.put(DatabaseInter.TABLE_BUDDY_INFO.EMAIL, data.get(3));
			cv.put(DatabaseInter.TABLE_BUDDY_INFO.PHOTO_PATH, data.get(4));
			cv.put(DatabaseInter.TABLE_BUDDY_INFO.ABOUT, data.get(5));
			
			db.insert(DatabaseInter.TABLE_BUDDY_INFO.TABLE_NAME, null, cv);
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(db != null) {
				db.close();
			}
		}
	}
	
	public void insertBuddyConversationData(ArrayList<String> data) {
		SQLiteDatabase db = getWritableDatabase();
		ContentValues cv = new ContentValues();
		
		try {
			cv.put(DatabaseInter.TABLE_BUDDY_CONVERSATION.ID, data.get(0));
			cv.put(DatabaseInter.TABLE_BUDDY_CONVERSATION.MESSAGE, data.get(1));
			cv.put(DatabaseInter.TABLE_BUDDY_CONVERSATION.PHOTO_PATH, data.get(2));
			cv.put(DatabaseInter.TABLE_BUDDY_CONVERSATION.VIDEO_PATH, data.get(3));
			
			db.insert(DatabaseInter.TABLE_BUDDY_CONVERSATION.TABLE_NAME, null, cv);
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(db != null) {
				db.close();
			}
		}
	}
	//Insert Data into Tables End
	
	/*public void updateTable(String table, String value, String[] columns, String[] whereArgs) {
		SQLiteDatabase db = getWritableDatabase();
		ContentValues cv = new ContentValues();
		for(int i = 0; i < )
		db.update(table, values, whereClause, whereArgs)
	}*/
	
	//Delete Data from Tables Start
	public void deleteData(String table, String whereClause) {
		SQLiteDatabase db = getWritableDatabase();
		
		try {
			db.delete(table, whereClause, null);
		} catch(SQLException sqlE) {
			sqlE.printStackTrace();
		} finally {
			if(db != null) {
				db.close();
			}
		}
	}
	//Delete Data from Tables End
	
	//Select data from Table Start
	public String[][] selectData(String table, String whereClause) {
		SQLiteDatabase db = getWritableDatabase();
		String[][] selectedData = null;
		try {
			Cursor cur = db.rawQuery("Select * From "+table + " "+whereClause, null);
			if(cur !=null) {
				if(cur.getCount() != 0) {
					cur.moveToFirst();
					selectedData = new String[cur.getCount()][cur.getColumnCount()];
					for(int i = 0; i < selectedData.length - 1; i++) {
						cur.moveToNext();
						for(int j = 0; j < selectedData[i].length - 1; j++) {
							selectedData[i][j] = cur.getString(j);
						}
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(db != null) {
				db.close();
			}
		}
		return selectedData;
	}
	//Select data from Table End
	
}