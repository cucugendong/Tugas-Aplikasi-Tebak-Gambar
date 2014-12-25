package com.startx.tebakgambar.level1;

import com.startx.tebakgambar.EndActivity;
import com.startx.tebakgambar.R;
import com.startx.tebakgambar.R.id;
import com.startx.tebakgambar.R.layout;
import com.startx.tebakgambar.R.menu;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Soal9Activity extends Activity {
EditText jawaban9;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_soal9);
		jawaban9=(EditText)findViewById(R.id.isisoal9);
		jawaban9.setFilters(new InputFilter[] { new InputFilter.AllCaps()});
	}
	public void CekJawaban9(View v){
		String jawabanbenar9 = "WINDOWS7";
		String jawabanbenar91 = "WINDOWS 7";
		String jawabanuser=jawaban9.getText().toString();
		if (jawabanuser.equals(jawabanbenar9)){
			Toast.makeText(getApplicationContext(), "JAWABAN " + jawabanbenar9 + " BENAR", 
					Toast.LENGTH_LONG).show();
			Intent i = new Intent(getApplicationContext(),Soal10Activity.class);
			startActivity(i);
			finish();
		}else if (jawabanuser.equals(jawabanbenar91)){
			Toast.makeText(getApplicationContext(), "JAWABAN " + jawabanbenar91 + " BENAR", 
					Toast.LENGTH_LONG).show();
			Intent i = new Intent(getApplicationContext(),Soal10Activity.class);
			startActivity(i);
			finish();
		}else if (jawabanuser.trim().equals("")){
			jawaban_kosong();
		}else {
			jawaban_salah();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.soal9, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public void jawaban_salah(){
		AlertDialog.Builder salah=new AlertDialog.Builder(Soal9Activity.this);
		salah.setTitle("Salah");
		salah.setMessage("Jawaban anda salah");
		salah.setIcon(R.drawable.gagal);
		
		salah.setNeutralButton("OK", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				jawaban9.setText("");
			}
		});
		salah.show();
	}
	public void jawaban_kosong(){
		AlertDialog.Builder kosong=new AlertDialog.Builder(Soal9Activity.this);
		kosong.setTitle("Kosong");
		kosong.setMessage("Jawaban anda masih kosong");
		kosong.setIcon(R.drawable.gagal);
		
		kosong.setNeutralButton("OK", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				jawaban9.requestFocus();
			}
		});
		kosong.show();
	}
	public void backtomenu(){
		AlertDialog.Builder pesan= new AlertDialog.Builder(this);
		pesan.setMessage("Kembali ke menu?")
		.setCancelable(false)
		.setPositiveButton("Ya", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				finish();
			}
		})
		.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.cancel();
			}
		}).show();
	}
	@Override
		public boolean onKeyDown(int keyCode, KeyEvent event) {
			// TODO Auto-generated method stub
			if(keyCode==KeyEvent.KEYCODE_BACK){
				backtomenu();
			}
			return super.onKeyDown(keyCode, event);
		}
}
