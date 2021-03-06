package com.mycompany.work;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameTest {

  private final Game game = new Game();
  
  
  private void rolls(int rolls, int pinsDown) {
    for (int roll = 0; roll < rolls; roll++) {
      game.roll(pinsDown);
    }
  }
  

  @Test
  void shouldScoreGutterGame() {
    rolls(20, 0);

    assertThat(game.score()).isEqualTo(0);
  }

  @Test
  void shouldScoreGameOfOnes() {
    rolls(20, 1);

    assertThat(game.score()).isEqualTo(20);
  }
  
  @Test
  void shouldScoreGameOfTows() {
	  rolls(20, 2);
	  
	  assertThat(game.score()).isEqualTo(40);
  }
  
  
  @Test
  void shouldScoreGameOfOneTwo() {
	  game.roll(1);
	  game.roll(2);
	  rolls(18, 0);
	  
	  assertThat(game.score()).isEqualTo((1+2));
  }
  
  
  @Test
  void shouldScoreGameOfTenTen() {
	  game.roll(10);
	  game.roll(10);  
	  rolls(18, 0);
	  
	  assertThat(game.score()).isEqualTo(10+10+10);
  }
  
  

  @Test
  void shouldScoreSpare() {
    game.roll(7);
    game.roll(3);
    game.roll(4);
    rolls(17, 0);

    assertThat(game.score()).isEqualTo((7 + 3) + 4 + 4);
  }

  @Test
  void shouldScoreStrike() {
    game.roll(10);
    game.roll(3);
    game.roll(4);
    rolls(16, 0);

    assertThat(game.score()).isEqualTo(10 + (3 + 4) + (3 + 4));
  }

  @Test
  void shouldScorePerfectGame() {
    rolls(12, 10);

    assertThat(game.score()).isEqualTo(300);
  }


}
