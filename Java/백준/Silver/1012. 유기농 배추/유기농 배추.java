import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void search(Queue<String> BFS ,int[][] field, boolean[][] visit, int n, int m){

        while(!BFS.isEmpty()) {
            StringTokenizer st = new StringTokenizer(BFS.poll());
            int nn = Integer.parseInt(st.nextToken());
            int mm = Integer.parseInt(st.nextToken());

            if (mm - 1 >= 0) {
                if (field[nn][mm - 1] == 1 && !visit[nn][mm - 1])
                {
                    BFS.offer(nn + " " + (mm - 1));
                    visit[nn][mm - 1] = true;
                }
            }
            if (mm + 1 < m){
                if (field[nn][mm + 1] == 1 && !visit[nn][mm + 1])
                {
                    BFS.offer(nn + " " + (mm + 1));
                    visit[nn][mm + 1] = true;
                }

            }
            if (nn + 1 < n){
                if (field[nn +  1][mm] == 1 && !visit[nn + 1][mm])
                {
                    BFS.offer((nn + 1) + " " + mm);
                    visit[nn + 1][mm] = true;
                }
            }
            if (nn - 1 >= 0){
                if (field[nn - 1][mm] == 1 && !visit[nn - 1][mm])
                {
                    BFS.offer((nn - 1) + " " + mm);
                    visit[nn - 1][mm] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        Queue<String> BFS;
        int cnt;

        for (int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int noa = Integer.parseInt(st.nextToken());

            cnt = 0;

            BFS = new ArrayDeque<>();

            int[][] field = new int[n][m];
            boolean[][] visit = new boolean[n][m];


            for (int j = 0; j < n; j++){
                for (int k = 0; k < m; k++){
                    field[j][k] = 0;
                    visit[j][k] = false;
                }
            }

            for (int j = 0; j < noa; j++){
                st = new StringTokenizer(br.readLine());
                int mm = Integer.parseInt(st.nextToken());
                int nn = Integer.parseInt(st.nextToken());

                field[nn][mm] = 1;
            }

            for (int j = 0; j < n; j++){
                for (int k = 0; k < m; k++){
                    if (field[j][k] == 1 && !visit[j][k]){
                        BFS.offer(j + " " + k);
                        visit[j][k] = true;
                        search(BFS, field, visit, n, m);
                        cnt++;
                    }
                }
            }
            bw.write(String.valueOf(cnt));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}