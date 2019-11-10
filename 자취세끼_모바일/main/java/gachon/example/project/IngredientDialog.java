package gachon.example.project;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class IngredientDialog {
    private Context context;
    session session;
    RecyclerView recyclerView;
    public IngredientDialog(Context context){
        this.context=context;
          session=(session)context.getApplicationContext();
    }
    // 호출할 다이얼로그 함수를 정의한다.
    public void callFunction() {

        // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
        final Dialog dlg = new Dialog(context);

        // 액티비티의 타이틀바를 숨긴다.
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // 커스텀 다이얼로그의 레이아웃을 설정한다.
        dlg.setContentView(R.layout.selected_ingredient_dialog);

        dlg.getWindow().setGravity(Gravity.BOTTOM);
        // 커스텀 다이얼로그를 노출한다.
        dlg.show();

        // 커스텀 다이얼로그의 각 위젯들을 정의한다.
        recyclerView=(RecyclerView)dlg.findViewById(R.id.selectedlist);
        RecyclerView.LayoutManager layoutManager;
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        Button button=(Button)dlg.findViewById(R.id.selectedlist_ok);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlg.dismiss();
            }
        });

       ingredient_cycle dialog_adapter=new ingredient_cycle(context);
       recyclerView.setAdapter(dialog_adapter);


    }
}
