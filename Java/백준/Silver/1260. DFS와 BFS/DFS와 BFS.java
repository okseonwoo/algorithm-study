import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        Stack<Integer> DFS = new Stack<>();
        Queue<Integer> BFS = new ArrayDeque<>();

        boolean[][] con = new boolean[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++){
            for (int j = 0; j < n + 1; j++){
                con[i][j] = false;
            }
        }

        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());

            con[f1][f2] = true;
            con[f2][f1] = true;
        }

        boolean[] visit = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++){
            visit[i] = false;
        }

        DFS.push(v);

        while(!DFS.empty()){
            int cur = DFS.pop();
            if (!visit[cur]){
                bw.write(String.valueOf(cur));
                bw.write(" ");
                visit[cur] = true;
                for (int i = n; i > 0; i--){
                    if (con[cur][i] && !visit[i]){
                        DFS.push(i);
                    }
                }
            }

        }

        bw.write("\n");

        for (int i = 0; i < n + 1; i++){
            visit[i] = false;
        }

        visit[v] = false;

        BFS.offer(v);


        while(!BFS.isEmpty()){
            int cur = BFS.poll();
            if (!visit[cur]){
                visit[cur] = true;
                bw.write(String.valueOf(cur));
                bw.write(" ");
                for (int i = 1; i < n + 1; i++){
                    if (con[cur][i] && !visit[i]){
                        BFS.offer(i);
                    }
                }
            }
        }
        bw.flush();
    }
}