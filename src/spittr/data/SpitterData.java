package spittr.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import spittr.Spitter;

@Component
@Profile("notData")
public class SpitterData implements SpittlerRepository{
	
	private static List<Spitter> list = new ArrayList<>();
	private static long IdSetter = 2L;
	static{
		list.add(new Spitter(1L, "zh826256645","123", "Zhong", "Hao", "826256645@qq.com"));
	}

	public Spitter save(Spitter spitter) {
		spitter.setId(IdSetter);
		IdSetter++;
		list.add(spitter);
		return spitter;
	}

	@Override
	public Spitter findByUsername(String username) {
		for(int i = 0; i < list.size(); i++) {
			Spitter spitter = list.get(i);
			if(spitter.getUsername().equals(username)) {
				return spitter;
			}
		}
		return null;
	}
	
}
