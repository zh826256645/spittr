package spittr.data;

import spittr.Spitter;

public interface SpittlerRepository {
	Spitter save(Spitter spitter);
	
	Spitter findByUsername(String username);
}
