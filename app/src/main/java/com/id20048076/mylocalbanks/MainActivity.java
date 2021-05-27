package com.id20048076.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;
    boolean fDBS = false;
    boolean fOCBC = false;
    boolean fUOB = false;
    String bankClicked = "";


    String link;
    String dial;
    String favourite;
    String english;
    String chinese;

    String dbse;
    String ocbce;
    String uobe;

    String dbsc;
    String ocbcc;
    String uobc;

    String dbsl;
    String dbsd;
    String ocbcl;
    String ocbcd;
    String uobl;
    String uobd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);

        link = getString(R.string.link);
        dial = getString(R.string.dial);
        favourite = getString(R.string.favourite);
        english = getString(R.string.english);
        chinese = getString(R.string.chinese);

        dbse = getString(R.string.dbs);
        ocbce = getString(R.string.ocbc);
        uobe = getString(R.string.uob);

        dbsc = getString(R.string.dbsc);
        ocbcc = getString(R.string.ocbcc);
        uobc = getString(R.string.uobc);

        dbsl = getString(R.string.dbsl);
        dbsd = getString(R.string.dbsd);
        ocbcl = getString(R.string.ocbcl);
        ocbcd = getString(R.string.ocbcd);
        uobl = getString(R.string.uobl);
        uobd = getString(R.string.uobd);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v==tvDBS){
            bankClicked = dbse;
        }else if(v==tvOCBC){
            bankClicked = ocbce;
        }else if(v==tvUOB){
            bankClicked = uobe;
        }
        menu.add(0,0,0,link);
        menu.add(0,1,1,dial);
        menu.add(0,2,2,favourite);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(bankClicked.equalsIgnoreCase(dbse)){
            if(id==0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(dbsl));
                startActivity(intent);
            }else if(id==1){
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(dbsd));
                startActivity(intentCall);
            }else if(id==2){
                int red = getResources().getColor(R.color.red);
                int black = getResources().getColor(R.color.black);
                if(fDBS){
                    fDBS=false;
                    tvDBS.setTextColor(black);
                }else{
                    fDBS=true;
                    tvDBS.setTextColor(red);
                }
                tvOCBC.setTextColor(black);
                tvUOB.setTextColor(black);
            }
        }else if(bankClicked.equalsIgnoreCase(ocbce)){
            if(id==0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(ocbcl));
                startActivity(intent);
            }else if(id==1){
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(ocbcd));
                startActivity(intentCall);
            }else if(id==2){
                int red = getResources().getColor(R.color.red);
                int black = getResources().getColor(R.color.black);
                tvDBS.setTextColor(black);
                if(fOCBC){
                    fOCBC=false;
                    tvOCBC.setTextColor(black);
                }else{
                    fOCBC=true;
                    tvOCBC.setTextColor(red);
                }
                tvUOB.setTextColor(black);
            }
        }else if(bankClicked.equalsIgnoreCase(uobe)){
            if(id==0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uobl));
                startActivity(intent);
            }else if(id==1){
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(uobd));
                startActivity(intentCall);
            }else if(id==2){
                int red = getResources().getColor(R.color.red);
                int black = getResources().getColor(R.color.black);
                tvDBS.setTextColor(black);
                tvOCBC.setTextColor(black);
                if(fUOB){
                    fUOB=false;
                    tvUOB.setTextColor(black);
                }else{
                    fUOB=true;
                    tvUOB.setTextColor(red);
                }
            }
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,0,0,english);
        menu.add(0,1,1,chinese);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==0){
            tvDBS.setText(dbse);
            tvOCBC.setText(ocbce);
            tvUOB.setText(uobe);
        }else if(id==1){
            tvDBS.setText(dbsc);
            tvOCBC.setText(ocbcc);
            tvUOB.setText(uobc);
        }
        return super.onOptionsItemSelected(item);
    }
}