package minesweeper;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
	
	public Game() {

		boolean safe = true;
		boolean start = true;
		Scanner s = new Scanner(System.in);
		List<Space> spaceList = new ArrayList<>();
			
		while(start == true) {
			convertAndPrint(spaceList);
			System.out.println();
			System.out.println("Please enter some coordinates (height before width)!");
			start = false;
		}
		
		int safeCount = 88;
		while(safe == true) {
			if(safeCount < 90) {
				String guess = s.nextLine();
				int guessInt = Integer.parseInt(guess);
				if(guessInt < 100) {
					if(spaceList.get(guessInt).getCoord().contains(guess)) {
						if(spaceList.get(guessInt).isBombType() == false) {
							int count = 0;
							safeCount += 1;
							System.out.println(safeCount);
							spaceList.get(guessInt).setFace(Integer.toString(checkAround(spaceList, guessInt, count)));
							convertAndPrint(spaceList);
							System.out.println();
							System.out.println("Please enter some coordinates (height before width)!");
						} else {
							System.out.println("BOOM! You selected a bomb!");
							safe = false;
						}
					}
				} else {
					System.out.println("Please enter a number between 00 and 99");
				}
			} else {
				System.out.println("Congrats, you win!");
				safe = false;
			}
			
		}
	}
	
	public int checkAround(List<Space> spaceList, int guessInt, int count) {
		if(guessInt == 0 || guessInt == 10 || guessInt == 20 || guessInt == 30 || guessInt == 40 || guessInt == 50 || guessInt == 60 || guessInt == 70 || guessInt == 80 || guessInt == 90) {
			if(guessInt > 10) {
				if(spaceList.get(guessInt - 10).isBombType() == true) {
					count += 1;
				}
				if(spaceList.get(guessInt - 9).isBombType() == true) {
					count += 1;
				}
			}
			
			if(guessInt < 99) {
				if(spaceList.get(guessInt + 1).isBombType() == true) {
					count += 1;
				}
			}
			
			if(guessInt < 90) {
				if(spaceList.get(guessInt + 10).isBombType() == true) {
					count += 1;
				}
				if(spaceList.get(guessInt + 11).isBombType() == true) {
					count += 1;
				}
			}
		} else if(guessInt == 9 || guessInt == 19 || guessInt == 29 || guessInt == 39 || guessInt == 49 || guessInt == 59 || guessInt == 69 || guessInt == 79 || guessInt == 89 || guessInt == 99) {
			if(guessInt > 10) {
				if(spaceList.get(guessInt - 11).isBombType() == true) {
					count += 1;
				}
				if(spaceList.get(guessInt - 10).isBombType() == true) {
					count += 1;
				}
			}
			
			if(guessInt > 1) {
				if(spaceList.get(guessInt - 1).isBombType() == true) {
					count += 1;
				}
			}
			
			if(guessInt < 90) {
				if(spaceList.get(guessInt + 9).isBombType() == true) {
					count += 1;
				}
				if(spaceList.get(guessInt + 10).isBombType() == true) {
					count += 1;
				}
			}
		} else {
			if(guessInt > 10) {
				if(spaceList.get(guessInt - 11).isBombType() == true) {
					count += 1;
				}
				if(spaceList.get(guessInt - 10).isBombType() == true) {
					count += 1;
				}
				if(spaceList.get(guessInt - 9).isBombType() == true) {
					count += 1;
				}
			}
			
			if(guessInt > 1) {
				if(spaceList.get(guessInt - 1).isBombType() == true) {
					count += 1;
				}
			}
			if(guessInt < 99) {
				if(spaceList.get(guessInt + 1).isBombType() == true) {
					count += 1;
				}
			}
			
			if(guessInt < 90) {
				if(spaceList.get(guessInt + 9).isBombType() == true) {
					count += 1;
				}
				if(spaceList.get(guessInt + 10).isBombType() == true) {
					count += 1;
				}
				if(spaceList.get(guessInt + 11).isBombType() == true) {
					count += 1;
				}
			}
		}
		return count;
		
		
		
	}
	
	public boolean typeMod(float chance, Random type) {
        float v = type.nextFloat();

        return chance > v;
    }
	
	public void convertAndPrint(List<Space> spaceList) {
		
		int bombCount = 0;
		for(int i = 0; i < 100; i++) {
			Random type = new Random();
			DecimalFormat formatter = new DecimalFormat("00");
			String formatted = formatter.format(i);
			

			if(bombCount < 10) {
				bombCount++;
				Space space = new Space(typeMod((float) 0.2, type), formatted);
				if(space.bombType == false) {
					bombCount--;
				}
				spaceList.add(space);
			} else {
				Space space = new Space(typeMod((float) 0, type), formatted);
				spaceList.add(space);
			}
			
		}

		System.out.println("     0 1 2 3 4 5 6 7 8 9");
		System.out.println("   _ _ _ _ _ _ _ _ _ _ _");
		System.out.println("  |");
		
		int row = 0;
		
		while(row < 10) {
			int col = 0;
			System.out.print(row + " |  ");
			while(col < 10) {
				switch(row) {
				case 0:
					System.out.print(spaceList.get(col).getFace() + " ");
					break;
				case 1:
					System.out.print(spaceList.get(col + 10).getFace() + " ");
					break;
				case 2:
					System.out.print(spaceList.get(col + 20).getFace() + " ");
					break;
				case 3:
					System.out.print(spaceList.get(col + 30).getFace() + " ");
					break;
				case 4:
					System.out.print(spaceList.get(col + 40).getFace() + " ");
					break;
				case 5:
					System.out.print(spaceList.get(col + 50).getFace() + " ");
					break;
				case 6:
					System.out.print(spaceList.get(col + 60).getFace() + " ");
					break;
				case 7:
					System.out.print(spaceList.get(col + 70).getFace() + " ");
					break;
				case 8:
					System.out.print(spaceList.get(col + 80).getFace() + " ");
					break;
				case 9:
					System.out.print(spaceList.get(col + 90).getFace() + " ");
					break;
				}
				col++;
			}
			System.out.println();
			row++;
		}
	}
}
