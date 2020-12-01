char[][] arr;

	public static void main(String[] args) {
		new Viergewinnt();
	}

	public void erzeugeFeld() {

		arr = new char[6][7];
		
		for (int i = 0; i < arr.length; i++) {
			for(char j = 0; j < arr.length; j++) {
				arr[i][j] = '0';
			}
		}

	}

	public void druckeFeld() {

		for(int i = 0; i < arr.length; i++) {
			for(char j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			
		}
		
	}
	public Vierwin() {
		erzeugeFeld();
		druckeFeld();
		
	}
	
