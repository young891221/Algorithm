package study;

import java.util.Scanner;

public class BFS {
	
	static int n; // 입력되는 정점의 최댓값
	static int rear; // 전단과 후단을 나타내는 변수
	static int front;
	static int map[][] = new int[30][30];
	static int queue[] = new int[30];
	static int visit[] = new int[30];
	
	static void BFS(int v){
		int i;
		
		visit[v] = 1; // 정점 v를 방문했다고 표시
		System.out.println(v+"에서 시작");
		queue[rear++] = v; //큐에 v를 삽입하고 후단을 1 증가시킴
		while(front < rear){
			//큐의 첫번째에 있는 데이터를 제외하고 제외된 값을 가져오며, 전단 1 증가
			v = queue[front++];
			for(i = 1; i <= n; i++){
				//정점 v와 정점 i 가 만나고, 정점 i를 방문하지 않은 상태일 경우
				if(map[v][i] == 1 && visit[i] == 0){
					visit[i] = 1; // 정점 i를 방문했다고 표시
					System.out.println(v+"에서 "+i+"로 이동");
					queue[rear++] = i; //큐에 i를 삽입하고 후단을 1 증가시킴
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		n = scan.nextInt(); // 정점
		int start = scan.nextInt(); // 시작
		int v1 = 0, v2 = 0;
		
		while(true){ // 트리 값들 다 저장해 놓음
			v1 = scan.nextInt();
			v2 = scan.nextInt();
			if(v1 == -1 && v2 == -1)
				break;
			map[v1][v2] = map[v2][v1] = 1;
		}
		
		BFS(start);

	}

}
