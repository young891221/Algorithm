package study;

import java.util.Scanner;

public class BFS {
	
	static int n; // �ԷµǴ� ������ �ִ�
	static int rear; // ���ܰ� �Ĵ��� ��Ÿ���� ����
	static int front;
	static int map[][] = new int[30][30];
	static int queue[] = new int[30];
	static int visit[] = new int[30];
	
	static void BFS(int v){
		int i;
		
		visit[v] = 1; // ���� v�� �湮�ߴٰ� ǥ��
		System.out.println(v+"���� ����");
		queue[rear++] = v; //ť�� v�� �����ϰ� �Ĵ��� 1 ������Ŵ
		while(front < rear){
			//ť�� ù��°�� �ִ� �����͸� �����ϰ� ���ܵ� ���� ��������, ���� 1 ����
			v = queue[front++];
			for(i = 1; i <= n; i++){
				//���� v�� ���� i �� ������, ���� i�� �湮���� ���� ������ ���
				if(map[v][i] == 1 && visit[i] == 0){
					visit[i] = 1; // ���� i�� �湮�ߴٰ� ǥ��
					System.out.println(v+"���� "+i+"�� �̵�");
					queue[rear++] = i; //ť�� i�� �����ϰ� �Ĵ��� 1 ������Ŵ
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		n = scan.nextInt(); // ����
		int start = scan.nextInt(); // ����
		int v1 = 0, v2 = 0;
		
		while(true){ // Ʈ�� ���� �� ������ ����
			v1 = scan.nextInt();
			v2 = scan.nextInt();
			if(v1 == -1 && v2 == -1)
				break;
			map[v1][v2] = map[v2][v1] = 1;
		}
		
		BFS(start);

	}

}
