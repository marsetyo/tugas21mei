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
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;



public class MainActivity extends AppCompatActivity {

    Button btnSimpan;
    ListView listViewBook;
    EditText editTextJudul, editTextNama, editTextHalaman;

    //inisialiasi arraylist yang digunakan pada program ini
    ArrayList<String> listOfBook=new ArrayList<>();

    //deklarasi arrayadapter
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewBook = (ListView) findViewById(R.id.listView_output);
        editTextJudul = (EditText) findViewById(R.id.inputJudulBuku);
        editTextNama = (EditText) findViewById(R.id.inputNamaPengarang);
        editTextHalaman = (EditText) findViewById(R.id.inputJumlahHalaman);
        btnSimpan = (Button) findViewById(R.id.btn_simpan);

        listOfBook.add("Laskar Pelangi");
        listOfBook.add("5 cm");
        listOfBook.add("Ayat ayat cinta");
        listOfBook.add("Lima Menara");
        listOfBook.add("Tutorial Pemrograman Android");

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listOfBook);

        listViewBook.setAdapter(adapter);

        listViewBook.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String clickedItem= (String) parent.getAdapter().getItem(position);
            Log.d("booklogger",clickedItem);
            }
        });

        listViewBook.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            String longClickedItem= (String) parent.getAdapter().getItem(position);
            Log.d("booklogger",longClickedItem);
            return false;
        }
    });

        //mengaktifkan fungsi button simpan
        btnSimpan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String title = editTextJudul.getText().toString();


                if(!title.isEmpty())
                {
                    listOfBook.add(title);
                    adapter.notifyDataSetChanged();
                    editTextJudul.setText("");
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "judul buku wajib diisi", Toast.LENGTH_SHORT).show();
                }
            }


          }
        );


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

    private void showDeleteDialog(final String bookTitle){
        AlertDialog.Builder deleteDialog=new AlertDialog.Builder(this);
        deleteDialog.setMessage("Anda yakin untuk menghapus \n"+bookTitle+"?");
        deleteDialog.setPositiveButton("Ya",new DialogInterface.OnClickListener() {

         @Override
         public void onClick(DialogInterface dialog, int which) {
         dialog.dismiss();
         listOfBook.remove(bookTitle);
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
}
