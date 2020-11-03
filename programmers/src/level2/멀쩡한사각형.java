package level2;
//문제의 식을 찾는게 가장 어려웠음
/* 
<풀이>
우선 w와 h가 공약수가 있다면 문제를 공약수를 나눈 w' 와 h'로 축소시킬수있습니다.

w'와 h'가 서로소라 가정했을때 대각선은 반대쪽 코너에 도달하기전 w'-1 세로선과 h'-1 가로선을 지나고 지날때마다 새로운 정사각형이 추가됩니다. 그래서 첫 정사각형을 포함 1 + (w'-1) + (h'-1) = w' + h' - 1개의 정사각형을 지나게 되므로 공약수를 다시 곱해주면 w + h - gcd(w,h)개의 정사각형을 지나는것을 찾을수있습니다.
*/
public class 멀쩡한사각형 {
	public long solution(int w, int h) {
	     long gcd = 0;
	     
	     //최대공약수 찾기
	     for(int i = (w > h ? h : w); i > 0; i--) {
	         if(w % i == 0 && h % i == 0){
	             gcd = i;
	             break;
	         }
	     }
	     
	     // 굳이 타입 캐스팅 해 주는 이유는
	     // w와 h가 int 형이기 때문에
	     // w*h가 int의 메모리를 벗어나면 에러 발생
	     long total = (long)w*(long)h;
	     long broken = w+h-gcd;
	     
	     return total-broken;
	 }
}

