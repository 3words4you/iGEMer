package yi.igemer;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by yimo on 2017-10-17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    SQLiteDatabase sqliteDB = this.getWritableDatabase();
    public static final String DATABASE_NAME = "IGEM.db";
    public static final String USER_TABLE = "users";
    public static final String USERID = "userID";
    public static final String USERNAME = "email";
    public static final String PASSWORD = "password";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ USER_TABLE + " (userID INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+USER_TABLE);
        onCreate(db);
    }

    public boolean addUserData(String email, String password){
        Cursor c = sqliteDB.rawQuery("SELECT * FROM users WHERE email='"+email+"'",null);
        if(c.getCount()==0){
            sqliteDB.execSQL("INSERT INTO users (email,password) VALUES('"+email+"','"+password+"');");
            return true;
        }
        return false;
    }

    public boolean loginIsSuccess(String email,String password){
        Cursor c = sqliteDB.rawQuery("SELECT * FROM users WHERE email='"+email+"' AND password='"+password+"';",null);
        if(c.getCount()==0){
            return false;
        }
        else{
            return true;
        }
    }
}
