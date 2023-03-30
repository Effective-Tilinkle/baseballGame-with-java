package game.baseball.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import game.baseball.constant.BaseballConstants;

public class Baseball {

	private List<Integer> baseballNos;

	private Baseball(List<Integer> baseballNos) {
		validate(baseballNos);
		this.baseballNos = baseballNos;
	}

	public static Baseball from(List<Integer> baseballNos) {
		return new Baseball(Collections.unmodifiableList(baseballNos));
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

	private void validate(List<Integer> baseballNos) {

		if (baseballNos.size() > BaseballConstants.NO_LENGTH_LIMIT) {
			throw new IllegalArgumentException("Too many baseball no exist");
		}

		if (baseballNos.stream().distinct().count() != baseballNos.size()) {
			throw new IllegalArgumentException("Duplicate number detected");
		}

	}

	public Stream<Integer> getNos() {
		return baseballNos.stream();
	}

	public int size() {
		return this.baseballNos.size();
	}
}
