package kakaoIntern2020Summer;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 
 * 건설회사의 설계사인 죠르디는 고객사로부터 자동차 경주로 건설에 필요한 견적을 의뢰받았습니다.
	제공된 경주로 설계 도면에 따르면 경주로 부지는 N x N 크기의 정사각형 격자 형태이며 각 격자는 1 x 1 크기입니다.
	설계 도면에는 각 격자의 칸은 0 또는 1 로 채워져 있으며, 0은 칸이 비어 있음을 1은 해당 칸이 벽으로 채워져 있음을 나타냅니다.
	경주로의 출발점은 (0, 0) 칸(좌측 상단)이며, 도착점은 (N-1, N-1) 칸(우측 하단)입니다. 죠르디는 출발점인 (0, 0) 칸에서 출발한 자동차가 도착점인 (N-1, N-1) 칸까지 무사히 도달할 수 있게 중간에 끊기지 않도록 경주로를 건설해야 합니다.
	경주로는 상, 하, 좌, 우로 인접한 두 빈 칸을 연결하여 건설할 수 있으며, 벽이 있는 칸에는 경주로를 건설할 수 없습니다.
	이때, 인접한 두 빈 칸을 상하 또는 좌우로 연결한 경주로를 직선 도로 라고 합니다.
	또한 두 직선 도로가 서로 직각으로 만나는 지점을 코너 라고 부릅니다.
	건설 비용을 계산해 보니 직선 도로 하나를 만들 때는 100원이 소요되며, 코너를 하나 만들 때는 500원이 추가로 듭니다.
	죠르디는 견적서 작성을 위해 경주로를 건설하는 데 필요한 최소 비용을 계산해야 합니다.
 *
 */

public class Number4 {
	
	static int[][] map = null;
	static boolean[][] visited = null;
	
	static int[] dx = {0,1,0,-1}; //위 오른쪽 아래 왼쪽
	static int[] dy = {-1,0,1,0};
	
	static int N = 0;
	//static int price = 0;

	
	static void roadBfs() {
		
		Queue<Position> q = new LinkedList<Position>();
		Position position = new Position(0, 0, -1);
		q.add(position);
		while(!q.isEmpty()) {
			 Position now = q.poll();
	         int x = now.getX();
	         int y = now.getY();
	         int dir = now.getDirection();
	         visited[x][y] = true;
	         
	         for(int i = 0; i < 4; i++) {
	        	 
	             int nx = x+dx[i];
	             int ny = y+dy[i];
	             
	             if(nx >= 0 && nx <= N && ny >= 0 && ny <= N) {
	                if(map[nx][ny] == 0 && visited[nx][ny] == false) {
	                   visited[nx][ny] = true;
	                   Position next = new Position(nx, ny);
	                   if(x == 0 && y == 0) {
	                	   map[nx][ny] = 100;
	                   }else {
	                	   if(dir == i) {
	                		   map[nx][ny] = map[x][y] + 100;
	                	   }else {
	                		   map[nx][ny] = map[x][y] + 600;
	                	   }
	                   }
	                   next.setDirection(i);
	                   q.add(next);
	                   System.out.println("위치 : " + nx+", "+ny+" | 가격 : " + map[nx][ny]+ " | 이전 방향 : " + now.getDirection()+ " | 이후 방향 : " + next.getDirection());
	                   visited[nx][ny] = true;
	                }
	             }
	             
	          }
	         
		}
	}
	
	public static void main(String[] args) {
		/***** 매개변수 설정 *****/
//		int[][] sample = {{0,0,0}, {0,0,0}, {0,0,0}};
//		int[][] sample = {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
//		int[][] sample = {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};
		int[][] sample = {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};	
		
		map = sample;
		
		/*******************/
		
		
		N = map.length-1;
		visited = new boolean[N+1][N+1];
		roadBfs();
		
		System.out.println(map[N][N]);
		
	}
	
}

class Position{
	
    int x;
	int y;
	int direction;
	   
	public Position(int x, int y) {
       this.x = x;
	   this.y = y;
	}
	
	public Position(int x, int y, int direction) {
	       this.x = x;
		   this.y = y;
		   this.direction = direction;
	}
	
    public int getX() {
	   return x;
	}
	public void setX(int x) {
	   this.x = x;
	}
	public int getY() {
	   return y;
	}
	public void setY(int y) {
	   this.y = y;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}


 }

/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Q2178 {
   static int tx = 0;
   static int ty = 0;
   static int[][] map = null;
   static boolean visited[][] = null;
   static int answer = 1;
   
   public static void bfs() {
      Queue<Position> q = new LinkedList<Position>();
      q.add(new Position(0, 0));
      
      int[] dx = {0,1,0,-1}; //위 오른쪽 아래 왼쪽
      int[] dy = {-1,0,1,0};
      
      while(!q.isEmpty()) {
         Position startP = q.poll();
         int x = startP.getX();
         int y = startP.getY();
         visited[x][y] = true;
         
         for(int i = 0; i < 4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            
            if(nx >= 0 && nx < tx && ny >= 0 && ny < ty) {
               if(map[nx][ny] == 1 && visited[nx][ny] == false) {
                  q.add(new Position(nx, ny));
                  visited[nx][ny] = true;
                  answer++;
                  map[nx][ny] = map[x][y]+1;
               }
            }
         }
         
      }
   }
   public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      tx = Integer.parseInt(st.nextToken());
      ty = Integer.parseInt(st.nextToken());
      map = new int[tx][ty];
      visited = new boolean[tx][ty];
      
      for(int i = 0; i < tx; i++) {
         String temp = br.readLine();
         for(int j = 0; j < ty; j++) {
            //외워두자! 문자->숫자 ASCII 코드 차는 48 (0-9 = 48-57)
            map[i][j] = temp.charAt(j) - 48;
         }
      }
      bfs();
      System.out.println(answer);
      System.out.println(map[tx-1][ty-1]);
   }
}
class Position{
   int x;
   int y;
   
   public Position(int x, int y) {
      this.x = x;
      this.y = y;
   }
   
   public int getX() {
      return x;
   }
   public void setX(int x) {
      this.x = x;
   }
   public int getY() {
      return y;
   }
   public void setY(int y) {
      this.y = y;
   }
   
}
*/