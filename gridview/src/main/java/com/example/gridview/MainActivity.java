package com.example.gridview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1.어댑터뷰 바인딩
        //2.어댑터 만들기(복잡방식: BaseAdapter를 상속해서)
        //3.어댑터뷰에 어댑터 꽂기
        //3.어댑터뷰의 아이템에 이벤트 처리

        //1.어댑터뷰 바인딩
        GridView gv1 = findViewById(R.id.gv1);

        //2.어댑터 만들기(복잡방식: BaseAdapter를 상속해서, MyAdapter클래스 객체 만들어서)

        MyAdapter adapter1 = new MyAdapter(this);


        //3.어댑터뷰에 어댑터 꽂기
        gv1.setAdapter(adapter1);

        //4.어댑터뷰의 아이템에 이벤트 처리 - getView 안에서 하시면됨!
    }

    private class MyAdapter extends BaseAdapter
    {
        Context con1;//1번 this

        //3번 데이터 -> String 이 아니고, 그림이죠~!
        Integer[] posterID = { R.drawable.mov01, R.drawable.mov02,
                            R.drawable.mov03, R.drawable.mov04, R.drawable.mov05,
                            R.drawable.mov06, R.drawable.mov07, R.drawable.mov08,
                            R.drawable.mov09, R.drawable.mov10, R.drawable.mov01,
                            R.drawable.mov02, R.drawable.mov03, R.drawable.mov04,
                            R.drawable.mov05, R.drawable.mov06, R.drawable.mov07,
                            R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
                            R.drawable.mov01, R.drawable.mov02, R.drawable.mov03,
                            R.drawable.mov04, R.drawable.mov05, R.drawable.mov06,
                            R.drawable.mov07, R.drawable.mov08, R.drawable.mov09,
                            R.drawable.mov10 };


        public MyAdapter(Context context1)
        {
            con1 = context1;

        }

        @Override
        public int getCount()//3번 데이터의 갯수만!!!
        {
            return posterID.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup)//2번 디자인 (3번 데이터를 활용해서)
        {
            //1줄의 디자인(여기서는 1칸의 디자인)
            ImageView iv1 = new ImageView(con1);
            iv1.setLayoutParams(new ViewGroup.LayoutParams(200,300));
            iv1.setPadding(5,5,5,5);
//            iv1.setImageResource(R.drawable.mov01);
            iv1.setImageResource(posterID[position]);

            //4.어댑터뷰의 아이템에 이벤트 처리 - getView 안에서 하시면됨! 여기서함!
            iv1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    View view1 = View.inflate(con1, R.layout.dialog1,null);
                    ImageView iv2 = view1.findViewById(R.id.iv1);
                    iv2.setImageResource(posterID[position]);

                    //1.대화상다 띄우기, inflator로 xml 가져와서 만듦
                    AlertDialog.Builder dlg1 = new AlertDialog.Builder(con1);
                    dlg1.setTitle("큰 포스터");
                    dlg1.setIcon(R.mipmap.ic_launcher);

                    dlg1.setView(view1);
                    dlg1.setNegativeButton("닫기", null);
                    dlg1.show();
                }
            });

            return iv1;
        }
    }
}