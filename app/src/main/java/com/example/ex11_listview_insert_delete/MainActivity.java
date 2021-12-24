package com.example.ex11_listview_insert_delete;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //0.어댑터뷰를 바인딩한다
        //1.어댑터를 만든다. 필요한거 3가지(1.this , 2.디자인(1줄,1칸) 3.데이터(전체)
        //2.어댑터뷰에 어댑터를 꽂는다.
        //3.어댑터뷰의 한 아이템에 이벤트처리 설정

        //0.어댑터뷰를 바인딩한다
        ListView listView1 = findViewById(R.id.listView1);//어댑터뷰

        //1.어댑터를 만든다. 필요한거 3가지(1.this , 2.디자인(1줄,1칸) 3.데이터(전체)
        //방법은 2가지인데, 심플과 복잡
        //심플 방법으로

//        String datas[] = {"사과","딸기","바나나"};
        ArrayList<String> datas = new ArrayList<String>();
        datas.add("파인애플");
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                                                                android.R.layout.simple_list_item_1,
                                                                  datas);

        //2.어댑터뷰에 어댑터를 꽂는다.
        listView1.setAdapter(adapter1);

        //버튼 이벤트처리 추가(insert 용)
        EditText edt1 = findViewById(R.id.edtItem);
        Button btn1 = findViewById(R.id.btnAdd);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                datas.add(edt1.getText().toString());
                adapter1.notifyDataSetChanged();
            }
        });

        //3.어댑터뷰의 한 아이템에 이벤트처리 설정
        listView1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {

                datas.remove(position);
                adapter1.notifyDataSetChanged();

                return false;
            }
        });





    }
}