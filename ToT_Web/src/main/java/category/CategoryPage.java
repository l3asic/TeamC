package category;

import java.util.List;

import org.springframework.stereotype.Component;

import common.PageVO;

@Component
public class CategoryPage extends PageVO {
	 private List<CategoryVO> list;

	public List<CategoryVO> getList() {
		return list;
	}

	public void setList(List<CategoryVO> list) {
		this.list = list;
	}
	 
	 
}
