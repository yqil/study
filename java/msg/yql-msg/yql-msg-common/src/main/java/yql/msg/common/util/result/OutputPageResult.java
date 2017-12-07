package yql.msg.common.util.result;

import java.util.List;

import yql.msg.common.util.logback.LogBackUtil;
import yql.msg.common.util.mybatis.Page;

/**
 * OutputResult类中data内容统一定义类
 * 
 * @author bm
 *
 */
public class OutputPageResult {
	/**
	 * 集合信息
	 */
	private List<? extends Object> list;
	/**
	 * 保存单个对象结果信息
	 */
	private Object obj;
	/**
	 * 分页信息
	 */
	private Page page;

	public List<? extends Object> getList() {
		return list;
	}

	public void setList(List<? extends Object> list) {
		this.list = list;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	/**
	 * 初始化分页信息
	 * @param count
	 * @param page
	 */
	public void initPageInfo(long count, Page page){
    	int pageNo = page.getPageNo() == 0 ? 1 : page.getPageNo();
    	page.setPageNo(pageNo);
    	page.setBegin((pageNo - 1) * page.getLength());
    	page.setEnd(pageNo * page.getLength());
		
		LogBackUtil.getLogger().debug("获取记录总数");
		LogBackUtil.getLogger().debug("获取分页后的数据，记录总数为：{}", count);
		page.setTotalRecords(Integer.parseInt(String.valueOf(count)));
		page.setPageCount(page.getTotalRecords() % page.getLength() == 0
				? page.getTotalRecords() / page.getLength()
				: (page.getTotalRecords() / page.getLength() + 1));
    }
}
