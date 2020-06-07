package devMathching2020Backend;

class Q2 {
	  static int answer = 0;
	  static int done = 0;
	  static int direction = 0;
	  public int solution(int[][] office, int r, int c, String[] move) {
	      int xlen = office[0].length;
	      int ylen = office.length;
	      
	      int[] dx = {0, 1, 0, -1 }; //북 동 남 서
	      int[] dy = {-1, 0, 1, 0 };

	      while(true){
	          if(office[r][c] != 0) {
	                answer += office[r][c];
	                office[r][c] = 0;
	          }
	          if(done == move.length){
	              return answer;
	          }
	          
	          if(move[done].equals("right")){
	              direction++;
	              if(direction > 3) direction = 0;
	              done++;
	          }else if(move[done].equals("left")){
	              direction--;
	              if(direction < 0) direction = 3;
	              done++;
	          }else{
	              if(r+dy[direction] < ylen && r+dy[direction] >= 0 && c+dx[direction] < xlen && c+dx[direction] >= 0){
	                    if(office[r+dy[direction]][c+dx[direction]] != -1){ //막혀있지 않으면
	                            done++;
	                            r += dy[direction];
	                            c += dx[direction];
	                     }else{
	                            done++;
	                     }
	               }else{
	                     done++;
	               }
	          }
	     }
	  }
	}
