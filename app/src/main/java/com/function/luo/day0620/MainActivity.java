package com.function.luo.day0620;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.function.luo.bean.DbBean;
import com.function.luo.bean.Student;
import com.function.luo.bean.StudentDao;
import com.function.luo.utils.DaoSessionUtils;

import org.greenrobot.greendao.query.WhereCondition;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.button3)
    Button button3;
    @BindView(R.id.button4)
    Button button4;
    @BindView(R.id.button5)
    Button button5;
    @BindView(R.id.button6)
    Button button6;
    @BindView(R.id.tv1)
    TextView tv1;
    private Student studentBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
        studentBean = new Student();
        studentBean.setId((long) (Math.random() * 100));
        studentBean.setAge(25);
        studentBean.setName("小米");
    }

    private void init() {


        for (int i = 0; i < 100; i++) {
            Student student = new Student();
            student.setStudentNo(i);
            int age = (int) (Math.random() * 10 + 10);
            student.setAge(age);
            student.setTelPhone(String.valueOf(Math.random() * 10000000));
            String chineseName = String.valueOf("名字：" + Math.random() * 10000000);
            student.setName(chineseName);
            if (i % 2 == 0) {
                student.setSex("男");
            } else {
                student.setSex("女");
            }
            student.setAddress(String.valueOf(Math.random() * 10000));
            student.setGrade(String.valueOf(age % 10) + "年纪");
            student.setSchoolName("学校：" + String.valueOf(Math.random() * 1000));
            DaoSessionUtils.insertDbBean(student);
        }

    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button1:
                //增加
                DaoSessionUtils.insertOrReplaceDbBean(studentBean);
                break;
            case R.id.button2:
                studentBean.setName("东方不败");
                DaoSessionUtils.updateDbBean(studentBean);
                //修改
                break;
            case R.id.button3:
                DaoSessionUtils.deleteDbBean(studentBean);
                //删除
                break;
            case R.id.button4:
                //全部查询
                List<? extends DbBean> dbBeans = DaoSessionUtils.queryAll(studentBean);
                if (dbBeans != null) {
                    Log.d("LUO", "数量" + dbBeans.size());
                    tv1.setText(String.valueOf(dbBeans));
                } else {
                    tv1.setText("无数据");
                }

                break;
            case R.id.button5:
                //按条件查询
                List<WhereCondition> whereConditions = new ArrayList<>();
                whereConditions.add(StudentDao.Properties.Name.eq("小米"));
                whereConditions.add(StudentDao.Properties.Age.eq(25));
                List<? extends DbBean> dbList = DaoSessionUtils.queryConditionAll(studentBean, whereConditions);

                if (dbList != null) {
                    Log.d("LUO", "数量" + dbList.size());
                    tv1.setText(String.valueOf(dbList));
                } else {
                    tv1.setText("无数据");
                }

                break;
            case R.id.button6:
                //sql 语句查询
                String sql = "_ID IN " + "(SELECT _ID FROM STUDENT WHERE _ID > 5)";
                List<? extends DbBean> dbBeans1 = DaoSessionUtils.querySqlAll(studentBean, sql);

                if (dbBeans1 != null) {
                    Log.d("LUO", "数量" + dbBeans1.size());
                    tv1.setText(String.valueOf(dbBeans1));
                } else {
                    tv1.setText("无数据");
                }

                break;
            default:
        }
    }
}
