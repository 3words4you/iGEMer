package yi.igemer;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yimo on 2017-10-17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    SQLiteDatabase sqliteDB = this.getWritableDatabase();
    public static final String DATABASE_NAME = "IGEM.db";
    public static final String USER_TABLE = "users";


    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, 5);
        SQLiteDatabase db = this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ USER_TABLE + " (userID INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT, password TEXT)");
        db.execSQL("CREATE TABLE news (newsID INTEGER PRIMARY KEY AUTOINCREMENT, logo TEXT, description TEXT, title text, createdAt TEXT)");
        db.execSQL("INSERT INTO news (newsID,logo,description,title,createdAt) VALUES(1,'http://oxuf82agx.bkt.clouddn.com/banner.jpg','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec velit felis, interdum tempus viverra eget, mattis et quam. Nam tristique, orci accumsan luctus egestas, ex tellus consequat eros, eget pellentesque dolor justo in elit. Integer bibendum, quam ut tempus consequat, sapien sem mollis nibh, at hendrerit ante leo nec est. Nulla quis interdum leo. Cras nec neque et lectus gravida blandit a vitae dolor. Vestibulum imperdiet fringilla lacus. Phasellus blandit mollis lorem, consequat interdum nibh. Vestibulum non eros eu sem pharetra lacinia. Cras tristique hendrerit dui, et viverra nisi vestibulum vitae. Nullam suscipit risus in lectus sodales ornare. Nunc imperdiet neque enim, ut imperdiet eros dapibus eu. Vestibulum tortor erat, mattis at accumsan at, facilisis ut justo. Suspendisse potenti. Vivamus tellus purus, semper sed facilisis vitae, efficitur in quam. Nullam ultrices luctus tincidunt. Quisque erat ligula, dapibus a lectus et, elementum vestibulum justo.','Sample Title 1','2017-01-01 00:00:00'),(2,'http://oxuf82agx.bkt.clouddn.com/banner.jpg','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec velit felis, interdum tempus viverra eget, mattis et quam. Nam tristique, orci accumsan luctus egestas, ex tellus consequat eros, eget pellentesque dolor justo in elit. Integer bibendum, quam ut tempus consequat, sapien sem mollis nibh, at hendrerit ante leo nec est. Nulla quis interdum leo. Cras nec neque et lectus gravida blandit a vitae dolor. Vestibulum imperdiet fringilla lacus. Phasellus blandit mollis lorem, consequat interdum nibh. Vestibulum non eros eu sem pharetra lacinia. Cras tristique hendrerit dui, et viverra nisi vestibulum vitae. Nullam suscipit risus in lectus sodales ornare. Nunc imperdiet neque enim, ut imperdiet eros dapibus eu. Vestibulum tortor erat, mattis at accumsan at, facilisis ut justo. Suspendisse potenti. Vivamus tellus purus, semper sed facilisis vitae, efficitur in quam. Nullam ultrices luctus tincidunt. Quisque erat ligula, dapibus a lectus et, elementum vestibulum justo.','Sample Title 2','2017-01-01 00:00:00'),(3,'http://oxuf82agx.bkt.clouddn.com/banner.jpg','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec velit felis, interdum tempus viverra eget, mattis et quam. Nam tristique, orci accumsan luctus egestas, ex tellus consequat eros, eget pellentesque dolor justo in elit. Integer bibendum, quam ut tempus consequat, sapien sem mollis nibh, at hendrerit ante leo nec est. Nulla quis interdum leo. Cras nec neque et lectus gravida blandit a vitae dolor. Vestibulum imperdiet fringilla lacus. Phasellus blandit mollis lorem, consequat interdum nibh. Vestibulum non eros eu sem pharetra lacinia. Cras tristique hendrerit dui, et viverra nisi vestibulum vitae. Nullam suscipit risus in lectus sodales ornare. Nunc imperdiet neque enim, ut imperdiet eros dapibus eu. Vestibulum tortor erat, mattis at accumsan at, facilisis ut justo. Suspendisse potenti. Vivamus tellus purus, semper sed facilisis vitae, efficitur in quam. Nullam ultrices luctus tincidunt. Quisque erat ligula, dapibus a lectus et, elementum vestibulum justo.','Sample Title 3','2017-01-01 00:00:00')");
        db.execSQL("CREATE TABLE teams (teamID INTEGER PRIMARY KEY AUTOINCREMENT, logo TEXT, description TEXT, name text, school TEXT, wiki TEXT,region TEXT, country TEXT,track TEXT, kind TEXT, application TEXT, serial TEXT,attend TEXT createdAt TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
//        db.execSQL("DROP TABLE IF EXISTS "+USER_TABLE);
//        db.execSQL("DROP TABLE IF EXISTS news");
//        db.execSQL("DROP TABLE IF EXISTS teams");
//        onCreate(db);
//        db.execSQL("DROP TABLE news");
//        db.execSQL("CREATE TABLE news (newsID INTEGER PRIMARY KEY AUTOINCREMENT, logo TEXT, description TEXT, title text, createdAt TEXT)");
//        db.execSQL("INSERT INTO news (newsID,logo,description,title,createdAt) VALUES(1,'http://oxuf82agx.bkt.clouddn.com/banner.jpg','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec velit felis, interdum tempus viverra eget, mattis et quam. Nam tristique, orci accumsan luctus egestas, ex tellus consequat eros, eget pellentesque dolor justo in elit. Integer bibendum, quam ut tempus consequat, sapien sem mollis nibh, at hendrerit ante leo nec est. Nulla quis interdum leo. Cras nec neque et lectus gravida blandit a vitae dolor. Vestibulum imperdiet fringilla lacus. Phasellus blandit mollis lorem, consequat interdum nibh. Vestibulum non eros eu sem pharetra lacinia. Cras tristique hendrerit dui, et viverra nisi vestibulum vitae. Nullam suscipit risus in lectus sodales ornare. Nunc imperdiet neque enim, ut imperdiet eros dapibus eu. Vestibulum tortor erat, mattis at accumsan at, facilisis ut justo. Suspendisse potenti. Vivamus tellus purus, semper sed facilisis vitae, efficitur in quam. Nullam ultrices luctus tincidunt. Quisque erat ligula, dapibus a lectus et, elementum vestibulum justo.','Sample Title 1','2017-01-01 00:00:00'),(2,'http://oxuf82agx.bkt.clouddn.com/banner.jpg','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec velit felis, interdum tempus viverra eget, mattis et quam. Nam tristique, orci accumsan luctus egestas, ex tellus consequat eros, eget pellentesque dolor justo in elit. Integer bibendum, quam ut tempus consequat, sapien sem mollis nibh, at hendrerit ante leo nec est. Nulla quis interdum leo. Cras nec neque et lectus gravida blandit a vitae dolor. Vestibulum imperdiet fringilla lacus. Phasellus blandit mollis lorem, consequat interdum nibh. Vestibulum non eros eu sem pharetra lacinia. Cras tristique hendrerit dui, et viverra nisi vestibulum vitae. Nullam suscipit risus in lectus sodales ornare. Nunc imperdiet neque enim, ut imperdiet eros dapibus eu. Vestibulum tortor erat, mattis at accumsan at, facilisis ut justo. Suspendisse potenti. Vivamus tellus purus, semper sed facilisis vitae, efficitur in quam. Nullam ultrices luctus tincidunt. Quisque erat ligula, dapibus a lectus et, elementum vestibulum justo.','Sample Title 2','2017-01-01 00:00:00'),(3,'http://oxuf82agx.bkt.clouddn.com/banner.jpg','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec velit felis, interdum tempus viverra eget, mattis et quam. Nam tristique, orci accumsan luctus egestas, ex tellus consequat eros, eget pellentesque dolor justo in elit. Integer bibendum, quam ut tempus consequat, sapien sem mollis nibh, at hendrerit ante leo nec est. Nulla quis interdum leo. Cras nec neque et lectus gravida blandit a vitae dolor. Vestibulum imperdiet fringilla lacus. Phasellus blandit mollis lorem, consequat interdum nibh. Vestibulum non eros eu sem pharetra lacinia. Cras tristique hendrerit dui, et viverra nisi vestibulum vitae. Nullam suscipit risus in lectus sodales ornare. Nunc imperdiet neque enim, ut imperdiet eros dapibus eu. Vestibulum tortor erat, mattis at accumsan at, facilisis ut justo. Suspendisse potenti. Vivamus tellus purus, semper sed facilisis vitae, efficitur in quam. Nullam ultrices luctus tincidunt. Quisque erat ligula, dapibus a lectus et, elementum vestibulum justo.','Sample Title 3','2017-01-01 00:00:00')");
//          db.execSQL("CREATE TABLE teams (teamID INTEGER PRIMARY KEY AUTOINCREMENT, logo TEXT, description TEXT, name text, school TEXT, wiki TEXT,region TEXT, country TEXT,track TEXT, kind TEXT, application TEXT, serial TEXT,attend TEXT createdAt TEXT)");
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

    public News getNewsDetail(int id){
        Cursor c = sqliteDB.rawQuery("SELECT newsID,title,logo,description FROM news WHERE newsID='"+id+"'",null);
        c.moveToFirst();
        News news = new News();
        news.setLogo(c.getString(2));
        news.setDescription(c.getString(3));
        news.setTitle(c.getString(1));

        return news;
    }

    public List<News> getNewsList() {
        List<News> newsList= new ArrayList<>();
        Cursor c = sqliteDB.rawQuery("SELECT newsID,title,createdAt,logo FROM news", null);
        c.moveToFirst();

        while (!c.isAfterLast()) {
            News news = new News(c.getInt(0),c.getString(1),c.getString(2),c.getString(3));
            newsList.add(news);
            c.moveToNext();
        }
        c.close();
        return newsList;
    }
}
