package scenario_based;

public class SnakeAndLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int winningPosition = 100;
		// UC 1: Start position at 0 and with single player---------------------------
		int position = 0;
		int countDice = 0;
		
		// UC 4: Repeat the game until player reaches 100;
		while(position!=winningPosition) {
		// UC 2: Random dice roll between 1 to 6
		int diceNum = (int) (Math.random()*6)+1;  
		countDice++;
		
		// UC 3: Random 3 options
		int options = (int) (Math.random()*3)+1;
		switch(options) {
		case 1:               // UC 3: Option - No play, player stays at same position
			System.out.println("Dice No.: "+diceNum+" | Option: No Play | Position: "+position);
			break;
		case 2:
			position = position+diceNum;  // UC 3: Option - Ladder, player moves ahead by position as no of dice comes
			if(position>winningPosition) {  // UC 5: If position is greater than 100 than player stays at same position
				position = winningPosition;
			}
			System.out.println("Dice No.: "+diceNum+" | Option: Ladder | Position: "+position); // UC 6: also tells position after every dice roll. 
			break;
		case 3:
			position = position-diceNum;
			if(position<0) {    // UC 3: Option - Snake, player moves behind by position as no of dice comes.
				position = 0;
			}
			System.out.println("Dice No.: "+diceNum+" | Option: Snake | Position: "+position);
			break;
		}
	}
		System.out.println("\nPlayer reached Winning position!");
		System.out.println("The no. of dice rolled to reach 100 are: "+countDice);  // UC 6: No. of times the dice rolled
		
		// UC 7: game for 2 players ----------------------------------------------------------
		int player1Position = 0;
        int player2Position = 0;  // start positions of both players
        int countDiceP1 = 0;
        int countDiceP2 = 0;
        boolean isPlayer1Turn = true;
        while(player1Position!=winningPosition && player2Position!=winningPosition) {  // until position not reaches 100
            int diceNumber = (int) (Math.random()*6)+1;  // Random dice rolled from 1 to 6
            int option = (int) (Math.random()*3)+1;   // Random options from 1 to 3
            if(isPlayer1Turn) {
                countDiceP1++;
                System.out.println("\nPlayer 1 rolled dice no.: "+diceNumber);  // player 1 turns
                switch(option) {
                    case 1:                   // No Play
                        System.out.println("Option- No Play | Position: "+player1Position);
                        isPlayer1Turn = false;
                        break;
                    case 2:                   // Ladder
                        if(player1Position+diceNumber<=winningPosition) {
                            player1Position = player1Position+diceNumber;
                        }
                        System.out.println("Option-Ladder | Position: "+player1Position);
                        // Player gets another chance if ladder comes
                        break;
                    case 3:                    // Snake
                        player1Position = player1Position-diceNumber;
                        if(player1Position<0) {
                            player1Position = 0;
                        }
                        System.out.println("Option- Snake | Position: "+player1Position);
                        isPlayer1Turn = false;
                        break;
                }
            }else {
                countDiceP2++;
                System.out.println("\nPlayer 2 rolled dice no.: "+diceNumber);  // player 2 turns
                switch (option) {
                    case 0:                   // No Play
                        System.out.println("Option- No Play | Position: "+player2Position);
                        isPlayer1Turn = true;
                        break;

                    case 1:                   // Ladder
                        if(player2Position+diceNumber<=winningPosition) {
                            player2Position = player2Position+diceNumber;
                        }
                        System.out.println("Option- Ladder | Position: "+player2Position);
                        break;
                    case 2:                   // Snake
                        player2Position = player2Position-diceNumber;
                        if(player2Position<0) {
                            player2Position = 0;
                        }
                        System.out.println("Option- Snake | Position: "+player2Position);
                        isPlayer1Turn = true;
                        break;
                }
            }
        }
        // Winner
        System.out.println("\nGAME OVER!!");
        if(player1Position==winningPosition) {
            System.out.println("Player 1 won the game!");
            System.out.println("Dice rolled by Player 1 are: " + countDiceP1);
        }else {
            System.out.println("Player 2 won the game!");
            System.out.println("Dice rolled by Player 2 are: " + countDiceP2);
        }
	}

}