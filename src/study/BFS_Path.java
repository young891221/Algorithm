package study;

import java.util.Scanner;

public class BFS_Path {
	int[][] data;
	int[] result = new int[100];
	int[] x = new int[100];
	int[] y = new int[100];
	int end_x;
	int end_y;
	static int cnt;
	
	public BFS_Path(int[][] data, int end_x, int end_y){
		this.data = data;
		this.end_x = end_x;
		this.end_y = end_y;
		cnt = 0;
	}
	
	public void BFS(int _x, int _y){
		int count = 0;
		insert_queue(_x, _y, 1);
		
		while(count < cnt && x[count] != end_x || y[count] != end_y){
			data[x[count]][y[count]] = 0;
			if(check(x[count]-1, y[count], data.length) && data[x[count]-1][y[count]] == 1){
				insert_queue(x[count]-1, y[count], result[count]+1);
			}
			if(check(x[count]+1, y[count], data.length) && data[x[count]+1][y[count]] == 1){
				insert_queue(x[count]+1, y[count], result[count]+1);
			}
			if(check(x[count], y[count]-1, data.length) && data[x[count]][y[count]-1] == 1){
				insert_queue(x[count], y[count]-1, result[count]+1);
			}
			if(check(x[count], y[count]+1, data.length) && data[x[count]][y[count]+1] == 1){
				insert_queue(x[count], y[count]+1, result[count]+1);
			}
			count++;
		}
		System.out.println("�ִܰŸ���: "+result[count-1]+"�Դϴ�.");
		
	}
	
	public void insert_queue(int _x, int _y, int count){
		x[cnt] = _x;
		y[cnt] = _y;
		result[cnt] = count;
		System.out.println("x: "+x[cnt]+" y: "+y[cnt]+"result : "+result[cnt]);
		cnt++;
	}
	
	boolean check(int i, int j, int num){
		if((i>-1&&i<num) && (j>-1&&j<num)){
			return true;
		}else{
			return false;
		}
	}
	
	public static void main(String[] args) {
		int start[] = new int[2];
		int end[] = new int[2];
		int num = 0;
		int data[][];
		Scanner scan = new Scanner(System.in);
		//������ �б�
		start[0] = scan.nextInt();
		start[1] = scan.nextInt();
		//������ �б�
		end[0] = scan.nextInt();
		end[1] = scan.nextInt();
		//�迭ũ�� �б�
		num = scan.nextInt();
		
		data = new int[num][num];
		
		//�� �Է� ����
		for(int i=0; i<num; i++){
			for(int j=0; j<num; j++){
				data[i][j] = scan.nextInt();
			}
		}
		//�� �Է� ����
		
		//DFS�� ���� �ִ� ��� ã��
		BFS_Path bp = new BFS_Path(data, end[0], end[1]);
		bp.BFS(start[0], start[1]);
		//DFS�� ���� �ִ� ��� ã�� ����
	}

}
