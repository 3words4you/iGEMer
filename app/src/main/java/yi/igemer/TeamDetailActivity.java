package yi.igemer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TeamDetailActivity extends AppCompatActivity {

    private TextView tvRegion,tvCountry,tvTrack,tvKind,tvApplication,tvSerial,tvAttend,txtTeamName,tvSchool,tvWiki;
    private Team team;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_detail);
        //init values
        Bundle b = getIntent().getExtras();
        int teamID =b.getInt("teamID");
        DatabaseHelper db = new DatabaseHelper(this);
        team = db.getTeamDetail(teamID);

        tvRegion = (TextView)findViewById(R.id.tvRegion);
        tvCountry = (TextView)findViewById(R.id.tvCountry);
        tvTrack = (TextView)findViewById(R.id.tvTrack);
        tvKind = (TextView)findViewById(R.id.tvKind);
        tvApplication = (TextView)findViewById(R.id.tvApplication);
        tvSerial = (TextView)findViewById(R.id.tvSerial);
        tvAttend = (TextView)findViewById(R.id.tvAttend);
        txtTeamName = (TextView)findViewById(R.id.txtTeamName);
        tvSchool = (TextView)findViewById(R.id.tvSchool);
        tvWiki = (TextView)findViewById(R.id.tvWiki);

        tvRegion.setText(team.getRegion());
        tvCountry.setText(team.getCountry());
        tvTrack.setText(team.getTrack());
        tvKind.setText(team.getKind());
        tvApplication.setText(team.getApplication());
        tvSerial.setText(team.getSerial());
        tvAttend.setText(team.getAttend());
        txtTeamName.setText(team.getName());
        tvSchool.setText(team.getSchool());


        tvWiki.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String url = team.getWiki();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }

    public void backToMain(View v){
        Intent i = new Intent(this,TeamListActivity.class);
        startActivity(i);
    }

}
