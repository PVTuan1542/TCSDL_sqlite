package tcsdl.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button bt_them;
    private Button bt_sua;
    private Button bt_xoa;
    private EditText etId;
    private EditText etName;
    private EditText etToan;
    private EditText etLi;
    private EditText etHoa;
    private myDatabase  MyDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyDatabase = new myDatabase(this);
        initView();
        initListener();

    }

    private void initListener() {
        bt_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String toan = etToan.getText().toString();
                String li = etLi.getText().toString();
                String hoa = etHoa.getText().toString();
                boolean bl=MyDatabase.insertData(name,toan,li,hoa);
                if(bl){
                    Toast.makeText(MainActivity.this,"Inserted ",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Insert fail",Toast.LENGTH_SHORT).show();
                }

            }
        });
        bt_sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = etId.getText().toString();
                String name = etName.getText().toString();
                String toan = etToan.getText().toString();
                String li = etLi.getText().toString();
                String hoa = etHoa.getText().toString();
                boolean bl=MyDatabase.updatetData(id,name,toan,li,hoa);
                if(bl){
                    Toast.makeText(MainActivity.this,"Updated ",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Update fail",Toast.LENGTH_SHORT).show();
                }
            }
        });

        bt_xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = etId.getText().toString();
                boolean bl=MyDatabase.deleteData(id);
                if(bl){
                    Toast.makeText(MainActivity.this,"Deleted ",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Delete fail",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void initView(){
        bt_them = (Button) findViewById(R.id.bt_them);
        bt_sua = (Button) findViewById(R.id.bt_sua);
        bt_xoa = (Button) findViewById(R.id.bt_xoa);
        etId = (EditText) findViewById(R.id.et_id);
        etName = (EditText) findViewById(R.id.et_name);
        etToan = (EditText) findViewById(R.id.et_toan);
        etLi = (EditText) findViewById(R.id.et_li);
        etHoa = (EditText) findViewById(R.id.et_hoa);

        bt_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        bt_sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        bt_xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}