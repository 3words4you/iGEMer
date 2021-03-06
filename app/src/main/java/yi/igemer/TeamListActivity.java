package yi.igemer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class TeamListActivity extends AppCompatActivity {

    private ListView teamListView;
    private List<Team> teamList;
    private TeamListAdapter teamAdapter;
    private DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_list);

        //set up list view team
        teamListView = (ListView) findViewById(R.id.lvAllTeam);

//        teamList = new ArrayList<>();
//        teamList.add(new Team(1,"1","1","1","1","1","1","1","1","1","1","1","1","1"));
//        teamList.add(new Team(1,"1","1","1","1","1","1","1","1","1","1","1","1","1"));
//        teamList.add(new Team(1,"1","1","1","1","1","1","1","1","1","1","1","1","1"));
//        teamList.add(new Team(1,"1","1","1","1","1","1","1","1","1","1","1","1","1"));
//        teamList.add(new Team(1,"1","1","1","1","1","1","1","1","1","1","1","1","1"));
        db = new DatabaseHelper(this);
        teamList = db.getTeamList();

        DatabaseHelper db = new DatabaseHelper(this);
        teamAdapter = new TeamListAdapter(this,teamList);

        teamListView.setAdapter(teamAdapter);

        teamListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(view.getContext(), TeamDetailActivity.class);
                Bundle b = new Bundle();
                b.putInt("teamID", Integer.parseInt(view.getTag().toString()));
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }

    public void backToMain(View v){
        Intent i = new Intent(this,MainActivity.class);
        Bundle b = new Bundle();
        b.putString("tab", "tabSearch");
        i.putExtras(b);
        startActivity(i);
    }
}
