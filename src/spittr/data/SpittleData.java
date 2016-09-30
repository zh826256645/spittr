package spittr.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import spittr.Spittle;

@Component
@Profile("noData")
public class SpittleData implements SpittleRepository{
	private static List<Spittle> list = new ArrayList<>();

	static {
		list.add(new Spittle(1L, "Spittles go fourth", new Date()));
		list.add(new Spittle(2L, "Spittle spittle spittle", new Date()));
		list.add(new Spittle(3L, "Here's another spittle", new Date()));
		list.add(new Spittle(4L, "Hello world!The first ever spittle!", new Date()));
	}

	@Override
	public List<Spittle> findSpittles(long max, int count) {
		List<Spittle> liSpittles = new ArrayList<>();
		if(list.size() < count) {
			count = list.size();
		}
		for(int i=0 ; i < count; i++) {
			liSpittles.add(list.get(i));
		}
		return liSpittles;
	}

	@Override
	public Spittle findOne(final long id) {
		for(int i = 0; i < list.size(); i++) {
			Spittle spittle = list.get(i);
			if(spittle.getId() == id) {
				return spittle;
			}
		}
		return null;
	}
}
