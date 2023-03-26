package baseball.domain;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

class BallCounterTest {
    private BallCounter ballCounter;

    @BeforeEach
    void setUp() {
        ballCounter = BallCounter.newInstance();
    }

    @Nested
    @DisplayName("BallCounter 객체의")
    class DescribeBallCounter {

        @Nested
        @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
        @DisplayName("스트라이크 반환 테스트에서")
        class DescribeBallCounterForStrike {
            @Test
            @Order(1)
            @DisplayName("스트라이크 값만 가지는 경우 true를 반환하고")
            void 스트라이크_값만_가진_경우() {
                ballCounter.plusStrike();
                assertThat(ballCounter.hasOnlyStrike()).isTrue();
            }

            @Test
            @Order(2)
            @DisplayName("그렇지 않은 경우 false를 반환한다.")
            void 그렇지_않은_경우() {
                ballCounter.plusStrike();
                ballCounter.plusBall();
                assertThat(ballCounter.hasOnlyStrike()).isFalse();
            }
        }

        @Nested
        @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
        @DisplayName("볼 반환 테스트에서")
        class DescribeBallCounterForBall {
            @Test
            @Order(1)
            @DisplayName("볼 값만 가지는 경우 true를 반환하고")
            void 볼_값만_가진_경우() {
                ballCounter.plusBall();
                assertThat(ballCounter.hasOnlyBall()).isTrue();
            }

            @Test
            @Order(2)
            @DisplayName("그렇지 않은 경우 false를 반환한다.")
            void 그렇지_않은_경우() {
                ballCounter.plusStrike();
                ballCounter.plusBall();
                assertThat(ballCounter.hasOnlyBall()).isFalse();
            }
        }

        @Nested
        @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
        @DisplayName("스크라이크와 볼 반환 테스트에서")
        class DescribeBallCounterForStrikeAndBall {
            @Test
            @Order(1)
            @DisplayName("스트라이크와 볼 값을 모두 가지는 경우 true를 반환하고")
            void 볼_값만_가진_경우() {
                ballCounter.plusStrike();
                ballCounter.plusBall();
                assertThat(ballCounter.hasStrikeAndBall()).isTrue();
            }

            @Test
            @Order(2)
            @DisplayName("스트라이크만 가지는 경우 false를 반환한다.")
            void 스트라이크만_가진_경우() {
                ballCounter.plusStrike();
                assertThat(ballCounter.hasStrikeAndBall()).isFalse();
            }

            @Test
            @Order(3)
            @DisplayName("볼만 가지는 경우 false를 반환한다.")
            void 볼_가진_경우() {
                ballCounter.plusBall();
                assertThat(ballCounter.hasStrikeAndBall()).isFalse();
            }
        }
    }

    @Test
    @DisplayName("스트라이크 값이 3인 경우 삼진 아웃에 해당한다.")
    void 삼진_아웃_테스트() {
        ballCounter.plusStrike();
        ballCounter.plusStrike();
        ballCounter.plusStrike();
        assertThat(ballCounter.isAllStrike()).isTrue();
    }
}