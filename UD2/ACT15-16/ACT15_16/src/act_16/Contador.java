package act_16;
	class Contador {
		private int c=0;
		Contador (int c) { 
			this.c = c; 
		}
		
		public synchronized void incrementa() {
			c=c+1;
		}
		
		public synchronized void decrementa() {
			c=c-1;
		}
		
		public int getValor() {
			return c; 
		}
	}