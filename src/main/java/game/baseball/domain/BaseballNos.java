package game.baseball.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BaseballNos {

	private Map<Integer, Integer> baseballNos;

	private BaseballNos() {
		this.baseballNos = new HashMap<>();
	}

	public static BaseballNos init() {
		return new BaseballNos();
	}

	public void addNos(int baseballNos) {
		int cnt = 0;
		while (baseballNos > 0) {
			int no = baseballNos % 10;
			this.baseballNos.put(no, cnt++);
			baseballNos /= 10;
		}
	}

	public boolean contains(int no) {
		return this.baseballNos.containsKey(no);
	}

	public int getPosition(int no) {
		return this.baseballNos.get(no);
	}

	public void addNo(int no) {
		this.baseballNos.put(no, baseballNos.size() + 1);
	}

	public void clear() {
		this.baseballNos.clear();
	}

	public Map<Integer, Integer> getBaseballNoMap() {
		return Collections.unmodifiableMap(this.baseballNos);
	}

	public int size() {
		return this.baseballNos.size();
	}

	public boolean isEquals(BaseballNos baseballNos) {
		return this.baseballNos.equals(baseballNos.getBaseballNoMap());
	}
}
