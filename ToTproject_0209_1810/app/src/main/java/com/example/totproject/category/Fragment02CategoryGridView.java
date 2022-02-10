package com.example.totproject.category;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.totproject.R;
import com.example.totproject.common.CommonAsk;
import com.example.totproject.common.CommonMethod;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Fragment02CategoryGridView extends Fragment{
    GridView gridView;
    int tabcode;
    ArrayList<CategoryVO> list = new ArrayList<>();

    public Fragment02CategoryGridView(int tabcode) {
        this.tabcode = tabcode;
    }



    CategoryVO vo = new CategoryVO();
    public View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Fragment02CategoryDetail categoryDetail = new Fragment02CategoryDetail();
            getFragmentManager().beginTransaction().replace(R.id.cate_container, categoryDetail).addToBackStack(null).commit();
            Bundle bundle = new Bundle();
            bundle.putString("sn", vo.getBoard_sn()+"");
            getParentFragmentManager().setFragmentResult("sn",bundle);

        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rooView = inflater.inflate(R.layout.category_frag_gridlist, container, false);

        /*SharedPreferences pref = getActivity().getSharedPreferences("Fragnebt02Tab", Context.MODE_PRIVATE);
        String result = pref.getString("tabText", "");*/
        list();

        if(tabcode == 1){

        }else if (tabcode == 2){

        }else if (tabcode == 3){

        }


        CategoryAdapter adapter = new CategoryAdapter(getContext(),list,listener);
        gridView = rooView.findViewById(R.id.gridv);

        gridView.setAdapter(adapter);

/*        CommonAsk commonAsk = new CommonAsk("categrid");
        commonAsk.execute();*/


        return rooView;
    }

    public ArrayList<CategoryVO> list(){
        Gson gson = new Gson();
        CommonAsk commonAsk = new CommonAsk("category_list");
        InputStream in = CommonMethod.excuteAsk(commonAsk);

        try{



            list    = gson.fromJson(new InputStreamReader(in), new TypeToken< List<CategoryVO> >(){}.getType());
        }catch (Exception e){
            e.printStackTrace();
        }
        return  list;
    }







   /* public void boardSN(int sn){
        Intent intent = new Intent(getActivity(), Fragment02CategoryDetail.class);
        intent.putExtra("sn",sn);
        startActivity(intent);

    }*/



/*    @Override
    public void onClick(View v) {
        Log.i("asdasdasd??","asdasd");
        Fragment02CategoryDetail categoryDetail = new Fragment02CategoryDetail();
        getFragmentManager().beginTransaction().replace(R.id.container, categoryDetail).commit();
    }*/
}