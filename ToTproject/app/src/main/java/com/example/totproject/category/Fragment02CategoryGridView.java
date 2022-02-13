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
import com.example.totproject.common.VO.BoardCommonVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Fragment02CategoryGridView extends Fragment{
    GridView gridView;
    int tabcode;
    ArrayList<BoardCommonVO> list = new ArrayList<>();

    public Fragment02CategoryGridView(int tabcode) {
        this.tabcode = tabcode;
    }



    BoardCommonVO vo = new BoardCommonVO();
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


        if(tabcode == 1){
            categoryList_tour();
        }else if (tabcode == 2){
            categoryList_activity();
        }else if (tabcode == 3){
            categoryList_festival();
        }


        CategoryAdapter adapter = new CategoryAdapter(getContext(),list,listener);
        gridView = rooView.findViewById(R.id.gridv);

        gridView.setAdapter(adapter);

/*        CommonAsk commonAsk = new CommonAsk("categrid");
        commonAsk.execute();*/


        return rooView;
    }

    /*public ArrayList<CategoryVO> list(){
        Gson gson = new Gson();
        CommonAsk commonAsk = new CommonAsk("category_list");
        InputStream in = CommonMethod.excuteAsk(commonAsk);

        try{



            list    = gson.fromJson(new InputStreamReader(in), new TypeToken< List<CategoryVO> >(){}.getType());
        }catch (Exception e){
            e.printStackTrace();
        }
        return  list;
    }*/

    public ArrayList<BoardCommonVO> categoryList_tour(){
        Gson gson = new Gson();
        CommonAsk commonAsk = new CommonAsk("categoryList_tour");
        InputStream in = CommonMethod.excuteAsk(commonAsk);

        try{



            list    = gson.fromJson(new InputStreamReader(in), new TypeToken< List<BoardCommonVO> >(){}.getType());
        }catch (Exception e){
            e.printStackTrace();
        }
        return  list;
    }

    public ArrayList<BoardCommonVO> categoryList_activity(){
        Gson gson = new Gson();
        CommonAsk commonAsk = new CommonAsk("categoryList_activity");
        InputStream in = CommonMethod.excuteAsk(commonAsk);

        try{



            list    = gson.fromJson(new InputStreamReader(in), new TypeToken< List<BoardCommonVO> >(){}.getType());
        }catch (Exception e){
            e.printStackTrace();
        }
        return  list;
    }

    public ArrayList<BoardCommonVO> categoryList_festival(){
        Gson gson = new Gson();
        CommonAsk commonAsk = new CommonAsk("categoryList_festival");
        InputStream in = CommonMethod.excuteAsk(commonAsk);

        try{



            list    = gson.fromJson(new InputStreamReader(in), new TypeToken< List<BoardCommonVO> >(){}.getType());
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