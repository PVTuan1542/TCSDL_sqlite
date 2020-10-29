package tcsdl.com;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class myDatabase extends SQLiteOpenHelper {
    private static final String Database_name = "Database_name";
    private static final String TABLE_NAME = "Sinhvien";
    private static final String Col_1 = "ID";
    private static final String Col_2 = "Name";
    private static final String Col_3 = "Toan";
    private static final String Col_4 = "Li";
    private static final String Col_5 = "Hoa";

    public myDatabase(Context context){
        super(context,Database_name,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" ( " + Col_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                Col_2 + "  TEXT, "+ Col_3 + " INTEGER, " + Col_4+" INTEGER, " + Col_5+" INTEGER ) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String name, String toan, String li, String hoa){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Col_2,name);
        values.put(Col_3,toan);
        values.put(Col_4,li);
        values.put(Col_5,hoa);
        long result = db.insert(TABLE_NAME,null,values);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean updatetData(String id, String name, String toan, String li, String hoa){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Col_1,id);
        values.put(Col_2,name);
        values.put(Col_3,toan);
        values.put(Col_4,li);
        values.put(Col_5,hoa);
        long result=db.update(TABLE_NAME,values, Col_1 +"=?",new String[]{id});
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME,Col_1 + "=?", new String[]{id});
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }
}
