package game.baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Baseball {

	private List<Integer> baseballNos;

	private Baseball() {
		this.baseballNos = new ArrayList<>();
	}

	private Baseball(List<Integer> baseballNos) {
		this.baseballNos = baseballNos;
	}

	public static Baseball init() {
		return new Baseball();
	}

	public static Baseball from(List<Integer> baseballNos) {
		return new Baseball(baseballNos);
	}

	public boolean contains(int no) {
		return this.baseballNos.contains(no);
	}

	/**
	 * 없는 번호인 경우, -1을 return한다.
	 *
	 * @param no
	 * @return
	 */
	public int getPosition(int no) {
		return this.baseballNos.indexOf(no);
	}

	public void addNo(int no) {
		if (baseballNos.contains(no)) {
			throw new IllegalArgumentException("Invalid baseball baseballNo");
		}
		this.baseballNos.add(0, no);
	}

	public void clear() {
		this.baseballNos.clear();
	}

	public Stream<Integer> getNos() {
		return baseballNos.stream();
	}

	public int size() {
		return this.baseballNos.size();
	}
}
