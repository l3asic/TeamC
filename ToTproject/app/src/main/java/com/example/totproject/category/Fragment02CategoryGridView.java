package com.example.totproject.category;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

import com.example.totproject.R;

import java.util.ArrayList;


public class Fragment02CategoryGridView extends Fragment{
    GridView gridView;

    GridDTO dto = new GridDTO();
    public View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Fragment02CategoryDetail categoryDetail = new Fragment02CategoryDetail();
            getFragmentManager().beginTransaction().replace(R.id.cate_container, categoryDetail).commit();
            Bundle bundle = new Bundle();
            bundle.putString("sn", dto.getBoard_sn()+"");
            getParentFragmentManager().setFragmentResult("sn",bundle);

        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rooView = inflater.inflate(R.layout.category_frag_gridlist, container, false);

        /*SharedPreferences pref = getActivity().getSharedPreferences("Fragnebt02Tab", Context.MODE_PRIVATE);
        String result = pref.getString("tabText", "");*/

        ArrayList<GridDTO> list = new ArrayList<>();

        for(int i=0; i < 10; i++){
            GridDTO dto = new GridDTO();
            dto.setBoard_sn(i);
            dto.setBoard_title("제목"+i);
            dto.setBoard_content("내용"+i);
            dto.setBoard_read_cnt(i);
            dto.setBoard_reviewepath(i);


            list.add(dto);
        }
        GridAdapter adapter = new GridAdapter(getContext(),list,listener);
        gridView = rooView.findViewById(R.id.gridv);

        gridView.setAdapter(adapter);
        return rooView;
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