package com.kelompokamalia.wowtechno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

    Button btnSimpan;
    ListView listViewBook;
    EditText editTextJudul, editTextNama, editTextHalaman;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewBook = (ListView) findViewById(R.id.listView_output);
        editTextJudul = (EditText) findViewById(R.id.inputJudulBuku);
        editTextNama = (EditText) findViewById(R.id.inputNamaPengarang);
        editTextHalaman = (EditText) findViewById(R.id.inputJumlahHalaman);
        btnSimpan = (Button) findViewById(R.id.btn_simpan);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
