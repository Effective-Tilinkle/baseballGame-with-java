package game.baseball.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UmpireTest {

	@DisplayName("해시맵 내부 정보가 동일하면 같은 해시맵으로 인식하는지 확인한다")
	@Test
	void testHashMap() {
		Map<Integer, Integer> map1 = new HashMap();
		map1.put(1, 1);
		map1.put(2, 2);
		map1.put(3, 3);

		Map<Integer, Integer> map2 = new HashMap();
		map2.put(1, 1);
		map2.put(2, 2);
		map2.put(3, 3);

		System.out.println(map1.equals(map2));

		assertTrue(map1.equals(map2));
	}

	@DisplayName("Unmodifable Map 내부 정보가 동일하면 같은 해시맵으로 인식하는지 확인한다")
	@Test
	void testUnmodifiableHashMap() {
		BaseballNos baseballNos1 = BaseballNos.init();
		baseballNos1.addNos(234);
		BaseballNos baseballNos2 = BaseballNos.init();
		baseballNos2.addNos(234);

		assertTrue(baseballNos1.isEquals(baseballNos2));
	}

}