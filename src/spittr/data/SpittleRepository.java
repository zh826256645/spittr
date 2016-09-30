package spittr.data;

import java.util.List;

import spittr.Spittle;

/**
 * 
 * @author 钟浩
 *
 */
public interface SpittleRepository {
	/**
	 * 
	 * @param max 代表返回的 Spittle 中, Spittle ID 属性的最大值
	 * @param count 表明要返回多少个 Spittle 对象
	 * @return
	 */
	List<Spittle> findSpittles(long max, int count);
	Spittle findOne(final long id);
}
