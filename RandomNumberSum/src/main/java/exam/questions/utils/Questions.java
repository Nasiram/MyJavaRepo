package exam.questions.utils;

public class Questions {

 public Questions(int[] randomNumbers) {
		super();
		this.randomNumbers = randomNumbers;
	}

private int[] randomNumbers;

		public int[] getRandomNumbers() {
			return randomNumbers;
		}

		public void setRandomNumbers(int[] randomNumbers) {
			this.randomNumbers = randomNumbers;
		}
		
		public int getSum()
		{
			return this.randomNumbers[0]+this.randomNumbers[1]+this.randomNumbers[2];
		}
	}
