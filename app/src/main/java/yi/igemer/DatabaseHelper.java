package yi.igemer;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
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
        //user
        db.execSQL("CREATE TABLE "+ USER_TABLE + " (userID INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT, password TEXT)");
        //news
        db.execSQL("CREATE TABLE news (newsID INTEGER PRIMARY KEY AUTOINCREMENT, logo TEXT, description TEXT, title text, createdAt TEXT)");
        db.execSQL("INSERT INTO news (newsID,logo,description,title,createdAt) VALUES(1,'http://oxuf82agx.bkt.clouddn.com/banner.jpg','Experience iGEM and be a part of the excitement as we celebrate your team, your hard work, and your achievements. Join us at the Jamboree!Make sure to register by the August 31st deadline to secure your poster and presentation slot At least one team member must register for the Giant Jamboree by the August 31 deadline to secure your teams presentation and poster slot at the Giant Jamboree. To avoid a late fee, ALL team members should register by August 31.','Giant Jamboree & Competition Updates','2017-06-22 06:30:00'),(2,'http://oxuf82agx.bkt.clouddn.com/banner.jpg','We are happy to announce that registration for iGEM 2017 is open. iGEM teams continue to impress each other and the broader international community. Following the close of the 2016 season, we have heard many stories from both past and future participants about how iGEM has influenced their world. There is a lot of excitement in store for 2017 so we encourage you to get signed up soon.','Registration','2017-03-01 08:00:00'),(3,'http://oxuf82agx.bkt.clouddn.com/banner.jpg','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec velit felis, interdum tempus viverra eget, mattis et quam. Nam tristique, orci accumsan luctus egestas, ex tellus consequat eros, eget pellentesque dolor justo in elit. Integer bibendum, quam ut tempus consequat, sapien sem mollis nibh, at hendrerit ante leo nec est. Nulla quis interdum leo. Cras nec neque et lectus gravida blandit a vitae dolor. Vestibulum imperdiet fringilla lacus. Phasellus blandit mollis lorem, consequat interdum nibh. Vestibulum non eros eu sem pharetra lacinia. Cras tristique hendrerit dui, et viverra nisi vestibulum vitae. Nullam suscipit risus in lectus sodales ornare. Nunc imperdiet neque enim, ut imperdiet eros dapibus eu. Vestibulum tortor erat, mattis at accumsan at, facilisis ut justo. Suspendisse potenti. Vivamus tellus purus, semper sed facilisis vitae, efficitur in quam. Nullam ultrices luctus tincidunt. Quisque erat ligula, dapibus a lectus et, elementum vestibulum justo.','Sample Title 3','2017-01-01 00:00:00'),(4,'http://oxuf82agx.bkt.clouddn.com/banner.jpg','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec velit felis, interdum tempus viverra eget, mattis et quam. Nam tristique, orci accumsan luctus egestas, ex tellus consequat eros, eget pellentesque dolor justo in elit. Integer bibendum, quam ut tempus consequat, sapien sem mollis nibh, at hendrerit ante leo nec est. Nulla quis interdum leo. Cras nec neque et lectus gravida blandit a vitae dolor. Vestibulum imperdiet fringilla lacus. Phasellus blandit mollis lorem, consequat interdum nibh. Vestibulum non eros eu sem pharetra lacinia. Cras tristique hendrerit dui, et viverra nisi vestibulum vitae. Nullam suscipit risus in lectus sodales ornare. Nunc imperdiet neque enim, ut imperdiet eros dapibus eu. Vestibulum tortor erat, mattis at accumsan at, facilisis ut justo. Suspendisse potenti. Vivamus tellus purus, semper sed facilisis vitae, efficitur in quam. Nullam ultrices luctus tincidunt. Quisque erat ligula, dapibus a lectus et, elementum vestibulum justo.','Sample Title 4','2017-01-01 00:00:00'),(5,'http://oxuf82agx.bkt.clouddn.com/banner.jpg','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec velit felis, interdum tempus viverra eget, mattis et quam. Nam tristique, orci accumsan luctus egestas, ex tellus consequat eros, eget pellentesque dolor justo in elit. Integer bibendum, quam ut tempus consequat, sapien sem mollis nibh, at hendrerit ante leo nec est. Nulla quis interdum leo. Cras nec neque et lectus gravida blandit a vitae dolor. Vestibulum imperdiet fringilla lacus. Phasellus blandit mollis lorem, consequat interdum nibh. Vestibulum non eros eu sem pharetra lacinia. Cras tristique hendrerit dui, et viverra nisi vestibulum vitae. Nullam suscipit risus in lectus sodales ornare. Nunc imperdiet neque enim, ut imperdiet eros dapibus eu. Vestibulum tortor erat, mattis at accumsan at, facilisis ut justo. Suspendisse potenti. Vivamus tellus purus, semper sed facilisis vitae, efficitur in quam. Nullam ultrices luctus tincidunt. Quisque erat ligula, dapibus a lectus et, elementum vestibulum justo.','Sample Title 5','2017-01-01 00:00:00')");
        //team
        db.execSQL("CREATE TABLE teams (teamID INTEGER PRIMARY KEY AUTOINCREMENT, logo TEXT, description TEXT, name text, school TEXT, wiki TEXT,region TEXT, country TEXT,track TEXT, kind TEXT, application TEXT, serial TEXT,attend TEXT, createdAt TEXT)");
        db.execSQL("INSERT INTO teams (teamID,logo,description,name,school,wiki,region,country,track,kind,application,serial,attend,createdAt) VALUES(1,'http://oxuf82agx.bkt.clouddn.com/banner.jpg','A single species of bacteria is responsible for many plant diseases','British_Columbia','University of British Columbia','http://2017.igem.org/Team:British_Columbia','North America','Canada','Environment','Collegiate','2017-03-29','50','10','2017-12-31'),(2,'http://oxuf82agx.bkt.clouddn.com/banner.jpg','C12 Mediated Cancer Treatment: Dual Functionality as a Cytotoxic and Signalling Agent','McMaster_II','McMaster Univeristy','http://2017.igem.org/Team:McMaster_II','North America','Canada','Therapeutics','Collegiate','2017-04-20','50','10','2017-12-31'),(3,'http://oxuf82agx.bkt.clouddn.com/banner.jpg','C12 Mediated Cancer Treatment: Dual Functionality as a Cytotoxic and Signalling Agent','BIT','Beijing Institute of Technology','http://2017.igem.org/Team:BIT','Asia','China','Diagnostics','Collegiate','2017-03-20','40','10','2017-12-31')");

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

    public List<News> getNewsList(String type) {
        List<News> newsList= new ArrayList<>();
        String query = "SELECT newsID,title,createdAt,logo FROM news";

        if(type=="hot"){
            query += " LIMIT 3";
        }
        Cursor c = sqliteDB.rawQuery(query, null);
        c.moveToFirst();

        while (!c.isAfterLast()) {
            News news = new News(c.getInt(0),c.getString(1),c.getString(2),c.getString(3));
            newsList.add(news);
            c.moveToNext();
        }
        c.close();
        return newsList;
    }

    public List<Team> getTeamList() {
        List<Team> teamList= new ArrayList<>();
        String query = "SELECT teamID,logo,description,name,school,wiki,region,country,track,kind,application,serial,attend,createdAt FROM teams";
        Cursor c = sqliteDB.rawQuery(query, null);
        c.moveToFirst();

        while (!c.isAfterLast()) {
            Team team = new Team(c.getInt(0),c.getString(1),c.getString(2),c.getString(3),c.getString(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),c.getString(10),c.getString(11),c.getString(12),c.getString(13));
            teamList.add(team);
            c.moveToNext();
        }
        c.close();
        return teamList;
    }

    public Team getTeamDetail(int id){
        Cursor c = sqliteDB.rawQuery("SELECT teamID,logo,description,name,school,wiki,region,country,track,kind,application,serial,attend,createdAt FROM teams WHERE teamID='"+id+"'",null);
        c.moveToFirst();
        Team team = new Team(c.getInt(0),c.getString(1),c.getString(2),c.getString(3),c.getString(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),c.getString(10),c.getString(11),c.getString(12),c.getString(13));
        return team;
    }
}
