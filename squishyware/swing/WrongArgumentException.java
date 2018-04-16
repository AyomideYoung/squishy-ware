package squishyware.swing;	
	public class WrongArgumentException extends Exception{
	
		private int index;
	
		public WrongArgumentException(){
			super();
			}
			
		public WrongArgumentException(String s){
			super(s);
		}
		
		public WrongArgumentException(String s,int index){
			super(s);
			this.index=index;
			
		}  		
		
		public void printStackTrace(){
			System.out.println("Found wrong argument in index "+index+" at" );	
			super.printStackTrace();  
		}
		
		}