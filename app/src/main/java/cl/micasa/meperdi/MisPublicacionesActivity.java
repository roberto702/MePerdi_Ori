package cl.micasa.meperdi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MisPublicacionesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mis_publicaciones_main);

        Button btn_publicar = (Button) findViewById(R.id.button_publicar);
        btn_publicar.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { Intent intent = new Intent (v.getContext(), PedirDatosActivity.class); startActivityForResult(intent, 0);
            } });
    }

    public void onClickImg1(View view) {
        Toast toast1 = Toast.makeText(getApplicationContext(), "Compartir imagen 1", Toast.LENGTH_SHORT);
        toast1.setGravity(Gravity.CENTER, 0, 0);
        toast1.show();

    }

    public void onClickImg2(View view) {
        Toast toast1 = Toast.makeText(getApplicationContext(), "Compartir imagen 2", Toast.LENGTH_SHORT);
        toast1.setGravity(Gravity.CENTER, 0, 0);
        toast1.show();

    }
    }
