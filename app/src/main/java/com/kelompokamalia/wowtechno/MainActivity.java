package com.kelompokamalia.wowtechno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.*;
import android.support.v4.util.SimpleArrayMap;
import android.widget.ArrayAdapter;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;



public class MainActivity extends AppCompatActivity {

    Button btnSimpan;
    ListView listViewBook;
    EditText editTextJudul, editTextNama, editTextHalaman;

    ArrayList<Buku> arrayBuku = Buku.getBukus();
    CustomBukuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewBook = (ListView) findViewById(R.id.listView_output);
        editTextJudul = (EditText) findViewById(R.id.inputJudulBuku);
        editTextNama = (EditText) findViewById(R.id.inputNamaPengarang);
        editTextHalaman = (EditText) findViewById(R.id.inputJumlahHalaman);
        btnSimpan = (Button) findViewById(R.id.btn_simpan);

        adapter = new CustomBukuAdapter(this, arrayBuku);

        final ListView listView = (ListView) findViewById(R.id.listView_output);
        listView.setAdapter(adapter);

        listViewBook.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                TextView a = (TextView)view.findViewById(R.id.textJudulBuku);
                String judul = (String) a.getText();

                showDeleteDialog(judul, position);
                Log.d("booklogger",judul);


            }
        });

        listViewBook.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                TextView namaBuku = (TextView)view.findViewById(R.id.textJudulBuku);
                TextView halaman = (TextView)view.findViewById(R.id.textJumlahHalaman);
                TextView pengarang = (TextView)view.findViewById(R.id.textNamaPengarang);

                String namaBuku2 = (String) namaBuku.getText();
                String halaman2 = (String) halaman.getText();
                String pengarang2 = (String) pengarang.getText();

                showUbahDialog(namaBuku2, halaman2, pengarang2, position);

                Log.d("booklogger",namaBuku2);
                return false;
        }
    });

        //mengaktifkan fungsi button simpan
        btnSimpan.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                String judulBuku = editTextJudul.getText().toString();
                String namaPengarang = editTextNama.getText().toString();
                String jumlahHalaman = editTextHalaman.getText().toString();



                if(!judulBuku.isEmpty() && !namaPengarang.isEmpty() && !jumlahHalaman.isEmpty())
                {
                    Buku newBuku = new Buku(judulBuku, namaPengarang, jumlahHalaman);
                    adapter.add(newBuku);
                    editTextJudul.setText("");
                    editTextNama.setText("");
                    editTextHalaman.setText("");
                }

                else
                {
                    Toast.makeText(getApplicationContext(), "Terdapat data kosong, silahkan coba lagi.", Toast.LENGTH_SHORT).show();
                }

            }
        });


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

    private void showDeleteDialog(final String judul, final int position){
        AlertDialog.Builder deleteDialog=new AlertDialog.Builder(this);
        deleteDialog.setMessage("Anda yakin untuk menghapus \n"+judul+"?");
        deleteDialog.setPositiveButton("Ya", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                arrayBuku.remove(position);
                // setelah menghapus, kita perlu meng-update listview
                adapter.notifyDataSetChanged();
            }
        });

        deleteDialog.setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        deleteDialog.show();
    }

    private void showUbahDialog(final String namaBuku2, final String halaman2, final String pengarang2, final int position){
        AlertDialog.Builder deleteDialog=new AlertDialog.Builder(this);
        deleteDialog.setMessage("Anda yakin untuk mengubah \n"+namaBuku2+"?");
        deleteDialog.setPositiveButton("Ya", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                arrayBuku.remove(position);
                adapter.notifyDataSetChanged();
                editTextJudul.setText(namaBuku2);
                editTextHalaman.setText(halaman2);
                editTextNama.setText(pengarang2);


            }
        });

        deleteDialog.setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        deleteDialog.show();
    }



}
