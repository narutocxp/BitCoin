package com.bitcoin.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import com.bitcoin.page.PageResult;

/**
 * 自定义的交易结果比较器，根据时间对交易记录进行排序。越近期的记录越排在前面
 * @author Administrator
 *
 */
public class RecordComparator implements Comparator<PageResult>{

	public int compare(PageResult t1, PageResult t2) {
		
		String timeStr1 = t1.getTime();
		String timeStr2 = t2.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date time1 = null;
		Date time2 = null;
		
		try {
			time1 = sdf.parse(timeStr1);
			time2 = sdf.parse(timeStr2);
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(time1.getTime() > time2.getTime())
			return -1;
		if(time1.getTime() == time2.getTime())
			return 0;
		
		return 1;
	}

}
