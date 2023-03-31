package game.baseball.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import game.baseball.constant.BaseballConstants;

public class Baseball {

	private List<Integer> baseballNos;

	private Baseball(List<Integer> baseballNos) {
		this.baseballNos = baseballNos;
	}

	public static Baseball from(List<Integer> baseballNos) {
		validate(baseballNos);
		return new Baseball(Collections.unmodifiableList(baseballNos));
	}

	public boolean contains(int no) {
		return this.baseballNos.contains(no);
	}

	public int getPosition(int no) {
		return this.baseballNos.indexOf(no);
	}

	private static void validate(List<Integer> baseballNos) {

		if (baseballNos.contains(0)) {
			throw new IllegalArgumentException("Invalid number contained");
		}

		if (baseballNos.size() > BaseballConstants.NO_LENGTH_LIMIT) {
			throw new IllegalArgumentException("Too many baseball no exist");
		}

		if (isExistDuplicateNo(baseballNos)) {
			throw new IllegalArgumentException("Duplicate number detected");
		}

	}

	private static boolean isExistDuplicateNo(List<Integer> baseballNos) {
		return baseballNos.stream().distinct().count() != baseballNos.size();
	}

	public Stream<Integer> getNos() {
		return baseballNos.stream();
	}

	public int size() {
		return this.baseballNos.size();
	}
}
